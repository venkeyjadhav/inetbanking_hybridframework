package com.inetbanking.testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.inetbanking.pageobject.LoginPage;
import com.inetbanking.testbase.TestBase;

public class LoginTC001 extends TestBase {

//	@Test
//	public void verifyLoginFuctionalityTC001() {
//		LoginPage login = new LoginPage(driver);
//		login.setUsername("mngr395244");
//		login.setPassword("YrYbEjY");
//		login.clickonLoginBtn();
//	}
	
	@Test
	public void verifyLoginFuctionalityTC001() {
		
		extentTest=extentReport.createTest("Login Functionality Test");
		LoginPage login = new LoginPage(driver);
		login.setUsername(configdataprovider.getUserName());
		login.setPassword(configdataprovider.getPwrd());
		login.clickonLoginBtn();
}
}