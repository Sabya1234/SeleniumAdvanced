package com.seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CapitelLetterThroughSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.tutorialspoint.com/questions/index.php");
		driver.manage().deleteAllCookies();
		WebElement ele = driver.findElement(By.xpath("//input[@type='text']"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().keyDown(Keys.SHIFT).sendKeys("tutorialpoint").keyUp(Keys.SHIFT).sendKeys(Keys.ENTER).build().perform();
		
		
	}

}
