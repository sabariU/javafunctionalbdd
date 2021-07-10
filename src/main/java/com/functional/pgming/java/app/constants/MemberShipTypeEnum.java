package com.functional.pgming.java.app.constants;

public enum MemberShipTypeEnum {
    BASIC("Basic"),STANDARD("Standard"),PREMIUM("Premium");

    public String value;

    MemberShipTypeEnum(String value) {
        this.value = value;
    }
}
