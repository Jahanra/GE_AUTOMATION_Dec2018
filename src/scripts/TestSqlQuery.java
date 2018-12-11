package scripts;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseTest;

public class TestSqlQuery extends BaseTest
{
 @Test
 public void runRegisterQuery() throws SQLException
 {
	 try {
		 
	 
	 Statement stmt = conn.createStatement();
	 String query="select * from jhi_user where email='jahan05@sismedical.com'";
	
	ResultSet rs= stmt.executeQuery(query);
	Reporter.log("-----------------------sismedical-----------------",true);
	    while (rs.next())
	    {
         Reporter.log(rs.getString("login"),true);
         Reporter.log(rs.getString("user_category"),true);
         Reporter.log(rs.getString("user_company_id"),true);
         Reporter.log(rs.getString("expiry_date"),true);
         Reporter.log(rs.getString("promo_code_id"),true);
 }
	    Statement stmt1=conn.createStatement();
	    String query1="select * from jhi_user where email='jahan05@tangoe.com'";
	    ResultSet rs1=stmt1.executeQuery(query1);
	    Reporter.log("-----------------------tangoe-----------------",true);
	    while(rs1.next())
	    {
	    	Reporter.log(rs1.getString("login"),true);
	         Reporter.log(rs1.getString("user_category"),true);
	         Reporter.log(rs1.getString("user_company_id"),true);
	         Reporter.log(rs1.getString("expiry_date"),true);
	         Reporter.log(rs1.getString("promo_code_id"),true);
	    }
	    
	    Statement stmt2=conn.createStatement();
	    String query2="select * from jhi_user where email='jahan05@gepii05.com'";
	    ResultSet rs2=stmt2.executeQuery(query2);
	    Reporter.log("-----------------------gepii05-----------------",true);
	    while(rs2.next())
	    {
	    	Reporter.log(rs2.getString("login"),true);
	         Reporter.log(rs2.getString("user_category"),true);
	         Reporter.log(rs2.getString("user_company_id"),true);
	         Reporter.log(rs2.getString("expiry_date"),true);
	         Reporter.log(rs2.getString("promo_code_id"),true);
	    }
	      
	  
	    Statement stmt3=conn.createStatement();
	    String query3="select * from jhi_user where email='jahan05@tangoeStar05.com'";
	    ResultSet rs3=stmt3.executeQuery(query3);
	    while(rs3.next())
	    {
	    	Reporter.log(rs3.getString("login"),true);
	         Reporter.log(rs3.getString("user_category"),true);
	         Reporter.log(rs3.getString("user_company_id"),true);
	         Reporter.log(rs3.getString("expiry_date"),true);
	         Reporter.log(rs3.getString("promo_code_id"),true);
	    }
	    
	    Statement stmt4=conn.createStatement();
	    String query4="select * from jhi_user where email='jahan05@naborly.com'";
	    ResultSet rs4=stmt4.executeQuery(query4);
	    Reporter.log("-----------------------naborly-----------------",true);
	    while(rs4.next())
	    {
	    	Reporter.log(rs4.getString("login"),true);
	         Reporter.log(rs4.getString("user_category"),true);
	         Reporter.log(rs4.getString("user_company_id"),true);
	         Reporter.log(rs4.getString("expiry_date"),true);
	         Reporter.log(rs4.getString("promo_code_id"),true);
	    }
	    Statement stmt5=conn.createStatement();
	    String query5="select * from jhi_user where email='jahanra@startupTest05.com'";
	    ResultSet rs5=stmt5.executeQuery(query5);
	    Reporter.log("-----------------------startupTest05-----------------",true);
	    while(rs5.next())
	    {
	    	
	    	Reporter.log(rs5.getString("login"),true);
	         Reporter.log(rs5.getString("user_category"),true);
	         Reporter.log(rs5.getString("user_company_id"),true);
	         Reporter.log(rs5.getString("expiry_date"),true);
	         Reporter.log(rs5.getString("promo_code_id"),true);
	    }
 
	    Statement stmt6=conn.createStatement();
	    String query6="Select user_company_id from jhi_user where email='jahanra@startupTest05.com'";
	    ResultSet rs6=stmt6.executeQuery(query6);
	    String company_id = null;
	    while(rs6.next())
	    {
	    	Reporter.log("get the user company id from jhi_user",true);
	        company_id=rs6.getString("user_company_id");
	    	Reporter.log(company_id,true);
	    }
	    Statement stmt7=conn.createStatement();
	    String query7="SELECT id FROM `company_profile` WHERE company_name='startupTest05'";
	    ResultSet rs7=stmt7.executeQuery(query7);
	    String id = null;
	    while(rs7.next())
	    {
	    	Reporter.log("get the company id from company_profile",true);
	    	id=rs7.getString("id");
	    			Reporter.log(id,true);
	    }
 if(company_id.equals(id))
 {
	 Reporter.log("Company exists in company_profile table",true);
 }
        
}
 catch(SQLException e)
	 {
	 e.printStackTrace();
 }
	 Statement stmt8=conn.createStatement();
	 String query8="SELECT expiry_date FROM jhi_user WHERE login='jahan05@tangoestar05.com'"; 
	 ResultSet rs8=stmt8.executeQuery(query8);
	 Date expirydate=null;
	 while(rs8.next())
	 {
		 Reporter.log("get the expiry date",true);
		 expirydate=rs8.getDate("expiry_date");
		 System.out.println(expirydate);
	 }
	 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
     LocalDate now = LocalDate.now();
     System.out.println("Current Date:" + now );
     String currentDate=dtf.format(now);
     System.out.println(currentDate);
     LocalDate ps = LocalDate.now().plusDays(14);
     System.out.println("diff is "+ ps);
     java.util.Date psDate = java.sql.Date.valueOf(ps);
     if(expirydate.compareTo(psDate)==0) {
     System.out.println("Expiry date is correct.....!!!! : " + psDate);
     }
     /*else
     {
    	 System.out.println("Expiry date is wrong....!!!!");
     }*/
}
}
