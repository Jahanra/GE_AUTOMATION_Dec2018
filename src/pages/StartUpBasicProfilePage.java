package pages;

import generics.Utility;
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

public class StartUpBasicProfilePage extends StartUpMyProfilePage {
    public StartUpBasicProfilePage(WebDriver driver, Connection conn, Statement stmt, ResultSet resultSet, Actions actions) {
        super(driver, conn, stmt, resultSet, actions);
    }

    public void callMyProfilefunc() throws InterruptedException {
        goToMyProfileLink();
    }

    public void clickOnEditIcon() throws InterruptedException {
        clickOnEditIconOfBasicInfo();
    }

    @FindBy(xpath = "//input[@id='field_foundedYear']")
    private WebElement yearOfEstablishment;

    @FindBy(xpath = "//table[@class='uib-yearpicker']")
    private WebElement datePickerElement;

    @FindBy(xpath = "//td[@ng-repeat='dt in row']//span[@class='ng-binding']")
    private List<WebElement> dateTD;

    @FindBy(xpath = "//i[@class='glyphicon glyphicon-chevron-left']")
    private WebElement datePickerLeftArrow;

    @FindBy(xpath = "//i[@class='glyphicon glyphicon-chevron-right']")
    private WebElement datePickerRightArrow;

    @FindBy(xpath = "(//div[@class='dropdown'])[1]")
    private WebElement noOfEmployees;

    @FindBy(xpath = "//input[@ng-model='searchFilter.teamSizeFilterText']")
    private WebElement enterTeamSize;

    @FindBy(xpath = "//span[@ng-bind-html='teamSize | highlight:searchFilter.teamSizeFilterText']/span[@class='highlight']")
    private List<WebElement> selectTeamSizeOption;

    @FindBy(xpath = "(//div[@class='dropdown'])[2]")
    private WebElement headquartersCountry;

    @FindBy(xpath = "//input[@ng-model='searchFilter.countryFilterText']")
    private WebElement enterCountry;

    @FindBy(xpath = "//span[@ng-bind-html='country | highlight:searchFilter.countryFilterText']/span[@class='highlight']")
    private List<WebElement> selectCountryOption;

    @FindBy(xpath = "(//div[@class='dropdown'])[3]")
    private WebElement city;

    @FindBy(xpath = "//input[@ng-model='searchFilter.cityFilterText']")
    private WebElement enterCity;

    @FindBy(xpath = "//span[@ng-bind-html='city | highlight:searchFilter.cityFilterText']/span[@class='highlight']")
    private List<WebElement> selectCityOption;


    @FindBy(xpath = "//textarea[@ng-model='companyProfileDto.shortDescriptions']")
    private WebElement shortDescription;

    @FindBy(xpath = "//input[@ng-model='searchFilter.technologyFilterText']")
    private WebElement technologyText;

    @FindBy(xpath = "//div[@class='options perfect-scroll ps ps--theme_default ps--active-y']//input[@type='checkbox']")
    private List<WebElement> technologySuggestion;

    @FindBy(xpath = "//div[@ng-click='top_level_tech.hidden = !top_level_tech.hidden']//input[contains(@id,'advanced-tech')and @type='checkbox']")
    private List<WebElement> topTechnologySuggestion;

    @FindBy(xpath = "//div[@class='input-checkboxes-field' and @ng-click='upper_level_tech.hidden = !upper_level_tech.hidden']//input[contains(@id,'advanced-tech') and @type='checkbox']")
    private List<WebElement> uppTechnologySuggestion;

    @FindBy(xpath = "//div[@class='input-checkboxes-field' and @ng-click='mid_level_tech.hidden = !mid_level_tech.hidden']//input[contains(@id,'advanced-tech') and @type='checkbox']")
    private List<WebElement> midTechnologySuggestion;

    @FindBy(xpath = "//div[@ng-click='lower_level_tech.hidden = !lower_level_tech.hidden']//input[contains(@id,'advanced-tech') and @type='checkbox']")
    private List<WebElement> lowTechnolgySuggestion;


    @FindBy(xpath = "//input[@ng-model='searchFilter.industryFilterText']")
    private WebElement industryText;

    @FindBy(xpath = "//div[@class='options perfect-scroll ps ps--theme_default']//input[ contains(@id,'advanced-sector') and @type='checkbox']")
    private List<WebElement> industrySuggestion;

    @FindBy(xpath = "//div[@class='input-checkboxes-field' and @ng-click='top_level_sector.hidden = !top_level_sector.hidden']//input[contains(@id,'advanced-sector') and @type='checkbox']")
    private List<WebElement> topIndustySuggestion;

