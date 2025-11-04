package com.fdmgroup.stepdefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@SuppressWarnings("deprecation")
@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "src/test/resources/features",
	    glue = "com.fdmgroup.stepdefinitions",
	    plugin = {
	    		"pretty", 
	    		"json:Report/cucumber.json",
	    		"junit:Report/cucumber.junit",
	    		"html:Report/cucumber.html"
	    		},
	    monochrome = false,
	    dryRun = false,
	    publish = true
	)
public class CucumberRunner {

} 