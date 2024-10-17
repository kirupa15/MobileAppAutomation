package testcases_deviceSettings;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddDevicePage;
import pages.DeviceMenuPage;
import pages.HomePage;
import wrappers.MobileAppWrappers;


public class TC03_DeviceSettings extends MobileAppWrappers {

	HomePage homepage;
	AddDevicePage adddevicepage;
	DeviceMenuPage devicemenupage;
	
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC03 - DeviceSettings";
		testDescription = "Enable The Quite LED Mode and Do Relya ON&OFF Check LED Working Or Not";
	}
	

	@Test
	public void removerepair() throws Exception {
		pairBlewithoutRouter();
	}

	
	public void pairBlewithoutRouter() throws Exception {
		adddevicepage= new AddDevicePage(driver);
		homepage = new HomePage(driver);
		devicemenupage= new DeviceMenuPage(driver);
		
		
		adddevicepage.pair(1);
		adddevicepage.clickNextButtonsZephyrInfo();
		adddevicepage.clickSubmitButtonDeviceSetting();
		
		
		for(int i=0;i<2;i++) {
		homepage.clickONOFFButton();
		Thread.sleep(1000);
		}
		
//LED Working Properly	
		
		    Thread.sleep(2000);
			homepage.clickMenuBarButton();
			Thread.sleep(1000);
			devicemenupage.clickDeviceSettingsButton();
			Thread.sleep(1000);
			
			
//Enable The Quiet LED Mode Test Case
			devicemenupage.clickQuietLEDToggleForOn();
			Thread.sleep(1000);
			devicemenupage.clickDeviceSettingsBackButton();
			
//Relay ON/OFF Time Device LED Was Not Working Expected Scenario 
			for(int i=0;i<4;i++) {
				homepage.clickONOFFButton();
				Thread.sleep(1000);
				}
			
//Disable The Quiet LED Mode Test Case
			homepage.clickMenuBarButton();
			Thread.sleep(1000);
			devicemenupage.clickDeviceSettingsButton();
			Thread.sleep(1000);
			devicemenupage.clickQuietLEDToggleForOff();
			Thread.sleep(1000);
			devicemenupage.clickDeviceSettingsBackButton();
			
//Relay ON/OFF Time Device LED Was Working Expected Scenario 
			for(int i=0;i<4;i++) {
				homepage.clickONOFFButton();
				Thread.sleep(1000);
				}
			
			homepage.clickMenuBarButton();
			devicemenupage.clickMenuBarRemoveDevice();
			devicemenupage.clickRemoveDevicePopupNoButton();
			Thread.sleep(1000);
			homepage.clickMenuBarButton();
			devicemenupage.clickMenuBarRemoveDevice();
			devicemenupage.clickRemoveDevicePopupYesButton();
			Thread.sleep(2000);
	}

}


