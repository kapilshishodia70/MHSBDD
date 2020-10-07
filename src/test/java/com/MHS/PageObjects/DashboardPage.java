package com.MHS.PageObjects;

import org.openqa.selenium.NoSuchElementException;

import com.MHS.testCases.Base;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DashboardPage extends BasePO {

	public DashboardPage(Base base) {
		super(base);
		// TODO Auto-generated constructor stub
	}
	
	@AndroidFindBy(xpath="//*[@text='Dashboard Screen'] | //*[@lable='Dashboard Screen']")
	private AndroidElement dashboardScrMsg;
	
	
	@AndroidFindBy(xpath="(//*[@text='Dashboard']/parent::android.view.ViewGroup//following-sibling::android.view.ViewGroup/android.widget.TextView)[1]")
	private AndroidElement hamburgerMenu;
	
	@AndroidFindBy(xpath="//*[@text='Logout']")
	private AndroidElement logoutBtn;
	
	public String verifyDashboardScreen()
	{
		String dashboardmsg= "";
		try {
		dashboardScrMsg.isDisplayed();
		dashboardmsg=dashboardScrMsg.getText();
		}
		catch(NoSuchElementException ne)
		{
		 ne.printStackTrace();
		 
		}
		return dashboardmsg;
	}
	
	public void clickOnMenu()
	{
		hamburgerMenu.click();
	}
	
	public void clickLogout()
	{
		logoutBtn.click();
	}

}
