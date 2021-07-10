package com.functional.pgming.java.exercise.netflix;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","html:target/cucumber"},
        features = {
                "src/test/resources/features/datasetexercise/netflix/netflix_dashboard.feature"
                })
class NetflixPart1TestInit {

}