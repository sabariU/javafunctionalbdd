package com.functional.pgming.java.app.util;

import com.functional.pgming.java.app.netflix.model.DataSetModel;

import java.util.ArrayList;
import java.util.List;

public class CsvTransfer {

    private List<String[]> csvStringList;

    private List<DataSetModel> csvList;

    public CsvTransfer() {}

    public List<String[]> getCsvStringList() {
        if (csvStringList != null) return csvStringList;
        return new ArrayList<String[]>();
    }

    public void addLine(String[] line) {
        if (this.csvList == null) this.csvStringList = new ArrayList<>();
        this.csvStringList.add(line);
    }

    public void setCsvStringList(List<String[]> csvStringList) {
        this.csvStringList = csvStringList;
    }

    public void setCsvList(List<DataSetModel> csvList) {
        this.csvList = csvList;
    }

    public List<DataSetModel> getCsvList() {
        if (csvList != null) return csvList;
        return new ArrayList<DataSetModel>();
    }
}
