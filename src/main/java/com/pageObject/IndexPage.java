package com.pageObject;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.actionDriver.Action;
public class IndexPage  {
	WebDriver driver;
	@FindBy(xpath="//img[@alt='nopCommerce demo store']")
	WebElement Logo;
	@FindBy(xpath="//a[@class='ico-register']") 
	WebElement Registration;	
	@FindBy(xpath="//a[@class='ico-login']")
	WebElement logInPageBtn ; 
	@FindBy(xpath="//input[@id='small-searchterms']") 
	WebElement SearchField;
	@FindBy(xpath="//button[normalize-space()='Search']")
	WebElement SearchBtn;
	@FindAll(@FindBy(xpath = "//ul/li[@class='ui-menu-item']")) 
	List<WebElement> autoDropDownItems;
	@FindBy(xpath="//span[@class='wishlist-label']")
	WebElement WishList;
	@FindBy(xpath="//span[@class='cart-label']")
	WebElement ShoppingCart;
	//span[@class='wishlist-label']     
public IndexPage(WebDriver d)
{
   driver=d;
   PageFactory.initElements(driver,this);
}

//1
public boolean nopCommerceLogoDisplayed()
{
	  Action.isDisplayed(driver,Logo);
	  return true;
}
//2
public boolean RegBtnDisplayed() 
{
	 return Registration.isDisplayed(); 
}
//3
public void RegBtnClick()
{
	Action.click(driver,Registration);
}
//2
public Boolean logInPageBtnDisplayed()
{
	Action.isDisplayed(driver,logInPageBtn);
	return true;
}
//3
public boolean logInPageBtnClick()
{
	Action.click(driver,logInPageBtn);
	return true;
}
public void searchField(String text)
{
	Action.type(SearchField, text);
}
public void searchProduct(String text)
{
	Action.autosuggDropDown(autoDropDownItems,text);	
}
public void ClickOnSearchBtn()
{
	Action.click(driver,SearchBtn);
}
public void ClickOnWishList()
{
	WishList.click();
}
public void ClickOnShoppingCart()
{
	ShoppingCart.click();
	
}
}
