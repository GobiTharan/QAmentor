package qa.qamentor.commands;



import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.awt.Toolkit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import qa.qamentor.utils.Directory;

public class LayoutActions {
	/*@Override
	    public WebDriver createDriver(Object[] args) {
	        return new FirefoxDriver();
	    }

	    @Test
	    public void welcomePage_shouldLookGood_onDesktopDevice() {
	        load("http://example.com", 1024, 768);
	        checkLayout("/specs/welcomePage.spec", asList("mobile"));
	    }*/

	public static int screenWidth;
	public static int screenHeight;
	public static String returnValue;

	public static String screenResolution(AndroidDriver driver) {
		//		screenHeight = driver.manage().window().getSize().getHeight();
		//		screenWidth = driver.manage().window().getSize().getWidth();

		String[] dimensions = driver.manage().window().getSize().toString().split("\\D");
		screenWidth = Integer.parseInt(dimensions[1]);
		screenHeight = Integer.parseInt(dimensions[3]);

		/*java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenWidth = (int) screenSize.getWidth();
		screenHeight = (int) screenSize.getHeight();*/

		String screenResolutionValue= new Integer(screenWidth).toString() +"*" + new Integer(screenHeight).toString();
		return screenResolutionValue;
	}

	public static String compareScreenResolution(AndroidDriver driver) {
		screenHeight = driver.manage().window().getSize().getHeight();
		screenWidth = driver.manage().window().getSize().getWidth();
		String screenResolutionValue= new Integer(screenWidth).toString() +"*" + new Integer(screenHeight).toString();
		if(!Directory.MOBILE_SCREEN_RESOLUTION_SIZE.equals(screenResolutionValue)) {
			screenResolutionValue = "Screen resolution size is not matched, Size = "+screenResolutionValue;
			Assert.assertTrue(Directory.MOBILE_SCREEN_RESOLUTION_SIZE.equals(screenResolutionValue),screenResolutionValue);
		}
		return screenResolutionValue;
	}
	
	public static String elementResolution(AndroidDriver driver,WebElement element) {
		screenHeight = driver.manage().window().getSize().getHeight();
		screenWidth = driver.manage().window().getSize().getWidth();
		Point elementLoc = element.getLocation();
		Dimension elementDim = element.getSize();
		int elementLeftX = elementLoc.getX();
		int elementRightX = elementLeftX + elementDim.getWidth();
		int elementTopY = elementLoc.getY();
		int elementBottomY = elementTopY + elementDim.getHeight();
		//System.out.println("Webelement: X->"+elementRightX+" Y->"+elementBottomY);
		returnValue= new Integer(elementLeftX).toString() +" , " + new Integer(elementRightX).toString() + " , " + new Integer(elementTopY).toString() +" , " + new Integer(elementBottomY).toString();;
		/* if((elementRightX <= screenWidth) && (elementBottomY <= screenHeight)) {
	    	returnValue = new Integer(elementLeftX).toString() +" , " + new Integer(elementRightX).toString() + " , " + new Integer(elementTopY).toString() +" , " + new Integer(elementBottomY).toString();
	    }
	    else {
	    	returnValue = "oops! Element is overlapped the page resolutions";
	    	Assert.assertTrue((elementRightX <= screenWidth) && (elementBottomY <= screenHeight),returnValue+"elementRightX"+elementRightX+"elementBottomY"+elementBottomY);
	    }*/
		return returnValue;
	}
	
	public static String compareImage(AndroidDriver driver,WebElement element,String dimension) {
		screenHeight = driver.manage().window().getSize().getHeight();
		screenWidth = driver.manage().window().getSize().getWidth();
		Dimension elementDim = element.getSize();
		String[] imageDimension = elementDim.toString().split(",");
		String[] coordinates = dimension.split(",");
	if(coordinates[0].trim().equals(imageDimension[0].trim()) && coordinates[1].equals(imageDimension[1].trim()) ) {
		returnValue = "Image has displayed correctly";
	} else {
		returnValue = "Oops!, Compare image not display correctly, Displayed Image Dimension:"+elementDim;
		Assert.assertTrue(coordinates[0].trim().equals(imageDimension[0].trim()) && coordinates[1].equals(imageDimension[1].trim()),returnValue);
	}
		
		return returnValue;
	}

