package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import testbase.ExtentReportsGeneration;

public class DashboardPage {
	private static Logger log = Logger.getLogger(DashboardPage.class);
	
	public DashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Dashboard']")
	private WebElement dashboard;
	
	@FindBy(css="div[class='oxd-topbar-header-userarea'] i[class$='oxd-userdropdown-icon']")
	private WebElement icon;
	
	@FindBy(linkText="Logout")
	private WebElement logout;
	
	@FindBy(css="a[class='oxd-main-menu-item'] span")
	private List<WebElement> sidemenu;
	
	public Boolean isDashboadDisplayed() throws IOException
	{
		ExtentReportsGeneration.addNode("Is Dashboard Display");
		boolean b=false;
		try {
			b = dashboard.isDisplayed();
			log.info("Dashboard Locator:"+dashboard+" - "+b);
		}catch(Exception e)
		{
			//ExtentReportsGeneration.addNodeFail("Dashboard not displayed");
			log.info(e.getMessage());
		}finally {
			log.info("Dashboard Locator:"+dashboard+" - "+b);
			
		}
		return b;
	}
	
	public void logout()
	{
		try {
			log.info("Logout icon:"+icon);
			icon.click();
			
		}catch(Exception e)
		{
			log.info("Logout icon:"+icon);
			
		}
		try {
			log.info("Logout option:"+logout);
			logout.click();
		}catch(Exception e)
		{
			log.info("Logout option:"+logout);
		}
		
	}
	
	/* method to get side menu items
	 * 
	 * @return List<String> 
	 */
	public List<String> getSideMenuItems() throws IOException
	{
		ExtentReportsGeneration.addNode("Get Side Menu items");
		List<String> act = new ArrayList<String>();
		for(WebElement e:sidemenu)
		{
			act.add(e.getText().trim());
		}
				
		return act;
	}
	
	/*
	 * method to return count of side menu items
	 *	@return int
	 */
	public int getSideMenuItemCount() throws IOException
	{
		ExtentReportsGeneration.addNode("Get Side Menu item count");
		return sidemenu.size();
	}
}
