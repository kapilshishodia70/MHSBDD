package com.MHS.testCases;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.FileReaderManager;
import testDatatype.Login;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;

import com.MHS.PageObjects.DashboardPage;
import com.MHS.PageObjects.LoginPage;


public class LoginMHS {
	
	Base base;
	AndroidDriver<AndroidElement> driver;
	ReusableActions action;
	Scenario scenario;
	public static String email;
	public static String password;
	
	public LoginMHS(Base base)
	{
		this.base= base;
		this.action= new ReusableActions(this.base);
		scenario= base.scenario;
		this.driver=base.getDriver();
		
		
	}
	
	@Given("^User is present on the login page$")
    public void user_is_present_on_the_login_page() {
		LoginPage lpg = new LoginPage(base);
		boolean flag= lpg.headerDisplayed();
		
		assertTrue(flag);
		
		
        
    }

    @When("^User provide the credentials$")
    public void user_provide_the_credentials(DataTable data) throws InterruptedException {
    	LoginPage lpg = new LoginPage(base);
    	List<List<String>> listData = data.asLists(String.class);
    	 email = listData.get(1).get(0);
    	 
    	Login login = FileReaderManager.getInstance().getJsonReader().getLoginByEmail(email);
    	try {
    	 password = login.Password;
    	}
    	catch(NullPointerException np)
    	{
    		password="-";
    	}
    	System.out.println("email is "+email +" and password is "+password);
    	if(email==null ||email.equalsIgnoreCase(" ")|| email.equalsIgnoreCase("-")) 
    	{
    		if(password==null || password.equalsIgnoreCase(" ") || password.equalsIgnoreCase("-"))
    			lpg.clickLogin();
    		else
    		{
    			lpg.enterPassword(password);
    			String shownPassword= driver.findElement(By.xpath("//android.widget.EditText[@text='"+password+"']")).getText();
    			scenario.log("clicking on show password icon displays password as : "+shownPassword);
    			lpg.clickLogin();
    			
    		}
    	}
    	else {
    	lpg.enterEmailId(email);
    	lpg.enterPassword(password);
    	lpg.showPassword(password);
    	String shownPassword= driver.findElement(By.xpath("//android.widget.EditText[@text='"+password+"']")).getText();
        
    	scenario.log("clicking on show password icon displays password as : "+shownPassword);
    	lpg.clickLogin();
    	}
        
    }

    @Then("^User is logged in the App succesfully And land on App dashboard$")
    public void user_is_logged_in_the_app_succesfully_and_land_on_app_dashboard() throws InterruptedException{
    	
    	Thread.sleep(2000);
    	
    	DashboardPage dbpg = new DashboardPage(base);
    	scenario.log("user lands on home page and '"+dbpg.verifyDashboardScreen()+ "' message is displayed."); 
    //	"+dbpg.verifyDashboardScreen()+
    	
    	dbpg.clickOnMenu();
    	dbpg.clickLogout();
    	scenario.log("User logged out successfully.");
    	
    	
        
    }
    @But("^User see field validation error on Email and password fields$")
    public void user_see_field_validation_error_on_email_and_password_fields()
    {
    	LoginPage lpg = new LoginPage(base);
    	if(!email.toUpperCase().matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$"))
    	{
    		scenario.log("'"+lpg.emailFieldvalidation()+"' message is found below email field");
    	}
    	
    	
    	if(!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$"))
    	{
    	System.out.println("wrong pattern of password ");
    	scenario.log("'"+lpg.passwordFieldvalidation()+"'  message is found below password field");
    	}
    	else if(password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$"))
    	{
    		
    		scenario.log("'"+(String)lpg.wrongPassvalidaionMsg().get(1)+"'  message is found below password field");
    		//System.out.println("wrong credentials");
    		assertTrue((boolean)lpg.wrongPassvalidaionMsg().get(0));
    		
    	}
    	
    	
    }

	
	

}
