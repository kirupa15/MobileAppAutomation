package testcases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.TimeoutException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddDevicePage;
import pages.DeviceMenuPage;
import pages.HomePage;
import pages.LandingPage;
import pages.SignInPage;
import pages.OtpPage;
import wrappers.MobileAppWrappers;


public class TC01_Pairing_BlewithRouter extends MobileAppWrappers {

	LandingPage landingpage;
	SignInPage loginpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	DeviceMenuPage devicemenupage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC01 - Pairinfg BLE With Router";
		testDescription = "Sign In and Start Pairing BLE with Router mode";
	}
	

	@Test
	public void removerepair() throws FileNotFoundException, IOException, InterruptedException {
		login();
		for(int i=0;i<5;i++) {
		pairBlewithoutRouter();}
	}

	public void login() {
		loginpage = new SignInPage(driver);
		landingpage = new LandingPage(driver);
		otppage = new OtpPage(driver);
		
		landingpage.clickSignInButton();
		loginpage.enterUserName("testuser1237@gmail.com");
		loginpage.clickSignInButton();
		otppage.enterOTPField1("1");
		otppage.enterOTPField2("2");
		otppage.enterOTPField3("3");
		otppage.enterOTPField4("4");
		otppage.submitButton();
		
	}
	
	public void pairBlewithoutRouter() throws FileNotFoundException, IOException, InterruptedException {
		adddevicepage= new AddDevicePage(driver);
		homepage = new HomePage(driver);
		devicemenupage= new DeviceMenuPage(driver);
		
		
		adddevicepage.clickAddDeviceButton();
		adddevicepage.checkBoxPairing();
		adddevicepage.nextButtonPairing();
		adddevicepage.startPairingButton();
		adddevicepage.locationPopUpPermission();
		adddevicepage.nearByPermission();
		
		adddevicepage.ClickCancelButtonBle();
		adddevicepage.enterWiFiPassword("12345678908");
		adddevicepage.clickEnterButton();
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
	}

}
