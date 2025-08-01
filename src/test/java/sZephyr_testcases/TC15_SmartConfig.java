package sZephyr_testcases;

import static org.testng.Assert.fail;

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
import pages.StoreLogPage;
import pages.Szephyr_info_Page;
import utils.logReadandWrite;
import wrappers.MobileAppWrappers;


public class  TC15_SmartConfig extends MobileAppWrappers {

	LandingPage landingpage;
	SignInPage loginpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	DeviceMenuPage devicemenupage;
	Szephyr_info_Page szephyrinfoPage;
	OTA_Status_monitor ota_Status_monitor;
	SignUpPage signinpage;
	StoreLogPage logpage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC15_SmartConfig_CONNECTIVITY";
		testDescription = "STA & Remote Connectivity check "+"<br>"+" Check the STA & Remote connectivity stablity after app kill and re-open "+"<br>"+"continusly 5 time turn the relay via app ON/OFF that time check the Connectivity";
	}
	

	@Test(priority = 14)
	public void TC15_SmartConfig_CONNECTIVITY() throws Exception {
		initAndriodDriver();
		pairBlewithoutRouter();
	}

	public void pairBlewithoutRouter() throws Exception {
		adddevicepage= new AddDevicePage(driver);
		homepage = new HomePage(driver);
		devicemenupage= new DeviceMenuPage(driver);
		szephyrinfoPage= new Szephyr_info_Page(driver);
		logpage= new StoreLogPage(driver);
		
		logReadandWrite readwrite = logReadandWrite.getInstance(loadProp("COM"));
		try {
		readwrite.openPort();
		
		
		///CONNECTIVITY_MOD_3_TC_1///   STA_connectivity establishment
		adddevicepage.pair(3);
		turnOffBT();
		adddevicepage.clickNextButtonsZephyrInfo();
		adddevicepage.clickBleokbutton();
//		adddevicepage.checkdevicedetailstoast();
		adddevicepage.clickSubmitButtonDeviceSetting();
		adddevicepage.checkdevicesettingstoast();
		
		Thread.sleep(10000);
		adddevicepage.staConnectivityCheck();
		Thread.sleep(2000);
		homepage.clickONOFFButton();
			
		//CONNECTIVITY_MOD_3_TC_2///     STA_Kill and Open
		homepage.getCurrentvalue();
		homepage.getVoltvalue();
		homepage.getPowervalue();
		
		homepage.killandopen();
		turnOffBT();
//		adddevicepage.ClickCancelButtonBle();
		adddevicepage.ClickOkButtonBLEpopUP();
		Thread.sleep(10000);
		adddevicepage.staConnectivityCheck();
		Thread.sleep(3000);
		homepage.clickONOFFButton();
		//CONNECTIVITY_MOD_3_TC_3///     STA_Device_ON/OFF
		
		for(int i=1;i<10;i++) {
			homepage.clickONOFFButton();
			Thread.sleep(2000);
			}
		homepage.getCurrentvalue();
		homepage.getVoltvalue();
		homepage.getPowervalue();
		//CONNECTIVITY_MOD_3_TC_4// BLE Connectivity Establishment
		homepage.enableBLE();
		homepage.disableWIFI();
		
		Thread.sleep(10000);
		adddevicepage.bleConnectivityCheck();
		homepage.clickONOFFButton();
		 Thread.sleep(2000);
//	    homepage.VerifyONdesc(); ///Connectivity Confirmation description check//
		///CONNECTIVITY_MOD_3_TC_5//BLE_Kill and Open
	    
	    homepage.getCurrentvalue();
		homepage.getVoltvalue();
		homepage.getPowervalue();
		homepage.killandopen();
		homepage.clickONOFFButton();
		
		//CONNECTIVITY_MOD_3_TC_6//BLE Device ON_OFF 
		
		Thread.sleep(10000);
		for(int i=1;i<10;i++) {
			homepage.clickONOFFButton();
			Thread.sleep(2000);
			}
	
		
		////Remote_Connectivity_Establishment//
		
		homepage.enableWIFI();/// need to connect TP Link//
		homepage.disableBLE();
		checkappinforeground();
	
		//homepage.VerifyONdesc();
		homepage.WifiSwitch(loadProp("REMOTEWIFINAME"),loadProp("REMOTEWIFIPASSWORD"));
//		disableWiFi();
//		adddevicepage.Turnonmobiledata();
		Thread.sleep(10000);
		adddevicepage.remoteConnectivityCheck();
		homepage.clickONOFFButton();
		homepage.getCurrentvalue();
		homepage.getVoltvalue();
		homepage.getPowervalue();
	///CONNECTIVITY_MOD_3_TC_5//remote_Kill and Open
		
		homepage.killandopen();
		Thread.sleep(5000);
		turnOffBT();
		adddevicepage.ClickOkButtonBLEpopUP();
		Thread.sleep(10000);
		adddevicepage.remoteConnectivityCheck();
		homepage.clickONOFFButton();
		//CONNECTIVITY_MOD_3_TC_6//Remote Device ON_OFF 
		
		for(int i=1;i<10;i++) {
			homepage.clickONOFFButton();
			Thread.sleep(2000);
			}
		
		homepage.getCurrentvalue();
		homepage.getVoltvalue();
		homepage.getPowervalue();
		
		homepage.clickMenuBarButton();
		devicemenupage.clickDeviceSettingsButton();
		devicemenupage.clickResetDeviceButton();
		devicemenupage.clickResetConfirmationYesButton();
		adddevicepage.checkdeviceresettoast();
		devicemenupage.AddDevicePagedisplayed();
		 readwrite.closePort();
		}
		catch (Exception e) {
			readwrite.closePort();
			logpage.CollectLogOnFailure(testCaseName,testDescription);
			fail(e);
		}
	}
	 
}
		