package com.MHS.testCases;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//@RunWith(Cucumber.class)

public class SelectMenu  {

    @Given("^User is on menu page$")
    public void user_is_on_menu_page() {
        System.out.println("feature file 2");
    }

    @When("^User click on chevorn and select an (.+) option$")
    public void user_click_on_chevorn_and_select_an_option(String menu)  {
    	 System.out.println("feature file 2 is  open in step is when" + menu);
    }

    @Then("^User should be directed to selected (.+) page$")
    public void user_should_be_directed_to_selected_page(String menu) {
    	
    	 System.out.println("feature file 2 executed succesfully"+menu);
        
    }

}
