package com.tekarch.salesforce.pages.home;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.tekarch.salesforce.pages.base.BasePage;

public class AccountPage extends BasePage {

	
	
	@FindBy(xpath="//div[@class='slds-context-bar']//a[@title='Accounts']")
	WebElement accountTab;
	@FindBy(xpath="//ul[contains(@class,'branding-actions')]//a[contains(@title, 'New')]")
	WebElement newTab;
	@FindBy(xpath="//input[@name='Name']")
	WebElement accountName;
			//lightning-base-combobox-item[@id="combobox-input-386-0-386"]//*[@class="slds-truncate"]
	
			
			
			@FindBy(id="combobox-button-283")
			WebElement industryTab;
			
			@FindBy(xpath="//div[contains(@class,'slds-input__icon-group')]/preceding-sibling::button[contains(@aria-label,'Type')]")
			WebElement typeTab;
			@FindBy(xpath="//div[@aria-label='Type']//lightning-base-combobox-item")
			List<WebElement >typeDropdownList;
			@FindBy(xpath="//label[text()='Billing Street']//parent::lightning-textarea//textarea")
			WebElement enterBillingStreet;
			@FindBy(xpath="//input[@name='SLAExpirationDate__c']")
			WebElement expDateBttn;
			@FindBy(xpath="//button[text()='Today']")
			WebElement todaysDate;
	//not working		@FindBy(xpath="//button[text()='Save']")
		///	WebElement saveBttn;
			@FindBy(xpath="//li[@data-target-selection-name='sfdc:StandardButton.Account.SaveEdit']//button[@name='SaveEdit']")
			WebElement saveBttn;
			@FindBy(xpath="//label[span[text()='Select item 1']]/preceding-sibling::input[@type='checkbox']")
			WebElement checkboxElement;

			@FindBy(xpath="	(//div[contains(@class,'forceVirtualActionMarker')])[1]")
			WebElement arrowdownElement;

			@FindBy(xpath="//a[@data-target-selection-name='sfdc:StandardButton.Account.Delete']")
			WebElement selectDeleteElement;
					@FindBy(xpath="	//div[text()='Are you sure you want to delete this account?']")
					WebElement confirmationDeleteMessage;

			@FindBy(xpath="//button[@title='Delete']")
			WebElement deleteBttn;
			
			
			@FindBy(xpath="//table[@role=\"grid\"]//tbody//tr/th//a")
			List<WebElement >columnElements;
			@FindBy(xpath="//div[@class='slds-grid']/a")
			WebElement accountOwner;
			@FindBy(xpath="//a[@class='flex-wrap-ie11 slds-truncate']")
			WebElement hoverAccountOwner;
			@FindBy(xpath="//div[starts-with(@class,'slds-item--detail')]//span[text()='lib123']")
					WebElement hovererdCompanyNameElement ;
			@FindBy(xpath="(//label[@class='slds-file-selector__body']/child::span)[1]")
			WebElement uploadBttnElement ;

			@FindBy(xpath="//li[@title='Details']/a")
			WebElement detailsTab ;
			
			@FindBy(xpath="//span[@class='test-id__field-label' and text()='Rating']")
			WebElement ratingElement ;
			@FindBy(xpath="//div[@data-target-selection-name='sfdc:RecordField.Account.Rating']//button")
			WebElement editRating ;
			@FindBy(xpath="(//div[@class='slds-combobox_container']//button)[2]")
			WebElement rating ;
			@FindBy(xpath="//lightning-base-combobox-item//span/span")
			WebElement ratingDropdownBttn ;

			@FindBy(xpath="//div[@aria-label='Rating']")
			List<WebElement> ratingOptions ;
			@FindBy(xpath="//runtime_platform_actions-action-renderer[@title='Save']//button[@name='SaveEdit']")
			WebElement saveEditBttn ;

