package com.inetbanking.pageobject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inetbanking.utility.Helper;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// Object reposertory

	@FindBy(linkText = "New Customer")
	WebElement newcustomerLink;

	@FindBy(linkText = "Edit Customer")
	WebElement editcustomerLink;

	@FindBy(linkText = "Delete Customer")
	WebElement deletecustomerLink;

	@FindBy(linkText = "New Account")
	WebElement newaccountLink;

	@FindBy(linkText = "Log out")
	WebElement logoutLink;

	public AddNewCustomerPage clickonNewCustomerLink() {
		try {
			newcustomerLink.click();
			Thread.sleep(5000);
			driver.switchTo().frame(driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0")));
			driver.switchTo().frame(driver.findElement(By.id("ad_iframe")));
			driver.findElement(By.xpath("//div[@id='dismiss-button']/div/span")).click();
			driver.switchTo().defaultContent();
			return new AddNewCustomerPage(driver);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public NewAccountPage clickonNewAccountLink() {
		try {
			newaccountLink.click();
			return new NewAccountPage();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public EditCustomerPage clickonEditCustomerLink() {
		try {
			editcustomerLink.click();
			return new EditCustomerPage();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void clickonLogoutLink() {
		try {
			logoutLink.click();
         if(Helper.isAlertisPresent(driver)) {
        	Alert alert = driver.switchTo().alert();
        	 System.out.println(driver.getTitle());
        	 alert.accept();
         }
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
