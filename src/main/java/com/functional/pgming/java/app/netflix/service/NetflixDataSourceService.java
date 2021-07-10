package com.functional.pgming.java.app.netflix.service;

import com.functional.pgming.java.app.api.DataSourceService;
import com.functional.pgming.java.app.netflix.model.DataSetModel;
import com.functional.pgming.java.app.netflix.model.NetflixTitle;
import com.functional.pgming.java.app.util.FileResourcesUtils;

import java.util.List;
import java.util.Objects;

public class NetflixDataSourceService implements DataSourceService {

    private String dataSourceConnection;

    private List<DataSetModel> dataSet ;

    public NetflixDataSourceService(String sourceFile) {
        this.dataSourceConnection = sourceFile;
    }

    public NetflixDataSourceService(List<DataSetModel> dataSet) {
        this.dataSet = dataSet;
    }


    @Override
    public List<DataSetModel> loadDataSet() {
        return  Objects.nonNull(dataSet)? dataSet :
                FileResourcesUtils.
                dataSetFromSourceFile(this.dataSourceConnection, NetflixTitle.class);
    }
}
