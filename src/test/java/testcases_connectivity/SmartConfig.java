package testcases_connectivity;

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
import utils.logReadandWrite;
import wrappers.MobileAppWrappers;


public class  SmartConfig extends MobileAppWrappers {

	LandingPage landingpage;
	SignInPage loginpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	DeviceMenuPage devicemenupage;
	Szephyr_info_Page szephyrinfoPage;
	OTA_Status_monitor ota_Status_monitor;
	SignUpPage signinpage;
		
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "CONNECTIVITY_MOD_3_TC_01,CONNECTIVITY_MOD_3_TC_02,CONNECTIVITY_MOD_3_TC_03 to CONNECTIVITY_MOD_3_TC_09 ";
		testDescription = "Smartconfig pairing";
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
		
		
		///CONNECTIVITY_MOD_3_TC_1///   STA_connectivity establishment
		adddevicepage.pair(3);
		turnOffBT();
		
		adddevicepage.clickNextButtonsZephyrInfo();
		adddevicepage.clickSubmitButtonDeviceSetting();
		Thread.sleep(10000);
		homepage.clickONOFFButton();
		Thread.sleep(5000);
		homepage.VerifyONdesc();
		Thread.sleep(5000);
		/*for(int i=0;i<2;i++) {
			Thread.sleep(1000);
			}*/
		
		//CONNECTIVITY_MOD_3_TC_2///     STA_Kill and Open
		
		homepage.killandopen();
		adddevicepage.ClickCancelButtonBle();
		Thread.sleep(10000);
		homepage.clickONOFFButton();
		//CONNECTIVITY_MOD_3_TC_3///     STA_Device_ON/OFF
		
		for(int i=0;i<11;i++) {
			homepage.clickONOFFButton();
			Thread.sleep(3000);
			}
		
		//CONNECTIVITY_MOD_3_TC_4// BLE Connectivity Establishment
		homepage.enableBLE();
		homepage.disableWIFI();
		Thread.sleep(10000);
		homepage.clickONOFFButton();
		 Thread.sleep(5000);
	    homepage.VerifyONdesc(); ///Connectivity Confirmation description check//
	    Thread.sleep(5000);
		///CONNECTIVITY_MOD_3_TC_5//BLE_Kill and Open
	   
		homepage.killandopen();
		
		//CONNECTIVITY_MOD_3_TC_6//BLE Device ON_OFF 
		
		Thread.sleep(10000);
		for(int i=0;i<11;i++) {
			homepage.clickONOFFButton();
			Thread.sleep(3000);
			}
	
		
		////Remote_Connectivity_Establishment//
		
		homepage.enableWIFI();/// need to connect TP Link//
		homepage.disableBLE();
		checkappinforeground();
	
		//homepage.VerifyONdesc();
		homepage.WifiSwitch(loadProp().getProperty("REMOTEWIFINAME"),loadProp().getProperty("REMOTEWIFIPASSWORD"));
		Thread.sleep(8000);
		homepage.clickONOFFButton();
		Thread.sleep(5000);
	///CONNECTIVITY_MOD_3_TC_5//remote_Kill and Open
		
		homepage.killandopen();
		Thread.sleep(10000);
		adddevicepage.ClickOkButtonBLEpopUP();
		Thread.sleep(3000);
		homepage.clickONOFFButton();
		homepage.VerifyONdesc();
		Thread.sleep(5000);
		//CONNECTIVITY_MOD_3_TC_6//Remote Device ON_OFF 
		
		for(int i=0;i<11;i++) {
			homepage.clickONOFFButton();
			Thread.sleep(3000);
			}
		homepage.clickMenuBarButton();
		devicemenupage.clickDeviceSettingsButton();
		devicemenupage.clickResetDeviceButton();
		devicemenupage.clickResetConfirmationYesButton();
		devicemenupage.AddDevicePagedisplayed();

		
	}
	 
}
		