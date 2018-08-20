package appModules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import pageObjects.LoginPage;
import pageObjects.SoftAsertion;
import utility.Constants;
import utility.ExcelUtility;
import utility.PlugInFunctions;

public class Login {
	

	public static WebDriver RequesterLogin(WebDriver driver,ExtentReports report) throws InterruptedException
	{
		ExtentTest logger = report.startTest("Verify User Login to Web");
		LoginPage.txt_UserName(driver).sendKeys("P000004");
		SoftAsertion.txtVerify(driver,LoginPage.txt_UserName(driver), logger, "username  ");
		LoginPage.txt_Password(driver).sendKeys("Incture@12");
		SoftAsertion.txtVerify(driver,LoginPage.txt_Password(driver), logger, "password  ");
		LoginPage.btn_clklogin(driver).click();
		SoftAsertion.txtVerify(driver, LoginPage.btn_clklogin(driver), logger, "button  ");
		//new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PlugInFunctions.loadXPathfile().getProperty("btn_create_return"))));
		//Assert.assertEquals("Create Referenced",LoginPage.btn_create_return(driver).getText());
		Logout(driver, report);
		
		
		report.endTest(logger);
		report.flush();
		SoftAsertion.sf.assertAll();
		return driver;
}
	public static WebDriver ZPapproverLogin(WebDriver driver,ExtentReports report) throws InterruptedException
	{
		ExtentTest logger = report.startTest("Verify that ZP Approver is having permissions specific to his role");
		LoginPage.txt_UserName(driver).sendKeys("P000011");
		SoftAsertion.txtVerify(driver,LoginPage.txt_UserName(driver), logger, "username  ");
		LoginPage.txt_Password(driver).sendKeys("May@2018");
		SoftAsertion.txtVerify(driver,LoginPage.txt_Password(driver), logger, "password  ");
		LoginPage.btn_clklogin(driver).click();
		SoftAsertion.txtVerify(driver, LoginPage.btn_clklogin(driver), logger, "button  ");
		//new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PlugInFunctions.loadXPathfile().getProperty("Approver_inbox"))));
		//Assert.assertEquals("Inbox",LoginPage.btn_Approver_inbox(driver).getText());
		Logout(driver, report);
		
		
		report.endTest(logger);
		report.flush();
		SoftAsertion.sf.assertAll();
		return driver;
		
}
	public static WebDriver PrincipalapproverLogin(WebDriver driver,ExtentReports report) throws InterruptedException
	{
		ExtentTest logger = report.startTest("Verify that Principal Approver is having permissions specific to his role");
		LoginPage.txt_UserName(driver).sendKeys("P000003");
		SoftAsertion.txtVerify(driver,LoginPage.txt_UserName(driver), logger, "username  ");
		LoginPage.txt_Password(driver).sendKeys("Incture@16");
		SoftAsertion.txtVerify(driver,LoginPage.txt_Password(driver), logger, "password  ");
		LoginPage.btn_clklogin(driver).click();
		SoftAsertion.txtVerify(driver, LoginPage.btn_clklogin(driver), logger, "button  ");
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PlugInFunctions.loadXPathfile().getProperty("Approver_inbox"))));

		Assert.assertEquals("Inbox",LoginPage.btn_Approver_inbox(driver).getText());
		Logout(driver, report);
		
		
		report.endTest(logger);
		report.flush();
		SoftAsertion.sf.assertAll();
		return driver;
	}
	
	public static WebDriver RequesterinvalidLogin(WebDriver driver,ExtentReports report)
	{
		ExtentTest logger = report.startTest("Verify User Login to Web with invalid credentials");
		LoginPage.txt_UserName(driver).sendKeys("P000004");
		SoftAsertion.txtVerify(driver,LoginPage.txt_UserName(driver), logger, "username  ");
		LoginPage.txt_Password(driver).sendKeys("Incture@1dehd");
		SoftAsertion.txtVerify(driver,LoginPage.txt_Password(driver), logger, "password  ");
		LoginPage.btn_clklogin(driver).click();
		SoftAsertion.txtVerify(driver, LoginPage.btn_clklogin(driver), logger, "button  ");
		Assert.assertEquals("Invalid Login credentials.",LoginPage.invalidLogin_errorMessage(driver).getText());
		LoginPage.invalidbtnOK_login_err_msg_popup(driver).click();
		Assert.assertEquals("Login", LoginPage.btn_clklogin(driver).getText());
		report.endTest(logger);
		report.flush();
		SoftAsertion.sf.assertAll();
		return driver;
	
	}
	public static WebDriver emptyLogin(WebDriver driver,ExtentReports report)
	{
		ExtentTest logger = report.startTest("Verify User Login to Web with empty values");
		LoginPage.txt_UserName(driver).clear();
		SoftAsertion.txtVerify(driver,LoginPage.txt_UserName(driver), logger, "username  ");
		LoginPage.txt_Password(driver).clear();
		SoftAsertion.txtVerify(driver,LoginPage.txt_Password(driver), logger, "password  ");
		LoginPage.btn_clklogin(driver).click();
		SoftAsertion.txtVerify(driver, LoginPage.btn_clklogin(driver), logger, "button  ");
		Assert.assertEquals("Please enter username.",LoginPage.emptylogin_error_message(driver).getText());
		LoginPage.btnOK_emptylogin_err_msg_popup(driver).click();
		Assert.assertEquals("Login", LoginPage.btn_clklogin(driver).getText());
		report.endTest(logger);
		report.flush();
		SoftAsertion.sf.assertAll();
		return driver;
		
	}
	
	public static WebDriver Logout(WebDriver driver,ExtentReports report) 
	{
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='__toolbar0']/div/button")));
		
			//boolean visiblie=PlugInFunctions.checkVisibiltyOfElement(driver, PlugInFunctions.loadXPathfile().getProperty("icon_logout"));
			LoginPage.icon_logout(driver).click();
		LoginPage.btn_logout(driver).click();
		//SoftAsertion.txtVerify(driver, LoginPage.btn_clklogin(driver),logger, "button  ");
		Assert.assertEquals("Login", LoginPage.btn_clklogin(driver).getText());
		return driver;
		
	}
}