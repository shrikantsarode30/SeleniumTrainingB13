package com.bymatAutomation.modulename.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bymatAutomation.modulename.commonmethods.CommonMethods;
import com.bymatAutomation.modulename.testbase.TestBase;

public class HomePage extends TestBase {

	//xpath-- a concept of Page Factory in POM Framework
	//@FindBy(id="")
	//@FindBy(class="")
	//@FindBy(name="")
	//@FindBy(linktext="")
	//@FindBy(partiallinktext="")
	//@FindBy(css="")
		
	@FindBy(xpath="//*[@rel=\"home\"]")
	private WebElement hp_logo;
	
	@FindBy(xpath="//*[@id=\"menu-item-3130\"]")
	private WebElement about_us;
	
	@FindBy(xpath="//*[@id=\"menu-item-1743\"]")
	private WebElement trainings;
	
	@FindBy(xpath="//*[@id=\"menu-item-112\"]")
	private WebElement reviews;
	
	@FindBy(xpath="//*[@id=\"menu-item-1870\"]")
	private WebElement inquiryRegister;
	
	@FindBy(xpath="//*[@id=\"menu-item-2439\"]")
	private WebElement feedback;

	@FindBy(xpath="//*[@id=\"menu-item-111\"]")
	private WebElement contactus;

	@FindBy(xpath="	//*[text()=\"Selenium\"]")
	private WebElement selenium_btn;
	
	
	public HomePage() {  //This constructor
		
		PageFactory.initElements(driver, this);
		
	}
	
	public HomePage verifyHomePageTitle() {  //Non Static Method
		// We need to create object of the class to access this method
		
//		System.out.println(driver.getTitle());
//		Assert.assertEquals(driver.getTitle(), "BYMAT Automation - Boost your Mind with Automation Technology");
		CommonMethods.getPageTitle("BYMAT Automation - Boost your Mind with Automation Technology");
		
		return this;
		
	}
	
	public HomePage verifyHomePageLinksTextAndButtons() throws InterruptedException {  //Non Static Method
		// We need to create object of the class to access this method
		Thread.sleep(2000);
//		about_us.isDisplayed();
//		about_us.click();
		CommonMethods.clickSelectCheckboxAndRadioButton(about_us, "User Clicked on about_us");
		
		return this;
		
	}
	public SeleniumAndCucumberPage clickOnSeleniumButton() {  //Non Static Method
		// We need to create object of the class to access this method
//		hp_logo.click();
//		selenium_btn.isDisplayed();
//		selenium_btn.click();
		
		CommonMethods.clickSelectCheckboxAndRadioButton(hp_logo, "User Click on Logo");
		CommonMethods.clickSelectCheckboxAndRadioButton(selenium_btn, "User click on Selenium button");
		return new SeleniumAndCucumberPage();
		
		//POM Concept- Whichever method is taking control of next Page,that method should be responsible to return the 
		//object of that page( where my control goes)		
	}
	
	public InquireRegisterPage navigateToInquireRegisterPage() throws IOException {  //Non Static Method
		// We need to create object of the class to access this method
//		takeaScreenShot();
		CommonMethods.clickSelectCheckboxAndRadioButton(inquiryRegister, "User Clicked on Inquiry Register Page");
		
//		inquiryRegister.isDisplayed();
//		inquiryRegister.click();
				
		return new InquireRegisterPage();
		
		//POM Concept- Whichever method is taking control of next Page,that method should be responsible to return the 
		//object of that page( where my control goes)		
	}
	
}
