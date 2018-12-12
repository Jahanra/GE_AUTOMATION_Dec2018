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


public class LoginPage extends BasePageLogin
{


    public LoginPage(WebDriver driver, Connection conn, Statement stmt, ResultSet resultSet,Actions actions) {

        super(driver, conn, stmt, resultSet,actions);

    }
    @FindBy(css = ".navbar-custom-link")
    private List<WebElement> signInLink;
   WebElement sign_in_btn;

    String userMatch;
    String pwdMatch;

    public void clickSignIn() throws InterruptedException {
        try
        {
            System.out.println("sign in function ---->");
                sign_in_btn=signInLink.get(signInLink.size()-1).findElement(By.cssSelector(".highlight"));
                sign_in_btn.click();
                System.out.println("Click on Sign in link");



        } catch (Exception e) {
             e.printStackTrace();
        }
    }


    @FindBy(xpath="//div[@class='modal-header']")
    private WebElement loginModalWindow;

    public void moveToLoginModalWindow()
    {
        actions.moveToElement(loginModalWindow);
        actions.click();
        actions.build().perform();
    }

    @FindBy(xpath = "//span[@href='/contactus/request-demo']")
    private WebElement requestForDemo;

    public void clickRequestForDemo()
    {
      actions.moveToElement(requestForDemo);
      actions.click();
      actions.build().perform();
    }

    @FindBy(xpath="(//span[@class='linkRegister'])[2]")
    private WebElement startUpRegister;

    public void clickOnStartUpRegister()
    {
        actions.moveToElement(startUpRegister);
        actions.click();
        actions.build().perform();
    }

    @FindBy(css="input[ng-model='vm.username']")
    private WebElement userName;

    public void setUserName(String userNameExcel) {
        try {
            actions.moveToElement(userName);
            actions.click();
            actions.sendKeys(userNameExcel);
            userMatch=userNameExcel;
            actions.build().perform();
            Thread.sleep(1000);

        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("exception in user name");
        }
    }

    @FindBy(css="input[ng-model='vm.password']")
    private WebElement password;

    public void setPassword(String passswordExcel){
        try {
            actions.moveToElement(password);
            actions.click();
            actions.sendKeys(passswordExcel);
            pwdMatch = passswordExcel;
            actions.build().perform();
            Thread.sleep(1000);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Exception in password");
        }
    }


    @FindBy(xpath = ".//*[@id='rememberMe']")
    private WebElement rememberMeCheckBox;

    public void clickRememberCheckBox() {
        rememberMeCheckBox.click();
    }


    @FindBy(xpath = "//a[@ng-click='vm.requestResetPassword()']")
    private WebElement forgotPwd;

    public void clickForgotPwd() {
        forgotPwd.click();
    }


    @FindBy(xpath = "(//button[@type='submit'])[1]")
    private WebElement loginBtn;

    public void clickLogin() throws Exception {
        loginBtn.click();

    }


    @FindBy(xpath = "//div[@class='modal-content']//span[@ng-click='vm.register()']")
    private WebElement registerNowLink;

    public void clickregisterNow()
    {
        registerNowLink.click();
    }


    @FindBy(xpath = "//i[@class='fa fa-close']")
    private WebElement closeLogin;

    public void clickCloseLogin() {
        closeLogin.click();
    }


    public void validateLoginDataStartUp(String query,String userType)
    {
        try{

        stmt = conn.createStatement();
        resultSet = stmt.executeQuery(query);
        String companyId=null;
        String login=null;
        String userCategory=null;

        while (resultSet.next())
        {
            login=resultSet.getString(1);
            userCategory=resultSet.getString(2);
            companyId=resultSet.getString(3);

        }
        if(login.contains(userMatch)&& userType.contains(userCategory))
        {
           Reporter.log("Passed:Login Test Is Validated For Start Up From DB");
        }
        else
        {
          Reporter.log("Failed:Login Test is Failed For start Up login from DB");
        }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Reporter.log("Exception In Validating Login Data for startup From DB",true);
        }
    }

    public void validateLoginDataCorporate(String query,String userType)
    {
        try
        {
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery(query);
            String email=userName.getText();
            String companyId=null;
            String login=null;
            String userCategory=null;
            String expiryDate=null;
            String promoCode=null;
            while(resultSet.next())
            {
                login=resultSet.getString(1);
                userCategory= resultSet.getString(2);
                companyId=resultSet.getString(3);
                expiryDate=resultSet.getString(4);
                promoCode=resultSet.getString(5);
            }

            if(login.contains(userMatch)&&userCategory.contains(userType))
            {
                Reporter.log("PASSED:TEST IS VALIDATED FOR CORPORATE LOGIN FROM DB",true);
            }
            else
            {
                Reporter.log("FAILED:TEST IS FAILED FOR CORPORATE LOGIN FROM DB",true);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Reporter.log("Exception in validating login data for corporate  from db",true);
        }
    }
}
