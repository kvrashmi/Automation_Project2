package util;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	private static WebDriver driver;
	static String browser="";
	static String url="";
	static String browser_driver_key="";
	static String browser_driver_path="";
	
	
	public static String getTypeOfOperatingSystem()
	{
		return System.getProperty("os.name");
	}

	public static WebDriver init()
	{
		String operatingSystem = BrowserFactory.getTypeOfOperatingSystem();
		//System.out.println(operatingSystem.indexOf("Mac"));
		ConfigFileReader pfh = new ConfigFileReader();
		Map<String,String> configFileProps=pfh.getPropertiesFileContents();
		browser=configFileProps.get("browser");
		url=configFileProps.get("url");
		if(operatingSystem.indexOf("Mac")>=0)
		{
			if(browser.equalsIgnoreCase("chrome")) 
			{
				browser_driver_key=configFileProps.get("chrome_driver_key");
				browser_driver_path=configFileProps.get("mac_chrome_driver_path");
				System.setProperty(browser_driver_key, browser_driver_path);	
				driver= new ChromeDriver();
				
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				browser_driver_key=configFileProps.get("firefox_driver_key");
				browser_driver_path=configFileProps.get("mac_firefox_driver_path");
				System.setProperty(browser_driver_key, browser_driver_path);	
				driver= new FirefoxDriver();
			}
		}
		else
		{
			if(browser.equalsIgnoreCase("chrome")) 
			{
				browser_driver_key=configFileProps.get("chrome_driver_key");
				browser_driver_path=configFileProps.get("win_chrome_driver_path");
				System.setProperty(browser_driver_key, browser_driver_path);	
				driver= new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				browser_driver_key=configFileProps.get("firefox_driver_key");
				browser_driver_path=configFileProps.get("win_firefox_driver_path");
				System.setProperty(browser_driver_key, browser_driver_path);	
				driver= new FirefoxDriver();
			}
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		return driver;
		
	}
	
	public static void tearDown()
	{
		driver.close();
		driver.quit();
	}
	
	
	//Testing this class
	/* 
	public static void main(String[] args)
	{
		System.out.println(System.getProperty("os.name"));
		init();	
	}
	*/
}
