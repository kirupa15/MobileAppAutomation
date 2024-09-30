
package testcases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.TimeoutException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddDevicePage;
import pages.DeviceMenuPage;
import pages.HomePage;
import pages.LandingPage;
import pages.OTA_Status_monitor;
import pages.OtpPage;
import pages.SignInPage;
import pages.SignUpPage;
import pages.Szephyr_info_Page;
import wrappers.MobileAppWrappers;


public class  OTA_TC_01_BLE extends MobileAppWrappers {

	LandingPage landingpage;
	SignInPage loginpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	DeviceMenuPage devicemenupage;
	Szephyr_info_Page szephyrinfoPage;
	OTA_Status_monitor ota_Status_monitor;
	SignUpPage signuppage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC01 -OTA Pairinfg BLE With Router";
		testDescription = "OTA update BLE without Router mode";
	}
	

	@Test
	public void removerepair() throws FileNotFoundException, IOException, InterruptedException {
		login();
		for(int i=0;i<1;i++) {
		pairBlewithoutRouter();}
	}

	public void login() {
		loginpage = new SignInPage(driver);
		landingpage = new LandingPage(driver);
		otppage = new OtpPage(driver);
		ota_Status_monitor=new OTA_Status_monitor(driver);
		signuppage = new SignUpPage(driver);
		
		landingpage.clickSignInButton();
		signuppage.enterEmailId("varadharajanram95@gmail.com");
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
		
		
		adddevicepage.clickAddDeviceButton();
		adddevicepage.checkBoxPairing();
		adddevicepage.nextButtonPairing();
		adddevicepage.startPairingButton();
		adddevicepage.locationPopUpPermission();
		adddevicepage.nearByPermission();
		adddevicepage.clickWifiCancelButton();
		//adddevicepage.enterWiFiPassword("12345678908");
		//adddevicepage.clickEnterButton();
		adddevicepage.clickNextButtonsZephyrInfo();
		adddevicepage.clickSubmitButtonDeviceSetting();
		
		//for(int i=0;i<2;i++) {
		//homepage.clickONOFFButton();
		//Thread.sleep(1000);
		//}
		
		homepage.clickMenuBarButton();
		devicemenupage.clickszephyr_info_button();
		szephyrinfoPage.clickdownload_firmwareButton();
		szephyrinfoPage.clickfirmware_update();
		szephyrinfoPage.clickfirmware_update_popup_button();
		szephyrinfoPage.clickOTA_OK_Button();
		ota_Status_monitor.waitforstatusbar();
		szephyrinfoPage.clickbackButton();
	    homepage.clickMenuBarButton();
		devicemenupage.clickDeviceSettingsButton();
		devicemenupage.clickResetDeviceButton();
		devicemenupage.clickResetConfirmationYesButton();
		
	    
	

}}
