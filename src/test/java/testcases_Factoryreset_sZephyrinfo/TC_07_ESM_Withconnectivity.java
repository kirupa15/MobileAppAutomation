package testcases_Factoryreset_sZephyrinfo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AddDevicePage;
import pages.DeviceMenuPage;
import pages.HomePage;
import pages.LandingPage;
import pages.OtpPage;
import pages.SignInPage;
import pages.SignUpPage;
import utils.logReadandWrite;
import wrappers.MobileAppWrappers;

public class TC_07_ESM_Withconnectivity extends MobileAppWrappers {

	LandingPage landingpage;
	SignInPage loginpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	DeviceMenuPage devicemenupage;
	SignUpPage signuppage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC06 - Change the few values in the AC Info page and check user can able to save the updated values";
		testDescription = " User should be allowed to edit and save the AC Info page values without any issue\r\n"
				+ "";
	}



@Test
public void removerepair() throws Exception {
	initAndriodDriver();
	pairBlewithoutRouter();
}



//String modelname ="G20";
//String capacity="2";
public void pairBlewithoutRouter() throws Exception {
	adddevicepage= new AddDevicePage(driver);
	homepage = new HomePage(driver);
	devicemenupage= new DeviceMenuPage(driver);
	
	logReadandWrite readwrite=new logReadandWrite("COM4");
	readwrite.openPort();
	readwrite.read();
	Thread.sleep(2000);
	readwrite.write("factory_reset\r");
	
	adddevicepage.pair(4);
	adddevicepage.clickNextButtonsZephyrInfo();
	adddevicepage.clickSubmitButtonDeviceSetting();
	
	homepage.clickMenuBarButton();
	devicemenupage.clickDeviceSettingsButton();
	devicemenupage.CheckEsmButton();
	Thread.sleep(1000);
	devicemenupage.ClickToggledisable();
	Thread.sleep(1000);
	devicemenupage.ClickEsmOKButton();
	Thread.sleep(1000);
	devicemenupage.ClickBackButtonESM();
	devicemenupage.CheckEsmButton();
	Thread.sleep(2000);
	    
	                                   //TC_02
	
	devicemenupage.ClickBackButtonESM();
	devicemenupage.CheckEsmButton();
	Thread.sleep(1000);
	devicemenupage.ClicktoggleButton();
	devicemenupage.CheckModeratefeature();
	//devicemenupage.cl
	Thread.sleep(1000);
	devicemenupage.checkSuccessfullyToast();
	

	

}

}
