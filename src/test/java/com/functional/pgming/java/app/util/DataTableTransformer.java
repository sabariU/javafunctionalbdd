package com.functional.pgming.java.app.util;

import com.functional.pgming.java.app.netflix.model.DataSetModel;
import com.functional.pgming.java.app.netflix.model.NetflixTitle;
import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DataTableTransformer {

    static Function<List<String>,NetflixTitle> nfxTitleConverter =
            arr -> {
        var i = 0;
        return NetflixTitle.builder().id(arr.get(i++)).
                type(arr.get(i++)).title(arr.get(i++)).director(arr.get(i++)).
                cast(arr.get(i++)).country(arr.get(i++)).dateAdded(arr.get(i++)).
                releaseYear(arr.get(i++)).rating(arr.get(i++)).
                duration(arr.get(i++)).listedIn(arr.get(i++)).description(arr.get(i++)).build();

    };

    public static List<DataSetModel> toNetflixTitles(DataTable dataTable){
        return dataTable.asLists().stream().map(nfxTitleConverter).collect(Collectors.toList());
    }
}
