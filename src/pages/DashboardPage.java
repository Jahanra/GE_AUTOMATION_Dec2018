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

public class DashboardPage extends HomePage {

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

    @FindBy(xpath="//li[@ng-repeat='horizontal in account.horizontalDescription']//span")
    private WebElement technologySelected;

    @FindBy(xpath="//li[@ng-repeat='sector in shortIndustries']//span")
            private WebElement industrySelected;

    @FindBy(xpath="//table[@id='dashboard-top-10']//section[@ng-bind='company.companyName']")
            private List<WebElement> companyNames;


    @FindBy(xpath="//tbody[@ng-repeat='company in top10Startups']//img[@ng-show='company.companyLogoUrl']")
    private  List<WebElement> companyLogos;

    @FindBy(xpath="//tbody[@ng-repeat='company in top10Startups']//span[@class='text ng-binding']")
     private  List<WebElement> companyMaturities;

    @FindBy(xpath="//tbody[@ng-repeat='company in top10Startups']//section[@class='tech ng-binding']")
    private  List<WebElement> companyTechnologies;

    @FindBy(xpath="//tbody[@ng-repeat='company in top10Startups']//section[@class='city ng-binding']")
    private List<WebElement>  companyCountries;

    @FindBy(xpath = "//tbody[@ng-repeat='company in top10Startups']//span[@class='ng-binding']")
            private List<WebElement> companyGeScores;



    String textMatch = null;
    public String countValue = null;
    public String searchText = null;

   String parentTechnology=null;
   String parentIndustry=null;

   String companyName=null;
   String  companyMaturity=null;
   String companyTechnology=null;
   String companyCountry= null;
   String companyGePiiScore;
   String companyLogoUrl=null;

   String nameUI=null;
    String technologyUI=null;
    String maturityUI=null;
    String urlUI=null;
    String gepiiScoreUI=null;


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

    public void checkTechnologySaved(String parentTechnologyExcel) {
        actions.moveToElement(technologySelected);
        parentTechnology = technologySelected.getText().toString();
        if (parentTechnology.equalsIgnoreCase(parentTechnologyExcel)) {
            Reporter.log("Parent Technology Matched", true);
        } else
            {
              Reporter.log("Parent Technology deoesnt match",true);
        }
        actions.build().perform();
    }


    public void  checkIndustrySaved(String parentIndustryExcel)
    {
        actions.moveToElement(industrySelected);
        parentTechnology = industrySelected.getText().toString();
        if (parentIndustry.equalsIgnoreCase(parentIndustryExcel)) {
            Reporter.log("Parent Industry  Matched", true);
        } else
        {
            Reporter.log("Parent Industry  deoesnt match",true);
        }
        actions.build().perform();
    }

    public void  checkTop10Startups(String query)
    {
        for (int i = 0; i <= companyNames.size(); i++)
        {
            try
            {
                stmt = conn.createStatement();
                resultSet = stmt.executeQuery(query);
                while (resultSet.next()) {
                    companyName = resultSet.getString("company_name");
                    companyTechnology = resultSet.getString("horizontal");
                    companyMaturity = resultSet.getString("maturity_status");
                    companyCountry = resultSet.getString("country");
                    companyLogoUrl = resultSet.getString("company_img_url");
                    companyGePiiScore = resultSet.getString("ge_pii_Score");
                    if (nameUI.equalsIgnoreCase(companyNames.get(i).getText()) &&
                            technologyUI.equalsIgnoreCase(companyTechnologies.get(i).getText()) &&
                            maturityUI.equalsIgnoreCase(companyMaturities.get(i).getText()) &&
                            urlUI.equalsIgnoreCase(companyLogos.get(i).getText())&&
                            gepiiScoreUI.equalsIgnoreCase(companyGeScores.get(i).getText()))
                    {
                         Reporter.log("The Startup details are correct",true);
                    }
                    else
                        {
                        Reporter.log("The startup details are incorrect",true);
                    }

                }

            }
            catch (Exception e) {
                e.printStackTrace();
                Reporter.log("Exception in validating startups listed in data base", true);
            }

        }
    }
}
