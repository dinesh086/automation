package com.qa.pages;

import org.openqa.selenium.By;

import com.qa.BaseTest;
import com.qa.pages.*;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class VerificationPage extends BaseTest {
	
	
	@AndroidFindBy(xpath="//android.widget.EditText[@index='4']") private MobileElement emailVerificationFirst;
	@AndroidFindBy(xpath="//android.widget.EditText[@index='5']") private MobileElement emailVerificationSecond;
	@AndroidFindBy(xpath="//android.widget.EditText[@index='6']") private MobileElement emailVerificationThird;
	@AndroidFindBy(xpath="//android.widget.EditText[@index='8']") private MobileElement emailVerificationFourth;
	@AndroidFindBy(xpath="//android.widget.EditText[@index='9']") private MobileElement emailVerificationFivth;
	@AndroidFindBy(xpath="//android.widget.EditText[@index='10']") private MobileElement emailVerificationSixth;
	@AndroidFindBy(xpath="//android.view.ViewGroup[@index='12']") private MobileElement confirmButton;
	
	
	

public VerificationPage enterEmail1(String username) {
	sendKeys(emailVerificationFirst,username);
		return this;
}


public MenuPage enterStaticOTP() throws Exception {
	Thread.sleep(3000);
	String count = "1";
	for( int i=4; i<= 10; i++) {
		if (i!=7) {
			MobileElement emailVerification =  (MobileElement) driver.findElement(By.xpath("//android.widget.EditText[@index='"+i+"']"));
			emailVerification.sendKeys(count);
			int a =Integer.parseInt(count);  
			a = a+1;
			
			 count=Integer.toString(a);
		}else {
			count = count;
		}

	}
	
	 Thread.sleep(3000);
	 MobileElement confirmButton =  (MobileElement) driver.findElement(By.xpath("//android.view.ViewGroup[@index='12']")); 
	 confirmButton.click();
	 return new MenuPage();
}


public VerificationPage enterEmail2(String username) {
	sendKeys(emailVerificationSecond,username);
		return this;
}
public VerificationPage enterEmail3(String username) {
	sendKeys(emailVerificationThird,username);
		return this;
}
public VerificationPage enterEmail4(String username) {
	sendKeys(emailVerificationFourth,username);
		return this;
}
public VerificationPage enterEmail5(String username) {
	sendKeys(emailVerificationFivth,username);
		return this;
}
public VerificationPage enterEmail6(String username) {
	sendKeys(emailVerificationSixth,username);
		return this;
}

public MenuPage pressLoginButton() {
	click(confirmButton);
	return new MenuPage();
}
}