package com.functional.pgming.java.app.netflix.model;

import com.functional.pgming.java.app.netflix.constants.DataSetConstants;
import lombok.Data;


@Data
public class FilterModel extends ApplicationModel{

    private DataSetConstants.NETFLIX_COLS field;
    private String value;
}
