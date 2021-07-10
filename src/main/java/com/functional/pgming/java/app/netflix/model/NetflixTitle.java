package com.functional.pgming.java.app.netflix.model;

import com.opencsv.bean.CsvBindByName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NetflixTitle extends DataSetModel{

    @CsvBindByName(column = "show_id")
    private String id;

    @CsvBindByName(column = "type")
    private String type;

    @CsvBindByName(column = "title")
    private String title;

    @CsvBindByName(column = "director")
    private String director;

    @CsvBindByName(column = "cast")
    private String cast;

    @CsvBindByName(column = "country")
    private String country;

    @CsvBindByName(column = "date_added")
    private String dateAdded;

    @CsvBindByName(column = "release_year")
    private String releaseYear;

    @CsvBindByName(column = "rating")
    private String rating;

    @CsvBindByName(column = "duration")
    private String duration;

    @CsvBindByName(column = "listed_in")
    private String listedIn;

    @CsvBindByName(column = "description")
    private String description;
}
