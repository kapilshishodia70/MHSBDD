package com.MHS.testCases;

import static org.testng.Assert.assertNotNull;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.PageFactory;

import com.MHS.PageObjects.APIDemosHome;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;



public class LauchApp {
	
	
	Base base;
	AndroidDriver<AndroidElement> driver;
	ReusableActions action;
	//Scenario scenario;
	
	
	public LauchApp(Base base) {
		
		
		this.base = base;
		this.action= new ReusableActions(this.base); 
		//this.scenario =base.scenario;
	}
	

	@Given("app is launched")
	public  void launchAndroidApp() throws IOException 
	{
		
		
		//APIDemosHome APhome = new APIDemosHome();
		//APhome = PageFactory.initElements(driver, APIDemosHome.class);
		//APhome.AppOption.click();
		//driver.findElement(By.xpath("//android.widget.TextView[@content-desc='App']")).click();;
		APIDemosHome adh = new APIDemosHome(base);
		
		adh.clickAppOption();
		//assert here by checking element of next page
		System.out.println("Clicked successfully");
		
		
		
	}
	
	
	@Then("print succcess")
	public void print_success() {
		String Null = null;
		APIDemosHome adh = new APIDemosHome(base);
		adh.clickmenuOption();
		System.out.println("success");
		
		assertNotNull(Null);
		//final byte[] screenshot = sharedDriver.getScreenshotAs(OutputType.BYTES);
		//action.takeScreenShotOfPage();
	}

}
