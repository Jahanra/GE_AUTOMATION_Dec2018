package scripts;

import base.BaseTestLogin;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.ProductsMyProfilePage;

public class TestProductMyProfile extends BaseTestLogin
{

    ProductsMyProfilePage objProductPage;
    @Test
    public void testProduct() throws InterruptedException
    {
        objProductPage=new ProductsMyProfilePage(driver,conn,stmt,resultSet,actions);
        try {
            objProductPage.callMyProfileFunc();
            Thread.sleep(2000);
            objProductPage.callScrollByFunc();
            Thread.sleep(2000);
            objProductPage.clickOnAddProduct();
            Thread.sleep(2000);
            objProductPage.setProductName("product1");
            Thread.sleep(2000);
            objProductPage.clickOnProductType();
            Thread.sleep(2000);
            objProductPage.setProductType("Beta");
            Thread.sleep(2000);
            objProductPage.setBioProductDesc("product1");
            Thread.sleep(2000);
            objProductPage.clickSave();
            Thread.sleep(5000);
            objProductPage.clickOnAddProduct();
            Thread.sleep(2000);
            objProductPage.setProductName("Mobile Gadgets");
            Thread.sleep(2000);
            objProductPage.clickOnProductType();
            Thread.sleep(2000);
            objProductPage.setProductType("Market Ready");
            Thread.sleep(2000);
            //objProductPage.setBioProductDesc("");
            Thread.sleep(2000);
            objProductPage.clickSave();
            Thread.sleep(3000);
            objProductPage.checkProducts();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Reporter.log("Exception in test product my profile------->"+getClass(),true);
        }



    }
}
