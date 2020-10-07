package com.MHS.PageObjects;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;

import com.MHS.testCases.Base;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class TokenValidationPage extends BasePO{
	public TokenValidationPage(Base base) {
		super(base);
		// TODO Auto-generated constructor stub
	}
	
	@AndroidFindBy(xpath="(//*[@text='Token'])[2]")
	private AndroidElement OTPeditBox;
	
	@AndroidFindBy(xpath="//*[@text='Validate']")
	private AndroidElement OTPSubmitBtn;
	
	@AndroidFindBy(xpath="//*[@text='Please enter valid value']")
	private AndroidElement OTPValidationerrorMsg;
	
	@AndroidFindBy(xpath="//*[@text='Token Validation']")
	private AndroidElement tokenValiadtionHead;
	
	@AndroidFindBy(xpath="//*[@text='Resend OTP']")
	private AndroidElement resendOTPBtn;
	
	@AndroidFindBy(xpath="//*[@text='Login']")
	private AndroidElement LoginBtn;
	
	@AndroidFindBy(xpath="//*[@text='please enter valid value, minimum length is 5']")
	private AndroidElement fullNameValidationMsg;
	
	@AndroidFindBy(xpath="//*[@text='please enter valid email address']")
	private AndroidElement emailValidationMsg;
	
	@AndroidFindBy(xpath="//*[@text='please enter valid value']")
	private AndroidElement passwordValidationMsg;
	
	@AndroidFindBy(xpath="//*[@text='please enter valid value'] ||//*[@text='do not match with password']")
	private  List<AndroidElement> cnfrmPasswordValidationMsg;
	
	@AndroidFindBy(xpath="//*[@text='Request failed with status code 400']")
	private AndroidElement backendValidationfailed;
	
	
	
	
	//'Request failed with status code 400'
	//'please enter valid value, minimum length is 5'
	//'please enter valid email address'
	//'please enter valid value'
	//'please enter valid value'
	//'do not match with password'
	
	
	public void tokenValidationHeadDisplayed()
	{
		//try {
			tokenValiadtionHead.isDisplayed();
	//	}
		//catch(NoSuchElementException ne)
		//{
		//	ne.printStackTrace();
		//}
	}
	
	public void enterOTP(String OTP)
	{
		//try {
			OTPeditBox.sendKeys(OTP);
		//}
		//catch(NoSuchElementException ne)
		//{
		//	ne.printStackTrace();
		//}
	}
	
	public void clickOTPSubmit()
	{
		//try {
			OTPSubmitBtn.click();
		//}
		//catch(NoSuchElementException ne) 
		//{ne.printStackTrace();}
	}
	
	public void clickResendOTP() 
	{
		//try {
			resendOTPBtn.click();
		//}
		//catch(NoSuchElementException ne) 
		//{
			//ne.printStackTrace();
		//}
	}
	
	public void clickLogin()
	{
		//try {
			LoginBtn.click();
		//}
		//catch(NoSuchElementException ne)
		//{
			//ne.printStackTrace();
		//}

	}
	
	public String errorMsgValidation()
	{
		String msg="";
		try {
			OTPValidationerrorMsg.isDisplayed();
			 msg= OTPValidationerrorMsg.getText();
			
		}
		catch(NoSuchElementException ne)
		{
			ne.printStackTrace();
		}
		return msg;
	}
	
	public String ivalidOTPMsgValidation()
	{
		String msg="";
		try {
			backendValidationfailed.isDisplayed();
			 msg= backendValidationfailed.getText();
			
		}
		catch(NoSuchElementException ne)
		{
			ne.printStackTrace();
		}
		return msg;
	}

}
