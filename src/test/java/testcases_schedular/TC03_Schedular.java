package testcases_schedular;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AddDevicePage;
import pages.DeviceMenuPage;
import pages.HomePage;
import pages.LandingPage;
import pages.OtpPage;
import pages.Schedularpage;
import pages.SignInPage;
import utils.logReadandWrite;
import wrappers.MobileAppWrappers;

public class TC03_Schedular extends MobileAppWrappers {

	LandingPage landingpage;
	SignInPage loginpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	DeviceMenuPage devicemenupage;
	Schedularpage schedulepage;

	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC01 - Pairinfg BLE With Router";
		testDescription = "Sign In and Start Pairing BLE with Router mode";
	}

	@Test
	public void schedule() throws Exception {
		initAndriodDriver();

		loginpage = new SignInPage(driver);
		landingpage = new LandingPage(driver);
		otppage = new OtpPage(driver);
		adddevicepage = new AddDevicePage(driver);
		devicemenupage = new DeviceMenuPage(driver);
		schedulepage = new Schedularpage(driver);

		logReadandWrite readwrite=new logReadandWrite("COM4");
		readwrite.openPort();
		readwrite.read();
		Thread.sleep(2000);
		readwrite.write("factory_reset\r");
		
		try {
			schedulepage.createschedule(3,3,1);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
		schedulepage.checkon_off(1);//to set min to wait for app turn on.
		schedulepage.checkon_off(1);//to set min to wait for app turn on.
		schedulepage.checkon_off(1);//to set min to wait for app turn on.
		
		readwrite.closePort();
		
	}
}
