package com.functional.pgming.java.app.netflix.service;

import com.functional.pgming.java.app.netflix.model.DataSetModel;
import com.functional.pgming.java.app.netflix.model.NetflixTitle;
import com.functional.pgming.java.app.util.CsvHelper;
import com.functional.pgming.java.app.util.FileResourcesUtils;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

import static com.functional.pgming.java.app.netflix.constants.DataSetConstants.BASE_FILE_PATH;
import static com.functional.pgming.java.app.netflix.constants.DataSetConstants.DataSetFilesEnum;

public class ShowCount {

    public static void main(String[] args) {
        try{
            new ShowCount().count1();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void count1() throws Exception{


        File file = FileResourcesUtils.getFileFromResource(BASE_FILE_PATH +
                DataSetFilesEnum.NETFLIX_DATASET_SOURCE_FILE.value+".csv");

        List<DataSetModel> netflixTitleList =
                CsvHelper.beanBuilder(Paths.get(file.getPath()), NetflixTitle.class);

        System.out.println(netflixTitleList.size());

    }
}
