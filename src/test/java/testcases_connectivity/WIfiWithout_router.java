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
		testCaseName = "WifiWithoutRouter";
		testDescription = "App kill and re-open and check the connectivity";
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

		logReadandWrite readwrite = logReadandWrite.getInstance("COM4");
		try {
			readwrite.openPort();
			//		readwrite.read();
			Thread.sleep(2000);
			readwrite.write("factory_reset\r");


			adddevicepage.pair(5);
			adddevicepage.clickNextButtonsZephyrInfo();
			adddevicepage.checkdevicedetailstoast();
			adddevicepage.clickSubmitButtonDeviceSetting();
			adddevicepage.checkdevicesettingstoast();
			
			homepage.clickONOFFButton();
			homepage.VerifyONdesc();


			//CONNECTIVITY_MOD_3_TC_2///     STA_Kill and Open
			homepage.clickONOFFButton();
			homepage.clickONOFFButton();
			homepage.killandopen();
			adddevicepage.ClickOkButtonBLEpopUP();
			Thread.sleep(3000);
			homepage.clickONOFFButton();
			
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