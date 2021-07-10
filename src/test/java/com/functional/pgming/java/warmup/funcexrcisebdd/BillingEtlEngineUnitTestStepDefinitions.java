package com.functional.pgming.java.warmup.funcexrcisebdd;

import com.functional.pgming.java.app.constants.MemberShipTypeEnum;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import java.util.List;

public class BillingEtlEngineUnitTestStepDefinitions {

    private static final Logger logger = LogManager.getLogger(BillingEtlEngineUnitTestStepDefinitions.class);


    BillingEtlEngineFunctional billingEtlEngineFunctional;
    Customer customerObjForSingleRow;
    List<String> singleRowData;

    List<List<String>> testDateForLoadAndSort;
    List<String> listPreparedForLoad;

    @Before
    public void setup(){
        this.billingEtlEngineFunctional = new BillingEtlEngineFunctional();
    }

    @Given("The following data row to be converted as a customer object")
    public void the_following_data_row_to_be_converted_as_a_customer_object(
            io.cucumber.datatable.DataTable dataTable) {
        singleRowData = dataTable.asLists().get(0);
    }

    @When("I pass the data row")
    public void i_pass_the_data_row() {
        customerObjForSingleRow = billingEtlEngineFunctional.toCustomer.apply(singleRowData);
    }

    @Then("I can get equivalnet customer object")
    public void i_can_get_equivalnet_customer_object() {

        Customer testCustomer = Customer.builder().id("1001")
                .name("Wael Ehsan")
                .memberShipPlan(MemberShipTypeEnum.BASIC)
                .country("Egypt")
                .dob("April 26,1976").build();

        Assert.assertEquals(testCustomer, customerObjForSingleRow);

        Customer testCustomerNegative = Customer.builder().id("1001")
                .memberShipPlan(MemberShipTypeEnum.BASIC)
                .country("Egypt")
                .dob("April 26,1976").build();

        Assert.assertNotEquals(testCustomerNegative, customerObjForSingleRow);
    }

    @Given("The following data from {string} row to be loaded and sorted by id")
    public void the_following_data_from_row_to_be_loaded_and_sorted_by_id(String srcSystem,
            io.cucumber.datatable.DataTable dataTable) {
        testDateForLoadAndSort = dataTable.asLists();
        billingEtlEngineFunctional.extract(srcSystem,testDateForLoadAndSort);

    }

    @When("I load the data for {string}")
    public void i_load_the_data_for(String tgtSystem) {
        billingEtlEngineFunctional.transform(tgtSystem);
        billingEtlEngineFunctional.trfmData.apply(tgtSystem);
        listPreparedForLoad = billingEtlEngineFunctional.prepareToLoad.apply(tgtSystem);



    }


    @Then("I can see expected data loading and sorting")
    public void i_can_see_expected_data_loading_and_sorting() {

        var expectedFirstElement = """
                {    
                    Id          : 103
                    Name        : test user3
                    Country     : Egypt
                    Membership  : Basic
                    Dob         : April 26,1976
                }
                """;
        var actual = listPreparedForLoad.stream().findFirst().get();
        logger.info("Expeected " + expectedFirstElement);
        logger.info("Actual " + actual);
        Assert.assertEquals(expectedFirstElement,actual);
    }
}
