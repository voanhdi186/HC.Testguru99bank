package BankPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	// Elements in Login page
	WebDriver driver;
	By txtUserName = By.name("uid");
	By txtPassword = By.name("password");
	By txtPageTitle = By.className("barone");
	By btnLogin = By.name("btnLogin");    

    public LoginPage(WebDriver driver){
    	this.driver = driver;
    }

    //Get the title of Login Page
    public String getLoginTitle(){
    	return driver.findElement(txtPageTitle).getText();
    }
    //Set user name into textbox
    public void setUserName(String username){
    	driver.findElement(txtUserName).sendKeys(username);
    }    

    //Set password in password textbox
    public void setPassword(String strPassword){
    	driver.findElement(txtPassword).sendKeys(strPassword);
    }

	//Click on Login button
	public void clickLogin(){
		driver.findElement(btnLogin).click();		
	}

	
	// Method(s) below is for running testcase
    //Login to Page after filling username and password
    public void loginToGuru99Bank(String username,String password){
    	//Fill user name and password
    	this.setUserName(username);
        this.setPassword(password);

        //Click Login button to login
        this.clickLogin();        
    }

}
