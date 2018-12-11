package base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import generics.Listener;
import generics.Utility;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.ITestResult;
import pages.DashboardPage;
import pages.LoginPage;

import java.lang.reflect.Method;
import java.sql.*;
import java.util.concurrent.TimeUnit;

@Listeners(Listener.class)
public abstract class BaseTestLogin implements AutomationConstants

{
    public static WebDriver driver;
    private static WebDriverWait wait;
    public static boolean loginRequired = true;
    public static boolean logoutRequired = true;
    public static String url;
    public static String un;
    public static String pw;
    public static long iTimeout;
    public static long eTimeout;
    public Logger log;
    public ExtentTest eTest;
    public static ExtentReports eReport;
    String dbUrl = "jdbc:mysql://88.198.208.55/dev_growth_enabler_ui";
    String username = "Growthenabler";
    String password = "G30WthEn@813r";
    public Connection conn;
    public Statement stmt;
    public ResultSet resultSet;
    public static Actions actions;

    public BaseTestLogin() {

        log = Logger.getLogger(this.getClass());
    }

    @BeforeSuite
    public void initReport() {
        String log4jConfPath = "./log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
        log.info("initializing ExtentReport");
        String now = Utility.getFormatedDateTime();
        String reportFile = REPORT_PATH + now + ".html";
        eReport = new ExtentReports(reportFile);
    }

    @AfterSuite
    public void publishReport() {
        log.info("publishing ExtentReport");
        eReport.flush();
    }

    @BeforeTest
    public void initGlobalVar() {
        log.info("initialize Global variables");
        url = Utility.getPropertyValue(CONFIG_PATH, "URL");
        un = Utility.getPropertyValue(CONFIG_PATH, "UN");
        pw = Utility.getPropertyValue(CONFIG_PATH, "PW");
        iTimeout = Long.parseLong(Utility.getPropertyValue(CONFIG_PATH, "IMPLICIT"));
        eTimeout = Long.parseLong(Utility.getPropertyValue(CONFIG_PATH, "EXPLICIT"));
    }

    @Parameters({"browser"})
    @BeforeClass
    public void initApplication(@Optional("chrome") String browser) throws SQLException, ClassNotFoundException {

        if (browser.equals("chrome")) {
            System.setProperty(CHROME_KEY, CHROME_VALUE);
            /*ChromeOptions cp = new ChromeOptions();
            cp.addArguments("--headless");*/
            driver = new ChromeDriver();
            actions = new Actions(driver);
        } else {
            System.setProperty(GECKO_KEY, GECKO_VALUE);
           /* FirefoxOptions fo = new FirefoxOptions();
            fo.addArguments("headless");*/
            driver = new FirefoxDriver();
            actions = new Actions(driver);
        }
        driver.manage().timeouts().implicitlyWait(iTimeout, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void closeApplication() throws InterruptedException {
        log.info("Closing Browser");
        System.out.println("calling of after class of basetestlogin-------------------------");

        try {
            conn.close();
            driver.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in @Afterclass method");
        }
    }

    @Parameters({"login"})
    @BeforeMethod
    public void preCondition(Method method, @Optional("StartUp") String loginType) throws Exception {
        System.out.println("calling before method of basetestlogin------------------------------");
        driver.get(url);
        if (loginType.equals("StartUp")) {
            if (loginRequired) {
                log.info("Auto login");
                LoginPage loginPageObj = new LoginPage(driver, conn, stmt, resultSet, actions);
                loginPageObj.clickSignIn();
                Thread.sleep(3000);
                loginPageObj.setUserName("test2@test2startup29feb.com");
                Thread.sleep(1000);
                loginPageObj.setPassword("startup29");
                Thread.sleep(1000);

                loginPageObj.clickLogin();
                Thread.sleep(5000);
            } else

            {
                log.warn("login required");
                loginRequired = true;
            }
        } else {
            if (loginRequired) {
                LoginPage loginPageObj = new LoginPage(driver, conn, stmt, resultSet, actions);
                loginPageObj.clickSignIn();
                Thread.sleep(3000);
                loginPageObj.setUserName("test25313Feb18@tangoeStar090218.com");
                Thread.sleep(1000);
                loginPageObj.setPassword("TangoeStar13");
                Thread.sleep(1000);

                loginPageObj.clickLogin();
                Thread.sleep(5000);
            } else

            {
                log.warn("login required");
                loginRequired = true;
            }
        }


        eTest = eReport.startTest(method.getName());

    }

    @AfterMethod
    public void postCondition(ITestResult testNGTestResult) throws InterruptedException {
        if (logoutRequired) {
            log.info("Auto logout");
            DashboardPage objdbPage = new DashboardPage(driver, conn, stmt, resultSet, actions);
            objdbPage.clickOnLogOut();
        } else {
            log.warn("logout required");
            logoutRequired = true;
        }
        if (testNGTestResult.getStatus() == ITestResult.FAILURE) {
            eTest.log(LogStatus.FAIL, "Check log for details");
        } else {
            eTest.log(LogStatus.PASS, "Script executed successfully");
        }
        eReport.endTest(eTest);
    }

    @AfterTest
    public void CloseTheConnection() throws SQLException {


        // Code to close each and all Object related to Database connection
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception e) {
            }

        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
            }
            finally {
                conn.close();
            }
        }


        driver.quit();
    }


}