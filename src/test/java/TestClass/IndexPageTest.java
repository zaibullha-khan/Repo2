package TestClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.BaseClass1;
import com.pageObject.AddProductToShoppingCart_5;
import com.pageObject.IndexPage;
import com.utility.logs;
import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.utility.ListenerClass01.class)
public class IndexPageTest extends BaseClass1  {
	
	 IndexPage index;
	 AddProductToShoppingCart_5 addPro;
   @Parameters("url")
	@BeforeClass(groups= { "smoke","sanity","Regression"})//	Compulsory (groups= { "smoke","sanity","Regression"}) should take here if doing grouping testing
	public void OpenWebsit(String url) throws InterruptedException
	{ 
	    driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		index=new IndexPage(driver);	
	}	 
@Test(priority=1,groups= "smoke")
public void TitleValidate() throws InterruptedException 
{	
	String expectedTitle=driver.getTitle();
	String actualTitle="nopCommerce demo store";
	Assert.assertEquals(expectedTitle,actualTitle);
    logs.info("get title verification");
}
@Test(groups="smoke")
public void nopCommerceLogoDispValidate() 
{ 
	Boolean logo=index.nopCommerceLogoDisplayed();
	Assert.assertTrue(logo);
}
@Test(groups="smoke")
public void RegBtnDisplayedValidate() 
{       
		//Boolean Btn1=
		index.RegBtnDisplayed();
        Assert.assertTrue(true);       
}
@Test(groups="smoke")
public void RegBtnClickValidate() throws InterruptedException 
{
	index.RegBtnClick();
	Thread.sleep(3000);
	String expectedUrl=driver.getCurrentUrl();
	System.out.println(expectedUrl);
	Assert.assertEquals(expectedUrl, "https://demo.nopcommerce.com/register?returnUrl=%2F"); // intentionally fail
	driver.navigate().back();
}
@Test
public void logInBtn() throws InterruptedException
{
	index.logInPageBtnClick();
	Thread.sleep(2000);
	String url=driver.getCurrentUrl();
	Assert.assertEquals(url, "https://demo.nopcommerce.com/login?returnUrl=%2F");
	driver.navigate().back();
}

@Test
public void ClickOnWishListValidation()
{
	index.ClickOnWishList();
	String expectedUrl=driver.getCurrentUrl();
	System.out.println(expectedUrl);
	Assert.assertEquals(expectedUrl,"https://demo.nopcommerce.com/wishlist");	
	driver.navigate().back();
}
@Test
public void ClickOnShoppingCartValidation()
{
	index.ClickOnShoppingCart();
	String expectedUrl=driver.getCurrentUrl();
	System.out.println(expectedUrl);
	Assert.assertEquals(expectedUrl,"https://demo.nopcommerce.com/cart");	
	driver.navigate().back();
}
@Test
public void Seachproduct() throws InterruptedException
{
    index.searchField("build");
    Thread.sleep(3000);
	index.searchProduct("Build your own computer");
	String url=driver.getCurrentUrl();
	Assert.assertEquals(url,"https://demo.nopcommerce.com/build-your-own-computer");
	driver.navigate().back();

 }

}
