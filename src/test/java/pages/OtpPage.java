package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import wrappers.GenericWrappers;

public class OtpPage extends GenericWrappers {

	private AndroidDriver driver;

	// Locate all elements on the page

	@FindBy(xpath = "(//android.widget.EditText[@resource-id='textInput'])[1]")
	private WebElement otpField1;

	@FindBy(xpath = "(//android.widget.EditText[@resource-id='textInput'])[2]")
	private WebElement otpField2;
	
	@FindBy(xpath = "(//android.widget.EditText[@resource-id='textInput'])[3]")
	private WebElement otpField3;
	
	@FindBy(xpath = "(//android.widget.EditText[@resource-id='textInput'])[4]")
	private WebElement otpField4;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Submit']")
	private WebElement submitBtn;

	// Constructor to initialize the driver and instantiate elements using
	
	public OtpPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Methods to be used as part of loginpage.
	
	public void enterOTPField1(String otp1) {
		
		entervaluebyXpath(otpField1, " OTP Box 1 " , otp1);
	}
	
	public void enterOTPField2(String otp2) {
		
		entervaluebyXpath(otpField2, " OTP Box 2 ", otp2);
	}
	
	public void enterOTPField3(String otp3) {
		
		entervaluebyXpath(otpField3, " OTP Box 3 ", otp3);
	}
	
	public void enterOTPField4(String otp4) {
		
		entervaluebyXpath(otpField4, " OTP Box 4 " , otp4);
	}

	public void submitButton() {
		
		clickbyXpath(submitBtn," Submit Button ");
	}
	
}
