package testcases_Multidevice;

import java.io.FileNotFoundException;
import java.io.IOException;

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


public class TC_02_ADD_Router_Module extends MobileAppWrappers {

	LandingPage landingpage;
	SignInPage loginpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	DeviceMenuPage devicemenupage;
	SignUpPage signuppage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC01 - Pairinfg BLE Without Router";
		testDescription = "Sign In and Start Pairing BLE without Router mode";
	}
	

	@Test
	public void removerepair() throws FileNotFoundException, IOException, InterruptedException {
		initAndriodDriver();
		login();
		for(int i=0;i<1;i++) {
		pairBlewithoutRouter();}
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
		
		//adddevicepage.ClickCancelButtonWifi();
		adddevicepage.cancelButton();
		Thread.sleep(1000);
		adddevicepage.clickNextButtonsZephyrInfo();
		adddevicepage.clickSubmitButtonDeviceSetting();
		
		
		
		for(int i=0;i<2;i++) {
		homepage.clickONOFFButton();
		Thread.sleep(1000);
		}
		
		homepage.clickMenuBarButton();
		devicemenupage.clickDeviceSettingsButton();
		devicemenupage.ClickaddrouterButton();
		adddevicepage.enterWiFiPassword("12345678908");
		adddevicepage.clickEnterButton();
		Thread.sleep(2000);
		devicemenupage.ClickDeviceSettingback();
		for(int i=0;i<2;i++) {
			homepage.clickONOFFButton();
			Thread.sleep(1000);
			}
		//devicemenupage.clickResetConfirmationYesButton();
	}

}
