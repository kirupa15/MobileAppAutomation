package pages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import wrappers.GenericWrappers;

public class LoginPage extends GenericWrappers {

	private AndroidDriver driver;

	// Locate all elements on the page
	@FindBy(xpath = "//android.widget.EditText[@text='Email or User Name']")
	private WebElement userNameField;

	@FindBy(xpath = "//android.widget.TextView[@text='Sign In']")
	private WebElement signInButton;

	// Constructor to initialize the driver and instantiate elements using
	
	public LoginPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Methods to be used as part of loginpage.
	
	public void enterEmailId(String email) {
		entervaluebyXpath(userNameField, " User Name " , email);
	}

	
	public void clickSignInButton() {
		clickbyXpath(signInButton, " Sign In ");
		
	}

}
