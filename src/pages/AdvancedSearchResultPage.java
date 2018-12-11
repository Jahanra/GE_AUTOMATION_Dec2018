package pages;

import base.BasePageLogin;
import generics.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdvancedSearchResultPage extends DashboardPage
{
    public AdvancedSearchResultPage(WebDriver driver, Connection conn, Statement stmt, ResultSet resultSet, Actions actions) {
        super(driver, conn, stmt, resultSet, actions);
    }

    @FindBy(xpath="(//tbody[@ng-repeat='companyDetails in visibleStartups track by $index']/tr[@class='company-row'])[1]")
    private WebElement companyName1;


    public void clickFirstCompany()
    {
        actions.moveToElement(companyName1);
        actions.click();
        actions.build().perform();
    }

    public void navigateBackSearchedResults()
    {
        driver.navigate().back();
    }



}
