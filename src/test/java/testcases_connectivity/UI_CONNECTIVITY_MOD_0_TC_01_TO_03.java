package testcases_connectivity;

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
import utils.logReadandWrite;
import wrappers.MobileAppWrappers;


public class  UI_CONNECTIVITY_MOD_0_TC_01_TO_03 extends MobileAppWrappers {

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
		testCaseName = "CONNECTIVITY_MOD_1_TC_00,CONNECTIVITY_MOD_0_TC_02,CONNECTIVITY_MOD_0_TC_03";
		testDescription = "OTA update BLE without Router mode";
	}
	

	@Test
	public void removerepair() throws Exception {
		initAndriodDriver();
		pairBlewithoutRouter();
	}

	
	public void pairBlewithoutRouter() throws Exception {
		adddevicepage= new AddDevicePage(driver);
		homepage = new HomePage(driver);
		devicemenupage= new DeviceMenuPage(driver);
		szephyrinfoPage= new Szephyr_info_Page(driver);
		
		logReadandWrite readwrite=new logReadandWrite("COM4");
		readwrite.openPort();
		readwrite.read();
		Thread.sleep(2000);
		readwrite.write("factory_reset\r");
		
		adddevicepage.pair(1);
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
		devicemenupage.ClickSzephyrInfoButton();
		szephyrinfoPage.brandnametext();
		szephyrinfoPage.Modelnametext();
		szephyrinfoPage.Capacity_field();
		szephyrinfoPage.Roomsize_field();
		Thread.sleep(3000);
		szephyrinfoPage.clickbackButton();
		homepage.clickMenuBarButton();
	    devicemenupage.clickDeviceSettingsButton();
		devicemenupage.clickResetDeviceButton();
		devicemenupage.clickResetConfirmationYesButton();
		
		//CONNECTIVITY_MOD_0_TC_02//
		
		adddevicepage.pair(1);
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
		adddevicepage.verifyAddDevicePage("Adddevice page");
		 readwrite.closePort();
	}
}
		