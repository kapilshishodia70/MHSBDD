package com.MHS.PageObjects;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import com.MHS.testCases.Base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BasePO {
	public static final int IMPLICIT_WAIT= 30;
	Base base;
	AppiumDriver<AndroidElement> sharedDriver;
	
	
	
	public BasePO(Base base) 
	{
		this.base =base;
		this.sharedDriver= base.getDriver();
		initElements();
		
	}
	
	private void initElements() 
	{
		System.out.println("initialiaing page factory elements");
		PageFactory.initElements(new AppiumFieldDecorator(sharedDriver, Duration.ofSeconds(IMPLICIT_WAIT)), this);
		
	}
}
