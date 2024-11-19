package testcases_signIn_up_accountsinfo_module;

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
import utils.logReadandWrite;
import wrappers.MobileAppWrappers;

public class TC04_SignIn_Valid_User extends MobileAppWrappers {

	LandingPage landingpage;
	SignInPage loginpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	DeviceMenuPage devicemenupage;
	SignUpPage signuppage;

	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC04 - SignIn_Valid_User";
		testDescription = "Try to Sign In into app with Valid user details but invalid OTP ";
	}
	

	@Test
	public void login() throws Exception {
		initAndriodDriver();
		loginpage = new SignInPage(driver);
		landingpage = new LandingPage(driver);
		otppage = new OtpPage(driver);
		signuppage =new SignUpPage(driver);

		logReadandWrite readwrite = logReadandWrite.getInstance(loadProp("COM"));
		System.out.println(" COM Availble :: " +loadProp("COM"));
		
		try {
		readwrite.openPort();
//		readwrite.read();
		Thread.sleep(2000);
		readwrite.write("factory_reset\r");
		
		signuppage.uninstall_reinstall();
		landingpage.clickSignInButton();
		loginpage.enterUserName("testuser@gmail.com");
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
			e.printStackTrace();
			readwrite.closePort();
			fail("Failed due to this exception", e);
		}
	}
	
}