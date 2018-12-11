package scripts;

import base.BaseTestLogin;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.BusinessTractionPage;

public class TestBusinessTraction extends BaseTestLogin
{
    BusinessTractionPage objBusiTrac;

    @Test
    public void testBusinessTraction() {
        try {
            Reporter.log("Running test business traction", true);
            objBusiTrac = new BusinessTractionPage(driver, conn, stmt, resultSet, actions);
            objBusiTrac.callMyProfilefunc();
            Thread.sleep(2000);
             objBusiTrac.scrollByUsingJSFunc();
             Thread.sleep(2000);
             objBusiTrac.callAddBussTract();
            Thread.sleep(2000);
            objBusiTrac.clickOnStartUpType();
            objBusiTrac.setStartUpType("BOTH");
            Thread.sleep(5000);
            objBusiTrac.clickOnProductType();
            objBusiTrac.setProductType("BOTH");
            Thread.sleep(2000);
            objBusiTrac.clickOnBusinessTypeBoth();
            objBusiTrac.clickOnCustomersB2B();
            objBusiTrac.setCustomerB2B("We Have Acquired Paid Customers");
            Thread.sleep(2000);
            objBusiTrac.clickOnNoOfCustomers();
            objBusiTrac.setNoOfCustomers("50+");
            Thread.sleep(2000);
            objBusiTrac.clickOnEndUsers();
            objBusiTrac.setEndUser("We Have Acquired Paid Users");
            Thread.sleep(2000);
            objBusiTrac.clickOnNoOfEndUsers();
            objBusiTrac.setNoOfEndUser("More than 50,000");
            Thread.sleep(2000);
            objBusiTrac.clickOnSubscription();
            objBusiTrac.clickOnCommission();
            objBusiTrac.clickOnAdvertising();
            objBusiTrac.clickOnOtherRevenueModel();
            Thread.sleep(2000);
            objBusiTrac.setOtherRevenueModel("Review Count");
            objBusiTrac.clickLeadership();
            objBusiTrac.clickInnovationCapability();
            objBusiTrac.clickOnOtherDiffCompet();
            Thread.sleep(2000);
            objBusiTrac.setOtherDiffCompet("Locality Search");
            Thread.sleep(2000);
            objBusiTrac.clickSave();
            //objBusiTrac.clickSave();

        } catch (Exception e)
        {
            e.printStackTrace();
            Reporter.log("Failed to run the business traction test");

        }
        try{
            objBusiTrac.checkResultBusinessTract();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
       /* try
        {
          objBusiTrac.checkTractionScore("");
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }*/
    }
}
