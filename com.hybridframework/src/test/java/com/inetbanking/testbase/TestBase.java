
package com.inetbanking.testbase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.inetbanking.utility.ConfigDataProvider;
import com.inetbanking.utility.ExcelDataProvider;
import com.inetbanking.utility.Helper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public WebDriver driver;

	static String configdatapath  = "./Configure/config.properties";
	static String exceldataproviderpath="./TestData/data.xlsx";
	
	public ConfigDataProvider configdataprovider;
	public ExcelDataProvider excelDataProvider;
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extentReport;
	public ExtentTest extentTest;
	
	@BeforeSuite
	public void init()
	{
		configdataprovider = new ConfigDataProvider(configdatapath);
		excelDataProvider=new ExcelDataProvider(exceldataproviderpath);
		
		String extentReportPath= System.getProperty("user.dir")+"//Reports//inetbanking_report_"
				+Helper.getCurrentDateTime()+ ".html";
		htmlReporter=new ExtentHtmlReporter(extentReportPath);
		
		htmlReporter.config().setDocumentTitle("Automation Test Reports");
		htmlReporter.config().setReportName("Functinal Test Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extentReport=new ExtentReports();
		extentReport.attachReporter(htmlReporter);
		
		extentReport.setSystemInfo("Hostname", "Local Host");
		extentReport.setSystemInfo("OS", "Windows10");
		extentReport.setSystemInfo("Browser", "Chrome");
		extentReport.setSystemInfo("Environment", "Regression");
		extentReport.setSystemInfo("Tester Name", "Venkey");
		
	}
	@BeforeMethod
	@Parameters({ "browser" })
	public void setUp(@Optional("chrome")String brName) {
		if (brName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (brName.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("browser not match plz chech expected browser");
		}
		driver.manage().window().maximize();
		driver.get(configdataprovider.getUrl());
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException  {

		if(result.getStatus()==ITestResult.FAILURE) {
			extentTest.fail("Test Case Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturescreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(Status.SKIP,"test case skip");
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(Status.PASS,"test case pass");
		}
		driver.quit();
	}
	@AfterTest
	public void flushReport() {
		extentReport.flush();
	}
}
