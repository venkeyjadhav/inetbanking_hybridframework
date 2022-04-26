package com.inetbanking.testcases;

import org.testng.annotations.Test;

import com.inetbanking.pageobject.AddNewCustomerPage;
import com.inetbanking.pageobject.HomePage;
import com.inetbanking.pageobject.LoginPage;
import com.inetbanking.testbase.TestBase;
import com.inetbanking.utility.Helper;

public class AddNewCustomerTC_001 extends TestBase {

	@Test
	public void AddNewCustomerTest() throws InterruptedException {
		extentTest=extentReport.createTest("login functionality Test");
		LoginPage login = new LoginPage(driver);
		login.setUsername(configdataprovider.getUserName());
		login.setPassword(configdataprovider.getPwrd());
		HomePage homepage = login.clickonLoginBtn();
		Thread.sleep(3000);
		AddNewCustomerPage addCust = homepage.clickonNewCustomerLink();
		addCust.setCustomerName("abcd");
		addCust.clickOnGenderRadioBtn("male");
		addCust.setDateOfBirth("12");
		Thread.sleep(2000);
		addCust.setDateOfBirth("05");
		Thread.sleep(2000);
		addCust.setDateOfBirth("2021");
		Thread.sleep(2000);
		addCust.setAddress("cidco aurangabad");
		addCust.setCity("aurangabad");
		addCust.setState("maharashtra");
		addCust.setPin("431006");
		addCust.setTelephoneNo("8308094609");
		String randomstring=Helper.getRandomString();
		addCust.setEmailid(randomstring+"@gmail.com");
		addCust.setPassword("abcd%$321");
		addCust.clickOnsubmitBtn();
	}
}
