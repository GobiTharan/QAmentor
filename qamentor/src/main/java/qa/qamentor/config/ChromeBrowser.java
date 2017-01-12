package qa.qamentor.config;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import qa.qamentor.utils.Platform;
/**
 * Class to configure and get Details for Chrome Browser
 * 
 * @author babu.sathiyaraja
 * 
 */
public class ChromeBrowser implements Browser {

	private WebDriver chromeDriver;
	private DesiredCapabilities caps;

	public ChromeBrowser() throws Exception {
		String OSName=Platform.OS.toUpperCase();
		if(OSName.contains("WINDOWS")){
		System.setProperty(ApplicationConstants.CHROME_DRIVER_NAME,
				ApplicationConstants.CHROME_DRIVER_PATH_WINDOWS);
		}
		else if(OSName.contains("MAC")){
			System.setProperty(ApplicationConstants.CHROME_DRIVER_NAME,
					ApplicationConstants.CHROME_DRIVER_PATH_MAC_OS);
		}
		chromeDriver = new ChromeDriver();		
		

		/* String USERNAME = "mohamedibrahim2806";
	      String ACCESS_KEY = "c4c0e305-7822-425a-9db2-8553900928b8";
	      System.out.println("Enteredchromesauce");
	  
	       String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
	     //  firefoxDriver=new FirefoxDriver();
	       caps=DesiredCapabilities.chrome();
	       caps.setCapability("platform", "Windows 7");
	       caps.setCapability("version", "43.0");
	       chromeDriver = new RemoteWebDriver(new URL(URL), caps);
	*/
		
		
		
		
	}

	public String getBrowserName() {
		return ((RemoteWebDriver) chromeDriver).getCapabilities()
				.getBrowserName();
	}

	public String getVersion() {
		return ((RemoteWebDriver) chromeDriver).getCapabilities().getVersion();
	}

	public WebDriver getDriver() {
		return chromeDriver;
	}

}
