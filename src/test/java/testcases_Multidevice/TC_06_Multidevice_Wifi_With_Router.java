package testcases_Multidevice;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AddDevicePage;
import pages.DeviceMenuPage;
import pages.HomePage;
import pages.LandingPage;
import pages.OtpPage;
import pages.SignInPage;
import pages.SignUpPage;
import wrappers.MobileAppWrappers;

public class TC_06_Multidevice_Wifi_With_Router extends MobileAppWrappers {

	LandingPage landingpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	DeviceMenuPage devicemenupage;
	SignInPage loginpage;
	SignUpPage signuppage;

	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC01 - Pairinfg BLE Without Router";
		testDescription = "Sign In and Start Pairing BLE without Router mode";
	}
	
	@Test
	public void pairingg() throws Exception {
		adddevicepage= new AddDevicePage(driver);
		homepage = new HomePage(driver);
		devicemenupage= new DeviceMenuPage(driver);
		adddevicepage= new AddDevicePage(driver);
		signuppage=new SignUpPage(driver);

		
		adddevicepage.pair(4);
		adddevicepage.clickNextButtonsZephyrInfo();
		adddevicepage.clickSubmitButtonDeviceSetting();
		for(int i=0;i<2;i++) {
			homepage.clickONOFFButton();
			Thread.sleep(8000);
			}
			
			homepage.clickMenuBarButton();
			devicemenupage.clickAddDeviceButton();
			devicemenupage.clickNewDevicePairingButton();
			adddevicepage.pair(4);
			
			Thread.sleep(1000);
			devicemenupage.clickSecondDeviceButton();
			
			for(int i=0;i<2;i++) {
			homepage.clickONOFFButton();
			Thread.sleep(1000);
			}
			
			devicemenupage.clickFirstDeviceButton();
			
			for(int i=0;i<2;i++) {
				homepage.clickONOFFButton();
				Thread.sleep(1000);
				}
			adddevicepage.pair(4);

			for(int i=0;i<2;i++) {
				homepage.clickONOFFButton();
				Thread.sleep(1000);
				}
	devicemenupage.clickThirdDeviceButton();
			
			for(int i=0;i<2;i++) {
				homepage.clickONOFFButton();
				Thread.sleep(1000);
	}
	}
	
}
