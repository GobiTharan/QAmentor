package qa.qamentor.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import qa.qamentor.utils.Platform;

 

 

/**
 * Class to configure and get Details for Safari Browser
 * @author Praba
 * 
 */
public class SafariBrowser implements Browser {

	private WebDriver safariDriver;
	public static final Log log = LogFactory
			.getLog(qa.qamentor.config.SafariBrowser.class);

	public SafariBrowser() {
		String OSName=Platform.OS.toUpperCase();
		  if(OSName.contains("WINDOWS")){
			   System.setProperty(ApplicationConstants.SAFARI_DRIVER_NAME,ApplicationConstants.SAFARI_DRIVER_PATH_WINDOWS);

			   }
			   else if(OSName.contains("MAC")){
			    System.setProperty(ApplicationConstants.SAFARI_DRIVER_NAME,ApplicationConstants.SAFARI_DRIVER_PATH_MAC_OS);

			   }
			  log.info("Calling SafariBrowser constructor and return Safari Driver Object");
			  safariDriver = new SafariDriver();
				
	}

	public String getBrowserName() {
		return ((RemoteWebDriver) safariDriver).getCapabilities()
				.getBrowserName();
	}

	public String getVersion() {
		return ((RemoteWebDriver) safariDriver).getCapabilities().getVersion();
	}

	public WebDriver getDriver() {
		return safariDriver;
	}
}