package rough;

import com.google.gson.internal.bind.SqlDateTypeAdapter;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.sql.*;


public class testdb {
    @Test
    public void testdbconn() throws ClassNotFoundException {

        // Initialize connection variables.
        String host = "nthdim10.alloy.ee";
        String databaseUi = "dev_growth_enabler_ui";
        String databaseCrawler = "dev_growth_enabler_crawler";
        String username = "Growthenabler";
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

        List<String> results=new ArrayList<String>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }


        System.out.println("MySQL JDBC driver detected in library path.");

        // Initialize connection object
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

            String queryCrawlerCondition1= "SELECT company_name,domain,primary_role,founded_on,funding_rounds,email,phone,employee_count,\n" +
                    "                    facebook_url,linkedin_url,twitter_url,short_description,homepage_url\n" +
                    "                    FROM `secondary_dinesh_data_validation_08_aug`\n" +
                    "                     WHERE (primary_role LIKE 'company' AND \n" +
                    "                     ( domain IS NOT NULL AND CHAR_LENGTH(TRIM(domain))>0 ))\n" +
                    "                     AND YEAR(founded_on) BETWEEN 1993 AND 2018 ";

            String queryCrawlerCondition2="SELECT company_name,domain,primary_role,founded_on,funding_rounds,email,phone,employee_count,\n" +
                    "facebook_url,linkedin_url,twitter_url,short_description,homepage_url\n" +
                    "FROM `cb_csv_tbl_organizations` WHERE primary_role LIKE 'company' AND \n" +
                    "                     ( domain IS NOT NULL AND CHAR_LENGTH(TRIM(domain))>0 )\n" +
                    " AND (YEAR (founded_on)='0000' AND funding_rounds !='0')";

            String queryUICondition1="SELECT  id,company_name,company_url,domain_name,founded_year,team_size,email,short_description,linkedin,facebook,\n" +
                    "twitter,source,TOTAL_FUNDING_ROUNDS FROM `company_profile` \n" +
                    "WHERE source='cb' AND YEAR (founded_year) BETWEEN 1993 AND 2018 ";

            String queryUICondition2="SELECT id,company_name,company_url,domain_name,founded_year,team_size,email,short_description,linkedin,facebook,\n" +
                    "twitter,source ,TOTAL_FUNDING_ROUNDS FROM company_profile WHERE \n" +
                    "source='cb' AND (YEAR(founded_year)='0000' AND TOTAL_FUNDING_ROUNDS!='0')";

            String queryCountCrawler1="SELECT COUNT(*)FROM `cb_csv_tbl_organizations` WHERE\n" +
                    "(primary_role LIKE 'company' AND \n" +
                    "                     ( domain IS NOT NULL AND CHAR_LENGTH(TRIM(domain))>0))\n" +
                    "                     AND YEAR(founded_on) BETWEEN 1993 AND 2018\n";

            String queryCountCrawler2="SELECT COUNT(*) FROM cb_csv_tbl_organizations  WHERE (primary_role LIKE 'company' AND \n" +
                    "                     (domain IS NOT NULL AND CHAR_LENGTH(TRIM(domain))>0 ))" +
                    " AND YEAR (founded_on)='0000' AND funding_rounds !='0'";

            String queryCountUI1="SELECT  COUNT(*) FROM `company_profile` WHERE \n"+
              " source='cb' AND (YEAR (founded_year) BETWEEN 1993 AND 2018) ";
            String querCountUI2="SELECT  COUNT(*) FROM company_profile WHERE \n" +
                    "source='cb' AND (YEAR(founded_year)='0000' AND TOTAL_FUNDING_ROUNDS!='0')";

            // get connection
            connUI = DriverManager.getConnection(dbUrlUI, properties);
            stmtUICondition1 = connUI.createStatement();
            resultSetUICondition1 = stmtUICondition1.executeQuery(queryUICondition1);



            String dbUrlCrawler = String.format("jdbc:mysql://%s/%s", host, databaseCrawler);

