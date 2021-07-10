package com.functional.pgming.java.warmup.funcexrcisebdd;

import com.functional.pgming.java.app.constants.MemberShipTypeEnum;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class Customer {

    private String id;
    private String name;
    private MemberShipTypeEnum memberShipPlan;
    private String country;
    private String dob;

}
