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

public class ManagementPage extends StartUpMyProfilePage
{
    public ManagementPage(WebDriver driver, Connection conn, Statement stmt, ResultSet resultSet, Actions actions) {
        super(driver, conn, stmt, resultSet, actions);
    }

    public void callMyProfilefunc()throws InterruptedException
    {
        goToMyProfileLink();
    }
    public void callScrollByFunc()
    {
        scrollByUsingJSFunc();
    }
    public void clickAddExceutive() throws InterruptedException
    {
        clickOnAddExecutive();
    }

    @FindBy(xpath="//header[contains(text(),'Leadership Team')] ")
    private WebElement leadershipTitle;

    @FindBy(xpath="//input[@ng-model='management.name']")
    private  WebElement managementName;


    @FindBy(xpath="//input[@ng-model='management.designation']")
    private WebElement mangementDesignation;

    @FindBy(xpath="(//div[@class='value ng-binding'])[1]")
    private WebElement pastCompany;

    @FindBy(xpath="//input[@ng-model='searchFilter.pastCompaniesFilterText']")
    private WebElement pastCompanyText;

    @FindBy(xpath="//span[@ng-bind-html='past_company | highlight:searchFilter.pastCompaniesFilterText']/span[@class='highlight']")
    private List<WebElement> pastCompanySuggestion;

    @FindBy(xpath="(//div[@class='value ng-binding'])[2]")
    private  WebElement previousExpereince;

    @FindBy(xpath="//input[@ng-model='searchFilter.previousDesignationFilterText']")
    private  WebElement previousExpText;

    @FindBy(xpath="//span[@ng-bind-html='experience | highlight:searchFilter.previousDesignationFilterText']")
    private  List<WebElement> previousExpSuggestion;

    @FindBy(xpath="(//div[@class='value ng-binding'])[3]")
    private  WebElement university;

    @FindBy(xpath="//input[@ng-model='searchFilter.universityFilterText']")
    private  WebElement universityText;

    @FindBy(xpath="//span[@ng-bind-html='university.universityName | highlight:searchFilter.universityFilterText']")
    private  List<WebElement> universitySuggestion;

    @FindBy(xpath="(//div[@class='value ng-binding'])[4]")
    private  WebElement highestQualification;

    @FindBy(xpath="//input[@ng-model='searchFilter.educationFilterText']")
    private  WebElement highestQualificationText;

    @FindBy(xpath="//span[@ng-bind-html='education | highlight:searchFilter.educationFilterText']")
    private  List<WebElement> highestQualSuggestion;

    @FindBy(xpath="(//div[@class='value ng-binding'])[5]")
    private  WebElement totalExperience;

    @FindBy(xpath="//input[@ng-model='searchFilter.totalExperienceInYearsFilterText']")
    private  WebElement totalExpText;

    @FindBy(xpath="//span[@ng-bind-html='total_experience | highlight:searchFilter.totalExperienceInYearsFilterText']")
    private  List<WebElement> totalExpSuggestion;

    @FindBy(xpath="(//div[@class='value ng-binding'])[6]")
    private  WebElement noOfPatentsFiled;

    @FindBy(xpath="//input[@ng-model='searchFilter.noOfPatentsFiledFilterText']")
    private  WebElement noOfPatentsText;

    @FindBy(xpath="//span[@ng-bind-html='noOfPatents | highlight:searchFilter.noOfPatentsFiledFilterText']")
    private  List<WebElement> noOfPatentsSuggestion;

    @FindBy(xpath="//textarea[@ng-model='management.bioDataDescription']")
    private  WebElement bioDescription;

    @FindBy(xpath="//input[@ng-model='management.linkedinProfileUrl']")
    private WebElement linkedInUrl;

    @FindBy(xpath = "//input[@ng-model='management.twitterUrl']")
    private  WebElement twitterUrl;

    @FindBy(xpath="//span[@ng-click='revertManagement(); closeAllModals($event);']")
    private  WebElement cancelButton;

    @FindBy(xpath="//span[@ng-click='saveManagement();closeAllModals($event);']")
    private  WebElement saveButton;

    String pastCompanyVal;

    String previousExpVal;

    String  universityVal;

    String qualificationVal;

    String totalExpVal;

    String noOfPatentsVal;

    @FindBy(xpath="(//section[@ng-hide='filtered_management.length == 0']//h4)[1]")
    private WebElement managementName1;

    @FindBy(xpath="(//section[@ng-hide='filtered_management.length == 0']//p)[1]")
    private WebElement manageDesignationValid1;

    @FindBy(xpath="(//section[@ng-hide='filtered_management.length == 0']//a)[1]")
    private WebElement linkedInValid1;

