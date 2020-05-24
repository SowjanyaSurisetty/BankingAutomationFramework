package com.netBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");//src is a variable which is refering to cofig file

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();//pro is refering to properties class
			pro.load(fis);//loads the file
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	//we have to read each and every variable with methods
	public String getApplicationURL()//give a relevent name
	{
		String url=pro.getProperty("baseURL");//refers to that variable from config.properties
		return url;
	}
	
	public String getUsername()
	{
	String username=pro.getProperty("username");
	return username;
	}
	
	public String getPassword()
	{
	String password=pro.getProperty("password");
	return password;
	}

	public String getChromePath()
	{
	String chromepath=pro.getProperty("chromepath");
	return chromepath;
	}
	
	public String getIEPath()
	{
	String iepath=pro.getProperty("iepath");
	return iepath;
	}
	
	public String getFirefoxPath()
	{
	String firefoxpath=pro.getProperty("firefoxpath");
	return firefoxpath;
	}

}
