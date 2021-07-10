package com.functional.pgming.java.warmup.funcexrcisebdd;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","html:target/cucumber.html"},
        features = {
                "src/test/resources/features/warmup/fninterfcexrcise/billing_etl_acceptance_test.feature",
                "src/test/resources/features/warmup/fninterfcexrcise/billing_etl_unit_test.feature"
        })
public class WarmupTestInit {
}
