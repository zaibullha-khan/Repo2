package TestClass;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.actionDriver.Action;
import com.base.BaseClass1;
import com.pageObject.AddProductPage;
import com.pageObject.AddProductToShoppingCart_5;
import com.pageObject.OrderPage;
import com.pageObject.checkoutP;
@Listeners(com.utility.ListenerClass01.class)
public class checkOutPageTest extends BaseClass1 {
		AddProductToShoppingCart_5 addPro;
		OrderPage odPage;
		checkoutP check;
		AddProductPage addProduct;
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
//		    addProduct.searchField("Build your own computer");
//		    addProduct.ClickOnSearchBtn();	    
//			Or
		    addProduct.searchField("build");
			Thread.sleep(3000);
			addProduct.searchProduct("Build your own computer"); //auto suggestion dropdown
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
		}	
		@Test(priority=1,dataProvider="checkOutData")			
		public void RegTest(String fname,String lname,String Email,String CName,String Scountry, String SState,String city,String Add1,String Add2,String PinCode,String PNumber,String Fnumber,String result) throws InterruptedException
		{
//				System.out.println(fname);
//				System.out.println(lname);
//				System.out.println(Email);
//				System.out.println(CName);
//				System.out.println(Scountry);
//				System.out.println(SState);
//				System.out.println(city);
//				System.out.println(Add1);
//				System.out.println(Add2);
//				System.out.println(PNumber);
//				System.out.println(Fnumber);
				System.out.println(result);
				
				check.firstname(fname);
				check.lastName(lname);
				check.EmailId(Email);
				check.CompanyName(CName);
				check.selectCountry(Scountry);
				check.selectState(SState);
				check.cityField(city);
				check.Address1(Add1);
				check.Address2(Add2);
				Action.scrollElement(driver,check.pinCode);
		     	Thread.sleep(2000);
				check.pinCode(PinCode);
				check.PhoneNamber(PNumber);
				check.FaxNumber(Fnumber);
				
				if(result.equals("valid"))
				{   Action.scrollElement(driver,check.ClickOnContinue);
		     	    Thread.sleep(2000);
					check.ClickOnContinueBtn();
			        Thread.sleep(3000);
					String act_url=driver.getCurrentUrl();
					System.out.println(act_url);
					String exp_url="https://demo.nopcommerce.com/onepagecheckout#opc-shipping_method";
					System.out.println(exp_url);
					if(act_url.equals(exp_url))
					{
			             Assert.assertTrue(true);
					     System.out.println("Successfully done");
					     driver.findElement(By.xpath("(//a[@href='#'])[2]")).click(); //need validation logic
					}
					else
					{
						Assert.assertTrue(false);
					}
			    }
				else     //for invalid
				{   Action.scrollElement(driver,check.ClickOnContinue);
	     	        Thread.sleep(2000);
					check.ClickOnContinueBtn();
				    Thread.sleep(3000);
					String act_url=driver.getCurrentUrl();
					System.out.println(act_url);
					String exp_url="https://demo.nopcommerce.com/onepagecheckout#opc-shipping_method";
					System.out.println(exp_url);
					if(!act_url.equals(exp_url))
					{
						Assert.assertTrue(true);
					}
					else
					{
						Assert.assertTrue(false);
						driver.findElement(By.xpath("(//a[@href='#'])[2]")).click(); //need validatio logic	 
					}	
				}
				Thread.sleep(3000);	
		    }
		@Test(priority=2)		
		public void ShipByLandTran() throws InterruptedException
		{
			check.firstname("zaib");
			check.lastName("khan");
			check.EmailId("zaibullhakhan2@Gmai.com");
			check.CompanyName("itech");
			check.selectCountry("1");
			check.selectState("1");
			check.cityField("hyderabad");
			check.Address1("1/145");
			check.Address2("rajeshwar");
			check.pinCode("585331");
			check.PhoneNamber("8088659790");
			check.FaxNumber("2126932342");
			Action.scrollElement(driver,check.ClickOnContinue);
		    Thread.sleep(2000);
			check.ClickOnContinueBtn();
		    Thread.sleep(3000);
		check.ShipByLandTran();
		check.ClickOnContinue2();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@href='#'])[3]")).click();	
		Assert.assertTrue(true);
		}
		@Test(priority=3)
		public void TheOneDayAirShipping() throws InterruptedException
		{
			check.TheOneDayAirShipping();
			check.ClickOnContinue2();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//a[@href='#'])[3]")).click();	
			Assert.assertTrue(true);
		}
		@Test(priority=4)
		public void TheTwoDayAirShipping() throws InterruptedException
		{
		    check.TheTwoDayAirShipping();
		    check.ClickOnContinue2();
		    Thread.sleep(2000);
			driver.findElement(By.xpath("(//a[@href='#'])[3]")).click();	
			Assert.assertTrue(true);
		}
		@Test(priority=5)
		public void ContinueShipMethod()
		{
			check.ClickOnContinue2();
			Assert.assertTrue(true);
		}
		@Test(priority=6)
		public void payByMonyOrder() throws InterruptedException {
			Thread.sleep(2000);
		    check.payByCreditOrDebit();
			check.payByMonyOrder();
			check.ClickOnContinue3();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//a[@href='#'])[4]")).click();
			Assert.assertTrue(true);
		}
		@Test(priority=7)
		public void payByCreditOrDebit() throws InterruptedException {
		    check.payByCreditOrDebit();
			check.ClickOnContinue3();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//a[@href='#'])[4]")).click();
			Assert.assertTrue(true);
		}
		@Test(priority=8)
		public void clickOnPayMethodContinue() throws InterruptedException 
		{	
			check.payByMonyOrder();
			check.ClickOnContinue3();
			Thread.sleep(2000);
			Assert.assertTrue(true);
		}
		@Test(priority=9)
		public void paymentInformVerifyStateAddress() throws InterruptedException {		
		String State=driver.findElement(By.xpath("(//b[normalize-space()='New York, NY 10001'])[1]")).getText();
		System.out.println(State);
		Assert.assertEquals(State, "New York, NY 10001");	
		}
		@Test(priority=10)
		public void paymentInformVerifyCity() throws InterruptedException {		
		String city=driver.findElement(By.xpath("//b[normalize-space()='USA']")).getText();
		System.out.println(city);
		Assert.assertEquals(city, "USA");		
		}
		@Test(priority=11)
		public void ClickOnContinuePaymentInform() throws InterruptedException {		
		check.ClickOnContinuePayConfirm();
		Assert.assertTrue(true);
		}
		@Test(priority=12)
		public void VerifyConfirmOrderBackBtn() throws InterruptedException
		{	
			WebElement backBtnScrol=driver.findElement(By.xpath("(//a[@href='#'])[5]")); 
			Action.scrollElement(driver,backBtnScrol);
		 	Thread.sleep(2000);
		 	driver.findElement(By.xpath("(//a[@href='#'])[5]")).click(); 
			check.ClickOnContinuePayConfirm();
			Assert.assertTrue(true);		
		}
		@Test(priority=13)
		public void VerifyBillingAdress() throws InterruptedException
		{
			Thread.sleep(2000);
			String actAdress=driver.findElement(By.xpath("(//ul[@class='info-list'])[1]")).getText();
//			String expAdress="zaib khan"+
//			"\n"+"Email: zaibullhakhan2@Gmai.com"+
//			"\n"+"Phone: 8088659790"+
//			"\n"+"Fax: 2126932342"+
//			"\n"+"itech"+
//			"\n"+"1/145"+
//			"\n"+"rajeshwar"+
//			"\n"+"hyderabad,AA (Armed Forces Americas),585331"+
//			"\n"+"United States"; //put the /n same as get text 
			String expAdress="zaib khan"+
			"\n"+"Email: zaibullhakhan2@Gmai.com"+
	        "\n"+"Phone: 8088659790"+
			"\n"+"Fax: 2126932342" +
			"\n"+"itech"+
			"\n"+"United States"+
			"\n"+"AA (Armed Forces Americas)"+
			"\n"+"hyderabad"+
			"\n"+"1/145"+
			"\n"+"rajeshwar"+
			"\n"+"585331";
			
			System.out.println(actAdress);
			System.out.println(expAdress);
			Assert.assertEquals(actAdress,expAdress);		
		}
		@Test(priority=14)
		public void VerifyShippingAdress() throws InterruptedException
		{
			Thread.sleep(2000);
			String actAdress=driver.findElement(By.xpath("(//ul[@class='info-list'])[3]")).getText();
			String expAdress="zaib khan"+	
			        "\n"+"Email: zaibullhakhan2@Gmai.com"+
			        "\n"+"Phone: 8088659790"+
					"\n"+"Fax: 2126932342" +
					"\n"+"itech"+
					"\n"+"United States"+
					"\n"+"AA (Armed Forces Americas)"+
					"\n"+"hyderabad"+
					"\n"+"1/145"+
					"\n"+"rajeshwar"+
					"\n"+"585331"; //put the /n same as get text 
			System.out.println(actAdress);
			System.out.println(expAdress);
			Assert.assertEquals(actAdress,expAdress);	
		}
		
