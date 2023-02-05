package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.ExtentReportsGeneration;

public class TimePage {

	public TimePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(@class,'oxd-main-menu-item')]/span[text()='Time']")
	WebElement time;
	
	@FindBy(xpath="//div[@class='oxd-table-body']/div/div/div[1]")
	private List<WebElement> nameInTableCol;
	
	public void clickOnTime() throws IOException
	{
		ExtentReportsGeneration.addNode("Click on Time");
		time.click();
	}

	public List<String> getNamesFromTableColumn() throws IOException
	{
		ExtentReportsGeneration.addNode("Get the List of names in table");
		List<String> names = new ArrayList<String>();
		for(WebElement e: nameInTableCol)
		{
			names.add(e.getText());
		}
		return names;
	}
}
