package testcases_signIn_up_accountsinfo_module;

import org.openqa.selenium.TimeoutException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AccountsInfoPage;
import pages.AddDevicePage;
import pages.DeviceMenuPage;
import pages.HomePage;
import pages.LandingPage;
import pages.SignInPage;
import pages.OtpPage;
import wrappers.MobileAppWrappers;

import org.openqa.selenium.JavascriptExecutor;

public class TC01_02_03_04_Accounts_Info extends MobileAppWrappers {

	LandingPage landingpage;
	SignInPage loginpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	AccountsInfoPage accountinfopage;
	DeviceMenuPage devicesettingpage;


	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC_01_Account_Info";
		testDescription = "Sign In and Start Pairing BLE with Router mode";
	}


	@Test
	public void removerepair() throws Exception {
			pairBlewithoutRouter();
	}


	public void pairBlewithoutRouter() throws Exception {
		adddevicepage= new AddDevicePage(driver);
		homepage = new HomePage(driver);
		accountinfopage= new AccountsInfoPage(driver);
		devicesettingpage= new DeviceMenuPage(driver);

		adddevicepage.pair(1);
		adddevicepage.clickNextButtonsZephyrInfo();
		adddevicepage.clickSubmitButtonDeviceSetting();

		for(int i=0;i<2;i++) {
			homepage.clickONOFFButton();
			Thread.sleep(1000);
		}

		homepage.clickMenuBarButton();
		accountinfopage.clickAccountsInfoButton();
		accountinfopage.clickSelectLanguageButton();
		accountinfopage.clickSelectLanguageTamilButton();
		Thread.sleep(2000);
		accountinfopage.clickAccountInfoBackButton();
		homepage.clickMenuBarButton();
		devicesettingpage.clickDeviceSettingsButton();
		devicesettingpage.checkcontentlowvoltage();
		devicesettingpage.clickDevicesettingsbackButton();
		homepage.clickMenuBarButton();
		accountinfopage.clickAccountsInfoButton();
		//		accountinfopage.clickSelectLanguageButton();
		accountinfopage.clickSelectLanguageDropDownButton();
		accountinfopage.clickSelectLanguageEnglishButton();
		//		Thread.sleep(1000);
		//			homepage.clickMenuBarButton();
		//			accountinfopage.clickAccountsInfoButton();
		accountinfopage.clickDeleteAccountButton();
		accountinfopage.clickAccountDeleteButton();
		accountinfopage.clickAccountInfoBackButton();
		homepage.clickMenuBarButton();
		accountinfopage.Clickremovedevicebutton();
		accountinfopage.clickRemoveDeviceYESButton();
		accountinfopage.Clickmenubaricon();
		accountinfopage.Clickaccountinfo();
		accountinfopage.Clickaccountdelete();
		accountinfopage.Clickaccountdeleteyes();

	}



}	

