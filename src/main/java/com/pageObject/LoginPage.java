package com.pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.actionDriver.Action;

public class LoginPage {
	
	public static WebDriver driver;
	@FindBy(id="Email") WebElement EmailField ; 
	@FindBy(xpath="//input[@id='Password']") WebElement passWordField ; 
	@FindBy(xpath="//button[normalize-space()='Log in']") WebElement LogInBtn ; 
	//
	public LoginPage(WebDriver d)
	{
	   driver=d;
	   PageFactory.initElements(driver,this);
	}
	// 
	
	public Boolean EmailFieldDisplayed()
	{
		 return EmailField.isDisplayed();
		 
	}
	//2
	public Boolean PasswordFieldDisplayed()
	{
		 return passWordField.isDisplayed();
	}
		
	public void EmailFields(String Id)
	{
			Action.type(EmailField, Id);
		
	}
	public void passwordFields(String Ps)
	{
		
		Action.type(passWordField, Ps);
	}
	
	public Boolean LogInBtnDisplay()
	{
		Action.isDisplayed(driver, LogInBtn);
		return true;
	}
		
	public void LogInBtnClick()
	{
		LogInBtn.click();
	}
		
}
	

