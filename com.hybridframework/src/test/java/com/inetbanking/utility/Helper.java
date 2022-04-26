package com.inetbanking.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	
	public static String capturescreenshot(WebDriver driver) {
	   String screenpath = System.getProperty("user.dir")+"//Screenshots//inetbanking_"+getCurrentDateTime()+".png";
		try {
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(screenpath));
		System.out.println("screenshot capture");
		return screenpath;
		} catch (Exception e) {
			System.out.println("screen shot not captured");
			return null;
			
			
		}
	}

	public static String getCurrentDateTime() {
	       SimpleDateFormat customdate = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
	       Date currentdate = new Date();
	       return customdate.format(currentdate);
	       
	}
	public static boolean isAlertisPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;

		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public static String getRandomString() {
		return RandomStringUtils.random(8);
	}
}
