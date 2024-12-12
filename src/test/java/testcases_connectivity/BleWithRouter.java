
package testcases_connectivity;

import static org.testng.Assert.fail;

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


public class  BleWithRouter extends MobileAppWrappers {

	LandingPage landingpage;
	SignInPage loginpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	DeviceMenuPage devicemenupage;
	Szephyr_info_Page szephyrinfoPage;
	OTA_Status_monitor ota_Status_monitor;
	SignUpPage signUppage;	
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "BlewithRouter";
		testDescription = "CONNECTIVITY_MOD_2_TC_02-BLE connectivity establishment"+"<br>"+"CONNECTIVITY_MOD_2_TC_03-APP kill and re Open"+"<br>"+"CONNECTIVITY_MOD_1_TC_04-5 times App ON/OFF";
	}
	
	
	@Test
	public void removerepair() throws Exception {
		initAndriodDriver();
		pairBlewithRouter();
	}


	
	public void pairBlewithRouter() throws Exception {
		adddevicepage= new AddDevicePage(driver);
		homepage = new HomePage(driver);
		devicemenupage= new DeviceMenuPage(driver);
		szephyrinfoPage= new Szephyr_info_Page(driver);
		
		logReadandWrite readwrite = new logReadandWrite(loadProp("COM"));
		try {
		readwrite.openPort();
		Thread.sleep(3000);
		readwrite.write("reboot\r");
		Thread.sleep(2000);
		readwrite.write("factory_reset\r");
		
		adddevicepage.pair(2);
		adddevicepage.clickNextButtonsZephyrInfo();
		adddevicepage.checkdevicedetailstoast();
		adddevicepage.clickSubmitButtonDeviceSetting();
		adddevicepage.checkdevicesettingstoast();
		adddevicepage.bleConnectivityCheck();
		
		for(int i=0;i<2;i++) {
		homepage.clickONOFFButton();
		Thread.sleep(1000);
		}
		homepage.disableBLE();
		adddevicepage.staConnectivityCheck();
		//homepage.enableBLE();
		for(int i=0;i<5;i++) {
			homepage.clickONOFFButton();
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
		
		
		///CONNECTIVITY_MOD_2_TC_2--Kill and Open///
		
		adddevicepage.pair(2);
		adddevicepage.clickNextButtonsZephyrInfo();
		adddevicepage.checkdevicedetailstoast();
		adddevicepage.clickSubmitButtonDeviceSetting();
		adddevicepage.checkdevicesettingstoast();
		
		adddevicepage.bleConnectivityCheck();
		homepage.clickONOFFButton();
		Thread.sleep(2000);
		homepage.VerifyONdesc();
		
		homepage.clickONOFFButton();
		Thread.sleep(2000);
		homepage.VerifyOFFdesc();
		
		homepage.disableBLE();
		adddevicepage.staConnectivityCheck();
		Thread.sleep(5000);
		homepage.clickONOFFButton();
		Thread.sleep(2000);
		homepage.VerifyONdesc();
		
		homepage.clickONOFFButton();
		Thread.sleep(2000);
		homepage.VerifyOFFdesc();
		
		homepage.killandopen();
		adddevicepage.ClickOkButtonBLEpopUP();
		adddevicepage.staConnectivityCheck();
		homepage.clickONOFFButton();
		Thread.sleep(2000);
		homepage.VerifyONdesc();
		
		homepage.clickONOFFButton();
		Thread.sleep(2000);
		homepage.VerifyOFFdesc();
		
		Thread.sleep(5000);
		///CONNECTIVITY_MOD_2_TC_3--      5 Times ON/OFF ///
		for(int i=0;i<5;i++) {
			homepage.clickONOFFButton();
			Thread.sleep(1000);
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
		
		///CONNECTIVITY_MOD_2_TC_4--   Check BLE Connectivity//
		
		adddevicepage.pair(2);
		adddevicepage.clickNextButtonsZephyrInfo();
		adddevicepage.checkdevicedetailstoast();
		adddevicepage.clickSubmitButtonDeviceSetting();
		adddevicepage.checkdevicesettingstoast();
		
		adddevicepage.bleConnectivityCheck();
		for(int i=0;i<2;i++) {
			homepage.clickONOFFButton();
			Thread.sleep(1000);
			}
	    homepage.disableWIFI();
	    adddevicepage.bleConnectivityCheck();
	    Thread.sleep(2000);
	    for(int i=0;i<2;i++) 
	    {
			homepage.clickONOFFButton();
			Thread.sleep(1000);
			}
	    homepage.getCurrentvalue();
		homepage.getVoltvalue();
		homepage.getPowervalue();
	  ///CONNECTIVITY_MOD_2_TC_5--   Check Kill and Open //
	    
	    Thread.sleep(5000);
		homepage.killandopen();
		adddevicepage.bleConnectivityCheck();
		homepage.clickONOFFButton();
		homepage.clickONOFFButton();
		Thread.sleep(5000);
	 ///CONNECTIVITY_MOD_2_TC_6  ---- 5 Times ON/OFF//	
		 for(int i=0;i<5;i++) 
		    {
				homepage.clickONOFFButton();
				Thread.sleep(1000);
				}
		 homepage.getCurrentvalue();
			homepage.getVoltvalue();
			homepage.getPowervalue();
			
		 homepage.clickMenuBarButton();
			devicemenupage.clickMenuBarRemoveDevice();
			devicemenupage.clickRemoveDevicePopupYesButton();
			adddevicepage.checkdeviceremovedtoast();
			devicemenupage.AddDevicePagedisplayed();
			
		 readwrite.closePort();
		}
		catch (Exception e) {
			e.printStackTrace();
			readwrite.closePort();
			fail("Failed due to this exception", e);
		}
	}
}