	public static String screenResolution(WebDriver driver) {
		//		screenHeight = driver.manage().window().getSize().getHeight();
		//		screenWidth = driver.manage().window().getSize().getWidth();

		String[] dimensions = driver.manage().window().getSize().toString().split("\\D");
		screenWidth = Integer.parseInt(dimensions[1]);
		screenHeight = Integer.parseInt(dimensions[3]);

		/*java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenWidth = (int) screenSize.getWidth();
		screenHeight = (int) screenSize.getHeight();*/

		String screenResolutionValue= new Integer(screenWidth).toString() +"*" + new Integer(screenHeight).toString();
		return screenResolutionValue;
	}

	public static String compareScreenResolution(WebDriver driver) {
		screenHeight = driver.manage().window().getSize().getHeight();
		screenWidth = driver.manage().window().getSize().getWidth();
		String screenResolutionValue= new Integer(screenWidth).toString() +"*" + new Integer(screenHeight).toString();
		if(!Directory.WEB_SCREEN_RESOLUTION_SIZE.equals(screenResolutionValue)) {
			screenResolutionValue = "Screen resolution size is not matched, Size = "+screenResolutionValue;
			Assert.assertTrue(Directory.WEB_SCREEN_RESOLUTION_SIZE.equals(screenResolutionValue),screenResolutionValue);
		}
		return screenResolutionValue;
	}

	public static String elementResolution(WebDriver driver,WebElement element) {
		screenHeight = driver.manage().window().getSize().getHeight();
		screenWidth = driver.manage().window().getSize().getWidth();
		Point elementLoc = element.getLocation();
		Dimension elementDim = element.getSize();
//		System.out.println("Dimension"+elementDim);
		int elementLeftX = elementLoc.getX();
		int elementRightX = elementLeftX + elementDim.getWidth();
		int elementTopY = elementLoc.getY();
		int elementBottomY = elementTopY + elementDim.getHeight();
		//System.out.println("Webelement: X->"+elementRightX+" Y->"+elementBottomY);
		returnValue= new Integer(elementLeftX).toString() +" , " + new Integer(elementRightX).toString() + " , " + new Integer(elementTopY).toString() +" , " + new Integer(elementBottomY).toString();;
		/* if((elementRightX <= screenWidth) && (elementBottomY <= screenHeight)) {
	    	returnValue = new Integer(elementLeftX).toString() +" , " + new Integer(elementRightX).toString() + " , " + new Integer(elementTopY).toString() +" , " + new Integer(elementBottomY).toString();
	    }
	    else {
	    	returnValue = "oops! Element is overlapped the page resolutions";
	    	Assert.assertTrue((elementRightX <= screenWidth) && (elementBottomY <= screenHeight),returnValue+"elementRightX"+elementRightX+"elementBottomY"+elementBottomY);
	    }*/
		return returnValue;
	}
	
	public static String compareImage(WebDriver driver,WebElement element,String dimension) {
		screenHeight = driver.manage().window().getSize().getHeight();
		screenWidth = driver.manage().window().getSize().getWidth();
		Dimension elementDim = element.getSize();
		String[] imageDimension = elementDim.toString().split(",");
		System.out.println(imageDimension[0]);
		System.out.println(imageDimension[1]);
		String[] coordinates = dimension.split(",");
		String dimensionx="("+coordinates[0].trim();
		String dimensiony=" "+coordinates[1].trim()+")";
		System.out.println(dimensionx);
		System.out.println(dimensiony);
	if(dimensionx.trim().equals(imageDimension[0].trim()) && coordinates[1].equals(imageDimension[1].trim()) ) {
		returnValue = "Image has displayed correctly";
	} else {
		returnValue = "Oops!, Compare image not display correctly, Displayed Image Dimension:"+elementDim;
		Assert.assertTrue(dimensionx.trim().equals(imageDimension[0].trim()) && coordinates[1].equals(imageDimension[1].trim()),returnValue);
	}
		
		return returnValue;
	}
	
