package com.tekarch.salesforce.automationscripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import com.salesforce.utility.Constants;
import com.salesforce.utility.PropertyUtility;
import com.tekarch.salesforce.base.BaseTest;
import com.tekarch.salesforce.pages.home.HomePage;
import com.tekarch.salesforce.pages.login.ForgotPasswordPage;
import com.tekarch.salesforce.pages.login.LoginPage;
import com.tekarch.salesforce.pages.login.ResetPassPage;

public class SalesforceLoginPage_Testcases extends BaseTest {
	Logger loginPageLog = LogManager.getLogger();
	SoftAssert softAssert = new SoftAssert();
	

	@Test(priority = 0,enabled = true	)
	public void loginPage_EmptyPassword() throws Exception {
		loginPageLog.info("..............started loginPage_EmptyPassword...............");
		LoginPage loginPage=new LoginPage(driver);
		String username = PropertyUtility.readdatatofile(Constants.applicationPropertyPath, "username");
		String passwrd = PropertyUtility.readdatatofile(Constants.applicationPropertyPath, "password");
		//extentReport.logTestInfo("username and password extracted from properties file");

		String expectedTxt = "Please enter your password.";
		String expTitle ="Login | Salesforce";	
		String actTitle=loginPage.getTitleOfThePage();
		try {
			AssertJUnit.assertEquals(actTitle, expTitle);
			loginPageLog.info(actTitle + "  matched with " + expTitle);
			reportlog.logTestwithPassed(actTitle + "  matched with " + expTitle);
		} catch (AssertionError e) {
			loginPageLog.error(actTitle + "not   matched with " + expTitle);

			// reportlog.logTestfailwithException(e);
			throw e;
		}
		loginPageLog.info("Assertion passed: Actual title is equal to Expected title");
		loginPage.waitforVisibilityUsername(30, "UserName ");
		loginPage.enterUserName(username);
		loginPageLog.info("User name entered");
		//elementTextVerify(email_field, "sweety123@yahoo.com");
		//System.out.println("Assertion passed: Actual title is equal to Expected title");
		loginPage.enterPassword("");
		//elementSendText(password, "", "Empty password ");
				
loginPage.waitforVisibilityLogin(30,"Login Button");
driver=loginPage.clickElement("Login Button");
		//getTextCheck(label, "Validation message", "Please enter your password.");
    String actualTxt=loginPage.getText("Label Text");
try {
	AssertJUnit.assertEquals(actualTxt, expectedTxt);
	loginPageLog.info(actualTxt + "  matched with " + expectedTxt);
	// mybasePagelog.error(actualTxt + " matched with " + expectedTxt);

	reportlog.logTestwithPassed(actualTxt + "  matched with " + expectedTxt);

} catch (AssertionError e) {
	loginPageLog.error(actualTxt + "not   matched with " + expectedTxt);

	// reportlog.logTestfailwithException(e);
	throw e;
}
loginPageLog.info("All assertions Passed");
reportlog.logTestInfo("All assertions Passed");

loginPageLog.info("..............ended loginPage_EmptyPassword................");

	}

