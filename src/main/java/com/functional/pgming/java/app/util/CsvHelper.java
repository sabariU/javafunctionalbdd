package com.functional.pgming.java.app.util;

import com.functional.pgming.java.app.netflix.model.DataSetModel;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.MappingStrategy;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvHelper {


    public static List<DataSetModel> beanBuilder(Path path, Class clazz) {
        HeaderColumnNameMappingStrategy ms = new HeaderColumnNameMappingStrategy();
        return beanBuilder(path, clazz, ms);
    }

    public static List<DataSetModel> beanBuilder(Path path, Class clazz, MappingStrategy ms) {
        CsvTransfer csvTransfer = new CsvTransfer();
        try {
            ms.setType(clazz);

            Reader reader = Files.newBufferedReader(path);
            CsvToBean cb = new CsvToBeanBuilder<>(reader).withType(clazz)
                    .withMappingStrategy(ms)
                    .build();

            csvTransfer.setCsvList(cb.parse());
            reader.close();

        } catch (Exception ex) {
            Helpers.err(ex);
        }
        return csvTransfer.getCsvList();
    }
}
