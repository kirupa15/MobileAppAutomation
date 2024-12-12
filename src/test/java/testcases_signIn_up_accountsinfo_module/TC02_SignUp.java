package testcases_signIn_up_accountsinfo_module;

import static org.testng.Assert.fail;

import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AddDevicePage;
import pages.DeviceMenuPage;
import pages.HomePage;
import pages.LandingPage;
import pages.SignInPage;
import pages.OtpPage;
import pages.SignUpPage;
import utils.logReadandWrite;
import wrappers.MobileAppWrappers;

public class TC02_SignUp extends MobileAppWrappers {

	LandingPage landingpage;
	SignInPage loginpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	DeviceMenuPage devicemenupage;
	SignUpPage signuppage;
	

	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC02_SignUp";
		testDescription = "Try to Sign Up with new username";
	}


	@Test
	public void signUp() throws Exception {
		initAndriodDriver();
		loginpage = new SignInPage(driver);
		landingpage = new LandingPage(driver);
		otppage = new OtpPage(driver);
		signuppage =new SignUpPage(driver);
		logReadandWrite readwrite = new logReadandWrite(loadProp("COM"));
		try {
		readwrite.openPort();
		
		signuppage.uninstall_reinstall();
		landingpage.clickSignUpLink();
		double rand=Math.random()*10000000;
		signuppage.enterUserName("testuser"+(int)rand);
		signuppage.enterEmailId("testuser"+(int)rand+"@gmail.com");
		System.out.println("New user: testuser"+(int)rand+"@gmail.com");
		signuppage.clickSignUpTCButton();
		signuppage.checkPpContentTitle("Privacy Policy");
		signuppage.checkPpContent("IINVSYS Private Limited (here is referred as IINVSYS or Company)");
		signuppage.checkPpContactUsContent("For questions regarding our Privacy Policy, please contact our customer care via email at support@iinvsys.com");
		signuppage.clicktcPopupCloseButton();
		signuppage.clickSignUpTCCheckBox();
		signuppage.clickSignUpButton();
		otppage.verifyOTPVerificationTitle("OTP Verification");
		readwrite.closePort();
		}
		catch (Exception e) {
			e.printStackTrace();
			readwrite.closePort();
			fail("Failed due to this exception", e);
		}

	}

}