//		@Test(priority=14)
//		public void VeifyTheProName()
//		{
//			
//		}
		@Test(priority=15)
		public void VerifyTheUnitPrice()
		{
			//String text= odPage.getUnitPrice();
			String text= driver.findElement(By.xpath("(//span[@class='product-unit-price'])[1]")).getText();
			System.out.println(text);
			Assert.assertEquals(text, "$1,440.00");
		}
		@Test(priority=16)
		public void VerrifyTheQuntity()
		{
			//String qty= odPage.getQTY();
			String qty= driver.findElement(By.xpath("(//td[@class='quantity'])[1]")).getText();
			System.out.println(qty);
			Assert.assertEquals(qty,"2");	
		}
		@Test(priority=17)
		public void VerifyTheTotalPriceInTable()
		{
			//String Total=odPage.getTotalPrice();
			String Total= driver.findElement(By.xpath("(//span[@class='product-subtotal'])[1]")).getText();
			System.out.println(Total);
			Assert.assertEquals(Total,"$2,880.00");	
		}
		@Test(priority=18)
		public void VerifyTheTotalPriceInSlip()
		{
			//String Total=odPage.getTotalPrice();
			String Total= driver.findElement(By.xpath("(//span[@class='value-summary'])[4]")).getText();
			System.out.println(Total);
			Assert.assertEquals(Total,"$2,880.00");
		}
		
		//tried it later
		@Test(priority=19)
		public void ClickOnConfirmBtn()
		{
			//String Total=odPage.getTotalPrice();
			driver.findElement(By.xpath("(//button[normalize-space()='Confirm'])[1]")).click();	
			String exp="Your order has been successfully processed!";
			String act= driver.findElement(By.xpath("(//strong[normalize-space()='Your order has been successfully processed!'])[1]")).getText();
			Assert.assertEquals(exp,act);
		}
			@Test(priority=20)
			public void ClickOnContinue() throws InterruptedException
			{
				//String Total=odPage.getTotalPrice();
				driver.findElement(By.xpath("(//button[normalize-space()='Continue'])[1]")).click();	
				Thread.sleep(3000);
				String ActUrl=driver.getCurrentUrl();
				String expUrl="https://demo.nopcommerce.com/";
				Assert.assertEquals(expUrl,ActUrl);
			}
//			
////		@Test(priority=21)
////		public void clickHereToReOrder()
////		{
////			
////		}
//		//1 verify billing address get text anc compare
//		//2 shipping address
//		//3 product details same test as shopping cart test
//		
//		
	}