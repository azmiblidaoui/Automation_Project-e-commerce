package testcases;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;

public class Login extends Base {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
	
	
		driver = initialize_broxser_and_oppen_application("chrome");
		
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		
	}
	@AfterMethod 
	public void tearDown() {
		driver.quit();
	}
	@Test(priority = 1)
	public void Login_with_valid_Credentilials()
	{
		driver.findElement(By.id("input-email")).sendKeys("tt5820724@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("azerty@@123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	}
	@Test(priority = 2)
	public void Login_with_invalid_Credentilials()
	{
		
		driver.findElement(By.id("input-email")).sendKeys("tt5820724ttt@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("azerty1234");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String actual_warning_message = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		String expected_warning_message = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actual_warning_message.contains(expected_warning_message),"Expected Warning Message is not displayed");
		
		
	}
	

}
