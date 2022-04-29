package com.seleniumPractice;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v97.network.Network;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestOnCDPUserAgents {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		// TODO Auto-generated method stub
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        DevTools devTools= ((ChromeDriver) driver).getDevTools();

		String fakeAgent="Mozilla/5.0 (iPhone; CPU iPhone OS 10_3_1 like Mac OS X) AppleWebKit/603.1.30 (KHTML, like Gecko) Version/10.0 Mobile/14E304 Safari/602.1";
	    devTools.createSession();
		devTools.send(Network.setUserAgentOverride(fakeAgent, Optional.empty(), Optional.empty(), Optional.empty()));
		driver.get("https://www.amazon.com");
		Thread.sleep(20000);
	}

}