    @FindBy(xpath = "//div[@class='input-checkboxes-field' and @ng-click='upper_level_sector.hidden = !upper_level_sector.hidden']//input[contains(@id,'advanced-sector') and @type='checkbox']")
    private List<WebElement> uppIndustrySuggestion;

    @FindBy(xpath = "//div[@class='input-checkboxes-field' and @ng-click='mid_level_sector.hidden = !mid_level_sector.hidden']//input[contains(@id,'advanced-sector') and @type='checkbox']")
    private List<WebElement> midIndustrySuggestion;

    @FindBy(xpath = "//input[@ng-model='searchFilter.solutionFilterText' and @type='text']")
    private WebElement solutionText;


    @FindBy(xpath = "//div[@ng-repeat='solution in queried_solutions | filter: searchFilter.solutionFilterText']//input[@type='checkbox']")
    private List<WebElement> solutionSuggestion;


    @FindBy(xpath = "//span[@class='highlight ng-binding' and contains(text(),'Add')]")
    private WebElement addNewSolutionText;

    @FindBy(xpath = "//input[@ng-model='searchFilter.challengeFilterText'and @type='text']")
    private WebElement challenge;


    @FindBy(xpath = " //div[@ng-repeat='challenge in queried_challenges | filter: searchFilter.challengeFilterText']//input[@type='checkbox']")
    private List<WebElement> challengesSuggestions;


    @FindBy(xpath = "//span[@class='highlight ng-binding' and contains(text(),'Add')]")
    private WebElement addNewChallengeText;


    @FindBy(xpath = "//span[@class='action-button close' and @ng-click='save(companyProfileDto) && closeAllModals($event);']")
    private WebElement saveButton;

    @FindBy(xpath = "//span[@class='action-button close' and @ng-click='revertBasicInfo(); closeAllModals($event);']")
    private WebElement cancelButton;

    @FindBy(xpath = "//input[@ng-model='companyProfileDto.companyEmail']")
    private WebElement contactText;

    @FindBy(xpath = "//input[@ng-model='companyProfileDto.companyName']")
    private WebElement companyName;

    String teamSizeVal = null;
    String technologyMatch = null;
    String techVal = null;
    String industryMatch = null;
    String indstryVal = null;
    String solutionMatch = null;
    String solVal = null;
    String challengesVal = null;
    String countryVal = null;
    String cityVal = null;
    String tdValue = null;
    String contactMatch = null;

    @FindBy(xpath = "(//section[@class='value ng-binding'])[2]")
    private WebElement solutionConfirmText;

    @FindBy(xpath = "(//section[@class='value ng-binding'])[3]")
    private WebElement challengesConfirmText;

    @FindBy(xpath = "//div[@class='tech']//span")
    private List<WebElement> techValid;

    @FindBy(xpath = "//div[@ng-if='!basicDataFetching && listOfIndustryAndSubSectorString']//section[@class='value ng-binding']")
    private WebElement industryValid;

    @FindBy(xpath = "//div[@ng-if='!basicDataFetching && businessSolutionsString']//section[@class='value ng-binding']")
    private WebElement solutionValid;

    @FindBy(xpath = "//div[@ng-if='!basicDataFetching && companyProfileDto.foundedYear != null']//section[@class='value ng-binding']")
    private WebElement dateValid;

    @FindBy(xpath = "//div[@ng-if='!basicDataFetching && (companyProfileDto.country || companyProfileDto.city)']//span[contains(@ng-show,'companyProfileDto.city') or contains(@ng-show,'companyProfileDto')]")
    private WebElement headquatersValid;

    @FindBy(xpath = "//div[@ng-if='!basicDataFetching && companyProfileDto.companyUrl']//a")
    private WebElement websiteValid;
    @FindBy(xpath = "//div[@ng-if='!basicDataFetching && companyProfileDto.companyEmail']//section[@class='value ng-binding']")
    private WebElement contactValid;

    @FindBy(xpath = "(//section[@class='value']//a)[2]")
    private WebElement socialLinkedInValid;

    @FindBy(xpath = "(//section[@class='value']//a)[3]")
    private WebElement socialFacebookValid;

    @FindBy(xpath = "(//section[@class='value']//a)[4]")
    private WebElement socialTwitterValid;

    String techUpdateVal = null;
    String solUpdateVal = null;
    String yearUpdateVal = null;
    String indusUpdateVal = null;
    String countryUpdateVal = null;
    String contactUpdateVal = null;


