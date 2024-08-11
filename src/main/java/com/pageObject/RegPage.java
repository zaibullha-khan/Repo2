package com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.actionDriver.Action;
public class RegPage {
	public static WebDriver driver;
	@FindBy(xpath="//input[@id='gender-male']")
	WebElement GenderMale;
	@FindBy(xpath="//input[@id='gender-female']")
	WebElement GenderFemale;
	@FindBy(xpath="//input[@id='FirstName']")
	WebElement FirstName;
	@FindBy(xpath="//input[@id='LastName']")
	WebElement LastName;;
	@FindBy(xpath="//select[@name='DateOfBirthDay']")
	WebElement DOBDay;
	@FindBy(xpath="//select[@name='DateOfBirthMonth']")
	WebElement DOBMonth;
	@FindBy(xpath="//select[@name='DateOfBirthYear']")
	WebElement DOBYear;
	@FindBy(xpath="//input[@id='Email']")
	WebElement EmailId;
	@FindBy(xpath="//input[@id='Company']")
	WebElement CompanyName;
	@FindBy(xpath="//input[@id='Newsletter']")
	WebElement Newsletter ;
	@FindBy(xpath="//input[@id='Password']")
	WebElement Password ;
	@FindBy(xpath="//input[@id='ConfirmPassword']")
	WebElement ConfirmPassword;
	@FindBy(xpath="//button[@id='register-button']")
    public static WebElement RegBtn ;
	
public RegPage(WebDriver d)
{
   driver=d;
   PageFactory.initElements(driver,this);
}
/////
///
//1 displayed methods
public boolean GenderMaleBtnDisplayed()
{
	 Action.isDisplayed(driver,GenderMale);
	 return true;
}

public boolean GenderFemaleBtnDisplayed()
{
	 Action.isDisplayed(driver,GenderFemale);
	 return true;
}
public boolean FirstNameFieldDisplayed()
{
	 return Action.isDisplayed(driver,FirstName);
	 
}
public boolean LastNameFieldDisplayed()
{
	 return LastName.isDisplayed();
}
public boolean DOBDayDropDownDisplayed()
{
	 return Action.isDisplayed(driver,DOBDay);
}
public boolean DOBMonthDropDownDisplayed()
{
	 return Action.isDisplayed(driver,DOBMonth);
}

public boolean DOBYearDropDownDisplayed()
{
	 return Action.isDisplayed(driver,DOBYear);
}
public boolean EmailIdDisplayed()
{
	 return Action.isDisplayed(driver,EmailId);
	 
}
public boolean CompanyNameFieledDisplayed()
{
	 return Action.isDisplayed(driver,CompanyName);
}

public boolean PasswordFieldDisplayed()
{
	 return Action.isDisplayed(driver,Password);
}
public boolean ConfirmPasswordFieldDisplayed()
{
	 return Action.isDisplayed(driver,ConfirmPassword);
}
public boolean RegistratioBtnDisplay()
{
	 return Action.isDisplayed(driver,RegBtn);
}
//2 Actions methods
public boolean selectMaleGender() 
{
	 Action.click(driver,GenderMale);
	 return true;
}
public boolean selectFemaleGender() 
{
	 Action.click(driver,GenderFemale);
	 return true;
}
public boolean FirstNameField(String Text)
{	//Enter first name
//	  Action.type(FirstName, "markend");
//	  Action.copy(driver, FirstName);
//	  Action.delete(driver,FirstName);
//	  Action.paste(driver, FirstName);
	 
	Action.type(FirstName, Text);
	  return true;
}
public boolean LastnameField(String Text)
{	//Enter first name
//	  Action.type(LastName, "markend");
//	  Action.copy(driver, LastName);
//	  Action.delete(driver,LastName);
//	  Action.paste(driver, LastName);
	 
	Action.type(LastName,Text);
	  return true;
}
public boolean DOBDayDropDown(String Value)
{
	 Action.selectByValue(DOBDay,Value);
	 return true; 
}
public boolean DOBMonthDropDown(String Value)
{
	
	 Action.selectByValue(DOBMonth,Value);
	 return true;
	 
}
public Boolean DOBYearDropDown(String Value)
{
	 Action.selectByValue(DOBYear,Value);
	 return true;
}

public boolean EmailIdField(String Email)
{   
//Action.copy(driver, EmailId);
//Action.delete(driver, EmailId);
//Action.paste(driver, EmailId);
      Action.type(EmailId, Email);
	  return true;	 
}
public boolean CompanyNameFieled(String comName)
{
//	  Action.type(CompanyName, "itez");
//	  Action.copy(driver, CompanyName);
//	  Action.delete(driver, CompanyName);
//	  Action.paste(driver, CompanyName);
	   Action.type(CompanyName, comName);
	  return true;
	  }
public Boolean PasswordField(String pass) 
{  //	  Action.type(Password, "itez");
//	  Action.copy(driver, Password);
//	  Action.delete(driver, Password);
//	  Action.paste(driver, Password);
	  Action.type(Password,pass);//+
	  return true; 
	 
}
public boolean ConPassFields(String pass)
{
//	  Action.type(Password, "itez");
//	  Action.copy(driver, Password);
//	  Action.delete(driver, Password);
//	  Action.paste(driver, Password);
	Action.type(ConfirmPassword,pass);//+
	return true;
   }
public void clickRegBtn()
{
	RegBtn.isEnabled();
	Action.click(driver, RegBtn);
	
}

}