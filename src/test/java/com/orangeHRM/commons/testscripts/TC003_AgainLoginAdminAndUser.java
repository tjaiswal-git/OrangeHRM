package com.orangeHRM.commons.testscripts;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.orangeHRM.common.pageobjects.LoginAdminPage;
import com.orangeHRM.common.pageobjects.LoginUserPage;
import com.orangeHRM.testbase.TestBase;

public class TC003_AgainLoginAdminAndUser extends TestBase
{
	LoginAdminPage loginAdminPage;
	LoginUserPage loginuserPage;
	
	@BeforeTest
	public void setUp()
	{   
		Properties properties=getProp();
	    String URL=properties.getProperty("URL");
		init(URL);
	}
	
	@Test(priority=1) 
	 public void verifyAdminLogin() throws InterruptedException
	 {  
		Properties properties=getProp();
		String userName=properties.getProperty("AdminLogin");
		String password=properties.getProperty("Adminpwd");
		loginAdminPage=new LoginAdminPage(driver);
		loginAdminPage.adminLogin(userName, password);
		
		//logger.info("Logout has successfully done from UserAccount!!");
	}
	@Test(priority=2)
    public void verifyApprovalByAdmin() throws InterruptedException
    {  
		loginAdminPage=new LoginAdminPage(driver);
		loginAdminPage.leaveApproveByAdmin();
		loginAdminPage.logoutByAdmin();
    }
	
	@Test(priority=3)
	public void verifyApproavlByUser() throws InterruptedException
	{
		Properties properties=getProp();
		String userName=properties.getProperty("userLogin");
		String password=properties.getProperty("userPdw");
		
		loginuserPage=new LoginUserPage(driver);
		loginuserPage.loginWithUserCredentials(userName, password);
		loginuserPage.myLeaveBtn();
		Assert.assertEquals(loginuserPage.myLeaveApproval_For_User(), "Scheduled(1.00)");
		
	
	}
	@AfterTest
	public void closeDriver()
	{
		driver.close();
	}
	
}
