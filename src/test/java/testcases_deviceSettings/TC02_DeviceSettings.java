package testcases_deviceSettings;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddDevicePage;
import pages.DeviceMenuPage;
import pages.HomePage;
import pages.LandingPage;
import pages.SignInPage;
import pages.OtpPage;
import wrappers.MobileAppWrappers;


public class TC02_DeviceSettings extends MobileAppWrappers {

	LandingPage landingpage;
	SignInPage loginpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	DeviceMenuPage devicemenupage;
	
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC02 - DeviceSettings";
		testDescription = "Remove the Added Router Details Test Case";
	}
	

	@Test
	public void removerepair() throws Exception {
		loginpage = new SignInPage(driver);
		landingpage = new LandingPage(driver);
		otppage = new OtpPage(driver);
		adddevicepage = new AddDevicePage(driver);

		
		login();
		pairBlewithoutRouter();
	}

	public void login() {
		loginpage = new SignInPage(driver);
		landingpage = new LandingPage(driver);
		otppage = new OtpPage(driver);
		
		
		landingpage.clickSignInButton();
		loginpage.enterUserName("Murugan");
		loginpage.clickSignInButton();
		otppage.enterOTPField1("1");
		otppage.enterOTPField2("2");
		otppage.enterOTPField3("3");
		otppage.enterOTPField4("4");
		otppage.submitButton();
		
	}
	
	public void pairBlewithoutRouter() throws Exception {
		adddevicepage= new AddDevicePage(driver);
		homepage = new HomePage(driver);
		devicemenupage= new DeviceMenuPage(driver);
		
		
		adddevicepage.clickAddDeviceButton();
		adddevicepage.checkBoxPairing();
		adddevicepage.nextButtonPairing();
		adddevicepage.startPairingButton();
		adddevicepage.locationPopUpPermission();
		adddevicepage.nearByPermission();
		
		devicemenupage.clickRouterPopCancelButton();
		adddevicepage.enterWiFiPassword("12345678908");
		adddevicepage.clickEnterButton();
		
		adddevicepage.clickNextButtonsZephyrInfo();
		adddevicepage.clickSubmitButtonDeviceSetting();
		
		
		//for(int i=0;i<2;i++) {
		//homepage.clickONOFFButton();
		//Thread.sleep(1000);
		//}
		Thread.sleep(2000);
			homepage.clickMenuBarButton();
			Thread.sleep(1000);
			devicemenupage.clickDeviceSettingsButton();
			Thread.sleep(1000);
	//Add Router Test Case		
			devicemenupage.ClickaddrouterButton();
			Thread.sleep(1000);
			adddevicepage.enterWiFiPassword("12345678908");
			devicemenupage.clickAddRouterCheckBox();
			adddevicepage.clickEnterButton();
			Thread.sleep(5000);
		
	//Remove Router Test Case		
			devicemenupage.clickRemoveRouterButton();
			devicemenupage.clickRemoveRouterCancelButton();
			Thread.sleep(1000);
			devicemenupage.clickRemoveRouterButton();
			devicemenupage.clickRemoveRouterRemoveButton();
			Thread.sleep(5000);
			devicemenupage.clickDeviceSettingsBackButton();
			Thread.sleep(1000);
			turnOffBT();
			Thread.sleep(1000);
			devicemenupage.shellAllowpopup();
			Thread.sleep(20000);
			turnOnBT();
			devicemenupage.shellAllowpopup();
		    Thread.sleep(10000);
			
			for(int i=0;i<2;i++) {
				homepage.clickONOFFButton();
				Thread.sleep(1000);
				}
			
			homepage.clickMenuBarButton();
			devicemenupage.clickMenuBarRemoveDevice();
			devicemenupage.clickRemoveDevicePopupNoButton();
			Thread.sleep(1000);
			homepage.clickMenuBarButton();
			devicemenupage.clickMenuBarRemoveDevice();
			devicemenupage.clickRemoveDevicePopupYesButton();
			Thread.sleep(1000);
	}

}


