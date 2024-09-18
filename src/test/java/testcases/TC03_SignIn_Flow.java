package testcases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AddDevicePage;
import pages.DeviceMenuPage;
import pages.HomePage;
import pages.LandingPage;
import pages.SignInPage;
import pages.OtpPage;
import wrappers.MobileAppWrappers;

public class TC03_SignIn_Flow extends MobileAppWrappers {

	LandingPage landingpage;
	SignInPage signinpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	DeviceMenuPage devicemenupage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC03 - Check Sign In Flow";
		testDescription = "Sign In and Start Pairing BLE with Router mode";
	}
	

	@Test
	public void signIn() throws FileNotFoundException, IOException, InterruptedException {
		
	signinpage = new SignInPage(driver);
	landingpage = new LandingPage(driver);
	otppage = new OtpPage(driver);
	
	landingpage.clickSignInButton();
	signinpage.enterUserName("testuser1237");
	signinpage.clickSignInButton();
	landingpage.clickSignInButton();
	signinpage.enterUserName("testuser1237@gmail.com");
	signinpage.clickSignInButton();
	otppage.enterOTPField1("1");
	otppage.enterOTPField2("2");
	otppage.enterOTPField3("3");
	otppage.enterOTPField4("4");
	otppage.submitButton();
	
	
	}

}