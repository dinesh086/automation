package com.qa;

import org.testng.annotations.Test;

import com.qa.utils.TestUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class BaseTest {
	protected static AppiumDriver driver;
	protected static Properties props;
	InputStream inputStream;
	
	
	public BaseTest() {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
		
  @Parameters({"deviceName","platformName","udid","platformVersion"})
  @BeforeTest
  public void beforeTest(String deviceName, String platformName, String udid, String platformVersion) throws Exception  {

	  
	  URL url;
	  
	  try {
		  props = new Properties();
		  String propFileName = "config.properties";
		  inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		  props.load(inputStream);
		 
		  
		  DesiredCapabilities cap = new DesiredCapabilities();
		    cap.setCapability("platformName", platformName);
			cap.setCapability("platformVersion", platformVersion);
			cap.setCapability("deviceName", deviceName);
			cap.setCapability("udid", udid);
					
			
			  switch(platformName) {
			
			  
			  case "Android": 
			  cap.setCapability("appPackage",props.getProperty("androidAppPackageName")); 
			  cap.setCapability("appActivity", props.getProperty("androidAppActivityName")); 
			  //String androidAppURL =  getClass().getResource(props.getProperty("iOSApplication")).getFile();
			  //cap.setCapability("app",androidAppURL); 
			  url = new URL(props.getProperty("appiumURL")); 
			  driver = new AndroidDriver(url, cap);
			  break;
			  
			  case "iOS":
			  
			  cap.setCapability("automationName", props.getProperty("iOSAutomationName"));
			  String iOSAppURL = getClass().getResource(props.getProperty("iOSApplication")).getFile();
			  cap.setCapability("app", iOSAppURL); 
			  url = new URL(props.getProperty("appiumURL")); 
			  driver = new IOSDriver(url, cap); 
			  break;
			  default: 
			  throw new Exception("Invalid platfrom!- " + platformName);
			  
			  }
			 
			
			
		  
	  } catch(Exception e) {
		  e.printStackTrace();
		  throw e;
		  
	  }
	  
	  
	 
	

  }
  
  public void waitForVisibility(MobileElement e) {
	  
	  WebDriverWait wait = new WebDriverWait(driver,TestUtils.WAIT);
	  wait.until(ExpectedConditions.visibilityOf(e));
	  
  }
  
  public void click(MobileElement e) {
	  waitForVisibility(e);
	  e.click();
  }
  
  public void sendKeys(MobileElement e, String txt) {
	  waitForVisibility(e);
	  e.sendKeys(txt);
  }
  public void getAttribute(MobileElement e, String attribute) {
	  waitForVisibility(e);
	  e.getAttribute(attribute);
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
	  
  }
  
  

}
