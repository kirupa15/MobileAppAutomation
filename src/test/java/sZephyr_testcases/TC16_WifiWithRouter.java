package sZephyr_testcases;

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
import pages.StoreLogPage;
import pages.Szephyr_info_Page;
import utils.logReadandWrite;
import wrappers.MobileAppWrappers;


public class  TC16_WifiWithRouter extends MobileAppWrappers {

	LandingPage landingpage;
	SignInPage loginpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	DeviceMenuPage devicemenupage;
	Szephyr_info_Page szephyrinfoPage;
	OTA_Status_monitor ota_Status_monitor;
	SignUpPage signpupage;
	StoreLogPage logpage;
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC16_WifiWithRouter_CONNECTIVITY";
		testDescription = "App kill and re-open and check the STA connectivity ";
	}


	@Test(priority = 15,groups = {"skip"})
	public void TC16_WifiWithRouter_CONNECTIVITY() throws Exception {


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


			adddevicepage.pair(4);
			adddevicepage.clickNextButtonsZephyrInfo();
			adddevicepage.clickBleokbutton();
//			adddevicepage.checkdevicedetailstoast();
			adddevicepage.clickSubmitButtonDeviceSetting();
			adddevicepage.checkdevicesettingstoast();
			adddevicepage.staConnectivityCheck();
			homepage.clickONOFFButton();

			//CONNECTIVITY_MOD_3_TC_2///     STA_Kill and Open
			homepage.clickONOFFButton();
			homepage.clickONOFFButton();
			homepage.getCurrentvalue();
			homepage.getVoltvalue();
			homepage.getPowervalue();
			homepage.killandopen();
			Thread.sleep(5000);
			adddevicepage.ClickOkButtonBLEpopUP();
			adddevicepage.staConnectivityCheck();
			homepage.clickONOFFButton();
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
			readwrite.closePort();
			logpage.CollectLogOnFailure(testCaseName,testDescription);
			fail(e);
		}
	}
}