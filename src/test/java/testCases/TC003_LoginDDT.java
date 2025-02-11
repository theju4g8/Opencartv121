package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
	/*  Data is valid ---login success- test pass - logout
	⦁	data is valid ----login failed---test fail
	⦁	data is invalid --login success-test fail-logout
	⦁	data is invalid -- login failed --test pass
	*/
	@Test(dataProvider = "Logindata",dataProviderClass= DataProviders.class,groups="datadriven")
	public void verify_loginDDT(String email, String pwd,String exp) {
	logger.info("*******Starting TC003_LoginDDTTest *****");
	// to go to login page we need to navigate from homepage
	// click my account -then click login
	try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();

		// to access the login page elements we need to create object for login page
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();

		// MyAccountPage
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = macc.isMyAccountPageExists();
		if(exp.equalsIgnoreCase("Valid")) {
		if(targetPage==true) {
			Assert.assertTrue(true);
			macc.clickLogout();
		}
		else {
			Assert.assertTrue(false);
		}
		}
		if(exp.equalsIgnoreCase("Invalid")) {
			if(targetPage==true) {
				macc.clickLogout();
				Assert.assertTrue(false);
				;
			}
			else {
				Assert.assertTrue(true);
			}
			}
	}
	
	catch(Exception e){
		Assert.fail();
	}
	
		logger.info("*******Finished TC003_LoginDDTTest *****");
		
}
}
