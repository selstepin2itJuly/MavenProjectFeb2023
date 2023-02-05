package testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import testbase.ExtentReportsGeneration;
import testbase.TestBase;

public class LoginTest {

	private static Logger log = Logger.getLogger(LoginTest.class);
	private WebDriver dr;
	TestBase tb = new TestBase();
	LoginPage lp;
	DashboardPage dp;
	@Test
	public void loginSuccessful_001(ITestResult it) throws IOException
	{
		ExtentReportsGeneration.addTest("Login SuccessFul - 001");
		lp.enterUsername("Admin")
		.enterPassword("admin123")
		.clickLogin();
		Assert.assertTrue(dp.isDashboadDisplayed());
		 if(!it.isSuccess())
		  {
			  ExtentReportsGeneration.addTestFail("Failed");
		  }
	}
	
	@Test
	public void loginUnSuccessful_002(ITestResult it) throws IOException
	{
		ExtentReportsGeneration.addTest("Login UnSuccessFul - 002");
		lp.enterUsername("Admin123")
		.enterPassword("admin123")
		.clickLogin();
		Assert.assertFalse(dp.isDashboadDisplayed());
		 if(!it.isSuccess())
		  {
			  ExtentReportsGeneration.addTestFail("Failed");
		  }
	}
	
	@BeforeMethod
	public void beforeMethod() throws IOException
	{
		dr = tb.getDriver();
		lp = new LoginPage(dr);
		dp = new DashboardPage(dr);
	}
	@AfterMethod
	public void afterMethod()
	{
		
		//dp.logout();
		tb.closeDriver();
	}
	@BeforeSuite(alwaysRun=true)
	public void beforeSuite()
	{
		ExtentReportsGeneration.initializeReport("Sprint 1");
	}
	
	@AfterSuite(alwaysRun=true)
	public void afterSuite()
	{
		ExtentReportsGeneration.completeReport();
	}
	
}
