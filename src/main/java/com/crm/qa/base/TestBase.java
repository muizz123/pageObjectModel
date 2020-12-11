package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties pro; 
	
	public TestBase() throws IOException  {
		
		 pro = new Properties();
		FileInputStream fis = new FileInputStream("E:\\abdullah\\pageObjectModel\\src\\main\\java\\com\\crm\\cofig\\config.properties");
		pro.load(fis);
	}
	
	public static void initilization() {
		String browserName = pro.getProperty("browser");
		String urlName = pro.getProperty("url");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			driver= new ChromeDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.pageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicitlyWait, TimeUnit.SECONDS);
		driver.get(urlName);
	}
}
