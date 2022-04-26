package com.inetbanking.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobject.HomePage;
import com.inetbanking.pageobject.LoginPage;
import com.inetbanking.testbase.TestBase;

public class HomeTC_001 extends TestBase {

	HomePage homepage;
	@Test(priority = 1)
	public void verifyLoginFuctionalityTC001() {
		LoginPage login = new LoginPage(driver);
		login.setUsername(configdataprovider.getUserName());
		login.setPassword(configdataprovider.getPwrd());
		homepage = login.clickonLoginBtn();
}
	
	@Test(priority = 2, enabled =false)
	public void navigateToEditCustomerPage()
	{
		homepage.clickonEditCustomerLink();
	}
	
	@Test(priority = 3)
	public void verifyLogoutFunctionality()
	{
		homepage.clickonLogoutLink();
		if(driver.getTitle().equals("Guru99 Bank Home Page")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
}
