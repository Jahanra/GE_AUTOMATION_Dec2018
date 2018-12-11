package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ContactUsPage extends HomePage

{


    public ContactUsPage(WebDriver driver, Connection conn, Statement stmt, ResultSet resultSet, Actions actions) {
        super(driver, conn, stmt, resultSet, actions);
    }

    @FindBy(xpath="//input[@ng-model='vm.contactUsDetails.subject']")
    private WebElement subject;

    @FindBy(xpath="//div[@class='input-checkboxes-field']/label[contains(text(),'Request for Demo')]")
    private  WebElement requestForDemoOption;

    public void setSubjectRequestForDemo()
    {
      actions.moveToElement(subject);
      actions.click();
      actions.moveToElement(requestForDemoOption);
      actions.click();
      actions.build().perform();
    }

    @FindBy(xpath="//div[@class='input-checkboxes-field']/label[contains(text(),'Sales Query')]")
    private  WebElement salesQueryOption;

    public void setSubjectSalesQuery()
    {
        actions.moveToElement(subject);
        actions.click();
        actions.moveToElement(salesQueryOption);
        actions.click();
        actions.build().perform();

    }


    @FindBy(xpath="//input[@ng-model='vm.contactUsDetails.visitorName']")
    private WebElement name;

    public void setName(String nameExcel)
    {
        actions.moveToElement(name);
        actions.sendKeys(nameExcel);
        actions.build().perform();

    }

    @FindBy(xpath="//input[@ng-model='vm.contactUsDetails.designation']")
    private  WebElement designation;


    public void setDesignation(String designationExcel)
    {
        actions.moveToElement(designation);
        actions.sendKeys(designationExcel);
        actions.build().perform();

    }

    @FindBy(xpath="//input[@ng-model='vm.contactUsDetails.company']")
    private WebElement company;

    public void setCompany(String companyExcel)
    {
        actions.moveToElement(company);
        actions.sendKeys(companyExcel);
        actions.build().perform();

    }

    @FindBy(xpath="//input[@ng-model='vm.contactUsDetails.visitorEmail']")
    private WebElement emailId;

    public void setEmailId(String emailIdExcel)
    {
        actions.moveToElement(emailId);
        actions.sendKeys(emailIdExcel);
        actions.build().perform();

    }

    @FindBy(xpath="//textarea[@ng-model='vm.contactUsDetails.message']")
    private  WebElement comment;

    public void setComment(String commentExcel)
    {
        actions.moveToElement(comment);
        actions.sendKeys(commentExcel);
        actions.build().perform();

    }

    @FindBy(xpath="//button[@ng-click='return vm.validateContactEmail()']")
    private WebElement submitButton;


    public void clickSubmitButton()
    {
        actions.moveToElement(submitButton);
        actions.click();
        actions.build().perform();
    }

    @FindBy(xpath="//a[@href='mailto:info@growthenabler.com']")
    private  WebElement emailTo;

    public void clickEmailTo()
    {
        actions.moveToElement(emailTo);
        actions.click();
        actions.build().perform();
    }


    @FindBy(xpath="(//a[@href='https://twitter.com/GrowthEnabler'])[1]")
    private WebElement twitter;


    public void clickTwitter()
    {
        actions.moveToElement(twitter);
        actions.click();
        actions.build().perform();
    }


}
