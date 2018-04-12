package BankPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;;

public class ManagerHomePage {
	WebDriver driver;
	
						//Elements in Manager Home page
	By HomePageUserName = By.xpath("//table//tr[@class='heading3']");
	By WelcomeMessage = By.xpath("//marquee[contains(text(),'Welcome To Manager')]");
	By lnkNewCustomer = By.linkText("New Customer");
	By lnkNewAccount = By.linkText("New Accout");
	By lnkDeposit = By.linkText("Deposit");
	
	public ManagerHomePage (WebDriver driver){
		this.driver = driver;
	}

	public String getHomePageUserName() {
		// TODO Auto-generated method stub
		return driver.findElement(HomePageUserName).getText();
	}
	
}