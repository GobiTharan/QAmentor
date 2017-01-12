package qa.qamentor.config;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import qa.qamentor.utils.Platform;



/**
 * Class to configure and get Details for Firefox Browser
 * @author babu.sathiyaraja
 * 
 */
public class FirefoxBrowser implements Browser {

	private WebDriver firefoxDriver;
	private DesiredCapabilities caps;
	public static final Log log = LogFactory
			.getLog(qa.qamentor.config.FirefoxBrowser.class);

	public FirefoxBrowser() throws Exception  {
	
		/* String USERNAME = "mohamedibrahim2806";
	      String ACCESS_KEY = "c4c0e305-7822-425a-9db2-8553900928b8";
	      System.out.println("Enteredfirefoxsauce");
	  
	       String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
	     //  firefoxDriver=new FirefoxDriver();
	       caps=DesiredCapabilities.firefox();
	       caps.setCapability("platform", "Windows 7");
	       caps.setCapability("version", "43.0");
	       firefoxDriver = new RemoteWebDriver(new URL(URL), caps);*/
	
	
		
		
		
		log.info("Calling FirefoxBrowser constructor and return Firefox Driver Object");
		firefoxDriver = new FirefoxDriver();
	/*	String OSName=Platform.OS.toUpperCase();
		if(OSName.contains("WINDOWS")){
			System.setProperty(ApplicationConstants.GECKO_DRIVER_NAME,ApplicationConstants.GECKO_DRIVER_PATH_WINDOWS);

		}
		else if(OSName.contains("MAC")){
			System.setProperty(ApplicationConstants.GECKO_DRIVER_NAME,ApplicationConstants.GECKO_DRIVER_PATH_MAC_OS);

		}
	    firefoxDriver = new FirefoxDriver();*/
		 


	}

	public String getBrowserName() {
		return ((RemoteWebDriver) firefoxDriver).getCapabilities()
				.getBrowserName();
	}

	public String getVersion() {
		return ((RemoteWebDriver) firefoxDriver).getCapabilities().getVersion();
	}

	public WebDriver getDriver() {
		return firefoxDriver;
	}

}
