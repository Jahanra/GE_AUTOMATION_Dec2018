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

public class FinanacialInformationPage extends StartUpMyProfilePage {
    public FinanacialInformationPage(WebDriver driver, Connection conn, Statement stmt, ResultSet resultSet, Actions actions) {
        super(driver, conn, stmt, resultSet, actions);
    }

    public void callMyProfilefunc() throws InterruptedException {
        goToMyProfileLink();
    }

    public void callScrollByFunc() {
        scrollByUsingJSFunc();
    }

    public void callClickAddFinancialInfo() throws InterruptedException {
        clickOnAddFinanacialInfo();
    }

    @FindBy(xpath="//header[contains(text(),'Financial Information ')]")
    private WebElement financialInfoTitle;

    @FindBy(xpath = "(//div[@class='value ng-binding'])[1]")
    private WebElement revenue;

    @FindBy(xpath = "//input[@ng-model='searchFilter.revenueFilterText']")
    private WebElement revenueText;

    @FindBy(xpath = "//span[@ng-bind-html='revenue | highlight:searchFilter.revenueFilterText']")
    private List<WebElement> revenueSuggestion;

    @FindBy(xpath = "(//div[@class='value ng-binding'])[2]")
    private WebElement companyProfitable;

    @FindBy(xpath = "//input[@ng-model='searchFilter.profitabilityFilterText']")
    private WebElement companyProfitableText;

    @FindBy(xpath = "//span[@ng-bind-html='profitability.name | highlight:searchFilter.profitabilityFilterText']")
    private List<WebElement> companyProfitableSuggestion;

    @FindBy(xpath = "//div[@ng-click='addCompanyFunding()']")
    private WebElement addFundingRound1;

    @FindBy(xpath = "(//div[@class='value ng-binding'])[3]")
    private WebElement fundingStage;


    @FindBy(xpath = "//input[@ng-model='searchFilter.revenueFilterText']")
    private WebElement fundingText;

    @FindBy(xpath = "//span[@ng-bind-html='fundingStage | highlight:searchFilter.fundingStageFilterText']")
    private List<WebElement> fundingSuggestion;

    @FindBy(xpath="//input[@id='field_fundingDate0']")
    private WebElement fundingYear;

    @FindBy(xpath="//table[@class='uib-yearpicker']//tr//td//button//span")
    private WebElement datePickerYear;

    @FindBy(xpath="//button[@class='btn btn-default btn-sm pull-left uib-left']")
    private WebElement leftArrowYear;

    @FindBy(xpath="//button[@class='btn btn-default btn-sm pull-right uib-right']")
    private WebElement rightArrowYear;


    @FindBy(xpath="//input[@ng-model='fundingRound.fundingAmount']")
    private WebElement fundingAmount;

    @FindBy(xpath="(//div[@class='value ng-binding'])[4]")
    private WebElement fundingDenomination;

    @FindBy(xpath="//input[@ng-model='searchFilter.fundingDenominationFilterText']")
    private WebElement fundingDenomText;

    @FindBy(xpath="//span[@ng-bind-html='fundingDenomination | highlight:searchFilter.fundingDenominationFilterText']")
    private List<WebElement> fundingDenomSuggestion1;

    @FindBy(xpath="//input[@ng-model='searchFilter.fundingInvestorFilterText[$index]']")
    private WebElement investor;

    @FindBy(xpath="//input[@id='advanced-solution-' and @type='checkbox'']")
    private WebElement investorName;

    @FindBy(xpath="//span[@ng-bind-html='queried_investor | highlight:searchFilter.fundingInvestorFilterText[$parent.$index]']/span")
    private List<WebElement> investorSuggestion;

    @FindBy(xpath="//div[@ng-click='addCompanyFunding()']")
    private WebElement addFundingRound2;

    @FindBy(xpath = "(//div[@class='value ng-binding'])[5]")
    private WebElement fundingStage2;


    @FindBy(xpath = "//input[@ng-model='searchFilter.revenueFilterText']")
    private WebElement fundingText2;

    @FindBy(xpath = "//span[@ng-bind-html='fundingStage | highlight:searchFilter.fundingStageFilterText']")
    private List<WebElement> fundingSuggestion2;

    @FindBy(xpath="//input[@id='field_fundingDate0']")
    private WebElement fundingYear2;

