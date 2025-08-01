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

public class TC05_SignIn_Valid_User extends MobileAppWrappers {

	LandingPage landingpage;
	SignInPage loginpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	DeviceMenuPage devicemenupage;
	SignUpPage signuppage;
	StoreLogPage logpage;

	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC05 - Try to Sign In into app with Valid user details but invalid OTP ";
		testDescription = "Try to Sign In into app with Valid user details but invalid OTP ";
	}
	

	@Test(priority = 4)
	public void TC05_Try_to_SignIn_into_app_with_Validuserdetails_but_invalidOTP() throws Exception {
		initAndriodDriver();
		loginpage = new SignInPage(driver);
		landingpage = new LandingPage(driver);
		otppage = new OtpPage(driver);
		signuppage =new SignUpPage(driver);
		logpage= new StoreLogPage(driver);
		
		logReadandWrite readwrite = logReadandWrite.getInstance(loadProp("COM"));		
		try {
		readwrite.openPort();
		
		signuppage.uninstall_reinstall();
		landingpage.clickSignInButton();
		loginpage.enterUserName( loadProp("USERNAME"));
		loginpage.clickSignInButton();
		Thread.sleep(3000);
		otppage.verifyOTPVerificationTitle("OTP Verification");
		otppage.enterOTPField1("5");
		otppage.enterOTPField2("2");
		otppage.enterOTPField3("3");
		otppage.enterOTPField4("4");
		otppage.submitButton();
		otppage.checkIncorrectOTPToast("Incorrect OTP, You have 5 more attempt");
		
		readwrite.closePort();
		}
		catch (Exception e) {
			readwrite.closePort();
			logpage.CollectLogOnFailure(testCaseName,testDescription);
			fail(e);
		}
	}
	
}