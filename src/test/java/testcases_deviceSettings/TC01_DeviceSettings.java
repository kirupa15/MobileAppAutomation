package testcases_deviceSettings;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddDevicePage;
import pages.DeviceMenuPage;
import pages.HomePage;
import utils.PassSTComment;
import utils.logReadandWrite;
import wrappers.MobileAppWrappers;


public class TC01_DeviceSettings extends MobileAppWrappers {

	HomePage homepage;
	AddDevicePage adddevicepage;
	DeviceMenuPage devicemenupage;
	
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC01 - RemoveRouter";
		testDescription = "Added Router to device ,disbale BLe and check STA connectivity";
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
		
		logReadandWrite readwrite=new logReadandWrite("COM4");
		try {
		readwrite.openPort();
		readwrite.read();
		Thread.sleep(2000);
		readwrite.write("factory_reset\r");
		
		adddevicepage.pair(1);
		adddevicepage.clickNextButtonsZephyrInfo();
		adddevicepage.clickSubmitButtonDeviceSetting();
		
		
		Thread.sleep(2000);
		

			homepage.clickMenuBarButton();
			Thread.sleep(1000);
			devicemenupage.clickDeviceSettingsButton();
			Thread.sleep(3000);
	//Add Router Test Case		
			devicemenupage.ClickaddrouterButton();
			Thread.sleep(3000);
			adddevicepage.enterWiFiPassword(adddevicepage.wifiPassword);
			devicemenupage.clickAddRouterCheckBox();
			adddevicepage.clickEnterButton();
			Thread.sleep(5000);
			devicemenupage.clickDeviceSettingsBackButton();
			turnOffBT();
			Thread.sleep(20000);
			
			for(int i=0;i<2;i++) {
				homepage.clickONOFFButton();
				Thread.sleep(1000);
				}
			
			homepage.clickMenuBarButton();
			devicemenupage.clickMenuBarRemoveDevice();
			devicemenupage.clickRemoveDevicePopupYesButton();
			devicemenupage.AddDevicePagedisplayed();
			 readwrite.closePort();
		}
		catch (Exception e) {
			e.printStackTrace();
			readwrite.closePort();
		}
	}

}
