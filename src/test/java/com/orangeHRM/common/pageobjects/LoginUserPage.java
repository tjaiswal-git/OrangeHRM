package com.orangeHRM.common.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginUserPage 
{
	WebDriver driver;
	public static final Logger logger=Logger.getLogger(LoginUserPage.class.getName());
	
	@FindBy(id="txtUsername")
	WebElement userLoginName;
	
	@FindBy(id="txtPassword")
	WebElement userLoginPass;
	
	@FindBy(id="btnLogin")
	WebElement userLoginBtn;
	
	@FindBy(xpath=".//*[@id='menu_leave_viewLeaveModule']/b")
	WebElement leaveModule;
	
	@FindBy(xpath=".//*[@id='menu_leave_applyLeave']")
	WebElement applyLeaveBtn;
	
	@FindBy(xpath=".//*[@id='apply-leave']/div[1]/h1")
	WebElement applyLeaveText;
	
	@FindBy(id="applyleave_txtLeaveType")
	WebElement selLeaveType;
	
	@FindBy(xpath=".//*[@id='frmLeaveApply']/fieldset/ol/li[3]/img")
	WebElement calenderStartMonth;
	
	@FindBy(xpath=".//*[@id='frmLeaveApply']/fieldset/ol/li[4]/img")
	WebElement calenderEndMonth;
	
	@FindBy(xpath=".//*[@id='ui-datepicker-div']/table/tbody/tr[1]/td[4]/a")
	WebElement startDate;
	
	@FindBy(xpath=".//*[@id='ui-datepicker-div']/table/tbody/tr[1]/td[4]/a")
	WebElement endDate;
	
	@FindBy(id="applyBtn")
	WebElement applyBtn;
	
	@FindBy(id="welcome")
	WebElement welcomeMenu;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logoutUser;
	
	@FindBy(xpath="//span[text()='My Leave']")
	WebElement myLeaveUser;
	
	@FindBy(xpath="//a[text()='Scheduled(1.00)']")
	WebElement scheduledLeaveUser;
	
	public LoginUserPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	public void loginWithUserCredentials(String userName,String userPass) throws InterruptedException
	
	{
		userLoginName.clear();
		userLoginName.sendKeys(userName);
		userLoginPass.clear();
		userLoginPass.sendKeys(userPass);
		Thread.sleep(2000);
		userLoginBtn.click();
		logger.info("user is successfully login..");
		}
	
	 public void userLeaveDetails() throws InterruptedException
	 {      Thread.sleep(1500);
	        //String textt=ApplyLeaveHeaderText(); 
	        leaveModule.click();
			logger.info("leave module btn is clicked....");
			Thread.sleep(1000);
			applyLeaveBtn.click();
			logger.info("Apply leave btn is clicked..");
			
	        Select select=new Select(selLeaveType);
			select.selectByVisibleText("Vacation US");
			calenderStartMonth.click();
			startDate.click();
			logger.info("String date is selected.. "+startDate.getText());
			//calenderEndMonth.click();
			//endDate.click();
		//	logger.info("Ending date is selected.. "+endDate.getText());
			
	 
	 }
	
	public void logoutUserAcc() throws InterruptedException
	{
		Thread.sleep(2000);
		welcomeMenu.click();
		Thread.sleep(2000);
		logoutUser.click();
		logger.info("User has successfully logout from session...");
		
	}
	
	public String ApplyLeaveHeaderText() throws InterruptedException
	{ 
		Thread.sleep(3000);
		String applyLeavespanText=applyLeaveText.getText();
		logger.info("Apply leave header text has returned "+applyLeavespanText);
		Thread.sleep(4000);
		applyBtn.click();
		logger.info("Apply btn pressing...");
		return applyLeavespanText;
		
	}
	
	public void myLeaveBtn() throws InterruptedException
	{
		Thread.sleep(2000);
		myLeaveUser.click();
		logger.info("leave btn has clicked.. on user side..");
	}
	
	public String myLeaveApproval_For_User() throws InterruptedException
	{   Thread.sleep(2000);
		String scheduledLeaveText=scheduledLeaveUser.getText();
		logger.info("Scheduled leave has passed..");
		return scheduledLeaveText;
		
	}
}
