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


public class WIfiWithout_router extends MobileAppWrappers {

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
		testCaseName = "CONNECTIVITY_MOD_4_TC_01,CONNECTIVITY_MOD_4_TC_02,CONNECTIVITY_MOD_4_TC_03";
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
		
		
		adddevicepage.pair(5);
		adddevicepage.clickNextButtonsZephyrInfo();
		adddevicepage.clickSubmitButtonDeviceSetting();
		homepage.clickONOFFButton();
		homepage.VerifyONdesc();
		
		
		//CONNECTIVITY_MOD_3_TC_2///     STA_Kill and Open
		homepage.clickONOFFButton();
		homepage.clickONOFFButton();
		homepage.killandopen();
		adddevicepage.ClickOkButtonBLEpopUP();
		Thread.sleep(3000);
		homepage.clickONOFFButton();
	}
	}