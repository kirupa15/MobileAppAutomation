package testcases_Analytics;

import static org.testng.Assert.fail;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AddDevicePage;
import pages.Analytics;
import pages.DeviceMenuPage;
import pages.HomePage;
import utils.logReadandWrite;
import wrappers.MobileAppWrappers;

public class TC_05_Analytics extends MobileAppWrappers {

	HomePage homepage;
	AddDevicePage adddevicepage;
	DeviceMenuPage devicemenupage;
	Analytics analyticspage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC_05_Analytics";
		testDescription = "Pairing mode=Wifi With Router <br> Connectivity :STA <br>Turn on device for 5min using relay  <br> check for analytivs value<br>Energy duration and Energy used for 5 min should update";
	}
	
	@Test
	public void removerepair() throws Exception {
		initAndriodDriver();
		pairBlewithoutRouter();
	}
	
	public void pairBlewithoutRouter() throws Exception {
		adddevicepage= new AddDevicePage(driver);
		homepage = new HomePage(driver);
		devicemenupage= new DeviceMenuPage(driver);
		analyticspage= new Analytics(driver);
		
		logReadandWrite readwrite = new logReadandWrite(loadProp("COM"));
		try {
		readwrite.openPort();
		Thread.sleep(2000);
		readwrite.write("reboot\r");
		Thread.sleep(3000);
		readwrite.write("factory_reset\r");
		
		adddevicepage.pair(4);
		adddevicepage.clickNextButtonsZephyrInfo();
		adddevicepage.checkdevicedetailstoast();
		adddevicepage.clickSubmitButtonDeviceSetting();
		adddevicepage.checkdevicesettingstoast();
		
		analyticspage.navigateAnalyticsPage();
		analyticspage.getenergydurationvalue();
		analyticspage.navigatehomepage();
		Thread.sleep(2000);
		homepage.clickONOFFButton();
		Thread.sleep(1*60*1000);
		homepage.clickONOFFButton();
		analyticspage.navigateAnalyticsPage();
		analyticspage.checkenrgyduration(1);
		
			
		
		
		}
		catch (Exception e) {
			e.printStackTrace();
			readwrite.closePort();
			fail("Failed due to this exception", e);
		}
	}
}
