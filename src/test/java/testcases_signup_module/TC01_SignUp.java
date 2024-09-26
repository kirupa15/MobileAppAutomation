package testcases_signup_module;

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
import pages.SignUpPage;
import wrappers.MobileAppWrappers;

public class TC01_SignUp extends MobileAppWrappers {

	LandingPage landingpage;
	SignInPage loginpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	DeviceMenuPage devicemenupage;
	SignUpPage signuppage;

	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC01 - SignUp with already existing username";
		testDescription = "Try to Sign Up with already registered username";
	}


	@Test
	public void signUp() throws FileNotFoundException, IOException, InterruptedException {
		initAndriodDriver();
		loginpage = new SignInPage(driver);
		landingpage = new LandingPage(driver);
		otppage = new OtpPage(driver);
		signuppage =new SignUpPage(driver);

		landingpage.clickSignUpButton();
		double rand=Math.random()*10000000;
		signuppage.enterUserName("testuser");
		signuppage.enterEmailId("testuser@gmail.com");
		signuppage.clickSignUpTCCheckBox();
		signuppage.clickSignUpButton();
		signuppage.checkUserNameExistToast("Username and Email ID both are already exists");

	}

}