

package TestNG;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import appModules.Login;
import utility.Constants;
import utility.ExcelUtils;
import utility.LaunchBrowser;
import utility.PlugInFunctions;

public class ZP_scripts {
	ExtentReports report = PlugInFunctions.reportGeneration(); 
	WebDriver driver;
	@BeforeClass
	public void before() throws Exception
	{
		System.out.println("before");
		driver=LaunchBrowser.execute(driver, report);
                System.out.println("webdriver executed"); 	
	}
	@Test(priority=1)
	public void testcase1() throws InterruptedException
	{
		Login.RequesterLogin(driver, report);
	}
	@Test(priority=2)
	public void testcase2()
	{
	Login.RequesterinvalidLogin(driver, report);
	}
	@Test(priority=3)
	public void testcase3()
	{
		Login.emptyLogin(driver, report);
	}
	@Test(priority=4)
	public void testcase4() throws InterruptedException 
	{
		Login.RequesterLogin(driver, report);
	}
	@Test(priority=5)
	public void testcase5() throws InterruptedException
	{
		Login.ZPapproverLogin(driver, report);
	}
	@Test(priority=6)
	public void testcase6() throws InterruptedException
	{
		Login.PrincipalapproverLogin(driver, report);
	}
	@AfterClass
	public void after() throws Exception
	{
		System.out.println("after");
		
               driver.close();
	}
	

}
