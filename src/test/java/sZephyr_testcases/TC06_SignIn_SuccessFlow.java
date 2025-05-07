package sZephyr_testcases;

import static org.testng.Assert.fail;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AddDevicePage;
import pages.DeviceMenuPage;
import pages.HomePage;
import pages.LandingPage;
import pages.OtpPage;
import pages.SignInPage;
import pages.SignUpPage;
import pages.StoreLogPage;
import utils.logReadandWrite;
import wrappers.MobileAppWrappers;

public class TC06_SignIn_SuccessFlow extends MobileAppWrappers {

	LandingPage landingpage;
	SignInPage loginpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	SignUpPage signuppage;
	StoreLogPage logpage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC06 - During Sign Up or Sign In, enter valid OTP";
		testDescription = "During Sign Up or Sign In, enter valid OTP";
	}
	

	@Test(priority = 5)
	public void login() throws Exception {
		initAndriodDriver();
		loginpage = new SignInPage(driver);
		landingpage = new LandingPage(driver);
		otppage = new OtpPage(driver);
		adddevicepage= new AddDevicePage(driver);
		signuppage =new SignUpPage(driver);
		logpage= new StoreLogPage(driver);
		
		logReadandWrite readwrite = logReadandWrite.getInstance(loadProp("COM"));
		
		try {
		readwrite.openPort();
		
		signuppage.uninstall_reinstall();
		landingpage.clickSignInButton();
		loginpage.enterUserName( loadProp("USERNAME"));
		loginpage.clickSignInButton();
		otppage.verifyOTPVerificationTitle("OTP Verification");
		otppage.enterOTPField1("1");
		otppage.enterOTPField2("2");
		otppage.enterOTPField3("3");
		otppage.enterOTPField4("4");
		otppage.submitButton();
		adddevicepage.verifyAddDevicePage("Add Device");
		readwrite.closePort();
		}
		catch (Exception e) {
			readwrite.closePort();
			logpage.CollectLogOnFailure(testCaseName,testDescription);
			fail(e);
		}
	}
	
}