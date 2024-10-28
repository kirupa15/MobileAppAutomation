package testcases_signIn_up_accountsinfo_module;

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

public class TC03_SignIn_Flow extends MobileAppWrappers {

	LandingPage landingpage;
	SignInPage signinpage;
	HomePage homepage;
	OtpPage otppage;
	SignUpPage signuppage;

	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC03_Sign In with unregistered username";
		testDescription = "Try to Sign In with unregistered username";
	}


	@Test
	public void signIn() throws Exception {
		initAndriodDriver();
		signinpage = new SignInPage(driver);
		landingpage = new LandingPage(driver);
		otppage = new OtpPage(driver);
		signuppage =new SignUpPage(driver);

		logReadandWrite readwrite=new logReadandWrite("COM4");
		try {
		readwrite.openPort();
		readwrite.read();
		Thread.sleep(2000);
		readwrite.write("factory_reset\r");
		
		signuppage.uninstall_reinstall();
		landingpage.clickSignInButton();
		double rand=Math.random()*100000000;
		signinpage.enterUserName("user"+(int)rand);
		signinpage.clickSignInButton();
		signinpage.checkUserNameNotFoundToast("User Not Found");

		readwrite.closePort();
		}
		catch (Exception e) {
			e.printStackTrace();
			readwrite.closePort();
		}
	}

}