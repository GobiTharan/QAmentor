package qa.qamentor.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import qa.qamentor.utils.Platform;

public class EdgeBrowser implements Browser {

	private WebDriver edgeDriver;

	public EdgeBrowser() {
		String OSName=Platform.OS.toUpperCase();
		System.setProperty(ApplicationConstants.EDGE_DRIVER_NAME,ApplicationConstants.EDGE_DRIVER_PATH_WINDOWS);
		edgeDriver = new EdgeDriver();		
	}

	public String getBrowserName() {
		return ((RemoteWebDriver) edgeDriver).getCapabilities()
				.getBrowserName();
	}

	public String getVersion() {
		return ((RemoteWebDriver) edgeDriver).getCapabilities().getVersion();
	}

	public WebDriver getDriver() {
		return edgeDriver;
	}

}
