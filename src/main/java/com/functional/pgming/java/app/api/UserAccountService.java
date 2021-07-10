package com.functional.pgming.java.app.api;

import com.functional.pgming.java.app.netflix.model.UserAccountModel;

public interface UserAccountService extends ApplicationService{
    UserAccountModel account(String email);
}
