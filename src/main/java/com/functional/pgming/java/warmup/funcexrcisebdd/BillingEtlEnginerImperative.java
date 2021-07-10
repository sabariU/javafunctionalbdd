package com.functional.pgming.java.warmup.funcexrcisebdd;

import com.functional.pgming.java.app.constants.EcoSystem;
import com.functional.pgming.java.app.constants.MessageConstants;
import com.functional.pgming.java.app.util.FIUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class BillingEtlEnginerImperative implements EtlEngine {

    private static final Logger logger = LogManager.getLogger(BillingEtlEngineFunctional.class);

    private Map<String, List<List<String>>> srcDataMap;
    private Map<String, List<Customer>> trfmDataMap;

    public BillingEtlEnginerImperative() {
        srcDataMap = new HashMap<>();
        trfmDataMap = new HashMap<>();
    }


    public List<List<String>> getRawData(String srcSystem) {
        if (!srcDataMap.containsKey(srcSystem))
            throw new RuntimeException(MessageConstants.RAW_DATA_NOT_FOUND.formatted(srcSystem));
        return srcDataMap.get(srcSystem);
    }

    public List<Customer> getTransformedData(String tgtSystem) {

        if (!trfmDataMap.containsKey(tgtSystem))
            throw new RuntimeException(MessageConstants.TRANFORMED_DATA_NOT_FOUND.formatted(tgtSystem));
        return trfmDataMap.get(tgtSystem);
    }


    EcoSystem getEcoSystem(String inputStr) {
        for (EcoSystem s : EcoSystem.values()) {
            if (Objects.equals(s.value, inputStr))
                return s;
        }
        throw new RuntimeException("Invalid source system : " + inputStr);
    }

    public Customer toCustomer(List<String> dataRow) {
        var i = 0;
        return Customer.builder().id(dataRow.get(i++))
                .name(dataRow.get(i++))
                .memberShipPlan(FIUtil.toMembrshipPlan.apply(dataRow.get(i++)))
                .country(dataRow.get(i++))
                .dob(dataRow.get(i++)).build();
    }

    public void doTransform(EcoSystem tgtSystem) {

        List<List<String>> rows = srcDataMap.get(EcoSystem.RETAIL_SYS.value);
        var custList = new ArrayList<Customer>();
        for(List<String> row : rows){
            custList.add(toCustomer(row));
        }
        trfmDataMap.put(tgtSystem.value, custList);
    }

    @Override
    public void extract(final String srcSystem, final List<List<String>> rawData) {
        var ecs = getEcoSystem(srcSystem);
        srcDataMap.put(ecs.value, rawData);
    }

    @Override
    public void transform(final String tgtSystem) {
        final var ecs = FIUtil.toEcoSystem.apply(tgtSystem);
        doTransform(ecs);
    }

    @Override
    public void load(String tgtSystem) {

        logger.info("The following customers are getting loaded to " + tgtSystem);
        for(Customer customer : trfmDataMap.get(tgtSystem)){
            logger.info(MessageConstants.CUSTOMER_INFO.formatted(customer.getId(),
                    customer.getName(), customer.getCountry(),
                    customer.getMemberShipPlan().value,
                    customer.getDob()));
        }

    }
}
