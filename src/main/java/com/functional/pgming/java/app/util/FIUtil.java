package com.functional.pgming.java.app.util;

import com.functional.pgming.java.app.constants.EcoSystem;
import com.functional.pgming.java.app.constants.MemberShipTypeEnum;

import java.util.Objects;
import java.util.function.Function;

public interface FIUtil {

    Function<String, EcoSystem> toEcoSystem = inputStr -> {
        for (EcoSystem s : EcoSystem.values()){
            if(Objects.equals(s.value, inputStr))
                return s;
        }
        throw new RuntimeException("Invalid source system : "+inputStr);
    };

    Function<String, MemberShipTypeEnum> toMembrshipPlan = inputStr -> {
        for (MemberShipTypeEnum s : MemberShipTypeEnum.values()){
            if(Objects.equals(s.value, inputStr))
                return s;
        }
        throw new RuntimeException("Invalid membership plan : "+inputStr);
    };
}
