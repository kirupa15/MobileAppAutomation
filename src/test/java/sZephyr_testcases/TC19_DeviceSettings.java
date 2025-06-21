package sZephyr_testcases;

import static org.testng.Assert.fail;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddDevicePage;
import pages.DeviceMenuPage;
import pages.HomePage;
import pages.StoreLogPage;
import utils.PassSTComment;
import utils.logReadandWrite;
import wrappers.MobileAppWrappers;


public class TC19_DeviceSettings extends MobileAppWrappers {

	HomePage homepage;
	AddDevicePage adddevicepage;
	DeviceMenuPage devicemenupage;
	StoreLogPage logpage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC19_DeviceSettings_Add_Router";
		testDescription = "Added Router to device ,disbale BLe and check STA connectivity";
	}
	

	@Test(priority = 18)
	public void TC19_DeviceSettings_Add_Router() throws Exception {
		initAndriodDriver();
		pairBlewithoutRouter();
	}


	
	public void pairBlewithoutRouter() throws Exception {

		
		adddevicepage= new AddDevicePage(driver);
		homepage = new HomePage(driver);
		devicemenupage= new DeviceMenuPage(driver);
		logpage= new StoreLogPage(driver);
		
		logReadandWrite readwrite = logReadandWrite.getInstance(loadProp("COM"));
		try {
		readwrite.openPort();
		
		adddevicepage.pair(1);
		adddevicepage.clickNextButtonsZephyrInfo();
		adddevicepage.checkdevicedetailstoast();
		adddevicepage.clickSubmitButtonDeviceSetting();
		adddevicepage.checkdevicesettingstoast();
		
		
		Thread.sleep(2000);
		

			homepage.clickMenuBarButton();
			devicemenupage.clickDeviceSettingsButton();
	//Add Router Test Case		
			devicemenupage.ClickaddrouterButton();
			adddevicepage.enterWiFiPassword(adddevicepage.wifiPassword);
			devicemenupage.clickAddRouterCheckBox();
			adddevicepage.clickEnterButton();
			adddevicepage.checkrouteraddedsuccessfultoast();
			devicemenupage.clickDeviceSettingsBackButton();
			turnOffBT();
			Thread.sleep(15000);
			homepage.getCurrentvalue();
			homepage.getVoltvalue();
			homepage.getPowervalue();
			
			for(int i=0;i<2;i++) {
				homepage.clickONOFFButton();
				Thread.sleep(1000);
				}
			
			disableWiFi();
			turnOnBT();
			Thread.sleep(10000);
			
			homepage.getCurrentvalue();
			homepage.getVoltvalue();
			homepage.getPowervalue();
			
			 homepage.clickMenuBarButton();
				devicemenupage.clickMenuBarRemoveDevice();
				devicemenupage.clickRemoveDevicePopupYesButton();
				adddevicepage.checkdeviceremovedtoast();
				devicemenupage.AddDevicePagedisplayed();
			 readwrite.closePort();
		}
		catch (Exception e) {
			readwrite.closePort();
			logpage.CollectLogOnFailure(testCaseName,testDescription);
			fail(e);
		}
	}

}
