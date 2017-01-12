package qa.qamentor.config;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import qa.qamentor.utils.Directory;

import io.appium.java_client.ios.IOSDriver;

public class IOSSetup {
	
	 public static IOSDriver driver;
	 public static IOSDriver getDriver() throws Exception {
	  System.out.println("Started IOS Driver");
	 
	  DesiredCapabilities capabilities = new DesiredCapabilities();
	  File appDir = new File(Directory.MOBILE_APPPATH);
	  File app = new File(appDir, Directory.MOBILEAPP_APK_NAME);
	  capabilities.setCapability("platformName", "iOS");
	  capabilities.setCapability("platformName", "Mac");
	   if(Directory.MOBILE_DEVICE_TYPE.equalsIgnoreCase("real")) {
	   System.out.println("Launch on real device");
	   capabilities.setCapability("deviceName", Directory.MOBILE_DEVICE_NAME);
	   capabilities.setCapability("platformVersion", Directory.MOBILE_DEVICE_VERSION);
	   capabilities.setCapability("udid", Directory.MOBILE_IOSDEVICE_UDID); 
	   if(Directory.MOBILE_APP_TYPE.equalsIgnoreCase("native")) {
	    capabilities.setCapability("app",Directory.MOBILE_APPPATH);
	    capabilities.setCapability("app",app.getAbsoluteFile());
	    capabilities.setCapability("bundleId",Directory.MOBILE_APK_APPPACKAGE);
	   }
	   else if(Directory.MOBILE_APP_TYPE.equalsIgnoreCase("web")) {
	    capabilities.setCapability("browserName", "safari");
	   }
	  }
	  else if (Directory.MOBILE_DEVICE_TYPE.equalsIgnoreCase("simulator")) {
	   System.out.println("Launch on Simulator");
	   capabilities.setCapability("deviceName", Directory.MOBILE_DEVICE_NAME);
	   capabilities.setCapability("platformVersion", Directory.MOBILE_DEVICE_VERSION); 
	   if(Directory.MOBILE_APP_TYPE.equalsIgnoreCase("native")) {
	    capabilities.setCapability("bundleId",Directory.MOBILE_APK_APPPACKAGE);
	    capabilities.setCapability("app",Directory.MOBILE_APPPATH);

	   }
	   else if(Directory.MOBILE_APP_TYPE.equalsIgnoreCase("web")) {
	    capabilities.setCapability("browserName", "safari");
	   }
	  }
	  //capabilities.setCapability("app","/Applications/Xcode.app/Contents/Developer/Applications/Simulator.app");
	  driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	  
	  
	  return  driver;
	 }
	

}
