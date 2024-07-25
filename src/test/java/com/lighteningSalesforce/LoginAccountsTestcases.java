package com.lighteningSalesforce;

import java.awt.Button;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bouncycastle.pqc.jcajce.provider.SABER;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import com.salesforce.utility.Constants;
import com.salesforce.utility.PropertyUtility;
import com.tekarch.salesforce.base.BaseTest;
import com.tekarch.salesforce.pages.home.AccountPage;
import com.tekarch.salesforce.pages.home.HomePage;
import com.tekarch.salesforce.pages.login.LoginPage;

public class LoginAccountsTestcases extends BaseTest{
	Logger loginPageLog = LogManager.getLogger();//get the logger wbased on the e currect class
	AccountPage accountPage;
	String uuid = UUID.randomUUID().toString();
	Random random;
	HomePage homePage;
	String accountname;
	Robot rt;
	@BeforeClass
    public void setUp() {

		accountPage=new AccountPage(driver);
		random = new Random();

	}
	
	
	@Test(priority = 0,enabled = true)
	public void login_Homepage() throws Exception {
		loginPageLog.info("..............stated login_Homepage()...............");
		LoginPage loginPage=new LoginPage(driver);
		String username = PropertyUtility.readdatatofile(Constants.applicationPropertyPath, "lightening_username");
		String passwrd = PropertyUtility.readdatatofile(Constants.applicationPropertyPath, "lightening_password");
		//extentReport.logTestInfo("username and password extracted from properties file");

		String expectedURL ="https://login.salesforce.com/";	
		String actualURL=loginPage.getCurrrenURL();
	Thread.sleep(8000);
	System.out.println(actualURL+"actualURL");
		try {
			Assert.assertEquals(actualURL, expectedURL);
			loginPageLog.info(actualURL + "  matched with " + expectedURL);
			reportlog.logTestwithPassed(actualURL + "  matched with " + expectedURL);
		} catch (AssertionError e) {
			loginPageLog.error(actualURL + "not   matched with " +expectedURL);

			
			throw e;
		}
		loginPage.waitforVisibilityUsername(30, "UserName ");
		loginPage.enterUserName(username);
		loginPageLog.info("User name entered successfully");
		//elementTextVerify(email_field, "sweety123@yahoo.com");
		loginPage.enterPassword(passwrd);
		loginPageLog.info("Password entered successfully");
		Thread.sleep(8000);

loginPage.waitforVisibilityLogin(30,"Login Button");
driver=loginPage.clickElement("Login Button");
Thread.sleep(2000);
homePage =new HomePage (driver);

String expTitle ="Home | Salesforce";	
String actTitle=homePage.getTitleOfThePage();
///homePage.wait(1000);  //this will wait untill  thread invokes the notify() method  foe this thread

try {
	WebDriverWait wait=new WebDriverWait(driver,20);
	
	Assert.assertEquals(actTitle, expTitle);
	loginPageLog.info(actTitle + "  matched with " + expTitle);
	reportlog.logTestwithPassed(actTitle + "  matched with " + expTitle);
} catch (AssertionError e) {
	loginPageLog.error(actTitle + " not   matched with " + expTitle);

	// reportlog.logTestfailwithException(e);
	throw e;
}
loginPageLog.info("All assertions Passed");
reportlog.logTestInfo("All assertions Passed");
		loginPageLog.info("..............ended Login_Homepage()...............");

		
	try {
driver.switchTo().alert();
Thread.sleep(1000);
loginPage.adCloseBttn("");


	}
	catch (Exception e) {
		
	System.out.println(	e.getMessage());
	}
	}
	
	
	
	@Test(priority = 1,enabled=false)
	public void Create_Account() throws Exception {
		
		loginPageLog.info("..............started Accountpage()...............");
		Thread.sleep(8000);
//accountPage=new AccountPage(driver);
accountPage.javaExceutorClickAccount();Thread.sleep(4000);
//Actions actions = new Actions(driver);
//actions.moveToElement(element).click().perform();
//		//accountPage.clickAccountTab("AccountTab is clicked");
		accountPage.clickNewTab("NewButton is clicked");Thread.sleep(1000);
		accountPage.clickAccontNameInputArea("AccountNameTextArea is clicked");
	    String accountName = "Acc_"  + uuid.substring(0, 3);
	    Thread.sleep(500);
		accountPage.enterAccountName(accountName);
 accountname=	accountPage.getAccountName();
		
		accountPage.javaExceutorScrollToTypeView("Scroll To Type field");
		accountPage.clickTypeDropdownBttn("Type field DropDown button");Thread.sleep(5000);
	List<WebElement> options=	 accountPage.dropdownTypeOptions();
	
for(WebElement option:options) {
	System.out.println(option.getText());
	if((option.getText()).equals("Customer - Channel")){
		//option.click();
		accountPage.javascriptClick(driver, option);
		break;
	}Thread.sleep(7000);
}		accountPage.javaExceutorScrollToBillingView("Scroll to Billing Address field");

String billingAddress =  uuid.substring(0, 3)+" "+ random.nextInt(100);// generates a random number between 0 and 99

accountPage.enterBillingStreet(billingAddress );
Thread.sleep(3000);
	accountPage.javaExceutorScrollToExpDate("Scroll to Exp Date Field ");;Thread.sleep(4000);

;accountPage.clickexpDateBttn("ExpirationDate Button");
Thread.sleep(5000);

accountPage.clickTodaysDate("Todays Date");Thread.sleep(5000);
driver=   accountPage.clickSaveBttn("Save button");


//accountPage.removedisabledSaveAttribue("");
//accountPage.waittoclickSaveBttn();
//accountPage.javaExceutorClickSave();
//accountPage.removedisabledSaveAttribue("Javaexecutor to remove disable attribute");

}
	

