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

public class TopResultsPage extends DashboardPage
{
    public TopResultsPage(WebDriver driver, Connection conn, Statement stmt, ResultSet resultSet, Actions actions) {
        super(driver, conn, stmt, resultSet, actions);
    }
 DashboardPage obDBPage=new DashboardPage(driver,conn,stmt,resultSet,actions);
    @FindBy(xpath="//sup[@class='ng-binding']")
    private WebElement resultCount;

    @FindBy(xpath = "//div[@class='text ng-binding']")
    private WebElement resultText;

    @FindBy(xpath="//div[@class='checkbox-holder']")
            private List<WebElement> topResultsCheckBox;

    String countValueUI=null;
    String resultValueUI=null;
    String searchedCountValue=null;
    String searchedTextValue=null;

    public void checkResult(String countTestValue,String textTestValue)
    {
        searchedCountValue=countTestValue;
        searchedTextValue=textTestValue;

        System.out.println("count Value fetched from db page---->"+searchedCountValue);
        System.out.println("text value fetched from db page---->"+searchedTextValue);
        countValueUI=resultCount.getText().toString();
        System.out.println("value of ui fetched for count---->"+countValueUI);

        resultValueUI=resultText.getText().toString();
        System.out.println("value of ui fetched for text------>"+resultValueUI);
        if(searchedCountValue.contains(countValueUI)&&searchedTextValue.contains(resultValueUI))
        {
            Reporter.log("Data Validation  is done from UI",true);
        }
        else
        {
            Reporter.log("Failed to validate from UI",true);
        }
    }
    public void validateDataBase(String query,String columnName) {
        try {
            String dbFetchCount=null;
            String fetchColumnValue=null;

            stmt = conn.createStatement();
            resultSet = stmt.executeQuery(query);

            Reporter.log("-----------------------DB Validation-----------------", true);
            while (resultSet.next())
            {
                dbFetchCount=resultSet.getString(1);
                fetchColumnValue=resultSet.getString(columnName);
            }

            System.out.println("dbfecthcount value----------->"+dbFetchCount);
            System.out.println("fetchColumnValue------------->"+fetchColumnValue);

            if(fetchColumnValue.contains(searchedTextValue)&&dbFetchCount.contains(countValueUI)  )
            {
                Reporter.log("Passed:Data is validated from DB point ",true);

            }
            else
            {
                Reporter.log("Failed:Data Failed to validate from DB point",true);
            }

        } catch (Exception e)
        {
            e.printStackTrace();
            log.info("Exception in validating the database fields!!!!!!!");
        }
    }


}
