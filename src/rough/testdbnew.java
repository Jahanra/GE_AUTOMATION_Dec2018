package rough;

import org.testng.annotations.Test;

import java.sql.*;
import java.util.Properties;

public class testdbnew
{
    @Test
    public void testdbconn() throws ClassNotFoundException {

        // Initialize connection variables.
        String host = "ge-prod-mysql-eu-west.mysql.database.azure.com";
        String databaseUi = "dev_growth_enabler_ui";
        String databaseCrawler = "dev_growth_enabler_crawler";
        String username = "Growthenabler@ge-prod-mysql-eu-west";
        String password = "G30WthEn@813r";
        Connection connUI = null;
        Statement stmtUICondition1=null;
        Statement stmtUICondition2=null;
        ResultSet resultSetUICondition1 = null;
        ResultSet resultSetUICondition2=null;
        Connection connCrawler = null;
        Statement stmtCrawler=null;
        ResultSet resultSetCrawlerCondition1 = null;
        ResultSet resultSetCrawlerCondition2=null;
        ResultSet resultSetCrawlerCount1=null;
        ResultSet resultSetCrawlerCount2=null;
        ResultSet resultSetUICount1=null;
        ResultSet resultSetUICount2=null;
        String companyNameUI = null, companyNameCrawler = null;
        String domainNameUI=null,domainNameCrawler=null;
        String emailUI=null,emailCrawler=null;
        String foundedYearUI=null,foundedYearCrawler=null;
        String teamSizeUI=null,teamSizeCrawler=null;
        String shortDescUI=null,shortDescCrawler=null;
        String websiteUI=null,websiteCrawler=null;
        String linkedInUI=null,linkedInCrawler=null;
        String facebookUI=null,facebookCrawler=null;
        String twitterUI=null,twitterCrawler=null;
        String phoneUI=null,phoneCrawler=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }

