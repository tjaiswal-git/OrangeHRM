package com.orangeHRM.commons.testscripts;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import com.orangeHRM.common.pageobjects.LoginUserPage;
import com.orangeHRM.testbase.TestBase;

public class TC002_VerifyUserLoginCredentials extends TestBase
{
    LoginUserPage loginuserPage;
    @BeforeTest
	public void setUp()
	{   
		Properties properties=getProp();
	    String URL=properties.getProperty("URL");
		init(URL);
	}
	
	@Test(priority=1) 
	 public void verifyUserLoginWithCreadentials() throws InterruptedException
	 {  
		Properties properties=getProp();
		String userName=properties.getProperty("userLogin");
		String password=properties.getProperty("userPdw");
		loginuserPage=new LoginUserPage(driver);
        loginuserPage.loginWithUserCredentials(userName, password);
        loginuserPage.userLeaveDetails();
        //loginuserPage.ApplyLeaveHeaderText();
        
        Assert.assertEquals(loginuserPage.ApplyLeaveHeaderText(), "Apply Leave");
        
		
		loginuserPage.logoutUserAcc();
		logger.info("Logout has successfully done from UserAccount!!");
	
	 }
	 
	@AfterTest
	public void closeDriver()
	{
		driver.close();
	}
}
