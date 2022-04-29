package com.seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IdentifyElementInWebTable {
	
	public static WebDriver driver;
	public static void main(String [] args)
	{
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		System.out.println(getElementwithRowColumn("Germany"));
		
	}
	
	public static  boolean getElementwithRowColumn(String element)
	{
		boolean flag=false;
		int rowCount=driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		int columnCount=driver.findElements(By.xpath("//table[@id='customers']//th")).size();
		
		
		for(int i=1;i<rowCount;i++)
		{
			for(int j=1;j<=columnCount;j++)
			{
				
				String value=driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+(i+1)+"]/td["+j+"]")).getText();
				//System.out.println(value);
				if(value.equalsIgnoreCase(element))
				{
					System.out.println(value);
					flag=true;
					System.out.println("The row is:"+(i+1)+"The column is"+j);
					break;
				}
			}
		}
		if(flag)
		{
			return true;
		}
		return flag;

		
	}

}
