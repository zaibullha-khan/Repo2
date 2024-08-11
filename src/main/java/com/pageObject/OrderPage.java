package com.pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.actionDriver.Action;
public class OrderPage {
	public static WebDriver driver;
	@FindBy(xpath="//td[@class='unit-price']") 
	WebElement unitPrice; 
	@FindBy(className="qty-input") 
	WebElement quantity;
	@FindBy(xpath="(//td[@class='subtotal'])[1]") 
	WebElement SubTotalPriceFromTable;
	@FindBy(xpath="(//select[@id='checkout_attribute_1'])[1]") 
	public WebElement giftWrap;
	@FindBy(xpath="//tr[@class='order-total']//span[@class='value-summary']") 
	WebElement getTotalPrice;
	@FindBy(xpath="//input[@id='termsofservice']") 
	WebElement ClickOnAgree;
	@FindBy(xpath="//button[@id='checkout']") 
	WebElement ClickOnchechOut;
	@FindBy(xpath="(//button[normalize-space()='Checkout as Guest'])[1]") 
	public WebElement CheckOutAsGuest;
	
	public OrderPage(WebDriver d)
	{
		driver=d;
		PageFactory.initElements(driver,this);
	}
		
public String getUnitPrice()
{
	return unitPrice.getText();
}
public String getQTY()
{
	return Action.getAttributeValue(quantity);
}
public String getSubTotalPrice()
{
	return SubTotalPriceFromTable.getText();
}
public Boolean giftWrap(int indexValue)
{
	//Action.scrollElement(driver,giftWrap);
	return Action.selectByIndex(giftWrap,indexValue);
}	
public String getTotalPrice()
{
	return getTotalPrice.getText();	
}	
public void ClickOnAgree()
{
	Action.click(driver, ClickOnAgree);	
}
public void ClickOnCheckOut()
{
	Action.click(driver, ClickOnchechOut);
}	
public void clickCheckOutAsGuest()
{
	CheckOutAsGuest.click();
	
}
}
