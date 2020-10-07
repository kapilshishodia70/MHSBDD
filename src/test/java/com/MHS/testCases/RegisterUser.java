package com.MHS.testCases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.MHS.PageObjects.DashboardPage;
import com.MHS.PageObjects.LoginPage;
import com.MHS.PageObjects.RegisterPage;
import com.MHS.PageObjects.TokenValidationPage;



import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterUser {
	
	Base base;
	AndroidDriver<AndroidElement> driver;
	Scenario scenario;
	
	public RegisterUser(Base base)
	{
		this.base=base;
		driver=base.getDriver();
		scenario=base.scenario; 
	}
	
	
//	@Given("^User is present on the login page$")
//    public void user_is_present_on_the_login_page() {
//		LoginPage lpg = new LoginPage(base);
//		boolean flag= lpg.headerDisplayed();
//		
//		assertTrue(flag);    
//    }

    @Given("^user choose to sign up as a (.+)$")
    public void user_choose_to_sign_up_as_a(String usertype) {
    	RegisterPage rpg = new RegisterPage(base);
    	if (usertype.equalsIgnoreCase("Patients")) {
    	rpg.clickPatients();
    	}
    	else
    	{
    		rpg.clickSpecialist();
    	}
        
    }

    @When("^user click on Signup link$")
    public void user_click_on_signup_link()  {
    	
    	LoginPage lpg = new LoginPage(base);
    	lpg.clickRegister();
        
    }

    @When("^user fill the required form details i.e. (.+), (.+) , (.+) , (.+) and click on register button.$")
    public void user_fill_the_required_form_details_click_on_register_button(String fullname, String email, String password, String confirmpassword ) {
    	RegisterPage rpg = new RegisterPage(base);
    	rpg.registerHeadDisplayed();
    	rpg.enterFullName(fullname);
		rpg.enterEmail(email);
    	rpg.enterPassword(password);
    	rpg.enterConfirmPassword(confirmpassword);
    	rpg.clickRegister();
    	
        
    }

    @Then("^user is navigated to Pre Registration page$")
    public void user_is_navigated_to_pre_registration_page()  {
    	RegisterPage rpg = new RegisterPage(base);
    	rpg.preRegisterHeadDisplayed();
    	
        
    }

    @Then("^user should be registered successfully and lands on login page.$")
    public void user_should_be_registered_successfully_and_lands_on_login_page() {
    	DashboardPage dpg = new DashboardPage(base);
    	
    	String dashbaordMsg=dpg.verifyDashboardScreen();
    	scenario.log("User registered and logged in successfully and landed on dashbaord page displying "+dashbaordMsg+ " message");

    }

    @And("^User provide the valid OTP (.+) as recived on (.+) and click on Submit button.$")
    public void user_provide_the_valid_as_recived_on_and_click_on_submit_button(String otp, String email) {
    	
    	TokenValidationPage tvpg = new TokenValidationPage(base);
    	RegisterPage rpg = new RegisterPage(base);
    	
    	
    	String prePopulatedEmail= "";
    	//try {
    	
    		rpg.clickAlertOK();
    		
    	prePopulatedEmail = driver.findElement(By.xpath("//*[@text='"+email+"']")).getText();
    	tvpg.enterOTP(otp);
    	tvpg.clickOTPSubmit();
    	
    	
    	
    	//}
    //	catch(NoSuchElementException ne)
    	//{
    		//ne.printStackTrace();
    		//scenario.log("Expected email "+prePopulatedEmail+" is not prepopulated as, Element with xpath //*[@text='"+email+"'] is not found ");
    		//write code to assert and fail 
    //	}
    	
        
    }

//    @And("^User provide the invalid  (.+) and (.+) and click on Submit button.$")
//    public void user_provide_the_invalid_and_click_on_submit_button(String otp, String email)  {
//    	TokenValidationPage tvpg = new TokenValidationPage(base);
//    	String prePopulatedEmail= "";
//    	//try {
//    	prePopulatedEmail = driver.findElement(By.xpath("//*[@text='"+email+"']")).getText();
//    	tvpg.enterOTP(otp);
//    	tvpg.clickOTPSubmit();
//    	
//    	//}
//    	//catch(NoSuchElementException ne)
//    	//{
//    	//	ne.printStackTrace();
//    		//scenario.log("Expected email "+prePopulatedEmail+" is not prepopulated as, Element with xpath //*[@text='"+email+"'] is not found ");
//    		//write code to assert and fail 
//    	//}
//    	
        
 //   }

    @But("^User see validation error message when used (.+), (.+), (.+) and (.+).$")
    public void user_see_validation_error_message (String fullName, String email, String password, String confirmpassword)  {
    	
    	
    	RegisterPage  rpg = new RegisterPage(base);
    	if(fullName.length()<5) {
    		scenario.log("' "+rpg.fullNameValidationMsgDsplyd()+" ' message is found below full name field");
    	rpg.fullNameValidationMsgDsplyd();
    	}
    	
    	if(!email.matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$"))
    	{
    		scenario.log("' "+rpg.emailValdtnMsgDsplyd()+ " ' message is found below email field");
    	}
    	if(!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[?~!@#\\₹¥€£$•¢®©%\\^&\\*\\[\\]{}()|'`\\`\\;:_\\-<>\\., =\\+\\/\\\\])(A-Za-z\\d?~!@#\\₹¥€£$•¢®©%\\^&\\*\\[\\]{}()|'`\\`\\;:_\\-<>\\., =\\+\\/\\\\]{8,20})"))
    	{
    		scenario.log("' "+rpg.passValdtnMsgDsplyd()+" ' message is found below password field");
    	}
    	
    	if(!confirmpassword.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[?~!@#\\₹¥€£$•¢®©%\\^&\\*\\[\\]{}()|'`\\`\\;:_\\-<>\\., =\\+\\/\\\\])(A-Za-z\\d?~!@#\\₹¥€£$•¢®©%\\^&\\*\\[\\]{}()|'`\\`\\;:_\\-<>\\., =\\+\\/\\\\]{8,20})"))
    	{
    		scenario.log("' "+rpg.cnfrmPassvaldtnMsg1Dsplyd()+" ' message is found below confirm password field");
    	}
    	
    	if(!confirmpassword.equalsIgnoreCase(password))
    	{
    		scenario.log("' "+rpg.cnfrmPassvaldtnMsg2Dsplyd()+" ' message is found below confirm password field");
    	}

    }
	
    @And("^User provide the invalid  (.+) that is not associated with (.+) and click on Submit button.$")
    public void user_provide_the_invalid_that_is_not_associated_with_and_click_on_submit_button(String otp, String email) {
    	TokenValidationPage tvpg = new TokenValidationPage(base);
    	RegisterPage  rpg = new RegisterPage(base);
    	rpg.clickAlertOK();
    	
    	tvpg.enterOTP(otp);
    	
    	tvpg.clickOTPSubmit();
    	    
    }
    
    @But("^User see validation error message when used  (.+) as OTP.$")
    public void user_see_validation_error_message_when_used_as_otp(String otp){
    	TokenValidationPage tvpg = new TokenValidationPage(base);
    	String msg="";
    	if(otp.length()<4)
    	{
    		msg=tvpg.errorMsgValidation();
    	}
    	else
    	{
    		msg=tvpg.ivalidOTPMsgValidation();
    	}
    	
    	 
    	scenario.log("' "+msg+" ' message is found below OTP field");
    	
    	
        
    }

}
