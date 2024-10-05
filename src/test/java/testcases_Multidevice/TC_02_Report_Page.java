package testcases_Multidevice;

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

public class TC_02_Report_Page extends MobileAppWrappers {

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
	public void removerepair() throws Exception {
			initAndriodDriver();
			pairBlewithoutRouter();
	}


	public void pairBlewithoutRouter() throws Exception {
		adddevicepage = new AddDevicePage(driver);
		homepage = new HomePage(driver);
		devicemenupage = new DeviceMenuPage(driver);
		reportpage= new Reportpage(driver);
		
		adddevicepage.pair(2);
		//devicemenupage.ClickOkButtonBLEpopUP();
		adddevicepage.clickNextButtonsZephyrInfo();
		adddevicepage.clickSubmitButtonDeviceSetting();

		for (int i = 0; i < 2; i++) {
			homepage.clickONOFFButton();
			Thread.sleep(1000);
		}

		homepage.clickMenuBarButton();
		Thread.sleep(3000);
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
