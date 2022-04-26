package com.inetbanking.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage {

	WebDriver driver;

	public AddNewCustomerPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		// a[text()='New Customer']
	}

	@FindBy(name = "name")
	WebElement custName;

	@FindBy(xpath = "//input[@type='radio' and @value='m']")
	WebElement maleBtn;

	@FindBy(xpath = "//input[@type='radio' and @value='f']")
	WebElement femaleBtn;

	@FindBy(name = "dob")
	WebElement custDob;

	@FindBy(name = "addr")
	WebElement custAddress;

	@FindBy(name = "city")
	WebElement custCity;

	@FindBy(name = "state")
	WebElement custState;

	@FindBy(name = "pinno")
	WebElement custPin;

	@FindBy(name = "telephoneno")
	WebElement custTelephone;

	@FindBy(name = "emailid")
	WebElement custEmailid;

	@FindBy(name = "password")
	WebElement custPassword;

	@FindBy(name = "sub")
	WebElement custSubmit;

	public void setCustomerName(String customername) {
		custName.clear();
		custName.sendKeys(customername);
	}

	public void clickOnGenderRadioBtn(String gender) {
		if (gender.equals("male")) {
			maleBtn.click();
		} else {
			femaleBtn.click();
		}
	}

	public void setDateOfBirth(String dob) {
		custDob.sendKeys(dob);
	}

	public void setAddress(String address) {
		custAddress.clear();
		custAddress.sendKeys(address);
	}

	public void setCity(String City) {
		custCity.clear();
		custCity.sendKeys(City);
	}

	public void setState(String state) {
		custState.clear();
		custState.sendKeys(state);
	}

	public void setPin(String pin) {
		custPin.clear();
		custPin.sendKeys(pin);
	}

	public void setTelephoneNo(String telephone) {
		custTelephone.clear();
		custTelephone.sendKeys(telephone);
	}

	public void setEmailid(String email) {
		custEmailid.clear();
		custEmailid.sendKeys(email);
	}

	public void setPassword(String password) {
		custPassword.clear();
		custPassword.sendKeys(password);
	}

	public void clickOnsubmitBtn() {
		custSubmit.click();

	}
}
