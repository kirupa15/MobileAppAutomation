package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileBy;
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
	
	@FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button2\"]")
	private WebElement ClickCancelBluetooth;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"com.szephyr:id/Wifi_RouterPasswerd_Cancel\"]")
	private WebElement ClickCancelWifi;
	
	@FindBy(xpath =  "//android.widget.Button[@resource-id=\"android:id/button1\"]")
	private WebElement ClickOkButtonBLEpopUP;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Add Router, Choosing to add a router will add a router to your device.\"]")
	private WebElement ClickaddrouterButton;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"com.szephyr:id/Device_BackIcon\"]")
	private WebElement ClickDeviceSettingback;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"\"]")
	private WebElement clickAddDeviceButton;
	
	@FindBy(xpath = "//android.widget.TextView[@content-desc=\"com.szephyr:id/AddDevice_NewDevicePairing_ButtonText\"]")
	private WebElement clickNewDevicePairingButton;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"nee_1\"]")
	private WebElement clickFirstDeviceButton;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"nee_2\"]")
	private WebElement clickSecondDeviceButton;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"nee_3\"]")
	private WebElement clickThirdDeviceButton;
	
	@FindBy(xpath = "//android.widget.TextView[@content-desc=\"com.szephyr:id/DeviceSetting_highVoltageConfig\"]")
	private WebElement lowvoltageconfiguration;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"com.szephyr:id/Device_BackIcon\"]")
	private WebElement DevicesettingsbackButton;
	// Constructor to initialize the driver and instantiate elements using
	
	
	
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Add Router, Choosing to add a router will add a router to your device.\"]")
	private WebElement addRouterButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Remove router\"]")
	private WebElement removeRouterButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"CANCEL\"]")
	private WebElement removeRouterCancelButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"REMOVE\"]")
	private WebElement removeRouterRemoveButton;
	
	@FindBy(xpath = "//android.widget.CheckBox[@content-desc=\"com.szephyr:id/Wifi_RouterPasswerd_CheckBox\"]")
	private WebElement addRouterPopCheckBox;
	
	@FindBy(xpath = "//android.widget.TextView[@content-desc=\"com.szephyr:id/Wifi_RouterPasswerd_Cancel_Text\"]")
	private WebElement routerPopCancelButton;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"com.szephyr:id/DeviceSetting_LEDQuietMode\"]/android.view.ViewGroup")
	private WebElement quietLEDToggleEnable;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"com.szephyr:id/DeviceSetting_LEDQuietMode\"]/android.view.ViewGroup")
	private WebElement quietLEDToggleDisable;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"com.szephyr:id/Device_BackIcon\"]")
	private WebElement deviceSettingsPageBackButton;
	
	@FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button3\"]")
	private WebElement shellallow;
	
	@FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button2\"]")
	private WebElement shelldeny;
	
	@FindBy(xpath = "//android.widget.Switch[@content-desc=\"com.szephyr:id/UserConfig_Switch4\"]")
	private WebElement infiniteToggle ;
	
	@FindBy(xpath = "(//android.widget.TextView[@text=\"\"])[1]")
	private WebElement hoursPlusButton ;
	
	@FindBy(xpath = "//android.widget.TextView[@content-desc=\"com.szephyr:id/UserConfig_Submit_ButtonText\"]")
	private WebElement infiniteSubmitButton ;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"com.szephyr:id/DeviceSetting_DurationforON, com.szephyr:id/DeviceSetting_DurationforON_Icon\"]")
	private WebElement durationForON;
	
	@FindBy(xpath = "//android.widget.Switch[@content-desc=\"com.szephyr:id/UserConfig_Switch3\"]")
	private WebElement pairingTimeQuietLEDEnable;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"com.szephyr:id/menu_icon_removeDevice, com.szephyr:id/menu_text_removeDevice\"]")
	private WebElement removeDevice;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"NO\"]")
	private WebElement removeDevicePopupNoButton;
	
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"YES\"]")
	private WebElement removeDevicePopupYesButton;
	
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
	
	@SuppressWarnings("deprecation")
	public void ClickaddrouterButton() {
//		expWaitforPairing(ClickaddrouterButton);
		driver.findElement(MobileBy.AndroidUIAutomator(
			    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Add Router\"));"))
			    .click();
//		clickbyXpath(ClickaddrouterButton, " add router button ");
	}
	public void checkcontentlowvoltage() {	
		verifyTextContainsByXpath(lowvoltageconfiguration, "Low voltage configuration" , "Device Settings");
	}
	
	public void clickDevicesettingsbackButton() {	
		clickbyXpath(DevicesettingsbackButton, " Device Setting Back Button ");
	}
	
	
	public void ClickDeviceSettingback() {	
		clickbyXpath(ClickDeviceSettingback, " Device setting back button ");
	}
	
	public void clickAddDeviceButton() {	
		clickbyXpath(clickAddDeviceButton, " Add Device ");
	}
	
	public void clickNewDevicePairingButton() {	
		clickbyXpath(clickNewDevicePairingButton, " Add New Device ");
	}
	
	public void clickFirstDeviceButton() {	
		clickbyXpath(clickFirstDeviceButton, " Add First Device ");
	}
	
	public void clickSecondDeviceButton() {	
		clickbyXpath(clickSecondDeviceButton, " Add Second Device ");
	}
	
	public void clickThirdDeviceButton() {	
		clickbyXpath(clickThirdDeviceButton, " Add Third Device ");
	}
	
	public void ClickCancelBluetooth() {	
		clickbyXpath(ClickCancelBluetooth, " Cancel Bluetooth Button ");
	}
	
	public void ClickOkButtonBLEpopUP() {
		expWaitforPairing(ClickOkButtonBLEpopUP);
		clickbyXpath(ClickOkButtonBLEpopUP, " Click OK  Bluetooth Button Popup ");
	}
	
	public void ClickCancelWifi() {
		expWaitforPairing(ClickCancelWifi);
		clickbyXpath(ClickCancelWifi, " Click Cancel Wifi Popup ");
	}
	public void clickRemoveRouterButton() {	
    	clickbyXpath(removeRouterButton, " Click Remove Router Button ");
	}
	
		public void clickRemoveRouterCancelButton() {	
			clickbyXpath(removeRouterCancelButton, " Click Remove Router Cancel Button ");
		}
		

        public void clickRemoveRouterRemoveButton() {	
	        clickbyXpath(removeRouterRemoveButton, " Click Remove Router Remove Button ");
       }
	
        public void clickAddRouterCheckBox() {	
	        clickbyXpath(addRouterPopCheckBox, " Click Add Router Pop-up Check Box ");
        }
        
        public void clickRouterPopCancelButton() {	
	        clickbyXpath(routerPopCancelButton, " Click Add Router Pop-up Cancel Button ");
        }
        
        public void clickQuietLEDToggleForOn() {	
	        clickbyXpath(quietLEDToggleEnable, " Enable The Quiet LED Toggle ");
       }
        
        public void clickQuietLEDToggleForOff() {	
	        clickbyXpath(quietLEDToggleDisable, " Disable The Quiet LED Toggle ");
        }

		public void clickDeviceSettingsBackButton() {
			clickbyXpath(deviceSettingsPageBackButton, " Click The Device Settings Page Back Button ");
        }
		
		
		public void clickInfiniteSubmitButton() {
			clickbyXpath(infiniteSubmitButton, " Click The Submit Button ");
			
		}
		
		public void clickDurationForONButton() {
			clickbyXpath(durationForON, " Click The ON Duration Button ");
			
		}

		public void clickInfinitePowerToggle() {
			clickbyXpath(infiniteToggle, " Disable The Infinite Toggle ");
			
		}

		public void clickHoursPlusButton() {
			clickbyXpath(hoursPlusButton, " Click The Hours Plus Button ");
			
		}
		
		public void clickPairingTimeQuietLEDEnable() {
			clickbyXpath(pairingTimeQuietLEDEnable, " Click The LED Quiet MOde Toggle ");
			
		}
		
		public void clickMenuBarRemoveDevice() {
			clickbyXpath(removeDevice, " Click The Remove Device Button ");
			
		}	
		
		public void clickRemoveDevicePopupNoButton() {
			clickbyXpath(removeDevicePopupNoButton, " Click The Remove Device Pop-up ON Button ");
			
		}	
		
		public void clickRemoveDevicePopupYesButton() {
			clickbyXpath(removeDevicePopupYesButton, " Click The Remove Device Pop-up YES Button ");
			
		}	
		
		public void shellAllowpopup() {	
			expWait(shellallow);
			clickbyXpath(shellallow, " allow shell ");
		}
		public void shellDenypopup() {	
			clickbyXpath(shelldeny, " deny shell ");
		}
		
		
		
		
}
