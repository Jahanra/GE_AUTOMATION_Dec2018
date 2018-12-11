package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HomePage extends BasePage
{
	
	


	public HomePage(WebDriver driver, Connection conn, Statement stmt, ResultSet resultSet, Actions actions) {
		super(driver, conn, stmt, resultSet, actions);
	}

	@FindBy(id="logo-link")
	private WebElement geLogo;

	public void clickGeLogo()
	{
		geLogo.click();
	}
	
	@FindBy(xpath = "//span[@class='linkRegister']")
	private WebElement registerHere;
	
	public void clickRegisterHere()
	{
		actions.moveToElement(registerHere);
		actions.click();
		actions.build().perform();

	}

	@FindBy(xpath="//button[@href='/contactus/request-demo']")
	private WebElement requestForDemo;

	public void clickRequestForDemo()
	{
		actions.moveToElement(requestForDemo);
		actions.click();
		actions.build().perform();
	}
	@FindBy(css="a[href='/team']")
	private WebElement teamLink;
	
	public void clickTeamLink()
	{

		teamLink.click();
	}
	
	@FindBy(xpath="//a[@ui-sref='subscribe()']")
     private WebElement pricingLink;
	
	public void clickPricingLink()
	
	{
		pricingLink.click();
	}

	@FindBy(css="a[ui-sref='startup()']")
    private WebElement startUpLink;
	
	public void clickStartUpLink()
	
	{
		actions.moveToElement(startUpLink);
		actions.click();
		actions.build().perform();
	}

	
	
	@FindBy(css="a[href='/geIntelligence']")
    private WebElement insightsLink;
	
	public void clickInsightLink()
	
	{
		insightsLink.click();
	}

	@FindBy(css="a[href='/media']")
	private WebElement mediaLink;

	public void clickMediaLink()

	{
		mediaLink.click();
	}

	@FindBy(id="login")
	private WebElement signInLink;

	public void clickSignInLink()

	{
		signInLink.click();
	}



  @FindBy(css="div[href='/termsofuse']")
	private WebElement termOfUseLink;


	public void clicktermOfUseLink()

	{
		termOfUseLink.click();
	}
	@FindBy(css="div[href='/termsofuse']")
	private WebElement contactUsLink;


	public void clickContactUsLink()

	{
		contactUsLink.click();
	}

	@FindBy(css="a[href='https://www.facebook.com/GrowthEnabler/?fref=ts']")
	private  WebElement facebookLink;

	public void clickFacebookLink()

	{
		facebookLink.click();
	}

	@FindBy(css="a[href='https://twitter.com/GrowthEnabler']")
	private WebElement twitterLink;

	public void clickTwitterLink()
	{
		twitterLink.click();
	}

	@FindBy(css="a[href='https://www.linkedin.com/company/9331781?trk=tyah&trkInfo=clickedVertical%3Acompany%2CclickedEntityId%3A9331781%2Cidx%3A1-1-1%2CtarId%3A1473683262817%2Ctas%3Agrowthenabler']")
	private WebElement linkedInLink;

	public void clickLinkedInLink()
	{
		linkedInLink.click();
	}


}
