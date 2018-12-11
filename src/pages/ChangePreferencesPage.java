package pages;

import base.BasePageLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;


import static generics.Utility.*;

public class ChangePreferencesPage extends BasePageLogin {

    public ChangePreferencesPage(WebDriver driver, Connection conn, Statement stmt, ResultSet resultSet, Actions actions) {

        super(driver, conn, stmt, resultSet, actions);
    }

    //Variable declaration
    String technologyMatch;
    String techVal;
    String industryMatch;
    String indstryVal;
    @FindBy(xpath = "//div[@class='block-level-input-holder']/input[@type='text']")
    WebElement companyName;

    @FindBy(css = "input[ng-model='searchFilter.technologyFilterText']")
    private WebElement technologiesText;

    @FindBy(xpath = "//div[@class='options perfect-scroll ps ps--theme_default' or @class='options perfect-scroll ps ps--theme_default ps--active-y']//input[contains(@id,'advanced-tech')]")
    private List<WebElement> technologySuggestion;

    @FindBy(xpath = "//div[@ng-click='top_level_tech.hidden = !top_level_tech.hidden']//input[@type='checkbox']")
    private List<WebElement> topTechnology;

    @FindBy(xpath = "//div[@ng-click='upper_level_tech.hidden = !upper_level_tech.hidden']//input[@type='checkbox']")
    private List<WebElement> upperTechnology;

    @FindBy(xpath = "//div[@ng-click='mid_level_tech.hidden = !mid_level_tech.hidden']//input[@type='checkbox']")
    private List<WebElement> middleTechnology;

    @FindBy(xpath = "//div[@ng-click='lower_level_tech.hidden = !lower_level_tech.hidden']//input[contains(@id,'advanced-tech')]")
    private List<WebElement> lowerTechnology;


    @FindBy(css = "input[ng-model='searchFilter.industryFilterText'][type='text']")
    private WebElement industryText;

    @FindBy(xpath = "//div[@class='options-list perfect-scroll ps ps--theme_default ps--active-y']//input[contains(@id,'advanced-sector')]")
    private List<WebElement> industrySuggestion;

    @FindBy(xpath = "//div[@ng-click='top_level_sector.hidden = !top_level_sector.hidden']//input[@type='checkbox']")
    private List<WebElement> topIndustry;

    @FindBy(xpath = "//div[@ng-click='upper_level_sector.hidden = !upper_level_sector.hidden']//input[@type='checkbox']")
    private List<WebElement> upperIndustry;

    @FindBy(xpath = "//div[@ng-click='mid_level_sector.hidden = !mid_level_sector.hidden']//input[@type='checkbox']")
    private List<WebElement> middleIndustry;
      String topTechVal;
    String uppTechVal;

    @FindBy(css="span[ng-click='goToDashboard(companyProfileDto);']")
    private WebElement saveButton;

    @FindBy(css="button[ng-click='goBack();']")
    private WebElement cancelBtn;

    @FindBy(xpath="//a[contains(text(),'Go to Dashboard')]")
    private WebElement goToDashboardLink;

    public boolean getURL()
    {
        boolean result=true;
        if(verifyURLhas("http://nthdim10.alloy.ee/add-company-details"))
        {
            result=true;
        }
        else
        {
            result=false;
        }
        return result;
    }

    public void clickOnTechnology(String technologyExcel) {
        try {
            clickOnElement(technologiesText, technologyExcel);
        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception On Click On Technology Method------>" + getClass());
        }
    }

    public void selectTechnology() throws InterruptedException {
        try {
            selectElementType1(technologySuggestion);
        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in selecting the technology", true);
        }
    }


    public boolean checkTopLevelTechnology() {
        boolean result = true;
        try {
            if (checkLevel(topTechnology, companyName) == true) {
                Reporter.log("Its A Top level Technology", true);
                result = true;
            } else {
                result = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in top level technology-------->" + getClass(), true);
        }
        return result;
    }


    public boolean checkUpperTechnology() {

        boolean result = true;
        try {
            if (checkLevel(upperTechnology, companyName) == true) {
                Reporter.log("Its A Upper level Technology", true);
                result = true;
            } else {
                result = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in upper Technology---------->" + getClass(), true);
        }

        return result;
    }


    public boolean checkMiddleTechnology() {
        boolean result = true;
        try {
            if (checkLevel(middleTechnology, companyName) == true) {
                Reporter.log("Its A Middle level Technology", true);
                result = true;
            } else {
                result = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in Middle Level Technology");
        }
        return result;

    }

    public void checkLowerTechnology() {
        try {
            if (checkLevel(lowerTechnology, companyName) == true) {
                Reporter.log("Its A Lower level Technology", true);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in  Lower Level Technology");
        }

    }

//Industry Scenarios to check the top level Industry ,Upper Level Industry and Middle Level Industry


    public void clickOnIndustry(String industryExcel) throws InterruptedException {
        try {
            clickOnElement(industryText, industryExcel);
        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception On Click On Industry Method------>" + getClass());
        }
    }

    public void selectIndustry() throws InterruptedException {
        try {
            selectElementType1(industrySuggestion);
        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in selecting the industry", true);
        }
    }


    public boolean checkTopLevelIndustry() {
        boolean result = true;
        try {
            if (checkLevel(topIndustry, companyName) == true) {
                Reporter.log("Its A Top level Industry", true);
                result = true;
            } else {
                result = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in top level Industry");
        }
        return result;
    }


    public boolean checkUpperIndustry() {
        boolean result = true;
        try {
            if (checkLevel(upperIndustry, companyName) == true) {
                Reporter.log("Its A Upper level Industry", true);
                result = true;
            } else {
                result = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in upper Industry---------->");
        }
        return result;
    }


    public boolean checkMiddleIndustry() {
        boolean result = true;
        try {
            if (checkLevel(middleIndustry, companyName) == true) {
                Reporter.log("Its A Middle level Industry", true);
                result = true;
            } else {
                result = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in Middle Level Industry");
        }
        return result;

    }

    public void clickSavePreferencesButton() {
        try {

           actions.moveToElement(saveButton);
            Thread.sleep(2000);
            actions.click();
            actions.build().perform();

        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in save preferences button!!!!!!!", true);
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

    @FindBy(xpath = "//input[@ng-model='companyProfileDto.companyName']")
    private WebElement companyNameTag;

    String companyNameValue = companyNameTag.getAttribute("value");

    public void getCompanyName() {

        Reporter.log("The value of ng-model---->" + companyNameTag.getAttribute("value"), true);

    }
}