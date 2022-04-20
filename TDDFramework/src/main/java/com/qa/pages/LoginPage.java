package com.qa.pages;

import com.qa.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BaseTest {
	
	@AndroidFindBy(xpath="//android.widget.EditText[@index='3']") private MobileElement emailTextBox;
	@AndroidFindBy(xpath="//android.view.ViewGroup[@index='4']") private MobileElement submitButton;
	@AndroidFindBy(xpath="//android.widget.TextView[@index='4']") private MobileElement errorText;



public LoginPage enterEmail(String username) {
	sendKeys(emailTextBox,username);
	return this;
}

public VerificationPage pressLoginButton() {
	click(submitButton);
	return new VerificationPage();
}
public LoginPage enterUserName(String username) {
		
	sendKeys(emailTextBox, username);
	return this;
}



}