    @FindBy(xpath="//table[@class='uib-yearpicker']//tr//td//button//span")
    private WebElement datePickerYear2;

    @FindBy(xpath="//button[@class='btn btn-default btn-sm pull-left uib-left']")
    private WebElement leftArrowYear2;

    @FindBy(xpath="//button[@class='btn btn-default btn-sm pull-right uib-right']")
    private WebElement rightArrowYear2;


    @FindBy(xpath="//input[@ng-model='fundingRound.fundingAmount']")
    private WebElement fundingAmount2;

    @FindBy(xpath="(//div[@class='value ng-binding'])[6]")
    private WebElement fundingDenomination2;

    @FindBy(xpath="//input[@ng-model='searchFilter.fundingDenominationFilterText']")
    private WebElement fundingDenomText2;
    @FindBy(xpath="//span[@ng-bind-html='fundingDenomination | highlight:searchFilter.fundingDenominationFilterText']")
    private List<WebElement> fundingDenomSuggestion2;


    @FindBy(xpath="//input[@ng-model='searchFilter.fundingInvestorFilterText[$index]']")
    private WebElement investor2;

    @FindBy(xpath="//input[@id='advanced-solution-' and @type='checkbox'']")
    private WebElement investorName2;

    @FindBy(xpath="//span[@ng-bind-html='queried_investor | highlight:searchFilter.fundingInvestorFilterText[$parent.$index]']/span")
    private List<WebElement> investorSuggestion2;

    @FindBy(xpath="//span[@ng-click='revertFunding(); closeAllModals($event);']")
    private WebElement cancelBtn;

    @FindBy(xpath="//span[@ng-click='save(companyProfileDto);closeAllModals($event);']")
    private  WebElement saveBtn;

    @FindBy(xpath="//i[@class='fa fa-2x fa-close close']")
    private WebElement close;

    String revenueVal;

    String companyProfitVal;
    String fundingStage1Val;

    String fundingDenom1Val;
    String investorVal1;

    String fundingStage2Val;

    String investorVal2;

    String fundingDenom2Val;

    @FindBy(xpath="//div[@ng-if='companyProfileDto.revenue && companyProfileDto.revenue != null']//section[@class='value ng-binding']")
    private  WebElement revenueValid;

    @FindBy(xpath = "//section[@ng-if='companyTotalAndLastFundingDetails.funding_stage != null']")
     private  WebElement fundingStageValid;

    @FindBy(xpath = "//div[@ng-if='companyTotalAndLastFundingDetails.total_funding_amount_in_million_usd && companyTotalAndLastFundingDetails.total_funding_amount_in_million_usd != null']//section[@class='value ng-binding']")
    private  WebElement fundAmountValid;

    @FindBy(xpath = "//div[@ng-if='companyTotalAndLastFundingDetails.total_funding_rounds && companyTotalAndLastFundingDetails.total_funding_rounds != null']//section[@class='value ng-binding']")
    private WebElement fundRoundValid;

    @FindBy(xpath="(//section[@class='profile-section funding-section']//section[@class='value ng-binding'])[4]")
    private  WebElement lastFundValid;

    @FindBy(xpath="(//section[@class='profile-section funding-section']//section[@class='value ng-binding'])[5]")
    private WebElement lastFundDateValid;

    @FindBy(xpath = "(//section[@class='profile-section funding-section']//section[@class='value ng-binding'])[6]")
    private WebElement totalInvestorValid;

    @FindBy(xpath="(//section[@class='profile-section funding-section']//section[@class='value ng-binding'])[7]")
    private WebElement actInvesValid;

    String revenuUpdateVal;

     String fundStageUpdateVal;

     String fundAmountUpdateVal;

     String fundRoundsUpdate;

     String lastFundUpdate;

    public void clickOnRevenue()throws InterruptedException
    {
        actions.moveToElement(revenue);
        actions.click();
        actions.build().perform();
    }

    public void setRevenue(String revenueExcel)throws InterruptedException
    {

        actions.moveToElement(revenueText);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(revenueExcel);
        actions.build().perform();
        for(int i=0;i<revenueSuggestion.size();i++)
        {
            revenueVal=revenueSuggestion.get(i).getText().toString();
            Reporter.log("The value of revenue  fetched is-------->"+revenueVal,true);
            if(revenueExcel.equalsIgnoreCase(revenueVal))
            {
                revenueSuggestion.get(i).click();
                financialInfoTitle.click();
                break;
            }
            else
            {
                Reporter.log("Not Matched the revenue value",true);
            }

        }
    }

