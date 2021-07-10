package com.functional.pgming.java.warmup.funcexrcisebdd;

import com.functional.pgming.java.app.constants.EcoSystem;
import com.functional.pgming.java.app.constants.MessageConstants;
import com.functional.pgming.java.app.util.FIUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class BillingEtlEngineFunctional implements EtlEngine {

    private static final Logger logger = LogManager.getLogger(BillingEtlEngineFunctional.class);

    private Map<String, List<List<String>>> srcDataMap;
    private Map<String, List<Customer>> trfmDataMap;

    public BillingEtlEngineFunctional() {
        srcDataMap = new HashMap<>();
        trfmDataMap = new HashMap<>();
    }

    public Function<String, List<List<String>>> rawData =
            srcSystem -> {
                if (!srcDataMap.containsKey(srcSystem))
                    throw new RuntimeException(MessageConstants.RAW_DATA_NOT_FOUND.formatted(srcSystem));
                return srcDataMap.get(srcSystem);
            };

    public Function<String, List<Customer>> trfmData =
            tgtSystem -> {
                if (!trfmDataMap.containsKey(tgtSystem))
                    throw new RuntimeException(MessageConstants.TRANFORMED_DATA_NOT_FOUND.formatted(tgtSystem));
                return trfmDataMap.get(tgtSystem);
            };


    public BiConsumer<EcoSystem, List<List<String>>> persistData =
            (srcSystem, rawData) -> srcDataMap.put(srcSystem.value, rawData);

    public Predicate<String> isRetailSys =
            inputStr -> Objects.equals(EcoSystem.RETAIL_SYS.value, inputStr);

    public Function<List<String>, Customer> toCustomer =
            dataRow -> {
                var i = 0;
                return Customer.builder().id(dataRow.get(i++))
                        .name(dataRow.get(i++))
                        .memberShipPlan(FIUtil.toMembrshipPlan.apply(dataRow.get(i++)))
                        .country(dataRow.get(i++))
                        .dob(dataRow.get(i++)).build();
            };

    public Consumer<EcoSystem> doTransform = tgtSystem -> {

        srcDataMap.keySet().stream()
                //.filter(isRetailSys)
                .map(k -> srcDataMap.get(k))
                .forEach(dataRows -> {
                    var custList = new ArrayList<Customer>();
                    dataRows.stream().forEach(row ->
                            custList.add(toCustomer.apply(row)));
                    trfmDataMap.put(tgtSystem.value, custList);
                });
    };


    Comparator<Customer> sortByIdAsc=
            (c1, c2) -> c1.getId().compareTo(c2.getId());

    Comparator<Customer> sortByIdDesc=
            (c1, c2) -> c2.getId().compareTo(c1.getId());

    public Function<String,List<String>> prepareToLoad = tgtSystem -> {
        return trfmDataMap.get(tgtSystem).stream().sorted(sortByIdAsc).map(customer ->
            MessageConstants.CUSTOMER_INFO.formatted(customer.getId(),
                    customer.getName(), customer.getCountry(),
                    customer.getMemberShipPlan().value,
                    customer.getDob())
        ).collect(Collectors.toList());
    };

    @Override
    public void extract(final String srcSystem, final List<List<String>> rawData) {
        var ecs = FIUtil.toEcoSystem.apply(srcSystem);
        persistData.accept(ecs, rawData);
    }

    @Override
    public void transform(final String tgtSystem) {
        final var ecs = FIUtil.toEcoSystem.apply(tgtSystem);
        doTransform.accept(ecs);
    }

    @Override
    public void load(final String tgtSystem) {

        logger.info("The following customers are getting loaded to " + tgtSystem);
        prepareToLoad.apply(tgtSystem).stream().forEach(logger::info);
    }
}
