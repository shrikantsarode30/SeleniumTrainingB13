package com.bymatAutomation.modulename.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bymatAutomation.modulename.testbase.TestBase;

public class verifyHomePageOfBymatAutomation extends TestBase{

//	@BeforeMethod
//	public static void launchBrowser(){
//		getDriver();
//		
//	}
	
	@BeforeClass
	private void isSkip() {
		testCaseName = this.getClass().getSimpleName();
		
		System.out.println("testCaseName is" +testCaseName);
		
		if(run_mode.get(testCaseName).equalsIgnoreCase("Y"))
			System.out.println("Executing Test Case: "+testCaseName);
		else throw new SkipException("Skipping Test Cases" +testCaseName+ " as it's run mode set to no");

	}
	
	
	@Test (dataProvider= "data_Collection")
	public static void verifyHomePageOfBYMATAutomation(Hashtable<String,String> htData) throws InterruptedException { // Test Step and Verification Points
				
//		test = reports.startTest("verifyHomePageOfBymatAutomation");
		
//		HomePage hp= new HomePage();
//		hp.verifyHomePageTitle();    // Verify User Landed on XYZ Website  //Input Base Line Document
//		hp.verifyHomePageLinksTextAndButtons();  //Verify user should be able to see links, buttons,Text
//		hp.clickOnSeleniumButton(); //User Clicked on Selenium Button
//		
//		SeleniumAndCucumberPage sac= new SeleniumAndCucumberPage();
//		sac.verifyHomePageTitle();
//		sac.clickOnSeleniumButton();
		
		hp.verifyHomePageTitle().verifyHomePageLinksTextAndButtons().clickOnSeleniumButton();
		
		//driver.manage().window().maximize();   //Sel Dev //POM--Object chaining concept
		
		
	}
//	@AfterMethod
//	public static void quitDriver() {
//		tearDown();
//		
//	}
	
	
}
