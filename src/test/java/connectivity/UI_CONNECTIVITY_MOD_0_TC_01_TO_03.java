package connectivity;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddDevicePage;
import pages.DeviceMenuPage;
import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;
import pages.OTA_Status_monitor;
import pages.OtpPage;
import pages.Szephyr_info_Page;
import wrappers.MobileAppWrappers;


public class  UI_CONNECTIVITY_MOD_0_TC_01_TO_03 extends MobileAppWrappers {

	LandingPage landingpage;
	LoginPage loginpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	DeviceMenuPage devicemenupage;
	Szephyr_info_Page szephyrinfoPage;
	OTA_Status_monitor ota_Status_monitor;
		
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "CONNECTIVITY_MOD_1_TC_00,CONNECTIVITY_MOD_0_TC_02,CONNECTIVITY_MOD_0_TC_03";
		testDescription = "OTA update BLE without Router mode";
	}
	

	@Test
	public void removerepair() throws FileNotFoundException, IOException, InterruptedException {
		login();
		for(int i=0;i<1;i++) {
		pairBlewithoutRouter();}
	}

	public void login() {
		loginpage = new LoginPage(driver);
		landingpage = new LandingPage(driver);
		otppage = new OtpPage(driver);
		ota_Status_monitor=new OTA_Status_monitor(driver);
		
		
		landingpage.clickSignInButton();
		loginpage.enterEmailId("varadharajanram95@gmail.com");
		loginpage.clickSignInButton();
		otppage.enterOTPField1("1");
		otppage.enterOTPField2("2");
		otppage.enterOTPField3("3");
		otppage.enterOTPField4("4");
		otppage.submitButton();
		
	}
	
	public void pairBlewithoutRouter() throws FileNotFoundException, IOException, InterruptedException {
		adddevicepage= new AddDevicePage(driver);
		homepage = new HomePage(driver);
		devicemenupage= new DeviceMenuPage(driver);
		szephyrinfoPage= new Szephyr_info_Page(driver);
		
		//CONNECTIVITY_MOD_0_TC_01////////////////////////////////////////////////
		/*adddevicepage.clickAddDeviceButton();
		adddevicepage.checkBoxPairing();
		adddevicepage.nextButtonPairing();
		adddevicepage.startPairingButton();
		adddevicepage.locationPopUpPermission();
		adddevicepage.nearByPermission();
		adddevicepage.ClickCancelButtonWifi();
		Thread.sleep(3000);
		adddevicepage.aCBrandNameClick();
		adddevicepage.aCBrandNameCarrierclick();
		adddevicepage.enterAcModelName("V20");
		adddevicepage.enterCapacity("2");
		adddevicepage.roomSizeselect();
		adddevicepage.roomSizesmall();
		adddevicepage.clickNextButtonsZephyrInfo();
		adddevicepage.clickSubmitButtonDeviceSetting();
		
		for(int i=0;i<2;i++) {
		homepage.clickONOFFButton();
		
		Thread.sleep(1000);
		}
		homepage.clickMenuBarButton();
		devicemenupage.clickszephyr_info_button();
		szephyrinfoPage.brandnametext();
		szephyrinfoPage.Modelnametext();
		szephyrinfoPage.Capacity_field();
		szephyrinfoPage.Roomsize_field();
		Thread.sleep(3000);
		szephyrinfoPage.clickbackButton();
		homepage.clickMenuBarButton();
	    devicemenupage.clickDeviceSettingsButton();
		devicemenupage.clickResetDeviceButton();
		devicemenupage.clickResetConfirmationYesButton();*/
		
		//CONNECTIVITY_MOD_0_TC_02//
		
		adddevicepage.clickAddDeviceButton();
		adddevicepage.checkBoxPairing();
		adddevicepage.nextButtonPairing();
		adddevicepage.startPairingButton();
		adddevicepage.locationPopUpPermission();
		adddevicepage.nearByPermission();
		adddevicepage.ClickCancelButtonWifi();
		adddevicepage.clickNextButtonsZephyrInfo();
		adddevicepage.LEDquietmode();
		adddevicepage.Infinitepoweron();
		Thread.sleep(3000);
		adddevicepage.Minutesminusbutton();
		adddevicepage.clickSubmitButtonDeviceSetting();
		homepage.clickMenuBarButton();
	    devicemenupage.clickDeviceSettingsButton();
	    adddevicepage.DurationforON();
	    Thread.sleep(3000);
	    adddevicepage.Hourstextbox();
	    adddevicepage.Minutestextbox();
	    adddevicepage.ClickokdurationON();
	    Thread.sleep(5000);
	    devicemenupage.clickResetDeviceButton();
		devicemenupage.clickResetConfirmationYesButton();
		
		
	}
}
		