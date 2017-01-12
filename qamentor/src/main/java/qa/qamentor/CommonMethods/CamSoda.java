package qa.qamentor.CommonMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import qa.qamentor.commands.Manipulation;
import qa.qamentor.commands.Navigate;
import qa.qamentor.commands.OR;
import qa.qamentor.utils.Directory;
import qa.qamentor.utils.Platform;

public class CamSoda extends Manipulation implements OR 
{	public static int total = 0;
public static String addValue(String string1, String string2) 
{
	int Val1 = Integer.parseInt(string1);
	int Val2 = Integer.parseInt(string2);
	total = Val1 - Val2;
	String TotalValue = String.valueOf(total);
	return TotalValue;
}

static String userName = "";
public static String login(WebDriver driver) 
{
	Navigate.get(driver, Directory.CAM_SODA_URL);
	Navigate.maximize(driver);
	Navigate.waitTime(driver, "8");

	WebElement element = driver.findElement(By.xpath(ENTER_SITE_BUTTON));
	click(element);

	waitForElement(driver, LOGO);
	WebElement logo = driver.findElement(By.xpath(LOGO));
	verifyElementIsPresent(driver, logo);
	Navigate.waitTime(driver, "5");

	jsClickByXPath(driver, SIGN_IN_LINK);
	wait(driver, "2");
	waitForElement(driver, LOGIN_POPUP_TITLE);
	WebElement popuptitle = driver.findElement(By.xpath(LOGIN_POPUP_TITLE));
	verifyElementIsPresent(driver, popuptitle);
	userName = Directory.CAM_SODA_USERNAME;
	WebElement username = driver.findElement(By.id(USERNAME_TEXTBOX));
	sendKeys(username, userName);
	wait(driver, "1");
	WebElement password = driver.findElement(By.id(PASSWORD_TEXTBOX));
	sendKeys(password, Directory.CAM_SODA_PASSWORD);
	wait(driver, "1");
	jsClickByXPath(driver, SIGN_IN_BUTTON);
	Navigate.waitTime(driver, "5");


	return userName;
}

public static void logOut(WebDriver driver) 
{
	WebElement username = driver.findElement(By.xpath(LOGGED_USERNAME+userName+LOGGED_USERNAME_1));
	verifyElementIsPresent(driver, username);
	jsClickByXPath(driver, LOGGED_USERNAME+userName+LOGGED_USERNAME_1);
	wait(driver, "1");
	jsClickByXPath(driver, LOGOUT_BUTTON);
	Navigate.waitTime(driver, "5");
}

public static void click(WebDriver driver,WebElement element)
{
	try	{
		if(element.isDisplayed()) {
			click(element);
		} else {
			//System.out.println("Clicked");
		}
	} catch(Exception e) {
	}
}

public static String model = "";
public static String ClickPrivateButton(WebDriver driver)
{
	WebElement RandomModel = driver.findElement(By.xpath(RANDOM_MODEL));
	verifyElementIsPresent(driver, RandomModel);
	jsClickByXPath(driver, RANDOM_MODEL);
	Navigate.waitTime(driver, "8");
	WebElement SelectedModelTitle = driver.findElement(By.xpath(SELECTED_MODEL_TITLE));
	verifyElementIsPresent(driver, SelectedModelTitle);
	model = driver.findElement(By.xpath(SELECTED_MODEL_TITLE)).getText();
	Navigate.waitTime(driver, "3");
	try 
	{
		if(driver.findElement(By.xpath(GO_PRIVATE_BUTTON)).isDisplayed()) 
		{
			jsClickByXPath(driver, GO_PRIVATE_BUTTON);
			wait(driver, "2");
			waitForElement(driver, PRIVATE_CHAT_POPUP_TITLE);
			WebElement popuptitle = driver.findElement(By.xpath(PRIVATE_CHAT_POPUP_TITLE));
			verifyElementIsPresent(driver, popuptitle);
			jsClickByXPath(driver, START_PRIVATE_CHAT_BUTTON);
			Navigate.waitTime(driver, "3");
		}
		else 
		{
			jsClickByXPath(driver, MENU_HOME);
			Navigate.waitTime(driver, "5");
			WebElement RandomModel1 = driver.findElement(By.xpath(RANDOM_MODEL_5));
			verifyElementIsPresent(driver, RandomModel1);
			jsClickByXPath(driver, RANDOM_MODEL_5);
			Navigate.waitTime(driver, "8");
			WebElement SelectedModelTitle1 = driver.findElement(By.xpath(SELECTED_MODEL_TITLE));
			verifyElementIsPresent(driver, SelectedModelTitle1);
			model = driver.findElement(By.xpath(SELECTED_MODEL_TITLE)).getText();
			if(driver.findElement(By.xpath(GO_PRIVATE_BUTTON)).isDisplayed()) 
			{
				jsClickByXPath(driver, GO_PRIVATE_BUTTON);
				Navigate.waitTime(driver, "5");
				waitForElement(driver, PRIVATE_CHAT_POPUP_TITLE);
				WebElement popuptitle = driver.findElement(By.xpath(PRIVATE_CHAT_POPUP_TITLE));
				verifyElementIsPresent(driver, popuptitle);
				jsClickByXPath(driver, START_PRIVATE_CHAT_BUTTON);
				Navigate.waitTime(driver, "3");
			}
			else 
			{
				jsClickByXPath(driver, MENU_HOME);
				Navigate.waitTime(driver, "5");
				WebElement RandomModel2 = driver.findElement(By.xpath(RANDOM_MODEL_6));
				verifyElementIsPresent(driver, RandomModel2);
				jsClickByXPath(driver, RANDOM_MODEL_6);
				Navigate.waitTime(driver, "8");
				WebElement SelectedModelTitle2 = driver.findElement(By.xpath(SELECTED_MODEL_TITLE));
				verifyElementIsPresent(driver, SelectedModelTitle2);
				model = driver.findElement(By.xpath(SELECTED_MODEL_TITLE)).getText();
				jsClickByXPath(driver, GO_PRIVATE_BUTTON);
				wait(driver, "2");
				waitForElement(driver, PRIVATE_CHAT_POPUP_TITLE);
				WebElement popuptitle = driver.findElement(By.xpath(PRIVATE_CHAT_POPUP_TITLE));
				verifyElementIsPresent(driver, popuptitle);
				jsClickByXPath(driver, START_PRIVATE_CHAT_BUTTON);
				Navigate.waitTime(driver, "3");

			}
		}
	}
	catch(Exception e)
	{
	}
	return model;

}

public static void ClickEndPrivateChat(WebDriver driver)
{
	try	{
		if(driver.findElement(By.xpath(END_PRIVATE_SHOW_BUTTON)).isDisplayed()) {
			WebElement privatebutton = driver.findElement(By.xpath(END_PRIVATE_SHOW_BUTTON));
			click(privatebutton);
			wait(driver, "2");
			WebElement title = driver.findElement(By.xpath(END_PRIVATE_CHAT_POPUP_TITLE));
			verifyElementIsPresent(driver, title);
			WebElement endchat = driver.findElement(By.xpath(END_PRIVATE_CHAT_BUTTON));
			click(endchat);

		} else {
			//System.out.println("Clicked");
		}
	} catch(Exception e) {
	}
}

public static void ClickEndSpyChat(WebDriver driver)
{
	try	{
		if(driver.findElement(By.xpath(END_SPY_CHAT_SHOW_BUTTON)).isDisplayed()) {
			WebElement privatebutton = driver.findElement(By.xpath(END_SPY_CHAT_SHOW_BUTTON));
			click(privatebutton);
			wait(driver, "2");
			WebElement title = driver.findElement(By.xpath(END_SPY_CHAT_POPUP_TITLE));
			verifyElementIsPresent(driver, title);
			WebElement endchat = driver.findElement(By.xpath(END_SPY_CHAT_BUTTON));
			click(endchat);

		} else {
			//System.out.println("Clicked");
		}
	} catch(Exception e) {
	}
}


public static String PrivateButton(WebDriver driver)
{
	try 
	{
		if(driver.findElement(By.xpath(GO_PRIVATE_BUTTON)).isDisplayed()) 
		{
			jsClickByXPath(driver, GO_PRIVATE_BUTTON);
			wait(driver, "2");
		}
		else 
		{
			jsClickByXPath(driver, MENU_HOME);
			Navigate.waitTime(driver, "5");
			WebElement RandomModel1 = driver.findElement(By.xpath(RANDOM_MODEL_5));
			verifyElementIsPresent(driver, RandomModel1);
			jsClickByXPath(driver, RANDOM_MODEL_5);
			Navigate.waitTime(driver, "8");
			WebElement SelectedModelTitle1 = driver.findElement(By.xpath(SELECTED_MODEL_TITLE));
			verifyElementIsPresent(driver, SelectedModelTitle1);
			model = driver.findElement(By.xpath(SELECTED_MODEL_TITLE)).getText();
			if(driver.findElement(By.xpath(GO_PRIVATE_BUTTON)).isDisplayed()) 
			{
				jsClickByXPath(driver, GO_PRIVATE_BUTTON);
				wait(driver, "2");
			}
			else 
			{
				jsClickByXPath(driver, MENU_HOME);
				Navigate.waitTime(driver, "5");
				WebElement RandomModel2 = driver.findElement(By.xpath(RANDOM_MODEL_6));
				verifyElementIsPresent(driver, RandomModel2);
				jsClickByXPath(driver, RANDOM_MODEL_6);
				Navigate.waitTime(driver, "8");
				WebElement SelectedModelTitle2 = driver.findElement(By.xpath(SELECTED_MODEL_TITLE));
				verifyElementIsPresent(driver, SelectedModelTitle2);
				model = driver.findElement(By.xpath(SELECTED_MODEL_TITLE)).getText();
				jsClickByXPath(driver, GO_PRIVATE_BUTTON);
				wait(driver, "2");
			}
		}
	}
	catch(Exception e)
	{
	}
	return model;

}

public static String SpyShowButton(WebDriver driver)
{
	try 
	{
		if(driver.findElement(By.xpath(SPY_ON_THIS_PRIVATE_SHOW_BUTTON)).isDisplayed()) 
		{
			jsClickByXPath(driver, SPY_ON_THIS_PRIVATE_SHOW_BUTTON);
			wait(driver, "2");
		}
		else 
		{
			jsClickByXPath(driver, MENU_HOME);
			Navigate.waitTime(driver, "5");
			jsClickByXPath(driver, SPY_SHOWS_TAB);
			Navigate.waitTime(driver, "5");
			WebElement Title = driver.findElement(By.xpath(SPY_SHOWS_PAGE_TITLE));
			verifyElementIsPresent(driver, Title);			
			WebElement RandomModel1 = driver.findElement(By.xpath(SPY_SHOWS_MODEL_1));
			verifyElementIsPresent(driver, RandomModel1);
			jsClickByXPath(driver, SPY_SHOWS_MODEL_1);
			Navigate.waitTime(driver, "8");
			WebElement SelectedModelTitle1 = driver.findElement(By.xpath(SELECTED_MODEL_TITLE));
			verifyElementIsPresent(driver, SelectedModelTitle1);
			model = driver.findElement(By.xpath(SELECTED_MODEL_TITLE)).getText();
			if(driver.findElement(By.xpath(SPY_ON_THIS_PRIVATE_SHOW_BUTTON)).isDisplayed()) 
			{
				jsClickByXPath(driver, SPY_ON_THIS_PRIVATE_SHOW_BUTTON);
				wait(driver, "2");
			}
			else 
			{
				jsClickByXPath(driver, MENU_HOME);
				Navigate.waitTime(driver, "5");
				jsClickByXPath(driver, SPY_SHOWS_TAB);
				Navigate.waitTime(driver, "5");
				WebElement Title2 = driver.findElement(By.xpath(SPY_SHOWS_PAGE_TITLE));
				verifyElementIsPresent(driver, Title2);			
				WebElement RandomModel2 = driver.findElement(By.xpath(SPY_SHOWS_MODEL_2));
				verifyElementIsPresent(driver, RandomModel2);
				jsClickByXPath(driver, SPY_SHOWS_MODEL_2);
				Navigate.waitTime(driver, "8");
				WebElement SelectedModelTitle2 = driver.findElement(By.xpath(SELECTED_MODEL_TITLE));
				verifyElementIsPresent(driver, SelectedModelTitle2);
				model = driver.findElement(By.xpath(SELECTED_MODEL_TITLE)).getText();
				jsClickByXPath(driver, SPY_ON_THIS_PRIVATE_SHOW_BUTTON);
				wait(driver, "2");
			}
		}
	}
	catch(Exception e)
	{
	}
	return model;

}


}