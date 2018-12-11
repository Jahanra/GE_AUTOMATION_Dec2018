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

public class StartUpMyProfilePage extends  DashboardPage
{

    public StartUpMyProfilePage(WebDriver driver, Connection conn, Statement stmt, ResultSet resultSet,Actions actions) {
        super(driver, conn, stmt, resultSet,actions);
    }
    DashboardPage objDB=new DashboardPage(driver,conn,stmt,resultSet,actions);

    @FindBy(xpath="(//i[@class='material-icons' and contains(text(),'edit')])[1]")
    private WebElement editBasicInfoIcon;



    @FindBy(xpath="(//div[@class='progress-number ng-binding'])[1]")
    private WebElement productValidScore;

    @FindBy(xpath="(//div[@class='progress-number ng-binding'])[2]")
    private WebElement financialValidScore;

    @FindBy(xpath = "(//div[@class='progress-number ng-binding'])[3]")
    private  WebElement tractionValidScore;

    @FindBy(xpath="(//div[@class='progress-number ng-binding'])[4]")
    private WebElement leadershipValidScore;

    @FindBy(xpath="(//div[@class='progress-number ng-binding'])[5]")
    private WebElement mediaValidScore;

    @FindBy(xpath="(//div[@class='progress-number ng-binding'])[6]")
    private WebElement piiScoreValid;



    @FindBy(xpath="//span[@ng-click='showAboutModal();']")
    private WebElement addAbout;

    @FindBy(xpath="//span[@ng-click='showBusinessModal();' and contains(text(),' Add Business Traction')]")
    private  WebElement addBusinessTraction;

    @FindBy(xpath="//input[@class='pii-score']")
    private WebElement gePiiChartSymbol;

    @FindBy(xpath="//span[@ng-click='addExecutive();']")
    private WebElement addExecutive;

    @FindBy(xpath="//span[@ng-click='addAdvisory();']")
    private  WebElement addAdvisory;

    @FindBy(xpath="//span[@ng-click='showFundingModal();']")
    private WebElement addFinancialInformation;

    @FindBy(xpath="//span[@ng-click='addProduct();']")
    private WebElement addProduct;

    @FindBy(xpath = "//span[@ng-click='addPatent();']")
    private WebElement addPatent;

    @FindBy(xpath="//span[@ng-click='showSocialModal();']")
    private WebElement addSocialMedia;


    @FindBy(xpath = "//h2[contains(text(),'GrowthEnabr Score')]")
    private WebElement scoreHeader;

    @FindBy(xpath="//h2[contains(text(),'Competitors')]")
    private WebElement competitorsHeader;

    @FindBy(xpath="//section[@data-target='competitor']")
    private  WebElement scrollTillCompt;

    @FindBy(xpath="(//div[@class='competitor'])[1]")
    private WebElement competName1;


    public  void goToMyProfileLink() throws InterruptedException
    {
        clickOnMyProfile();
    }

    public void clickOnEditIconOfBasicInfo()throws InterruptedException
    {
        actions.moveToElement(editBasicInfoIcon);
        actions.click();
        actions.build().perform();
    }

    public void clickOnAddAbout()throws InterruptedException
    {
        actions.moveToElement(addAbout);
        actions.click();
        actions.build().perform();
    }

    public  void scrollByUsingJSFunc()
    {

        Utility.scrollByUsingJS(driver,gePiiChartSymbol);
    }
    public void scrollByUsingAbout()
    {
        Utility.scrollByUsingJS(driver,scoreHeader);
    }

    public void scrollByUsingJS1()
    {
        Utility.scrollByUsingJS(driver,addExecutive);
    }
    public void scrollByUsingJS2()
    {
        Utility.scrollByUsingJS(driver,addProduct);
    }

    public void scrollByMedia()
    {
        Utility.scrollByUsingJS(driver,competitorsHeader);
    }
    public void clickOnAddBusinessTraction()throws  InterruptedException
    {
        actions.moveToElement(addBusinessTraction);
        actions.click();
        actions.build().perform();
    }