    public void clickOnCompanyProfit()throws InterruptedException
    {
        actions.moveToElement(companyProfitable);
        actions.click();
        actions.build().perform();
    }

    public void setCompanyProfitable(String companyProfitableExcel)throws InterruptedException
    {

        actions.moveToElement(companyProfitableText);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(companyProfitableExcel);
        actions.build().perform();
        for(int i=0;i<revenueSuggestion.size();i++)
        {
            companyProfitVal=revenueSuggestion.get(i).getText().toString();
            Reporter.log("The value of company profitable   fetched is-------->"+companyProfitVal,true);
            if(companyProfitableExcel.equalsIgnoreCase(companyProfitVal))
            {
                revenueSuggestion.get(i).click();
                financialInfoTitle.click();
                break;
            }
            else
            {
                Reporter.log("Not Matched the company profitable value",true);
            }

        }
    }
    public void clickAddFundingRound1() throws InterruptedException
    {
        actions.moveToElement(addFundingRound1);
        actions.click();
        actions.build().perform();
    }

    public void clickOnFundingStage1()throws InterruptedException
    {
        actions.moveToElement(fundingStage);
        actions.click();
        actions.build().perform();
    }

    public void setFundingStage1(String fundingStageExcel)throws InterruptedException
    {

        actions.moveToElement(fundingText);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(fundingStageExcel);
        actions.build().perform();
        for(int i=0;i<fundingSuggestion.size();i++)
        {
            fundingStage1Val=fundingSuggestion.get(i).getText().toString();
            Reporter.log("The value of funding stage 1   fetched is-------->"+fundingStage1Val,true);
            if(fundingStageExcel.equalsIgnoreCase(fundingStage1Val))
            {
                fundingSuggestion.get(i).click();
                financialInfoTitle.click();
                break;
            }
            else
            {
                Reporter.log("Not Matched the funding stage 1 value",true);
            }

        }
    }
    public void setFundingAmount1(String fundAmountExcel) throws InterruptedException
    {
        actions.moveToElement(fundingAmount);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(fundAmountExcel);
        actions.build().perform();

    }

    public void clickOnFundingDenom1()throws InterruptedException
    {
        actions.moveToElement(fundingDenomination);
        actions.click();
        actions.build().perform();
    }

    public void setFundingDenom1(String fundingDenomExcel)throws InterruptedException
    {

        actions.moveToElement(fundingDenomText);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(fundingDenomExcel);
        actions.build().perform();
        for(int i=0;i<fundingDenomSuggestion1.size();i++)
        {
            fundingDenom1Val=fundingDenomSuggestion1.get(i).getText().toString();
            Reporter.log("The value of funding denomination 1  fetched is-------->"+fundingDenom1Val,true);
            if(fundingDenomExcel.equalsIgnoreCase(fundingDenom1Val))
            {
                fundingDenomSuggestion1.get(i).click();
                financialInfoTitle.click();
                break;
            }
            else
            {
                Reporter.log("Not Matched the funding denomination 1 value",true);
            }

        }
    }

    public void clickOnInvestors1()throws InterruptedException
    {
        actions.moveToElement(fundingDenomination);
        actions.click();
        actions.build().perform();
    }

    public void setInvestors1(String investorsExcel)throws InterruptedException
    {

        actions.moveToElement(investorName);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(investorsExcel);
        actions.build().perform();
        for(int i=0;i<investorSuggestion.size();i++)
        {
            investorVal1=investorSuggestion.get(i).getText().toString();
            Reporter.log("The value of investor 1   fetched is-------->"+investorVal1,true);
            if(investorsExcel.equalsIgnoreCase(investorVal1))
            {
                investorSuggestion.get(i).click();
                financialInfoTitle.click();
                break;
            }
            else
            {
                Reporter.log("Not Matched the investor 1 value",true);
            }

        }
    }
//For Funding Round 2




    public void clickAddFundingRound2() throws InterruptedException
    {
        actions.moveToElement(addFundingRound2);
        actions.click();
        actions.build().perform();
    }

