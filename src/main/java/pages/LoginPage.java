package pages;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;

import testbase.ExtentReportsGeneration;


public class LoginPage {
	private static Logger log = Logger.getLogger(LoginPage.class);
	
	//private WebDriver dr; 
	
	/*
	* constructor method for Login Page
	*
	*
	*/
	public LoginPage(WebDriver driver)
	{
	//	this.dr=driver;
		PageFactory.initElements(driver, this);
	}
	
	//FindBy, FindBys (and - all elements are mandatory), FindAll (OR - any one)
	
	@FindAll({@FindBy(how=How.NAME, using="username"), 
		@FindBy(how=How.CSS, using="input[placeholder='Usernae']")})
	private WebElement user;
	
	@FindBy(name="password")
	private WebElement pass;
	
	@FindBy(css="button[type='submit']")
	private WebElement loginButton;
	
	public LoginPage enterUsername(String username) throws IOException
	{	
		ExtentReportsGeneration.addNode("Enter username");
		user.clear();
		user.sendKeys(username);
		log.info(username+" At Locator:"+user);
		return this;
	}
	public LoginPage enterPassword(String password) throws IOException
	{
		ExtentReportsGeneration.addNode("Enter Password");
		pass.clear();
		pass.sendKeys(password);
		log.info(password+" At Locator:"+pass);
		return this;
	}
	public LoginPage clickLogin() throws IOException
	{
		ExtentReportsGeneration.addNode("Click On Login");
		loginButton.click();
		log.info("Clicked At Locator:"+loginButton);
		return this;
	}
	
	public void loginToApp(String usr, String pwd)
	{
		user.sendKeys(usr);
		pass.sendKeys(pwd);
		loginButton.click();
	}
}