            // get connection
                connCrawler = DriverManager.getConnection(dbUrlCrawler, properties);
            stmtCrawler = connCrawler.createStatement();
            resultSetCrawlerCondition1 = stmtCrawler.executeQuery(queryCrawlerCondition1);



            System.out.println("----------------------------------companies exists Crawler for condition (Founded Year -1993 to 2018)-----------------------------------");
            System.out.println("Company Name"+"\t\t\t"+"Domain Name");
            System.out.println("---------------------------------------------------------------------");

            while (resultSetUICondition1.next() && resultSetCrawlerCondition1.next())
            {
                companyNameUI=  resultSetUICondition1.getString("company_name");
                companyNameCrawler=resultSetCrawlerCondition1.getString("company_name");
                domainNameUI=resultSetUICondition1.getString("domain_name");
                domainNameCrawler=resultSetCrawlerCondition1.getString("domain");
                emailUI=resultSetUICondition1.getString("email");
                emailCrawler=resultSetCrawlerCondition1.getString("email");
                foundedYearUI=resultSetUICondition1.getString("founded_year");
                foundedYearCrawler=resultSetCrawlerCondition1.getString("founded_on");
                websiteUI=resultSetUICondition1.getString("company_url");
                websiteCrawler=resultSetCrawlerCondition1.getString("homepage_url");
                teamSizeUI=resultSetUICondition1.getString("team_size");
                teamSizeCrawler=resultSetCrawlerCondition1.getString("employee_count");
                shortDescUI=resultSetUICondition1.getString("short_description");
                shortDescCrawler=resultSetCrawlerCondition1.getString("short_description");
                facebookUI=resultSetUICondition1.getString("facebook");
                facebookCrawler=resultSetCrawlerCondition1.getString("facebook_url");
                linkedInUI=resultSetUICondition1.getString("linkedin");
                linkedInCrawler=resultSetCrawlerCondition1.getString("linkedin_url");
                twitterUI=resultSetUICondition1.getString("twitter");
                twitterCrawler=resultSetCrawlerCondition1.getString("twitter_url");

                /*phoneUI=resultSetUICondition1.getString("");*/
                phoneCrawler=resultSetCrawlerCondition1.getString("phone");


                if (((companyNameCrawler.length()!=companyNameUI.length())
                        &&!(companyNameCrawler.equalsIgnoreCase(companyNameUI))) && ((domainNameCrawler.length()
                          !=domainNameUI.length())&&!(domainNameCrawler.equalsIgnoreCase(domainNameUI))))
                       /* && ((foundedYearUI.substring(0,4)) .equals(foundedYearCrawler.substring(0,4)))
                        &&websiteUI.contains(websiteCrawler)&& teamSizeUI.contains(teamSizeCrawler)&&facebookUI.contains(facebookCrawler)&&linkedInUI.contains(linkedInCrawler)
                        &&twitterUI.contains(twitterCrawler) && shortDescUI.equalsIgnoreCase(shortDescCrawler) && emailUI.equalsIgnoreCase(emailCrawler)*/
                {
                    System.out.println(companyNameCrawler+"\t"+domainNameCrawler+"\t"+foundedYearCrawler);

                }

               else {

                    System.out.println("UI Data condition 1");
                }
            }

            // get connection
            connUI = DriverManager.getConnection(dbUrlUI, properties);
            stmtUICondition2 = connUI.createStatement();
            resultSetUICondition2 = stmtUICondition2.executeQuery(queryUICondition2);

            connCrawler = DriverManager.getConnection(dbUrlCrawler, properties);
            stmtCrawler = connCrawler.createStatement();
            resultSetCrawlerCondition2 = stmtCrawler.executeQuery(queryCrawlerCondition2);



            System.out.println("----------------------------------companies exists Crawler for condition (Founded Year - 0000 and Funding round not equal to 0)-----------------------------------");
            System.out.println("Company Name"+"\t\t\t"+"Domain Name");
            System.out.println("---------------------------------------------------------------------");

