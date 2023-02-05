package common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;
import testbase.TestBase;

public class Utility extends TestBase {

	public static void scrollToElement(WebElement ele)
	{
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(false);", ele);//default is true
		//false brings the element at the bottom.
		je.executeScript("window.scrollBy(0,300)", "");
		
	}
	
	public static void clickOnElementJS(WebElement ele)
	{
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click();", ele);
		
		
	}

	public static void scrollToElementActions(WebElement ele)
	{
		Actions ac = new Actions(driver);
		ac.scrollToElement(ele).scrollByAmount(200, 400).perform();
		
	}
	
	public static void captureScreenAsFile() throws IOException
	{
		
		File f = new File("./Screenshot");
		if(!f.isDirectory())
		{
			f.mkdir();
		}
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File(f+"/"+getDate()+"_image.jpg"));//jpg, png
	}
	
	public static String captureScreenAsFileName() throws IOException
	{
		
		File f = new File("./Screenshot");
		if(!f.isDirectory())
		{
			f.mkdir();
		}
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File(f+"/"+getDate()+"_image.jpg"));//jpg, png
		return f+"/"+getDate()+"_image.jpg";
	}
	
	public static String getDate()
	{
		Date dt = new Date();
		System.out.println(dt);
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY_MM_d_HH_mm_ss_SSS");
		String date = sdf.format(dt);
		return date;
	}
	
	public static String attacheSceenshot() throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		String file = ts.getScreenshotAs(OutputType.BASE64);
		//String tag = "<img src=\"data:image/png;base64,"+file+"\" height=\"600\" width=\"800\" />";
		//Reporter.log(tag);
		return file;
	}
}
