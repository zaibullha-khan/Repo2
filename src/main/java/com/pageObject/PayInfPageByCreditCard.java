package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actionDriver.Action;

public class PayInfPageByCreditCard {
      
	  WebDriver driver;
    
      @FindBy(xpath="(//select[@id='CreditCardType'])[1]") WebElement selectCreditCard;
      @FindBy(xpath="(//input[@id='CardholderName'])[1]") WebElement CardHolderNameField;
      @FindBy(xpath="(//input[@id='CardNumber'])[1]") WebElement cardNum;
      @FindBy(xpath="(//select[@id='ExpireMonth'])[1]") WebElement selectExpireDateMonth;
      @FindBy(xpath="(//select[@id='ExpireYear'])[1]") WebElement selectExpireDateYear;
      @FindBy(xpath="(//input[@id='CardCode'])[1]") WebElement cardCode;
      @FindBy(xpath="(//a[@href='#'])[4]") WebElement clickOnBackBtn;
      @FindBy(xpath="(//button[@class='button-1 payment-info-next-step-button'])[1]") WebElement clickOnContinueBtn;
      
     
      public PayInfPageByCreditCard(WebDriver d)
      {
    	  driver=d;
    	  PageFactory.initElements(driver,this);
      }
      public boolean selectCreditCard(String text)
      {
    	  return Action.selectByValue(selectCreditCard, text);  
      }
      public void CardHolderNameField(String text)
      {
    	  Action.type(CardHolderNameField,text);
      }
      public void cardNum(String text)
      {
    	  Action.type(cardNum,text);
      }
      public void selectExpireDateMonth(String text)
      {
    	  Action.selectByValue(selectExpireDateMonth, text);
      }
      public void selectExpireDateYear(String text)
      {
    	  Action.selectByValue(selectExpireDateYear, text);
      }
      public void cardCode(String text)
      {
    	  Action.type(cardCode,text);
      }
      public void clickOnBackBtn(String text)
      {
    	  Action.click(driver, clickOnBackBtn);
      }
      public void clickOnContinueBtn()
      {
    	  Action.click(driver, clickOnContinueBtn);
      }
      
      
}
