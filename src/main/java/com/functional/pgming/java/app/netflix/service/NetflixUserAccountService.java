package com.functional.pgming.java.app.netflix.service;

import com.functional.pgming.java.app.api.UserAccountService;
import com.functional.pgming.java.app.constants.MemberShipTypeEnum;
import com.functional.pgming.java.app.netflix.model.UserAccountModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class NetflixUserAccountService implements UserAccountService {

    private static final Logger logger = LogManager.getLogger(NetflixUserAccountService.class);

    private Map<String, UserAccountModel> useAccounts;

    public NetflixUserAccountService() {
        this.useAccounts = new HashMap<>();

        this.useAccounts.put("basic-user@gmail.com",
                 UserAccountModel.builder().userName("Basic User")
                    .email("basic-user@gmail.com")
                    .memberShipTypeEnum(MemberShipTypeEnum.BASIC)
                    .country("USA").build());

        this.useAccounts.put("standard-user@gmail.com",
                UserAccountModel.builder().userName("Standard User")
                        .email("standard-user@gmail.com")
                        .memberShipTypeEnum(MemberShipTypeEnum.STANDARD)
                        .country("India")
                        .build());

        this.useAccounts.put("premium-user@gmail.com",
                UserAccountModel.builder().userName("Premium User")
                        .email("premium-user@gmail.com")
                        .memberShipTypeEnum(MemberShipTypeEnum.BASIC)
                        .country("India").build());

    }

    @Override
    public UserAccountModel account(String email) {
        var acc = useAccounts.get(email);
        logger.debug(email + " - " +acc.getMemberShipTypeEnum());
        return useAccounts.get(email);
    }
}
