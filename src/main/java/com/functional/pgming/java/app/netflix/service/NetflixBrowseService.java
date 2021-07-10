package com.functional.pgming.java.app.netflix.service;

import com.functional.pgming.java.app.api.BrowseService;
import com.functional.pgming.java.app.api.DataSourceService;
import com.functional.pgming.java.app.netflix.constants.BrowsePageSectionEnum;
import com.functional.pgming.java.app.netflix.model.*;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class NetflixBrowseService implements BrowseService {

    private DataSourceService dataSourceService;
    private List<DataSetModel> dataSet;

    public NetflixBrowseService(final DataSourceService dataSourceService) {
        this.dataSourceService =  dataSourceService;
    }

    private Map<String,Set<DataSetModel>> titlesMap = new HashMap<>();

    Function<DataSetModel, NetflixTitle> castToNfxTitle = dsObj -> {
        return (NetflixTitle) dsObj;
    };

    Supplier<List<BrowsePageSectionEnum>> bscCatLogSects =
            () -> Arrays.asList(BrowsePageSectionEnum.ALL);

    Supplier<List<BrowsePageSectionEnum>> stdCatLogSects =
            () -> Arrays.asList(BrowsePageSectionEnum.COUNTRY,
                    BrowsePageSectionEnum.REGIONLANG,BrowsePageSectionEnum.DOCUMENTARY,
                    BrowsePageSectionEnum.THRILLER,
                    BrowsePageSectionEnum.OTHERS);

    Supplier<List<BrowsePageSectionEnum>> prmCatLogSects =
            () -> Arrays.asList(BrowsePageSectionEnum.COUNTRY,
                    BrowsePageSectionEnum.REGIONLANG,BrowsePageSectionEnum.DOCUMENTARY,
                    BrowsePageSectionEnum.THRILLER,BrowsePageSectionEnum.RECOM,
                    BrowsePageSectionEnum.OTHERS);


    Function<NetflixTitle,String> keyMapper = k -> BrowsePageSectionEnum.ALL.value ;

    Function<NetflixTitle,Set<NetflixTitle>> valueMapper = k -> new HashSet<>(Arrays.asList(k)) ;
    BinaryOperator<Set<NetflixTitle>> setMerger = (s1,s2) -> {s1.addAll(s2);return s1;} ;


    Supplier<Map<String,Set<NetflixTitle>>> stdCatLog = () -> {
        return dataSet.stream().map(castToNfxTitle)
                .collect( Collectors.toMap(keyMapper,valueMapper,setMerger,
                        HashMap::new));
    };


    Supplier<Map<String,Set<NetflixTitle>>> bscCatLog = () -> {
        return dataSet.stream().map(castToNfxTitle)
                .collect( Collectors.toMap(keyMapper,valueMapper,setMerger,
                        HashMap::new));
    };

    Supplier<Map<String,Set<NetflixTitle>>> prmCatLog = () -> {
        return dataSet.stream().map(castToNfxTitle)
                .collect( Collectors.toMap(keyMapper,valueMapper,setMerger,
                        HashMap::new));
    };


    @Override
    public Map<String, Set<NetflixTitle>> browsePage(final UserAccountModel userAccountModel) {

        dataSet = dataSourceService.loadDataSet();
        Objects.requireNonNull(dataSet);

        return bscCatLog.get();
    }

    @Override
    public Map<String, Set<NetflixTitle>> filter(final UserAccountModel userAccountModel,
                                                 final BrowsePageSectionEnum section,
                                                 final FilterModel[] filter,
                                                 final SortModel[] sort) {
        dataSet = dataSourceService.loadDataSet();
        Objects.requireNonNull(dataSet);

        return null;
    }
}