        try {
            String dbUrlUI = String.format("jdbc:mysql://%s/%s", host, databaseUi);

            // Set connection properties.
            Properties properties = new Properties();
            properties.setProperty("user", username);
            properties.setProperty("password", password);
            properties.setProperty("useSSL", "true");
            properties.setProperty("verifyServerCertificate", "true");
            properties.setProperty("requireSSL", "false");
            properties.setProperty("useUnicode", "true");
            properties.setProperty("serverTimezone", "UTC");
            connUI = DriverManager.getConnection(dbUrlUI, properties);
            String dbUrlCrawler = String.format("jdbc:mysql://%s/%s", host, databaseCrawler);

            // get connection
            connCrawler = DriverManager.getConnection(dbUrlCrawler, properties);


            String queryCondition1="SELECT company_name,domain,primary_role,founded_on,funding_rounds,email,phone,employee_count,\n" +
                    "facebook_url,linkedin_url,twitter_url,short_description,homepage_url\n" +
                    "FROM dev_growth_enabler_crawler.`secondary_Dinesh_Data_Validation_08_AUG`\n" +
                    "WHERE corrected_domain NOT IN (\n" +
                    "SELECT  domain_name FROM dev_growth_enabler_ui.`company_profile` \n" +
                    "WHERE  source = 'EXCEL_ANALYST' OR ((source='cb'  OR source IS NULL OR source = 'angel') \n" +
                    "AND YEAR (founded_year) BETWEEN 1993 AND 2018) \n" +
                    "AND domain IS NOT NULL AND CHAR_LENGTH(TRIM(domain))>0 \n" +
                    "AND YEAR(founded_on) BETWEEN 1993 AND 2018)  ";

            String queryCountCrawler1= " SELECT count(*) FROM dev_growth_enabler_crawler.`secondary_Dinesh_Data_Validation_08_AUG`\n" +
                    "WHERE corrected_domain NOT IN (\n" +
                    "SELECT  domain_name FROM dev_growth_enabler_ui.`company_profile` \n" +
                    "WHERE  source = 'EXCEL_ANALYST' OR ((source='cb'  OR source IS NULL OR source = 'angel') \n" +
                    "AND YEAR (founded_year) BETWEEN 1993 AND 2018) \n" +
                    "AND domain IS NOT NULL AND CHAR_LENGTH(TRIM(domain))>0 \n" +
                    "AND YEAR(founded_on) BETWEEN 1993 AND 2018)  ";

            String queryCrawlerCondition2="SELECT company_name,domain,primary_role,founded_on,funding_rounds,email,phone,employee_count,\n" +
                    "                                       facebook_url,linkedin_url,twitter_url,short_description,homepage_url\n" +
                    "                                        FROM dev_growth_enabler_crawler.`secondary_dinesh_data_validation_08_aug` WHERE  \n" +
                    "                                        domain NOT IN (\n" +
                    "      SELECT  domain_name FROM dev_growth_enabler_ui.`company_profile` \n" +
                    "                    WHERE  source = 'EXCEL_ANALYST' OR (source='cb'  OR source IS NULL OR source = 'angel')  \n" +
                    "                    AND company_category LIKE \"STARTUP\" AND(YEAR(founded_year)='0000' AND TOTAL_FUNDING_ROUNDS!='0'))\n" +
                    "                      AND domain IS NOT NULL AND CHAR_LENGTH(TRIM(domain))>0 \n" +
                    "                      AND  YEAR (founded_on)='0000' AND funding_rounds !='0'";

            String queryCountCrawler2= "SELECT count(*) FROM dev_growth_enabler_crawler.`secondary_dinesh_data_validation_08_aug` WHERE  \n" +
                    "                                        domain NOT IN (\n" +
                    "      SELECT  domain_name FROM dev_growth_enabler_ui.`company_profile` \n" +
                    "                    WHERE  source = 'EXCEL_ANALYST' OR (source='cb'  OR source IS NULL OR source = 'angel')  \n" +
                    "                    AND company_category LIKE \"STARTUP\" AND(YEAR(founded_year)='0000' AND TOTAL_FUNDING_ROUNDS!='0'))\n" +
                    "                      AND domain IS NOT NULL AND CHAR_LENGTH(TRIM(domain))>0 \n" +
                    "                      AND  YEAR (founded_on)='0000' AND funding_rounds !='0'";


            stmtUICondition1 = connUI.createStatement();
            stmtCrawler=connCrawler.createStatement();

            resultSetCrawlerCondition1 = stmtCrawler.executeQuery(queryCondition1);
            System.out.println("The company listed for condition(1993 to 2018)");
            System.out.println("------------------------------------------------------------------------------");
            while(resultSetCrawlerCondition1.next())
            {
                companyNameCrawler=resultSetCrawlerCondition1.getString("company_name");
                domainNameCrawler=resultSetCrawlerCondition1.getString("domain");
                foundedYearCrawler=resultSetCrawlerCondition1.getString("founded_on");

                System.out.println(companyNameCrawler+"\t"+domainNameCrawler+"\t"+foundedYearCrawler);
            }
            resultSetCrawlerCondition2=stmtCrawler.executeQuery(queryCrawlerCondition2);
            System.out.println("The companies listed for condition(0000 and funding round >0)");

            System.out.println("-------------------------------------------------------------------------------------");

            while(resultSetCrawlerCondition2.next())
            {
                companyNameCrawler=resultSetCrawlerCondition2.getString("company_name");
                domainNameCrawler=resultSetCrawlerCondition2.getString("domain");
                foundedYearCrawler=resultSetCrawlerCondition2.getString("founded_on");

                System.out.println(companyNameCrawler+"\t"+domainNameCrawler+"\t"+foundedYearCrawler);
            }


            stmtCrawler = connCrawler.createStatement();
            resultSetCrawlerCount1 = stmtCrawler.executeQuery(queryCountCrawler1);
            int crawlerCount1=0;

            while(resultSetCrawlerCount1.next())
            {
                crawlerCount1=resultSetCrawlerCount1.getInt(1);
                System.out.println("The total count Crawler (Founded Year -1993-2018)---->" + crawlerCount1);
            }

            stmtCrawler = connCrawler.createStatement();
            resultSetCrawlerCount2 = stmtCrawler.executeQuery(queryCountCrawler2);
            int crawlerCount2=0;

            while(resultSetCrawlerCount2.next())
            {
                crawlerCount2=resultSetCrawlerCount2.getInt(1);
                System.out.println("The total count Crawler (Founded year -0000 and funding rounds not equal to zero)---->" + crawlerCount2);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        finally
        {
            try {
                if(connUI==null){
                    connUI.close();

                }
                if(connCrawler==null) {
                    connCrawler.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