    public void clickOnYearOfEstablishment(String yearExcel) throws InterruptedException {
        try {
            actions.moveToElement(yearOfEstablishment);
            actions.sendKeys(yearExcel);
            Thread.sleep(5000);
            actions.click();
            actions.moveToElement(datePickerElement);
            Thread.sleep(2000);
            actions.moveToElement(datePickerLeftArrow);
            Thread.sleep(2000);
            actions.click();
            actions.build().perform();
            /* Utility.datePicker(datePickerElement,dateTD,yearExcel);*/
            for (int i = 0; i < dateTD.size(); i++) {
                tdValue = dateTD.get(i).getText();
                Reporter.log("The Value Of Date Of Establishment-------->" + tdValue, true);
                if (yearExcel.contains(tdValue)) {
                    dateTD.get(i).click();
                    companyName.click();
                    break;
                } else {
                    Reporter.log("The value of establishment doesnt match", true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in selecting the year of establishment");
        }


    }

    public void clickOnNoOfEmployee() throws InterruptedException {

        actions.moveToElement(noOfEmployees);
        actions.click();
        Thread.sleep(2000);
        actions.build().perform();

    }

    public void setNoOfEmployee(String teamSizeExcel) throws InterruptedException {

        actions.moveToElement(enterTeamSize);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(teamSizeExcel);
        actions.build().perform();
        for (int i = 0; i <= selectTeamSizeOption.size(); i++) {
            teamSizeVal = selectTeamSizeOption.get(i).getText().toString();
            Reporter.log("The value of team fetched is-------->" + teamSizeVal, true);
            if (teamSizeExcel.contains(teamSizeVal)) {
                selectTeamSizeOption.get(i).click();
                companyName.click();
                break;
            } else {
                Reporter.log("Not Matched the team size value");
            }

        }
    }

    public void clickOnCountry() throws InterruptedException {

        actions.moveToElement(headquartersCountry);
        actions.click();
        actions.build().perform();


    }

    public void setCountryName(String countryExcel) throws InterruptedException {

        actions.moveToElement(enterCountry);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(countryExcel);
        actions.build().perform();
        for (int i = 0; i <= selectCountryOption.size(); i++) {
            countryVal = selectCountryOption.get(i).getText().toString();
            Reporter.log("The value of country fetched is-------->" + countryVal, true);
            if (countryExcel.contains(countryVal)) {
                selectCountryOption.get(i).click();
                companyName.click();
                break;
            } else {
                Reporter.log("Not Matched the country value", true);
            }

        }


    }

    public void clickOnCity() throws InterruptedException {

        actions.moveToElement(city);
        actions.click();
        actions.build().perform();
    }

    public void setCity(String cityExcel) throws InterruptedException {

        actions.moveToElement(enterCity);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(cityExcel);
        actions.build().perform();
        for (int i = 0; i <= selectCityOption.size(); i++) {
            cityVal = selectCityOption.get(i).getText().toString();
            Reporter.log("The value of city fetched is-------->" + cityVal, true);
            if (cityExcel.contains(cityVal)) {
                selectCityOption.get(i).click();
                companyName.click();
                break;
            } else {
                Reporter.log("Not Matched the city value", true);
            }

        }


    }

    public void setShortDescription(String description) throws InterruptedException {

        actions.moveToElement(shortDescription);
        Thread.sleep(2000);
        actions.click();
        actions.sendKeys(description);
        Thread.sleep(2000);
        actions.build().perform();


    }

    public void clickOnTechnology(String technologyExcel) throws InterruptedException {
        try {
            System.out.println("driver value in  click on technology----------->" + driver);
            actions.moveToElement(technologyText);
            actions.click();
            actions.sendKeys(technologyExcel);
            actions.build().perform();
            System.out.println("Technology value------>" + technologyExcel);
            technologyMatch = technologyExcel;
            System.out.println("Technology match----------------->" + technologyMatch);
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in click on technology method");
        }
    }


    public void selectTechnology() throws InterruptedException {
        try {
            System.out.println("Total technology fetched-----" + technologySuggestion.size());
            for (int i = 0; i < technologySuggestion.size(); i++) {
                techVal = technologySuggestion.get(i).getAttribute("value").toString();
                if (techVal.equalsIgnoreCase(technologyMatch)) {
                    technologySuggestion.get(i).click();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in selecting the technology");
        }
    }


    public void checkTopLevelTechnology() {
        try {
            System.out.println("Top Level technology size-----> " + topTechnologySuggestion.size());
            for (int i = 0; i < topTechnologySuggestion.size(); i++) {
                String topTech = topTechnologySuggestion.get(i).getAttribute("value").toString();
                if (topTech != null && topTech.equalsIgnoreCase(technologyMatch)) {
                    System.out.println("Its A Top Level Technology-------->" + topTechnologySuggestion.get(i).getAttribute("value").toString());
                    companyName.click();
                    break;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in top level technology");
        }
    }


    public void checkUpperTechnology() {
        try {


            System.out.println("Size Of Upper Technology----->" + uppTechnologySuggestion.size());
            for (int i = 0; i < uppTechnologySuggestion.size(); i++) {
                String uppTech = uppTechnologySuggestion.get(i).getAttribute("value").toString();

                if (uppTech != null && uppTech.equalsIgnoreCase(technologyMatch)) {
                    System.out.println("Its A Upper Level Technology----------->" + uppTechnologySuggestion.get(i).getAttribute("value").toString());
                    companyName.click();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in upper Technology---------->");
        }
    }


    public void checkMiddleTechnology() {
        try {
            System.out.println("The Size of Middle level Technology-------->" + midTechnologySuggestion.size());
            for (int i = 0; i < midTechnologySuggestion.size(); i++)

            {
                String midTech = midTechnologySuggestion.get(i).getAttribute("value").toString();
                if (midTech != null && midTech.equalsIgnoreCase(technologyMatch)) {
                    System.out.println("Its a middle Level Technology------------->" + midTechnologySuggestion.get(i).getAttribute("value").toString());
                    companyName.click();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in Middle Level Technology");
        }

    }

    public void checkLowerTechnology() {
        try {
            System.out.println("The Size of Lower level Technology-------->" + lowTechnolgySuggestion.size());
            for (int i = 0; i < lowTechnolgySuggestion.size(); i++)

            {
                String lowTech = lowTechnolgySuggestion.get(i).getAttribute("value").toString();
                if (lowTech != null && lowTech.equalsIgnoreCase(technologyMatch)) {
                    System.out.println("Its a Lower Level Technology------------->" + lowTechnolgySuggestion.get(i).getAttribute("value").toString());
                    companyName.click();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in Lower Level Technology");
        }

    }

    public void clickOnIndustry(String industryExcel) throws InterruptedException {
        actions.moveToElement(industryText);
        actions.click();
        actions.sendKeys(industryExcel);
        actions.build().perform();
        System.out.println("Industry value------>" + industryExcel);
        industryMatch = industryExcel;
        System.out.println("industry match----------------->" + industryMatch);
        Thread.sleep(1000);
    }


    public void selectIndustry() throws InterruptedException {
        try {
            System.out.println("Total Industry fetched-----" + industrySuggestion.size());
            for (int i = 0; i < industrySuggestion.size(); i++) {
                indstryVal = industrySuggestion.get(i).getAttribute("value");
                if (indstryVal.equalsIgnoreCase(industryMatch)) {
                    industrySuggestion.get(i).click();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in selecting the Industry");
        }
    }


    public void checkTopLevelIndustry() {
        try {
            System.out.println("Top Level Industry size-----> " + topIndustySuggestion.size());
            for (int i = 0; i < topIndustySuggestion.size(); i++) {
                String topIndus = topIndustySuggestion.get(i).getText().toString();
                if (topIndus != null && topIndus.equalsIgnoreCase(industryMatch)) {
                    System.out.println("Its A Top Level Industry-------->" + topIndustySuggestion.get(i).getText().toString());
                    companyName.click();
                    break;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in top level Industry");
        }
    }


    public void checkUpperIndustry() {
        try {


            System.out.println("Size Of Upper Industry----->" + uppIndustrySuggestion.size());
            for (int i = 0; i < uppIndustrySuggestion.size(); i++) {
                String uppIndus = uppIndustrySuggestion.get(i).getAttribute("value").toString();

                if (uppIndus != null && uppIndus.equalsIgnoreCase(industryMatch)) {
                    System.out.println("Its A Upper Level Industry----------->" + uppIndustrySuggestion.get(i).getAttribute("value").toString());
                    companyName.click();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in upper Industry---------->");
        }
    }


    public void checkMiddleIndustry() {
        try {
            System.out.println("The Size of Middle level Industry-------->" + midIndustrySuggestion.size());
            for (int i = 0; i < midIndustrySuggestion.size(); i++)

            {
                String midIndus = midIndustrySuggestion.get(i).getAttribute("value").toString();
                if (midIndus != null && midIndus.equalsIgnoreCase(industryMatch)) {
                    System.out.println("Its a middle Level Industry------------->" + midIndustrySuggestion.get(i).getAttribute("value").toString());
                    companyName.click();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in Middle Level Industry");
        }

    }

    public void clickOnSolution(String solutionExcel) throws InterruptedException {
        try {
            actions.moveToElement(solutionText);
            actions.click();

            actions.sendKeys(solutionExcel);
            actions.build().perform();
            System.out.println("Solution value------>" + solutionExcel);
            solutionMatch = solutionExcel;
            System.out.println("Solution match----------------->" + solutionMatch);
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in click on solution method");
        }
    }


    public void selectSolution() throws InterruptedException {
        try {
            System.out.println("Total Solution fetched-----" + solutionSuggestion.size());
            for (int i = 0; i <= solutionSuggestion.size(); i++) {
                solVal = solutionSuggestion.get(i).getAttribute("value").toString();
                System.out.println("solution value------------>" + solVal);

                solutionSuggestion.get(i).click();
                companyName.click();
                break;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in selecting the Solution");
        }
    }

    String newSolutionMatch = null;

    public void setNewSolution(String newSolutionExcel) throws InterruptedException {
        try {
            actions.moveToElement(solutionText);
            actions.click();


            actions.sendKeys(newSolutionExcel);
            newSolutionMatch = newSolutionExcel;
            actions.build().perform();
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in adding new solution");
        }
    }

    public void addNewSolution() throws InterruptedException {
        try {

            actions.moveToElement(addNewSolutionText);
            actions.click();
            actions.build().perform();
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in add new  solution method");
        }
    }

    public void clickOnChallenges(String challengeExcel) {
        try {

            actions.moveToElement(challenge);
            actions.click();

            actions.sendKeys(challengeExcel);
            actions.build().perform();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in click on challenges method!!!!!!!!!!!!!1");
        }
    }


    public void selectChallenges() throws InterruptedException {
        try {
            System.out.println("Total challenges fetched-----" + challengesSuggestions.size());
            for (int i = 0; i <= challengesSuggestions.size(); i++) {
                challengesVal = challengesSuggestions.get(i).getAttribute("value").toString();
                System.out.println("Challenges value------------>" + challengesVal);
                challengesSuggestions.get(i).click();
                companyName.click();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in selecting the challenges");
        }
    }

    String newChallengeMatch = null;

    public void setNewChallenges(String newChallengesExcel) throws InterruptedException {

        actions.moveToElement(challenge);
        actions.click();

        actions.sendKeys(newChallengesExcel);
        newChallengeMatch = newChallengesExcel;
        actions.build().perform();
        Thread.sleep(1000);
    }


    public void addNewChallenge() throws InterruptedException {
        try {

            actions.moveToElement(addNewChallengeText);
            actions.click();
            actions.build().perform();
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in add new  challenge method");
        }
    }

    public void clickOnContact(String contactExcel) throws InterruptedException {
        try {

            actions.moveToElement(contactText);
            actions.click();
            actions.sendKeys(contactExcel);
            contactMatch = contactExcel;
            actions.build().perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickSaveBasicProfile() {
        try {
            System.out.println("click on save button in basic profile pop up");
            actions.moveToElement(saveButton);
            actions.click();
            actions.build().perform();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in save button!!!!!!!");
        }
    }


    public void checkResultEditBasicProfile() throws InterruptedException {
        try {
            for (int i = 0; i <= techValid.size(); i++) {
                techUpdateVal = techValid.get(i).getText().toString();
            }
            System.out.println("tech validation value---->" + techUpdateVal);
            indusUpdateVal = industryValid.getText().toString();
            System.out.println("industry validation value---->" + indusUpdateVal);
            solUpdateVal = solutionValid.getText().toString();
            System.out.println("Solution validation value------>" + solUpdateVal);
            yearUpdateVal = dateValid.getText().toString();
            System.out.println("year validation value------>" + yearUpdateVal);
            countryUpdateVal = headquatersValid.getText().toString();
            System.out.println("Head quarters validation value------>" + countryUpdateVal);
            contactUpdateVal = contactValid.getText().toString();
            System.out.println("contact validation value----->" + contactUpdateVal);

            if (techUpdateVal.contains(technologyMatch) && indusUpdateVal.contains(industryMatch) && solUpdateVal.contains(solutionMatch) && yearUpdateVal.contains(tdValue) && countryVal.contains(countryUpdateVal) && cityVal.contains(countryUpdateVal) && contactUpdateVal.contains(contactMatch)) {
                Reporter.log("**** Basic Profile Test is passed from UI Consideration***", true);
            } else

            {
                Reporter.log("******Basic Profile Test is Failed from UI Consideration******", true);
            }
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in Basic Profile test result function ", true);
        }
    }
}
