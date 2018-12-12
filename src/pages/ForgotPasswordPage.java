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
import java.time.LocalDate;
import java.util.Date;

public class ForgotPasswordPage extends BasePageLogin
{
    public ForgotPasswordPage(WebDriver driver, Connection conn, Statement stmt, ResultSet resultSet, Actions actions) {
        super(driver, conn, stmt, resultSet, actions);
    }

    @FindBy(xpath="//input[@ng-model='vm.resetAccount.email']")
    private WebElement registerdEmailId;


    @FindBy(xpath = "//button[contains(text(),'RESET')]")
    private  WebElement resetBtn;


    @FindBy(xpath="//div[@class='alert alert-success']/p")
    private WebElement alertMessage;

    String successAlertMsg="Reset request sent! Check your e-mail for details on how to reset your password.";
    String  failedAlertMsg="";

    public void setRegisterdEmailId(String forgotPwdExcel)
    {
        actions.moveToElement(registerdEmailId);
        actions.sendKeys(forgotPwdExcel);
        actions.build().perform();
    }

    public void checkEmailIdExists(String query,String emailId)
    {
        try {

            stmt = conn.createStatement();
            resultSet = stmt.executeQuery(query);
            String login=null;
            String  resetKey=null;
            Date resetDate=null;
            LocalDate now=LocalDate.now();

            while (resultSet.next())
            {
                login = resultSet.getString(2);
                resetKey=resultSet.getString("reset_key");
                resetDate=resultSet.getDate(13);

                if(login.equalsIgnoreCase(emailId)&& !(resetKey.isEmpty()) && resetDate.equals(now))
                {
                    Reporter.log("Email Id exists and the reset mail has been sent successfully ",true);
                }
                else
                {
                    Reporter.log("Email Id doesnt exists and no email has been sent",true);
                }
                }

        }
        catch (Exception e)
        {
            e.printStackTrace();
            Reporter.log("Exception in validaing forgot password from data base",true);
        }
    }

    public  void clickResetBtn()
    {
        actions.moveToElement(resetBtn);
        actions.click();
        actions.build().perform();
    }

    public  void checkAlertMessage()
    {
        if(alertMessage.getText().equalsIgnoreCase(successAlertMsg))
        {
            Reporter.log("Email Id is valid and reset email has been sent successfully",true);
        }
        else
        {
            Reporter.log("Email Id is not valid",true);
        }

    }

}
