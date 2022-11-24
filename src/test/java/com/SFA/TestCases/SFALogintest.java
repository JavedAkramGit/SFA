package com.SFA.TestCases;

import java.time.Duration;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.SFA.PageObjects.LaunchPage;
import com.SFA.PageObjects.LoginPage;
import com.SFA.Utilities.ReadExcel;

public class SFALogintest extends BaseClass{
	
	ReadExcel readexcel;
	
	@Test(dataProvider = "LoginDataProvider" , retryAnalyzer = com.SFA.Utilities.RetryAnalayzer.class)
	public void loginTest(String username, String password)
	{
		
		
		//Open the Url
		driver.get(Url);
		driver.manage().addCookie(new Cookie("MCPopupClosed", "yes"));

		logger.info("Url opened");
		
		
		//Click on Login Button
		LaunchPage lp = new LaunchPage(driver);
		
		driver.manage().addCookie(new Cookie("MCPopupClosed", "yes"));

		lp.clicklogin();

		logger.info("Login Button clicked");
		
		//Enter email and password
		LoginPage login = new LoginPage(driver);
		login.enteremail(username);
		login.enterpassword(password);
		logger.info("Email and password entered");
		
		//Click on LoginButton
		driver.manage().addCookie(new Cookie("MCPopupClosed", "yes"));
//		login.clickloginbtn();
		logger.info("Login button clicked");
		
		//Verify if User is logged in 
		lp.verifylogin();
		logger.info("User is logged in");
		
		
		
		
		
		
		
		
		
	}
	
	
	@DataProvider(name = "LoginDataProvider")
	public String[][] LoginDataProvider()
	{
		
		String filename = "/Users/mohanned/eclipse-workspace/SFA/TestData/TestDataTDD.xlsx";
		
		int ttlrows = readexcel.getrowcount(filename, "TestDataSheet" );
		int ttlcells = readexcel.getcolcount(filename, "TestDataSheet");
		
		
		String [][] data = new String[ttlrows-1][ttlcells];
		
		
		for( int i =1; i<ttlrows;i++)
		{
			
			for(int j =0;j<ttlcells;j++)
			{
				data[i][j]=readexcel.getCellValue(filename, "TestDataSheet", i, j);
			}
		}
		return data;
		
		
	}
	
	
	
	
	
	
	
	

}
