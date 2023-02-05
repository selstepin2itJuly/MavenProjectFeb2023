package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.DashboardPage;
import pages.LoginPage;
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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class DashboardTest {
	
	private static Logger log = Logger.getLogger(DashboardTest.class);
	private WebDriver dr;
	private TestBase tb;
	private LoginPage lp;
	private DashboardPage dp;
  @Test
  public void getDashboardQuickLaunchItems_004() throws IOException {
	  ExtentReportsGeneration.addTest("Get Dashboard Quick Launch Items - 004");
	  Assert.assertTrue(dp.isDashboadDisplayed());
	  List<String> act = dp.getSideMenuItems();
	  List<String> exp = new ArrayList<String>();
	  exp.add("Admin");
	  exp.add("PIM");
	  exp.add("Leave");
	  exp.add("Time");
	  exp.add("recruitment");
	  exp.add("My Info");
	  exp.add("Performance");
	  //exp.add("Dashboard");
	  exp.add("Directory");
	  exp.add("maintenance");
	  exp.add("Buzz");
	  //Assert.assertEquals(act, exp);
	  SoftAssert sft = new SoftAssert();
	  for(int i=0; i<act.size()-1;i++)
	  {
		  sft.assertEquals(act.get(i), exp.get(i));
	  }
	  sft.assertAll();
	  
  }
  
  @Test
  public void getDashboardQuickLaunchItemsCount_006() throws IOException {
	  ExtentReportsGeneration.addTest("Get Dashboard Quick Launch Items Count - 006");
	  Assert.assertTrue(dp.isDashboadDisplayed());
	  Assert.assertEquals(dp.getSideMenuItemCount(), 10);
  }
  @BeforeClass
  public void beforeClass() throws IOException {
	  tb = new TestBase();
	  dr = tb.getDriver();
	  lp = new LoginPage(dr);
	  dp = new DashboardPage(dr);
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
