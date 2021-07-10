package com.functional.pgming.java.app.netflix.service;

import com.functional.pgming.java.app.api.DashboardService;
import com.functional.pgming.java.app.api.DataSourceService;
import com.functional.pgming.java.app.netflix.constants.DataSetConstants;
import com.functional.pgming.java.app.netflix.model.UserAccountModel;
import com.functional.pgming.java.app.netflix.model.DataSetModel;
import com.functional.pgming.java.app.netflix.model.NetflixTitle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.function.*;

public class NetflixDashboardService implements DashboardService {

    private static final Logger logger = LogManager.getLogger(NetflixDashboardService.class);

    private List<DataSetModel> dataSet;

    private final Map<String,Set<String>> dsbMap = new HashMap<>();

    DataSourceService dataSourceService;

    public NetflixDashboardService(DataSourceService dataSourceService) {
        this.dataSourceService =  dataSourceService;
    }

    Function<DataSetModel, NetflixTitle> castToNfxTitle = dsObj -> {
        return (NetflixTitle) dsObj;
    };

    Function<String,Set<String>> retrievedSet = paramName -> dsbMap.get(paramName);

    Consumer<String> paramSet = pName
             -> Objects.requireNonNullElse(dsbMap.putIfAbsent(pName,new HashSet<>()),
            retrievedSet.apply(pName));

    BiFunction<String,String,Set<String>> updateDsb = (paramType,paramValue) -> {
        paramSet.accept(paramType);
        dsbMap.get(paramType).add(paramValue);
        return dsbMap.get(paramType);
    };

    Consumer<NetflixTitle> updateBscDsb = netflixTitle -> {
        updateDsb.apply(DataSetConstants.NETFLIX_COLS.TITLE.name(),netflixTitle.getTitle());
    };

    Consumer<NetflixTitle> updateStdDsb = netflixTitle -> {
        updateBscDsb.accept(netflixTitle);
        updateDsb.apply(DataSetConstants.NETFLIX_COLS.TYPE.name(),netflixTitle.getType());
    };

    Consumer<NetflixTitle> updatePrmDsb = netflixTitle -> {
        updateStdDsb.accept(netflixTitle);
        updateDsb.apply(DataSetConstants.NETFLIX_COLS.DIRECTOR.name(),netflixTitle.getDirector());
        updateDsb.apply(DataSetConstants.NETFLIX_COLS.RELEASE_YEAR.name(),netflixTitle.getReleaseYear());
    };



//    @Override
//    public List<DataSetModel> loadDataSet(String sourceFile) {
//        return FileResourcesUtils.dataSetFromSourceFile(sourceFile,NetflixTitle.class);
//    }
//
//    @Override
//    public Map<String, Set<String>> dashboard(String sourceFile) {
//        dataSet = Objects.requireNonNull(loadDataSet(sourceFile));
//
//        dataSet.stream().map(netFlixTitle).forEach(updatePrmDsb);
//
//
//
//        return null;
//    }

    private Consumer<NetflixTitle> dsbStgy(UserAccountModel userAccountModel){

        return switch (userAccountModel.getMemberShipTypeEnum()){
            case BASIC -> updateBscDsb;
            case STANDARD -> updateStdDsb;
            case PREMIUM -> updatePrmDsb;
            default -> updateBscDsb;
        };
    }

    @Override
    public Map<String, Set<String>> dashboard(final UserAccountModel userAccountModel) {
        dataSet = dataSourceService.loadDataSet();
        Objects.requireNonNull(dataSet);

        dataSet.stream().map(castToNfxTitle).forEach(dsbStgy(userAccountModel));

        return dsbMap;
    }

}
