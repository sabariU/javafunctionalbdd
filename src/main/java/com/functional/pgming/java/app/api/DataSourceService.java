package com.functional.pgming.java.app.api;

import com.functional.pgming.java.app.netflix.model.DataSetModel;

import java.util.List;

public interface DataSourceService extends ApplicationService{
    List<DataSetModel> loadDataSet();
}
