package com.seleniumPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropdownWithMouseover {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver;

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		try {

			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();

			driver.get("https://selectorshub.com/xpath-practice-page/");

			WebElement dropDown = driver.findElement(By.xpath("//div[@class='dropdown']"));

			Actions act = new Actions(driver);
			act.moveToElement(dropDown).perform();
			Thread.sleep(3000);

			// xpath chaining
			List<WebElement> dropDownContents = dropDown.findElements(By.xpath(".//a"));
			// List<WebElement>
			// dropDownContents=driver.findElements(By.xpath("//div[@class='dropdown']/button/following-sibling::div/a"));

			//printing no of drop down option 
			for (WebElement ele : dropDownContents) {
				System.out.println(ele.getText());
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			driver.quit();
		}

	}

}
