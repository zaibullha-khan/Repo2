package TestClass;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.actionDriver.Action;
import com.base.BaseClass1;
import com.pageObject.AddProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.utility.ListenerClass01.class)
public class AddProdcutPageTest extends BaseClass1
{ 
	AddProductPage addProduct;
	@Parameters("url")
	@BeforeMethod(groups= {"smoke","sanity","Regression"})//	Compulsory (groups= { "smoke","sanity","Regression"}) should take here if doing grouping testing
	public void openWebsite(String url) throws InterruptedException
	{
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		addProduct=new AddProductPage(driver);	
//		addProduct.searchField("build");
//		Thread.sleep(3000);
//		addProduct.searchProduct("Build your own computer");
//    or
		addProduct.searchField("Build your own computer");
		addProduct.ClickOnSearchBtn();
	    driver.findElement(By.xpath("//h2[@class='product-title']//a[normalize-space()='Build your own computer']")).click();//click on product
	}										
	@Test
    public void SelectProce22GHzValidation() throws InterruptedException 
    {     
	        String text1=addProduct.getTextForAmount();
	        //getting text
	        System.out.println(text1);
	        //print
	        String resultWD=addProduct.GetAmountAndAddedAmount(text1,100);
	        //Converting String to Double(removed $ and ,) and than convert double to String(Added $  "," and .00)
	        addProduct.proDropDown();
		    //click on dropdown
	        addProduct.scrollElement(addProduct.ProcessorDropDown);
	        //ScrollDown
	        addProduct.SelectProcessor("1");
    		  //select processor
			  Thread.sleep(2000);	
		      String text2=addProduct.getTextForAmount();
			  //getText again
	          System.out.println(text2);
	          //print
              Assert.assertEquals(resultWD,text2);
    		}
	@Test
    public void SelectProce25GHzValidation() throws InterruptedException 
    {     
	        String text1=addProduct.getTextForAmount();
	        //getting text
	        System.out.println(text1);
	        //print
	        String resultWD=addProduct.GetAmountAndAddedAmount(text1,115);
	        //Converting String to Double(removed $ and ,) and than convert double to String(Added $  "," and .00)
	        addProduct.proDropDown();
		    //click on dropdown
	        addProduct.scrollElement(addProduct.ProcessorDropDown);
	        //ScrollDown
	        addProduct.SelectProcessor("2");
    		  //select processor
			  Thread.sleep(2000);			    
		      String text2=addProduct.getTextForAmount();
			  //getText again
	          System.out.println(text2);
	          //print
              Assert.assertEquals(resultWD,text2);	
    }
	@Test
    public void SelectRam2GBValidation() throws InterruptedException 
    {     
		    String text1=addProduct.getTextForAmount();
	        System.out.println(text1);
	        //getting text
	        String resultWD=addProduct.GetAmountAndAddedAmount(text1,115);
	        //Converting String to Double(removed $ and ,) and than convert double to String(Added $  "," and .00)
		    //print
	             
	             addProduct.RamDropDown();//2
			      //click on dropdown
	             addProduct.scrollElement(addProduct.RamDropDown);
	             addProduct.SelectRam("3");//3
			      //select processorm
			      Thread.sleep(2000);
			      String text2=addProduct.getTextForAmount();
			       //getText again
		          System.out.println(text2);
	              //print
	              Assert.assertEquals(resultWD,text2);
    			}
	@Test
  public void SelectRam4GBValidation() throws InterruptedException 
  {         //4gb
		    String text1=addProduct.getTextForAmount();
	        System.out.println(text1);
	        //getting text
	        String resultWD=addProduct.GetAmountAndAddedAmount(text1,135);
	        //Converting String to Double(removed $ and ,) and than convert double to String(Added $  "," and .00)
		    //print          
	             	addProduct.RamDropDown();//2
	             	//click on dropdown
	             	addProduct.scrollElement(addProduct.RamDropDown);
	             	Thread.sleep(3000);
	             	addProduct.SelectRam("4");//3
	             	//select processorm
	             	Thread.sleep(2000);
	             	String text2=addProduct.getTextForAmount();
	             	//getText again
	             	System.out.println(text2);
	             	//print
	             	Assert.assertEquals(resultWD,text2);
  			}
	@Test
	  public void SelectRam8GBValidation() throws InterruptedException 
	  {     //4gb
			    String text1=addProduct.getTextForAmount();
		        System.out.println(text1);
		        //getting text
		        String resultWD=addProduct.GetAmountAndAddedAmount(text1,175);
		        //Converting String to Double(removed $ and ,) and than convert double to String(Added $  "," and .00)
			    //print
		               addProduct.RamDropDown();//2
				       //click on dropdown
		               addProduct.scrollElement(addProduct.RamDropDown);
		               addProduct.SelectRam("5");//3
				       //select processorm
				       Thread.sleep(2000);
				       String text2=addProduct.getTextForAmount();
				       //getText again
			           System.out.println(text2);
		               //print
		               Assert.assertEquals(resultWD,text2);
	  }
	 @Test
	 public void SelectHDD320GBValidation() throws InterruptedException
	    {     
			    String text1=addProduct.getTextForAmount();
		        System.out.println(text1);
		        //getting text
		        String resultWD=addProduct.GetAmountAndAddedAmount(text1,115);
		        //Converting String to Double(removed $ and ,) and than convert double to String(Added $  "," and .00)
		        addProduct.scrollElement(addProduct.HDDRadioBtn320Gb); 
		        Thread.sleep(2000);
		        addProduct.SelectHDD320GB();
		        Thread.sleep(2000);
		        String text2=addProduct.getTextForAmount();
				//getText again
		        System.out.println(text2);
		        //print
		        Assert.assertEquals(resultWD,text2);
	    }
	 @Test
	 public void SelectHDD400GBValidation() throws InterruptedException
	    {     
			    String text1=addProduct.getTextForAmount();
		        System.out.println(text1);
		        //getting text
		        String resultWD=addProduct.GetAmountAndAddedAmount(text1,215);
		        //Converting String to Double(removed $ and ,) and than convert double to String(Added $  "," and .00)
		        addProduct.scrollElement(addProduct.HDDRadioBtn400Gb); 
		        Thread.sleep(2000);
		        addProduct.SelectHDD400GB();
		        Thread.sleep(2000);
		        String text2=addProduct.getTextForAmount();
				//getText again
		        System.out.println(text2);
		        //print
		        Assert.assertEquals(resultWD,text2);
	    }
	 @Test
	 public void SelectOsVistaHomeValidation() throws InterruptedException
	    {     
		 String text1=addProduct.getTextForAmount();
	        System.out.println(text1);
	        //getting text
	        String resultWD=addProduct.GetAmountAndAddedAmount(text1,115);
	        //Converting String to Double(removed $ and ,) and than convert double to String(Added $  "," and .00)
	        addProduct.scrollElement(addProduct.OsVistaHome); 
	        Thread.sleep(2000);
	        addProduct.SelectOsVista();
	        Thread.sleep(2000);
	        String text2=addProduct.getTextForAmount();
			//getText again
	        System.out.println(text2);
	        //print
	        Assert.assertEquals(resultWD,text2);
	    }
	 @Test
	 public void SelectOsPremiumHomeValidation() throws InterruptedException
	    {     
		    String text1=addProduct.getTextForAmount();
	        System.out.println(text1);
	        //getting text
	        String resultWD=addProduct.GetAmountAndAddedAmount(text1,125);
	        //Converting String to Double(removed $ and ,) and than convert double to String(Added $  "," and .00)
	        addProduct.scrollElement(addProduct.OsVistaHomePremium); 
	        Thread.sleep(2000);
	        addProduct.SelectOsPremium();
	        Thread.sleep(2000);
	        String text2=addProduct.getTextForAmount();
			//getText again
	        System.out.println(text2);
	        //print
	        Assert.assertEquals(resultWD,text2);	
	    }
	 @Test
	 public void SelectSofMicOfficeValidation() throws InterruptedException
	    {     
		    String text1=addProduct.getTextForAmount();
	        System.out.println(text1);
	        //getting text
	        String resultWD=addProduct.GetAmountAndAddedAmount(text1,115);
	        //Converting String to Double(removed $ and ,) and than convert double to String(Added $  "," and .00)
	        addProduct.scrollElement(addProduct.SofMicOffice); 
	        Thread.sleep(2000);
	        addProduct.SelectSofMicOffice();
	        addProduct.SelectSofMicOffice();
	        Thread.sleep(2000);
	        String text2=addProduct.getTextForAmount();
			//getText again
	        System.out.println(text2);
	        //print
	        Assert.assertEquals(resultWD,text2);	
	    }
	 @Test
	 public void SelectSofAcrobatReaderValidation() throws InterruptedException
	    {     
		    String text1=addProduct.getTextForAmount();
	        System.out.println(text1);
	        //getting text
	        String resultWD=addProduct.GetAmountAndAddedAmount(text1,125);
	        //Converting String to Double(removed $ and ,) and than convert double to String(Added $  "," and .00)
	        addProduct.scrollElement(addProduct.SofAcrobatReader); 
	        Thread.sleep(2000);
	        addProduct.SelectSofAcrobatReader();
	        Thread.sleep(2000);
	        String text2=addProduct.getTextForAmount();
			//getText again
	        System.out.println(text2);
	        //print
	        Assert.assertEquals(resultWD,text2);	
	    }
	 @Test
	 public void SelectSofTotalComanderValidation() throws InterruptedException
	    {     
		    String text1=addProduct.getTextForAmount();
	        System.out.println(text1);
	        //getting text
	        String resultWD=addProduct.GetAmountAndAddedAmount(text1,120);
	        //Converting String to Double(removed $ and ,) and than convert double to String(Added $  "," and .00)
	        addProduct.scrollElement(addProduct.SofTotalComander); 
	        Thread.sleep(2000);
	        addProduct.SelectSofTotalComander();
	        Thread.sleep(2000);
	        String text2=addProduct.getTextForAmount();
			//getText again
	        System.out.println(text2);
	        //print
	        Assert.assertEquals(resultWD,text2);	
	    }
	 @Test
	 public void EnterTheQuantity() throws InterruptedException
	 {
	    Boolean text=addProduct.QuantityField("2");
	    Assert.assertTrue(text);
	 }
	 @Test
	 public void AddToCartValidation() throws InterruptedException
	 {
		    Action.scrollElement(driver,addProduct.RamDropDown);
		 	Thread.sleep(2000);
		 	addProduct.SelectRam("3");
		 	addProduct.SelectHDD320GB();
		 	Action.scrollElement(driver,addProduct.AddToCart);
		 	Thread.sleep(2000);
		 	addProduct. AddToCartBtn();
		 	WebElement element=driver.findElement(By.xpath("//div[@class='bar-notification success']"));
			addProduct.webDriverWait(30,element);
		    String text=element.getText();
		    Assert.assertEquals(text,"The product has been added to your shopping cart");
	 }
	 @Test
	 public void AddToWishListValidation() throws InterruptedException
	 {	
		 	Action.scrollElement(driver,addProduct.RamDropDown);
		 	Thread.sleep(2000);
		 	addProduct.SelectRam("3");
		 	addProduct.SelectHDD320GB();
		 	Action.scrollElement(driver,addProduct.AddToWishList);
		 	Thread.sleep(2000);
		 	addProduct.AddToWishListBtn();
    	    WebElement element=driver.findElement(By.xpath("//p[@class='content']"));
		 	addProduct.webDriverWait(30,element);
		    String text=element.getText();
		    Assert.assertEquals(text,"The product has been added to your wishlist");
	 }
	 @Test
	 public void EmailBtnClickValidation() throws InterruptedException
	 {		
		    Action.scrollElement(driver,addProduct.EmailToFriend);
		    Thread.sleep(2000);
		    addProduct.EmailToFriendBtn();
		    Thread.sleep(2000);
		    String url=driver.getCurrentUrl();
		    Assert.assertEquals(url,"https://demo.nopcommerce.com/productemailafriend/1");
	 }
}
