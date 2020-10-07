package com.MHS.PageObjects;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;

import com.MHS.testCases.Base;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class RegisterPage extends BasePO {

	public RegisterPage(Base base) {
		super(base);
		// TODO Auto-generated constructor stub
	}

	@AndroidFindBy(xpath = "(//*[@text='PATIENTS']//parent::android.view.ViewGroup//parent::android.view.ViewGroup/android.widget.TextView)[1]")
	private AndroidElement preRegisterHead;

	// "(//*[@text='PATIENTS']//parent::android.view.ViewGroup//parent::android.view.ViewGroup/android.widget.TextView)[1]"

	@AndroidFindBy(xpath = "//*[@text='PATIENTS']")
	private AndroidElement patientsTapArea;

	@AndroidFindBy(xpath = "//*[@text='SPECIALISTS']")
	private AndroidElement specialistTapArea;

	@AndroidFindBy(xpath = "//*[@text='Full Name']//parent::android.view.ViewGroup//parent::android.view.ViewGroup/android.widget.TextView")
	private AndroidElement registerHead;
	

	@AndroidFindBy(xpath = "(//*[@text='Full Name'])[2]")
	private AndroidElement fullNameEditBox;

	@AndroidFindBy(xpath = "(//*[@text='Email'])[4]")
	private AndroidElement EmailEditBox;

	@AndroidFindBy(xpath = "(//*[@text='Password'])[4]")
	private AndroidElement PasswordEditBox;

	@AndroidFindBy(xpath = "(//*[@text='Confirm Password'])[2]")
	private AndroidElement confirmPasswordEditBox;

	@AndroidFindBy(xpath = "//*[@text='Register']")
	private AndroidElement registerBtn;

	@AndroidFindBy(xpath = "(//*[@text='Login'])[2]")
	private AndroidElement loginLink;

	@AndroidFindBy(xpath = "//*[@text='Register with Facebook']")
	private AndroidElement registerWithFacebook;

	@AndroidFindBy(xpath = "//*[@text='Register with Google']")
	private AndroidElement registerWithGoogle;
	
	@AndroidFindBy(xpath="//*[@text='Token']")
	private AndroidElement OTPeditBox;
	
	@AndroidFindBy(xpath="//*[@text='Validate']")
	private AndroidElement OTPSubmitBtn;
	
	@AndroidFindBy(xpath="//*[@resource-id='android:id/button1']")
	private AndroidElement emailOTPAlert;
	
	
	@AndroidFindBy(xpath="//*[@resource-id='android:id/message']")
	private AndroidElement OTPAlertMsg;
	
	
	@AndroidFindBy(xpath="//*[@resource-id='android:id/alertTitle']")
	private AndroidElement OTPalertTitle;
	
	@AndroidFindBy(xpath="//*[@text='Please enter valid value']")
	private AndroidElement OTPValidationerrorMsg;
	
	@AndroidFindBy(xpath="//*[text='Email OTP send successfully!']")
	private AndroidElement resendOTPAlert;
	
	@AndroidFindBy(xpath="//*[text='OK']")
	private AndroidElement alertAccept;
	
	@AndroidFindBy(xpath="//*[@text='please enter valid value, minimum length is 5']")
	private AndroidElement fullNameValidationMsg;
	
	@AndroidFindBy(xpath="//*[@text='please enter valid email address']")
	private AndroidElement emailValidationMsg;
	
	@AndroidFindBy(xpath="//*[@text='please enter valid value']")
	private AndroidElement passwordValidationMsg;
	
	@AndroidFindBy(xpath="//*[@text='please enter valid value']")
	private  AndroidElement cnfrmPasswordValidationMsg1;
	
	@AndroidFindBy(xpath="//*[@text='do not match with password']")
	private  AndroidElement cnfrmPasswordValidationMsg2;
	
	@AndroidFindBy(xpath="//*[@text='Request failed with status code 400']")
	private AndroidElement backendValidationfailed;
	
	
	//resource-id- android:id/alertTitle  ,  text ='Email OTP send successfully!'
	//android:id/button1   , text ='OK'
	
	//Token Validation
	//Resend OTP
	//Login
	


	public boolean preRegisterHeadDisplayed() {
		boolean flag = false;
		//try {
			flag = preRegisterHead.isDisplayed();
		//} catch (NoSuchElementException ne) {
		//	ne.printStackTrace();
		//	flag = false;
		//}

		return flag;

	}

	public void clickPatients() {
		//try {
			patientsTapArea.click();
		//} catch (NoSuchElementException ne) {
		//	ne.printStackTrace();
		//}
	}

	public void clickSpecialist() {
		//try {
			specialistTapArea.click();
		//} catch (NoSuchElementException ne) {
		//	ne.printStackTrace();
		//}
	}

	public void registerHeadDisplayed() {
		//try {
			registerHead.isDisplayed();
	//	} catch (NoSuchElementException ne) {
		//	ne.printStackTrace();
		//}
	}

	public void enterFullName(String fullName) {
	//	try {
			fullNameEditBox.sendKeys(fullName);
		//} catch (NoSuchElementException ne) {
		//	ne.printStackTrace();
		//}
	}

	public void enterEmail(String emailID) {
		//try {
			EmailEditBox.sendKeys(emailID);

	//	} catch (NoSuchElementException ne) {
		//	ne.printStackTrace();
		//}
	}

	public void enterPassword(String password) {
		//try {
			PasswordEditBox.sendKeys(password);

		//} catch (NoSuchElementException ne) {
			//ne.printStackTrace();
		//}
	}

	public void enterConfirmPassword(String password) {
	//	try {
			confirmPasswordEditBox.sendKeys(password);

		//} catch (NoSuchElementException ne) {
			//ne.printStackTrace();
		//}
	}

	public void clickRegister() {
		//try {
			registerBtn.click();
	//	} catch (NoSuchElementException ne) {
		//	ne.printStackTrace();
		//}
	}

	public void clickLogin() {
		//try {
			loginLink.click();
		//} catch (NoSuchElementException ne) {
		//	ne.printStackTrace();
		//}
	}

	public void clickRegisterWithFacebooklink() {
		//try {
			registerWithFacebook.click();
		//} catch (NoSuchElementException ne) {
			//ne.printStackTrace();
		//}
	}

	public void clickRegisterWithGoogle() {
		//try {
			registerWithGoogle.click();
		//} catch (NoSuchElementException ne) {
			//ne.printStackTrace();
		//}
	}
	
	public String getOTPalertText()
	{
		String confirmationMsg = "";
		//try {
			OTPAlertMsg.isDisplayed();
			confirmationMsg =OTPAlertMsg.getText();
			
		//}
		//catch(NoSuchElementException ne )
		//{ ne.printStackTrace();
		 //confirmationMsg = "BLANK";
		
		//}
		return confirmationMsg;
	}
	
	public void clickAlertOK()
	{
		//try {
		
			emailOTPAlert.click();
		//}
		//catch(NoSuchElementException ne)
		//{
		//	ne.printStackTrace();
		//}
		
	}
	
	public String fullNameValidationMsgDsplyd()
	{
		fullNameValidationMsg.isDisplayed();
		return  fullNameValidationMsg.getText();
		
			
		
	}
	
	public String emailValdtnMsgDsplyd()
	{
		emailValidationMsg.isDisplayed();
		return emailValidationMsg.getText();
		
	}
	
	public String passValdtnMsgDsplyd()
	{
		passwordValidationMsg.isDisplayed();
		return passwordValidationMsg.getText();
		
	}
	
	public String cnfrmPassvaldtnMsg1Dsplyd() 
	{
		cnfrmPasswordValidationMsg1.isDisplayed();
		return cnfrmPasswordValidationMsg1.getText();
	}
	
	public String cnfrmPassvaldtnMsg2Dsplyd() 
	{
		cnfrmPasswordValidationMsg2.isDisplayed();
		return cnfrmPasswordValidationMsg2.getText();
	}
	
	public String backendVldtnMsgDsplyd()
	{
		backendValidationfailed.isDisplayed();
		return backendValidationfailed.getText();
	}
	
	

}
