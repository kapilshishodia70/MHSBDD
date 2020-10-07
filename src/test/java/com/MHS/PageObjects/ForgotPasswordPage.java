package com.MHS.PageObjects;

import com.MHS.testCases.Base;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ForgotPasswordPage extends BasePO {

	public ForgotPasswordPage(Base base) {
		super(base);
		// TODO Auto-generated constructor stub
	}
	
	
	@AndroidFindBy(xpath="(//*[@text='Email'])[4]")
	private AndroidElement emailEditBox;
	
	
	@AndroidFindBy(xpath="//*[@text='Submit']")
	private AndroidElement submitBtn;
	
	
	@AndroidFindBy(xpath="//*[@resource-id='android:id/button1']")
	private AndroidElement forgotPasswordOTPAlert;
	
	@AndroidFindBy(xpath="(//*[@text='Token'])[2]")
	private AndroidElement OTPeditBox;
	
	@AndroidFindBy(xpath = "(//*[@text='Password'])[4]")
	private AndroidElement PasswordEditBox;
	
	@AndroidFindBy(xpath = "(//*[@text='Confirm Password'])[2]")
	private AndroidElement confirmPasswordEditBox;
	
	@AndroidFindBy(xpath="//*[@resource-id='android:id/button1']")
	private AndroidElement resetSuccessAlert;
	
	@AndroidFindBy(xpath="//*[@resource-id='android:id/message']")
	private AndroidElement resetSuccessMsg;
	
	

	
	@AndroidFindBy(xpath = "(//*[@text='Login'])[2]")
	private AndroidElement LoginBtn;
	
	
	public void enterEmailonFPpage(String email)
	{
		emailEditBox.sendKeys(email);
	}
	
	public void clickSubmit()   // call submit method twice once for getting token and second after setting new password
	{
		submitBtn.click();
	}
	
	//accept allert
	
	public void acceptOTPAlert()
	{
	
		forgotPasswordOTPAlert.click();
	}
	
	
	// validate the prepoulated email in test script
	public void setToken(String OTP)
	{
		OTPeditBox.sendKeys(OTP);
	}
	
	public void setPassword(String password)
	{
		PasswordEditBox.sendKeys(password);
	}
	
	public void setConfirmPassword(String conformPassword)
	{
		confirmPasswordEditBox.sendKeys(conformPassword);
	}
	
	public String acceptChangedPasswordAlert()
	{
		String msg=resetSuccessMsg.getText();
		resetSuccessAlert.click();
		
		return msg;
	}
	
	
	
	//now use login page objects in test case to login further

}
