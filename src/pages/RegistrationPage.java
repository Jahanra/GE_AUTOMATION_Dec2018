package pages;

import generics.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import org.testng.Reporter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class RegistrationPage extends HomePage
{
	
	public RegistrationPage(WebDriver driver, Connection conn, Statement stmt, ResultSet resultSet,Actions actions) {

		super(driver,conn,stmt,resultSet,actions);
	}



	@FindBy(css = ".navbar-custom-link")
	private List<WebElement> signInLink;
	WebElement sign_in_btn;

	@FindBy(css="input[ng-model='vm.registerAccount.email']")
	private WebElement businessEmail;

	@FindBy(id="signup-btn")
	private WebElement signUpButton;

	@FindBy(id="password")
	private WebElement password;


	@FindBy(css="input[ngmodel='vm.registerAccount.IAgree']")
	private WebElement agreeTermsCheck;


	@FindBy(xpath="//a[@href='/termsofuse']")
	private WebElement policyLink;


	@FindBy(css="button[ng-click='vm.cancel()']")
	private WebElement cancelButton;

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
@FindBy(xpath="(//span[@ng-if='isStartup'])[1]")
private  WebElement registrationModalWIndow;

	public void moveTORegistrationModalWindow()
	{
		actions.moveToElement(registrationModalWIndow);
		actions.click();
		actions.build().perform();
	}


	public void setBusinessEmail(String businessEmailExcel) throws InterruptedException
	{
		actions.moveToElement(businessEmail);
		actions.click();
		actions.sendKeys(businessEmailExcel,Keys.ENTER);
		actions.build().perform();

		Thread.sleep(1000);
	}


	
	public void setPassword(String passwordExcel) throws InterruptedException
	{
		actions.moveToElement(password);
		actions.click();
		actions.sendKeys(passwordExcel);
		actions.build().perform();

		Thread.sleep(1000);
	}


	
	public void clickAgreeTerms()
	{
		actions.moveToElement(agreeTermsCheck);
		actions.click();
		actions.build().perform();

	}


public void clickPolicy()
{

	policyLink.click();
}
	


	public void clickRegister()
	{

		signUpButton.click();
	}


	
	public void clickCancelButton()
	{
		cancelButton.click();
	}

	@FindBy(css="a[ng-click='vm.cancel(); vm.login();']")
	private WebElement signInLinkReg;
	
	public void clickSignInRegLink()
	{
		signInLinkReg.click();
	}


	@FindBy(xpath="(//span[@ng-model='vm.registerAccount.userCategory'])[1]")
	private WebElement registerStartUp;

	public void clickRegisterStartUp()throws InterruptedException
	{

		actions.moveToElement(registerStartUp);
		actions.click();
		actions.build().perform();
	}


	@FindBy(xpath="(//span[@ng-model='vm.registerAccount.userCategory'])[2]")
	private WebElement registerBusiness;

	public  void clickRegisterBusiness()throws InterruptedException
	{
		actions.moveToElement(registerBusiness);
		actions.click();
		actions.build().perform();
	}

	@FindBy(xpath="//form[@class='mail-sent-body ng-pristine ng-valid ng-scope']")
	private WebElement mailSent;

@FindBy(xpath="(//i[@ng-click='vm.cancel()'])[1]")
private WebElement closeMark;


	public  void clickOnClose()throws InterruptedException
	{
		actions.moveToElement(mailSent);
		actions.moveToElement(closeMark);
		actions.click();
		actions.build().perform();
	}


	public void validateDataRegistrationCorporate(String query1,String query2,String query3) throws SQLException
	{
		int rowsUpdated;
		DateTimeFormatter dtf;
		LocalDate now;
		LocalDate ps;
		String companyId=null;
		Date expirydate=null;
		String promoCode=null;
		String id=null;
		try {
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery(query1);

			while (resultSet.next())

			{
				companyId = resultSet.getString(3);
				expirydate = resultSet.getDate(4);
				promoCode=resultSet.getString(5);
				System.out.println("promo code value in DB------>"+promoCode);

			}

             try {

				 if (null!=promoCode && !promoCode.isEmpty() && "OFFER4".equalsIgnoreCase(promoCode)) {
					 Reporter.log("Running 90 days Offer pack",true);

					 dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					 now = LocalDate.now();
					 Reporter.log("Current Date:" + now, true);
					 String currentDate = dtf.format(now);
					 Reporter.log(currentDate, true);
					 ps = LocalDate.now().plusDays(90);
					 Reporter.log("diff is " + ps, true);
					 java.util.Date psDate = java.sql.Date.valueOf(ps);
					 if (expirydate.compareTo(psDate) == 0) {
						 Reporter.log("Expiry date is correct for 90 days.....!!!! : " + psDate, true);
					 }
				 } else {
					 Reporter.log("Running 14 days trail pack",true);
					 dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					 now = LocalDate.now();
					 System.out.println("Current Date:" + now);
					 String currentDate = dtf.format(now);
					 System.out.println(currentDate);
					 ps = LocalDate.now().plusDays(14);
					 System.out.println("diff is " + ps);
					 java.util.Date psDate = java.sql.Date.valueOf(ps);
					 if (expirydate.compareTo(psDate) == 0) {
						 Reporter.log("Expiry date is correct for 14 days.....!!!! : " + psDate,true);


					 }

				 }
			 }
			 catch (NullPointerException e)
			 {
			 	e.printStackTrace();
			 }

			resultSet=stmt.executeQuery(query2);

			while(resultSet.next())
			{
             id=resultSet.getString(1);
			}

			if(companyId.equals(id))
			{
				Reporter.log("The Entry for the company "+businessEmail.getText().toString()+ " is present" ,true);
			}
			else
			{
				Reporter.log("The Entry for the company "+businessEmail.getText().toString()+"is not present",true);
			}

			 rowsUpdated=stmt.executeUpdate(query3);

		}
		catch (Exception e)
		{
			e.printStackTrace();
			Reporter.log("Exception in validating the data in resgistration business from db",true);
		}
	}

	public void validateDataRegStartUp(String query1,String query2,String query3) throws SQLException
	{
		String companyId=null;
		String id=null;
		int rowsUpdated;

		try {
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery(query1);

			while (resultSet.next())

			{
				companyId = resultSet.getString(3);
			}

			resultSet= stmt.executeQuery(query2);
			while (resultSet.next())

			{
				id = resultSet.getString(1);
			}
			if(companyId.equals(id))
			{
				Reporter.log("Company Exists In Company Profile table",true);
			}
			else
			{
				Reporter.log("Company Doesnt exists in company Profile table",true);
			}

			rowsUpdated=stmt.executeUpdate(query3);


		}
		catch (SQLException e)
		{
			e.printStackTrace();
			Reporter.log("Exception in validating the data in resgistration startup from db",true);
		}


	}

	public void validateCorporateRequest(String query,String nameExcel,String emailExcel,
										 String subjectExcel,String designationExcel,String companyExcel,String messageExcel)
	{
		int rowsUpdated;
		String visitorName=null;
		String visitorEmail=null;
		String subject=null;
		String designation=null;
		String company=null;
		String message=null;

		try{
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery(query);

			while(resultSet.next())
			{
				visitorName=resultSet.getString("visitor_name");
				visitorEmail=resultSet.getString("visitor_email");
				subject=resultSet.getString("subject");
				designation=resultSet.getString("designation");
				company=resultSet.getString("company");
				message=resultSet.getString("message");
			}

			if(nameExcel.equalsIgnoreCase(visitorName)&& emailExcel.equalsIgnoreCase(visitorEmail)&&
					subjectExcel.equalsIgnoreCase(subject)&&designationExcel.equalsIgnoreCase(designation)
					&& companyExcel.equalsIgnoreCase(company)&& messageExcel.equalsIgnoreCase(message) )

			{
               Reporter.log("Pass: Request For demo has saved in data base",true);
			}
			else
			{
				Reporter.log("Fail : Request For demo is not saved in data base",true);

			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
			Reporter.log("Exception in validating the data in request for demo from db",true);
		}

	}
}