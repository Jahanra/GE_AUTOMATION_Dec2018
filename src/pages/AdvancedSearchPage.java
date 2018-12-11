package pages;

import base.BasePageLogin;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class AdvancedSearchPage extends DashboardPage

{

    public AdvancedSearchPage(WebDriver driver, Connection conn, Statement stmt, ResultSet resultSet,Actions actions) {

        super(driver,conn,stmt,resultSet,actions);
    }
    @FindBy(xpath=".//*[@id='advanced-search']/h2")
    private WebElement advSearchText;
@FindBy(xpath="//div[@class='advanced-drop-down']")
private WebElement advancedSearchLink;

    @FindBy(xpath="//input[@id='adv-tech-search']")
    private WebElement advTechnologyText;

    @FindBy(xpath="//div[@class='options always-visible ps ps--theme_default ps--active-y']//input[@type='checkbox']")
    private List<WebElement>advTechnologySuggestion;

    @FindBy(xpath="//div[@class='input-checkboxes-field' and @ng-click='top_level_tech.hidden = !top_level_tech.hidden']//input[contains(@id,'advanced-tech') and @type='checkbox']")
    private List<WebElement> advTopTechnologySuggestion;



    @FindBy(xpath="//div[@class='input-checkboxes-field' and @ng-click='upper_level_tech.hidden = !upper_level_tech.hidden']//input[contains(@id,'advanced-tech') and @type='checkbox']")
    private List<WebElement> advUppTechnologySuggestion;

    @FindBy(xpath="//div[@class='input-checkboxes-field' and @ng-click='mid_level_tech.hidden = !mid_level_tech.hidden']//input[contains(@id,'advanced-tech') and @type='checkbox']")
    private List<WebElement> advMidTechnologySuggestion;

    @FindBy(xpath="//div[@ng-click='lower_level_tech.hidden = !lower_level_tech.hidden']//input[contains(@id,'advanced-tech') and @type='checkbox']")
    private  List<WebElement> advLowTechnolgySuggestion;

    @FindBy(xpath="//input[@id='adv-industry-search']")
    private WebElement advIndustryText;

    @FindBy(xpath="//div[@class='input-checkboxes-field']//input[contains(@id,'advanced-sector') and @type='checkbox']")
    private List<WebElement> advIndustrySuggestion;

    @FindBy(xpath = "//div[@ng-click='top_level_sector.hidden = !top_level_sector.hidden']//input[ @type='checkbox']")
    private List<WebElement> advTopIndustySuggestion;

    @FindBy(xpath="//div[@ng-click='upper_level_sector.hidden = !upper_level_sector.hidden']//input[contains(@id,'advanced-sector') and @type='checkbox']")
    private List<WebElement>advUppIndustrySuggestion;

   // xpath="//input[@id='adv-solution-search']"
    @FindBy(css = "input[type=text][id=adv-solution-search]")
    private WebElement advSolutionText;

    @FindBy(xpath = "//div[@class='ng-scope' and @ng-repeat='solution in solutions | filter: solutionFilterText']//input[contains(@id,'advanced-solution') and @type='checkbox']")
    private List<WebElement> advSolSuggestion;

    @FindBy(xpath="//input[@id='adv-country-search']")
    private WebElement advCountryText;

    @FindBy(xpath= "//div[@ng-repeat='country in countries | filter: countryFilterText']//input[contains(@id,'advanced-country') and @type='checkbox']")
    private  List<WebElement> advCountrySuggestion;

    @FindBy(xpath="//input[@id='adv-cities-search']")
    private WebElement advCitiesText;

    @FindBy(xpath = "//div[@ng-repeat='city in queried_cities track by $index']//input[contains(@id,'advanced-city') and @type='checkbox']")
    private List<WebElement>  advCitiesSuggestion;

    @FindBy(xpath="//input[@id='adv-employee-count-search']")
    private  WebElement empCountText;

    @FindBy(xpath ="//div[contains(@ng-click,'advancedSearch.toggleEmployeeCount')]//input[@type='checkbox']")
    private List<WebElement> empCountSuggestion;

    @FindBy(xpath="//input[@id='adv-business-type-search']")
    private WebElement businessTypeText;

    @FindBy(xpath = "//div[@ng-repeat='business_type in business_types | filter: businessTypeText']//input[@type='checkbox']")
    private List<WebElement> businessTypeSuggestion;

    @FindBy(xpath = "//input[@id='adv-funding-search']")
    private WebElement advFundingText;

    @FindBy(xpath="//div[@ng-repeat='funding_stage in fundingStages | filter: fundingStageFilterText']//input[@type='checkbox']")
    private List<WebElement> advFundingSuggestion;



    @FindBy(css="input[type=text][id=adv-investors-search]")
    private  WebElement advInvestorsText;

    //input[@id='adv-investors-search']

    //div[contains(@class,'options always-visible ps ps--theme_default ps--active-y')]//input[contains(@id,'advanced-investor') and @type='checkbox']
    @FindBy(xpath = "//div[@class='options always-visible ps ps--theme_default']/div[@ng-repeat='investor in queried_investors']//input[contains(@id,'advanced-investor') and @type='checkbox']" )
            //"//span[@ng-bind-html='investor | highlight:investorQueryText']//span[@class='highlight']")
            //(css="highlight")
    private  List<WebElement> advInvestorsSuggestion;

    @FindBy(xpath="//input[@ng-model='advancedSearch.totalFundingAmountStartRange']")
    private WebElement  fundFromText;

    @FindBy(xpath = "//input[@ng-model='advancedSearch.totalFundingAmountEndRange']")
    private WebElement fundToText;

    @FindBy(xpath = "//span[@class='rz-pointer rz-pointer-min']")
    private WebElement foundedYearMinPointer;

    @FindBy(xpath = "//span[@class='rz-pointer rz-pointer-max']")
    private WebElement foundedYearMaxPointer;

    @FindBy(xpath="//div[contains(@class,'search-button') and contains(text(),'SEARCH')]")
    private WebElement searchButton;

    @FindBy(xpath = "//sup[@class='ng-binding']")
    private WebElement searchedCountValue;

    @FindBy(xpath = "//div[@class='text ng-binding']")
    private  WebElement searchedValue;

    @FindBy(xpath="//span[@class='label-count-for-dropdown ng-binding']")
    private  List<WebElement> countValue;

    String advTechMatch;
    String advTechVal;
    String advIndustryMatch;
    String advIndustryVal;
    String advSolutionMatch;
    String advSolVal;
    String advCountryMatch;
    String advCountryVal;
    String advCitiesMatch;
    String advCitiesVal;
    String advEmpCountMatch;
    String advEmpCountVal;
    String advBusiTypeMatch;
    String advBusiTypeVal;
    String advFundingStageMatch;
    String advFundingStageVal;
    String advInvestorMatch;
    String advInvestorVal;
    String advFromMatch;
    String  advToMatch;
    String countValueText;
    String searchedCountValueText;
    String searchedValueText;




    public void advclickAdvancedSearchLink()
{
    try{
        clickOnAdvancedSearch();
    }
    catch(Exception e)
    {
        e.printStackTrace();
        System.out.println("Exception in clicking the Advanced search Link!!!!!!!!!!!!!!");
    }
}

public void advclickOnLogout()
{
    try{
        clickOnLogOut();
    }
    catch(Exception e)
    {
        e.printStackTrace();
        System.out.println("Exception in clicking log out link");
    }
}
    public void searchAdvTechnology(String advTechnologyExcel)
    {
        try {

            actions.moveToElement(advTechnologyText);
            actions.click();
            actions.sendKeys(advTechnologyExcel);
            actions.build().perform();
            System.out.println("The Advanced Search Technology Value----------->" + advTechnologyExcel);
            advTechMatch = advTechnologyExcel;
            System.out.println("The advanced search Technology match value----------->" + advTechMatch);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Exception in searchAdvTechnolgy function!!!!!!!!!");
        }

    }


    public void selectAdvTechnology() throws InterruptedException {
        try {

            System.out.println("Total Advanced technology fetched-----" + advTechnologySuggestion.size());
            for (int i = 0; i < advTechnologySuggestion.size();i++)
                {
                advTechVal = advTechnologySuggestion.get(i).getAttribute("value").toString();
                if (advTechVal.equalsIgnoreCase(advTechMatch))
                {
                    countValueText=countValue.get(i).getText().toString();
                    advTechnologySuggestion.get(i).click();

                    System.out.println("count value fetched--->"+countValueText);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in selecting the technology");
        }
    }
    public boolean checkAdvTopLevelTechnology()
    {
        boolean result = true;
        try {
            System.out.println("Advanced Top Level technology size-----> " + advTopTechnologySuggestion.size());

            for (int i = 0; i < advTopTechnologySuggestion.size(); i++) {

                String topTech = advTopTechnologySuggestion.get(i).getAttribute("value").toString();
                System.out.println("top tech values---->" + topTech);

                if (topTech != null && topTech.equalsIgnoreCase(advTechMatch)) {
                    System.out.println("Its A Advanced Top Level Technology-------->" + topTech); //advTopTechnologySuggestion.get(i).getAttribute("value").toString());
                    advSearchText.click();
                    result = true;
                    break;
                } else {
                    result = false;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in top level technology");
        }
        return result;
    }


    public boolean checkAdvUpperAdvTechnology()
    {
        boolean result=true;
        try {
            System.out.println("Size Of Advanced Upper Technology----->" + advUppTechnologySuggestion.size());
            for (int i = 0; i < advUppTechnologySuggestion.size(); i++) {
                String advUppTech = advUppTechnologySuggestion.get(i).getAttribute("value").toString();

                if (advUppTech != null && advUppTech.equalsIgnoreCase(advTechMatch)) {
                    System.out.println("Its Advanced Upper Level Technology----------->" + advUppTechnologySuggestion.get(i).getAttribute("value").toString());
                    advSearchText.click();
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
            System.out.println("Exception in Advanced upper Technology---------->");
        }
        return  result;
    }

    public boolean checkAdvMiddleTechnology()
    {
        boolean result=true;
        try {
                System.out.println("The Size of Advanced Middle level Technology-------->" + advMidTechnologySuggestion.size());
                for (int i = 0; i < advMidTechnologySuggestion.size(); i++)

                {
                    String advMidTech = advMidTechnologySuggestion.get(i).getAttribute("value").toString();
                    if (advMidTech != null && advMidTech.equalsIgnoreCase(advTechMatch)) {
                        System.out.println("Its a Advanced middle Level Technology------------->" + advMidTechnologySuggestion.get(i).getAttribute("value").toString());
                        advSearchText.click();
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
            System.out.println("Exception in Advanced  Middle Level Technology");
        }
        return  result;
    }


    public boolean checkAdvLowerTechnology() {
        boolean result=true;
        try {
            System.out.println("The Size of Advanced Lower level Technology-------->" + advLowTechnolgySuggestion.size());
            for (int i = 0; i < advLowTechnolgySuggestion.size(); i++)

            {
                String advLowTech = advLowTechnolgySuggestion.get(i).getAttribute("value").toString();
                if (advLowTech != null && advLowTech.equalsIgnoreCase(advTechMatch)) {
                    System.out.println("Its a Advanced Lower Level Technology------------->" + advLowTechnolgySuggestion.get(i).getAttribute("value").toString());
                    advSearchText.click();
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
            System.out.println("Exception in Advanced  Lower Level Technology");
        }
        return  result;
    }
    public  void checkResultTestTechnology()throws InterruptedException
    {
        try {
            searchedCountValueText = searchedCountValue.getText().toString();
            System.out.println("searched count value---->" + searchedCountValueText);

            searchedValueText = searchedValue.getText().toString();
            System.out.println("searched value---->" + searchedValueText);

            if (countValueText.contains(searchedCountValueText) && searchedValueText.contains(advTechMatch)) {
                Reporter.log("****Test is passed from UI Consideration***",true);
            }
            else

            {
                Reporter.log("******Test is Failed from UI Consideration******",true);
            }
            Thread.sleep(3000);
        }
        catch(Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test result function ",true);
        }
    }


//Industry Scenarios to check the top level Industry ,Upper Level Industry and Middle Level Industry

    public void clickOnAdvIndustry(String advIndustryExcel) throws InterruptedException
    {

        actions.moveToElement(advIndustryText);
        actions.click();
        actions.sendKeys(advIndustryExcel);
        actions.build().perform();
        System.out.println("Industry value------>" + advIndustryExcel);
        advIndustryMatch = advIndustryExcel;
        System.out.println("industry match----------------->" +advIndustryMatch);
        Thread.sleep(1000);
    }


    public void selectAdvIndustry() throws InterruptedException {
        try {
            System.out.println("Total advanced Industry fetched-----" + advIndustrySuggestion.size());
            for (int i = 0; i < advIndustrySuggestion.size(); i++)
            {

                advIndustryVal = advIndustrySuggestion.get(i).getAttribute("value");
                if (advIndustryVal.equalsIgnoreCase(advIndustryMatch))
                {
                    countValueText=countValue.get(i).getText().toString();
                    advIndustrySuggestion.get(i).click();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in selecting the advanced Industry");
        }
    }

    public boolean checkAdvTopLevelIndustry() {
        boolean result=true;
        try {
            System.out.println("Advanced Top Level Industry size-----> " + advTopIndustySuggestion.size());
            for (int i = 0; i <advTopIndustySuggestion.size(); i++)
            {
                String topAdvIndus = advTopIndustySuggestion.get(i).getAttribute("value").toString();
                System.out.println("The value of industry---------->"+topAdvIndus);
                if (topAdvIndus != null && topAdvIndus.equalsIgnoreCase(advIndustryMatch))
                {
                    System.out.println("Its A Top Level Industry-------->" + advTopIndustySuggestion.get(i).getText().toString());
                    advSearchText.click();
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
            System.out.println("Exception in top level Industry");
        }
        return  result;
    }


    public boolean checkAdvUpperIndustry() {
        boolean result=true;
        try {


            System.out.println("Size Of Upper Industry----->" + advUppIndustrySuggestion.size());
            for (int i = 0; i < advUppIndustrySuggestion.size(); i++) {
                String uppIndus = advUppIndustrySuggestion.get(i).getAttribute("value").toString();

                if (uppIndus != null && uppIndus.equalsIgnoreCase(advIndustryMatch))
                {
                    System.out.println("Its A Upper Level Industry----------->" + advUppIndustrySuggestion.get(i).getAttribute("value").toString());
                    advSearchText.click();
                    result=true;
                    break;
                }
                else
                {
                    result=false;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in upper Industry---------->");
        }

        return  result;
    }
    public  void checkResultTestIndustry()throws InterruptedException
    {
        try {

            Reporter.log("Calling result test Industry",true);

            searchedCountValueText = searchedCountValue.getText().toString();
            System.out.println("searched count value---->" + searchedCountValueText);
            Thread.sleep(3000);
            searchedValueText = searchedValue.getText().toString();
            System.out.println("searched value---->" + searchedValueText);
            if (countValueText.contains(searchedCountValueText) && searchedValueText.contains(advIndustryMatch)) {
                Reporter.log("****Passed:-Test is passed for Industry Search from UI Consideration***",true);
            }
            else

            {
                Reporter.log("******Failed:-Test is Failed Industry Search from UI Consideration******",true);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test result for Industry Search function from UI Consideration",true);
        }
    }

    public void clickOnAdvSolution(String advSolutionExcel) throws InterruptedException {
        try {
           // Actions actions = new Actions(driver);
            actions.moveToElement(advSolutionText);
            actions.click();
            actions.sendKeys(advSolutionExcel);
            actions.build().perform();
            System.out.println("Solution value------>" + advSolutionExcel);
            advSolutionMatch = advSolutionExcel;
            System.out.println("Solution match----------------->" + advSolutionMatch);
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in click on solution method");
        }
    }


    public void selectAdvSolution() throws InterruptedException {
        try {
            System.out.println("Total Solution fetched-----" + advSolSuggestion.size());
            for (int i = 0; i <advSolSuggestion.size(); i++) {
                advSolVal = advSolSuggestion.get(i).getAttribute("value").toString();
                System.out.println("Business solution value------------>" + advSolVal);
                countValueText=countValue.get(i).getText().toString();
                advSolSuggestion.get(i).click();
                advSearchText.click();
                break;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in selecting the Business Solution");
        }
    }
    public  void checkResultTestSolutions()throws InterruptedException
    {
        try {

            searchedCountValueText = searchedCountValue.getText().toString();
            System.out.println("searched count value---->" + searchedCountValueText);
            Thread.sleep(3000);
             searchedValueText = searchedValue.getText().toString();
            System.out.println("searched value---->" + searchedValueText);
            if (countValueText.contains(searchedCountValueText) && searchedValueText.contains(advSolutionMatch)) {
                System.out.println("****Test is passed for solution Search***");
            }
            else

            {
                System.out.println("******Test is Failed solution Search******");
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("Exception in test result for solution Search function ");
        }
    }


    public void clickOnAdvCountry(String advCountryExcel) throws InterruptedException {
        try {
            //Actions actions = new Actions(driver);
            actions.moveToElement(advCountryText);
            actions.click();
            actions.sendKeys(advCountryExcel);
            actions.build().perform();
            System.out.println("Country value------>" + advCountryExcel);
            advCountryMatch = advCountryExcel;
            System.out.println("Country match----------------->" + advCountryMatch);
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in click on Country method");
        }
    }

    public void selectAdvCountry() throws InterruptedException {
        try {
            System.out.println("Total Country fetched-----" + advCountrySuggestion.size());
            for (int i = 0; i <= advCountrySuggestion.size(); i++) {
                advCountryVal = advCountrySuggestion.get(i).getAttribute("value").toString();
                System.out.println("Country value------------>" + advCountryVal);
                countValueText=countValue.get(i).getText().toString();
                advCountrySuggestion.get(i).click();
                advSearchText.click();
                break;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in selecting the  Country");
        }
    }

    public void  checkResultCountry()
    {
        try {

             searchedCountValueText = searchedCountValue.getText().toString();
            System.out.println("searched count value---->" + searchedCountValueText);
            Thread.sleep(3000);
            searchedValueText = searchedValue.getText().toString();
            System.out.println("searched value---->" + searchedValueText);
            if (countValueText.contains(searchedCountValueText) && searchedValueText.contains(advCountryMatch))
            {
                System.out.println("****Test is passed for country search***");
            }
            else

            {
                System.out.println("******Test is Failed for country search*****");
            }
        }
            catch(Exception e)
            {
                e.printStackTrace();
                System.out.println("Exception in check test result for country ");
            }
    }

    public void clickOnAdvCities(String advCitiesExcel) throws InterruptedException {
        try {
            actions.moveToElement(advCitiesText);
            actions.click();
            actions.sendKeys(advCitiesExcel);
            actions.build().perform();
            System.out.println("Cities value------>" + advCitiesExcel);
            advCitiesMatch = advCitiesExcel;
            System.out.println("Cities match----------------->" + advCitiesMatch);
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in click on city method");
        }
    }

    public void selectAdvCities() throws InterruptedException {
        try {
            System.out.println("Total City fetched-----" + advCitiesSuggestion.size());
            for (int i = 0; i <= advCitiesSuggestion.size(); i++) {
                advCitiesVal = advCitiesSuggestion.get(i).getAttribute("value").toString();
                System.out.println("Cities value------------>" + advCitiesVal);

                advCitiesSuggestion.get(i).click();
                advSearchText.click();
                break;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in selecting the  Cities");
        }
    }
    public void  checkResultCity()
    {
        try {

            searchedCountValueText = searchedCountValue.getText().toString();
            System.out.println("searched count value---->" + searchedCountValueText);
            Thread.sleep(3000);
            searchedValueText = searchedValue.getText().toString();
            System.out.println("searched value---->" + searchedValueText);
            if (countValueText.contains(searchedCountValueText) && searchedValueText.contains(advCitiesMatch)) {
                System.out.println("****Test is passed for cities search***");
            } else

            {
                System.out.println("******Test is Failed for cities search*****");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Exception in check test result for country ");
        }
    }

    public void clickOnAdvEmpCount(String advEmpCountExcel) throws InterruptedException {
        try {
            actions.moveToElement(empCountText);
            actions.click();
            actions.sendKeys(advEmpCountExcel);
            actions.build().perform();
            System.out.println("employee count value------>" + advEmpCountExcel);
            advEmpCountMatch = advEmpCountExcel;
            System.out.println("employee count match----------------->" + advEmpCountMatch);
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in click on Emp Count method");
        }
    }

    public void selectAdvEmpCount() throws InterruptedException {
        try {
            System.out.println("Total Emp Count fetched-----" + empCountSuggestion.size());
            for (int i = 0; i <= empCountSuggestion.size(); i++) {
                advEmpCountVal = empCountSuggestion.get(i).getAttribute("value").toString();
                System.out.println("Emp Count value------------>" + advEmpCountVal);
                empCountSuggestion.get(i).click();
                advSearchText.click();
                break;
            }

        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in selecting the  Employee Count");
        }
    }
    public void  checkResultEmpCount()
    {
        try {
            searchedCountValueText = searchedCountValue.getText().toString();
            System.out.println("searched count value---->" + searchedCountValueText);
            Thread.sleep(3000);
            searchedValueText = searchedValue.getText().toString();
            System.out.println("searched value---->" + searchedValueText);
            if (countValueText.contains(searchedCountValueText) && searchedValueText.contains(advEmpCountMatch)) {
                System.out.println("****Test is passed for employee count search***");
            } else

            {
                System.out.println("******Test is Failed for employee count search*****");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Exception in check test result for emp count");
        }
    }

    public void clickOnAdvBusinessType(String advBusinessTypeExcel) throws InterruptedException {
        try {

            actions.moveToElement(businessTypeText);
            actions.click();
            actions.sendKeys(advBusinessTypeExcel);
            actions.build().perform();
            System.out.println("business type value------>" + advBusinessTypeExcel);
            advBusiTypeMatch = advBusinessTypeExcel;
            System.out.println("business type match----------------->" + advBusiTypeMatch);
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in click on Business Type method");
        }
    }

    public void selectAdvBusinessType() throws InterruptedException {
        try {
            System.out.println("Total business type fetched-----" + businessTypeSuggestion.size());
            for (int i = 0; i <= businessTypeSuggestion.size(); i++) {
                advBusiTypeVal = businessTypeSuggestion.get(i).getAttribute("value").toString();
                System.out.println("Business Type value------------>" + advBusiTypeVal);

                businessTypeSuggestion.get(i).click();
                advSearchText.click();
                break;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in selecting the  Business type");
        }
    }
    public void  checkResultBusinessType()
    {
        try {

            searchedCountValueText = searchedCountValue.getText().toString();
            System.out.println("searched count value---->" + searchedCountValueText);
            Thread.sleep(3000);
           searchedValueText = searchedValue.getText().toString();
            System.out.println("searched value---->" + searchedValueText);
            if (countValueText.contains(searchedCountValueText) && searchedValueText.contains(advBusiTypeMatch)) {
                System.out.println("****Test is passed for business type search***");
            } else

            {
                System.out.println("******Test is Failed for business type search*****");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Exception in check test result for business type");
        }
    }
    public void clickOnAdvFundingStage(String advFundingStageExcel) throws InterruptedException {
        try {

            actions.moveToElement(advFundingText);
            actions.click();
            actions.sendKeys(advFundingStageExcel);
            actions.build().perform();
            System.out.println("Funding stage  value------>" + advFundingStageExcel);
            advFundingStageMatch = advFundingStageExcel;
            System.out.println("funding stage match----------------->" + advFundingStageMatch);
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in click on Funding Stage method!!!!!!!!!!!!!!!");
        }
    }

    public void selectAdvFundingStage() throws InterruptedException {
        try {
            System.out.println("Total funding stages fetched-----" + advFundingSuggestion.size());
            for (int i = 0; i <= advFundingSuggestion.size(); i++) {
                advFundingStageVal = advFundingSuggestion.get(i).getAttribute("value").toString();
                System.out.println("Funding stage value------------>" + advFundingStageVal);

                advFundingSuggestion.get(i).click();
                advSearchText.click();
                break;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in selecting the Funding Stage Method!!!!!!!!!!");
        }
    }
    public void  checkResultFundingStage()
    {
        try {

             searchedCountValueText = searchedCountValue.getText().toString();
            System.out.println("searched count value---->" + searchedCountValueText);
            Thread.sleep(3000);
            searchedValueText = searchedValue.getText().toString();
            System.out.println("searched value---->" + searchedValueText);
            if (countValueText.contains(searchedCountValueText) && searchedValueText.contains(advFundingStageMatch)) {
                System.out.println("****Test is passed for funding stage search***");
            } else

            {
                System.out.println("******Test is Failed for funding stage search*****");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Exception in check test result for funding stage");
        }
    }

    public void clickOnAdvInvestors(String advInvestorsExcel) throws InterruptedException {
        try {

            actions.moveToElement(advInvestorsText);
            actions.click();
            actions.sendKeys(advInvestorsExcel);
            actions.build().perform();
            System.out.println("Investors value excel------>" + advInvestorsExcel);
            advInvestorMatch = advInvestorsExcel;
            System.out.println("Investors match----------------->" + advInvestorMatch);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in click on Investors method!!!!!!!!!!!!!!!");
        }
    }

    public void selectAdvInvestors() throws InterruptedException {
        try {

            boolean checkpresent=advInvestorsSuggestion.isEmpty();
            System.out.println("Is present------------->"+checkpresent);
            System.out.println("Total Investors fetched-----" + advInvestorsSuggestion.size());
            for (int i = 0; i <advInvestorsSuggestion.size(); i++) {
                advInvestorVal = advInvestorsSuggestion.get(i).getAttribute("value").toString();
                if (advInvestorVal != null && advInvestorVal.equalsIgnoreCase(advInvestorMatch))
                {
                    System.out.println("Investor value------------>" + advInvestorVal);

                   advInvestorsSuggestion.get(i).click();

                    //advSearchText.click();
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in selecting the Investors Method!!!!!!!!!!");
        }
    }
    public void  checkResultInvestors()
    {
        try {

            searchedCountValueText = searchedCountValue.getText().toString();
            System.out.println("searched count value---->" + searchedCountValueText);
            Thread.sleep(3000);
           searchedValueText = searchedValue.getText().toString();
            System.out.println("searched value---->" + searchedValueText);
            if (searchedValueText.contains(advInvestorMatch)) {
                System.out.println("****Test is passed for Investors search***");
            } else

            {
                System.out.println("******Test is Failed for Investors search*****");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Exception in check test result for Investors");
        }
    }
    public void clickOnAdvFundingFrom(String advFromExcel) throws InterruptedException {
        try {

            actions.moveToElement(fundFromText);
            Thread.sleep(2000);
            actions.click();
            Thread.sleep(3000);
            actions.sendKeys(advFromExcel);
            Thread.sleep(3000);
            actions.build().perform();
            System.out.println("Fund From value------>" + advFromExcel);
            advFromMatch = advFromExcel;
            System.out.println("Fund From match----------------->" + advFromMatch);
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in click on Total  Funding  From method!!!!!!!!!!!!!!!");
        }
    }

    public void clickOnAdvFundingTo(String advToExcel) throws InterruptedException {
        try {
            actions.moveToElement(fundToText);
            actions.click();
            Thread.sleep(3000);
            actions.sendKeys(advToExcel);
            Thread.sleep(3000);
            actions.build().perform();
            System.out.println("Fund To value------>" + advToExcel);
            advToMatch = advToExcel;
            System.out.println("Fund To match----------------->" + advToMatch);
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in click on Total  Funding  To method!!!!!!!!!!!!!!!");
        }
    }

    public void  checkResultTotalFunding()
    {
        try {

             searchedCountValueText = searchedCountValue.getText().toString();
            System.out.println("searched count value---->" + searchedCountValueText);
            Thread.sleep(3000);
            searchedValueText = searchedValue.getText().toString();
            System.out.println("searched value---->" + searchedValueText);
            if (searchedValueText.contains(advFromMatch)&&searchedCountValueText.contains(advToMatch))
            {
                System.out.println("****Test is passed for total funding search***");
            } else

            {
                System.out.println("******Test is Failed for total funding search*****");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Exception in check test result for total funding");
        }
    }
    public void setMinFounderYear(int xOffsetExcel,int yOffsetExcel)
    {
        try {
            System.out.println("Set The Minimum Founder Year");
            actions.moveToElement(foundedYearMinPointer);
            Thread.sleep(3000);
            actions.clickAndHold();
            Thread.sleep(3000);
            actions.dragAndDropBy(foundedYearMinPointer,yOffsetExcel,xOffsetExcel).build().perform();;
            Thread.sleep(3000);
            actions.release().perform();

        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Exception in setting the minimum founder year");
        }
    }

    public void setMaxFounderYear(int xOffsetExcel,int yOffsetExcel)
    {
        try {
            System.out.println("Set The Maximum Founder Year");

            actions.moveToElement(foundedYearMaxPointer);
            Thread.sleep(3000);
           actions.clickAndHold();
            Thread.sleep(2000);
            actions.dragAndDropBy(foundedYearMaxPointer,xOffsetExcel,yOffsetExcel).build().perform();
            Thread.sleep(2000);
            actions.release().perform();

        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Exception in setting the Maximum founder year");
        }
    }



    public void clickSearchButton()
    {
        try {
            System.out.println("Click Search Button");
            actions.moveToElement(searchButton);
            actions.click();
            actions.build().perform();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Exception in click search Button");
        }

    }
    public void validateDataBase(String query,String columnName)
    {
        try {
            String dbFetchCount=null;
            String fetchColumnValue=null;

            stmt = conn.createStatement();
            resultSet = stmt.executeQuery(query);

            Reporter.log("-----------------------DB Validation-----------------", true);
            while (resultSet.next())
            {
                dbFetchCount=resultSet.getString(1);
                fetchColumnValue=resultSet.getString(columnName);
            }

            System.out.println("dbfecthcount value----------->"+dbFetchCount);
            System.out.println("fetchColumnValue------------->"+fetchColumnValue);


            if(fetchColumnValue.contains(searchedValueText)&&dbFetchCount.contains(searchedCountValueText)  )
            {
                Reporter.log("Passed:Data is validated from DB point ",true);

            }
            else
            {
               Reporter.log("Failed:Data Failed to validate from DB point",true);
            }

        } catch (Exception e)
        {
            e.printStackTrace();
            log.info("Exception in validating the database fields!!!!!!!");
        }
    }

    public void validateCombinedAdvancedSearchData(String query)
    {
        try {
            String dbFetchCount = null;
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery(query);
            while (resultSet.next())
            {
                dbFetchCount=resultSet.getString(1);
            }
            if(dbFetchCount.contains(searchedCountValueText))
            {

                Reporter.log("Passed: Data Has Been Validated From Data Base",true);
            }
            else
            {
                Reporter.log("Failed: Data Failed To Validate From Data Base",true);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
            Reporter.log("Exception In Validating Combined Advanced Search Data");
        }
    }

}
