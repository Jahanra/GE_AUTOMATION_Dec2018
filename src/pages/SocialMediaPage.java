package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SocialMediaPage extends StartUpMyProfilePage {
    public SocialMediaPage(WebDriver driver, Connection conn, Statement stmt, ResultSet resultSet, Actions actions) {
        super(driver, conn, stmt, resultSet, actions);
    }

    public void callMyProfileFunc() throws InterruptedException {
        goToMyProfileLink();
    }

    public void callScrollByFunc() {
        scrollByMedia();
    }

    public void callClickAddSocialMedia() throws InterruptedException
    {
       clickOnAddSocialMedia();
    }
    @FindBy(xpath="//header[contains(text(),'Social Media ')]")
    private WebElement socialMediaTitle;

    @FindBy(xpath="//input[@ng-model='companyProfileDto.facebook']")
    private WebElement facebook;

    @FindBy(xpath="//input[@ng-model='companyProfileDto.twitter']")
    private WebElement twitter;

    @FindBy(xpath="//input[@ng-model='companyProfileDto.linkedin']")
    private  WebElement linkedInUrl;

    @FindBy(xpath="//span[@ng-click='revertSocialInfo(); closeAllModals($event);']")
    private  WebElement cancelBtn;

    @FindBy(xpath = "//span[@ng-click='save(companyProfileDto) && closeAllModals($event);']")
    private  WebElement saveBtn;

    @FindBy(xpath="//i[@ng-click='revertSocialInfo(); closeAllModals($event);']")
    private  WebElement close;


    @FindBy(xpath="//div[@class='timeline-Header timeline-InformationCircle-widgetParent']//a[@class='customisable-highlight']")
    private WebElement twitterFeedValid;

    @FindBy(xpath = "//html[@id='facebook']//a[@class='_3-8_ lfloat']")
    private WebElement facebookFeedValid;

     String facebookMatch=null;
     String twitterMatch=null;

     String faceUpdateVal=null;
     String  twitUpdateVal=null;

    public void setFacebook(String facebookExcel) throws InterruptedException
    {
        actions.moveToElement(facebook);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(facebookExcel);
        facebookMatch=facebookExcel;
        actions.build().perform();

    }

    public void setLinkedInUrl(String linkedInExcel) throws InterruptedException
    {
        actions.moveToElement(linkedInUrl);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(linkedInExcel);
        actions.build().perform();

    }
    public void setTwitter(String twitterExcel) throws InterruptedException
    {
        actions.moveToElement(twitter);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(twitterExcel);
        twitterMatch=twitterExcel;
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

    public void checkSocialMedia()
    {
        try {
            faceUpdateVal = facebookFeedValid.getText().toString();
            Reporter.log("The value of facebook feed is-------->" + faceUpdateVal);
            twitUpdateVal = twitterFeedValid.getText().toString();
            Reporter.log("The value of twitter feed is-------->" + twitUpdateVal);
            if (faceUpdateVal.contains(facebookMatch) && twitUpdateVal.contains(twitterMatch)) {
                Reporter.log("Passed: UI data for facebook and twitter matched", true);
            } else {
                Reporter.log("Failed:UI data for Facebook and Twitter Doesnt matched", true);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Reporter.log("Exception is check social media function----->"+getClass(),true);
        }
    }

}
