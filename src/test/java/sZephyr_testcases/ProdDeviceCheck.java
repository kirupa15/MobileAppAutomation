package sZephyr_testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AddDevicePage;
import pages.Analytics;
import pages.DeviceMenuPage;
import pages.HomePage;
import pages.LandingPage;
import pages.OtpPage;
import pages.SignInPage;
import utils.logReadandWrite;
import wrappers.MobileAppWrappers;

public class ProdDeviceCheck extends MobileAppWrappers {

	LandingPage landingpage;
	SignInPage loginpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	DeviceMenuPage devicemenupage;
	Analytics analyticspage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "Prod Device Sanity Check";
		testDescription = "Pro Validation Sanity Check";
	}
	
	
//	(retryAnalyzer = Retry_analyser.class)
//	@Test()
	public void Prod_Device_Sanity_Check() throws Exception {
		initAndriodDriver();
		loginpage = new SignInPage(driver);
		landingpage = new LandingPage(driver);
		otppage = new OtpPage(driver);
		adddevicepage= new AddDevicePage(driver);
		homepage = new HomePage(driver);
		devicemenupage= new DeviceMenuPage(driver);
		
		try {
		adddevicepage.pair(1);
		adddevicepage.clickNextButtonsZephyrInfo();
		adddevicepage.clickSubmitButtonDeviceSetting();
		
		//Check BLE Connectivity
		homepage.checkBLEConnectivity();
		
		//ON/OFF Check
		homepage.clickONOFFButton();
		Thread.sleep(2000);
		homepage.clickONOFFButton();
		Thread.sleep(2000);
		
		//Temp Sensor working or not
		homepage.checkTempSensorWorking();
		
		//Analytics Check
		analyticspage.navigateAnalyticsPage();
		analyticspage.getenergydurationvalue();
		analyticspage.navigatehomepage();
		Thread.sleep(2000);
		homepage.clickONOFFButton();
		Thread.sleep(2*60*1000);
		homepage.clickONOFFButton();
		analyticspage.navigateAnalyticsPage();
		analyticspage.checkenrgyduration(2);
		
		//Factory Reset
		homepage.clickMenuBarButton();
		devicemenupage.clickDeviceSettingsButton();
		devicemenupage.clickResetDeviceButton();
		devicemenupage.clickResetConfirmationYesButton();
		adddevicepage.checkdeviceresettoast();
		devicemenupage.AddDevicePagedisplayed();
		}
		catch (Exception e) {
			fail(e);
		}
	}

	//newly added SKIP in extent report 
	//newly added toast reader in add device page 
	//newly added info 
	
	//To add toast in all page,need to do
}

