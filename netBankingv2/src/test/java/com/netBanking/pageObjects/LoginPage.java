package com.netBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver =rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="txtUsername")
	WebElement txtUsername;
	
	@FindBy(id="txtPassword")
	WebElement txtPassword;
	
	@FindBy(name="Submit")
	WebElement btnLogin;
	
	//@FindBy(xpath="//*[text()='Invalid credentials']")
	//WebElement invalid;
	
	@FindBy(id="welcome")
	WebElement wel;
	
	@FindBy(xpath="//*[text()='Logout']")
	WebElement logout;
	
	
	
	public void setUserName(String uname)
	{
		txtUsername.sendKeys(uname);
	}

	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	public void Login()
	{
		btnLogin.click();
	}
	/*public void invalidData(String id)
	{
		String s=invalid.getText();
		System.out.println(s);
	}*/
	public void welcomeLink()
	{
		wel.click();
	}
	public void LogoutLink()
	{
		logout.click();
	}
}
