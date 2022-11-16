package com.SFA.Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass implements ITestListener{
	
	
	
	
	ExtentSparkReporter htmlreporter;
	ExtentReports reports;
	ExtentTest test;
	
	
	public void Configurereport()
	{
		
		String timestamp = new SimpleDateFormat("yy.mm.dd.hh.mm.ss").format(new Date());
		String reportname = "MySFAReport"+ timestamp + ".html";
		htmlreporter = new ExtentSparkReporter("/Users/mohanned/eclipse-workspace/SFA/Reports/"+reportname);
		reports = new  ExtentReports();
		reports.attachReporter(htmlreporter);
		
		
		reports.setSystemInfo("Machine", "MacBook");
		reports.setSystemInfo("OS", "MacOS");
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("User", "Akram");
		
		
		htmlreporter.config().setDocumentTitle("Extent Listener Report");
		htmlreporter.config().setReportName("This is the first Report");
		htmlreporter.config().setTheme(Theme.DARK);
		
		
		
	}
	
	//Called when methoid starts
	public void onStart(ITestContext Result)
	{
		
		Configurereport();
		System.out.println("Start Method invoked");
	}
	
	//called when moethoid ends
	public void onFinish(ITestContext Result)
	{
		
		System.out.println("Finishing Method invoked");
		reports.flush(); //To ensure that the reports that are generated are saved on the reporter
	}
	
	public void onTestfails(ITestResult Result)
	{
		System.out.println("The test method that has failed is" + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("The test method that has failed is" + Result.getName(), ExtentColor.RED));
		
		
		String screenshotpath = "/Users/mohanned/eclipse-workspace/SFA/Screenshots" + Result.getName() + ".png";
		File screenshotfile = new File(screenshotpath);
		if(screenshotfile.exists())
		{
			
			test.fail("The captured screenshot is below " + test.addScreenCaptureFromPath(screenshotpath));
		}
	}
	
	public void onTestSkipped(ITestResult Result)
	{
		System.out.println("The test method that has Skipped is" + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("The test method that has Skipped is" + Result.getName(), ExtentColor.YELLOW));
		
	}
	
	
	
	
	public void ontestSTart(ITestResult Result)
	{
		
		System.out.println("The test that has started is " + Result.getName());
	}
	
	public void onTestPassed(ITestResult Result)
	{
		System.out.println("The test method that has Passed is" + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("The test method that has Passed is" + Result.getName(), ExtentColor.GREEN));
		
	}
	
	public void testcasefailedwithhighsuccess(ITestResult Result)
	{
		
		
	}
	
	
	

}
