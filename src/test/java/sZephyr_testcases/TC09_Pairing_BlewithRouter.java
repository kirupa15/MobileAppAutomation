package sZephyr_testcases;

import static org.testng.Assert.fail;

import org.openqa.selenium.TimeoutException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddDevicePage;
import pages.DeviceMenuPage;
import pages.HomePage;
import pages.LandingPage;
import pages.SignInPage;
import pages.StoreLogPage;
import utils.logReadandWrite;
import pages.OtpPage;
import wrappers.MobileAppWrappers;


public class TC09_Pairing_BlewithRouter extends MobileAppWrappers {

	LandingPage landingpage;
	SignInPage loginpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	DeviceMenuPage devicemenupage;
	StoreLogPage logpage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC09 - Pairing BLE With Router";
		testDescription = "If already Signin skip signin and  check Ble with router pairing else Signin and check pairing ";
	}
	

	@Test(priority = 8)
	public void TC09_Pairing_BLE_With_Router() throws Exception {
		initAndriodDriver();


		pairBlewithoutRouter();
		}


	
	public void pairBlewithoutRouter() throws Exception {
		adddevicepage= new AddDevicePage(driver);
		homepage = new HomePage(driver);
		devicemenupage= new DeviceMenuPage(driver);
		logpage= new StoreLogPage(driver);
		
		logReadandWrite readwrite = logReadandWrite.getInstance(loadProp("COM"));
		try {
		readwrite.openPort();
		
		adddevicepage.pair(2);
		adddevicepage.clickNextButtonsZephyrInfo();
		adddevicepage.clickBleokbutton();
//		adddevicepage.checkdevicedetailstoast();
		adddevicepage.clickSubmitButtonDeviceSetting();
		adddevicepage.checkdevicesettingstoast();
		Thread.sleep(5000);
		homepage.clickONOFFButton();
		Thread.sleep(2000);
//		homepage.VerifyONdesc();
		homepage.clickONOFFButton();
//		homepage.VerifyOFFdesc();
		
		
		homepage.clickMenuBarButton();
		devicemenupage.clickMenuBarRemoveDevice();
		devicemenupage.clickRemoveDevicePopupYesButton();
		adddevicepage.checkdeviceremovedtoast();
		devicemenupage.AddDevicePagedisplayed();
		
		adddevicepage.pair(2);
		adddevicepage.clickNextButtonsZephyrInfo();
		adddevicepage.clickBleokbutton();
//		adddevicepage.checkdevicedetailstoast();
		adddevicepage.clickSubmitButtonDeviceSetting();
		adddevicepage.checkdevicesettingstoast();
		Thread.sleep(5000);
		homepage.clickONOFFButton();
		Thread.sleep(2000);
//		homepage.VerifyONdesc();
		homepage.clickONOFFButton();
//		homepage.VerifyOFFdesc();
		
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