    @FindBy(xpath="(//section[@ng-hide='filtered_management.length == 0']//a)[2]")
    private WebElement twitterValid1;

    @FindBy(xpath="(//section[@ng-hide='filtered_management.length == 0']//h4)[2]")
    private WebElement managementName2;

    @FindBy(xpath="(//section[@ng-hide='filtered_management.length == 0']//p)[2]")
    private WebElement manageDesignationValid2;

    @FindBy(xpath="(//section[@ng-hide='filtered_management.length == 0']//a)[3]")
    private WebElement linkedInValid2;

    @FindBy(xpath="(//section[@ng-hide='filtered_management.length == 0']//a)[4]")
    private WebElement twitterValid2;

    String mangementNameUpdateVal1=null;
    String managementNameUpdateVal2=null;
    String managementDesigUpdateVal1=null;
    String managementDesignUpdateVal2=null;
    String twitterUpdateVal1=null;
    String twitterUpdateVal2=null;
    String linkedInUpdateVal1=null;
    String linkedInUpdateVal2=null;


    public void setExecutiveName(String executiveNameExcel) throws InterruptedException
    {
        actions.moveToElement(managementName);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(executiveNameExcel);
        actions.build().perform();
    }

    public void setExecutiveDesignation(String executiveDesignationExcel) throws InterruptedException
    {
        actions.moveToElement(mangementDesignation);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(executiveDesignationExcel);
        actions.build().perform();
    }


    public void clickOnPastCompany()throws InterruptedException
    {

        actions.moveToElement(pastCompany);
        actions.click();
        actions.build().perform();

    }

    public void setPastCompany(String pastCompanyExcel)throws InterruptedException
    {

        actions.moveToElement(pastCompanyText);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(pastCompanyExcel);
        actions.build().perform();
        for(int i=0;i<pastCompanySuggestion.size();i++)
        {
            pastCompanyVal=pastCompanySuggestion.get(i).getText().toString();
            Reporter.log("The value of past company  fetched is-------->"+pastCompanyVal,true);
            if(pastCompanyVal.equalsIgnoreCase(pastCompanyExcel))
            {
                pastCompanySuggestion.get(i).click();
                leadershipTitle.click();
                break;
            }
            else
            {
                Reporter.log("Not Matched the past company value",true);
            }

        }
    }


    public void clickOnPreviousExp()throws InterruptedException
{

    actions.moveToElement(previousExpereince);
    actions.click();
    actions.build().perform();

}

    public void setPreviousExp(String previousExpExcel)throws InterruptedException
    {

        actions.moveToElement(previousExpText);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(previousExpExcel);
        actions.build().perform();
        for(int i=0;i<=previousExpSuggestion.size();i++)
        {
            previousExpVal=previousExpSuggestion.get(i).getText().toString();
            Reporter.log("The value of previous experience  fetched is-------->"+previousExpVal,true);
            if(previousExpExcel.equalsIgnoreCase(previousExpVal))
            {
                previousExpSuggestion.get(i).click();
                leadershipTitle.click();
                break;
            }
            else
            {
                Reporter.log("Not Matched the previous experience value",true);
            }

        }
    }



    public void clickOnUniversity()throws InterruptedException
    {

        actions.moveToElement(university);
        actions.click();
        actions.build().perform();

    }

    public void setUniversity(String universityExcel)throws InterruptedException
    {

        actions.moveToElement(universityText);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(universityExcel);
        actions.build().perform();
        for(int i=0;i<universitySuggestion.size();i++)
        {
            universityVal=universitySuggestion.get(i).getText().toString();
            Reporter.log("The value of university fetched is-------->"+universityVal,true);
            if(universityExcel.equalsIgnoreCase(universityVal))
            {
                universitySuggestion.get(i).click();
                leadershipTitle.click();
                break;
            }
            else
            {
                Reporter.log("Not Matched the university value",true);
            }

        }
    }

    public void clickOnHighQual()throws InterruptedException
    {

        actions.moveToElement(highestQualification);
        actions.click();
        actions.build().perform();

    }

    public void setHighQualification(String qualificationExcel)throws InterruptedException
    {

        actions.moveToElement(highestQualificationText);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(qualificationExcel);
        actions.build().perform();
        for(int i=0;i<highestQualSuggestion.size();i++)
        {
          qualificationVal=highestQualSuggestion.get(i).getText().toString();
            Reporter.log("The value of highest qualification  fetched is-------->"+qualificationVal,true);
            if(qualificationExcel.equalsIgnoreCase(qualificationVal))
            {
                highestQualSuggestion.get(i).click();
                leadershipTitle.click();
                break;
            }
            else
            {
                Reporter.log("Not Matched the highest qualification value",true);
            }

        }
    }

