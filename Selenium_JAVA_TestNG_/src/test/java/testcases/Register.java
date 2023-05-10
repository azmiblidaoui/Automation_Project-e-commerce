package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Register {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
	String browserName= "chrome";
	if(browserName.equals("chrome")) {
	driver = new ChromeDriver();
		
	}
	else if(browserName.equals("farefox"))
	{
	driver = new FirefoxDriver();
	}
	else if(browserName.equals("edge")) {
	driver = new EdgeDriver();
	}
	driver.manage().window().maximize();
	driver.get("https://tutorialsninja.com/demo/");
	driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
	driver.findElement(By.linkText("Register")).click();
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	
	
	@Test(priority = 1)
	public void registering_an_account_with_mandatory_fields() {
		
		driver.findElement(By.id("input-firstname")).sendKeys("test");
		driver.findElement(By.id("input-lastname")).sendKeys("test");
		driver.findElement(By.id("input-email")).sendKeys("t11@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("123");
		driver.findElement(By.id("input-password")).sendKeys("azerty@@123");
		driver.findElement(By.id("input-confirm")).sendKeys("azerty@@123");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String actualSuccessHeading = driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();
		Assert.assertEquals(actualSuccessHeading,"Your Account Has Been Created!");
	}
	@Test(priority = 2)
	public void verify_Registering_Account_By_providin_All_fields() {

		driver.findElement(By.id("input-firstname")).sendKeys("test");
		driver.findElement(By.id("input-lastname")).sendKeys("test");
		driver.findElement(By.id("input-email")).sendKeys("t22@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("123");
		driver.findElement(By.id("input-password")).sendKeys("azerty@@123");
		driver.findElement(By.id("input-confirm")).sendKeys("azerty@@123");
		driver.findElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String actualSuccessHeading = driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();
		Assert.assertEquals(actualSuccessHeading,"Your Account Has Been Created!");
	}
	@Test(priority =3)
	public void verify_Registering_Account_with_existing_email_address() {
		driver.findElement(By.id("input-firstname")).sendKeys("test");
		driver.findElement(By.id("input-lastname")).sendKeys("test");
		driver.findElement(By.id("input-email")).sendKeys("t22@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("123");
		driver.findElement(By.id("input-password")).sendKeys("azerty@@123");
		driver.findElement(By.id("input-confirm")).sendKeys("azerty@@123");
		driver.findElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String actualWarning = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		Assert.assertTrue(actualWarning.contains("Warning: E-Mail Address is already registered!"),"warning message not displayed ");
		
	}

}
