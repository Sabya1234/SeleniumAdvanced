package com.seleniumPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchtoSpecificWindow {
	public static WebDriver driver;

	public static void main(String[] args) {
		

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		String parentWindowHandle= driver.getWindowHandle();
		List<WebElement> icons = driver.findElements(By.xpath("//div[@id='social-icons']/a"));
		System.out.println(icons.size());
		for(int i=0;i<icons.size();i++)
		{
			icons.get(i).click();
		}
		
		Set<String> childWindowHandles = driver.getWindowHandles();
		List<String> handles = new ArrayList<String>(childWindowHandles);
		
		if(switchToChildWindow("Facebook",handles))
		{
			System.out.println(driver.getCurrentUrl()+"    "+driver.getTitle());
		}
		closeAllChildWindow(parentWindowHandle,handles);
		switchToParentWindow(parentWindowHandle);
		System.out.println(driver.getCurrentUrl());
		
		
	}
	
	
	public static void closeAllChildWindow(String parentId,List<String> handles)
	{
		for(String e: handles)
		{
			if(!e.equals(parentId))
			{
				driver.switchTo().window(e);
				driver.close();
			}
		}
		
	}
	
	public static void switchToParentWindow(String parentWindowId)
	{
		driver.switchTo().window(parentWindowId);
	}
		
		public static boolean switchToChildWindow(String title,List<String> handles)
		{
			for(String h: handles)
			{
				String pagetitle=driver.switchTo().window(h).getTitle();
				if(pagetitle.contains(title))
				{
					System.out.println("found the right window--");
					return true;
				}
				
			}
			return false;
			
		}


	

}