	public static String verifyElementsHorizontally (String element1Resolution, String element2Resolution) {
		String[] element1ResolutionValue = element1Resolution.split(",");
		String element1RightX = element1ResolutionValue[1];
		int element1RightXValue = Integer.parseInt(element1RightX.trim());
		String[] element2ResolutionValue = element2Resolution.split(",");
		String element2LeftX = element2ResolutionValue[0];
		int element2LeftXValue = Integer.parseInt(element2LeftX.trim());
		if(element1RightXValue <= element2LeftXValue)
		{
			returnValue = "Element Co-ordinates has verified successfully, Element1 X Values:" + element1ResolutionValue[0] + " , " + element1ResolutionValue[1] + " , Element2 X Values:" + element2ResolutionValue[0] + " , " + element2ResolutionValue[1];
		}
		else {
			returnValue = "oops! Elements has overlapped, Element1 X Values:" + element1ResolutionValue[0] + " , " + element1ResolutionValue[1] + " , Element2 X Values:" + element2ResolutionValue[0] + " , " + element2ResolutionValue[1];
			Assert.assertTrue((element1RightXValue <= element2LeftXValue),returnValue);
		}
		return returnValue;
	}

	public static String verifyElementsVertically (String element1Resolution, String element2Resolution) {
		String[] element1ResolutionValue = element1Resolution.split(",");
		String element1BottomY = element1ResolutionValue[3];
		int element1BottomYValue = Integer.parseInt(element1BottomY.trim());
		String[] element2ResolutionValue = element2Resolution.split(",");
		String element2TopY = element2ResolutionValue[2];
		int element2TopYValue = Integer.parseInt(element2TopY.trim());
		if(element1BottomYValue <= element2TopYValue) {
			returnValue = "Element Co-ordinates has verified successfully, Element1 Y Values:" + element1ResolutionValue[2] + " , " + element1ResolutionValue[3] + " , Element2 Y Values:" + element2ResolutionValue[2] + " , " + element2ResolutionValue[3];
		}
		else {
			returnValue = "oops! Elements has overlapped, Element1 Y Values:" + element1ResolutionValue[2] + " , " + element1ResolutionValue[3] + " , Element2 Y Values:" + element2ResolutionValue[2] + " , " + element2ResolutionValue[3];
			Assert.assertTrue((element1BottomYValue <= element2TopYValue),returnValue);
		}
		return returnValue;
	}

	public static String verifyInnerOutterElements(WebDriver driver,WebElement innerElement, WebElement outterElement) {

		Point outerLoc = outterElement.getLocation();
		org.openqa.selenium.Dimension outerDim = outterElement.getSize();
		int outerLeftX = outerLoc.getX();
		int outerRightX = outerLeftX + outerDim.getWidth();
		int outerTopY = outerLoc.getY();
		int outerBottomY = outerTopY + outerDim.getHeight();

		// get borders of inner element
		Point innerLoc = innerElement.getLocation();
		org.openqa.selenium.Dimension innerDim = innerElement.getSize();
		int innerLeftX = innerLoc.getX();
		int innerRightX = innerLeftX + innerDim.getWidth();
		int innerTopY = innerLoc.getY();
		int innerBottomY = innerTopY + innerDim.getHeight();
		if ((outerLeftX <= innerLeftX)
				&& (innerRightX <= outerRightX)
				&& (outerTopY <= innerTopY)
				&& (innerBottomY <= outerBottomY)) {
			returnValue = "Elements has verified successfully" ;
		}
		else {
			returnValue = "oops! Elements has overlapped";
			Assert.assertTrue((outerLeftX <= innerLeftX)
					&& (innerRightX <= outerRightX)
					&& (outerTopY <= innerTopY)
					&& (innerBottomY <= outerBottomY),returnValue);
		}
		return returnValue;
	}
}