    public void clickOnFundingStage2()throws InterruptedException
    {
        actions.moveToElement(fundingStage2);
        actions.click();
        actions.build().perform();
    }

    public void setFundingStage2(String fundingStageExcel2)throws InterruptedException
    {

        actions.moveToElement(fundingText2);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(fundingStageExcel2);
        actions.build().perform();
        for(int i=0;i<fundingSuggestion2.size();i++)
        {
            fundingStage2Val=fundingSuggestion2.get(i).getText().toString();
            Reporter.log("The value of funding stage 2   fetched is-------->"+fundingStage2Val,true);
            if(fundingStageExcel2.equalsIgnoreCase(fundingStage2Val))
            {
                fundingSuggestion2.get(i).click();
                financialInfoTitle.click();
                break;
            }
            else
            {
                Reporter.log("Not Matched the funding stage 2 value",true);
            }

        }
    }
    public void setFundingAmount2(String fundAmountExcel2) throws InterruptedException
    {
        actions.moveToElement(fundingAmount2);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(fundAmountExcel2);
        actions.build().perform();

    }

    public void clickOnFundingDenom2()throws InterruptedException
    {
        actions.moveToElement(fundingDenomination2);
        actions.click();
        actions.build().perform();
    }

    public void setFundingDenom2(String fundingDenomExcel2)throws InterruptedException
    {

        actions.moveToElement(fundingDenomText2);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(fundingDenomExcel2);
        actions.build().perform();
        for(int i=0;i<fundingDenomSuggestion2.size();i++)
        {
            fundingDenom2Val=fundingDenomSuggestion2.get(i).getText().toString();
            Reporter.log("The value of funding denomination 2 fetched is-------->"+fundingDenom2Val,true);
            if(fundingDenomExcel2.equalsIgnoreCase(fundingDenom2Val))
            {
                fundingDenomSuggestion2.get(i).click();
                financialInfoTitle.click();
                break;
            }
            else
            {
                Reporter.log("Not Matched the funding denomination 2 value",true);
            }

        }
    }

    public void clickOnInvestors2()throws InterruptedException
    {
        actions.moveToElement(investor2);
        actions.click();
        actions.build().perform();
    }

    public void setInvestors2(String investorsExcel2)throws InterruptedException
    {

        actions.moveToElement(investorName2);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(investorsExcel2);
        actions.build().perform();
        for(int i=0;i<investorSuggestion2.size();i++)
        {
            investorVal2=investorSuggestion2.get(i).getText().toString();
            Reporter.log("The value of investor 2   fetched is-------->"+investorVal2,true);
            if(investorsExcel2.equalsIgnoreCase(investorVal2))
            {
                investorSuggestion2.get(i).click();
                financialInfoTitle.click();
                break;
            }
            else
            {
                Reporter.log("Not Matched the investor  2 value",true);
            }

        }
    }
    public void clickCancel() throws InterruptedException
    {
        actions.moveToElement(cancelBtn);
        actions.click();
        actions.build().perform();
    }


    public void clickSave() throws InterruptedException
    {
        actions.moveToElement(saveBtn);
        actions.click();
        actions.build().perform();
    }


    public  void checkResultTestTechnology()throws InterruptedException
    {
        try {
            revenuUpdateVal= revenueValid.getText().toString();
            System.out.println("validation value of revenue---->" + revenuUpdateVal);

            fundStageUpdateVal = fundingStageValid.getText().toString();
            System.out.println("validation value od funding stage  value---->" + fundStageUpdateVal);

            fundAmountUpdateVal=fundAmountValid.getText().toString();
            System.out.println("funding amount validation value------>"+fundAmountUpdateVal);

            fundRoundsUpdate=fundRoundValid.getText().toString();
            System.out.println("funding rounds validation value------>"+fundRoundsUpdate);

            lastFundUpdate=lastFundValid.getText().toString();
            System.out.println("last funding validation value------>"+lastFundUpdate);



            //if (countValueText.contains(searchedCountValueText) && searchedValueText.contains(advTechMatch)) {
                Reporter.log("****Test is passed from UI Consideration***",true);
           /* }
            else

            {
                Reporter.log("******Test is Failed from UI Consideration******",true);
            }
            Thread.sleep(3000);*/
        }
        catch(Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test result function ",true);
        }
    }



}
