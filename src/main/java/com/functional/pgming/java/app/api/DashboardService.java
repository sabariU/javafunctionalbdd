package com.functional.pgming.java.app.api;

import com.functional.pgming.java.app.netflix.model.UserAccountModel;

import java.util.Map;
import java.util.Set;

public interface DashboardService extends ApplicationService{

    Map<String, Set<String>> dashboard(final UserAccountModel userAccountModel);

}
