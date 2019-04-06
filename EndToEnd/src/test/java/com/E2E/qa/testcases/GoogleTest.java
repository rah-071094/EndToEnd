package com.E2E.qa.testcases;
import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.E2E.qa.base.TestBase;

public class GoogleTest extends TestBase 
{
	
	 @Test
	  public void GoogleSearch()
	  {
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Java");
			
			List <WebElement> searchlist = driver.findElements(By.xpath("//ul[@class='erkvQe']//li/descendant::div[@class='sbtc']"));
			
			for(int i=0; i<searchlist.size();i++)
			{
				if(searchlist.get(i).getText().contains("javascript"))
				{
					searchlist.get(i).click();
					break;
				}
			}
	  }
	  
	  @Test
	  public void GoogleTitle() 
	  { 
		  String title = driver.getTitle();
		  assertEquals(title, "1Google"); 
	  }
	  
	  
	  @Test
	  public void GoogleIcon() 
	  {
		  boolean b = driver.findElement(By.xpath("//img[@id='hplogo']")).isDisplayed();
		  assertEquals(b, true);
	  }
	  
	  @BeforeMethod
	  public void beforeMethod() {
		    System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver(); //Launching
			driver.manage().window().maximize(); //Maximizing window
			driver.get("https://www.google.co.in/"); //Setting URL

			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); //Maximum wait for page to load
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //Maximum wait for a webelement to load
	  }

	  @AfterMethod
	  public void afterMethod() {
		  driver.quit();
	  }

}
