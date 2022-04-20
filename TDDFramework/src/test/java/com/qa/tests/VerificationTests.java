package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.BaseTest;
import com.qa.pages.LoginPage;
import com.qa.pages.VerificationPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.AfterClass;

public class VerificationTests extends BaseTest {
	com.qa.pages.LoginPage loginPage;
	 com.qa.pages.VerificationPage verificationPage;
	 com.qa.pages.MenuPage menuPage;
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
  public void beforeMethod(Method m) throws Exception {	  
	  System.out.println("***Starting Test" + m.getName());	
	  loginPage = new LoginPage();
	  loginPage.enterEmail(loginUsers.getJSONObject("validEmail").getString("email"));
	  verificationPage = loginPage.pressLoginButton();	
	  		  
	  
  }

  @AfterMethod 
  public void afterMethod() {
	  		 
	  
	  //menuPage = verificationPage.pressLoginButton();
	   
  }
  

  @Test
  public void otpVerification() throws Exception {
	 	  
	 	  menuPage = verificationPage.enterStaticOTP(); 
	 	  Thread.sleep(3000);	
	  
  }

  

}
