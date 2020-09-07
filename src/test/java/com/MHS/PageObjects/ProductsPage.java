package com.MHS.PageObjects;

import java.util.List;

import com.MHS.testCases.Base;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductsPage extends BasePO{

	public ProductsPage(Base base) {
		super(base);
		// TODO Auto-generated constructor stub
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/toolbar_title")
	private AndroidElement productTitle;

	@AndroidFindBy(id="com.androidsample.generalstore:id/productAddCart")
	private List<AndroidElement> addToCart;
	//	com.androidsample.generalstore:id/appbar_btn_cart
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private AndroidElement cart;
	
	
	public String getPageTitle() {
		return productTitle.getText();
		
	}
	public void clickOnAddTocart() {
		
//		if(addToCart.listIterator().hasNext())
//		{
//			addToCart.listIterator().next().getText();
//		}
		
		addToCart.get(1).click();
	}
	
	public void clickOnCart() {
		cart.click();
	}
}
