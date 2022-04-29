package com.seleniumPractice;

import java.util.*;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FIndValuesFromDynamicWebTable {

	public static void main(String[] args)  {
		try {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		/*ChromeOptions opt= new ChromeOptions();
		String userAgent = "Chrome/97.0.4692.99";
		opt.addArguments(String.format("user-agent=%s", userAgent));*/
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		//driver.manage().window().setSize(new Dimension(1920,1080));
		driver.get("https://www.nseindia.com/");
		driver.manage().deleteAllCookies();
	
		 By ele=By.xpath("//div[@role='tablist']//a[text()='Equities']");
		 
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
		
		
		WebDriverWait waite= new WebDriverWait(driver,Duration.ofSeconds(20));
		
		waite.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='topgainer-Table']")));
		List<WebElement>totalData=driver.findElements(By.xpath("//table[@id='topgainer-Table']//tbody//tr"));
		
		for(WebElement elem:totalData)
		{
			System.out.println(elem.getText());
		}
		
		List<WebElement> companyNames = driver.findElements(By.xpath("//table[@id='topgainer-Table']//tbody/tr/td[1]"));
		List<WebElement> AssetValues = driver.findElements(By.xpath("//table[@id='topgainer-Table']//tbody/tr/td[8]"));
		
		for(int i=0;i<companyNames.size();i++)
		{
			String name="HSCL";
			
			if(companyNames.get(i).getText().equals(name))
			{
				System.out.println("the correspoding value is"+AssetValues.get(i).getText());
			}
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		

	}

}
