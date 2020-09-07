package com.MHS.testCases;

import com.MHS.PageObjects.GeneralStoreHomePage;
import com.MHS.PageObjects.ProductsPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

import java.util.List;
public class GeneralStoreHome {
	
	Base base;
	AndroidDriver<AndroidElement> driver;
	Actions action;
	Scenario scenario;
	
	public GeneralStoreHome(Base base)
	{
		this.base= base;
		this.action=new Actions(this.base);
		scenario=base.scenario;
	}
	
	
	 @Given("^User is on general store home page$")
	    public void user_is_on_general_store_home_page() {
		 
		 GeneralStoreHomePage GShomePg= new GeneralStoreHomePage(base);
		 boolean flag= GShomePg.titleDispalyed();
		 assertTrue(flag);
		 
	        
	    }

	    @When("^user provide sign up information$")
	    public void user_provide_sign_up_information(DataTable data ) throws InterruptedException  {
	    	GeneralStoreHomePage GShomePg= new GeneralStoreHomePage(base);
	    	List<List<String>> li = data.asLists();
	    	System.out.println(li.get(1).get(1));
	    	Thread.sleep(2000);
	    	GShomePg.enterYourname();
	    	Thread.sleep(2000);
	    	GShomePg.selectGender();
	    	
	        
	    }

	    @And("^user click on Lets shop button$")
	    public void user_click_on_lets_shop_button() throws InterruptedException{
	    	GeneralStoreHomePage GShomePg= new GeneralStoreHomePage(base);
	    	Thread.sleep(2000);
	    	GShomePg.letsShop();
	        
	    }
	    @Then("^User is navigated to products page$")
	    public void user_is_navigated_to_products_page() throws InterruptedException{
	    	ProductsPage GSProductPg= new ProductsPage(base);
	    	System.out.println(GSProductPg.getPageTitle());
	    	scenario.log("User is on "+GSProductPg.getPageTitle()+ " page");
	    	Thread.sleep(2000);
	    	GSProductPg.clickOnAddTocart();
	    	Thread.sleep(2000);
	    	GSProductPg.clickOnCart();
	    	
	    	
	    	
	    	
	        
	    }

}
