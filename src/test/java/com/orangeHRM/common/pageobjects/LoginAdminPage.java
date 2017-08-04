package com.orangeHRM.common.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

public class LoginAdminPage
{
    WebDriver driver;
	public static final Logger logger=Logger.getLogger(LoginAdminPage.class.getName());
	
	@FindBy(id="txtUsername")
	WebElement adminUserName;
	
	@FindBy(id="txtPassword")
	WebElement adminPass;
	
	@FindBy(id="btnLogin")
	WebElement btnLogin;
	
	@FindBy(xpath=".//*[@id='menu_pim_viewPimModule']/b")
	WebElement pimObject;
	
	@FindBy(id="menu_pim_addEmployee")
	WebElement addEmployee;
	
	@FindBy(xpath=".//*[@id='content']/div/div[1]/h1")
	WebElement addEmpText;
	
	@FindBy(id="firstName")
	WebElement Addfirstname;
	
	@FindBy(id="lastName")
	WebElement AddlastName;
	
	@FindBy(id="chkLogin")
	WebElement checkLogincheckBox;
	
	@FindBy(id="btnSave")
	WebElement btnSaveLoginDetails;

	@FindBy(id="user_name")
	WebElement accUserName;
	
	@FindBy(id="user_password")
	WebElement accUserPassword;
	
	@FindBy(id="re_password")
	WebElement accRePassword;
	
	@FindBy(xpath=".//*[@id='menu_leave_viewLeaveModule']/b")
	WebElement leaveBtn;
	
	@FindBy(id="menu_leave_Entitlements")
	WebElement HovermenuLeaveEntitlement;
	
	@FindBy(id="menu_leave_addLeaveEntitlement")
	WebElement addleave_entitlements;
	
	@FindBy(id="entitlements_employee_empName")
	WebElement entitlementsEmpName;
	
	@FindBy(id="entitlements_leave_type")
	WebElement selentitlementsLeave;
	
	@FindBy(id="entitlements_entitlement")
	WebElement entitlementsValue; 
	
	@FindBy(xpath="html/body/div[4]/ul/li[1]")
	WebElement selfullEmpName;
	
	@FindBy(xpath=".//*[@id='welcome']")
	WebElement logoutMenu;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logout;
	
	@FindBy(xpath=".//*[@id='menu_leave_viewLeaveList']")
	WebElement leaveList;
	
	@FindBy(xpath="//select[starts-with(@id, 'select_leave')]")
	WebElement leaveActionID;
	

    @FindBy(id="select_leave_action_4")
	WebElement selLeaveAction;
	
	
	
	
	public LoginAdminPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void adminLogin(String adminUser,String adminPass) throws InterruptedException
	{
		adminUserName.clear();
		adminUserName.sendKeys(adminUser);
		logger.info("Admin User Name is entered "+adminUser);
		this.adminPass.clear();
		this.adminPass.sendKeys(adminPass);
		logger.info("Admin password is Entered "+adminPass);
		Thread.sleep(2000);
		btnLogin.click();
		logger.info("Admin login is success...");
		
	}
	
	public void addEmpHeadVerify() throws InterruptedException
	{

		Thread.sleep(1000);
		pimObject.click();
		Thread.sleep(1000);
		addEmployee.click();
		logger.info("add employee option is clicked.." +addEmployee.toString());
	}
	
	public void addEmployeeOption(String firstName,String lastName,String accUserName,String accUserPass,String accRePass) throws InterruptedException
	{  
		Thread.sleep(1500);
		Addfirstname.sendKeys(firstName);
		logger.info("first name is entered.." +Addfirstname.toString());
		Thread.sleep(1500);
		AddlastName.sendKeys(lastName);
		logger.info("last name is entered.."+AddlastName.toString());
		Thread.sleep(1500);
		checkLogincheckBox.click();
		logger.info("check login box.. "+checkLogincheckBox.toString());
		Thread.sleep(1500);
	    this.accUserName.sendKeys(accUserName);
	    logger.info("accUserName is entered.." +accUserName.toString());
		Thread.sleep(1500);
		this.accUserPassword.sendKeys(accUserPass);
		logger.info("accPassword is entered.. "+accUserPassword.toString());
		this.accRePassword.sendKeys(accRePass);
		logger.info("acc confirm password is entered.. "+accRePassword.toString());
		Thread.sleep(1500);
	    btnSaveLoginDetails.click();
		logger.info("Add Employee login details has benn saved.. "+btnSaveLoginDetails.toString());
		Thread.sleep(2500);
	}
	
	public void addLeaveEntitlements(String empName,String value) throws InterruptedException
	{  try{
		Thread.sleep(2000);
		leaveBtn.click();
		Thread.sleep(1500);
		
		Actions builder = new Actions(driver);
		builder.moveToElement(HovermenuLeaveEntitlement).perform();
		logger.info("Hover option has come of by mouse.. "+HovermenuLeaveEntitlement.toString());
		By locator = By.id("menu_leave_addLeaveEntitlement");
		driver.findElement(locator).click(); 
	    logger.info("add leave entitlement option is clicked "+locator.toString());
		Thread.sleep(3000);
	    //entitlementsEmpName.clear();
        Thread.sleep(2000);
       // entitlementsEmpName.clear();
        entitlementsEmpName.sendKeys(empName);
        selfullEmpName.click();
        //entitlementsEmpName.click();
        logger.info("EmpName has entered..");
        Thread.sleep(2000);
		Select select=new Select(selentitlementsLeave);
		select.selectByVisibleText("Vacation US");
		//entitlementsValue.clear();
		Thread.sleep(3000);
		entitlementsValue.sendKeys(value);
		logger.info("Entitlement value has entered.. "+entitlementsValue.toString());
		Thread.sleep(3000);
		btnSaveLoginDetails.click();
		logger.info("Save btn is clicked..." +btnSaveLoginDetails.toString());
		Thread.sleep(5000);
		logoutMenu.click();
		Thread.sleep(2000);
		logout.click();
		logger.info("logout has been successfully done.. "+logout.toString());
	}
	
	catch (ElementNotInteractableException e) {
		e.printStackTrace();
		logger.info("Exception isfound for element not found "+e.getMessage());
		// TODO: handle exception
	}
	}
	
	public String addEmployeeText()
	{
		String addempText=addEmpText.getText();
		logger.info("addEmployee assert has sent "+addempText);
		return addempText;
	}
	
	public void leaveApproveByAdmin() throws InterruptedException
	{   
		try{
		Thread.sleep(2000);
		leaveBtn.click();
		logger.info("leave module btn is clicked.. "+leaveBtn.toString());
		Thread.sleep(1000);
	    leaveList.click();
		logger.info("leave list has clicked.. "+leaveList.toString());
		Thread.sleep(1500);
		Select select=new Select(leaveActionID);
		select.selectByVisibleText("Approve");
		Thread.sleep(1500);
		btnSaveLoginDetails.click();
		logger.info("leave Approlaval btn has clicked.. "+btnSaveLoginDetails.toString());
		}
		catch (ElementNotFoundException e) {
			// TODO: handle exception
			logger.info("Element is able to found excepton "+e.getMessage());
		}
	}
	
	public void logoutByAdmin() throws InterruptedException
	{  
		Thread.sleep(2000);
		logoutMenu.click();
		Thread.sleep(1000);
		logout.click();
		logger.info("Admin has successfully logout.. "+logout.toString());
	}
}
