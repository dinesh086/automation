package com.qa.pages;

import com.qa.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BasketReview extends BaseTest {

	@AndroidFindBy(xpath="//android.widget.TextView[@index='0']") private MobileElement checkoutBtn;
	
	
	public CheckoutPage pressCheckoutBtn() {
		click(checkoutBtn);
		return new CheckoutPage();
	}
	
}