	@Test(priority = 2,enabled = true)
	public void editAccount() throws Exception {
	
		
		Thread.sleep(4000);
		accountPage.javaExceutorClickAccount();Thread.sleep(4000);

	List<WebElement> accounts=	accountPage.allColumnAccounts();
	for(WebElement account:accounts) {
		System.out.println(account.getText());
		if(account.isDisplayed() &&(account.getText()).equals("Acc_a53")){
			accountPage.javascriptClick(driver, account);
		}
	}

		

		Thread.sleep(5000);
	accountPage.hoverElement("Hover over the Account Owner");
	Thread.sleep(5000);
String actCompanyName=	accountPage.getCompanyName();
	Assert.assertEquals(actCompanyName, "lib123");
	Thread.sleep(2000);
	/*accountPage.javaExceutorScrollToUploadandClickAction("Scroll to Upload btton and click ");
	 rt=new Robot();
		Thread.sleep(5000);

	StringSelection stringSelection = new StringSelection("/Users/nitin/screen.png");
	Clipboard   clip= Toolkit.getDefaultToolkit().getSystemClipboard();
	clip.setContents(stringSelection, null);
	Thread.sleep(4000);
	//`Command + Shift + G` on macOS, it opens the "Go to Folder" dialog in Finder.
	System.out.println("Pressing Command + Shift + G");

	rt.keyPress(KeyEvent.VK_META);  // Press Command key
  rt.keyPress(KeyEvent.VK_SHIFT); // Press Shift key
	rt.keyPress(KeyEvent.VK_G);     // Press G key
	Thread.sleep(5000);
    // Release the keys in reverse order
	System.out.println("Releasing Command + Shift + G");

	rt.keyRelease(KeyEvent.VK_G); 
	rt.keyRelease(KeyEvent.VK_SHIFT); // Release Shift key
	rt.keyRelease(KeyEvent.VK_META);  // Release Command key

	// Adding a small delay to ensure the "Go to Folder" dialog opens
//	Thread.sleep(5000);

	// Paste the clipboard content (file path)
	System.out.println("Pressing Command +  V");

	rt.keyPress(KeyEvent.VK_META);
	rt.keyPress(KeyEvent.VK_V);
	System.out.println("Releasing Command +  V");

	rt.keyRelease(KeyEvent.VK_V);
	rt.keyRelease(KeyEvent.VK_META);
	Thread.sleep(8000);

	rt.keyPress(KeyEvent.VK_ENTER);
	rt.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(2000);
	
	rt.keyPress(KeyEvent.VK_ESCAPE);
	rt.keyRelease(KeyEvent.VK_ESCAPE);
	Thread.sleep(10000);*/
	accountPage.clickDetailsTab("Details Tab is clicked");
	accountPage.waitforVisibiltyRating();
	accountPage.clickeditRating("Edit Rating clicked ");	Thread.sleep(5000);
	accountPage.clickRating("");
	/*

	 * 1. **Locate the dropdown menu.** 2. **Find all the options within the
	 * dropdown.** 3. **Choose a random option.** 4. **Select the chosen option.
	 ***/
	List<WebElement> optionsElements= accountPage.ratingOptions();
	int randomIndex=  random.nextInt(optionsElements.size());
	  WebElement randomOption =optionsElements.get(randomIndex);
		Thread.sleep(5000);
	  randomOption .click();
		Thread.sleep(5000);

	  accountPage.clickEditSaveBttn("Clicking on Save Button");
	}
	
	
	@Test(priority = 4,enabled = false)
	public void DeleteAccount() throws Exception {
		
		loginPageLog.info("..............started DeleteAccount()...............");
		Thread.sleep(10000);
accountPage.javaExceutorClickAccount();Thread.sleep(4000);
accountPage.javaExceutorClickCheckbox();
	//accountPage.clickCheckBoxForAccount("Select first account to be deleted");
	reportlog.logTestInfo("Selected first account successfully ");

	Thread.sleep(5000);   
	accountPage.clickDownArrowButton("Arrow Button ");
	reportlog.logTestInfo("\"Arrow Button  to choose delte action is Clicked\"");

	Thread.sleep(5000); 
	accountPage.SelectDeleteLink("Select Delete Link from DropDown");
	reportlog.logTestInfo("Delete Link selected from DropDown");Thread.sleep(5000);
	accountPage.clickDeleteBttn("Click delete ");
	}
	}