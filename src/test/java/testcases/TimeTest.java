package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.DashboardPage;
import pages.LoginPage;
import pages.TimePage;
import testbase.ExtentReportsGeneration;
import testbase.TestBase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class TimeTest {
	
	private static Logger log = Logger.getLogger(TimeTest.class);
	private WebDriver dr;
	private TestBase tb;
	private LoginPage lp;
	private DashboardPage dp;
	private TimePage tmp;
  @Test
  public void getNamesTable_005(ITestNGMethod it) throws IOException {
	  ExtentReportsGeneration.addTest("Get Names in Table");
	  Assert.assertTrue(dp.isDashboadDisplayed());
	  tmp.clickOnTime();
	  List<String> act = tmp.getNamesFromTableColumn();
	  for(String s: act)
	  {
		  if(s.equals("Charlie Carter"))
		  {
			  Assert.assertTrue(true);
			  ExtentReportsGeneration.addTestPass("Matched: "+s);
			  break;
		  }
	  }
  }
  
 
  @BeforeClass
  public void beforeClass() throws IOException {
	  tb = new TestBase();
	  dr = tb.getDriver();
	  lp = new LoginPage(dr);
	  dp = new DashboardPage(dr);
	  tmp = new TimePage(dr);
	  lp.loginToApp("Admin", "admin123");
  }

  @AfterClass
  public void afterClass() {
	  
	  tb.closeDriver();
  }
	/*
	 * @BeforeSuite() public void beforeSuite() {
	 * System.out.println("Before Suite");
	 * ExtentReportsGeneration.initializeReport("Sprint 1"); }
	 * 
	 * @AfterSuite() public void afterSuite() {
	 * ExtentReportsGeneration.completeReport(); }
	 */
}
