package testcases_Multidevice;

import org.openqa.selenium.TimeoutException;
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


public class TC_05_MultiDevice_BLE_Without_Router extends MobileAppWrappers {

	LandingPage landingpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	DeviceMenuPage devicemenupage;
	SignUpPage signuppage;
	SignInPage loginpage;


	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC01 - Pairinfg BLE With Router";
		testDescription = "Sign In and Start Pairing BLE with Router mode";
	}
	

	@Test
	public void removerepair() throws Exception {
		pairBlewithoutRouter();
	}

	
	public void pairBlewithoutRouter() throws Exception {
		adddevicepage= new AddDevicePage(driver);
		homepage = new HomePage(driver);
		devicemenupage= new DeviceMenuPage(driver);
		
		
			adddevicepage.pair(1);
		adddevicepage.clickNextButtonsZephyrInfo();
		adddevicepage.clickSubmitButtonDeviceSetting();
		
		for(int i=0;i<2;i++) {
		homepage.clickONOFFButton();
		Thread.sleep(1000);
		}
		
		homepage.clickMenuBarButton();
		devicemenupage.clickAddDeviceButton();
		devicemenupage.clickNewDevicePairingButton();
		
		adddevicepage.checkBoxPairing();
		adddevicepage.nextButtonPairing();
		adddevicepage.startPairingButton();
		adddevicepage.locationPopUpPermission();
		adddevicepage.nearByPermission();
		
		//adddevicepage.ClickCancelButtonBle();
		//adddevicepage.enterWiFiPassword("12345678908");
		//adddevicepage.clickEnterButton();
		devicemenupage.ClickCancelWifi();
		adddevicepage.clickNextButtonsZephyrInfo();
		adddevicepage.clickSubmitButtonDeviceSetting();
		for(int i=0;i<2;i++) {
			homepage.clickONOFFButton();
			Thread.sleep(1000);
			}
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
		Thread.sleep(1000);
		devicemenupage.clickSecondDeviceButton();
		
		homepage.clickMenuBarButton();
		devicemenupage.clickAddDeviceButton();
		devicemenupage.clickNewDevicePairingButton();
		adddevicepage.checkBoxPairing();
		adddevicepage.nextButtonPairing();
		adddevicepage.startPairingButton();
		adddevicepage.locationPopUpPermission();
		adddevicepage.nearByPermission();
		
		//adddevicepage.ClickCancelButtonBle();
		//adddevicepage.enterWiFiPassword("12345678908");
		//adddevicepage.clickEnterButton();
		devicemenupage.ClickCancelWifi();
		adddevicepage.clickNextButtonsZephyrInfo();
		adddevicepage.clickSubmitButtonDeviceSetting();
		for(int i=0;i<2;i++) {
			homepage.clickONOFFButton();
			Thread.sleep(1000);
			}
devicemenupage.clickFirstDeviceButton();
		
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
