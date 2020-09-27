package sdet.assign.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import sdet.assign.util.TestUtil;

public class TestBase {
	
	protected static Properties prop;
	protected static WebDriver driver;
		
	protected TestBase(){
		
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/sdet/assign/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialize(){

		String browserNm=prop.getProperty("browser");
		
		if(browserNm.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\KumariRupam\\eclipse-workspace\\SDET\\sdet-assignment-1\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserNm.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\KumariRupam\\eclipse-workspace\\SDET\\sdet-assignment-1\\src\\main\\resources\\geckodriver-v0.27.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		
	}
	
	public String getTitle() {
		return driver.getTitle();		
	}
	
	

}
