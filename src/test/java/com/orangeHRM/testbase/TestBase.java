package com.orangeHRM.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


public class TestBase 
{
	public WebDriver driver;
	//String URL="";
	String browser="firefox";
	
	
	public static final Logger logger=Logger.getLogger(TestBase.class.getName());
    public void init(String URL)
	{
		selectBrowser(browser);
		
		PropertyConfigurator.configure("Configuration//Log4j.properties");
		getURL(URL);
	}
	
    
    
    public Properties getProp()
    {
        File file = new File("Configuration//prop.properties");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Properties properties = new Properties();
        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
    
    
    public void selectBrowser(String browser)
	
    {
	  if(browser.equalsIgnoreCase("firefox"))
	  {
		    FirefoxProfile profile = new FirefoxProfile();
	        profile.setPreference("browser.download.folderList", 2);
	        profile.setPreference("browser.download.manager.showWhenStarting", false);
	        
	        profile.setPreference("browser.helperApps.neverAsk.openFile",
	                "text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
	        profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
	                "text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
	        profile.setPreference("browser.helperApps.alwaysAsk.force", false);
	        profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
	        profile.setPreference("browser.download.manager.focusWhenStarting", false);
	        profile.setPreference("browser.download.manager.useWindow", false);
	        profile.setPreference("browser.download.manager.showAlertOnComplete", false);
	        profile.setPreference("browser.download.manager.closeWhenDone", false);

	        DesiredCapabilities ds = new DesiredCapabilities().firefox();
	        ds.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	        ds.setCapability(FirefoxDriver.PROFILE, profile);


	         // this is the important line - i.e. don't use Marionette
	        ds.setCapability(FirefoxDriver.MARIONETTE, false);

	        driver = new FirefoxDriver(ds);
	        System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
	        logger.info("Firefox has launching...");
		  
	  }
	
		
	}
	
	public void getURL(String URL)
	{
		driver.get(URL);
		logger.info("url has lauching..");
		driver.manage().window().maximize();
		logger.info("Now Browser is maximize...");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		logger.info("Page loading.....");
	}

	
}