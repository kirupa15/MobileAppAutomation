package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import wrappers.GenericWrappers;

public class AddDevicePage extends GenericWrappers{

	private AndroidDriver driver;

	// Locate all elements on the page

	@FindBy(xpath = "//android.widget.TextView[@text='Add Device']")
	private WebElement addDeviceButton;

	@FindBy(xpath = "//android.widget.CheckBox")
	private WebElement checkBoxPairing;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Next']")
	private WebElement nextButtonPairing;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Start Pairing']")
	private WebElement startPairingButton;
	
	@FindBy(xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']")
	private WebElement locationPopUp;
	
	@FindBy(xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_button']")
	private WebElement nearByPermisson;
	
	@FindBy(xpath = "//android.widget.EditText[@text='Enter Password']")
	private WebElement enterPasswordField;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Enter']")
	private WebElement enterButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Next']")
	private WebElement nextButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Submit']")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//android.view.ViewGroup[@resource-id='Add_Device_Next_Button']")
	private WebElement sZephyrInfoNextButton;
	
	@FindBy(xpath = "//android.view.ViewGroup[@resource-id='UserConfig_Submit_Button']")
	private WebElement deviceSettingSubmitButton;
	
	
	
	
	// Constructor to initialize the driver and instantiate elements using
	
	public AddDevicePage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Methods to be used as part of loginpage.
	
	public void clickAddDeviceButton() {
		clickbyXpath(addDeviceButton, " Add Device Button  ");
	}
	
	public void checkBoxPairing() {
		clickbyXpath(checkBoxPairing, " Pairing Mode Check Box ");
	}
	
	public void nextButtonPairing() {	
		clickbyXpath(nextButtonPairing, " Pairing mode Next Button ");
	}
		public void startPairingButton() {
		clickbyXpath(startPairingButton, " Start Pairing " );
	}
	
	public void locationPopUpPermission() {
		clickbyXpathwithoutReport(locationPopUp, " Location Permission pop up " );
	}
	
	public void nearByPermission() {
		clickbyXpathwithoutReport(nearByPermisson, " Near by devices Permission  " );
	}
	
	public void enterWiFiPassword(String password) {
		entervaluebyXpath(enterPasswordField, " Wifi Password  ", password );
	}
	
	public void clickEnterButton() {
		
		clickbyXpath(enterButton, " Enter Button  " );
	}

	public void clickNextButton() {
		clickbyXpath(nextButton, " Enter Button  " );
	}
	
	public void submitButton() {
		clickbyXpath(submitBtn," Submit Button ");
	}
	

	public void clickNextButtonsZephyrInfo() {
		expWaitforPairing(sZephyrInfoNextButton);
		clickbyXpath(sZephyrInfoNextButton, " Next Button ");
	}
	
	public void clickSubmitButtonDeviceSetting() {
		clickbyXpath(deviceSettingSubmitButton, " Next Button ");
	}
	

}
