package testcases_schedular;

import static org.testng.Assert.fail;

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

public class TC01_Schedular extends MobileAppWrappers {

	LandingPage landingpage;
	SignInPage loginpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	DeviceMenuPage devicemenupage;
	Schedularpage schedulepage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC01_Schedular";
		testDescription = "Sign In and Start Pairing BLE with Router mode";
	}
	
	@Test
	public void schedule() throws Exception {
		initAndriodDriver();

		loginpage = new SignInPage(driver);
		landingpage = new LandingPage(driver);
		otppage = new OtpPage(driver);
		adddevicepage= new AddDevicePage(driver);
		devicemenupage= new DeviceMenuPage(driver);
		schedulepage=new Schedularpage(driver);

		logReadandWrite readwrite = logReadandWrite.getInstance("COM4");
		readwrite.openPort();
//		readwrite.read();
		Thread.sleep(2000);
		readwrite.write("factory_reset\r");
		try {
			schedulepage.createschedule(4,1,2);//(mode,loopcount,minutesgap between schedules)
	
			readwrite.closePort();
			} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			readwrite.closePort();
			fail("Failed due to this exception", e);
		}
	}
	
//	@Test
//	public void verifylogs() {
//
//		try {
//			schedulepage.verifyinglog("C:\\Users\\Invcuser_45\\Desktop\\React-Log-20240920_171438.txt", "C:\\Users\\Invcuser_45\\Desktop\\LiveLog\\teraterm.log", "STA");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
}
