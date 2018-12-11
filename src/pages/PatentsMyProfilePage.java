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

public class PatentsMyProfilePage extends  StartUpMyProfilePage {
    public PatentsMyProfilePage(WebDriver driver, Connection conn, Statement stmt, ResultSet resultSet, Actions actions) {
        super(driver, conn, stmt, resultSet, actions);
    }

    public void callMyProfileFunc() throws InterruptedException {
        goToMyProfileLink();
    }

    public void callScrollByFunc() {
        scrollByUsingJS2();
    }

    public void callClickAddPatent() throws InterruptedException {
        clickOnAddPatent();
    }

    @FindBy(xpath="//header[contains(text(),'Patents ')] ")
    private WebElement patentTitle;

    @FindBy(xpath="//input[@ng-model='patent.documentTitle']")
    private WebElement patentName;

    @FindBy(xpath="(//div[@class='value'])[1]")
    private  WebElement patentStatus;

    @FindBy(xpath = "//input[@ng-model='searchFilter.appliedOrGrantedFilterText']")
    private WebElement patentStatusText;

    @FindBy(xpath = "//span[@ng-bind-html='appliedOrGranted.name | highlight:searchFilter.appliedOrGrantedFilterText']")
    private List<WebElement> patentSuggestion;

    @FindBy(xpath="//textarea[@ng-model='patent.description']")
    private WebElement patentDescription;

    @FindBy(xpath="//span[@ng-click='revertPatent(); closeAllModals($event);']")
    private  WebElement cancelBtn;

    @FindBy(xpath = "//span[@ng-click='savePatent();closeAllModals($event);']")
    private  WebElement saveBtn;

    @FindBy(xpath="//i[@ng-click='revertPatent(); closeAllModals($event);']")
    private  WebElement close;

    @FindBy(xpath = "(//section[@ng-hide='companyProfileDto.companyPatentsDTOs.length == 0']//section[@class='value ng-binding'])[1]")
    private WebElement patentCountValid;


    @FindBy(xpath="(//section[@ng-hide='companyProfileDto.companyPatentsDTOs.length == 0']//section[@class='value ng-binding'])[3]")
    private WebElement patentNameValid1;

    @FindBy(xpath="(//section[@ng-hide='companyProfileDto.companyPatentsDTOs.length == 0']//section[@class='value ng-binding'])[4]")
    private  WebElement patentStatusValid1;

    @FindBy(xpath = "(//section[@ng-hide='companyProfileDto.companyPatentsDTOs.length == 0']//p)[1]")
    private WebElement patentDescValid1;

    @FindBy(xpath="(//section[@ng-hide='companyProfileDto.companyPatentsDTOs.length == 0']//section[@class='value ng-binding'])[5]")
    private WebElement patentNameValid2;

    @FindBy(xpath ="(//section[@ng-hide='companyProfileDto.companyPatentsDTOs.length == 0']//section[@class='value ng-binding'])[6]")
    private WebElement patentStatusValid2;

    @FindBy(xpath = "(//section[@ng-hide='companyProfileDto.companyPatentsDTOs.length == 0']//p)[2]")
    private WebElement patentDescValid2;


    String patentStatusVal=null;
    String patentMatch=null;
    String descMatch=null;

    String patUpdateVal1=null;
    String patUpdateVal2=null;
    String patTypeUpdateVal1=null;
    String patTypeUpdateVal2=null;
    String patDescUpdateVal1=null;
    String patDescUpdateVal2=null;


    public void setPatentName(String patentNameExcel) throws InterruptedException
    {
        actions.moveToElement(patentName);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(patentNameExcel);
        patentMatch=patentNameExcel;
        actions.build().perform();
    }


    public void clickOnPatentStatus()throws InterruptedException
    {
        actions.moveToElement(patentStatus);
        actions.click();
        actions.build().perform();
    }

    public void setPatentStatus(String patentStatusExcel)throws InterruptedException
    {

        actions.moveToElement(patentStatusText);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(patentStatusExcel);
        actions.build().perform();
        for(int i=0;i<patentSuggestion.size();i++)
        {
            patentStatusVal=patentSuggestion.get(i).getText().toString();
            Reporter.log("The value of patent status  fetched is-------->"+patentStatusVal,true);
            if(patentStatusExcel.equalsIgnoreCase(patentStatusVal))
            {
                patentSuggestion.get(i).click();
                patentTitle.click();
                break;
            }
            else
            {
                Reporter.log("Not Matched the patent  status value",true);
            }

        }
    }

    public void setPatentDesc(String patentDescExcel) throws InterruptedException
    {
        actions.moveToElement(patentDescription);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(patentDescExcel);
        descMatch=patentDescExcel;
        actions.build().perform();

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

    public void checkPatents()
    {
        try {
            patUpdateVal1 = patentNameValid1.getText().toString();
            Reporter.log("The value 1 after Update of patent name---------->" + patUpdateVal1, true);
            patUpdateVal2 = patentNameValid2.getText().toString();
            Reporter.log("The value 2 after Update of patent name--------->" + patUpdateVal2, true);
            patTypeUpdateVal1 = patentStatusValid1.getText().toString();
            Reporter.log("The value 1 after update of patent status------->" + patTypeUpdateVal1, true);
            patTypeUpdateVal2 = patentStatusValid2.getText().toString();
            Reporter.log("The value 2 after update of patent status------->" + patTypeUpdateVal2, true);
            patDescUpdateVal1 = patentDescValid1.getText().toString();
            Reporter.log("The value 1 after update of patent Desc------->" + patDescUpdateVal1, true);
            patDescUpdateVal2 = patentDescValid2.getText().toString();
            Reporter.log("The value 2 after update of patent Desc------->" + patDescUpdateVal2, true);
            if(patUpdateVal1.contains(patentMatch)||patUpdateVal2.contains(patentMatch)
               && patTypeUpdateVal1.contains(patentStatusVal)||patTypeUpdateVal2.contains(patentStatusVal)
                    && patDescUpdateVal1.contains(descMatch)||patDescUpdateVal2.contains(descMatch))
            {
                Reporter.log("Passed UI patents Matched",true);
            }
            else
            {
                Reporter.log("Failed UI Patents Doest Matched",true);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
            Reporter.log("Exception in validating the patents data in UI"+getClass(),true);
        }
    }

}