	@Test(priority = 3,enabled = true)
	public void login_Homepage() throws Exception {
		loginPageLog.info("..............stated login_Homepage()...............");
		LoginPage loginPage=new LoginPage(driver);
		String username = PropertyUtility.readdatatofile(Constants.applicationPropertyPath, "username");
		String passwrd = PropertyUtility.readdatatofile(Constants.applicationPropertyPath, "password");
		//extentReport.logTestInfo("username and password extracted from properties file");

		String expectedURL ="https://login.salesforce.com/";	
		String actualURL=loginPage.getCurrrenURL();
	
		try {
			AssertJUnit.assertEquals(actualURL, expectedURL);
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

loginPage.waitforVisibilityLogin(30,"Login Button");
driver=loginPage.clickElement("Login Button");
HomePage homePage=new HomePage (driver);

String expTitle ="Home Page ~ Salesforce - Developer Edition";	
String actTitle=homePage.getTitleOfThePage();
///homePage.wait(1000);  //this will wait untill  thread invokes the notify() method  foe this thread

try {
	AssertJUnit.assertEquals(actTitle, expTitle);
	loginPageLog.info(actTitle + "  matched with " + expTitle);
	reportlog.logTestwithPassed(actTitle + "  matched with " + expTitle);
} catch (AssertionError e) {
	loginPageLog.error(actTitle + " not   matched with " + expTitle);

	// reportlog.logTestfailwithException(e);
	throw e;
}
loginPageLog.info("All assertions Passed");
reportlog.logTestInfo("All assertions Passed");
		loginPageLog.info("..............ended login_Homepage()...............");

	}

	@Test(priority = 4)
	public void rememberUser_checkbox() throws Exception {
		loginPageLog.info("..............stated  rememberUser_checkbox..............");
		LoginPage loginPage=new LoginPage(driver);
		String username = PropertyUtility.readdatatofile(Constants.applicationPropertyPath, "username");
		String passwrd = PropertyUtility.readdatatofile(Constants.applicationPropertyPath, "password");
		//extentReport.logTestInfo("username and password extracted from properties file");
		loginPage.waitforVisibilityUsername(30, "UserName ");
		loginPage.enterUserName(username);
		loginPageLog.info("User name entered successfully");
		//elementTextVerify(email_field, "sweety123@yahoo.com");
		loginPage.enterPassword(passwrd);
		loginPageLog.info("Password entered successfully");
		loginPage.waitforVisibilityLogin(30,"Remember me checkbox");
		loginPage.clickCheckBox("Remember me ");
loginPage.waitforVisibilityLogin(30,"Login Button");
driver=loginPage.clickElement("Login Button");

		
HomePage homePage=new HomePage (driver);

String expTitle ="Home Page ~ Salesforce - Developer Edition";	
String actTitle=homePage.getTitleOfThePage();
//homePage.wait(1000);

try {
	AssertJUnit.assertEquals(actTitle, expTitle);
	loginPageLog.info(actTitle + "  matched with " + expTitle);
	reportlog.logTestwithPassed(actTitle + "  matched with " + expTitle);
} catch (AssertionError e) {
	loginPageLog.error(actTitle + " not   matched with " + expTitle);

	// reportlog.logTestfailwithException(e);
	throw e;
}
homePage.waitforVisibilityUser(30, "User account ");
//homePage.waitforVisibilitylogout(30, "Logout Button ");
driver=homePage.logout();
		
loginPage.waitforVisibilityUserlabeltxt(30,"Username Label ");
String explabelTxt="sweety123@yahoo.com";
String actlabelTxt=loginPage.getTextUser("Username label");
try {
	AssertJUnit.assertEquals(actlabelTxt, explabelTxt);
	loginPageLog.info(actlabelTxt+ "  matched with " + explabelTxt);
	reportlog.logTestwithPassed(actlabelTxt + "  matched with " + explabelTxt);
} catch (AssertionError e) {
	loginPageLog.error(actlabelTxt + " not   matched with " + explabelTxt);

	// reportlog.logTestfailwithException(e);
	throw e;
}
loginPageLog.info("All assertions Passed");
reportlog.logTestInfo("All assertions Passed");

		loginPageLog.info(".............ended rememberUser_checkbox..............");

	}

	@Test(priority = 1,enabled = true)
	public void testForgotPasssword() throws Exception {
		loginPageLog.info("..............stated testForgotPasssword..............");
		String username = PropertyUtility.readdatatofile(Constants.applicationPropertyPath, "username");

		LoginPage loginPage=new LoginPage(driver);
driver=  loginPage.clickForgotBttn("Forgot Button" );
ForgotPasswordPage forgotPassPage=new ForgotPasswordPage (driver);

String expTitle ="Forgot Your Password | Salesforce";	
String actTitle=forgotPassPage.getTitleOfThePage();
//homePage.wait(1000);

try {
	AssertJUnit.assertEquals(actTitle, expTitle);
	loginPageLog.info(actTitle + "  matched with " + expTitle);
	reportlog.logTestwithPassed(actTitle + "  matched with " + expTitle);
} catch (AssertionError e) {
	loginPageLog.error(actTitle + " not   matched with " + expTitle);

	// reportlog.logTestfailwithException(e);
	throw e;
}
forgotPassPage.waitforVisibilityUsername(30, "User Name ");
forgotPassPage.enterUserName(username);

driver=forgotPassPage.clickContinueBttn("Continue ");

ResetPassPage resetPage=new ResetPassPage(driver);

String expTitle1 ="Check Your Email | Salesforce";	
String actTitle1=forgotPassPage.getTitleOfThePage();

try {
	AssertJUnit.assertEquals(actTitle1, expTitle1);
	loginPageLog.info(actTitle1 + "  matched with " + expTitle1);
	reportlog.logTestwithPassed(actTitle1+ "  matched with " + expTitle1);
} catch (AssertionError e) {
	loginPageLog.error(actTitle1 + " not   matched with " + expTitle1);

	// reportlog.logTestfailwithException(e);
	throw e;
}
		String actemailtxt=resetPage.getText("Check emil lable ");
		String expemailtxt="Check Your Email";
		try {
			AssertJUnit.assertEquals(actemailtxt, expemailtxt);
			loginPageLog.info(actemailtxt+ "  matched with " + expemailtxt);
			reportlog.logTestwithPassed(actemailtxt + "  matched with " + expemailtxt);
		} catch (AssertionError e) {
			loginPageLog.error(actemailtxt + " not   matched with " + expemailtxt);

			// reportlog.logTestfailwithException(e);
			throw e;
		}
		loginPageLog.info("All assertions Passed");
		reportlog.logTestInfo("All assertions Passed");
		//getTextCheck(element, "page label text: ", "Check Your Email");
		loginPageLog.info("..............ended testForgotPasssword..............");

	}

	@Test(priority = 2,enabled = true)
	public void loginErrorMessage() throws Exception {
		loginPageLog.info("..............stated loginErrorMessage..............");
		String username = PropertyUtility.readdatatofile(Constants.applicationPropertyPath, "username");
		LoginPage loginPage=new LoginPage(driver);

String explabel="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
loginPage.waitforVisibilityUsername(30, "UserName ");
loginPage.enterUserName(username);
loginPageLog.info("User name entered successfully");
//elementTextVerify(email_field, "sweety123@yahoo.com");
loginPage.enterPassword("22131");


loginPage.waitforVisibilityLogin(30,"Login Button");
driver=loginPage.clickElement("Login Button");
		
	String actErrorTxt=	loginPage.getTextLoginError("Login Error");
		
		AssertJUnit.assertEquals(true,actErrorTxt.contains(explabel));
		loginPageLog.info(actErrorTxt+ "  matched with " +explabel);
		reportlog.logTestwithPassed(actErrorTxt+ "  matched with " +explabel);
		//sfAssert.assertAll();
		// String string=labelele.getText();
		// System.out.println(string);
		//getTextCheck(label, "page label text: ",
		//		"Please check your username and password."); 
		loginPageLog.info("All assertions Passed");
		reportlog.logTestInfo("All assertions Passed");
		loginPageLog.info("..............ended loginErrorMessage..............");

	}
	
}
