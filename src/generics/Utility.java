package generics;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.imageio.ImageIO;

import base.BasePageLogin;
import base.BaseTest;
import base.BaseTestLogin;
import org.openqa.selenium.interactions.Actions;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;


public class Utility extends BasePageLogin
{


	//public static Actions actions;
	static String matchValue=null;
	static String newValue=null;

	static WebElement newElementVal;
	static WebElement addNewElementVal;

	public Utility(WebDriver driver, Connection conn, Statement stmt, ResultSet resultSet, Actions actions) {
		super(driver, conn, stmt, resultSet, actions);
	}

	public static String getFormatedDateTime() {
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		return simpleDate.format(new Date());
	}
	public static String getScreenShot1( String imageFolderPath)
	{
		String imagePath = imageFolderPath + "/" + getFormatedDateTime() + ".png";
		TakesScreenshot page = (TakesScreenshot) driver;
		try {
			FileUtils.copyFile(page.getScreenshotAs(OutputType.FILE), new File(imagePath));
		} catch (Exception e) {

		}
		return imagePath;

	}

	public static String getScreenShot(String imageFolderPath) {
		String imagePath = imageFolderPath + "/" + getFormatedDateTime() + ".png";

		try {
			Dimension desktopSize = Toolkit.getDefaultToolkit().getScreenSize();
			BufferedImage image = new Robot().createScreenCapture(new Rectangle(desktopSize));
			ImageIO.write(image, "png", new File(imagePath));
		} catch (Exception e) {
		}

		return imagePath;

	}

	public static String getPropertyValue(String filePath, String key) {
		String value = "";
		Properties ppt = new Properties();
		try {
			ppt.load(new FileInputStream(filePath));
			value = ppt.getProperty(key);
		} catch (Exception e) {
		}
		return value;

	}

	public static void clickUsingJS(WebDriver driver, WebElement element)
	{
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].click();", element);
	}

	public static void scrollByUsingJS(WebDriver driver, WebElement element)
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}


	public static String datePicker(WebElement tablebobject, String tdObject,String data)
	{
		String result = "Passed";
		try {

			List<WebElement> rows = tablebobject.findElements(By.tagName("tr"));
			List<WebElement> columns = tablebobject.findElements(By.xpath(tdObject));

			for (WebElement cell : columns) {
				if (cell.getText().equals(data))
				{
					cell.click();
					break;
				}
			}
		} catch (Exception e) {
			Reporter.log("Failed to select the date", true);
		}
   return result;
	}

	public static void clickOnWebElement(WebElement elementName)
	{
		try
		{
			actions.moveToElement(elementName);
			actions.click();
			actions.build().perform();

		}

		catch (Exception e)
		{
			e.printStackTrace();

		}
	}

	public static void clickOnElement(WebElement elementName,String passExcelValue)
	{
		try
		{
			actions.moveToElement(elementName);
			actions.click();
			actions.sendKeys(passExcelValue);
            matchValue=passExcelValue;
			actions.build().perform();

		}
		catch (Exception e)
		{
			e.printStackTrace();
			Reporter.log("Failed to click the element",true);
		}
	}

	public static boolean selectElementType1(List<WebElement> listElement)
	{

	    boolean result=true;
		String value;
		Reporter.log("Size of list of element------------>"+listElement.size(),true);
		for(int i=0;i<listElement.size();i++)
		{
		 value=listElement.get(i).getAttribute("value").toString();

			if(matchValue.equalsIgnoreCase(value))
            {
                listElement.get(i).click();
                Reporter.log("The value of value----------->"+value,true);
                result=true;
                break;

            }
            else
            {
                result=false;
                //Reporter.log("The value doesnt match",true);
            }


		}

		return result;
	}

    public static boolean selectElementType2(List<WebElement> listElement)
    {

        boolean result=true;
        String value;
        Reporter.log("Size of list of element------------>"+listElement.size(),true);
        for(int i=0;i<=listElement.size();i++)
        {
            value=listElement.get(i).getText();
            if(matchValue.equalsIgnoreCase(value))
            {
                listElement.get(i).click();
                result=true;
                break;

            }
            else
            {
                result=false;
                Reporter.log("The value doesnt match",true);
            }


        }

        return result;
    }
	public static boolean checkLevel(List<WebElement> listElement,WebElement elementName)
    {
		String listVal;
        boolean result=true;
        try {
         Reporter.log("The match value------>"+matchValue,true);
         Reporter.log("The Size of list of elements-----> " + listElement.size(),true);
            for (int i = 0; i < listElement.size(); i++) {
                 listVal = listElement.get(i).getAttribute("value").toString();
                if (null!=listVal && listVal.equalsIgnoreCase(matchValue)) {
                    Reporter.log("List value -------->" + listVal,true);
                    elementName.click();
                    result=true;
                    break;
                }
                else
                {
                    result=false;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        Reporter.log("Exception in checking the levels",true);
        }
        return result;
    }
    public void selectNewElement(List<WebElement> elementList,WebElement elementName) throws InterruptedException
    {
        try {
            Reporter.log("Total size fetched from the element---------->" + elementList.size(),true);
            for (int i = 0; i <= elementList.size(); i++)
            {
                newValue = elementList.get(i).getAttribute("value").toString();
                Reporter.log("Element value------------>" + newValue,true);
                if(newValue.equalsIgnoreCase(matchValue)) {
                    elementList.get(i).click();
                    elementName.click();
                    break;
                }
                else
                {
                    Reporter.log("Element Value Does'nt Match",true);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in selecting the element",true);
        }
    }


    public static WebElement setNewValue(WebElement newValueText,String valueNew)
	{
		try {
			actions.moveToElement(newValueText);
			actions.click();
			actions.sendKeys(valueNew);
			actions.build().perform();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Exception in adding new element value",true);
		}
		return newValueText;

	}

	public static void addNewValue(WebElement addNewValueText) throws InterruptedException
	{
		try {

			actions.moveToElement(addNewValueText);
			actions.click();
			actions.build().perform();
			Thread.sleep(1000);
		}

		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception in add new value method");
		}
	}


}

