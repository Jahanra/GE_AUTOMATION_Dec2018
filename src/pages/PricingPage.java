package pages;

import base.BasePage;
import generics.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PricingPage extends HomePage
{



    public PricingPage(WebDriver driver, Connection conn, Statement stmt, ResultSet resultSet, Actions actions) {
        super(driver, conn, stmt, resultSet, actions);
    }

    @FindBy(css="(//div[@href='/contactus/request-demo'])[1]")
    private WebElement requestForDemo1;

    public void clickOnRequestForDemo1()
    {
        actions.moveToElement(requestForDemo1);
        actions.click();
        actions.build().perform();
    }


    @FindBy(xpath="(//div[@href='/contactus/request-demo'])[2]")
    private WebElement requestForDemo2;

    public void clickOnRequestForDemo2()
    {
        actions.moveToElement(requestForDemo2);
        actions.click();
        actions.build().perform();
    }

    @FindBy(xpath="(//div[@class='button purchase ng-scope'])[2]")
    private  WebElement purchaseNow;

    public void clickPurchaseNow()
    {
        actions.moveToElement(purchaseNow);
        actions.click();
        actions.build().perform();
    }

    @FindBy(xpath="(//div[@class='owl-stage-outer'])[2]")
    private WebElement scrollTillElement;

    public void scrollTillElementRegister()
    {
        Utility.scrollByUsingJS(driver,scrollTillElement);
    }

    @FindBy(xpath="(//div[@href='/contactus/request-demo'])[7]")
    private WebElement requestForDemo3;

    public  void  clickRequestOnDemo3()
    {
        actions.moveToElement(requestForDemo3);
        actions.click();
        actions.build().perform();
    }

}
