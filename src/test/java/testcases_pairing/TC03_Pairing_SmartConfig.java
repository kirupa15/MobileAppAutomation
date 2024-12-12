package testcases_pairing;

import static org.testng.Assert.fail;

import java.util.Properties;

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

public class TC03_Pairing_SmartConfig extends MobileAppWrappers {

	LandingPage landingpage;
	SignInPage loginpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	DeviceMenuPage devicemenupage;

	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC03 - Pairing in Smart Config Mode";
		testDescription = "If already Signin skip signin and  Start Pairing Smartconfig mode, else Signin and pair Smartconfig mode";
	}

	Properties prop= new Properties();
	@Test
	public void removerepair() throws Exception {
		initAndriodDriver();
		loginpage = new SignInPage(driver);
		landingpage = new LandingPage(driver);
		otppage = new OtpPage(driver);
		adddevicepage= new AddDevicePage(driver);
		homepage = new HomePage(driver);
		devicemenupage= new DeviceMenuPage(driver);

	 
		logReadandWrite readwrite = new logReadandWrite(loadProp("COM"));
		try {
		readwrite.openPort();
		Thread.sleep(2000);
		readwrite.write("reboot\r");
		Thread.sleep(3000);
		readwrite.write("factory_reset\r");
		
		adddevicepage.pair(3);
		adddevicepage.clickNextButtonsZephyrInfo();
		adddevicepage.checkdevicedetailstoast();
		adddevicepage.clickSubmitButtonDeviceSetting();
		adddevicepage.checkdevicesettingstoast();


		homepage.clickONOFFButton();
		Thread.sleep(2000);
		homepage.VerifyONdesc();
		
		homepage.clickONOFFButton();
		Thread.sleep(2000);
		homepage.VerifyOFFdesc();
		
		homepage.clickMenuBarButton();
		devicemenupage.clickMenuBarRemoveDevice();
		devicemenupage.clickRemoveDevicePopupYesButton();
		adddevicepage.checkdeviceremovedtoast();
		devicemenupage.AddDevicePagedisplayed();
		
		adddevicepage.pair(3);
		adddevicepage.clickNextButtonsZephyrInfo();
		adddevicepage.checkdevicedetailstoast();
		adddevicepage.clickSubmitButtonDeviceSetting();
		adddevicepage.checkdevicesettingstoast();
		
		homepage.clickONOFFButton();
		Thread.sleep(2000);
		homepage.VerifyONdesc();
		
		homepage.clickONOFFButton();
		Thread.sleep(2000);
		homepage.VerifyOFFdesc();
		
		homepage.clickMenuBarButton();
		devicemenupage.clickLogoutButton();
		devicemenupage.clickLogoutConfirmationButton();
		landingpage.clickSignInButton();
		loginpage.enterUserName(prop.getProperty("EMAILID"));
		loginpage.clickSignInButton();
		otppage.verifyOTPVerificationTitle("OTP Verification");
		otppage.enterOTPField1("1");
		otppage.enterOTPField2("2");
		otppage.enterOTPField3("3");
		otppage.enterOTPField4("4");
		otppage.submitButton();
		homepage.VerifyOFFdesc();

		homepage.clickMenuBarButton();
		devicemenupage.clickMenuBarRemoveDevice();
		devicemenupage.clickRemoveDevicePopupYesButton();
		adddevicepage.checkdeviceremovedtoast();
		devicemenupage.AddDevicePagedisplayed();
		readwrite.closePort();
		}
		catch (Exception e) {
			readwrite.closePort();
//			e.printStackTrace();
			fail("Failed due to this exception", e);
		}
	}

}
