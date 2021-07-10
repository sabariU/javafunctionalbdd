package com.functional.pgming.java.app.netflix.model;

import com.functional.pgming.java.app.constants.MemberShipTypeEnum;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserAccountModel extends ApplicationModel{

    private String userName;
    private String email;
    private MemberShipTypeEnum memberShipTypeEnum;
    private String country;
    private List<String> languages;
    private List<String> watchedPast;


}