            while (resultSetUICondition2.next() && resultSetCrawlerCondition2.next())
            {
                companyNameUI=  resultSetUICondition2.getString("company_name");
                companyNameCrawler=resultSetCrawlerCondition2.getString("company_name");
                domainNameUI=resultSetUICondition2.getString("domain_name");
                domainNameCrawler=resultSetCrawlerCondition2.getString("domain");
                emailUI=resultSetUICondition2.getString("email");
                emailCrawler=resultSetCrawlerCondition2.getString("email");
                foundedYearUI=resultSetUICondition2.getString("founded_year");
                foundedYearCrawler=resultSetCrawlerCondition2.getString("founded_on");
                websiteUI=resultSetUICondition2.getString("company_url");
                websiteCrawler=resultSetCrawlerCondition2.getString("homepage_url");
                teamSizeUI=resultSetUICondition2.getString("team_size");
                teamSizeCrawler=resultSetCrawlerCondition2.getString("employee_count");
                shortDescUI=resultSetUICondition2.getString("short_description");
                shortDescCrawler=resultSetCrawlerCondition2.getString("short_description");
                facebookUI=resultSetUICondition2.getString("facebook");
                facebookCrawler=resultSetCrawlerCondition2.getString("facebook_url");
                linkedInUI=resultSetUICondition2.getString("linkedin");
                linkedInCrawler=resultSetCrawlerCondition2.getString("linkedin_url");
                twitterUI=resultSetUICondition2.getString("twitter");
                twitterCrawler=resultSetCrawlerCondition2.getString("twitter_url");

                /*phoneUI=resultSetUICondition1.getString("");*/
                phoneCrawler=resultSetCrawlerCondition2.getString("phone");



                if (companyNameCrawler.equalsIgnoreCase(companyNameUI) && domainNameCrawler.equalsIgnoreCase(domainNameUI))
                        /*&& ((foundedYearUI.substring(0,4)) .equals(foundedYearCrawler.substring(0,4)))
                        &&websiteUI.contains(websiteCrawler)&& teamSizeUI.contains(teamSizeCrawler)&&facebookUI.contains(facebookCrawler)&&linkedInUI.contains(linkedInCrawler)
                        &&twitterUI.contains(twitterCrawler) && shortDescUI.equalsIgnoreCase(shortDescCrawler) && emailUI.equalsIgnoreCase(emailCrawler))
*/                {
                    System.out.println("UI Data condition 2");
                }

                else {

                                        System.out.println(companyNameCrawler+"\t"+domainNameCrawler+"\t"+foundedYearCrawler);

                }
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
            stmtUICondition1 = connUI.createStatement();
            resultSetUICount1 = stmtUICondition1.executeQuery(queryCountUI1);
            int uiCount1=0;

            while(resultSetUICount1.next())
            {
                uiCount1=resultSetUICount1.getInt(1);
                System.out.println("The total count UI-(Founded Year -1993-2018)---->" +uiCount1);
            }

            stmtUICondition2 = connUI.createStatement();
            resultSetUICount2 = stmtUICondition2.executeQuery(querCountUI2);
            int uiCount2=0;

            while(resultSetUICount2.next())
            {
                uiCount2=resultSetUICount2.getInt(1);
                System.out.println("The total count UI-(Founded year -0000 and funding rounds not equal to zero)---->" +uiCount2);
            }

           int diffCountUICB1=0;
            diffCountUICB1=crawlerCount1-uiCount1;
            System.out.println("The difference in count from UI and Crawler (1993-2018)--->"+diffCountUICB1);

            int diffCountUICB2=0;
            diffCountUICB2=crawlerCount2-uiCount2;
            System.out.println("The difference in count from UI and crawler (0000 and funding round not equal to 0)---->"+diffCountUICB2);

            double countDeviation1;
            double countDeviation2;

            countDeviation1=diffCountUICB1/100;
            countDeviation2=diffCountUICB2/100;

            System.out.println("The deviation for (founded year 1993-2018) is--->"+countDeviation1);
            System.out.println("The deviation for (founded year -0000-founding round !=0)---->"+countDeviation2);



        } catch (SQLException e) {
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


