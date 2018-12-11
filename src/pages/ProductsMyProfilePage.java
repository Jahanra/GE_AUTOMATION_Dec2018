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

public class ProductsMyProfilePage extends StartUpMyProfilePage
{
    public ProductsMyProfilePage(WebDriver driver, Connection conn, Statement stmt, ResultSet resultSet, Actions actions) {
        super(driver, conn, stmt, resultSet, actions);
    }

    public void callMyProfileFunc() throws InterruptedException {
        goToMyProfileLink();
    }

    public void callScrollByFunc() {
        scrollByUsingJS1();
    }

    public void callClickAddProduct() throws InterruptedException {
        clickOnAddProduct();
    }

    @FindBy(xpath="//header[contains(text(),'Products')]")
    private WebElement productTitle;

    @FindBy(xpath="//input[@ng-model='product.productName']")
    private WebElement productName;

    @FindBy(xpath="(//div[@class='value ng-binding'])[1]")
    private  WebElement productType;

    @FindBy(xpath = "//input[@ng-model='searchFilter.productStageFilterText']")
    private WebElement productTypeText;

    @FindBy(xpath = "//span[@ng-bind-html='productStage.value | highlight:searchFilter.productStageFilterText']")
    private List<WebElement> productTypeSuggestion;

    @FindBy(xpath="//textarea[@ng-model='product.productDescription']")
    private WebElement productDescription;

    @FindBy(xpath="//span[@ng-click='revertProduct(); closeAllModals($event);']")
    private  WebElement cancelBtn;

    @FindBy(xpath = "//span[@ng-click='saveProduct();closeAllModals($event);']")
    private  WebElement saveBtn;

    @FindBy(xpath="//i[@ng-click='revertProduct(); closeAllModals($event);']")
    private  WebElement close;

    @FindBy(xpath = "(//section[@class='product-instance ng-scope']//section[@class='value ng-binding'])[1]")
    private WebElement prodNameValid1;

    @FindBy(xpath = "(//section[@class='product-instance ng-scope']//section[@class='value ng-binding'])[2]")
    private WebElement prodStageValid1;

    @FindBy(xpath = "(//section[@class='product-instance ng-scope']//section[@class='value ng-binding'])[3]")
    private WebElement prodNameValid2;

    @FindBy(xpath="(//section[@class='product-instance ng-scope']//section[@class='value ng-binding'])[4]")
    private WebElement prodStageValid2;

    @FindBy(xpath = "(//section[@class='product-instance ng-scope']//p[@ng-if='product_toggle[$index]'])[1]")
    private WebElement prodDescValid1;

    @FindBy(xpath="(//section[@class='product-instance ng-scope']//p[@ng-if='product_toggle[$index]'])[2]")
    private WebElement prodDescValid2;

    String productMatch=null;
    String productTypeVal=null;
    String descMatch=null;
    String prodUpdateVal1=null;
    String prodUpdateVal2=null;
    String prodStageUpdateVal1=null;
    String prodStageUpdateVal2=null;
    String prodDescUpdateVal1=null;
    String prodDescUpdateVal2=null;

    public void setProductName(String productNameExcel) throws InterruptedException
    {
        actions.moveToElement(productName);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(productNameExcel);
        productMatch=productNameExcel;
        actions.build().perform();
    }


    public void clickOnProductType()throws InterruptedException
    {

        actions.moveToElement(productType);
        actions.click();
        actions.build().perform();

    }

    public void setProductType(String productTypeExcel)throws InterruptedException
    {

        actions.moveToElement(productTypeText);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(productTypeExcel);
        actions.build().perform();
        for(int i=0;i<productTypeSuggestion.size();i++)
        {
            productTypeVal=productTypeSuggestion.get(i).getText().toString();
            Reporter.log("The value of products type fetched is-------->"+productTypeVal,true);
            if(productTypeExcel.equalsIgnoreCase(productTypeVal))
            {
                productTypeSuggestion.get(i).click();
                productTitle.click();
                break;
            }
            else
            {
                Reporter.log("Not Matched the products type value",true);
            }

        }
    }

    public void setBioProductDesc(String productDescExcel) throws InterruptedException
    {
        actions.moveToElement(productDescription);
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys(productDescExcel);
        descMatch=productDescExcel;
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

    public void checkProducts()
    {
        try {
            prodUpdateVal1 = prodNameValid1.getText().toString();
            Reporter.log("The value 1 after Update of product name---------->" + prodUpdateVal1, true);
            prodUpdateVal2 = prodNameValid2.getText().toString();
            Reporter.log("The value 2 after Update of product name--------->" + prodUpdateVal2, true);
            prodStageUpdateVal1 = prodStageValid1.getText().toString();
            Reporter.log("The value 1 after update of product stage------->" + prodStageUpdateVal1, true);
            prodStageUpdateVal2 = prodStageValid2.getText().toString();
            Reporter.log("The value 2after update of product stage------->" + prodStageUpdateVal2, true);
            prodDescUpdateVal1 = prodDescValid1.getText().toString();
            Reporter.log("The value 1 after update of product Desc------->" + prodDescUpdateVal1, true);
            prodDescUpdateVal2 = prodDescValid2.getText().toString();
            Reporter.log("The value 2 after update of product Desc------->" + prodDescUpdateVal2, true);

            if(prodUpdateVal1.contains(productMatch)||prodUpdateVal2.contains(productMatch)&&prodStageUpdateVal1.contains(productTypeVal)||prodStageUpdateVal2.contains(productTypeVal)&&prodDescUpdateVal1.contains(descMatch)||prodDescUpdateVal2.contains(descMatch))
            {
                Reporter.log("Passed: UI product Data Matched",true);
            }
            else
            {
                Reporter.log("Failed:UI product Data Doesnt Matched",true);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
            Reporter.log("Exception in validating the products data in UI"+getClass(),true);
        }
    }
}
