package testcases_Factoryreset_sZephyrinfo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AddDevicePage;
import pages.DeviceMenuPage;
import pages.HomePage;
import pages.LandingPage;
import pages.OtpPage;
import pages.SignInPage;
import pages.SignUpPage;
import utils.logReadandWrite;
import wrappers.MobileAppWrappers;

public class TC_05_Ble_Factory_Reset extends MobileAppWrappers {

	LandingPage landingpage;
	SignInPage loginpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	DeviceMenuPage devicemenupage;
	SignUpPage signuppage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC01 - SignUp with already existing username";
		testDescription = "Try to Sign Up with already registered username";
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
	readwrite.openPort();
	readwrite.read();
	Thread.sleep(2000);
	readwrite.write("factory_reset\r");
	
	adddevicepage.pair(1);
	adddevicepage.clickNextButtonsZephyrInfo();
	adddevicepage.clickSubmitButtonDeviceSetting();
	
	for(int i=0;i<2;i++) {
	homepage.clickONOFFButton();
	Thread.sleep(1000);
	}
	Thread.sleep(1000);
	homepage.killandopen();
	Thread.sleep(1000);
	homepage.clickMenuBarButton();
	devicemenupage.clickDeviceSettingsButton();
	devicemenupage.clickResetDeviceButton();
	devicemenupage.clickResetConfirmationYesButton();
	devicemenupage.AddDevicePagedisplayed();

}

}
