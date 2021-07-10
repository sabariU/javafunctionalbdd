package com.functional.pgming.java.exercise.netflix;

import com.functional.pgming.java.app.api.BrowseService;
import com.functional.pgming.java.app.api.DataSourceService;
import com.functional.pgming.java.app.api.UserAccountService;
import com.functional.pgming.java.app.netflix.model.DataSetModel;
import com.functional.pgming.java.app.netflix.model.NetflixTitle;
import com.functional.pgming.java.app.netflix.service.NetflixBrowseService;
import com.functional.pgming.java.app.netflix.service.NetflixDataSourceService;
import com.functional.pgming.java.app.netflix.service.NetflixUserAccountService;
import com.functional.pgming.java.app.util.DataTableTransformer;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.Set;

public class NetflixBrowsePageStepDefinitions {

    BrowseService browseService;
    UserAccountService userAccountService;
    String email;

    private static final Logger logger = LogManager.getLogger(NetflixBrowsePageStepDefinitions.class);

    @Before
    public void setup() {
        userAccountService = new NetflixUserAccountService();
    }


    @Given("The following titles exist in the system")
    public void the_following_titles_exist_in_the_system(DataTable dataTable) {

        var rows = DataTableTransformer.toNetflixTitles(dataTable);
        var debugMsg = """
                    Given test data 
                    contains %d
                """.formatted(rows.size());

        DataSourceService dataSourceService = new
                NetflixDataSourceService(rows);
        browseService = new NetflixBrowseService(dataSourceService);
        logger.debug(debugMsg);

    }

    @When("I login to netflix with {string}")
    public void i_login_to_netflix_with(String email) {
        Map<String, Set<NetflixTitle>> browseMap =
                browseService.browsePage(userAccountService.account(email));
        logger.info("");
    }

    @Then("I see list of titles to browse")
    public void i_see_list_of_titles_to_browse() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    @Then("I sort the titles by year on the section A")
    public void i_sort_the_titles_by_year_on_the_section_a() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    @Then("I filter the titles by director on the section A")
    public void i_filter_the_titles_by_director_on_the_section_a() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }



}
