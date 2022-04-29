package com.seleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NestedIframeHandle {
	
	public static void main(String []args)
	{
	
	String text="Sabya";
	WebDriver driver;
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.get("https://selectorshub.com/xpath-practice-page/");
	
	driver.switchTo().frame("pact1");
	
	//switch into nested child frame
	driver.switchTo().frame("pact2");
	
	driver.findElement(By.xpath("//input[@id='jex']")).sendKeys(text);
	
	driver.switchTo().parentFrame();
	
	System.out.println("we are on parent frame");
	
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	
	WebElement ele=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[contains(text(),'frame')]")));
    boolean present=ele.isDisplayed();
    System.out.println(present);
	//switch back to main HTML
	driver.switchTo().defaultContent();
	
	System.out.println("We are on main HTML");
	driver.findElement(By.xpath("//h3[contains(text(),'practice')]")).isDisplayed();
	driver.quit();

}
}
