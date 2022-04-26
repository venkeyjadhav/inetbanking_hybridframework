package com.inetbanking.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageobject.LoginPage;
import com.inetbanking.testbase.TestBase;

public class LoginTC002 extends TestBase {
@DataProvider
	public Object[][] getdata() {
		return excelDataProvider.getExcelTestData("DTT_login");
	}

    @Test(dataProvider = "getdata")
	public void verifyLoginFuctionalityDDTest(Object username,Object password) {
		LoginPage login = new LoginPage(driver);
		login.setUsername((String)username);
		login.setPassword((String)password);
		login.clickonLoginBtn();
	}
	
	
//	@Test
//	public void verifyLoginFuctionalityTC001() {
//		LoginPage login = new LoginPage(driver);
//		login.setUsername(excelDataProvider.getStringcellValue("login", 1, 0));
//		login.setPassword(excelDataProvider.getStringcellValue("login", 1, 1));
//		login.clickonLoginBtn();
//}
}