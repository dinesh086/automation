package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.BaseTest;

import io.appium.java_client.MobileElement;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.AfterClass;

public class LoginTests extends BaseTest{
	
	 com.qa.pages.LoginPage loginPage;
	 com.qa.pages.VerificationPage verificationPage;
	 InputStream datais;
	 JSONObject loginUsers;
	
	@BeforeClass
	  public void beforeClass() throws Exception {
		
		try {
			String dataFileName = "data/loginUsers.json";
			datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
			JSONTokener tokener = new JSONTokener(datais);
			loginUsers = new JSONObject(tokener);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			if (datais != null) {
				datais.close();
			}
		}
		
	  }

	  @AfterClass
	  public void afterClass() {
	  }
	  @BeforeMethod
	  public void beforeMethod(Method m) {
		  loginPage = new com.qa.pages.LoginPage();
		 // verificationPage = new com.qa.pages.VerificationPage();
	  System.out.println("***Starting Test" + m.getName());
	  }

	  @AfterMethod
	  public void afterMethod() {
	  }
//	  @Test
//	  public void invalidUserName() throws Exception {
//		  
//		loginPage.enterEmail(loginUsers.getJSONObject("invalidEmail").getString("email"));
//		loginPage.pressLoginButton();
//		
//		  
//	  }
//  
	  
	  @Test
	  public void successfulLogin() throws Exception {	
		  
		  loginPage.enterEmail(loginUsers.getJSONObject("validEmail").getString("email"));
		  verificationPage = loginPage.pressLoginButton();		  
		
		  
	  }

 
 
  
}
