package BankPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class NewCustomerPage {
	WebDriver driver;

	//Elements in New Customer page
	By lnkNewCustomer = By.linkText("New Customer");
	By txtCustomerName = By.name("name");
	By rbGenrder_male = By.xpath(".//input[@name='rad1'][1]");
	By rbGenrder_female = By.xpath(".//input[@name='rad1'][2]");
	By dateDoB = By.name("dob");
	By txtAddress = By.name("addr");
	By txtCity = By.name("city");
	By txtState = By.name("state");
	By txtPIN = By.name("pinno");
	By txtMobileNumber = By.name("telephoneno");
	By txtEmail = By.name("emailid");
	By txtPassword = By.name("password");
	By btnSubmit = By.name("sub");
	By btnReset = By.name("res");
	
	public NewCustomerPage (WebDriver driver){
		this.driver = driver;
	}
	
	//Create new Customer
	public void createNewCustomer(
			String name,
			String gender,
			String dob,
			String addr,
			String city,
			String state,
			String pin,
			String mobileno,
			String email,
			String password){
		
		// Go to Create new customer page
		driver.findElement(lnkNewCustomer).click();
		
		//Input data into fields
		driver.findElement(txtCustomerName).sendKeys(name);
		
		if (gender == "female")
			driver.findElement(rbGenrder_female).click();
		else
			driver.findElement(rbGenrder_male).click();
		
		driver.findElement(dateDoB).sendKeys(dob);
		driver.findElement(txtAddress).sendKeys(addr);
		driver.findElement(txtCity).sendKeys(city);
		driver.findElement(txtState).sendKeys(state);
		driver.findElement(txtPIN).sendKeys(pin);
		driver.findElement(txtMobileNumber).sendKeys(mobileno);
		driver.findElement(txtEmail).sendKeys(email);
		driver.findElement(txtPassword).sendKeys(password);
		driver.findElement(btnSubmit).click();		
	}
	
	public String getIDofCustomerCreated(){
		
		return driver.findElement(By.xpath(".//td[text()='Customer ID']/following-sibling::td")).getText();
	}
	
	
	// Reset all fields to empty
	public void resetAllFields(){
		driver.findElement(btnReset).click();		
	}
}
