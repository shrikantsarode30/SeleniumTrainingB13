package com.bymatAutomation.modulename.pages;

import java.util.Hashtable;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.bymatAutomation.modulename.commonmethods.CommonMethods;
import com.bymatAutomation.modulename.testbase.TestBase;

public class InquireRegisterPage extends TestBase {

		
	//xpath-- a concept of Page Factory in POM Framework
	//@FindBy(id="")
	//@FindBy(class="")
	//@FindBy(name="")
	//@FindBy(linktext="")
	//@FindBy(partiallinktext="")
	//@FindBy(css="")
		
	@FindBy(xpath="//*[@rel=\"home\"]")
	private WebElement hp_logo;
	
	@FindBy(xpath="//*[@id=\"wpforms-1830-field_0\"]")
	private WebElement firstName;
	
	@FindBy(xpath="//*[@id=\"wpforms-1830-field_1\"]")
	private WebElement emailAddress;
	
	@FindBy(xpath="//*[@id=\"wpforms-1830-field_7\"]")
	private WebElement phoneNumber;
	
	@FindBy(xpath="//*[@id=\"wpforms-1830-field_10_1\"]")
	private WebElement seleniumCheckbox;
	
	@FindBy(xpath="//*[@id=\"wpforms-1830-field_10_2\"]")
	private WebElement devOpsCheckbox;

	@FindBy(xpath="//*[@id=\"wpforms-1830-field_2222\"]")
	private WebElement message;

	@FindBy(xpath="//*[@id=\"wpforms-submit-1830\"]")
	private WebElement submit_btn;
	
	public InquireRegisterPage() {  //This constructor
		
		PageFactory.initElements(driver, this);
		
	}
		
	public InquireRegisterPage verifyHomePageTitle() {  //Non Static Method
		// We need to create object of the class to access this method
		
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "BYMAT Automation - Boost your Mind with Automation Technology");
		return this;
		
	}
	
	public InquireRegisterPage enterUserDetails(Hashtable<String, String> htData) throws InterruptedException {  //Non Static Method
		// We need to create object of the class to access this method
		Thread.sleep(2000);
		
//		firstName.isDisplayed();
//		firstName.sendKeys("Shrikant");
//		
//		emailAddress.isDisplayed();
//		emailAddress.sendKeys("test@gmail.com");
//		
//		phoneNumber.isDisplayed();
//		phoneNumber.sendKeys("1234567890");
//				
//		seleniumCheckbox.isDisplayed();
//		seleniumCheckbox.click();
//		
//		devOpsCheckbox.isDisplayed();
//		devOpsCheckbox.click();
//		
//		message.isDisplayed();
//		message.sendKeys("Enter Message");
//		
//		submit_btn.isDisplayed();
//		submit_btn.click();
		
		CommonMethods.enterDataToInputBox(firstName, htData.get("First_Name"), "First Name is Entered");
		CommonMethods.enterDataToInputBox(emailAddress, htData.get("Email_ID"), "Email Address is Entered");
		CommonMethods.enterDataToInputBox(phoneNumber, htData.get("Phone_No"), "Phone Number is Entered");
		
		CommonMethods.clickSelectCheckboxAndRadioButton(seleniumCheckbox, "Selenium Checkbox is Clicked");
		CommonMethods.clickSelectCheckboxAndRadioButton(devOpsCheckbox, "DevOps checkbox is Clicked");
		
		CommonMethods.enterDataToInputBox(message, htData.get("Message"), "Message has been Entered");
	//	takeaScreenShot();
		CommonMethods.clickSelectCheckboxAndRadioButton(submit_btn, "Submit Button is Clicked");
	//	takeaScreenShot();
		return this;
		
	}	
}
