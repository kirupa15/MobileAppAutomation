package testcase_Factoryreset_sZephyrinfo;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AddDevicePage;
import pages.DeviceMenuPage;
import pages.HomePage;
import pages.LandingPage;
import pages.OtpPage;
import pages.SignInPage;
import pages.SignUpPage;
import wrappers.MobileAppWrappers;

public class TC_06_sZephyr_Info extends MobileAppWrappers {

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
public void removerepair() throws FileNotFoundException, IOException, InterruptedException {
	login();
	for(int i=0;i<1;i++) {
	pairBlewithoutRouter();}
}

public void login() {
	loginpage = new SignInPage(driver);
	landingpage = new LandingPage(driver);
	otppage = new OtpPage(driver);
	
	landingpage.clickSignInButton();
	loginpage.enterUserName("Raj");
	loginpage.clickSignInButton();
	otppage.enterOTPField1("1");
	otppage.enterOTPField2("2");
	otppage.enterOTPField3("3");
	otppage.enterOTPField4("4");
	otppage.submitButton();
	
}

String modelname ="G20";
String capacity="2";
public void pairBlewithoutRouter() throws FileNotFoundException, IOException, InterruptedException {
	adddevicepage= new AddDevicePage(driver);
	homepage = new HomePage(driver);
	devicemenupage= new DeviceMenuPage(driver);
	
	
	adddevicepage.clickAddDeviceButton();
	adddevicepage.checkBoxPairing();
	adddevicepage.nextButtonPairing();
	adddevicepage.startPairingButton();
	adddevicepage.locationPopUpPermission();
	adddevicepage.nearByPermission();
	
	//adddevicepage.ClickCancelButtonBle();
	//adddevicepage.enterWiFiPassword("12345678908");
	//adddevicepage.clickEnterButton();
	adddevicepage.cancelButton();
	Thread.sleep(1000);
	//adddevicepage.ClickOkButtonBLEpopUP();
	adddevicepage.ClickBrandName();
	adddevicepage.ClickSelectName();
	adddevicepage.enterAcModelName("G20");
	adddevicepage.enterCapacity("2");
	adddevicepage.ClickRoomSizeButton();
	adddevicepage.SelectRoomSizeOption();
	Thread.sleep(1000);
	adddevicepage.clickNextButtonsZephyrInfo();
	adddevicepage.clickSubmitButtonDeviceSetting();
	Thread.sleep(1000);
	for(int i=0;i<2;i++) {
	homepage.clickONOFFButton();
	Thread.sleep(1000);
	}
	
	homepage.clickMenuBarButton();
	devicemenupage.ClickSzephyrInfoButton();
	Thread.sleep(1000);
	devicemenupage.CheckSzephyrInfPageBrandName();
	devicemenupage.CheckSzephyrInfPageModelName();
	devicemenupage.CheckSzephyrInfPageCapacity();
	devicemenupage.CheckSzephyrInfPageRoomSize();
	Thread.sleep(1000);
	
	
	//devicemenupage.clickDeviceSettingsButton();
	//devicemenupage.clickResetDeviceButton();
	//devicemenupage.clickResetConfirmationYesButton();
}

}
