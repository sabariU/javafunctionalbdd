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

public class BillingEtlEngineAcceptanceTestStepDefinitions {

    private static final Logger logger = LogManager.getLogger(BillingEtlEngineAcceptanceTestStepDefinitions.class);

    BillingEtlEngineFunctional billingEtlEngineFunctional;
    List<List<String>> rawData;
    String srcSystem;

    @Before
    public void setup(){
        this.billingEtlEngineFunctional = new BillingEtlEngineFunctional();
    }

    @Given("The following customers from {string}")
    public void the_following_customers_from(String srcSystem,
                                             io.cucumber.datatable.DataTable dataTable) {

        this.rawData = dataTable.asLists();
        this.srcSystem = srcSystem;

    }

    @When("I pass the customers as raw data")
    public void i_pass_the_customers_as_raw_data() {
        billingEtlEngineFunctional.extract(srcSystem,rawData);
    }

    @Then("I can see the data persisted in the system")
    public void i_can_see_the_data_persisted_in_the_system() {
        Assert.assertArrayEquals(rawData.toArray(), billingEtlEngineFunctional.rawData.apply(srcSystem).toArray());
    }

    @Then("I can see the data transformed to customer object compatible to {string}")
    public void i_can_see_the_data_transformed_to_customer_object_compatible_to(String tgtSystem) {
        billingEtlEngineFunctional.transform(tgtSystem);
        List<Customer> customers = billingEtlEngineFunctional.trfmData.apply(tgtSystem);

        //customers.stream().forEach(System.out::println);

        Assert.assertEquals(8,customers.size());

        Customer testCustomer = Customer.builder().id("3942")
                .name("Juan Camilo Pinzon")
                .memberShipPlan(MemberShipTypeEnum.BASIC)
                .country("Colombia")
                .dob("March 1,2009").build();

        Assert.assertTrue(customers.contains(testCustomer));
    }

    @Then("I can load the customer objects to {string} \\(just print) sort by id in descending order")
    public void i_can_load_the_customer_objects_to_just_print_sort_by_id_in_descending_order(String tgtSystem) {
        billingEtlEngineFunctional.load(tgtSystem);
    }


}