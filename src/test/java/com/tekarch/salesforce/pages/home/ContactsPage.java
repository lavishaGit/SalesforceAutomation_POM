package com.tekarch.salesforce.pages.home;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.tekarch.salesforce.pages.base.BasePage;

public class ContactsPage extends BasePage {
	
	
	@FindBy(xpath="//*[@data-target-selection-name='sfdc:StandardButton.Contact.NewContact']//button")
	WebElement contactNewButtn;
	@FindBy(xpath="//input[@name='lastName']")
	WebElement lastName;
	@FindBy(xpath="//input[@name='Birthdate']")
	WebElement Birthday;
	@FindBy(xpath="//div[contains(@class,'slds-datepicker') and @role='dialog']")
	WebElement datepicker;
	@FindBy(xpath="//*[@title='Previous Month']")
	WebElement previousMonth;

	@FindBy(xpath="//*[@class='slds-align-middle' and @role='alert']")
	WebElement monthTitle;
	@FindBy(xpath="//select[@class='slds-select']")
	WebElement year;
	@FindBy(xpath="//div[@part='input-container']//input[contains(@class,'slds-combobox__input-value')]")
	WebElement contactAccountName;
	@FindBy(xpath="//lightning-formatted-text[@class='custom-truncate']")
	WebElement accountName;

	@FindBy(xpath="//button[@name='SaveEdit']")
	WebElement saveBttn;
	
	@FindBy(xpath="//table[@class='slds-datepicker__month']//td")
	List   <WebElement> dates;
	@FindBy(xpath="//*[@data-aura-class='sfaOutputNameWithHierarchyIcon']/lightning-formatted-text")
	WebElement accountnameOnAccountPage;
	
	@FindAll({@FindBy(xpath="//div[@class='slds-context-bar']//a[@title='Contacts']"),
	@FindBy(xpath="//div[@class='slds-context-bar']//a[@title='Contacts']/parent::*")})
	WebElement contactTab;

	@FindBy(xpath="//table[contains(@class, 'slds-table_header-fixed')]//tbody/tr/th//div/a")
	List<WebElement> lastnameContactPage;
	@FindBy(xpath="//div[@class='slds-card__body slds-wrap slds-grid']//div[@class='slds-grid']/a//slot/span")
	List<WebElement> lastNameFront;

	@FindBy(xpath="//div[@role='alertdialog']/button")
	WebElement dialog;

	
	
	
	
	public ContactsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public void clickContact(String objname) throws Exception {
		
		clickbutton(contactNewButtn, objname);

	}
public void clickdialog(String objname) throws Exception {
	if(dialog.isDisplayed()&&dialog != null)
		
		clickbutton(dialog, objname);

 else {
        System.out.println("Element  'closeButton' not found or not displayed");
    }
}
    public void clickContactTab(String objname) throws Exception {
		
    	waitForclickable(contactTab, 50, objname);
    	System.out.println("waited for element");
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
     //   js.executeScript("arguments[0].scrollIntoView(true);", contactPage);	
        javascriptClick(driver,contactTab );System.out.println("Clicked on element");
     //   contactTab.click();// if i use this it gives javascript error: Cannot read properties of undefined (reading 'defaultView')
	}

public List<String> getContactLastNames() {
	List<String> namesElements=new ArrayList<>();
	for(WebElement name:lastNameFront) {
		System.out.println(name.getText()+ "name list after creating contact");
	namesElements.add(name.getText());
	}
	return namesElements;
	}
	

public String isContactNameExist(String lastname) throws InterruptedException {
	Thread.sleep(3000);
	List<String> names=	getContactLastNames();
if(names.contains(lastname))
	{			System.out.println(lastname+ "  last name ");

	System.out.println(names.size()+ "size of name list");

return lastname;}
else {
    return "Contact not found"; //depending on what you prefer
}
}
/*
public Boolean isLastNameMatch(String  lastname)
{
	
	return lastnameContactPage.contains(lastname);
}
	*/
public String matchLastNameExistInContactPage(String lastname) {
	List<String> namesElements=new ArrayList<>();
	System.out.println(lastname+ " matchLastNameExistInContactPage lastname ");
	WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.visibilityOfAllElements(lastnameContactPage));
	List<WebElement> rows =lastnameContactPage;
	for(WebElement name:rows) {
        System.out.println("lastnameContactPage element: " + name.getTagName() + " | " + name.getText() + " | " + name.getAttribute("title"));

		System.out.println("lastnameContactPage list:   "+name.getAttribute("title"));
	namesElements.add(name.getAttribute("title"));
	}
if(namesElements.contains(lastname))
	{
return lastname;}
else {
    return null; // or return "Contact not found"; depending on what you prefer
}
	}

	
	public WebDriver clickSaveBttn(String objname) throws Exception {
		waitForVisibiltyofElementLocated(saveBttn, 10, "");

		clickbutton(saveBttn, objname);
		return driver;
		
	}
public void enterLastName(String name,String objname) {
	lastName.click();
	elementSendText(lastName,name, objname);
		
	}
public String getLastName() {
	return getText(lastName);
		
	}

public void clickBirthday(String objname) {
	
	clickbutton(Birthday, objname);
}

public void clickPreviousMonth(String objname) {
	
	clickbutton(previousMonth, objname);
}

public String getAccountNameAccountPage() {
	return getText(accountnameOnAccountPage);
	
	
}

public String getContactAccountName() {
	return contactAccountName.getAttribute("data-value");
	
}

public void selectByVisibleText(By locator, String visibleText) throws Exception {
	WebElement dropdownElement = driver.findElement(locator);
	dropdownElement.click();
	mybasePagelog.info("Dropdown element is clicked");
	reportlog.logTestInfo("Dropdown element is clicked");
	Select dropdown = new Select(dropdownElement);
	try {
		dropdown.selectByVisibleText(visibleText);
		mybasePagelog.info("Text '" + visibleText + "' is selected from dropdown");

		String selectedOptionText = dropdown.getFirstSelectedOption().getText();

		Assert.assertEquals(visibleText, selectedOptionText);
		mybasePagelog.info("selected option matches to the Actual option");

		reportlog.logTestwithPassed("Selected option matches to the expected Visible text");

	} catch (Exception e) {
		mybasePagelog.error("Desired Visible text" + visibleText + "is not selected");
		// reportlog.logTestfailwithException(e);
		throw e;
	}
}

 public void chooseYear(String visibleText) throws Exception {
	 year.click();Thread.sleep(5000);
	 selectByVisibleText(By.xpath("//select[@class='slds-select']"),visibleText);
	 Thread.sleep(2000);
	 
 }
 
 public void selectDate(String date) throws Exception {

List<WebElement> pickdates	   = dates;
	 for(WebElement pickdate: pickdates) {Thread.sleep(7000);
		 if((pickdate.getText()).contains(date))
		 {
				waitForVisibiltyofElementLocated(pickdate, 10, "");

			 pickdate.click(); break;
	 }break;
 }
	 }
 
 public String currentMonth() {
	 return monthTitle.getText();
	 
	 
 }
 public void waitPageToLoad(long time ) {
	 waitUntilPageLoads(time);
	 
 }
 
 public  void scrolltoBirthday() {
	 
	 javascriptScrollToElement(driver, Birthday);
	 
	 
	 
 }
 //public void javaExceutorClickContact() {
		
	//	javascriptClick(driver, contactPage);
		
//	}
 
}
