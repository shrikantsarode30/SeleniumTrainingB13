package com.bymatAutomation.modulename.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.bymatAutomation.modulename.pages.HomePage;
import com.bymatautomation.seleniumtraining.DataCollection;
import com.bymatautomation.seleniumtraining.ExcelReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {       // Heart or the Engine of the framework

	public static WebDriver driver; 
	//public static String browser;  //Configuration
	public static FileInputStream fis;	
	public static Properties config;
	public static ExcelReader excel;
	public static HomePage hp;
	public static ExtentReports reports;
	public static ExtentTest test;
	public static String testCaseName;
	public static Hashtable<String, String> run_mode = new Hashtable<>();
		
	@BeforeSuite  //Before Test Case Suite Execution --350. 500, 700
	public static void setUp() {
		//FileInputStream Declaration
		try {
			fis = new FileInputStream(System.getProperty("user.dir")
			+"\\src\\test\\resources\\propertiesFiles\\Config.properties");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
		
		//Config declaration
		//Properties config = new Properties();
		
		config = new Properties();
		try {
			config.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
		System.out.println("Config file has been loaded");
		
		excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\Master_Sheet.xlsx");
		
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH__mm__ss").format(new Date());
		
		reports = new ExtentReports(System.getProperty("user.dir")+"\\src\\test\\resources\\executionReports\\ExtentReportResults_"+timeStamp+".html");
		
		loadRunModeHashtable();
}
	
	public static void getDriver() {
	
		if(config.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			ChromeOptions ops= new ChromeOptions();
			ops.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();  //Selenium 4.0  
			driver=new ChromeDriver(ops);	//Local Variable
		}
		else if(config.getProperty("browser").equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();  //Selenium 4.0
			driver=new EdgeDriver();
		}	
		else if(config.getProperty("browser").equalsIgnoreCase("FF"))
		{
			WebDriverManager.firefoxdriver().setup();  //Selenium 4.0
			driver=new FirefoxDriver();
		}	
		else
		{
			driver=new EdgeDriver();  //Default Browser to open
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000)); // Selenium Server JAR file
		
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);   //Selenium file
		
		driver.get(config.getProperty("app_url_test"));
		
		test = reports.startTest(testCaseName);
		
		System.out.println("User Navigated to"+config.getProperty("app_url_test")+"URL");
		test.log(LogStatus.INFO, "User Navigated to"+config.getProperty("app_url_test")+"URL");
			
		hp= new HomePage();
	}
		
	public static void tearDown() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			driver.quit();
			System.out.println("Browser has been closed");
		}
	
	public static void takeaScreenShot(){
		
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date()); 
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String screenShotPath = System.getProperty("user.dir")+"\\src\\test\\resources\\screenshots\\screenshot_"+timeStamp+".png";
		
		File destFile = new File(screenShotPath);
		
		try {
			FileHandler.copy(scrFile, destFile);  //We can write the code in this way or like mention in below line
			
//			FileUtils.copyFile(scrFile, new File(RESULT_FILENAME));  //This way also we can write the code to store screenshot
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
		test.log(LogStatus.INFO,test.addScreenCapture(screenShotPath));	
	}
	
	public static void loadRunModeHashtable() {
		int rows = excel.getRowCount("testCaseName");
		for(int i=2; i<=rows;i++ ){
			String key = excel.getCellData("Test_Cases","TestCaseName", i);
			String value = excel.getCellData("Test_Cases","Run_Mode", i);
			run_mode.put(key , value);
		}
		
		System.out.println("HashTable Run Mode:" +run_mode);
	}
	
	@DataProvider
	public Object[][] data_Collection(){
		
		DataCollection dc = new DataCollection(excel, "Test_Data", testCaseName);
		
		return dc.dataArray();
	}
	
	@AfterSuite
	public static void endTest() {
		reports.endTest(test);
		reports.flush();
	}
	
		
}


