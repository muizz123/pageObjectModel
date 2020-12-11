package com.crm.qa.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	 LoginPage logPag;
	 HomePage homePage;
	public LoginPageTest() throws IOException {
	super();
	}

	@BeforeMethod
	public void setup() throws IOException  {
		
	      initilization();
	      logPag = new LoginPage();
		
	}
	@Test(priority = 1)
	public void loginPageTitle() {
		String titleName = logPag.validatingLogingPage();
		
		Assert.assertEquals(titleName,"CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	@Test (priority = 2)
	public void logotest() {
		boolean flag = logPag.validatingLogoImage();
		Assert.assertTrue(flag);
	}
	@Test (priority = 2)
	public void loginTest() throws IOException {
		homePage = logPag.login(pro.getProperty("userName"), pro.getProperty("password"));
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
