package schedular;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;
import pages.AddDevicePage;
import pages.DeviceMenuPage;
import pages.HomePage;
import pages.LandingPage;
import pages.OtpPage;
import pages.Schedularpage;
import pages.SignInPage;
import wrappers.MobileAppWrappers;
import java.util.HashMap;
import java.util.Map;

public class TC02_Schedular extends MobileAppWrappers {

	LandingPage landingpage;
	SignInPage loginpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	DeviceMenuPage devicemenupage;
	Schedularpage schedulepage;

	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC01 - Pairing BLE With Router";
		testDescription = "Sign In and Start Pairing BLE with Router mode";
	}

	@Test
	public void schedule() throws Exception {
		loginpage = new SignInPage(driver);
		landingpage = new LandingPage(driver);
		otppage = new OtpPage(driver);
		adddevicepage = new AddDevicePage(driver);
		devicemenupage = new DeviceMenuPage(driver);
		schedulepage = new Schedularpage(driver);

		schedulepage.createschedule(5, 1, 1);// (2,1,1)select mode,1 time only the loop run,one min gap between each schedules

		schedulepage.disableschedule(1);// to wait for 1 min to check it turn on or in off state

	}

	@FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
	private WebElement connectbuttonWifipage;
//	@Test
	public void openwifipage() throws Exception {

		String text= "ANTA";//TP-Link_6D38(With_Internet)
		Runtime.getRuntime().exec("adb shell am start -n com.android.settings/.Settings\\$WifiSettingsActivity");
		Thread.sleep(5000);
		AndroidElement element = driver.findElement(
			    MobileBy.AndroidUIAutomator(
			        "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"" + text + "\"))"
			    )
			);
		element.click();
		String text2 = "connect";
		AndroidElement elements = (AndroidElement) driver.findElement(
	            MobileBy.AndroidUIAutomator(
	            		"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"" + text2 + "\"))"));
//		   WebDriverWait wait = new WebDriverWait(driver, 20);  // 20 seconds timeout, adjust as necessary
//	        wait.until(ExpectedConditions.visibilityOf(connectbuttonWifipage));
//	        wait.until(ExpectedConditions.elementToBeClickable(connectbuttonWifipage));
	
		adddevicepage.hidekeyboard();
	        elements.click();
		
	}

	
}