			@FindBy(xpath="//table[contains(@class, 'slds-table_header-fixed')]//tbody/tr/th")
			List<WebElement> columndata ;

			
	public AccountPage(WebDriver driver) {
		super(driver);
	}
		public void clickAccountTab(String objname) {
			
			clickbutton(accountTab, objname);
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			
		}
		public void printColumnData() {
	        for (WebElement cell : columndata) {
	            System.out.println(cell.getText());
	        }
	    }
		public void getColumnData(String cell) {
	        for (WebElement celldata : columndata) {
	        	if((celldata.getText()).contains(cell)) {
	        		
	        		
	        	}
	        	
	        }
	    }
public void clickeditRating(String objname) {
			
			clickbutton(editRating, objname);
			
		}
public void clickEditSaveBttn(String objname) {
	
	clickbutton(saveEditBttn, objname);
	
}
public void clickRating(String objname) {
	
	clickbutton(rating, objname);
	
}
public void clickDetailsTab(String objname) {
			
			clickbutton(detailsTab , objname);
			
		}

public void clickNewTab(String objname) {
			
			clickbutton(newTab, objname);
			
		}
public void clickAccontNameInputArea(String objname) {
	
	clickElement(accountName, objname);
	
}		// TODO Auto-generated constructor stub
	
public void enterAccountName(String data) {
	elementSendText(accountName, data, "account field ");

}

public String getAccountName() {
	return accountName.getText();
	
	
}public String getCompanyName() {
	return getText(hovererdCompanyNameElement);
	
	
}public void hoverElement(String objname) {
	hoverElement(hoverAccountOwner);
			
		}

public void clickTypeDropdownBttn(String objname) {
	
	clickElement(typeTab, objname);
	
}public void clickCheckBoxForAccount(String objname) {
	
	clickElement(checkboxElement, objname);
	
}
public void clickDownArrowButton(String objname) {
	
	clickElement( arrowdownElement, objname);
	
}
public void SelectDeleteLink(String objname) {
	
	clickElement( selectDeleteElement, objname);
	
}
public void clickDeleteBttn(String objname) {
	
	clickElement( deleteBttn, objname);
	
}


public List<WebElement> dropdownTypeOptions() {
	
return typeDropdownList;

}
public List<WebElement> ratingOptions() {
	
return ratingOptions;

}
public List<WebElement> allColumnAccounts() {
	
return columnElements;   }

public void enterBillingStreet(String data) {
	enterBillingStreet.click();
	elementSendText(enterBillingStreet, data, "billing street  ");

}
public void clickTodaysDate(String objname) {
	
	clickElement(todaysDate, objname);
	
}
public WebDriver clickSaveBttn(String objname) {
	
	clickbutton(saveBttn, objname);
	return driver;
}
public void clickexpDateBttn(String objname) {
	
	clickbutton(expDateBttn, objname);
	
}
	public void javaExceutorClickAccount() {
		
		javascriptClick(driver, accountTab);
		
	}
public void javaExceutorClickCheckbox() {
		
		javascriptClick(driver,checkboxElement);
		
	}
public void javaExceutorClickSave() {
		
		javascriptClick(driver, saveBttn);
	
}

public void javaExceutorScrollToTypeView(String objectname) {
		
	javascriptScrollToElement(driver, typeTab)		;
	}
public void javaExceutorScrollToBillingView(String objectname) {
	
	javascriptScrollToElement(driver,enterBillingStreet)		;
	}
public void javaExceutorScrollToExpDate(String objectname) {
	
	javascriptScrollToExpDateElement(driver,expDateBttn)		;
	}
public void javaExceutorScrollToUploadandClickAction (String objectname) {
	
	javascriptScrollToExpDateElement(driver,uploadBttnElement)		
	;uploadBttnElement.click();
	}

public void waittoclickSaveBttn() {
	
	try {
		waitForclickable(saveBttn, 10, "");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void waitforVisibiltyRating() throws Exception {
waitForVisibiltyofElementLocated(By.xpath("//span[@class='test-id__field-label' and text()='Rating']"), 10, "");
}

public void removedisabledSaveAttribue(String objname) {

//Check if the button is interactable
if (!saveBttn.isEnabled()) {
 // If not, execute JavaScript to remove the 'disabled' attribute
 ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('disabled')", saveBttn);
}
saveBttn.click();

}}
