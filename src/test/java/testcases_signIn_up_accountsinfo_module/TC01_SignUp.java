package testcases_signIn_up_accountsinfo_module;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import jssc.SerialPortException;
import pages.AddDevicePage;
import pages.DeviceMenuPage;
import pages.HomePage;
import pages.LandingPage;
import pages.OtpPage;
import pages.SignInPage;
import pages.SignUpPage;
import utils.GetAppLog;
import utils.PassSTComment;
import utils.logReadandWrite;
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
	public void signUp() throws FileNotFoundException, IOException, InterruptedException, SerialPortException {

		initAndriodDriver();
		loginpage = new SignInPage(driver);
		landingpage = new LandingPage(driver);
		otppage = new OtpPage(driver);
		signuppage =new SignUpPage(driver);
		GetAppLog applog= new GetAppLog();
		applog.startLogProcess();
		
		/*
		 * logReadandWrite readwrite=new logReadandWrite("COM4"); readwrite.openPort();
		 * readwrite.read(); Thread.sleep(2000); readwrite.write("button_press\r");
		 */
		landingpage.clickSignUpButton();
		
		signuppage.enterUserName("testuser");
		signuppage.enterEmailId("testuser@gmail.com");
		signuppage.clickSignUpTCCheckBox();
		signuppage.clickSignUpButton();
		//readwrite.write("button_press\r");
		signuppage.checkUserNameExistToast("Username and Email ID both are already exists");
		//readwrite.closePort();
	}

}