package com.MHS.PageObjects;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.MHS.testCases.Base;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class APIDemosHome extends BasePO {
	
	public APIDemosHome(Base base) {
		super(base);
		// TODO Auto-generated constructor stub
	}

	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='App']")
	private AndroidElement AppOption;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='Menu']")
	private AndroidElement menuoption;
	
	public void clickAppOption()
	{
		if (AppOption.isDisplayed())
			AppOption.click();
	}
	
	public void clickmenuOption()
	{
		if(menuoption.isDisplayed())
			menuoption.click();
	}
	
	
	
	

	
	
}
