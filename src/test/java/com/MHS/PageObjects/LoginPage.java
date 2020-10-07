package com.MHS.PageObjects;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.interactions.touch.TouchActions;

import com.MHS.testCases.Base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class LoginPage extends BasePO {

	public LoginPage(Base base) {
		super(base);
		// TODO Auto-generated constructor stub
	}

	@AndroidFindBy(xpath = "(//android.view.ViewGroup/android.widget.TextView)[1]")
	private AndroidElement LoginHeader;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Email']")
	private AndroidElement EmailEditBox;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Password']")
	private AndroidElement PasswordEditBox;

	// @AndroidFindBy(xpath="//android.widget.EditText[@text='Password']//parent::android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView")
	private AndroidElement ShowPassword;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Login']")
	private AndroidElement LoginButton;

	@AndroidFindBy(xpath = "//*[@text='please enter valid email address']")
	private AndroidElement emailFieldvalidationMsg;

	@AndroidFindBy(xpath = "//*[@text='Please enter valid value']")
	private AndroidElement passwordFieldvalidationMsg;

	@AndroidFindBy(xpath = "//*[@text='Request failed with status code 400']")
	private AndroidElement wrongPassvalidaionMsg;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Forgot Password?']")
	private AndroidElement ForgotPassword;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Not Registered Yet? SIGN Up']")
	private AndroidElement Register;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Login with Facebook']")
	private AndroidElement FacebookLogin;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Login with Google']")
	private AndroidElement GoogleLogin;

	public boolean headerDisplayed() {
		boolean flag = LoginHeader.isDisplayed();
		return flag;
	}

	public void enterEmailId(String emailID) {
		EmailEditBox.sendKeys(emailID);
	}

	public void enterPassword(String password) {
		PasswordEditBox.sendKeys(password);
	}

	public void showPassword(String password) throws InterruptedException {
		ShowPassword.click();
		Thread.sleep(2000);
		// TouchAction touchAction = new TouchAction(sharedDriver);
		// touchAction.tap(new TapOptions().withElement(new
		// ElementOption().withElement(ShowPassword))).perform();

		// if(PasswordEditBox.getText().equalsIgnoreCase(password)

	}

	public void clickLogin() {
		LoginButton.click();
	}

	public void clickForgotPassword() {
		ForgotPassword.click();
	}

	public void clickRegister() {
		Register.click();
	}

	public void clickFacebookLogin() {
		FacebookLogin.click();
	}

	public void clickGoogleLogin() {
		GoogleLogin.click();
	}

	public String emailFieldvalidation() {
		String validationMsg = "";
		try {
			if (emailFieldvalidationMsg.isDisplayed()) {
				validationMsg = emailFieldvalidationMsg.getText();

			}

		} catch (NoSuchElementException e1) {
			validationMsg = "No validation ";
			e1.printStackTrace();
		} catch (NotFoundException e2) {
			validationMsg = "No validation ";
			e2.printStackTrace();
		}
		return validationMsg;
	}

	
	public ArrayList<Object> passwordFieldvalidation() {
		String validationMsg = "";
		boolean flag=false;
		ArrayList<Object> al = new ArrayList<Object>() ;
		try {
			if (passwordFieldvalidationMsg.isDisplayed()) 
			{
				validationMsg = passwordFieldvalidationMsg.getText();
				flag=true;

			}
			else 
			{
				flag=false;
			}
		} catch (NoSuchElementException e1) {
			validationMsg = "No validation ";
			flag=false;
			e1.printStackTrace();
		} catch (NotFoundException e2) {
			validationMsg = "No validation ";
			flag=false;
			e2.printStackTrace();
		}
		
		al.add(flag);
		al.add(validationMsg);
		return al;
	}
	
	public ArrayList<Object> wrongPassvalidaionMsg()
	{
		String validationMsg="";
		boolean flag =false;
		ArrayList<Object> al= new ArrayList<Object>();
		try 
		{
			if(wrongPassvalidaionMsg.isDisplayed())
			{
				validationMsg=wrongPassvalidaionMsg.getText();
				flag=true;// change to true
			}
			else
			{
				flag=false;
			}
		}
		catch (NoSuchElementException e1) {
			validationMsg = "No validation ";
			flag=false;
			e1.printStackTrace();
		} catch (NotFoundException e2) {
			validationMsg = "No validation ";
			flag=false;
			e2.printStackTrace();
		}
		al.add(flag);
		al.add(validationMsg);
		return  al;
	}
}
