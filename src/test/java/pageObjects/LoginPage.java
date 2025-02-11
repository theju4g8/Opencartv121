package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmailAddres;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@value='Login']") // login link added in step-5
	WebElement btnLogin;

	public void setEmail(String email) {
		txtEmailAddres.sendKeys(email);

	}
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);  

	}
	public void clickLogin() {
		btnLogin.click();
	}
	}


