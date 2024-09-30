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
import pages.SignUpPage;
import wrappers.MobileAppWrappers;
import java.util.Random;

public class TC02_SignUp_Flow extends MobileAppWrappers {

	LandingPage landingpage;
	SignInPage loginpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	DeviceMenuPage devicemenupage;
	SignUpPage signuppage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC02 - Check Sign Up Flow";
		testDescription = "Sign In and Start Pairing BLE with Router mode";
	}
	

	@Test
	public void signUp() throws FileNotFoundException, IOException, InterruptedException {
		
	loginpage = new SignInPage(driver);
	landingpage = new LandingPage(driver);
	otppage = new OtpPage(driver);
	signuppage =new SignUpPage(driver);
	
	landingpage.clickSignUpButton();
	double rand=Math.random()*10000000;
	signuppage.enterUserName("testuser"+(int)rand);
	signuppage.enterEmailId("testuser"+(int)rand+"@gmail.com");
	signuppage.clickSignUpTCButton();
	signuppage.checkPpContentTitle("Privacy Policy");
	signuppage.checkPpContent("IINVSYS Private Limited (here is referred as IINVSYS or Company)");
	signuppage.checkPpContactUsContent("For questions regarding our Privacy Policy, please contact our customer care via email at support@iinvsys.com");
	signuppage.clicktcPopupCloseButton();
	signuppage.clickSignUpButton();
	
	}

}