package testcases_pairing;

import org.openqa.selenium.TimeoutException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddDevicePage;
import pages.DeviceMenuPage;
import pages.HomePage;
import pages.LandingPage;
import pages.SignInPage;
import utils.logReadandWrite;
import pages.OtpPage;
import wrappers.MobileAppWrappers;


public class TC02_Pairing_BlewithRouter extends MobileAppWrappers {

	LandingPage landingpage;
	SignInPage loginpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	DeviceMenuPage devicemenupage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC02 - Pairing BLE With Router";
		testDescription = "If already Signin skip signin and  Start Pairing BLE with Router mode else Signin and pair Ble with router";
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
		
		logReadandWrite readwrite=new logReadandWrite("COM4");
		try {
		readwrite.openPort();
		readwrite.read();
		readwrite.write("factory_reset\r");
		
		adddevicepage.pair(2);
		adddevicepage.clickNextButtonsZephyrInfo();
		adddevicepage.clickSubmitButtonDeviceSetting();
		
		for(int i=0;i<2;i++) {
		homepage.clickONOFFButton();
		Thread.sleep(1000);
		}
		
		homepage.clickMenuBarButton();
		devicemenupage.clickDeviceSettingsButton();
		devicemenupage.clickResetDeviceButton();
		devicemenupage.clickResetConfirmationYesButton();
		devicemenupage.AddDevicePagedisplayed();
		readwrite.closePort();
		}
		catch (Exception e) {
			e.printStackTrace();
			readwrite.closePort();
		}
	}

}
