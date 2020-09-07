package com.MHS.PageObjects;

import static org.testng.Assert.assertTrue;

import java.util.List;

import com.MHS.testCases.Base;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class GeneralStoreHomePage extends BasePO {

	public GeneralStoreHomePage(Base base) {
		super(base);
		// TODO Auto-generated constructor stub
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/toolbar_title")
	private AndroidElement title;
	
	@AndroidFindBy(id="android:id/text1")
	private AndroidElement selectedCountrytitle;
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout/android.widget.ListView/android.widget.TextView")
	private List<AndroidElement> selectCountry;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private AndroidElement countryDropDown;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private AndroidElement yourName;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
	private AndroidElement radioMale;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	private AndroidElement radioFemale;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private AndroidElement letsShopBtn;
	
	
	public boolean titleDispalyed()
	{
		boolean displayed = title.isDisplayed();
		return displayed;
		
	}
	
	public void clickOnSpinnerCountry()
	{
		countryDropDown.click();
	}
	
	public void enterYourname()
	{
		yourName.sendKeys("Kapil");
	}
	
	public void selectGender() 
	{
		radioMale.click();
	}
	
	public void letsShop()
	{
		letsShopBtn.click();
	}

}
