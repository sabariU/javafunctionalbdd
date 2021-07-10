package com.functional.pgming.java.app.api;

import com.functional.pgming.java.app.netflix.constants.BrowsePageSectionEnum;
import com.functional.pgming.java.app.netflix.model.*;

import java.util.Map;
import java.util.Set;

public interface BrowseService extends ApplicationService{

    Map<String, Set<NetflixTitle>> browsePage(UserAccountModel userAccountModel);

    Map<String, Set<NetflixTitle>>  filter(UserAccountModel userAccountModel,
                                          BrowsePageSectionEnum section,
                                              FilterModel[] filter,
                                              SortModel[] sort);
}
