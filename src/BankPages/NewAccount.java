package BankPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {
	WebDriver driver;

	//Elements in New Account page
	By lnkNewAccount = By.linkText("New Account");
	By txtCustomerId = By.name("cusid");
	By selectionAccType = By.name("selaccount");
	By txtInitialDeposit = By.name("inideposit");
	By btnSubmit = By.name("button2");
	By btnReset = By.name("reset");
	
	public NewAccount (WebDriver driver){
		this.driver = driver;
	}
	
	//Create new Account for Customer
	public void createNewAccount(
			String cusid,
			String accType,
			String initdeposit){
		
		// Go to Create new account page
		driver.findElement(lnkNewAccount).click();
		
		//Input data into fields
		driver.findElement(txtCustomerId).sendKeys(cusid);
		
		//Select Account Type
		Select accountType = new Select(driver.findElement(By.name("selaccount")));
		if (accType == "Savings")
			accountType.selectByVisibleText("Savings");
		if (accType == "Current")
			accountType.selectByVisibleText("Current");
		
		//Input initial amount
		driver.findElement(txtInitialDeposit).sendKeys(initdeposit);
		driver.findElement(btnSubmit).click();		
	}
	
	// return Account ID created
	public String getAccountNo(){
		return driver.findElement(By.xpath(".//td[text()='Account ID']/following-sibling::td")).getText();
	}
	
	// Reset all fields to empty
	public void resetAllFields(){
		driver.findElement(btnReset).click();		
	}
}
