package testcases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddDevicePage;
import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;
import pages.OtpPage;
import wrappers.MobileAppWrappers;


public class TC01_Pairing_BlewithRouter extends MobileAppWrappers {

	LandingPage landingpage;
	LoginPage loginpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC01 - Pairinfg BLE With Router";
		testDescription = "Sign In and Start Pairing BLE with Router mode";
	}
	

	@Test
	public void pairBlewithoutRouter() throws FileNotFoundException, IOException {
		
		loginpage = new LoginPage(driver);
		landingpage = new LandingPage(driver);
		otppage = new OtpPage(driver);
		adddevicepage= new AddDevicePage(driver);
		homepage = new HomePage(driver);
		landingpage.clickSignInButton();
		loginpage.enterEmailId("testuser1237@gmail.com");
		loginpage.clickSignInButton();
		otppage.enterOTPField1("1");
		otppage.enterOTPField2("2");
		otppage.enterOTPField3("3");
		otppage.enterOTPField4("4");
		otppage.submitButton();
		
		adddevicepage.clickAddDeviceButton();
		adddevicepage.checkBoxPairing();
		adddevicepage.nextButtonPairing();
		adddevicepage.startPairingButton();
		adddevicepage.locationPopUpPermission();
		adddevicepage.nearByPermission();
		adddevicepage.enterWiFiPassword("12345678915");
		adddevicepage.clickEnterButton();		
		homepage.clickONOFFButton();
		
		//clickbyXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[7]/android.view.ViewGroup"); 
		/*clickbyXpath("//android.widget.TextView[@text=\"\"]");
		clickbyXpath("//android.widget.TextView[@text='']");
		clickbyXpath("//android.widget.TextView[@text='Reset Device']"); 
		clickbyXpath("//android.widget.Button[@resource-id='android:id/button1']");*/
	}

}
