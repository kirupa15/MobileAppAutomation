package pages;

import org.openqa.selenium.JavascriptExecutor;
import java.io.IOException;
import org.openqa.selenium.WebElement;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.appmanagement.ApplicationState;
import wrappers.GenericWrappers;

public class AddDevicePage extends GenericWrappers {

	public static AndroidDriver<AndroidElement> driver;

	// Locate all elements on the page

	@FindBy(xpath = "//*[@resource-id='Add_Devices_ButtonText']")
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


	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"com.szephyr:id/Wifi_RouterPasswerd_Cancel\"]")
	private WebElement cancelButton;


	@FindBy(xpath = "//android.widget.TextView[@text='Enter']")
	private WebElement enterButton;

	@FindBy(xpath = "//*[@resource-id='Wifi_RouterPasswerd_Cancel']")
	private WebElement routerCancelButton;

	@FindBy(xpath = "//android.widget.TextView[@text='Next']")
	private WebElement nextButton;

	@FindBy(xpath = "//android.widget.TextView[@text='Submit']")
	private WebElement submitBtn;

	@FindBy(xpath =  "//android.view.ViewGroup[@content-desc=\", Select Brand\"]")
	private WebElement ClickBrandName;

	@FindBy(xpath =  "//android.widget.TextView[@text=\"Carrier\"]")
	private WebElement ClickSelectName;

	@FindBy(xpath =  "//android.widget.EditText[@content-desc=\"com.szephyr:id/Add_Device_Ac_ModelName_Input\"]")
	private WebElement enterAcModelName;

	@FindBy(xpath =  "//android.widget.EditText[@content-desc=\"com.szephyr:id/Add_Device_Capacity_Input\"]")
	private WebElement enterCapacity;

	@FindBy(xpath =  "//android.widget.TextView[@text=\"Select room size\"]")
	private WebElement ClickRoomSizeButton;

	@FindBy(xpath =  "//android.widget.TextView[@text=\"Medium\"]")
	private WebElement SelectRoomSizeOption;

	@FindBy(xpath = "//android.view.ViewGroup[@resource-id='Add_Device_Next_Button']")
	private WebElement sZephyrInfoNextButton;

	@FindBy(xpath = "//android.view.ViewGroup[@resource-id='UserConfig_Submit_Button']")
	private WebElement deviceSettingSubmitButton;

	@FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
	private WebElement connectbuttonWifipage;
	@FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
	private WebElement devicewifipop_upOK;
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/alertTitle\"]")
	private WebElement devicewifipop_up;
	@FindBy(xpath = "//android.widget.TextView[@text='Sign In']")
	private WebElement signInButton;
	@FindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]")
	private WebElement locationpermissionpopup;
	@FindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")
	private WebElement devicepermission;
	@FindBy(xpath = "//android.widget.TextView[@text=\"sZephyr and AC turned ON\"]")
	private WebElement Acturnondesc;
	@FindBy(xpath = "//android.widget.TextView[@text=\"Please ensure sZephyr is switched ON prior to operating your AC remote\"]")
	private WebElement acturnoffdesc;
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/alertTitle\"]")
	private WebElement alertpopup;
	@FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
	private WebElement shellallow;
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/message\"]")
	private WebElement shellmessage;

	@FindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
	private WebElement Blepopup_afterpairing;
	@FindBy(xpath = "//android.widget.TextView[@content-desc=\"com.szephyr:id/Retrying_header_line\"]")
	private WebElement Retrypagetext;


	@FindBy(xpath = "//android.widget.TextView[@content-desc=\"com.szephyr:id/Retrying_Retry_Button_Text\"]")
	private WebElement Retrypageretrybutton;
	@FindBy(xpath = "//android.widget.TextView[@content-desc=\"com.szephyr:id/Retrying_Cancel_Button_Text\"]")
	private WebElement Retrypagecancelbutton;
	//android.widget.Button[@resource-id="android:id/button1"]

	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[7]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.CircleView[1]")
	private WebElement deviceONOFFButton;

	@FindBy(xpath = "//android.widget.TextView[@content-desc=\"com.szephyr:id/Wifi_RouterPasswerd_Cancel_Text\"]")
	private WebElement ClickCancelButtonWifi;
	
	@FindBy(xpath = "//android.widget.EditText[@content-desc=\"com.szephyr:id/Add_Device_YourDevice\"]")
	private WebElement szephyrDeviceName;
	
	@FindBy(xpath ="//android.view.ViewGroup[@content-desc=\", Select Brand\"]")
	private WebElement ACBrandNameClick;
	
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Carrier\"]")
	private WebElement ACBrandNameCarrier;
	
	@FindBy(xpath = "//android.widget.EditText[@content-desc=\"com.szephyr:id/Add_Device_Ac_ModelName_Input\"]")
	private WebElement ACModelName;
	
	@FindBy(xpath = "//android.widget.EditText[@content-desc=\"com.szephyr:id/Add_Device_Capacity_Input\"]")
	private WebElement Capacity;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Select room size\"]")
	private WebElement RoomSizeselect;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Small\"]")
	private WebElement RoomSizesmall;
	
	@FindBy(xpath = "//android.widget.Switch[@content-desc=\"com.szephyr:id/UserConfig_Switch3\"]")
	private WebElement Ledquietmode;
	
	@FindBy(xpath = "//android.widget.Switch[@content-desc=\"com.szephyr:id/UserConfig_Switch4\"]")
	private WebElement infinitepoweron;
	
	@FindBy(xpath = "(//android.widget.TextView[@text=\"\"])[1]")
	private WebElement hoursplusbutton ;
	
	@FindBy(xpath = "(//android.widget.TextView[@text=\"\"])[2]")
	private WebElement minutesplusbutton ;
	
	@FindBy(xpath = "(//android.widget.TextView[@text=\"\"])[2]")
   	private WebElement minutesminusbutton ;
	
	@FindBy(xpath ="//android.widget.Button[@resource-id=\"android:id/button2\"]")
	private WebElement ClickCancelButtonBle;
	
	@FindBy(xpath ="//android.widget.Button[@resource-id=\"android:id/button1\"]")
	private WebElement ClickOkButtonBLEpopUP;
	
	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[7]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.CircleView[1]")
	private WebElement enterpasswordwifipge1;
	
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"com.szephyr:id/DeviceSetting_DurationforON, com.szephyr:id/DeviceSetting_DurationforON_Icon\"]")
	private WebElement durationforON;
    
    @FindBy(xpath = "//android.widget.EditText[@text=\"0\"]")
   	private WebElement hourstextbox ;
    
    @FindBy(xpath = "//android.widget.EditText[@text=\"19\"]")
   	private WebElement minutestextbox; 
	
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"com.szephyr:id/DeviceSetting_DurationforON, com.szephyr:id/DeviceSetting_DurationforON_Icon\"]")
   	private WebElement clickokdurationON; 
  
   	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"com.szephyr:id/Device_BackIcon\"]")
   	private WebElement backbuttonDevicesettings; 
	
   	@FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
	private WebElement blePermissionOkButton;

  //android.widget.Button[@resource-id="android:id/button2"]
  //android.widget.Button[@resource-id="android:id/button1"]
	@FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button2\"]")
	private WebElement blePermissionCancelButton;

	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"com.android.settings:id/password\"]")
	private WebElement enterpasswordwifipge;

	@FindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
	private WebElement BleOKpopup;

	
	@FindBy(xpath = "//android.widget.Button[@resource-id='android:id/button2']")
	private WebElement BLEcancelpopup;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"com.szephyr:id/Wifi_RouterPasswerd_Cancel\"]")
	private WebElement wifiCancel;


	// Constructor to initialize the driver and instantiate elements using

	public AddDevicePage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.js = (JavascriptExecutor) driver;
	}

	JavascriptExecutor js = (JavascriptExecutor) driver;

	// Methods to be used as part of loginpage.

	public AddDevicePage clickAddDeviceButton() {
		clickbyXpath(addDeviceButton, " Add Device Button  ");
		return this;
	}

	public AddDevicePage checkBoxPairing() {
		clickbyXpath(checkBoxPairing, " Pairing Mode Check Box ");
		return this;
	}

	public void nextButtonPairing() {
		clickbyXpath(nextButtonPairing, " Pairing mode Next Button ");
	}

	public void startPairingButton() {
		clickbyXpath(startPairingButton, " Start Pairing ");
		}

	public void locationPopUpPermission() {
		if (isElementDisplayed(locationPopUp)) {
			clickbyXpath(locationPopUp, "Location pop-up");
		} else {
			System.out.println("not asked for precise or approx location");

		}
		//		clickbyXpathwithoutReport(locationPopUp, " Location Permission pop up " );
	}

	public void nearByPermission() {
		if (isElementDisplayed(nearByPermisson)) {

			clickbyXpathwithoutReport(nearByPermisson, " Near by devices Permission  ");
		}
	}

	public void enterWiFiPassword(String password) {
		entervaluebyXpath(enterPasswordField, " Wifi Password  ", password);
	}

	public void clickRouterCancelButton() {
		clickbyXpathwithoutReport(routerCancelButton, " Add router Cancel button" );
	}

	public void clickEnterButton() {

		clickbyXpath(enterButton, " Enter Button  ");
	}


	public void clickNextButton() {
		clickbyXpath(nextButton, " Enter Button  ");
	}

	public void submitButton() {
		clickbyXpath(submitBtn, " Submit Button ");
	}

	public void clickNextButtonsZephyrInfo() {
		expWaitforPairing(sZephyrInfoNextButton);
		clickbyXpath(sZephyrInfoNextButton, " Next Button ");
	}



	public void ClickBrandName() {
		expWaitforPairing(ClickBrandName);
		clickbyXpath(ClickBrandName," Ac Brand Name ");
	}

	public void ClickSelectName() {
		clickbyXpath(ClickSelectName," Select Brand Name ");
	}

	public void enterAcModelName(String entermodelname) {
		entervaluebyXpath(enterAcModelName," AC Model Name " ,entermodelname );
	}

	public void enterCapacity(String Capacity) {
		entervaluebyXpath(enterCapacity," AC Model Name " ,Capacity );
	}

	public void ClickRoomSizeButton() {
		clickbyXpath(ClickRoomSizeButton," Room Size ");
	}

	public void SelectRoomSizeOption() {
		clickbyXpath(SelectRoomSizeOption," Select room size ");
	}


	public void ClickCancelButtonBle() {
		clickbyXpath(ClickCancelButtonBle," Cancel Button ");

	}


	public void cancelButton() {
		expWaitforPairing(cancelButton);
		clickbyXpathwithoutReport(cancelButton," Wifi cancel Button ");

	}		

	public void ClickOkButtonBLEpopUP() {
		expWaitforPairing(ClickOkButtonBLEpopUP);
		clickbyXpathwithoutReport(ClickOkButtonBLEpopUP," Ok Ble Button ");	

	}

	public void clickSubmitButtonDeviceSetting() {
		clickbyXpath(deviceSettingSubmitButton, " Next Button ");
	}


	public void clickBlePermissionCancelbutton() {
		clickbyXpath(blePermissionCancelButton, " Ble Popup Cancel Button ");
	}


	public void clickBlePermissionOkbutton() {
		expWaitforPairing(blePermissionOkButton);
		clickbyXpath(blePermissionOkButton, " Ble Popup Cancel Button ");
	}

	public void verifyAddDevicePage(String title) {
		verifyTextContainsByXpath(addDeviceButton, title, " ADD device Page ");
	}

	public void turnOnBluetooth() {

		try {
			Runtime.getRuntime().exec("adb shell svc bluetooth enable");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void turnOffBluetooth() {

		try {
			Runtime.getRuntime().exec("adb shell svc bluetooth disable");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void turnOnWifi() {

		try {
			Runtime.getRuntime().exec("adb shell svc wifi enable");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void turnOffWifi() {

		try {
			Runtime.getRuntime().exec("adb shell svc wifi disable");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public void clickWifiCancelButton() {
		wait.until(ExpectedConditions.visibilityOf(wifiCancel));
		clickbyXpath(wifiCancel, "Wificancel button");
	}

	public void clickBleokbutton() {
		wait.until(ExpectedConditions.visibilityOf(BleOKpopup));
		clickbyXpath(BleOKpopup, "Ble okbutton");
	}

	public void clickBleCancelbutton() {
		wait.until(ExpectedConditions.visibilityOf(BLEcancelpopup));
		clickbyXpath(BLEcancelpopup, "Ble Cancelbutton");
	}

	
public void aCBrandNameClick ()
	
	{	
		expWaitforPairing(ACBrandNameClick);
		clickbyXpath( ACBrandNameClick,"Acbrandname");
	}
    public void aCBrandNameCarrierclick()
	
	{	
		expWaitforPairing(ACBrandNameClick);
		clickbyXpath( ACBrandNameCarrier,"Acbrandname");
	}
	
    public void roomSizeselect()
    {
		clickbyXpath(RoomSizeselect, " room Size ");
	}
    public void roomSizesmall() 
    {
		clickbyXpath(RoomSizesmall, "Select room size ");
	}
    
    public void clickLedquietmode() 
    {
		clickbyXpath(Ledquietmode, "LED enable disable ");
	}
    
    public void Alertpopup() 
    {
		clickbyXpath(alertpopup, "Inn_alertpopup");
	}
    public void LEDquietmode() 
    {
		clickbyXpath(Ledquietmode, "enabling LED Quiet mode");
	}
	
    public void Infinitepoweron() 
    {
		clickbyXpath(infinitepoweron, "Clicking INFINITE Power On disable");
	}
    
    public void hoursplusbutton () 
    {
		clickbyXpath(hoursplusbutton , "Clicking Hours plus button set 0");
	}
    
    public void Minutesminusbutton () 
    {
		clickbyXpath(minutesminusbutton , "Clicking Hours plus button set 0");
	}
	
    public void DurationforON () 
    {
		clickbyXpath(durationforON , "Clicking Duration for ON");
	}
    
	public void Hourstextbox()
	{	
		verifyTextContainsByXpath(hourstextbox , "0", "Hours");
	}
	
	public void Minutestextbox()
	{	
		verifyTextContainsByXpath(minutestextbox , "19", "Minutes");
	}
	public void ClickokdurationON()
	{
		//wait.until(ExpectedConditions.visibilityOf(clickokdurationON));
		clickbyXpath(clickokdurationON, "OKbutton_Duration for ON");
	}
	
	 public void BackbuttonDevicesettings () 
	    {
			clickbyXpath(backbuttonDevicesettings , "back button click");
		}
	
	
	
	String serialno = "iinv_smartac";

	LandingPage landingpage;
	SignInPage loginpage;
	HomePage homepage;
	OtpPage otppage;
	//	AddDevicePage adddevicepage;
	DeviceMenuPage devicemenupage;

	public void pair(int mode) throws Exception {
		loginpage = new SignInPage(driver);
		landingpage = new LandingPage(driver);
		homepage = new HomePage(driver);
		//		adddevicepage = new AddDevicePage(driver);
		otppage = new OtpPage(driver);
		verifysigninpage();
		initiatepairing(mode);
	}

	public void verifysigninpage() throws Exception {

		if (isElementDisplayed(signInButton)) {

			landingpage.clickSignInButton();
			loginpage.enterUserName("testuser007@gmail.com");
			loginpage.clickSignInButton();
			otppage.enterOTPField1("1");
			otppage.enterOTPField2("2");
			otppage.enterOTPField3("3");
			otppage.enterOTPField4("4");
			otppage.submitButton();

		} else {
			System.out.println("App is already Installed and opening the previous state");
		}
	}

	public void initiatepairing(int mode) throws Exception {

		if (isElementDisplayed(locationpermissionpopup)) {
			clickbyXpath(locationpermissionpopup, "Location pop-up");

			// Check if device permission popup appears after location permission
			if (isElementDisplayed(devicepermission)) {
				clickbyXpath(devicepermission, "Device permission pop-up");
			}
			if (isElementDisplayed(blePermissionOkButton)) {
				clickByXpath(blePermissionOkButton, "Allowing Ble permission pop-up");
			}
			if (acturnoffdesc.isDisplayed()) {
				System.out.println("Device is already paired..");
			}

			// Proceed to add the device if no further permission popups
		} else {
			// No location permission popup, proceed to add the device
			proceedToAddDevice(mode);
		}
	}

	//	mode=1-Ble without router ,2-Ble with router,3-Smartconfig,

	public void proceedToAddDevice(int mode) throws Exception {
		if (isElementDisplayed(addDeviceButton)) {

			clickAddDeviceButton();
			checkBoxPairing();
			nextButtonPairing();

			switch (mode) {
			case 1:
				turnOnBT();
				startPairingButton();
				if (isElementDisplayed(alertpopup)) {
					BleOKpopup.click();
					Thread.sleep(2000);
					driver.navigate().back();
				} else {
					System.out.println("Ble is in ON state");
				}
				locationPopUpPermission();
				nearByPermission();

				Thread.sleep(3000);
				if (isElementDisplayed(alertpopup)) {
					BleOKpopup.click();
					Thread.sleep(2000);
					driver.navigate().back();
					Thread.sleep(2000);
				} else {
					System.out.println("No alert pop ups displayed");
				}

				clickWifiCancelButton();

				break;

			case 2:
				turnOnBT();

				startPairingButton();
				if (isElementDisplayed(alertpopup)) {
					BleOKpopup.click();
					Thread.sleep(2000);
					driver.navigate().back();
				} else {
					System.out.println("Ble is in ON state");
				}
				Thread.sleep(3000);
				locationPopUpPermission();
				nearByPermission();

				Thread.sleep(3000);
				if (isElementDisplayed(alertpopup)) {
					BleOKpopup.click();
					Thread.sleep(2000);
					driver.navigate().back();
				} else {
					System.out.println("Alert pop-up not displayed");
				}
				enterWiFiPassword("12345678908");
				clickEnterButton();
				break;
			case 3:
				turnOffBT();

				startPairingButton();
				if (isElementDisplayed(alertpopup)) {

					BLEcancelpopup.click();
					Thread.sleep(2000);
					//					driver.navigate().back();

				} else {
					System.out.println("Ble is in ON state");
				}
				Thread.sleep(3000);
				locationPopUpPermission();
				nearByPermission();

				if (isElementDisplayed(blePermissionOkButton)) {

					blePermissionCancelButton.click();
					Thread.sleep(2000);
					//					driver.navigate().back();

				} else {
					System.out.println("Alert pop-up not displayed");
				}
				Thread.sleep(3000);

				enterWiFiPassword("12345678908");
				clickEnterButton();
				
				Thread.sleep(20000);
				
				if (isElementDisplayed(alertpopup)) {
					BleOKpopup.click();
					Thread.sleep(2000);
//					driver.navigate().back();
				} else {
					System.out.println("Turn on Bluetooth for connectivity pop-up not displayed");
				}
				Thread.sleep(3000);

				break;
			case 4:
				turnOffBT();

				startPairingButton();
				if (isElementDisplayed(alertpopup)) {
					BLEcancelpopup.click();
					Thread.sleep(2000);
					//					driver.navigate().back();
				} else {
					System.out.println("Ble is in ON state");
				}
				Thread.sleep(3000);
				locationPopUpPermission();
				nearByPermission();

				Thread.sleep(1000 * 5 * 1);
				if (isElementDisplayed(alertpopup)) {
					BLEcancelpopup.click();
					Thread.sleep(2000);
					//					driver.navigate().back();
				} else {
					System.out.println("Alert pop-up not displayed");
				}

				Thread.sleep(1000 * 30 * 1);

				enterWiFiPassword("12345678908");
				clickEnterButton();

				Thread.sleep(100000);

				if (isElementDisplayed(devicewifipop_upOK)) {
					clickbyXpath(devicewifipop_upOK, "click on Device wifi OK popup");


					//					Runtime.getRuntime()	.exec("adb shell am start -a android.settings.WIFI_SETTINGS");
					Thread.sleep(5000);
					AndroidElement element = driver.findElement(MobileBy.AndroidUIAutomator(
							"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\""
									+ serialno + "\"))"));
					wait.until(ExpectedConditions.visibilityOf(element));
					wait.until(ExpectedConditions.elementToBeClickable(element));
					element.click();
					if (isElementDisplayed(enterpasswordwifipge)) {
						entervaluebyXpath(enterpasswordwifipge, "wifipage password", "mypassword");
						hidekeyboard();
						clickbyXpath(connectbuttonWifipage, "connect button");
					} else {
						System.out.println("Already password saved ");
					}

					if (driver.queryAppState("com.iinvsys.szephyr") != ApplicationState.RUNNING_IN_FOREGROUND) {
						driver.activateApp("com.iinvsys.szephyr"); // Bring it back
						//						WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
						WebElement blePopupOkButton = wait.until(ExpectedConditions.elementToBeClickable(Blepopup_afterpairing));

						// Now click the OK button once it is visible and clickable

						clickbyXpath(blePopupOkButton, "oK button of Ble alert pop-up");

					}

					//					driver.navigate().back();

				} else {
					System.out.println("unable to connect with device hotspot");
				}
				break;

			case 5:

				turnOffBT();

				startPairingButton();

				if (isElementDisplayed(alertpopup)) {
					clickBleCancelbutton();
					Thread.sleep(2000);
					//					driver.navigate().back();
				} else {
					System.out.println("Ble is in On state");
				}
				Thread.sleep(3000);
				locationPopUpPermission();
				nearByPermission();


				Thread.sleep(1000 * 5 * 1);
				if (isElementDisplayed(alertpopup)) {
					clickBleCancelbutton();
					Thread.sleep(2000);
					//					driver.navigate().back();
				} else {
					System.out.println("Alert pop-up not displayed");
				}

				clickWifiCancelButton();

				//				Thread.sleep(1000 * 30 * 1);

				Thread.sleep(100000);

				if (isElementDisplayed(Retrypagetext)) {

					clickbyXpath(Retrypageretrybutton, "retrypage");

				}else {
					System.out.println("Retry page not displayed proceed to connect with wifi page");
				}


				if (isElementDisplayed(devicewifipop_upOK)) {
					clickbyXpath(devicewifipop_upOK, "click on Device wifi OK popup");

					//					Runtime.getRuntime()
					//							.exec("adb shell am start -n com.android.settings/.Settings\\$WifiSettingsActivity");
					Thread.sleep(5000);
					AndroidElement element = driver.findElement(MobileBy.AndroidUIAutomator(
							"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\""
									+ serialno + "\"))"));
					wait.until(ExpectedConditions.visibilityOf(element));
					wait.until(ExpectedConditions.elementToBeClickable(element));
					element.click();
					if (isElementDisplayed(enterpasswordwifipge)) {
						entervaluebyXpath(enterpasswordwifipge, "wifipage password", "mypassword");


						hidekeyboard();
						clickbyXpath(connectbuttonWifipage, "connect button");
					} else {
						System.out.println("Already password saved ");
					}



					//					driver.navigate().back();
				} else {
					System.out.println("unable to connect with device hotspot");
				}
				if (driver.queryAppState("com.iinvsys.szephyr") != ApplicationState.RUNNING_IN_FOREGROUND) {
					driver.activateApp("com.iinvsys.szephyr"); // Bring it back
					Thread.sleep(5000);
					//					WebDriverWait wait = new WebDriverWait(driver, 10);
					WebElement blePopupOkButton = wait.until(ExpectedConditions.elementToBeClickable(Blepopup_afterpairing));

					// Now click the OK button once it is visible and clickable

					clickbyXpath(blePopupOkButton, "oK button of Ble alert pop-up");
					turnOnBT();

				}else {
					System.out.println("unable to click ok on BLE pop-up");
				}
				break;

			default:
				System.out.println("Pairing not done");
				break;
			}


		} else {
			System.out.println("Device is already in paired state");
		}
	}


	public void hidekeyboard() {
		// Scroll up
		Map<String, Object> params = new HashMap<>();
		params.put("direction", "up");
		driver.executeScript("mobile: hideKeyboard", params);
	}


	


}
