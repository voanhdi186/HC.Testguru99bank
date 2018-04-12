package BankPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;;

public class Deposit {
	WebDriver driver;

	//Elements in Deposit page
	By lnkDeposit = By.linkText("Deposit");
	By txtAccountNo = By.name("accountno");
	By txtAmount = By.name("ammount");
	By txtDescription = By.name("desc");
	By btnSubmit = By.name("AccSubmit");
	By btnReset = By.name("res");
	
	public Deposit (WebDriver driver){
		this.driver = driver;
	}
	
	//Create new Deposit
	public void createNewDeposit(
			String accno,
			String amount,
			String desc	){
		
		// Go to Deposit page
		driver.findElement(lnkDeposit).click();
		
		//Input data into fields
		driver.findElement(txtAccountNo).sendKeys(accno);
		driver.findElement(txtAmount).sendKeys(amount);
		driver.findElement(txtDescription).sendKeys(desc);
		driver.findElement(btnSubmit).click();
	}
	
	// return Current balance of account
	public String getCurrentBalance(){
		return driver.findElement(By.xpath(".//td[text()='Current Balance']/following-sibling::td")).getText();
	}
	
	// Reset all fields to empty
	public void resetAllFields(){
		driver.findElement(btnReset).click();		
	}
}
