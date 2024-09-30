package testcases_signup_module;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AddDevicePage;
import pages.DeviceMenuPage;
import pages.HomePage;
import pages.LandingPage;
import pages.OtpPage;
import pages.SignInPage;
import wrappers.MobileAppWrappers;

public class TC04_SignIn_Valid_User extends MobileAppWrappers {

	LandingPage landingpage;
	SignInPage loginpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	DeviceMenuPage devicemenupage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC04 - Sign In with Valid User";
		testDescription = "Sign In into app with Valid user details";
	}
	

	@Test
	public void login() throws InterruptedException, FileNotFoundException, IOException {
		initAndriodDriver();
		loginpage = new SignInPage(driver);
		landingpage = new LandingPage(driver);
		otppage = new OtpPage(driver);
		
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
	}
	
}