package com.seleniumPractice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindBrokenLinksUsingJavaStream {

	public static void main(String[] args) {
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("The no of links "+links.size());
		
		List<String> urls = new ArrayList<String>();
		for(WebElement e: links)
		{
			String url=e.getAttribute("href");
			urls.add(url);
			//checkBrokenLink(url);
		}
		
		//max 45 sec 
		long startTime =System.currentTimeMillis();
		urls.parallelStream().forEach(e->checkBrokenLink(e));
        long endTime=System.currentTimeMillis();
        System.out.println("Total Execution Time--->"+(startTime-endTime));
		
		//Total Execution Time--->-243230
        /*long startTime =System.currentTimeMillis();
		urls.stream().forEach(e->checkBrokenLink(e));
        long endTime=System.currentTimeMillis();
        System.out.println("Total Execution Time--->"+(startTime-endTime));*/
        
		driver.quit();
	}
	
	public static void checkBrokenLink(String linkUrl)
	{
		try {
			URL url = new URL(linkUrl);
			  HttpURLConnection huc =(HttpURLConnection) url.openConnection();
			  huc.setConnectTimeout(5000);
			  huc.connect();
			  
			  if(huc.getResponseCode()>=400)
			  {
				  System.out.println(linkUrl+"  "+huc.getResponseMessage()+"This is broken link");
			  }
			  else {
				  System.out.println(linkUrl+"  "+huc.getResponseMessage());
			  }
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
