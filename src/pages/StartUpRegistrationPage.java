package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class StartUpRegistrationPage extends HomePage
{

    public StartUpRegistrationPage(WebDriver driver, Connection conn, Statement stmt, ResultSet resultSet, Actions actions) {
        super(driver, conn, stmt, resultSet, actions);
    }

    @FindBy(css="div[ng-click='stc.register();']")
    private WebElement registerForFree1;

    @FindBy(id="company-input")
    private  WebElement companyNameText;


    @FindBy(css="input[ng-model='vm.registerAccount.domainName']")
    private WebElement domainNameText;

    @FindBy(css="input[ng-model='vm.registerAccount.email']")
    private WebElement businessEmailText;

    @FindBy(css="input[ng-model='vm.registerAccount.firstName']")
    private  WebElement name;

    @FindBy(id="password")
    private WebElement passwordText;

    @FindBy(css="input[ng-model='vm.registerAccount.IAgree']")
    private  WebElement agreeTerms;


    @FindBy(id="signup-btn")
    private WebElement signUpButton;

    @FindBy(css="button[ng-click='vm.cancel()']")
    private WebElement cancelButton;

    @FindBy(xpath="//div[@ng-click='stc.register();' and contains(text(),'Register for free')]")
    private WebElement registerForFree;

    @FindBy(xpath="(//div[@class='register-cta'])[2]")
    private  WebElement registerNow1;

    @FindBy(xpath = "(//div[@class='register-cta'])[3]")
    private WebElement registerNow2;

    @FindBy(xpath="(//div[@class='register-cta'])[4]")
    private WebElement registerNow3;


    @FindBy(css="div[class='register-form-holder']")
    private  WebElement registerModal;

    @FindBy(css="div[class='option row ng-scope']")
    private WebElement autosuggestionCompany;

    @FindBy(css="div[class='register-form-holder']")
    private  WebElement registerModalForFree;


    @FindBy(css="div[id='upfold']")
    private WebElement divStartUp;

    @FindBy(css="div[class='prompt']")
    private WebElement divStartUp2;

    @FindBy(css="div[class='final-prompt']")
    private WebElement divStartUp3;

    public void clickOnRegisterFree1()
    {
        actions.moveToElement(divStartUp);
        actions.build().perform();
        actions.moveToElement(registerForFree);
        System.out.println("Register for free displayed---->"+registerForFree.isDisplayed());
        actions.click();
        actions.build().perform();
    }

     public void moveToRegisterModal()
     {
         actions.moveToElement(registerModalForFree);

         actions.build().perform();
     }

    public void setCompanyName(String companyNameExcel)
    {
        actions.moveToElement(companyNameText);
        actions.click();
        actions.sendKeys(companyNameExcel);
        actions.build().perform();
    }

    public void selectCompanyAuto(String companyNameExcel)
    {
        actions.moveToElement(companyNameText);
        actions.click();
        actions.sendKeys(companyNameExcel);
        actions.moveToElement(autosuggestionCompany);
        actions.click();
        actions.build().perform();
    }
    public void setDomainName(String domainExcel)
    {
        if(domainNameText.getText().isEmpty())
        {
            actions.moveToElement(domainNameText);
            actions.click();
            actions.sendKeys(domainExcel);
            actions.build().perform();
        }

    }


  public void setBusinessMail(String businessMailExcel)
  {
      actions.moveToElement(businessEmailText);
      actions.click();
      actions.sendKeys(businessMailExcel);
      actions.build().perform();
  }
    public void setName(String nameExcel)
    {
        actions.moveToElement(name);
        actions.click();
        actions.sendKeys(nameExcel);
        actions.build().perform();
    }

    public void setPassword(String passwordExcel)
    {
        actions.moveToElement(passwordText);
        actions.click();
        actions.sendKeys(passwordExcel);
        actions.build().perform();
    }

    public void clickAgreeTerms()
    {
        actions.moveToElement(agreeTerms);
        actions.click();
        actions.build().perform();
    }

    public void clickOnRegister()
    {
        actions.moveToElement(signUpButton);
        actions.click();
        actions.build().perform();
    }

    public void clickCancelButton()
    {
        cancelButton.click();
    }


    public  void clickOnRegisterNow2()
    {
        actions.moveToElement(divStartUp2);
        actions.build().perform();
        actions.moveToElement(registerNow2);
        actions.click();
        actions.build().perform();
    }

    public  void clickOnRegisterNow3()
    {
        actions.moveToElement(divStartUp3);
        actions.build().perform();
        actions.moveToElement(registerNow3);
        actions.click();
        actions.build().perform();
    }
}
