package scripts;

import base.BaseTestLogin;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.SocialMediaPage;

public class TestSocialMediaMyProfile extends BaseTestLogin
{
    SocialMediaPage objSocialMediaPage;

    @Test
    public void  testSocialMedia() throws InterruptedException
    {
        objSocialMediaPage=new SocialMediaPage(driver,conn,stmt,resultSet,actions);
        try{
            objSocialMediaPage.callMyProfileFunc();
            Thread.sleep(2000);
            objSocialMediaPage.scrollByMedia();
            Thread.sleep(2000);
            objSocialMediaPage.clickOnAddSocialMedia();
            Thread.sleep(2000);
            objSocialMediaPage.setFacebook("facebook url test");
            Thread.sleep(2000);
            objSocialMediaPage.setTwitter("twitter url test");
            Thread.sleep(2000);
            objSocialMediaPage.setLinkedInUrl("linked in url test");
            Thread.sleep(2000);
            objSocialMediaPage.clickCancel();

        }
        catch (Exception e)
        {
            e.printStackTrace();
            Reporter.log("Exception in test social media----->"+getClass(),true);
        }
    }
}
