package com.functional.pgming.java.app.netflix.constants;

public class DataSetConstants {

    public final static String BASE_FILE_PATH = "dataset/";

    public static enum DataSetFilesEnum{
        NETFLIX_DATASET_SOURCE_FILE("netflix_titles.csv");

        public String value;

        DataSetFilesEnum(String value) {
            this.value = value;
        }
    }

    public static enum NETFLIX_COLS {
        ID,TYPE,TITLE,DIRECTOR,
        CAST,COUNTRY,DATE_ADDED,RELEASE_YEAR,
        RATING,DURATION,LISTED_IN,DESCRIPTION
    }


}
