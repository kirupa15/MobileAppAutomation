package testcases_pairing;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AddDevicePage;
import pages.DeviceMenuPage;
import pages.HomePage;
import pages.LandingPage;
import pages.OtpPage;
import pages.SignInPage;
import utils.logReadandWrite;
import wrappers.MobileAppWrappers;

public class TC04_Pairing_WifiwithRouter extends MobileAppWrappers {

	LandingPage landingpage;
	SignInPage loginpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	DeviceMenuPage devicemenupage;

	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC04 - Pairing in Wifi with router mode";
		testDescription = "If already Signin skip signin and  Start Pairing Wifi with router mode else Signin and pair Wifi with router mode";
	}


	@Test
	public void removerepair() throws Exception {
		initAndriodDriver();
		loginpage = new SignInPage(driver);
		landingpage = new LandingPage(driver);
		otppage = new OtpPage(driver);
		adddevicepage= new AddDevicePage(driver);
		homepage = new HomePage(driver);
		devicemenupage= new DeviceMenuPage(driver);

	 
		logReadandWrite readwrite=new logReadandWrite("COM4");
		try {
		readwrite.openPort();
		readwrite.read();
		Thread.sleep(2000);
		readwrite.write("factory_reset\r");
		
		adddevicepage.pair(4);
		adddevicepage.clickNextButtonsZephyrInfo();
		adddevicepage.clickSubmitButtonDeviceSetting();
		for(int i=0;i<2;i++) {
			homepage.clickONOFFButton();
			Thread.sleep(3000);
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
