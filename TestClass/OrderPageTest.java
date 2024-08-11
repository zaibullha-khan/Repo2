package TestClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.actionDriver.Action;
import com.base.BaseClass1;
import com.pageObject.AddProductToShoppingCart_5;
import com.pageObject.OrderPage;
import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.utility.ListenerClass01.class)
public class OrderPageTest extends BaseClass1 {
	AddProductToShoppingCart_5 addPro;
	OrderPage odPage;
	@Parameters("url")
	@BeforeClass
	public void openWebsite(String url) throws InterruptedException
	{
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();	
		odPage=new OrderPage(driver);
		addPro=new AddProductToShoppingCart_5(driver);
		addPro.searchField("build");
		Thread.sleep(3000);
		addPro.searchProducts("Build your own computer");
        //Add one product for shopping cart
		addPro.selectProcessor(2);
	    addPro.selectRam(3);
	    addPro.select400GBHDD();
	    addPro.selectVistaPremium();
		addPro.selectSoftMicSoftOffice();
	    addPro.selectSoftTotalCommander();
	    addPro.enterQnty("2");
	    addPro.clickOnAddToCart();
		String ActText= driver.findElement(By.xpath("//p[@class='content']")).getText();
		Assert.assertEquals(ActText, "The product has been added to your shopping cart");	
		driver.navigate().back();
		// Land on shopping cart
		driver.findElement(By.xpath("//span[@class='cart-label']")).click();	
	}	
@Test(priority=1)
public void UnitPriceTest()
{
	String text= odPage.getUnitPrice();
	System.out.println(text);
	Assert.assertEquals(text, "$1,440.00");
}
@Test(priority=2)
public void testTheSeletedQty() throws InterruptedException
{	
	String qty= odPage.getQTY();
	System.out.println(qty); //check the path
	Assert.assertEquals(qty,"2");	
}
@Test(priority=3)
public void subTotalPrice() throws InterruptedException
{
	String subTotal=odPage.getSubTotalPrice();
	System.out.println(subTotal); //check the path
	Assert.assertEquals(subTotal,"$2,880.00");
}
@Test(priority=4)
public void giftWrapTest() throws InterruptedException
{
	Action.scrollElement(driver,odPage.giftWrap);
 	Thread.sleep(2000);
	odPage.giftWrap(1);
	Thread.sleep(3000);
	String Total=odPage.getTotalPrice();
	Assert.assertEquals(Total,"$2,890.00");
	//or compare with total price
}
@Test(priority=5)
public void TotalPrice() throws InterruptedException
{
	Thread.sleep(3000);
	String Total=odPage.getTotalPrice();
	Assert.assertEquals(Total,"$2,890.00");
}
@Test(priority=6)
public void ClickOnAgreeTest()
{
   odPage.ClickOnAgree();
   Assert.assertTrue(true);
}
@Test(priority=7)
	public void clickOnCheckOut() throws InterruptedException
	{
		odPage.ClickOnCheckOut();
		Thread.sleep(3000);
		String url=driver.getCurrentUrl();
		String exp="https://demo.nopcommerce.com/login/checkoutasguest?returnUrl=%2Fcart";
		Assert.assertEquals(url,exp);
	}
@Test(priority=8)
public void clickAsGuest() throws InterruptedException
{
	odPage.clickCheckOutAsGuest();
	Thread.sleep(3000);
	String url=driver.getCurrentUrl();
	System.out.println(url);
	String exp="https://demo.nopcommerce.com/onepagecheckout#opc-billing";
	Assert.assertEquals(url,exp);
	System.out.println("pass");
}

}
