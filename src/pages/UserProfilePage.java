package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import static generics.Utility.clickOnElement;
import static generics.Utility.selectElementType1;

public class UserProfilePage extends HomePage
{

    public UserProfilePage(WebDriver driver, Connection conn, Statement stmt, ResultSet resultSet, Actions actions) {
        super(driver, conn, stmt, resultSet, actions);
    }

    String countryMatch=null;
    String cityMatch=null;

    @FindBy(css="input[ng-model='vm.user.firstName']")
    private WebElement firstName;

    @FindBy(css="input[ng-model='vm.user.country']")
    private WebElement country;

    @FindBy(xpath="//span[@ng-bind-html='country | highlight:searchFilter.countryFilterText']//span[@class='highlight']")
    private List<WebElement> countrySuggestion;

    @FindBy(css="input[ng-model='vm.user.city']")
    private WebElement city;

    @FindBy(xpath="//span[@ng-bind-html='city | highlight:searchFilter.cityFilterText']//span[@class='highlight']")
    private  List<WebElement> citySuggestion;

    @FindBy(css="input[@ng-model='vm.user.userRole']")
    private WebElement userRole;

    @FindBy(css="button[ng-click='completeProfile(companyProfileDto);']")
    private WebElement saveBtn;

    @FindBy(css="button[ng-click='goBack();']")
    private WebElement cancelBtn;

    @FindBy(xpath="//a[contains(text(),'Go to Dashboard')]")
    private WebElement goToDashboardLink;

public  void selectCountry(String countryExcel)
{
    clickOnElement(country, countryExcel);
    selectElementType1(countrySuggestion);

}

public void selectCity(String cityExcel)
{
    clickOnElement(city, cityExcel);
    selectElementType1(citySuggestion);

}

    public void setUserRole(String userRoleExcel) {
        try {
            actions.moveToElement(userRole);
            actions.click();
            actions.sendKeys(userRoleExcel);
            actions.build().perform();
            Thread.sleep(1000);

        } catch (Exception e)
        {
            e.printStackTrace();
       Reporter.log("Exception in User Role",true);
        }
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
