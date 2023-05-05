package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


@Test
public class Register {
	public void registering_an_account_with_mandatory_fields() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("test");
		driver.findElement(By.id("input-lastname")).sendKeys("test");
		driver.findElement(By.id("input-email")).sendKeys("tt5820445724@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("123");
		driver.findElement(By.id("input-password")).sendKeys("azerty@@123");
		driver.findElement(By.id("input-confirm")).sendKeys("azerty@@123");
		driver.quit();
		
		
		
		
	}

}
