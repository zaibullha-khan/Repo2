package com.pageObject;

import java.text.DecimalFormat;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.actionDriver.Action;

public class AddProductPage 
{
	WebDriver driver;
	@FindBy(xpath="//input[@id='small-searchterms']") 
	WebElement SearchField;
    @FindAll(@FindBy(xpath = " //ul/li[@class='ui-menu-item']")) 
    List<WebElement> autoDropDownItems; //or//ul/li/a[@class='ui-menu-item-wrapper']
    @FindBy(xpath="//button[normalize-space()='Search']") 
    WebElement SearchBtn;
    @FindBy(xpath="(//select[@id='product_attribute_1'])[1]")
	public WebElement ProcessorDropDown;
    @FindBy(xpath="(//select[@id='product_attribute_2'])[1]")
	public WebElement RamDropDown;
    @FindBy(xpath="//select[@id='product_attribute_2']") 
    WebElement Ram;
    @FindBy(xpath="//input[@id='product_attribute_3_6']")
	public WebElement HDDRadioBtn320Gb;
    @FindBy(xpath="//input[@id='product_attribute_3_7']")
	public WebElement HDDRadioBtn400Gb;
    @FindBy(xpath="//input[@id='product_attribute_4_8']")
	public WebElement OsVistaHome;
    @FindBy(xpath="//input[@id='product_attribute_4_9']")
	public WebElement OsVistaHomePremium;
    @FindBy(xpath="//input[@id='product_attribute_5_10']")
	public WebElement SofMicOffice;
    @FindBy(xpath="//input[@id='product_attribute_5_11']")
	public WebElement SofAcrobatReader;
    @FindBy(xpath="//input[@id='product_attribute_5_12']")
	public WebElement SofTotalComander;
    @FindBy(xpath="//span[@id='price-value-1']") 
    WebElement getTextMoney;
    @FindBy(xpath="//input[@id='product_enteredQuantity_1']") 
    WebElement QtyField;
    @FindBy(xpath="//button[@id='add-to-cart-button-1']") 
    public WebElement AddToCart;
    @FindBy(xpath="//button[@id='add-to-wishlist-button-1']") 
    public  WebElement AddToWishList;
    @FindBy(xpath="//button[normalize-space()='Add to compare list']") 
    public WebElement AddToCompareList;
    @FindBy(xpath="//button[normalize-space()='Email a friend']") 
    public WebElement EmailToFriend;
    
    public AddProductPage(WebDriver d)
    {
       driver=d;
       PageFactory.initElements(driver,this);
    }
    //
    public void searchField(String text)
    {
    	Action.type(SearchField,text);
    }
    public void ClickOnSearchBtn()
    {
    	Action.click(driver,SearchBtn);
    }
    //
    public void searchProduct(String text)
    {
    	Action.autosuggDropDown(autoDropDownItems,text);		
    }
    public void proDropDown()
    {
    	Action.click(driver,ProcessorDropDown);	
    }
    //
    public void SelectProcessor(String text)
    {
    	Action.selectByValue(ProcessorDropDown,text);
    }
    public void RamDropDown()
    {
    	Action.click(driver, RamDropDown);
    }
    public void SelectRam(String text)
    {
    	Action.selectByValue(Ram,text);
    }
    public void SelectHDD320GB()
    {
    	Action.click(driver, HDDRadioBtn320Gb);
    }
    public void SelectHDD400GB()
    {
    	Action.click(driver, HDDRadioBtn400Gb);
    }
    public void SelectOsVista()
    {
    	Action.click(driver, OsVistaHome);
    }
    public void SelectOsPremium()
    {
    	Action.click(driver, OsVistaHomePremium);
    }
    public void SelectSofMicOffice()
    {
    	Action.click(driver,SofMicOffice);
    }
    public void SelectSofAcrobatReader()
    {
    	Action.click(driver,SofAcrobatReader);
    }
    public void SelectSofTotalComander()
    {
    	Action.click(driver,SofTotalComander);
    }
    public String getTextForAmount()
    {
    	 return getTextMoney.getText();
    }
    public Boolean QuantityField(String text)
    {
    	return Action.type(QtyField, text);
    }
    public void AddToCartBtn()
    {
    	Action.click(driver, AddToCart);
    }
    public void AddToWishListBtn()
    {
    	Action.click(driver, AddToWishList);
    }
    public void AddToCompareListBtn()
    {
    	Action.click(driver, AddToCompareList);
    }
    
    public void EmailToFriendBtn()
    {
    	Action.click(driver,EmailToFriend);
    }
    //Converting String to Double(removed $ and ,) and than convert double to String(Added $  "," and .00)
	public String GetAmountAndAddedAmount(String text1,int add)
    {
    	     String textWithoutDollarAndCommas = text1.replace("$", "").replace(",", "");
		    //Remove dollar sign and commas from the string
		     double doubleValue = Double.parseDouble(textWithoutDollarAndCommas);
		    //Converting into doouble
		    double adding=doubleValue+add;//1
		    //Adding 
		    DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
	        String resultWithDollar = "$" + decimalFormat.format(adding);
            //Converting into String
			System.out.println(resultWithDollar);
			return resultWithDollar;
    }
	public void scrollElement( WebElement ele) 
	{
		// TODO Auto-generated method stub
		Action.scrollElement(driver, ele);
		
	}
	public void webDriverWait(int duration,WebElement ele)
	{
		Action.WebDriverWait(driver, duration, ele);
	}
}