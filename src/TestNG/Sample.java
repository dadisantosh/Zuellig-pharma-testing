package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Sample {
	
	public static WebDriver driver;
	@BeforeMethod
	public void openbrowser()
	{
		
		System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
		public void open()
	{
		driver.get("http://google.com");
	}
	
	

}
