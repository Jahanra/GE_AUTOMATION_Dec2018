package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyAccountPage extends DashboardPage
{

    public MyAccountPage(WebDriver driver, Connection conn, Statement stmt, ResultSet resultSet, Actions actions) {
        super(driver, conn, stmt, resultSet, actions);
    }

    @FindBy(css="a[href='/password']")
    private WebElement changePwdLink;

    @FindBy(css="a[href='/user-profile']")
    private  WebElement userProfileLink;

    @FindBy(xpath ="//section[@class='name']/span[contains(text(),'Change Preference')]")
    private  WebElement changePreferencesLink;


    public void clickUserProfile()
    {
        actions.moveToElement(userProfileLink);
        actions.click();
        actions.build().perform();
    }


    public  void clickChangePreferences()
    {
        actions.moveToElement(changePreferencesLink);
        actions.click();
        actions.build().perform();
    }

    public void clickChangepassword()
    {
        actions.moveToElement(changePwdLink);
        actions.click();
        actions.build().perform();
    }

}
