package Testcases;

import BankPages.Deposit;
import BankPages.LoginPage;
import BankPages.NewAccount;
import BankPages.NewCustomerPage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testcase_01 {

	WebDriver driver;
	String strCustomerId = ""; // store Customer ID when create new customer successfully
	String strAccountId = ""; // store Account ID when create new account successfully

	// login credentials
	String loginid = "mngr127150";
	String password = "mahUduq";
	
	
	// parameters for Create Account
	String strAccountType = "Current"; // "Savings"/"Current"
	String strInitamount = "5500";

	// parameters for Deposit
	String strAddAmount = "1500";
	String strDesc = "Add more amount to the account";

	public static void main(String[] args) {
		
		Testcase_01 obj = new Testcase_01();
		obj.setupEnviroment();
		
//------ Verify new customer can be created.
		
			// this section sets parameter for email address
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HHmss");
		LocalDateTime now = LocalDateTime.now();
		String email = "test"+ dtf.format(now).toString() + "@hc.com";
			//end set parameter email address
		
		obj.verify_new_customer_can_be_created("user one", "male", "11112000", "123 hcmc", "hcmc", "hcmc", "123456", "123456789", email, "123456");
		
		
//-----	Verify to create new account based on the customer just created above.
		obj.verify_new_account_created_for_new_customer();
		
//------Verify deposit function work fine with the account just created
		obj.verify_deposit_function_work_fine();		
	}
	
    public Testcase_01() {
		System.setProperty("webdriver.chrome.driver","c:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
	   	driver.get("http://demo.guru99.com/v4");
    }
    
	public void setupEnviroment(){		
		// Login to guru99bank page
		LoginPage objLogin = new LoginPage(driver);
		objLogin.loginToGuru99Bank(loginid, password);
    }

	public void verify_new_customer_can_be_created(
			String username,
			String gender,
			String dateofbirth,
			String address,
			String city,
			String state,
			String pin,
			String mobilenumber,
			String email,
			String password){
		NewCustomerPage objNewCustomer = new NewCustomerPage(driver);		
		objNewCustomer.createNewCustomer(username, gender, dateofbirth, address, city, state, pin, mobilenumber, email, password);
		strCustomerId = objNewCustomer.getIDofCustomerCreated();
		System.out.println("Customer is created and Customer ID is " + strCustomerId);
	}	
	
	public void verify_new_account_created_for_new_customer(){
		NewAccount objNewAccount = new NewAccount(driver);		
		objNewAccount.createNewAccount(strCustomerId, strAccountType, strInitamount);		
		strAccountId = objNewAccount.getAccountNo();		
		System.out.println("New Account is created for Customer ID: " + strCustomerId + " with Account No is "+ strAccountId);
	}	
	
	public void verify_deposit_function_work_fine(){
		Deposit objDeposit = new Deposit(driver);		
		objDeposit.createNewDeposit(strAccountId, strAddAmount, strDesc);
		System.out.println("Deposit run successfully with Current Balance = Init Amt + Deposit Amt = " + objDeposit.getCurrentBalance());
	}
	
}