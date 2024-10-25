package testcases_signIn_up_accountsinfo_module;

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

public class TC05_SignIn_SuccessFlow extends MobileAppWrappers {

	LandingPage landingpage;
	SignInPage loginpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	SignUpPage signuppage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC05 - Sign Up or Sign In, enter valid OTP";
		testDescription = "During Sign Up or Sign In, enter valid OTP";
	}
	

	@Test
	public void login() throws Exception {
		initAndriodDriver();
		loginpage = new SignInPage(driver);
		landingpage = new LandingPage(driver);
		otppage = new OtpPage(driver);
		adddevicepage= new AddDevicePage(driver);
		signuppage =new SignUpPage(driver);
		
		signuppage.uninstall_reinstall();
		landingpage.clickSignInButton();
		loginpage.enterUserName("testuser@gmail.com");
		loginpage.clickSignInButton();
		otppage.verifyOTPVerificationTitle("OTP Verification");
		otppage.enterOTPField1("1");
		otppage.enterOTPField2("2");
		otppage.enterOTPField3("3");
		otppage.enterOTPField4("4");
		otppage.submitButton();
		adddevicepage.verifyAddDevicePage("Add Device");
		
	}
	
}