package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import wrappers.GenericWrappers;

public class DeviceMenuPage extends GenericWrappers{

	private AndroidDriver<AndroidElement> driver;

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
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"com.szephyr:id/menu_icon_geyserInfo, com.szephyr:id/menu_text_geyserInfo\"]")
	private WebElement ClickSzephyrInfoButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Carrier\"]")
	private WebElement CheckSzephyrInfPageBrandName;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"G20\"]")
	private WebElement CheckSzephyrInfPageModelName;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"2\"]")
	private WebElement CheckSzephyrInfPageCapacity;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Medium\"]")
	private WebElement CheckSzephyrInfPageRoomSize;
	
	@FindBy(xpath = "//android.widget.TextView[@content-desc=\"com.szephyr:id/DeviceSetting_energysaving\"]")
	private WebElement ClickESMButton;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"com.szephyr:id/AutoPowerON/OFF_Switch\"]/android.view.ViewGroup/android.view.ViewGroup")
	private WebElement EnableToogleSwtich;
	
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"com.szephyr:id/AutoPowerON/OFF_Switch\"]")
	private WebElement DisableToogleSwtich;
	
	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/com.horcrux.svg.SvgView[1]/com.horcrux.svg.GroupView/com.horcrux.svg.PathView[1]")
	private WebElement Clickmoderatecooling;
	
	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[3]/com.horcrux.svg.SvgView[1]/com.horcrux.svg.GroupView/com.horcrux.svg.PathView[1]")
	private WebElement ClickPropercooling;
	
	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/com.horcrux.svg.SvgView[1]/com.horcrux.svg.GroupView/com.horcrux.svg.PathView[1]")
	private WebElement ClickLesscooling;
	
	@FindBy(xpath = "//android.widget.TextView[@content-desc=\"com.szephyr:id/DeviceON/OFF_Ok_ButtonText\"]")
	private WebElement EsmOKbutton;
	
	@FindBy(xpath = "//android.widget.Toast[@text=\"Connect with device and try again\"]")
	private WebElement ToastForwithoutconnectivity;
	
	@FindBy(xpath = "//android.widget.Toast[@text=\"Energy saving mode updated successfully\"]")
	private WebElement SuccessfullyToast;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"com.szephyr:id/Device_BackIcon\"]")
	private WebElement ESMPageBackButton;

	@FindBy(xpath = "//*[@resource-id='menu_icon_logout']")
	private WebElement logoutButton;
	
	@FindBy(xpath = "//*[@resource-id='logoutIcon']")
	private WebElement logoutButtonAfterReset;

	
	@FindBy(xpath = "//*[@resource-id='Logout_LOGOUT']")
	private WebElement logoutConfirmationButton;
	
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
	
	

	public void clickLogoutButton() {
		clickbyXpath(logoutButton, " Logout button ");
	}
	
	public void clickLogoutButtonAfterReset() {
		clickbyXpath(logoutButtonAfterReset, " Logout button ");
	}
	
	public void clickLogoutConfirmationButton() {
		clickbyXpath(logoutConfirmationButton, " Logout button ");
	}
	public void ClickSzephyrInfoButton() {	
		clickbyXpath(ClickSzephyrInfoButton, " Szephyr Info ");
	}
       //Szephyr Info page
	public void CheckSzephyrInfPageBrandName() {

		verifyTextContainsByXpath( CheckSzephyrInfPageBrandName, "Carrier", "AC Brand Name");
    }
	public void CheckSzephyrInfPageModelName() {

		verifyTextContainsByXpath( CheckSzephyrInfPageModelName, "G20", "Model Name");
    }
	public void CheckSzephyrInfPageCapacity() {

		verifyTextContainsByXpath( CheckSzephyrInfPageCapacity, "2", "Capacity");
    }
	public void CheckSzephyrInfPageRoomSize() {

		verifyTextContainsByXpath( CheckSzephyrInfPageRoomSize, "Medium", "Room Size");
    }

	//Engery Saving Elements	
	
	public void ToastForwithoutconnectivity() {

		verifyTextContainsByXpath( ToastForwithoutconnectivity, "Connect with device and try again", "esM");
    }
	
	public void checkSuccessfullyToast() {

		verifyTextContainsByXpath( SuccessfullyToast, "Energy saving mode updated successfully", "EnableToast");
    }
	
	public void CheckEsmButton() {	
		clickbyXpath(ClickESMButton, " Click energy Saving schedule ");
	}
	
	public void ClicktoggleButton() {	
		clickbyXpath(EnableToogleSwtich, " Click Enable toggle ");
	}
	
	public void ClickToggledisable() {	
		clickbyXpath(DisableToogleSwtich, " Click Disable toggle ");
	}
	
	public void CheckModeratefeature() {	
		clickbyXpath(Clickmoderatecooling, " Select Moderate ");
	}
	
	public void CheckProperfeature() {	
		clickbyXpath(ClickPropercooling, " Select Proper cooling ");
	}
	
	public void CheckLessfeature() {	
		clickbyXpath(ClickLesscooling, " Select Less cooling ");
	}
	
	public void ClickEsmOKButton() {	
		clickbyXpath(EsmOKbutton, " EnergySaving Button OK ");
	}
	
	public void ClickBackButtonESM() {	
		clickbyXpath(ESMPageBackButton, " Back button ESM page ");
	}
	
	
}
