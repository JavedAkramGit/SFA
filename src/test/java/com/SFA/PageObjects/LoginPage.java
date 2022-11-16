package com.SFA.PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	
	WebDriver ldriver;
	WebDriverWait wait;
	
	
	
	public LoginPage(WebDriver rdriver)
	{
		
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
		
	}
	
	
	@FindBy(id = "username")
	WebElement email;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(className = "sfa-account-form__submit")
	WebElement Loginbtn;
	
	public void enteremail(String emailtext) {
		
		wait = new WebDriverWait(ldriver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
		email.sendKeys(emailtext);
	}
	

	public void enterpassword(String Passwordtext)
	{
		
		password.sendKeys(Passwordtext);
		password.sendKeys(Keys.ENTER);
	}

	public void clickloginbtn()
	{
		wait = new WebDriverWait(ldriver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("sfa-account-form__submit")));
//		Loginbtn.sendKeys(Keys.ENTER);
	}
	
}
