package TestClass;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.base.BaseClass1;
import com.pageObject.IndexPage;
import com.pageObject.LoginPage;
import com.utility.XLUtility;
@Listeners(com.utility.ListenerClass01.class)
public class LoginTest extends BaseClass1 {
	  LoginPage loginPage;
	  IndexPage index;
	  @Parameters("url")
	@BeforeClass(groups= { "smoke","sanity","Regression"})//	Compulsory (groups= { "smoke","sanity","Regression"}) should take here if doing grouping testing
	  public void Lounch(String url)
	  {      
	      driver.get(url);
	      driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		  driver.manage().window().maximize();
	      driver.manage().deleteAllCookies();
	      index=new IndexPage(driver); //go into login page
	      loginPage=new LoginPage(driver);// Inside the login page   
//	      index.logInPageBtnClick(); 
	      index.logInPageBtnClick(); 
	}
	@Test(groups= "sanity")
	public void EmailFieldDisplayedValidation()
	{
		Boolean disp=loginPage.EmailFieldDisplayed();
		Assert.assertTrue(disp);
	}
	@Test(groups= "sanity")
	public void PasswordFieldDisplayedValidtion()
	{		
		Boolean disp=loginPage.PasswordFieldDisplayed();
		Assert.assertTrue(disp);	
	}
	@Test
	public void LogInBtnDisplayValidtion()
	{
		Boolean disp=loginPage.LogInBtnDisplay();
		Assert.assertTrue(disp);
	}
	@Test(dataProvider="LoginData",groups= "sanity")
	public void loginTestValids(String user,String pwd,String exp) throws InterruptedException
	{   
		loginPage.EmailFields(user);
		loginPage.passwordFields(pwd);
		loginPage.LogInBtnClick();
		Thread.sleep(3000);
				    String exp_url="https://demo.nopcommerce.com/";
					String act_url=driver.getCurrentUrl();
					if(exp.equals("Valid")) //actions
					{
						if(exp_url.equals(act_url))
						{
							driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
							index.logInPageBtnClick();  
							Assert.assertTrue(true);
							System.out.println("Successfully log in");
						}
						//make some change if valid but unregistered
						else
						{	
							System.out.println(user+" and "+pwd+" No customer account found or unregistered can considered as pass");
						    Assert.assertTrue(false);
						}
					}				
					
					else if(exp.equals("Invalid"))
					{
						if(exp_url.equals(act_url))
						{
							driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
							index.logInPageBtnClick();  
							Assert.assertTrue(false);
						}
						//make some change for exact invalid 
						else
						{
							Assert.assertTrue(true);
						}
					}		
	}
	
}