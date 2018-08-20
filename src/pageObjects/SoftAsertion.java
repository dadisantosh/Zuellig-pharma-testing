
package pageObjects;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utility.Constants;
import utility.ExcelUtility;
import utility.PlugInFunctions;

public class SoftAsertion {
	public static boolean status;
	public static SoftAssert sf=new SoftAssert();
	
	public static void txtVerify(WebDriver driver,WebElement ele, ExtentTest logger,String msg)
	{
		
		status=isenabled(driver,ele,logger,msg);
		/*if(status==true)
		{
			sf.assertTrue(status,msg+"enabled" );
			logger.log(LogStatus.PASS, msg+"enabled");
		}
		else
		{
			sf.assertTrue(status,msg+"disabled" );
			PlugInFunctions.errorHandling(driver, status, logger,msg+"disabled" );
		}*/
	}
	
	public static boolean  isenabled(WebDriver driver,WebElement ele,ExtentTest logger,String msg)
	{
		String eleTagName=ele.getTagName();
		//System.out.println(eleTagName);
		if(ele.isDisplayed())
		{
			status=true;
			logger.log(LogStatus.PASS, msg+"element is displayed");
		}
		else
		{
			logger.log(LogStatus.PASS, msg+"element not displayed");
		}
			if(status==true)
			{
				status=	ele.isEnabled();
				logger.log(LogStatus.PASS, msg+"element is enabled");
			
				if(status==true)
				{
			String value=ele.getAttribute("value");
			System.out.println(value);
					
					
					 if(eleTagName.equals("button"))
					{
						status=true;
						logger.log(LogStatus.PASS, msg+"element is not editable it is button");
						
					}
					 else if(!value.equals(null))
						{
							
							status= true;
							logger.log(LogStatus.PASS, msg+"textfield is editable");
						}
				}
			}
		else	
		{
			logger.log(LogStatus.PASS, msg+"element is not enabled");
		
	}
			return status;
	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public static SoftAssert verify(WebDriver driver,ExtentTest logger,String from_excel,String from_textField,String msg) throws InterruptedException
	{
		
		
	sf.assertEquals(from_excel, from_textField);
	
	if(from_excel.equals(from_textField))
	{
		logger.log(LogStatus.INFO,msg+"successfully" );
	}
	else
	{
	boolean results=false;	
	Thread.sleep(3000);
		PlugInFunctions.errorHandling(driver, results, logger,msg );
	}
	

	return sf;
	}	
	public static void checkElement(WebDriver driver,boolean check,ExtentTest logger,String enableStatus,String disableStatus)
	{
	if(check==true){
		
		logger.log(LogStatus.INFO,enableStatus );
		
	}
	else
	{
		PlugInFunctions.errorHandling(driver, check, logger,disableStatus );

	}
	}		*/
	
	}


