
package com.automation.Search;

import java.io.File;
import java.lang.Thread;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Seleniumsearch {

	WebDriver pageUnderTest = null;
	

	public WebDriver getDriverHandle(String stringWebSiteURL)
	{
		String exePath = "D:\\Devops\\Chromedriver\\chromedriver.exe";
		ChromeDriverService.Builder serviceBuilder = new ChromeDriverService.Builder();
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		serviceBuilder.withLogFile(new File("D:\\Devops\\Logs\\logFile.txt"));
		driver.get(stringWebSiteURL);
		this.pageUnderTest=driver;
		return driver;
	}
	
	
	public static void main(String args[])
	{
		Seleniumsearch myPageRef = new Seleniumsearch();
		
		WebDriver webDriver = myPageRef.getDriverHandle("https://www.google.com/");
		
		//Browser Commands
		System.out.println("Title was "+webDriver.getTitle());
		System.out.println("CurrentURL was "+webDriver.getCurrentUrl());
		//System.out.println("PageSource was "+webDriver.getPageSource());
		
		//Navigational Commands
				//System.out.println("Going to click Todays Deals");
				//webDriver.findElement(By.linkText("Today's Deals")).click();
				
		//navigate to selenium
		//searchBox.click();
		WebElement searchBox= webDriver.findElement(By.name("q"));
		
		//Click on the searchBox
		searchBox.click();
		searchBox.sendKeys("Selenium");
		
		WebElement searchButton= webDriver.findElement(By.xpath("//*[@id='tsf']/div[2]/div[3]/center/input[1]"));
		//*[@id="nav-search"]/form/div[2]/div/input
		//Click on the searchBox
		searchButton.click();   //*[@id="tsf"]/div[2]/div[3]/center/input[1]
		Thread thread=new Thread();
		
		try
		{
		thread.sleep(5000); 
		}
		catch(Exception ex)
		{
		}
		webDriver.navigate().back();
		//idle for 30sec
		
		
		
		//       //*[@id="nav-search"]/form/div[2]/div/input
		//WebElement searchButton= webDriver.findElement(By.xpath("//*[@id='nav-search']/form/div[2]/div/input"));
		//*[@id="nav-search"]/form/div[2]/div/input
		//Click on the searchBox
		//searchButton.click();
	}
	
}
