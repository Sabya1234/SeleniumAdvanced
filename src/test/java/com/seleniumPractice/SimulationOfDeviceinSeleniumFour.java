package com.seleniumPractice;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v97.emulation.Emulation;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SimulationOfDeviceinSeleniumFour {

	public static void main(String[] args) {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		DevTools devTools=((ChromeDriver)driver).getDevTools();
		devTools.createSession();
		Map<String, Object> mp= new HashMap<String, Object>()
				{{
					put("width",360);
					put("height",640);
					put("mobile",true);
					put("deviceScaleFactor",95);
				}};
		((ChromeDriver)driver).executeCdpCommand("Emulation.setDeviceMetricsOverride", mp);
		driver.get("https://www.google.com");
		// TODO Auto-generated method stub

	}

}
