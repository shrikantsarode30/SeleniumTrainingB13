package com.bymatAutomation.modulename.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bymatAutomation.modulename.testbase.TestBase;

public class RegisterUserForTheSeleniumTraining2 extends TestBase{

	
	@BeforeClass
	private void isSkip() {
		testCaseName = this.getClass().getSimpleName();

		System.out.println("testCaseName is" +testCaseName);
		
		if(run_mode.get(testCaseName).equalsIgnoreCase("Y"))
			System.out.println("Executing Test Case: "+testCaseName);
		else throw new SkipException("Skipping Test Cases" +testCaseName+ " as it's run mode set to no");
	}
		
	
	@Test (dataProvider= "data_Collection")
	public static void registerUserForTheSeleniumTraining(Hashtable<String,String> htData) throws InterruptedException, IOException { // Test Step and Verification Points
		
		hp.navigateToInquireRegisterPage().enterUserDetails(htData);
		
	}	
}
