package utility;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.BaseClass;

public class Utils{
		
	

	public static WebDriver driver = null;
	public static WebDriver OpenBrowser(int iTestCaseRow) throws Exception{
		
		
		String sBrowserName;
		try{
		sBrowserName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Browser);
		if(sBrowserName.equals("chrome")){
			System.out.println("Utils_OpenBrowser  -----    Equals_val > " + sBrowserName.equals("chrome"));
			
			System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		//	for(Cookie cookie : allCookies)
			//{
			//    driver.manage().addCookie(cookie);
			//}
			driver = new ChromeDriver(capabilities);
			//driver = new FirefoxDriver();
			System.out.println("driver value from utils - " + driver );
			
			Log.info("New driver instantiated");
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    Log.info("Implicit wait applied on the driver for 10 seconds");
		    driver.get(Constant.URL);
		    Log.info("Web application launched successfully");
			}else
		
		
		if(sBrowserName.equals("firefox")){
			System.out.println("Utils_OpenBrowser  -----    Equals_val > " + sBrowserName.equals("chrome"));
			
			
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		//	for(Cookie cookie : allCookies)
			//{
			//    driver.manage().addCookie(cookie);
			//}

			driver = new FirefoxDriver();
			System.out.println("driver value from utils - " + driver );
			
			Log.info("New driver instantiated");
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    Log.info("Implicit wait applied on the driver for 10 seconds");
		    driver.get(Constant.URL);
		    Log.info("Web application launched successfully");
			}
		
		
		
		
		}catch (Exception e){
			Log.error("Class Utils | Method OpenBrowser | Exception desc : "+e.getMessage());
		}
		return driver;
	}
	
	public static String getTestCaseName(String sTestCase)throws Exception{
		String value = sTestCase;
		try{
			int posi = value.indexOf("@");
			value = value.substring(0, posi);
			posi = value.lastIndexOf(".");	
			value = value.substring(posi + 1);
			return value;
				}catch (Exception e){
			Log.error("Class Utils | Method getTestCaseName | Exception desc : "+e.getMessage());
			throw (e);
					}
			}
	
	 public static void mouseHoverAction(WebElement mainElement, String subElement){
		
		 Actions action = new Actions(driver);
         action.moveToElement(mainElement).perform();
      //if conditions in all 
         
         action.click();
         action.perform();
         Log.info("Click action is performed on the selected Product Type");
	 }
	 public static void waitForElement(WebElement element){
		 
		 WebDriverWait wait = new WebDriverWait(driver, 10);
	     wait.until(ExpectedConditions.elementToBeClickable(element));
	 	}
		
	 public static void takeScreenshot(WebDriver driver, String sTestCaseName) throws Exception{
			try{
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(Constant.Path_ScreenShot + sTestCaseName +".jpg"));	
			} catch (Exception e){
				Log.error("Class Utils | Method takeScreenshot | Exception occured while capturing ScreenShot : "+e.getMessage());
				throw new Exception();
			}
		}
	 
	 
	}
