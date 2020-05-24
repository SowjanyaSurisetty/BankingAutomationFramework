package com.netBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.netBanking.pageObjects.LoginPage;
import com.netBanking.utilities.XLUtils;


public class Tc_Login_DDT_02 extends BaseClass
{
	@Test(dataProvider="Log")
	public void loginDDT(String user,String pwd) throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		Thread.sleep(3000);
		lp.setUserName(user);
		logger.info("username provided");
		Thread.sleep(3000);
		lp.setPassword(pwd);
		logger.info("password provided");
		Thread.sleep(3000);
		lp.Login();
		
		
		logger.info("Login Clicked");
		System.out.println(driver.getTitle());
		String er=driver.getTitle();
		String ar="OrangeHRM";
		System.out.println(ar);
		if(ar.equals(er))
		{
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
			Thread.sleep(3000);
			lp.welcomeLink();
			Thread.sleep(3000);
			lp.LogoutLink();
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Invalid Credentials");
			
		}
	
	}		
	
	//read data from excel file and store the data in two dimensional array

	@DataProvider(name="Log")
	String[][] getData() throws IOException
	{
		//XLUtils utils=new XLUtils();
		String path=System.getProperty("user.dir")+"/src/test/java/com/netBanking/testData/Log.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String log[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				log[i-1][j]=XLUtils.getCellData(path,"Sheet1",i,j);//1,0
			}
		}
			return log;	
	}
}
