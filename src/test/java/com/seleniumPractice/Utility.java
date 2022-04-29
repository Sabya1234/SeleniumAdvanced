package com.seleniumPractice;

import java.time.LocalDate;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Utility {
	
	public static void selectDate(WebDriver driver,String dateTobeselect,String monthTobeSelect,String yeartobeselect) throws InterruptedException
	{
		boolean status=false;
		int currentYear =LocalDate.now().getYear();
		while(!status)
		{
			String month=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String year=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			if(Integer.parseInt(dateTobeselect)>31)
			{
				System.out.println("not valid");
				break;
			}
			
			if(monthTobeSelect.equalsIgnoreCase("February") && Integer.parseInt(dateTobeselect)>29)
            {
			  break;
		     }
			
			
			
			if(Integer.parseInt(yeartobeselect) <= currentYear)
			{
				if(month.contains(monthTobeSelect) && year.contains(yeartobeselect))
				{
					driver.findElement(By.xpath("//a[text()='"+dateTobeselect+"']")).click();
					status=true;
					Thread.sleep(2000);
					break;
				}
				else {
					driver.findElement(By.xpath("//span[text()='Prev']")).click();
				}
			}
			else {
				
				if(month.contains(monthTobeSelect) && year.contains(yeartobeselect))
				{
					status=true;
					driver.findElement(By.xpath("//a[text()='"+dateTobeselect+"']")).click();
					Thread.sleep(2000);
					break;
				}
				else {
					driver.findElement(By.xpath("//span[text()='Next']")).click();
				}
			}
		}
	}

}
