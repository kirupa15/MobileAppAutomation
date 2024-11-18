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
import utils.logReadandWrite;
import wrappers.MobileAppWrappers;


public class TC_03_MultiDevice_Ble_with_router extends MobileAppWrappers {

	LandingPage landingpage;
	SignInPage loginpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	DeviceMenuPage devicemenupage;
	SignUpPage signuppage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC03_MultiDevice Ble With Router";
		testDescription = "Check Pairing with device BLE with Router mode for multi devices";
	}
	

	@Test
	public void removerepair() throws Exception {
		pairBlewithoutRouter();
	}

	public void login() {
		loginpage = new SignInPage(driver);
		landingpage = new LandingPage(driver);
		otppage = new OtpPage(driver);
		signuppage=new SignUpPage(driver);

		
		landingpage.clickSignInButton();
		signuppage.enterEmailId("Nee@gmail.com");
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
		
		logReadandWrite readwrite = logReadandWrite.getInstance("COM4");
		readwrite.openPort();
//		readwrite.read();
		Thread.sleep(2000);
		readwrite.write("factory_reset\r");
		
		adddevicepage.pair(2);
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
		adddevicepage.enterWiFiPassword("12345678908");
		adddevicepage.clickEnterButton();
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
		adddevicepage.enterWiFiPassword("12345678908");
		adddevicepage.clickEnterButton();
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
		readwrite.closePort();
	}
}
		
		
		
		
		
		
