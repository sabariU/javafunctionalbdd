package com.functional.pgming.java.app.constants;

public enum EcoSystem {

    BILLING_SYS("Billing system"), OTHERS("Others"),
    RETAIL_SYS("Retail system"), ONLINE_SYS("Online system");

    public String value;

    EcoSystem(String value) {
        this.value = value;
    }
}
