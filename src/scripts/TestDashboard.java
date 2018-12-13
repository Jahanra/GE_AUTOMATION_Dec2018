package scripts;

import base.BaseTestLogin;
import generics.Excel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.HomePage;
import pages.LoginPage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDashboard extends BaseTestLogin
{

     HomePage objHomePage=new HomePage(driver,conn,stmt,resultSet,actions);
     DashboardPage objDashboard=new DashboardPage(driver,conn,stmt,resultSet,actions);
     String technologyName=null;
     String industryName=null;


    @Test
    public  void testDashboard()
    {
        int rc = Excel.getRowCount(INPUT_PATH, "DashboardPageData");

        for (int i = 1; i <= rc; i++)
        {
            technologyName= Excel.getCellValue(INPUT_PATH, "DashboardPageData", i, 0);
            industryName=Excel.getCellValue(INPUT_PATH, "DashboardPageData", i, 1);
            objDashboard.checkTechnologySaved(technologyName);
            objDashboard.checkIndustrySaved(industryName);
            objDashboard.checkTop10Startups("Select * from company_profile_replica_for_gepii_scoring");

        }

    }
}
