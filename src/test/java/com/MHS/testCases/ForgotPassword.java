package com.MHS.testCases;

import static org.junit.Assert.*;



import com.MHS.PageObjects.DashboardPage;
import com.MHS.PageObjects.ForgotPasswordPage;
import com.MHS.PageObjects.LoginPage;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgotPassword {
	
	Base base;
	AndroidDriver<AndroidElement> driver;
	Scenario scenario;
	
	public  ForgotPassword(Base base)
	{
		this.base=base;
		driver=base.getDriver();
		scenario=base.scenario; 
	}
	
	

   

    @When("^user enter the (.+) on Forgot password page and click submit button.$")
    public void user_enter_the_on_forgot_password_page_and_click_submit_button(String email)  {
    	ForgotPasswordPage forPasspg= new ForgotPasswordPage(base);
    	forPasspg.enterEmailonFPpage(email);
    	forPasspg.clickSubmit();
        
    }

    @Then("^an alert stating password changed should be displayed with message as (.+)$")
    public void a_alert_stating_password_changed_should_be_displayed(String message){
    	ForgotPasswordPage forPasspg= new ForgotPasswordPage(base);
    	String msg =forPasspg.acceptChangedPasswordAlert();
    	scenario.log("Alert with message ' "+msg+" ' is shown");
    	assertEquals("comapring alert message", message, msg);
    	TouchAction tc = new TouchAction(driver);
    	tc.tap(PointOption.point(736,315)).perform();
//    	DashboardPage dpg = new DashboardPage(base);
//    	LoginPage lpg = new LoginPage(base);
//    	lpg.headerDisplayed();
//    	System.out.println("after email" + email);
//    	lpg.enterEmailId(email);
//    	
//    	lpg.enterPassword(newpassword);
//    	System.out.println("after password" + newpassword);
//    	lpg.clickLogin();
//    	System.out.println("after login btn");
////    	String msg =dpg.verifyDashboardScreen();
////    	scenario.log("' "+msg+" ' is shown on dashbaord page");
//    	
//    	dpg.clickOnMenu();
//    	dpg.clickLogout();
    	
    	
        
    }

    @And("^user clicks on  Forgot password link.$")
    public void user_clicks_on_forgot_password_link()  {
    	
    	
    	LoginPage lpg = new LoginPage(base);
    	lpg.clickForgotPassword();
    
       
    }

    @And("^user provide the otp (.+) , new password (.+) and confirm password (.+) on password reset page and click on Submit button$")
    public void user_provide_the_and_on_password_reset_page_and_click_on_submit_button(String otp, String newpassword, String confirmpassword) {
    	ForgotPasswordPage forPasspg= new ForgotPasswordPage(base);
    	forPasspg.acceptOTPAlert();
    	forPasspg.setToken(otp);
    	forPasspg.setPassword(newpassword);
    	forPasspg.setConfirmPassword(confirmpassword);
    	forPasspg.clickSubmit();
        
    }

    @And("^User should be able to Login with email (.+) and changed password (.+) succesfully.$")
    public void user_should_be_able_to_login_with_changed_password_succesfully(String email, String newpassword) {
    	
   	//LoginPage lpg = new LoginPage(base);
    	DashboardPage dpg = new DashboardPage(base);
    	LoginPage lpg = new LoginPage(base);
    	lpg.headerDisplayed();
    	System.out.println("after email" + email);
    	lpg.enterEmailId(email);
    	
    	lpg.enterPassword(newpassword);
    	System.out.println("after password" + newpassword);
    	lpg.clickLogin();
    	System.out.println("after login btn");
//    	String msg =dpg.verifyDashboardScreen();
//    	scenario.log("' "+msg+" ' is shown on dashbaord page");
    	
  	dpg.clickOnMenu();
    	dpg.clickLogout();
    	
    	
    	
        
    }

}
