package com.pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actionDriver.Action;

public class AddProductToShoppingCart_5 {
	
	
	WebDriver driver;
	@FindBy(xpath="//input[@id='small-searchterms']") 
	WebElement SearchField;
	@FindBy(xpath="//button[contains(text(),'Search')]") 
	WebElement SearchBtn;
    @FindAll(@FindBy(xpath = "//ul/li[@class='ui-menu-item']")) 
    List<WebElement> selectFromAutoDropDown; 
    //or//ul/li/a[@class='ui-menu-item-wrapper']
	@FindBy(xpath="(//select[@id='product_attribute_1'])[1]") 
    WebElement selectProcessor;
	@FindBy(xpath="(//select[@id='product_attribute_2'])[1]") 
	WebElement SelectRam;
	@FindBy(xpath="(//input[@id='product_attribute_3_6'])[1]") 
	WebElement SelectHDD320GB;
	@FindBy(xpath="(//input[@id='product_attribute_3_7'])[1]") 
	WebElement SelectHDD400GB;
	@FindBy(xpath="(//input[@id='product_attribute_4_8'])[1]") 
	WebElement selectOsVistaHome;
	@FindBy(xpath="(//input[@id='product_attribute_4_9'])[1]") 
	WebElement selectOsVistaPremium;
	@FindBy(xpath="(//input[@id='product_attribute_5_10'])[1]") 
	WebElement selectSOftMicOffice;
	@FindBy(xpath="(//input[@id='product_attribute_5_11'])[1]") 
	WebElement selectSOftAcroReader;
	@FindBy(xpath="(//input[@id='product_attribute_5_12'])[1]") 
	WebElement selectSOftTotalCommandr;
	@FindBy(xpath="(//input[@id='product_enteredQuantity_1'])[1]") 
	WebElement AddToCartField;
	@FindBy(xpath="(//button[normalize-space()='Add to cart'])[1]") 
	WebElement AddToCartBtn;
	
	public AddProductToShoppingCart_5(WebDriver d)
	{
		driver=d;
		PageFactory.initElements(driver,this);
	}
public void searchField(String text)
{
	Action.type(SearchField, text);
}
public void searchProducts(String text)
{
	Action.autosuggDropDown(selectFromAutoDropDown, text);
}
public void clickOnRegBtn()
{
Action.click(driver, SearchBtn);
}	
public boolean selectProcessor(int text)
{
	return Action.selectByIndex(selectProcessor, text);	
}
public void selectRam(int text)
{
	Action.selectByIndex(SelectRam, text);	
}
public void select320GBHDD()
{	
	Action.click(driver,SelectHDD320GB);
}
public void select400GBHDD()
{
	Action.click(driver,SelectHDD400GB);	
}
public void selectVistaHome()
{
	Action.click(driver,selectOsVistaHome);
}
public void selectVistaPremium()
{
	Action.click(driver,selectOsVistaPremium);
}
public void selectSoftMicSoftOffice()
{
	Action.click(driver,selectSOftMicOffice);
}
public void selectSoftAcroReader()
{
	Action.click(driver,selectSOftAcroReader);
}
public void selectSoftTotalCommander()
{
	Action.click(driver,selectSOftTotalCommandr);
}
public void enterQnty(String texts)
{
	Action.type(AddToCartField, texts);
}
public void clickOnAddToCart()
{
	Action.click(driver,AddToCartBtn);
}

}
