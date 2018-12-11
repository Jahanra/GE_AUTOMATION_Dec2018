package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ChangePasswordPage extends DashboardPage
{

    public ChangePasswordPage(WebDriver driver, Connection conn, Statement stmt, ResultSet resultSet, Actions actions) {
        super(driver, conn, stmt, resultSet, actions);
    }

    @FindBy(css="input[ng-model='vm.password']")
    private WebElement password;

    @FindBy(css="input[ng-model='vm.confirmPassword']")
    private WebElement confirmPassword;


    @FindBy(css="button[ng-click='vm.changePassword()']")
    private WebElement saveChangePwd;

    @FindBy(css="button[ng-click='goBack()']")
    private WebElement cancelBtn;

    @FindBy(xpath="//a[contains(text(),'Go to Dashboard')]")
    private WebElement goToDashboardLink;

    public void setPassword(String passwordExcel) {
        try {
            actions.moveToElement(password);
            actions.click();
            actions.sendKeys(passwordExcel);
            actions.build().perform();
            Thread.sleep(1000);

        } catch (Exception e)
        {
            e.printStackTrace();
            Reporter.log("Exception in Password",true);
        }
    }

    public void setConfirmPassword(String confirmPasswordExcel) {
        try {
            actions.moveToElement(confirmPassword);
            actions.click();
            actions.sendKeys(confirmPasswordExcel);
            actions.build().perform();
            Thread.sleep(1000);

        } catch (Exception e)
        {
            e.printStackTrace();
            Reporter.log("Exception in confirm Password",true);
        }
    }

    public void saveChangePassword()
    {
        actions.moveToElement(saveChangePwd);
        actions.click();
        actions.build().perform();
    }

    public void clickCancel()
    {
        actions.moveToElement(cancelBtn);
        actions.click();
        actions.build().perform();
    }

    public void clickGoToDashboardLink()
    {
        actions.moveToElement(goToDashboardLink);
        actions.click();
        actions.build().perform();
    }
}
