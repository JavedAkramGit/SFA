package com.SFA.PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LaunchPage {
	
	
	
	//Create object of WebDriver
	WebDriver ldriver;
	WebDriverWait wait;
	
	
	public LaunchPage(WebDriver rdriver )
	{
		
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
		
		
	}
	
	
	//Find WebELements
	
	@FindBy(linkText = "Login / Register")
	WebElement loggerbtn;
	
	
	@FindBy(id = "search_input")
	WebElement searchFilter;
	
	//Identify action on Webelement
	public void clicklogin()
	{
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Login / Register")));
		loggerbtn.click();
	}
	
	
	public void verifylogin()
	{
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search_input")));
		
		searchFilter.isDisplayed();
	}
	
	
	
	

}
