package testcases_Multidevice;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AddDevicePage;
import pages.DeviceMenuPage;
import pages.HomePage;
import pages.LandingPage;
import pages.OtpPage;
import pages.Reportpage;
import pages.SignInPage;
import pages.SignUpPage;
import wrappers.MobileAppWrappers;

public class TC_08_Report_Page extends MobileAppWrappers {

//	private static final String Reportpagexpath = null;
	LandingPage landingpage;
	SignInPage loginpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	DeviceMenuPage devicemenupage;
	Reportpage reportpage;
	SignUpPage signuppage;


	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC01 - Pairinfg BLE With Router";
		testDescription = "Sign In and Start Pairing BLE with Router mode";
	}

	@Test
	public void removerepair() throws FileNotFoundException, IOException, InterruptedException {
		login();
		for (int i = 0; i < 1; i++) {
			pairBlewithoutRouter();
		}
	}

	public void login() {
		loginpage = new SignInPage(driver);
		landingpage = new LandingPage(driver);
		otppage = new OtpPage(driver);
		homepage = new HomePage(driver);
		adddevicepage = new AddDevicePage(driver);
		devicemenupage = new DeviceMenuPage(driver);
		reportpage = new Reportpage(driver);
		signuppage=new SignUpPage(driver);


		landingpage.clickSignInButton();
		signuppage.enterEmailId("Nee@gmail.com");
		loginpage.clickSignInButton();
		otppage.enterOTPField1("1");
		otppage.enterOTPField2("2");
		otppage.enterOTPField3("3");
		otppage.enterOTPField4("4");
		otppage.submitButton();

	}

	public void pairBlewithoutRouter() throws FileNotFoundException, IOException, InterruptedException {
		adddevicepage = new AddDevicePage(driver);
		homepage = new HomePage(driver);
		devicemenupage = new DeviceMenuPage(driver);

		adddevicepage.clickAddDeviceButton();
		adddevicepage.checkBoxPairing();
		adddevicepage.nextButtonPairing();
		adddevicepage.startPairingButton();
		adddevicepage.locationPopUpPermission();
		adddevicepage.nearByPermission();

		//adddevicepage.ClickCancelButtonBle();
		adddevicepage.enterWiFiPassword("12345678908");
		adddevicepage.clickEnterButton();
		//devicemenupage.ClickOkButtonBLEpopUP();
		adddevicepage.clickNextButtonsZephyrInfo();
		adddevicepage.clickSubmitButtonDeviceSetting();

		for (int i = 0; i < 2; i++) {
			homepage.clickONOFFButton();
			Thread.sleep(1000);
		}

		homepage.clickMenuBarButton();
		Thread.sleep(1000);
		reportpage.ClickReportpage();
		reportpage.Clickissuetype();
		reportpage.ClickAppissue();
		reportpage.Clickdevicename();
		reportpage.ClickIssuename();
//		ClickIssuedescription();
		reportpage.sendDesscription();
		reportpage.ClickIssueobsserved();
		reportpage.Clickenterdate();
		reportpage.Enterdate();
		reportpage.Clickokbutton();
		
		reportpage.scrollpage();//click+button
		
		reportpage.Uploadscreenshort();
		reportpage.Clickallowall();
		reportpage.selectphotos();
		reportpage.Clickaddoption();

	}
}
