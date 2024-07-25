package com.lighteningSalesforce;

import java.awt.Button;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.tekarch.salesforce.base.BaseTest;
import com.tekarch.salesforce.pages.home.AccountPage;
import com.tekarch.salesforce.pages.home.ContactsPage;

public class ContactsTestCases extends BaseTest {
	Logger loginPageLog = LogManager.getLogger();//get the logger based on the e currect class
	ContactsPage contactpage;AccountPage accountPage;
	LoginAccountsTestcases loginaccountTestcase;
	Faker faker;
	String alastName ;
	String randomlastName;
	 String lastnameAccountPage;
	 String lastnameContactPage;
	@BeforeClass
    public void setUp() {

		contactpage=new ContactsPage(driver);
		accountPage=new AccountPage(driver);
		loginaccountTestcase=new LoginAccountsTestcases();
		faker=new Faker();
	}
	
  @Test

	public void createContacts() throws Exception {
	  loginaccountTestcase.login_Homepage();
	  
randomlastName=	faker.name().lastName();

	accountPage.javaExceutorClickAccount();
	accountPage.waitUntilPageLoads(20);Thread.sleep(5000);
	List<WebElement> accounts=	accountPage.allColumnAccounts();
	for(WebElement account:accounts) {
		System.out.println(account.getText());
		if(account.isDisplayed() &&(account.getText()).equals("Acc_a53")){
			accountPage.javascriptClick(driver, account);
		}
	}Thread.sleep(4000);
	String accountName=contactpage.getAccountNameAccountPage();
	System.out.println("actual page"+accountName);

Thread.sleep(4000);
		contactpage.clickContact("Contact button on Accounts page ");
		Thread.sleep(4000);
		contactpage.enterLastName(randomlastName, "last name ");
		Thread.sleep(4000);
		//here i was trying to get the lastname when i m entering the last name which not possible as untill u save the form u cannot get the value
//alastName=	contactpage.getLastName();	
//System.out.println(alastName+"last name  when contact craeted");

		String contactAccountName=contactpage.getContactAccountName();	
		System.out.println("contact page"+contactAccountName);

		Assert.assertEquals( contactAccountName,accountName);Thread.sleep(4000);
	/*	contactpage.scrolltoBirthday();Thread.sleep(4000);
		contactpage.clickBirthday("Birthday calendar click");
		String aMonth=contactpage.currentMonth();
		while(!aMonth.equals("January")){
			contactpage.clickPreviousMonth("CLicking ON BackAction ARROW Button ");
	aMonth=	contactpage.currentMonth();
			//Initially, the variable aMonth holds a reference to the String object "June".
	//After the reassignment, aMonth holds a reference to the String object "January".
	//Both String objects "June" and "January" are stored in the string pool, but aMonth only references one at a time.
		
		}
		Assert.assertTrue(aMonth.equals("January"));
		contactpage.chooseYear("2001");
		contactpage.selectDate("15");
	  	*/
	driver=	contactpage.clickSaveBttn("Save Action Button");
	System.out.println(randomlastName+"last name  when contact craeted");
	//this will check the randomlastName in the existing list of getContactLastNames()method and return true if true 
lastnameAccountPage=     contactpage. isContactNameExist(randomlastName);
contactpage.clickdialog("Clicking on Custom Alert dialog");

	Thread.sleep(5000);
contactpage.clickContactTab("clicks contact tab");
 lastnameContactPage=  contactpage.matchLastNameExistInContactPage(lastnameAccountPage);//used waits in method to load all contacts  elemnts  else its giving me null 
  System.out.println(lastnameContactPage+"saved lastname ");
 Assert.assertEquals(lastnameContactPage, lastnameAccountPage, "Last name matches in the contact page");
  }

}
