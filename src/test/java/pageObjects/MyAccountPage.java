package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	// TODO Auto-generated constructor stub
	@FindBy(xpath = "//h2[text()='My Account']") // My Account Page Heading
	WebElement msgHeading;
	@FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']") // added in step-6
	WebElement lnklogout;

	public boolean isMyAccountPageExists() {
		try {
			return (msgHeading.isDisplayed());
		}
		catch(Exception e) {
			return false;
		}
		
	}
	public void clickLogout() {
		lnklogout.click();
	}
}
