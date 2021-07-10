package com.functional.pgming.java.exercise.netflix;

import com.functional.pgming.java.app.api.UserAccountService;
import com.functional.pgming.java.app.api.DashboardService;
import com.functional.pgming.java.app.api.DataSourceService;
import com.functional.pgming.java.app.netflix.constants.DataSetConstants;
import com.functional.pgming.java.app.netflix.service.NetflixDashboardService;
import com.functional.pgming.java.app.netflix.service.NetflixDataSourceService;
import com.functional.pgming.java.app.netflix.service.NetflixUserAccountService;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.*;

public class NetflixDashboardStepDefinitions {

    DashboardService dashboardService;
    UserAccountService userAccountService;
    String email;
    Map<String, Set<String>> dsbMap;

    private static final Logger logger = LogManager.getLogger(NetflixDashboardStepDefinitions.class);


    @Before
    public void setup(){
        DataSourceService dataSourceService = new
                NetflixDataSourceService(DataSetConstants.DataSetFilesEnum.NETFLIX_DATASET_SOURCE_FILE.value);
        dashboardService = new NetflixDashboardService(dataSourceService);
        userAccountService = new NetflixUserAccountService();
    }

    @Given("I have logged in to netflix as a {string}")
    public void i_have_logged_in_to_netflix_as_a(String email) {
        this.email = email;
    }

    @When("I go to the dashboard")
    public void i_go_to_the_dashboard() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    @When("I see my dashboard statistics")
    public void i_see_my_dashboard_statistics() {

        dsbMap = dashboardService.
                dashboard(userAccountService.account(this.email));

        logger.info("Dashboard for "+this.email);
        dsbMap.keySet().stream().forEach(paramType ->{
            System.out.println(paramType + " - "+ dsbMap.get(paramType).size());
        });
    }

    @Then("I view the list of values")
    public void i_view_the_list_of_values() {
        dsbMap.keySet().stream().forEach(paramType ->{
            logger.info(paramType + " - "+ dsbMap.get(paramType));
        });
    }

    @Test
    public void t1(){


    }

}
