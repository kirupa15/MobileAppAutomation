package sZephyr_testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AddDevicePage;
import pages.DeviceMenuPage;
import pages.Energy_SavingPage;
import pages.HomePage;
import pages.LandingPage;
import pages.OtpPage;
import pages.SignInPage;
import pages.SignUpPage;
import utils.logReadandWrite;
import wrappers.MobileAppWrappers;

public class TC36_ESMmode extends MobileAppWrappers {

	LandingPage landingpage;
	SignInPage loginpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	DeviceMenuPage devicemenupage;
	SignUpPage signuppage;
	Energy_SavingPage ESM;

	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC36_ESM mode button check";
		testDescription = " Paired in BLE without router mode -User should be allowed to edit and save the Energy saving mode  page values without any issue\r\n"
				+ "";
	}



	@Test(priority = 34)
	public void TC36_ESM_mode_button_check() throws Exception {
		initAndriodDriver();
		
		adddevicepage= new AddDevicePage(driver);
		homepage = new HomePage(driver);
		devicemenupage= new DeviceMenuPage(driver);
		ESM = new Energy_SavingPage(driver);

		logReadandWrite readwrite = logReadandWrite.getInstance(loadProp("COM"));
		try {
			readwrite.openPort();
			
			adddevicepage.pair(1);
			adddevicepage.clickNextButtonsZephyrInfo();
			adddevicepage.clickBleokbutton();
			adddevicepage.clickSubmitButtonDeviceSetting();
			
			//60 percent mode check 
			ESM.ClickEsmButton();
			ESM.ClickEsmToggle();
			ESM.ClickUpto60percent();
			ESM.ClickOkbutton();
			ESM.checkToast();
			
			ESM.ClickEsmButton();
			ESM.ClickEsmToggle();
			ESM.ClickOkbutton();
			ESM.checkToast();
			
			
			//40percent mode check
			ESM.ClickEsmButton();
			ESM.ClickEsmToggle();
			ESM.ClickUpto40percent();
			ESM.ClickOkbutton();
			ESM.checkToast();
			
			ESM.ClickEsmButton();
			ESM.ClickEsmToggle();
			ESM.ClickOkbutton();
			ESM.checkToast();
			
			//20 percent mode page check
			ESM.ClickEsmButton();
			ESM.ClickEsmToggle();
			ESM.ClickUpto20percent();
			ESM.ClickOkbutton();
			ESM.checkToast();
			
			ESM.ClickEsmButton();
			ESM.ClickEsmToggle();
			ESM.ClickOkbutton();
			ESM.checkToast();
			
			
			
			
		}
		catch (Exception e) {
			readwrite.closePort();
			fail(e);
		}
		
   }
}