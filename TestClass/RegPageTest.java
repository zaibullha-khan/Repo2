package TestClass;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.actionDriver.Action;
import com.base.BaseClass1;
import com.pageObject.IndexPage;
import com.pageObject.RegPage;

@Listeners(com.utility.ListenerClass01.class)
public class RegPageTest extends BaseClass1 {
	      RegPage reg;
		  IndexPage index;
		@Parameters("url")
		@BeforeClass(groups= { "smoke","sanity","Regression"})//	Compulsory (groups= { "smoke","sanity","Regression"}) should take here if doing grouping testing, Note regression testing
		public void Lounch(String url)
		{      
		      driver.get(url);
		      driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			  driver.manage().window().maximize();
		      driver.manage().deleteAllCookies();
		      reg=new RegPage(driver);
		      index=new IndexPage(driver);
		      index.RegBtnClick(); 
	    }
		@Test(dataProvider="Registration", groups= {"Regression"})
		public void RegTest(String fname,String lname,String Email,String Cname,String pwd,String Cpwd,String DOD,String DOM,String DOY,String res) throws InterruptedException
		{  
//		System.out.println(fname);
//		System.out.println(lname);
//		System.out.println(Email);
//		System.out.println(Cname);
//		System.out.println(pwd);
//		System.out.println(Cpwd);
//		System.out.println(DOD);
//		System.out.println(DOM);
//		System.out.println(DOY);
//		System.out.println(res);
			
		reg.FirstNameField(fname);
		reg.LastnameField(lname);
		reg.EmailIdField(Email);
		reg.CompanyNameFieled(Cname);
		reg.PasswordField(pwd);
		reg.ConPassFields(Cpwd);
		reg.DOBDayDropDown(DOD);
		reg.DOBMonthDropDown(DOM);
		reg.DOBYearDropDown(DOY);
		Action.scrollElement(driver,RegPage.RegBtn);
		Thread.sleep(2000);
	    reg.clickRegBtn();   
	    Thread.sleep(2000);
	    //For valid test
	    if (res.equals("Valid"))
		 {
	    	String exp_url="https://demo.nopcommerce.com/registerresult/1?returnUrl=/";
	 	    String act_url=driver.getCurrentUrl();
	 	    System.out.println(act_url);
	    	//For valid test new account have not exist not exist 
		    if(act_url.equals(exp_url))
		    {       
		    	    System.out.println("Successfully registratared");
		    	    driver.findElement(By.xpath("(//a[normalize-space()='Log out'])[1]")).click();
			        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
			        Assert.assertTrue(true);    
		    }
		    //For valid test new account already exist
		    else if(!act_url.equals(exp_url))
		    {
		 	        String ex="The specified email already exists";
		 	    	String ac=driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']//ul")).getText();
		 	        Assert.assertEquals(ex,ac);
		 	        System.out.println("The specified email already exists");
		 	        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
		 	}
		    else 
		    {
		        Assert.assertTrue(false);
		    } 
       }
	    
	    //For Invalid test
	    else if(res.equals("Invalid"))
		{   
	    	String exp_url="https://demo.nopcommerce.com/registerresult/1?returnUrl=/";
	 	    String act_url=driver.getCurrentUrl();
	 	    System.out.println(act_url);
			if(act_url.equals(exp_url))
			{
				Assert.assertTrue(false);
				driver.findElement(By.xpath("//a[@class='ico-register']")).click();

			}
			else
			{
				Assert.assertTrue(true);
				
			}
		}
						
		}
		
}