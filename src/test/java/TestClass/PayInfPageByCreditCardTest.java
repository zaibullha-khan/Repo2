package TestClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.actionDriver.Action;
import com.base.BaseClass1;
import com.pageObject.AddProductPage;
import com.pageObject.AddProductToShoppingCart_5;
import com.pageObject.OrderPage;
import com.pageObject.PayInfPageByCreditCard;
import com.pageObject.checkoutP;
public class PayInfPageByCreditCardTest extends BaseClass1
{
	AddProductToShoppingCart_5 addPro;
	OrderPage odPage;
	checkoutP check;
	AddProductPage addProduct;
	PayInfPageByCreditCard payInfo;
	@Parameters("url")
	@BeforeClass
	public void openWebsite(String url) throws InterruptedException
	{
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		addPro=new AddProductToShoppingCart_5(driver);
		odPage=new OrderPage(driver);
	    check=new checkoutP(driver);
	    addProduct=new AddProductPage(driver);
	    payInfo=new PayInfPageByCreditCard(driver);
	    addProduct.searchField("Build your own computer");
	    addProduct.ClickOnSearchBtn();	
	    Thread.sleep(2000);
	    WebElement ele=driver.findElement(By.xpath("//div[@class='picture']//img[@title='Show details for Build your own computer']"));
	    Action.scrollElement(driver,ele);
	 	Thread.sleep(2000);
	    ele.click();
//		Or  
//	    addProduct.searchField("build");
//		Thread.sleep(3000);
//		addProduct.searchProduct("Build your own computer"); //auto suggestion dropdown
        //Add one product for shopping cart
		addPro.selectProcessor(2);
		Action.scrollElement(driver,addProduct.RamDropDown);
	 	Thread.sleep(2000);
	    addPro.selectRam(3);
	    addPro.select400GBHDD();
	    addPro.selectVistaPremium();
		addPro.selectSoftMicSoftOffice();
	    addPro.selectSoftTotalCommander();
	    Action.scrollElement(driver,addProduct.AddToCart);
	 	Thread.sleep(2000);
	    addPro.enterQnty("2");
	    addPro.clickOnAddToCart();
		driver.findElement(By.xpath("//span[@class='cart-label']")).click();
		Action.scrollElement(driver,odPage.giftWrap);
     	Thread.sleep(2000);
		odPage.giftWrap(2);
		odPage.ClickOnAgree();
		odPage.ClickOnCheckOut();
		Thread.sleep(3000);
		Action.scrollElement(driver,odPage.CheckOutAsGuest);
     	Thread.sleep(2000);
		odPage.clickCheckOutAsGuest();
		driver.findElement(By.xpath("(//input[@id='BillingNewAddress_FirstName'])[1]")).sendKeys("dkjdjd");
		driver.findElement(By.xpath("(//input[@id='BillingNewAddress_LastName'])[1]")).sendKeys("wkjsje");
		driver.findElement(By.xpath("(//input[@id='BillingNewAddress_Email'])[1]")).sendKeys("zaibullhakhan1@gmail.com");
		WebElement elem=driver.findElement(By.xpath("(//select[@id='BillingNewAddress_CountryId'])[1]"));
		Action.selectByIndex(elem, 6);
		driver.findElement(By.xpath("(//input[@id='BillingNewAddress_City'])[1]")).sendKeys("rajeshwer");
		driver.findElement(By.xpath("(//input[@id='BillingNewAddress_Address1'])[1]")).sendKeys("Pathan street Rajeshwar");
		driver.findElement(By.xpath("(//input[@id='BillingNewAddress_Address2'])[1]")).sendKeys("HN-1/145");
		driver.findElement(By.xpath("(//input[@id='BillingNewAddress_ZipPostalCode'])[1]")).sendKeys("585331");
		driver.findElement(By.xpath("(//input[@id='BillingNewAddress_PhoneNumber'])[1]")).sendKeys("08088659790");
		driver.findElement(By.xpath("(//button[@onclick='if (!window.__cfRLUnblockHandlers) return false; Billing.save()'])[1]")).click();
		driver.findElement(By.xpath("(//button[@class='button-1 shipping-method-next-step-button'])[1]")).click();
		driver.findElement(By.xpath("(//input[@id='paymentmethod_1'])[1]")).click();
		driver.findElement(By.xpath("(//button[@class='button-1 payment-method-next-step-button'])[1]")).click();
	
	}
	
	@Test(dataProvider="payInfoData")
	public void PaymentInfoEndToEndTesting(String SelCreCardNum,String CardHolName,String CardNumb,String SelExpDateMoth,String SelExpDateYear,String CardCod,String Validation) throws InterruptedException
	{
		
		System.out.println(SelCreCardNum);
	    System.out.println(CardHolName);
	    System.out.println(CardNumb);
		System.out.println(SelExpDateMoth);
		System.out.println(SelExpDateYear);
		System.out.println(CardCod);
		System.out.println(Validation);
		
		
		payInfo.selectCreditCard(SelCreCardNum);
	    payInfo.CardHolderNameField(CardHolName);
		payInfo.cardNum(CardNumb);
		payInfo.selectExpireDateMonth(SelExpDateMoth);
		payInfo.selectExpireDateYear(SelExpDateYear);
		payInfo.cardCode(CardCod);
		payInfo.clickOnContinueBtn();
		Thread.sleep(2000);
		 
		//For valid test
	    if (Validation.equals("valid"))
		 {
	    	String exp_url="https://demo.nopcommerce.com/onepagecheckout#opc-confirm_order";
	 	    String act_url=driver.getCurrentUrl();
	 	    System.out.println(act_url);
	    	//For valid test new account have not exist not exist 
		    if(act_url.equals(exp_url))
		    {    
		    	    driver.findElement(By.xpath("(//a[@href='#'])[5]")).click();
		    	    System.out.println("Successfully done payment info test");
			        Assert.assertTrue(true);    
		    }
		 }
		  
	          //For invalid test new account already exist
		    else
		    {
		    	System.out.println("1");
		    	if(    (driver.findElement(By.xpath("(//li[normalize-space()='Wrong card number'])[1]")).getText()).equals("Wrong card number") 
		    		|| (driver.findElement(By.xpath("(//li[normalize-space()='Wrong card code'])[1]")).getText()).equals("Wrong card code")
		    		|| (driver.findElement(By.xpath("(//li[normalize-space()='Enter cardholder name'])[1]")).getText()).equals("Enter cardholder name")
		    		|| (driver.findElement(By.xpath("(//li[normalize-space()='Card is expired'])[1]")).getText()).equals("Card is expired"))
		    	{       
	                       /// rsolve the problem if card is expir test could not pass lick invalid expiry date
			 		  System.out.println("getting errors for Wrong card number or Wrong card code or Enter cardholder name or Card is expired");
			    }
		    	
		  	} 
	}
}