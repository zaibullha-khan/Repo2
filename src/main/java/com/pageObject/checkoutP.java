package com.pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.actionDriver.Action;
public class checkoutP {
	public static WebDriver driver;
	@FindBy(xpath="//input[@id='BillingNewAddress_FirstName']") 
	WebElement FName;
	@FindBy(xpath="//input[@id='BillingNewAddress_LastName']") 
	WebElement LName ;
	@FindBy(xpath="//input[@id='BillingNewAddress_Email']") 
	WebElement Email ;
	@FindBy(xpath="//input[@id='BillingNewAddress_Company']") 
	WebElement Company ;
	@FindBy(xpath="(//select[@id='BillingNewAddress_CountryId'])[1]") 
	WebElement Selectcountry;
	@FindBy(xpath="(//select[@id='BillingNewAddress_StateProvinceId'])[1]") 
	WebElement SelectState;
	@FindBy(xpath="//input[@id='BillingNewAddress_City']") 
	WebElement city ;
	@FindBy(xpath="(//input[@id='BillingNewAddress_Address1'])[1]") 
	WebElement Address1 ;
	@FindBy(xpath="(//input[@id='BillingNewAddress_Address2'])[1]") 
	WebElement Address2;
	@FindBy(xpath="//input[@id='BillingNewAddress_ZipPostalCode']") 
	public WebElement pinCode ;
	@FindBy(xpath="(//input[@id='BillingNewAddress_PhoneNumber'])[1]") 
	WebElement PhoneNamber ;
	@FindBy(xpath="(//input[@id='BillingNewAddress_FaxNumber'])[1]") 
	WebElement FaxNumber;
	@FindBy(xpath="//button[@onclick='if (!window.__cfRLUnblockHandlers) return false; Billing.save()']") 
	public WebElement ClickOnContinue ;
	////
	@FindBy(xpath="(//input[@id='shippingoption_0'])[1]") 
	WebElement shippingByLandTransfer ;
	@FindBy(xpath="(//input[@id='shippingoption_1'])[1]") 
	WebElement TheOneDayAirShipping;
	@FindBy(xpath="(//input[@id='shippingoption_2'])[1]") 
	WebElement TheTwoDayAirShipping;
	@FindBy(xpath="//div[@id='shipping-method-buttons-container']//p[@class='back-link']//a[@href='#']") 
	public WebElement ClickOnBackBtn;
	@FindBy(xpath="(//button[@class='button-1 shipping-method-next-step-button'])[1]") 
	WebElement ClickOnContinue2 ;
	@FindBy(xpath="(//input[@id='paymentmethod_0'])[1]") 
	WebElement payByMonyOrder ;
	@FindBy(xpath="(//input[@id='paymentmethod_1'])[1]") 
	WebElement payByCreditOrDebit;
	@FindBy(xpath="(//a[@href='#'])[3]") 
	WebElement ClickOnBack ;
	@FindBy(xpath="(//button[@class='button-1 payment-method-next-step-button'])[1]") 
	WebElement ClickOnContinue3 ;
	@FindBy(xpath="(//a[@href='#'])[4]") 
	WebElement clickOnBackInPayConfirm  ;
	@FindBy(xpath="(//button[@class='button-1 payment-info-next-step-button'])[1]") 
	WebElement ClickOnContinuePayInformation;
	
	
	public checkoutP (WebDriver d)
	{
		driver=d;
		PageFactory.initElements(driver,this);
	}
	public  void firstname(String text)
	{
		Action.type(FName, text);
	}
	public  void lastName(String text)
	{
		Action.type(LName, text);
	}
	public  void EmailId(String text)
	{
		Action.type(Email, text);
	}
	public  void CompanyName(String text)
	{
		Action.type(Company, text);
	}
	public  void selectCountry(String text)
	{
		Action.selectByValue(Selectcountry, text);
	}
	public  void selectState(String text)
	{
		Action.selectByValue(SelectState, text);
	}
	public  void cityField(String text)
	{
		Action.type(city, text);
	}
	public  void Address1(String text)
	{
		Action.type(Address1, text);
	}
	public  void Address2(String text)
	{
		Action.type(Address2, text);
	}
	public  void pinCode(String text)
	{
		Action.type(pinCode, text);
	}
	public  void PhoneNamber(String text)
	{
		Action.type(PhoneNamber, text);
	}
	public  void FaxNumber(String text)
	{
		Action.type(FaxNumber, text);
	}
	public  void ClickOnContinueBtn()
	{
		Action.click(driver, ClickOnContinue);
	}

	public boolean ShipByLandTran()
	{
		Action.click(driver, shippingByLandTransfer);
		return true;
	}
	public boolean TheOneDayAirShipping()
	{
		Action.click(driver, TheOneDayAirShipping);
		return true;
	}
	public Boolean TheTwoDayAirShipping()
	{
		Action.click(driver, TheTwoDayAirShipping);
		return true;
	}
	public void ClickOnBackBtn()
	{
		Action.click(driver, ClickOnBackBtn);
	}
	public Boolean ClickOnContinue2()
	{
		Action.click(driver, ClickOnContinue2);
		return true;
		
	}
	public void payByMonyOrder()
	{
		Action.click(driver, payByMonyOrder);
	}
	public void payByCreditOrDebit()
	{
		Action.click(driver, payByCreditOrDebit);
	}
	public void ClickOnBack()
	{
		Action.click(driver, ClickOnBack);
	}
	public void ClickOnContinue3()
	{
		Action.click(driver, ClickOnContinue3);
	}
	public void clickOnBackInPayConfirm()
	{
		Action.click(driver, clickOnBackInPayConfirm);
	}
	public void ClickOnContinuePayConfirm()
	{
		Action.click(driver, ClickOnContinuePayInformation);
	}
	
}
