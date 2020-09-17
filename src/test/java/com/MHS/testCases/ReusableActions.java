package com.MHS.testCases;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.functions.ExpectedCondition;
import io.cucumber.java.Scenario;


public class ReusableActions{

	
	Base base;
	AppiumDriver<AndroidElement> sharedDriver;
	public Scenario scenario;
	

	public ReusableActions(Base base) {

	this.base=base;
	this.sharedDriver= base.getDriver();
	this.scenario=base.scenario;
	}

	Properties prop;

	// explicitly wait for visibility of element

	public void waitForVisibility(MobileElement el) {
		try {
			FileInputStream fis = new FileInputStream(
					"src\\test\\resources\\configuration.properties");
			prop = new Properties();
			prop.load(fis);
			//picoObject.base= new Base();
			WebDriverWait wait = new WebDriverWait(base.getDriver(), Long.parseLong(prop.getProperty("explicitWait")));
			wait.until(ExpectedConditions.visibilityOf(el));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// click action
	public void click(MobileElement el) {
		try {
			waitForVisibility(el);
			el.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//input action (sendkeys)
	
	public void enterText(MobileElement el, String value)
	{
		try {
			waitForVisibility(el);
			el.sendKeys(value);
		}
		catch(Exception e)
		{e.printStackTrace();}
	}
	
	//clear input field
	public void clearText(MobileElement el)
	{
		try {
			waitForVisibility(el);
			el.clear();;
		}
		catch(Exception e)
		{e.printStackTrace();}
	}
	
	public void takeScreenShotOfPage()
	{
		final byte[] screenshot = sharedDriver.getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "scr"+new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
		System.out.println("image captured");
		
	}

}
