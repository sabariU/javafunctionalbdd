package com.functional.pgming.java.app.netflix.constants;

public enum BrowsePageSectionEnum {

    ALL("All"),COUNTRY("Country"), NEW("New"), REGIONLANG("Favorite Language"),
    DOCUMENTARY("Documentaries"), KIDS("Kids"),THRILLER("Thriller"),
    AWARD_WINNING("Award Winning"),RECOM("Recommendations"),OTHERS("Others");

    public String value;

    BrowsePageSectionEnum(String value) {
        this.value = value;
    }
}
