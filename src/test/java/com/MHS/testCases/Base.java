package com.MHS.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
//import io.cucumber.java.Scenario;

public class Base {
	

	
	
	public static File apkFile; // apk file of android app
	public static Properties prop; //  Properties file for mobile app capabilities and other app and driver related configurations
	public Scenario scenario; // Object of Scenario class for getting status of execution during run time.
	private AndroidDriver<AndroidElement> sharedDriver;  //android driver object
	
	
	/////Before Hook ,executed before every scenario and do setup driver with desired capabilities//////////
	@Before
	public void capabilities(Scenario scenario) throws IOException 
	
	{
		this.scenario=scenario;  //scenario object of Scenario type initialized in Before hook , this can be used until execution of scenario completes
		
		
		
		// Instantiate and load properties file
		prop= new Properties();
		FileInputStream fis = new FileInputStream("src\\test\\resources\\configuration.properties");
		prop.load(fis);
		apkFile= new File(prop.getProperty("apkPath"));
		
		//set the desired capabilities and initialize the driver
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty("android.platform"));
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getProperty("android.platform.version"));
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("android.device.name"));
		//use if apk is available
		
		
		//
		//use only if using browser in android mobile
		//cap.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		//use if apk not avaialble
		if(apkFile.getAbsolutePath()== null || apkFile.getAbsolutePath().trim().isEmpty())
		{
		cap.setCapability("appPackage", prop.getProperty("android.app.packageName"));
		cap.setCapability("appActivity", prop.getProperty("android.app.activityName"));
		}
		else
		{
			cap.setCapability(MobileCapabilityType.APP, apkFile.getAbsolutePath());
		}
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability("noReset", true);
		cap.setCapability("autoGrantPermissions",true);
		
		
		
		 sharedDriver = new AndroidDriver<>(new URL(prop.getProperty("appium.server.url")),cap);
		
		
	}
	
	// public getDriver method  
	public AndroidDriver<AndroidElement> getDriver(){
		System.out.println("calling get driver method");
		System.out.println(sharedDriver.hashCode());
		return sharedDriver;
	}
	
	
	
	
	//////After hook, do terminate the browser or any other task that have to performed after the scenario 
	@After
	public void tearDown() {
		
		//final byte[] screenshot = sharedDriver.getScreenshotAs(OutputType.BYTES);
		
	   // scenario.attach(screenshot, "image/png", "scr"+new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
	    
		
		if(sharedDriver!=null)
			sharedDriver.quit();
		
	}
	
	
	
	////// Before step hook, used sending custom message in report 
	@BeforeStep
	public void step()
	{
		//System.out.println("the name of the scenario is : " +scenario.getName());
		scenario.log("Custom message before step is executed for scenario"+ scenario.getName());
		
		
	}
	
	
	
	
	///// Afterstep hook, used for taking screenshot of app screen after step execution or if scenario fails
	@AfterStep
	public void stepAfter()
	{
		//if(scenario.isFailed())
		{
			
			scenario.log("Screenshot of app after the "+ scenario.getName() + " scenario");
			final byte[] screenshot = sharedDriver.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "scr"+new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
		}
	}

	
	
}