    public void clickOnAddExecutive()throws  InterruptedException
    {
        actions.moveToElement(addExecutive);
        actions.click();
        actions.build().perform();
    }

    public void clickOnAddAdvisory()throws  InterruptedException
    {
        actions.moveToElement(addAdvisory);
        actions.click();
        actions.build().perform();
    }

    public void clickOnAddFinanacialInfo()throws  InterruptedException
    {
        actions.moveToElement(addFinancialInformation);
        actions.click();
        actions.build().perform();
    }

    public void clickOnAddProduct()throws  InterruptedException
    {
        actions.moveToElement(addProduct);
        actions.click();
        actions.build().perform();
    }
    public void clickOnAddPatent()throws  InterruptedException
    {
        actions.moveToElement(addPatent);
        actions.click();
        actions.build().perform();
    }


    public void clickOnAddSocialMedia()throws  InterruptedException
    {
        actions.moveToElement(addSocialMedia);
        actions.click();
        actions.build().perform();
    }
    public void callScrollBy()
    {
        Utility.scrollByUsingJS(driver,scrollTillCompt);

        actions.moveToElement(scrollTillCompt);
        actions.click();
        actions.build().perform();

    }

    public void clickOnCompet1()
    {
        actions.moveToElement(competName1);
        actions.click();
        actions.build().perform();
    }

    String tractionScore=null;

    public void checkTractionScore(String tractionExcel)
    {
        tractionScore= tractionValidScore.getText().toString();

        Reporter.log("The value of business traction score fetched----->"+tractionScore,true);

        if(tractionScore.contains(tractionExcel))
        {
            Reporter.log(" Business Traction Score Matched",true);
        }
        else
        {
            Reporter.log("Business Traction score doesnt matched",true);
        }
    }


    String managementScore=null;

    public void checkManagementScore(String managementExcel)
    {
        managementScore= leadershipValidScore.getText().toString();

        Reporter.log("The value of leadership score fetched----->"+managementScore,true);

        if(managementScore.contains(managementExcel))
        {
            Reporter.log(" leadership Score Matched",true);
        }
        else
        {
            Reporter.log("leadership score doesnt matched",true);
        }
    }

    String financeScore=null;

    public void checkFinanceScore(String financeExcel)
    {
        financeScore= financialValidScore.getText().toString();

        Reporter.log("The value of financial score fetched----->"+financeScore,true);

        if(financeScore.contains(financeExcel))
        {
            Reporter.log(" financial Score Matched",true);
        }
        else
        {
            Reporter.log("financial score doesnt matched",true);
        }
    }

    String productScore=null;

    public void checkProductScore(String productExcel)
    {
        productScore= productValidScore.getText().toString();

        Reporter.log("The value of product score fetched----->"+productScore,true);

        if(productScore.contains(productExcel))
        {
            Reporter.log(" Product Score Matched",true);
        }
        else
        {
            Reporter.log("Product score doesnt matched",true);
        }
    }


    String mediaScore=null;

    public void checkMediaScore(String mediaExcel)
    {
        mediaScore= mediaValidScore.getText().toString();

        Reporter.log("The value of media score fetched----->"+mediaScore,true);

        if(mediaScore.contains(mediaExcel))
        {
            Reporter.log(" Media Score Matched",true);
        }
        else
        {
            Reporter.log("Media score doesnt matched",true);
        }
    }

    String gePiiScore=null;

    public void checkGePiiScore(String piiExcel)
    {
        gePiiScore= piiScoreValid.getText().toString();

        Reporter.log("The value of pii score fetched----->"+gePiiScore,true);

        if(gePiiScore.contains(piiExcel))
        {
            Reporter.log(" Pii Score Matched",true);
        }
        else
        {
            Reporter.log("Pii score doesnt matched",true);
        }
    }



}
