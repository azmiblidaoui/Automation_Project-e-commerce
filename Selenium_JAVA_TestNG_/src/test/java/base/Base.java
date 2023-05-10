package base;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	WebDriver driver;
	public WebDriver initialize_broxser_and_oppen_application(String browserName) {
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
		
		
		return driver;
		
	}

}
