package com.qa;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import com.qa.pages.BasketReview;

public class HeaderPage extends BaseTest {

	@AndroidFindBy(xpath="//android.widget.ImageView[@index='0']") private MobileElement basketBtn;
	
	
	public BasketReview pressSeetingsBtn() {
		click(basketBtn);
		return new BasketReview();
	}
	
}
