package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AboutMyProfilePage extends StartUpMyProfilePage
{
    public AboutMyProfilePage(WebDriver driver, Connection conn, Statement stmt, ResultSet resultSet, Actions actions) {
        super(driver, conn, stmt, resultSet, actions);
    }

    public void callMyProfileFunc() throws InterruptedException {
        goToMyProfileLink();
    }

    public void callScrollByFunc() {
      scrollByUsingAbout();
    }

    public void callClickAddAbout() throws InterruptedException {
       clickOnAddAbout();
    }

    @FindBy(xpath="//header[contains(text(),'About Company')]")
    private WebElement aboutCompanyTitle;

    @FindBy(xpath="//textarea[@ng-model='companyProfileDto.aboutUs']")
    private WebElement descCompany;


    @FindBy(xpath="//span[@ng-click='revertAbout(); closeAllModals($event);']")
    private  WebElement cancelBtn;

    @FindBy(xpath = "//span[@ng-click='save(companyProfileDto);closeAllModals($event);']")
    private  WebElement saveBtn;

    @FindBy(xpath="//i[@ng-click='revertAbout(); closeAllModals($event);']")
    private  WebElement close;

    @FindBy(xpath="//p[@ng-if='!about_toggle']")
    private WebElement aboutValid;

    String aboutMatch=null;
    String aboutUpdateVal=null;


    public void setAboutCompany(String aboutCompanyExcel) throws InterruptedException
    {
        actions.moveToElement(descCompany);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(aboutCompanyExcel);
        aboutMatch=aboutCompanyExcel;
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
    public  void checkResultTestAbout()throws InterruptedException
    {
        try {
            aboutUpdateVal = aboutValid.getText().toString();
            System.out.println("about validation value---->" + aboutUpdateVal);

            if (aboutUpdateVal.contains(aboutMatch)) {
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
