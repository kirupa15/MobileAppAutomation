package connectivity;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.TimeoutException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import pages.AddDevicePage;
import pages.DeviceMenuPage;
import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;
import pages.OTA_Status_monitor;
import pages.OtpPage;
import pages.Szephyr_info_Page;
import wrappers.MobileAppWrappers;


public class  WifiWithRouter extends MobileAppWrappers {

	LandingPage landingpage;
	LoginPage loginpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	DeviceMenuPage devicemenupage;
	Szephyr_info_Page szephyrinfoPage;
	OTA_Status_monitor ota_Status_monitor;
		
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "CONNECTIVITY_MOD_5_TC_01,CONNECTIVITY_MOD_5_TC_02,CONNECTIVITY_MOD_5_TC_03";
		testDescription = "OTA update BLE without Router mode";
	}
	

	@Test
	public void removerepair() throws FileNotFoundException, IOException, InterruptedException {
//		login();
//		for(int i=0;i<1;i++) {
//		pairBlewithoutRouter();
//		}
		
		adddevicepage= new AddDevicePage(driver);
		homepage = new HomePage(driver);
		devicemenupage= new DeviceMenuPage(driver);
		szephyrinfoPage= new Szephyr_info_Page(driver);
		landingpage=new LandingPage(driver);
		loginpage=new LoginPage(driver);
		
		try {
			adddevicepage.pair(4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void login() {
		loginpage = new LoginPage(driver);
		landingpage = new LandingPage(driver);
		otppage = new OtpPage(driver);
		ota_Status_monitor=new OTA_Status_monitor(driver);
		
		
		landingpage.clickSignInButton();
		loginpage.enterEmailId("varadharajanram95@gmail.com");
		loginpage.clickSignInButton();
		otppage.enterOTPField1("1");
		otppage.enterOTPField2("2");
		otppage.enterOTPField3("3");
		otppage.enterOTPField4("4");
		otppage.submitButton();
		
	}
		
	
	
	@SuppressWarnings("deprecation")
	public void pairBlewithoutRouter() throws FileNotFoundException, IOException, InterruptedException {
		adddevicepage= new AddDevicePage(driver);
		homepage = new HomePage(driver);
		devicemenupage= new DeviceMenuPage(driver);
		szephyrinfoPage= new Szephyr_info_Page(driver);
		///CONNECTIVITY_MOD_3_TC_1///   STA_connectivity establishment
		homepage.disableBLE();
		adddevicepage.clickAddDeviceButton();
		adddevicepage.checkBoxPairing();
		adddevicepage.nextButtonPairing();
		adddevicepage.startPairingButton();
		adddevicepage.locationPopUpPermission();
		adddevicepage.nearByPermission();
		//driver.navigate().back();
		adddevicepage.enterWiFiPassword("12345678908");
		adddevicepage.clickEnterButton();
		//adddevicepage.clickOkButtonBLEpopUP();
		adddevicepage.clickNextButtonsZephyrInfo();
		adddevicepage.clickSubmitButtonDeviceSetting();
		homepage.clickONOFFButton();
		homepage.VerifyONdesc();
		
		/*for(int i=0;i<2;i++) {
			Thread.sleep(1000);
			}*/
		
		//CONNECTIVITY_MOD_3_TC_2///     STA_Kill and Open
		homepage.clickONOFFButton();
		homepage.clickONOFFButton();
		homepage.killandopen();
		adddevicepage.clickOkButtonBLEpopUP();
		Thread.sleep(3000);
		homepage.clickONOFFButton();
		
	}
	}