package com.netBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.netBanking.pageObjects.LoginPage;



public class Tc_LoginTest_01 extends BaseClass{
	
	@Test
	public void loginTest() throws InterruptedException, IOException 
	{
		//driver.get(baseURL);
		logger.info("URL is OPENED");
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Entered Username");
		
		lp.setPassword(password);
		logger.info("entered Password");
		
		lp.Login();
		logger.info("Login Clicked");
		System.out.println(driver.getTitle());
		String er=driver.getTitle();
		String ar="OrangeHRM123";
		System.out.println(ar);
		if(ar.equals(er))
		{
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login Test Failed");
		}
	}

	
}
