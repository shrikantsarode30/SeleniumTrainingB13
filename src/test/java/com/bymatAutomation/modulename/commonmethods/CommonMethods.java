package com.bymatAutomation.modulename.commonmethods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.bymatAutomation.modulename.testbase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class CommonMethods extends TestBase {

	
	public static void clickSelectCheckboxAndRadioButton(WebElement element, String message) {
		
		element.isDisplayed();
		element.click();
				
		System.out.println(message);
		test.log(LogStatus.PASS, message);		
	}
	public static void enterDataToInputBox(WebElement element, String data, String message) {
		
		element.isDisplayed();
		element.sendKeys(data);
				
		System.out.println(message);
		test.log(LogStatus.PASS, message);
	}
	
	public static void getPageTitle(String pageTitle) {
		
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(),pageTitle );
		test.log(LogStatus.PASS, pageTitle);
	}
	
	public static void selectValueByVisibleText(WebElement element, String text, String message) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
		test.log(LogStatus.PASS, message);		
	}
	public static void selectValueByIndex(WebElement element, String text, String message) {
		
	}
	public static void selectByValue(WebElement element, String text, String message) {
		
	}
	
}
