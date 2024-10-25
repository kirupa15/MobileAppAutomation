package testcases_signIn_up_accountsinfo_module;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import pages.AccountsInfoPage;
import pages.AddDevicePage;
import pages.DeviceMenuPage;
import pages.HomePage;
import pages.LandingPage;
import pages.SignInPage;
import utils.logReadandWrite;
import pages.OtpPage;
import wrappers.MobileAppWrappers;

import java.util.List;

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
		//check login username and Accounts info username are same or not 
		//check for language selection 
		//pair with device try to del account and check for popup and try to remove device and try to del acnt and check add device page .
		
		testDescription = "change language and check changed language ,before removing device try to delete account then try to remove device and delete account";
	}


	@Test
	public void removerepair() throws Exception {
			initAndriodDriver();
			pairBlewithoutRouter();
	}


	public void pairBlewithoutRouter() throws Exception {
		adddevicepage= new AddDevicePage(driver);
		homepage = new HomePage(driver);
		accountinfopage= new AccountsInfoPage(driver);
		devicesettingpage= new DeviceMenuPage(driver);

		logReadandWrite readwrite=new logReadandWrite("COM4");
		readwrite.openPort();
		readwrite.read();
		Thread.sleep(2000);
		readwrite.write("factory_reset\r");
		
		adddevicepage.pair(1);
		adddevicepage.clickNextButtonsZephyrInfo();
		adddevicepage.clickSubmitButtonDeviceSetting();

		
		

		for(int i=0;i<2;i++) {
			homepage.clickONOFFButton();
			Thread.sleep(1000);
		}

		accountinfopage.checkAccountsinfousername_email_Language();

		readwrite.closePort();
	}


}	

