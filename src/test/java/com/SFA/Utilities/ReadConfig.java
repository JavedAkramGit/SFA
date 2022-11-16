package com.SFA.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {

	
	
	Properties properties;
	String Path = "/Users/mohanned/eclipse-workspace/SFA/Configuration/config.properties";
	
	//Constructor
	public ReadConfig() {
		
		try {
		properties = new Properties();
		FileInputStream fis = new FileInputStream(Path);
		properties.load(fis);
		
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public String getBaseUrl()
	{
		String value = properties.getProperty("baseUrl");
		if(value!=null)
			return value;
		else 
			throw new RuntimeException("URL not specified in config file.");
		
		
	}
	
	
	public String getbrowser()
	{
		
		String value = properties.getProperty("browser");
		if(value!=null)
		return value;
		else
			throw new RuntimeException("Browser value not specified in config file.");
	}
	
	
	
}