    public void clickOnTotalExp()throws InterruptedException
    {

        actions.moveToElement(totalExperience);
        actions.click();
        actions.build().perform();

    }

    public void setTotalExp(String totalExpExcel)throws InterruptedException
    {

        actions.moveToElement(totalExpText);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(totalExpExcel);
        actions.build().perform();
        for(int i=0;i<totalExpSuggestion.size();i++)
        {
            totalExpVal=totalExpSuggestion.get(i).getText().toString();
            Reporter.log("The value of total experience  fetched is-------->"+totalExpVal,true);
            if(totalExpExcel.equalsIgnoreCase(totalExpVal))
            {
                totalExpSuggestion.get(i).click();
                leadershipTitle.click();
                break;
            }
            else
            {
                Reporter.log("Not Matched the total experience value",true);
            }

        }
    }


    public void clickOnNoOfPatentsFiled()throws InterruptedException
    {

        actions.moveToElement(noOfPatentsFiled);
        actions.click();
        actions.build().perform();

    }

    public void setNoOfPatentsFiled(String noOfPatentsFiledExcel)throws InterruptedException
    {

        actions.moveToElement(noOfPatentsText);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(noOfPatentsFiledExcel);
        actions.build().perform();
        for(int i=0;i<noOfPatentsSuggestion.size();i++)
        {
            noOfPatentsVal=noOfPatentsSuggestion.get(i).getText().toString();
            Reporter.log("The value of patents fetched is-------->"+noOfPatentsVal,true);
            if(noOfPatentsFiledExcel.equalsIgnoreCase(noOfPatentsVal))
            {
                noOfPatentsSuggestion.get(i).click();
                leadershipTitle.click();
                break;
            }
            else
            {
                Reporter.log("Not Matched the patents value",true);
            }

        }
    }


    public void setBioDescription(String bioDescriptionExcel) throws InterruptedException
    {
        actions.moveToElement(bioDescription);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(bioDescriptionExcel);
        actions.build().perform();
    }

    public void setLinkedInUrl(String linkedInURLExcel) throws InterruptedException
    {
        actions.moveToElement(linkedInUrl);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(linkedInURLExcel);
        actions.build().perform();
    }

    public void setTwitterUrl(String twitterUrlExcel) throws InterruptedException
    {
        actions.moveToElement(twitterUrl);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(twitterUrlExcel);
        actions.build().perform();
    }

    public void clickCancel() throws InterruptedException
    {
        actions.moveToElement(cancelButton);
        actions.click();
        actions.build().perform();
    }


    public void clickSave() throws InterruptedException
    {
        actions.moveToElement(saveButton);
        actions.click();
        actions.build().perform();
    }

    public  void checkResultTestManagement()throws InterruptedException
    {
        try {
            mangementNameUpdateVal1 = managementName1.getText().toString();
            System.out.println("management validation  value 1---->" + mangementNameUpdateVal1);
            managementNameUpdateVal2=managementName2.getText().toString();
            System.out.println("management validation value 2----->"+managementNameUpdateVal2);
            managementDesigUpdateVal1=manageDesignationValid1.getText().toString();
            System.out.println("management designation validation value 1------>"+managementDesigUpdateVal1);
            managementNameUpdateVal2=manageDesignationValid2.getText().toString();
            System.out.println("management designation validation value 2------>"+managementDesignUpdateVal2);
            twitterUpdateVal1=twitterValid1.getText().toString();
            System.out.println("twitter validation value 1----->"+twitterUpdateVal1);
            twitterUpdateVal2=twitterValid2.getText().toString();
            System.out.println("twitter validation value 2------->"+twitterUpdateVal2);
            linkedInUpdateVal1=linkedInValid1.getText().toString();
            System.out.println("linked in valdation value 1---->"+linkedInUpdateVal1);
            linkedInUpdateVal2=linkedInValid2.getText().toString();
            System.out.println("lnked in validation value 2---->"+linkedInUpdateVal2);

            if (mangementNameUpdateVal1.contains(managementName.getText()) || managementNameUpdateVal2.contains(managementName.getText())&&managementDesigUpdateVal1.contains(mangementDesignation.getText())||managementDesignUpdateVal2.contains(mangementDesignation.getText())&& twitterUpdateVal1.contains(twitterUrl.getText())||twitterUpdateVal2.contains(twitterUrl.getText())&&linkedInUpdateVal1.contains(linkedInUrl.getText())|| linkedInUpdateVal2.contains(linkedInUrl.getText())) {
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
}
