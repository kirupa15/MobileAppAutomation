package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import wrappers.GenericWrappers;

public class DeviceMenuPage extends GenericWrappers{

	private AndroidDriver driver;

	// Locate all elements on the page

	@FindBy(xpath = "//android.widget.TextView[@text='']")
	private WebElement deviceSettingsButton;

	@FindBy(xpath = "//android.widget.TextView[@text='Reset Device']")
	private WebElement resetDeviceButtom;
	
	@FindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
	private WebElement resetConfirmationYesButton;
	
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
	
	@FindBy(xpath ="//android.view.ViewGroup[@content-desc=\"com.szephyr:id/menu_icon_geyserInfo, com.szephyr:id/menu_text_geyserInfo\"]")
	private WebElement szephyr_info_button;
	

	
	
	
	
	
	// Constructor to initialize the driver and instantiate elements using
	
	public DeviceMenuPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Methods to be used as part of loginpage.
	
	public void clickDeviceSettingsButton() {
		clickbyXpath(deviceSettingsButton, " Device Settings Button  ");
	}
	
	public void clickResetDeviceButton() {
		clickbyXpath(resetDeviceButtom, " Pairing Mode Check Box ");
	}
	
	public void clickResetConfirmationYesButton() {	
		clickbyXpath(resetConfirmationYesButton, " Pairing mode Next Button ");
	}
	public void clickszephyr_info_button() {	
		clickbyXpath(szephyr_info_button, " Szphyr_info_menubar");
	}
	
	

}
