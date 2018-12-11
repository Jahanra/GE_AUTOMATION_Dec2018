package pages;

import base.BasePageLogin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class DashboardPage extends BasePageLogin {

    public DashboardPage(WebDriver driver, Connection conn, Statement stmt, ResultSet resultSet, Actions actions) {

        super(driver, conn, stmt, resultSet, actions);
    }

    @FindBy(css = "div[class='advanced-drop-down']")
    private WebElement advancedSearch;

    @FindBy(xpath = "//span[@class='hidden-sm ng-binding']")
    private WebElement userIcon;

    @FindBy(css = "input[id=startup-search][type=text]")
    private WebElement guidedSearchTextField;

    @FindBy(xpath = "//span[@ng-bind-html='technology.name | highlight:searchFilter.freeText']//span[@class='highlight']")
    private WebElement techSuggestion;

    @FindBy(xpath = "(//div[@ng-repeat='technology in navFilteredTechnologies']//div[@class='count ng-binding'])[1]")
    private WebElement techSuggestCount;

    @FindBy(xpath = "//span[@ng-bind-html='industry.name | highlight:searchFilter.freeText']//span[@class='highlight']")
    private WebElement indusSuggestion;

    @FindBy(xpath = "(//div[@ng-repeat='industry in navFilteredIndustries']//div[@class='count ng-binding'])[1]")
    private WebElement indusSuggestCount;

    @FindBy(xpath="//div[@class='business-solution ng-scope']//span[@class='highlight']")
    private WebElement solSuggestion;

    @FindBy(xpath="((//div[@ng-repeat='solution in navFilteredSolutions']//div[@class='count ng-binding'])[1]")
    private WebElement solSuggestCount;


    @FindBy(xpath="(//span[@ng-bind-html='challenge.name | highlight:searchFilter.freeText']//span[@class='highlight'])[1]")
    private  WebElement prioritySuggestion;

    @FindBy(xpath="(//div[@ng-repeat='challenge in navFilteredChallenges']//div[@class='count ng-binding'])[1]")
    private WebElement prioritySuggestCount;

    @FindBy(xpath="//span[@ng-bind-html='companyDetails.companyName | highlight:searchFilter.freeText']//span[@class='highlight']")
    private  WebElement startupName;

    @FindBy(xpath="//span[@ng-click='globalNavbarSearch();']")
    private WebElement viewAllStartUpLink;

    @FindBy(xpath = "//div[@class='search-button']")
    private WebElement searchButton;


    @FindBy(css="a[href='/watchlist/']")
    private  WebElement watchListIcon;

    @FindBy(css="a[href='/chat']")
    private WebElement connectUpIcon;

    @FindBy(css="div[ng-init='getNotificationCount()']")
    private WebElement notificationIcon;

    @FindBy(xpath = "//span[contains(text(),'My Profile')]")
    private WebElement myProfileLink;

    @FindBy(css="span[href='subscribe']")
    private  WebElement subcribeLink;

     @FindBy(css = "a[href='/add-company-details']")
     private WebElement myAccountLink;

     @FindBy(css="a[href='/ge-excel']")
     private WebElement importExportLink;

     @FindBy(css="div[href='/add-company-details']")
     private WebElement settingsIcon;


     @FindBy(css="button[ng-click='searchWithDefault()']")
     private WebElement expandIcon;

    @FindBy(xpath = "//span[contains(text(),'Sign out')]")
    private WebElement signOutLink;

    String textMatch = null;
    public String countValue = null;
    public String searchText = null;


    public void clickOnAdvancedSearch() throws InterruptedException

    {
        actions.moveToElement(advancedSearch);
        Thread.sleep(2000);
        actions.click();
        actions.build().perform();
    }


    public void clickOnMyProfile() throws InterruptedException {
        actions.moveToElement(userIcon);
        Thread.sleep(2000);
        actions.click();
        actions.moveToElement(myProfileLink);
        Thread.sleep(2000);
        actions.click();
        actions.build().perform();

    }

    public void clickOnLogOut() throws InterruptedException {
        actions.moveToElement(userIcon);
        Thread.sleep(2000);
        actions.click();
        actions.moveToElement(signOutLink);
        Thread.sleep(2000);
        actions.click();
        actions.build().perform();
    }


    public void clickGuidedSearchText(String textExcel) {
        actions.moveToElement(guidedSearchTextField);
        actions.click();
        actions.sendKeys(textExcel);
        textMatch = textExcel;
        actions.build().perform();
    }

    public void selectTextTechSearch() {
        searchText = techSuggestion.getText().toString();
        Reporter.log("The value of searched text------>" + searchText, true);
        countValue = techSuggestCount.getText().toString();
        Reporter.log("The value of searched count----->" + countValue, true);
        actions.moveToElement(techSuggestion);
        actions.click();
        actions.build().perform();

    }

    public void selectTextIndusSearch() {
        searchText = indusSuggestion.getText().toString();
        Reporter.log("The value of searched text------>" + searchText, true);
        countValue = indusSuggestCount.getText().toString();
        Reporter.log("The value of searched count----->" + countValue, true);
        actions.moveToElement(indusSuggestion);
        actions.click();
        actions.build().perform();

    }

    public void selectBusinessSolutionSearch()
    {
        searchText = solSuggestion.getText().toString();
        Reporter.log("The value of searched text------>" + searchText, true);
        countValue = solSuggestCount.getText().toString();
        Reporter.log("The value of searched count----->" + countValue, true);
        actions.moveToElement(solSuggestion);
        actions.click();
        actions.build().perform();
    }

    public void selectBusinessPrioritySearch()
    {
        searchText = prioritySuggestion.getText().toString();
        Reporter.log("The value of searched text------>" + searchText, true);
        countValue = prioritySuggestCount.getText().toString();
        Reporter.log("The value of searched count----->" + countValue, true);
        actions.moveToElement(prioritySuggestion);
        actions.click();
        actions.build().perform();
    }

    public void clickGuidedSearch() {
        actions.moveToElement(searchButton);
        actions.click();
        actions.build().perform();
    }

    public String getCountValue() {
        return countValue;
    }

    public String getTextValue() {
        return searchText;
    }


}
