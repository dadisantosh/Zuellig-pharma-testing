
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.PlugInFunctions;

public class LoginPage {
	private static WebElement element;

	public static WebElement txt_UserName(WebDriver driver) {
		element = PlugInFunctions.expWait(driver, PlugInFunctions.loadXPathfile().getProperty("txt_UserName"));
	
		return element;
	}

	public static WebElement txt_Password(WebDriver driver) {
		element = PlugInFunctions.expWait(driver, PlugInFunctions.loadXPathfile().getProperty("txt_Password"));
		return element;
	}

	public static WebElement btn_clklogin(WebDriver driver) {
		element = PlugInFunctions.expWait(driver, PlugInFunctions.loadXPathfile().getProperty("btn_clklogin"));
		return element;

}
	public static WebElement icon_logout(WebDriver driver) {
		element = PlugInFunctions.expWait(driver, PlugInFunctions.loadXPathfile().getProperty("icon_logout"));
		return element;
	}
	public static WebElement btn_logout(WebDriver driver) {
		element = PlugInFunctions.expWait(driver, PlugInFunctions.loadXPathfile().getProperty("btn_logout"));
		return element;
	}
	public static WebElement btn_create_return(WebDriver driver) {
		element = PlugInFunctions.expWait(driver, PlugInFunctions.loadXPathfile().getProperty("btn_create_return"));
		return element;
	}
	public static WebElement invalidLogin_errorMessage(WebDriver driver) {
		element = PlugInFunctions.expWait(driver, PlugInFunctions.loadXPathfile().getProperty("invalidLogin_errorMessage"));
		return element;
	}
	public static WebElement invalidbtnOK_login_err_msg_popup(WebDriver driver) {
		element = PlugInFunctions.expWait(driver, PlugInFunctions.loadXPathfile().getProperty("btnOK_invalidlogin_err_msg_popup"));
		return element;
	}
	public static WebElement btn_Approver_inbox(WebDriver driver) {
		element = PlugInFunctions.expWait(driver, PlugInFunctions.loadXPathfile().getProperty("Approver_inbox"));
		return element;
	}
	public static WebElement emptylogin_error_message(WebDriver driver) {
		element = PlugInFunctions.expWait(driver, PlugInFunctions.loadXPathfile().getProperty("emptylogin_error_message"));
		return element;
	}
	public static WebElement btnOK_emptylogin_err_msg_popup(WebDriver driver) {
		element = PlugInFunctions.expWait(driver, PlugInFunctions.loadXPathfile().getProperty("btnOK_emptylogin_error_message_popup"));
		return element;
	}
}
