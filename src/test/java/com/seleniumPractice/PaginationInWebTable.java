package com.seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class PaginationInWebTable {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		driver.manage().deleteAllCookies();
		selectCity("Siliguri","mac");
		
		
	}
	
	public static  void selectCity(String cityName,String os) throws InterruptedException
	{
		while(true)
		{
			if(driver.findElements(By.xpath("//td[text()='"+cityName+"']")).size()>0)
			{
				Thread.sleep(2000);
				WebElement ele =driver.findElement(By.xpath("//td[text()='"+cityName+"']"));
				//driver.findElement(By.xpath("//td[text()='"+cityName+"']/preceding-sibling::td/child::input[@type='checkbox']")).click();
				driver.findElement(with(By.xpath("//input[@type='checkbox']")).toLeftOf(ele)).click();
				
				fetchOS(cityName,os);
				break;
			}
			else {
				WebElement ele =driver.findElement(By.linkText("Next"));
				if(ele.getAttribute("class").contains("disabled"))
				{
					System.out.println("Pagination over");
				}
				ele.click();
				Thread.sleep(500);
			}
		}
		
		
		
	}
	
	public static void fetchOS(String cityName,String os)
	{
		boolean a=false;
		String s =driver.findElement(By.xpath("//td[text()='"+cityName+"']/preceding-sibling::td[text()='"+os+"']")).getText();
		if(s.equalsIgnoreCase(os))
		{
			System.out.println(s);
		}
		
	}

}
