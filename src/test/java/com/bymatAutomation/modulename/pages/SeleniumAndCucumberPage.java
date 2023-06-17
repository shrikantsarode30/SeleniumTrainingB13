package com.bymatAutomation.modulename.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.bymatAutomation.modulename.testbase.TestBase;

public class SeleniumAndCucumberPage extends TestBase {

	//xpath-- a concept of Page Factory in POM Framework
	//@FindBy(id="")
	//@FindBy(class="")
	//@FindBy(name="")
	//@FindBy(linktext="")
	//@FindBy(partiallinktext="")
	//@FindBy(css="")
		
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
	
	@FindBy(xpath="	//*[text()=\"Selenium\"]") //Added this xpath to check changes in GitHub
	private WebElement selenium_btn1;
	
	public SeleniumAndCucumberPage() {  //This constructor
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void verifyHomePageTitle() {  //Non Static Method
		// We need to create object of the class to access this method
		
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "BYMAT Automation - Boost your Mind with Automation Technology");
	}
	
	public void verifyHomePageLinksTextAndButtons() {  //Non Static Method
		// We need to create object of the class to access this method
		
		about_us.isDisplayed();
		about_us.click();
		
	}
	public void clickOnSeleniumButton() {  //Non Static Method
		// We need to create object of the class to access this method
		
		selenium_btn.isDisplayed();
		selenium_btn.click();
		
	}
	
}
