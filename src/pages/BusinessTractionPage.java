package pages;

import generics.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class BusinessTractionPage extends StartUpMyProfilePage
{

    public BusinessTractionPage(WebDriver driver, Connection conn, Statement stmt, ResultSet resultSet, Actions actions) {
        super(driver, conn, stmt, resultSet,actions);
    }

    public void callMyProfilefunc()throws InterruptedException
    {
        goToMyProfileLink();
    }
    public void callScrollByFunc()
    {

        scrollByUsingJSFunc();
    }
    public void callAddBussTract() throws  InterruptedException
    {
        clickOnAddBusinessTraction();
    }


    @FindBy(xpath="//header[contains(text(),'Business Traction ')]")
    private WebElement businessTractionHeader;

    @FindBy(xpath = "(//div[@class='value ng-binding'])[1]")
    private WebElement stratUpTypeLabel;

    @FindBy(xpath="//input[@ng-model='searchFilter.startupTypeFilterText']")
    private  WebElement startUpTypeText;


    @FindBy(xpath="//span[@ng-bind-html='startupType.name | highlight:searchFilter.startupTypeFilterText']")
    private List<WebElement> startUpTypeSuggestion;

    @FindBy(xpath = "(//div[@class='value ng-binding'])[2]")
    private WebElement productTypeLabel;

    @FindBy(xpath="//input[@ng-model='searchFilter.productTypeFilterText']")
    private  WebElement productTypeText;


    @FindBy(xpath="//span[@ng-bind-html='productType.name | highlight:searchFilter.productTypeFilterText']")
    private List<WebElement> productTypeSuggestion;



    @FindBy(xpath="//div[@class='option' and  contains(text(),'B2C')]")
    private WebElement businessTypeB2C;

    @FindBy(xpath="//div[@class='option' and  contains(text(),'B2B')]")
    private WebElement businessTypeB2B;

    @FindBy(xpath="//div[@class='option' and  contains(text(),'Both')]")
    private WebElement businessTypeBOTH;
    @FindBy(xpath="(//div[@class='value ng-binding'])[3]")
    private WebElement custB2B;

    @FindBy(xpath=" //input[@ng-model='searchFilter.b2bCustomersFilterText']")
    private  WebElement custB2BText;

    @FindBy(xpath="//span[@ng-bind-html='customersOption | highlight:searchFilter.b2bCustomersFilterText']")
    private List<WebElement> custB2BSuggestion;


    @FindBy(xpath="(//div[@class='value ng-binding'])[4]")
    private WebElement noOfCust;

    @FindBy(xpath=" //input[@ng-model='searchFilter.noOfCustomersFilterText']")
    private  WebElement noOfCustText;

    @FindBy(xpath="//span[@ng-bind-html='noOfCustomersOption | highlight:searchFilter.noOfCustomersFilterText']")
    private List<WebElement> noOfCustSuggestion;

    @FindBy(xpath="(//div[@class='value ng-binding'])[5]")
    private WebElement endUsers;

    @FindBy(xpath=" //input[@ng-model='searchFilter.b2cEndUsersFilterText']")
    private  WebElement endUsersText;

    @FindBy(xpath="//span[@ng-bind-html='endUsersOption | highlight:searchFilter.b2cEndUsersFilterText']")
    private List<WebElement> endUsersSuggestion;


    @FindBy(xpath="(//div[@class='value ng-binding'])[6]")
    private WebElement noOfUsers;

    @FindBy(xpath=" //input[@ng-model='searchFilter.noOfEndUsersFilterText']")
    private  WebElement noOfUsersText;

    @FindBy(xpath="//span[@ng-bind-html='noOfEndUsersOption | highlight:searchFilter.noOfEndUsersFilterText']")
    private List<WebElement> noOfUsersSuggestion;



    @FindBy(xpath="//div[@ng-repeat='reveModl in revenueModel' and contains(text(),'Subscription')]")
    private WebElement revenueModelSubscription;

    @FindBy(xpath="//div[@ng-repeat='reveModl in revenueModel' and contains(text(),'Commission')]")
    private WebElement revenueModelCommission;

    @FindBy(xpath="//div[@ng-repeat='reveModl in revenueModel' and contains(text(),'Online Sales')]")
    private WebElement revenueModelOnlineSales;

    @FindBy(xpath="//div[@ng-repeat='reveModl in revenueModel' and contains(text(),'Direct Sales')]")
    private WebElement revenueModelDirectSales;

    @FindBy(xpath="//div[@ng-repeat='reveModl in revenueModel' and contains(text(),'Affiliation')]")
    private WebElement revenueModelAffiliation;

    @FindBy(xpath="//div[@ng-repeat='reveModl in revenueModel' and contains(text(),'Advertising')]")
    private WebElement revenueModelAdvertising;

    @FindBy(xpath="//div[@ng-repeat='reveModl in revenueModel' and contains(text(),'Not for Profit')]")
    private WebElement revenueModelNotForProfit;

    @FindBy(xpath="//div[@ng-repeat='reveModl in revenueModel' and contains(text(),'Performance Based')]")
    private WebElement revenueModelPerformanceBased;

    @FindBy(xpath="//div[@ng-repeat='reveModl in revenueModel' and contains(text(),'Pay Per Use')]")
    private WebElement revenueModelPayPerUse;

    @FindBy(xpath="//div[@ng-repeat='reveModl in revenueModel' and contains(text(),'Auction')]")
    private WebElement revenueModelAuction;

    @FindBy(xpath="//div[@ng-repeat='reveModl in revenueModel' and contains(text(),'Software Licensing')]")
    private WebElement revenueModelSoftwareLicensing;

    @FindBy(xpath="//div[@ng-repeat='reveModl in revenueModel' and contains(text(),'Other')]")
    private WebElement revenueModelOther;


    @FindBy(xpath=" //input[@placeholder='Enter Revenue Model value']")
    private WebElement revenueModelText;



    @FindBy(xpath="//div[@ng-repeat='compDiff in competitiveDifferentiations' and contains(text(),'Leadership')]")
    private WebElement competitiveDiffLeadership;

    @FindBy(xpath="//div[@ng-repeat='compDiff in competitiveDifferentiations' and contains(text(),'Innovation capability')]")
    private WebElement competitiveDiffInnovationCapability;

    @FindBy(xpath="//div[@ng-repeat='compDiff in competitiveDifferentiations' and contains(text(),'Product')]")
    private WebElement competitiveDiffProduct;

    @FindBy(xpath="//div[@ng-repeat='compDiff in competitiveDifferentiations' and contains(text(),'Sales Competence')]")
    private WebElement competitiveDiffSalesCompetence;

    @FindBy(xpath="//div[@ng-repeat='compDiff in competitiveDifferentiations' and contains(text(),'Geographic reach')]")
    private WebElement competitiveDiffGeographicReach;

    @FindBy(xpath="//div[@ng-repeat='compDiff in competitiveDifferentiations' and contains(text(),'Pricing/Licencing Model')]")
    private WebElement competitiveDiffPricingLicencingModel;

    @FindBy(xpath="//div[@ng-repeat='compDiff in competitiveDifferentiations' and contains(text(),'Market Entry Timing')]")
    private WebElement competitiveDiffMarketEntryTiming;

    @FindBy(xpath="//div[@ng-repeat='compDiff in competitiveDifferentiations' and contains(text(),'Other')]")
    private WebElement competitiveDiffOther;


    @FindBy(xpath=" //input[@placeholder='Enter Competitive Differentiation value']")
    private WebElement competDiffText;

    @FindBy(xpath="//span[@ng-click='revertBusiness(); closeAllModals($event);']")
    private  WebElement cancelButton;

    @FindBy(xpath="//span[@ng-click='save(companyProfileDto);closeAllModals($event);']")
    private WebElement saveButton;

    @FindBy(xpath = "//i[@class='fa fa-2x fa-close close']")
    private WebElement close;

    String startUpTypeVal;

    String productTypeVal;

    String custB2BVal;

    String noOfCustVal;

    String endUsersVal;

    String noOfEndUsersVal;

    @FindBy(xpath="//section[@class='profile-section business-section']//div[@ng-show='companyProfileDto.startupType']//section[@class='value ng-binding']")
    private WebElement startUpTypeValid;

    @FindBy(xpath="//section[@class='profile-section business-section']//div[@ng-show='companyProfileDto.productType']//section[@class='value ng-binding']")
    private WebElement productTypeValid;

    @FindBy(xpath="//section[@class='profile-section business-section']//div[@ng-show='companyProfileDto.businessType']//section[@class='value ng-binding']")
    private WebElement businessTypeValid;

    @FindBy(xpath="(//section[@class='value ng-binding'])[7]")
    private  WebElement customersValid;

    @FindBy(xpath="(//section[@class='value ng-binding'])[8]")
    private WebElement noOfCustomersValid;

    @FindBy(xpath="(//section[@class='value ng-binding'])[9]")
    private WebElement endUsersValid;

    @FindBy(xpath = "(//section[@class='value ng-binding'])[9]")
    private WebElement noOfEndUsersValid;

    @FindBy(xpath="//div[@ng-show='revenueModelString']//section[@class='value ng-binding'")
    private WebElement revenueValid;

    @FindBy(xpath="//div[@ng-show='competitiveDifferentiationString']//section[@class='value ng-binding']")
    private WebElement compDiffValid;


    String startUpTypeUpdate=null;
    String productTypeUpdateVal=null;
    String businessTypeUpdateVal=null;
    String customersUpdateVal=null;
    String noOfCustomersUpdateVal=null;
    String endUsersUpdateVal=null;
    String noOfEndUsersUpdateVal=null;
    String revenueUpdateVal=null;
    String compDiffUpdateVal=null;

    public void clickOnStartUpType()throws InterruptedException
    {

        actions.moveToElement(stratUpTypeLabel);
        actions.click();
        actions.build().perform();

    }

    public void setStartUpType(String startTypeExcel)throws InterruptedException
    {

        actions.moveToElement(startUpTypeText);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(startTypeExcel);
        actions.build().perform();
        for(int i=0;i<startUpTypeSuggestion.size();i++)
        {
            startUpTypeVal=startUpTypeSuggestion.get(i).getText().toString();
            Reporter.log("The value of start type  fetched is-------->"+startUpTypeVal,true);
            if(startUpTypeVal.equalsIgnoreCase(startTypeExcel))
            {
                startUpTypeSuggestion.get(i).click();
                businessTractionHeader.click();
                break;
            }
            else
            {
                Reporter.log("Not Matched the start up type value",true);
            }

        }
    }

    public void clickOnProductType()throws InterruptedException
    {

        actions.moveToElement(productTypeLabel);
        actions.click();
        actions.build().perform();

    }

    public void setProductType(String productTypeExcel)throws InterruptedException
    {

        actions.moveToElement(productTypeText);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(productTypeExcel);
        actions.build().perform();
        for(int i=0;i<productTypeSuggestion.size();i++)
        {
            productTypeVal=productTypeSuggestion.get(i).getText().toString();
            Reporter.log("The value of product type  fetched is-------->"+productTypeVal,true);
            if(productTypeVal.equalsIgnoreCase(productTypeExcel))
            {
                productTypeSuggestion.get(i).click();
                businessTractionHeader.click();
                break;
            }
            else
            {
                Reporter.log("Not Matched the product type value",true);
            }

        }
    }
    public void clickOnBusinessTypeB2C()throws InterruptedException
    {

        actions.moveToElement(businessTypeB2C);
        actions.click();
        actions.build().perform();

    }
    public void clickOnBusinessTypeB2B()throws InterruptedException
    {

        actions.moveToElement(businessTypeB2B);
        actions.click();
        actions.build().perform();

    }

    public void clickOnBusinessTypeBoth()throws InterruptedException
    {

        actions.moveToElement(businessTypeBOTH);
        actions.click();
        actions.build().perform();

    }

    public void clickOnCustomersB2B()throws InterruptedException
    {

        actions.moveToElement(custB2B);
        actions.click();
        actions.build().perform();

    }

    public void setCustomerB2B(String custB2BExcel)throws InterruptedException
    {

        actions.moveToElement(custB2BText);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(custB2BExcel);
        actions.build().perform();
        for(int i=0;i<custB2BSuggestion.size();i++)
        {
            custB2BVal=custB2BSuggestion.get(i).getText().toString();
            Reporter.log("The value of customer B2B fetched is-------->"+custB2BVal,true);
            if(custB2BVal.equalsIgnoreCase(custB2BExcel))
            {
                custB2BSuggestion.get(i).click();
                businessTractionHeader.click();
                break;
            }
            else
            {
                Reporter.log("Not Matched the customer B2B  value",true);
            }

        }
    }


    public void clickOnNoOfCustomers()throws InterruptedException
    {

        actions.moveToElement(noOfCust);
        actions.click();
        actions.build().perform();

    }

    public void setNoOfCustomers(String noOfCustExcel)throws InterruptedException
    {

        actions.moveToElement(noOfCustText);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(noOfCustExcel);
        actions.build().perform();
        for(int i=0;i<noOfCustSuggestion.size();i++)
        {
            noOfCustVal=noOfCustSuggestion.get(i).getText().toString();
            Reporter.log("The value of no of customer fetched is-------->"+noOfCustVal,true);
            if(noOfCustExcel.equalsIgnoreCase(noOfCustVal))
            {
                noOfCustSuggestion.get(i).click();
                businessTractionHeader.click();
                break;
            }
            else
            {
                Reporter.log("Not Matched the no of customer value",true);
            }

        }
    }


    public void clickOnEndUsers()throws InterruptedException
    {

        actions.moveToElement(endUsers);
        actions.click();
        actions.build().perform();

    }

    public void setEndUser(String endUsersExcel)throws InterruptedException
    {

        actions.moveToElement(endUsersText);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(endUsersExcel);
        actions.build().perform();
        for(int i=0;i<endUsersSuggestion.size();i++)
        {
            endUsersVal=endUsersSuggestion.get(i).getText().toString();
            Reporter.log("The value of end users fetched is-------->"+endUsersVal,true);
            if(endUsersExcel.equalsIgnoreCase(endUsersVal))
            {
                endUsersSuggestion.get(i).click();
                businessTractionHeader.click();
                break;
            }
            else
            {
                Reporter.log("Not Matched the end users value",true);
            }

        }
    }


    public void clickOnNoOfEndUsers()throws InterruptedException
    {

        actions.moveToElement(noOfUsers);
        actions.click();
        actions.build().perform();

    }

    public void setNoOfEndUser(String noOfEndUsersExcel)throws InterruptedException
    {

        actions.moveToElement(noOfUsersText);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(noOfEndUsersExcel);
        actions.build().perform();
        for(int i=0;i<noOfUsersSuggestion.size();i++)
        {
            noOfEndUsersVal=noOfUsersSuggestion.get(i).getText().toString();
            Reporter.log("The value of no of end users fetched is-------->"+noOfEndUsersVal,true);
            if(noOfEndUsersExcel.equalsIgnoreCase(noOfEndUsersVal))
            {
                noOfUsersSuggestion.get(i).click();
                businessTractionHeader.click();
                break;
            }
            else
            {
                Reporter.log("Not Matched the no of end users value",true);
            }

        }
    }

    public void clickOnSubscription()throws InterruptedException
    {

        actions.moveToElement(revenueModelSubscription);
        actions.click();
        actions.build().perform();

    }

    public void clickOnCommission()throws InterruptedException
    {

        actions.moveToElement(revenueModelCommission);
        actions.click();
        actions.build().perform();

    }

    public void clickOnAdvertising()throws InterruptedException
    {

        actions.moveToElement(revenueModelAdvertising);
        actions.click();
        actions.build().perform();

    }
    public void clickOnOtherRevenueModel()throws InterruptedException
    {

        actions.moveToElement(revenueModelOther);
        actions.click();
        actions.build().perform();

    }
    public void setOtherRevenueModel(String otherRevenueModelExcel) throws InterruptedException
    {
        actions.moveToElement(revenueModelText);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(otherRevenueModelExcel);
        actions.build().perform();
    }

       public void clickLeadership()throws InterruptedException
    {
        actions.moveToElement(competitiveDiffLeadership);
        actions.click();
        actions.build().perform();
    }
    public void clickInnovationCapability()throws InterruptedException
    {
        actions.moveToElement(competitiveDiffInnovationCapability);
        actions.click();
        actions.build().perform();
    }

    public void clickOnOtherDiffCompet()throws InterruptedException
    {

        actions.moveToElement(competitiveDiffOther);
        actions.click();
        actions.build().perform();

    }

    public void setOtherDiffCompet(String otherDiffCompetExcel) throws InterruptedException
    {
        actions.moveToElement(competDiffText);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(otherDiffCompetExcel);
        actions.build().perform();
    }

    public void clickCancel()
    {
        actions.moveToElement(cancelButton);
        actions.click();
        actions.build().perform();


    }
    public void clickSave()
    {
        actions.moveToElement(saveButton);
        actions.click();
        actions.build().perform();


    }

    public void clickClose()
    {
        actions.moveToElement(close);
        actions.click();
        actions.build().perform();
    }

    public  void checkResultBusinessTract()throws InterruptedException
    {
        try {

                startUpTypeUpdate = startUpTypeValid.getText().toString();
            System.out.println("start type validation value---->" + startUpTypeUpdate);
            productTypeUpdateVal=productTypeValid.getText().toString();
            System.out.println("product type  validation value---->"+productTypeUpdateVal);
            businessTypeUpdateVal=businessTypeValid.getText().toString();
            System.out.println("business type validation value------>"+businessTypeUpdateVal);
            customersUpdateVal=customersValid.getText().toString();
            System.out.println("customers validation value------>"+customersUpdateVal);
            noOfCustomersUpdateVal=noOfCustomersValid.getText().toString();
            System.out.println("no of customers validation value------>"+noOfCustomersUpdateVal);
            endUsersUpdateVal=endUsersValid.getText().toString();
            System.out.println("end users validation value----->"+endUsersUpdateVal);
            noOfEndUsersUpdateVal=noOfEndUsersValid.getText().toString();
            System.out.println("no of end users validation value---------->"+noOfEndUsersUpdateVal);
            revenueUpdateVal=revenueValid.getText().toString();
            System.out.println("revenue validation value----->"+revenueUpdateVal);
            compDiffUpdateVal=compDiffValid.getText().toString();
            System.out.println("comp diff validation value------>"+compDiffUpdateVal);


            if (startUpTypeUpdate.contains(startUpTypeVal)&&productTypeUpdateVal.contains(productTypeVal)&&businessTypeUpdateVal.contains(businessTypeB2B.getText()) || businessTypeUpdateVal.contains(businessTypeB2C.getText()) ||businessTypeUpdateVal.contains(businessTypeBOTH.getText()) && customersUpdateVal.contains(custB2BVal) && noOfCustomersUpdateVal.contains(noOfCustVal)&& endUsersUpdateVal.contains(endUsersVal)&&noOfEndUsersUpdateVal.contains(noOfEndUsersVal)&&revenueUpdateVal.contains(revenueModelAdvertising.getText())|| revenueUpdateVal.contains(revenueModelAffiliation.getText())||revenueUpdateVal.contains(revenueModelAuction.getText())||revenueUpdateVal.contains(revenueModelCommission.getText())||revenueUpdateVal.contains(revenueModelDirectSales.getText())||revenueUpdateVal.contains(revenueModelNotForProfit.getText())||revenueUpdateVal.contains(revenueModelOnlineSales.getText())||revenueUpdateVal.contains(revenueModelPayPerUse.getText())||revenueUpdateVal.contains(revenueModelOther.getText())&&compDiffUpdateVal.contains(competitiveDiffGeographicReach.getText())||compDiffUpdateVal.contains(competitiveDiffInnovationCapability.getText())||compDiffUpdateVal.contains(competitiveDiffLeadership.getText())||compDiffUpdateVal.contains(competitiveDiffMarketEntryTiming.getText())||compDiffUpdateVal.contains(competitiveDiffPricingLicencingModel.getText())||compDiffUpdateVal.contains(competitiveDiffProduct.getText())||compDiffUpdateVal.contains(competitiveDiffSalesCompetence.getText())||compDiffUpdateVal.contains(competDiffText.getText())) {
                Reporter.log("**** Business Traction Test is passed from UI Consideration***",true);
            }
            else

            {
                Reporter.log("******Business Traction Test is Failed from UI Consideration******",true);
            }
            Thread.sleep(3000);
        }
        catch(Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in Business Traction test result function ",true);
        }
    }
}
