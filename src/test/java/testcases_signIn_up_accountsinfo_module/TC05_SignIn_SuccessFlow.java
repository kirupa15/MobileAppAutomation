package testcases_signIn_up_accountsinfo_module;

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

public class TC05_SignIn_SuccessFlow extends MobileAppWrappers {

	LandingPage landingpage;
	SignInPage loginpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC05 - Sign Up or Sign In, enter valid OTP";
		testDescription = "During Sign Up or Sign In, enter valid OTP";
	}
	

	@Test
	public void login() throws InterruptedException, FileNotFoundException, IOException {
		initAndriodDriver();
		loginpage = new SignInPage(driver);
		landingpage = new LandingPage(driver);
		otppage = new OtpPage(driver);
		adddevicepage= new AddDevicePage(driver);
		
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