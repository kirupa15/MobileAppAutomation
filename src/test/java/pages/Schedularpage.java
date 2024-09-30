package pages;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.SimpleDateFormat;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.appmanagement.ApplicationState;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import wrappers.GenericWrappers;

public class Schedularpage extends GenericWrappers {
	public static AndroidDriver<AndroidElement> driver;

//	public AndroidElement element;

	public Schedularpage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.js = (JavascriptExecutor) driver;
	}

	
	JavascriptExecutor js = (JavascriptExecutor) driver;

	LandingPage landingpage;
	SignInPage loginpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	DeviceMenuPage devicemenupage;

	



//			adddevicepage.startPairingButton();
//			if (isElementDisplayed(alertpopup)) {
//				BleOKpopup.click();
//				Thread.sleep(2000);
//				driver.navigate().back();
//			} else {
//				System.out.println("Ble is in ON state");
//			}
//			Thread.sleep(3000);
//			adddevicepage.locationPopUpPermission();
//			adddevicepage.nearByPermission();

//			switch (mode) {
//			case 1:
//				turnOnBT();
//				
//				Thread.sleep(3000);
//				if (isElementDisplayed(alertpopup)) {
//					BleOKpopup.click();
//					Thread.sleep(2000);
//					driver.navigate().back();
//					Thread.sleep(2000);
//				} else {
//					System.out.println("No alert pop ups displayed");
//				}
//
//				adddevicepage.clickWifiCancelButton();
//
//				break;
//			case 2:
//				turnOnBT();
//				Thread.sleep(3000);
//				if (isElementDisplayed(alertpopup)) {
//					BleOKpopup.click();
//					Thread.sleep(2000);
//					driver.navigate().back();
//				} else {
//					System.out.println("Alert pop-up not displayed");
//				}
//				adddevicepage.enterWiFiPassword("12345678908");
//				adddevicepage.clickEnterButton();
//				break;
//
//			case 3:
//
//				turnOffBT();
//				
//				if (isElementDisplayed(alertpopup)) {
//					BleOKpopup.click();
//					Thread.sleep(2000);
//					driver.navigate().back();
//				} else {
//					System.out.println("Alert pop-up not displayed");
//				}
//				Thread.sleep(3000);
//
//				adddevicepage.enterWiFiPassword("12345678908");
//				adddevicepage.clickEnterButton();
//
//				break;
//				
//			case 4:
//				turnOffBT();
//				Thread.sleep(1000*5*1);
//				if (isElementDisplayed(alertpopup)) {
//					BleOKpopup.click();
//					Thread.sleep(2000);
//					driver.navigate().back();
//				} else {
//					System.out.println("Alert pop-up not displayed");
//				}
//				
//
//				Thread.sleep(1000*30*1);
//				
//				adddevicepage.enterWiFiPassword("12345678908");
//				adddevicepage.clickEnterButton();
//				
//				Thread.sleep(1000*81*1);
//				
//				if (isElementDisplayed(devicewifipop_up)) {
//					clickbyXpath(devicewifipop_upOK, "click on Device wifi OK popup");
//					
//					driver.findElement(MobileBy.AndroidUIAutomator(
//					    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text("+serialno+"));")).click(); 
//					
//				}
//				
//				break;
//			default:
//				System.out.println("Pairing not done");
//				break;
//			}

			



	@FindBy(xpath = "//android.widget.TextView[@content-desc=\"com.szephyr:id/Home_Navigation\"]")
	private WebElement Schedulebutton;

	@FindBy(xpath = "//android.widget.TextView[@text=\"testuser007_1\"]")
	private WebElement Username;
	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]")
	private WebElement Scehduletitle;
	@FindBy(xpath = "//android.widget.TextView[@content-desc=\"com.szephyr:id/SCH_ADD_PLUS_ICON\"]")
	private WebElement plusIcon;
	@FindBy(xpath = "//android.widget.TextView[@content-desc=\"com.szephyr:id/Scheduler_YourSchedules\"]")
	private WebElement yourScheduleheader;
	@FindBy(xpath = "//android.widget.TextView[@content-desc=\"com.szephyr:id/Scheduler_OtherUsersSchedules\"]")
	private WebElement otherScheduleheader;
	@FindBy(xpath = "//android.widget.TextView[@content-desc=\"com.szephyr:id/Scheduler_YouDoNotHaveAnySchedules\"]")
	private WebElement schedulePlaceholder;

	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup")
	private WebElement scheduletime0;
	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup")
	private WebElement scheduletime1;
	@FindBy(xpath = "//android.widget.TextView[@text=\"PM\"]")
	private WebElement scheduletime2;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"com.szephyr:id/Edit_Schedule_Save_Button\"]")
	private WebElement savebtn;
	@FindBy(xpath = "//android.widget.TextView[@content-desc=\"com.szephyr:id/Edit_Schedule_Cancel_ButtonText\"]")
	private WebElement cancelbtn;
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"com.szephyr:id/Scheduler_Time, com.szephyr:id/Scheduler_Meridian, com.szephyr:id/Scheduler_Switch, Duration:  1 Minutes\r\n"
			+ "Today\"]/android.view.ViewGroup")
	private WebElement createdschedule;
	@FindBy(xpath = "//android.widget.TextView[@text=\"Delete\"]")
	private WebElement deleteBtn;
	@FindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]")
	private WebElement locationpermissionpopup;
	@FindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")
	private WebElement devicepermission;
	@FindBy(xpath = "//android.widget.TextView[@content-desc=\"com.szephyr:id/Edit_Schedule_HeatingDuration\"]")
	private WebElement durationtext;
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"com.szephyr:id/Scheduler_Switch\"]/android.view.ViewGroup")
	private WebElement disableschedule;
	@FindBy(xpath = "//android.widget.TextView[@text=\"sZephyr and AC turned ON\"]")
	private WebElement Acturnondesc;
	@FindBy(xpath = "//android.widget.TextView[@text=\"Please ensure sZephyr is switched ON prior to operating your AC remote\"]")
	private WebElement acturnoffdesc;
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"com.szephyr:id/Edit_Schedule_Minutes1\"]/android.view.ViewGroup")
	private WebElement minute1;
	@FindBy(xpath = "//android.widget.TextView[@content-desc=\"com.szephyr:id/Edit_Schedule_Duration_Hours_Minutes\"]")
	private WebElement duration;
	
//	@FindBy(xpath = "")
//	private WebElement ;
//	@FindBy(xpath = "")
//	private WebElement ;

	public void createschedule(int mode, int intervals, int gap) throws Exception {

		loginpage = new SignInPage(driver);
		landingpage = new LandingPage(driver);
		homepage = new HomePage(driver);
		adddevicepage = new AddDevicePage(driver);
		otppage = new OtpPage(driver);
		
		adddevicepage.pair(mode);
		clickbyXpath(Schedulebutton, "schedulebutton");

		// Generate schedule times
		LocalTime currentTime = LocalTime.now();
		LocalTime timet = currentTime.plusMinutes(5);
		List<LocalTime> scheduleTimes = generateSchedule(timet, intervals, gap);

		// Loop through each time and create the schedule
		for (LocalTime time : scheduleTimes) {
			// Split time into hour, minute, and AM/PM
			int hour = time.getHour() % 12;
			if (hour == 0)
				hour = 12; // Convert 0 hour to 12 for 12-hour format

			// Store minute as int but format it as two digits when displaying
			int minute = time.getMinute();
			String formattedMinute = String.format("%02d", minute); // Format minute as two digits
			String amPm = time.getHour() >= 12 ? "PM" : "AM";

			System.out.println("Creating schedule for: " + hour + ":" + formattedMinute + " " + amPm);

			// Navigate to the screen where you can create a schedule (replace with actual
			// navigation steps)

			clickbyXpath(plusIcon, "plusbutton");
			// Select the time (replace with actual steps to select the time)
			// selectTime(hour, minute, amPm);
			selectTimeUsingBounds(hour, minute, amPm);
			// Save the schedule (replace with actual save steps)
			clickbyXpath(minute1, "1min");

			String text = duration.getText();
			System.out.println(text);

			int extractintvalue = extractintvalue(text.toString());
			if (extractintvalue == 1) {
				System.out.println("schedule created for 1 min ");

			}
			saveSchedule();

			System.out.println("Schedule created for: " + hour + ":" + minute + " " + amPm);
		}
	}

	private List<LocalTime> generateSchedule(LocalTime startTime, int intervals, int durationMinutes) {
		List<LocalTime> schedule = new ArrayList<>();
		for (int i = 0; i < intervals; i++) {
			schedule.add(startTime.plusMinutes(i * durationMinutes));
		}
		return schedule;
	}

	private void selectTimeUsingBounds(int hour, int minute, String amPm) {
		// Ensure the frame is visible before interacting with it
		By frameLocator = By.xpath(
				"//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[1]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(frameLocator));

		// Scroll to hour and ensure it's centered
		scrollToTextUsingUiScrollable(hour, 0);

		String formattedMinute = String.format("%02d", minute); // Ensure minute is displayed as 01, 02, etc.
		scrollToTextUsingUiScrollable(formattedMinute, 1);

		// Scroll to AM/PM and ensure it's centered
		scrollToTextUsingUiScrollable(amPm, 2);
	}

	// Overloaded method for int
	private void scrollToTextUsingUiScrollable(int value, int instance) {
		String selector = "new UiScrollable(new UiSelector().scrollable(true).instance(" + instance
				+ ")).scrollIntoView(new UiSelector().text(\"" + value + "\"))";
		MobileElement element = (MobileElement) driver.findElementByAndroidUIAutomator(selector);
		wait.until(ExpectedConditions.visibilityOf(element));
//		verifyElementPosition(element, String.valueOf(value), instance);
	}

	// Overloaded method for String
	private void scrollToTextUsingUiScrollable(String value, int instance) {
		String selector = "new UiScrollable(new UiSelector().scrollable(true).instance(" + instance
				+ ")).scrollIntoView(new UiSelector().text(\"" + value + "\"))";
		MobileElement element = (MobileElement) driver.findElementByAndroidUIAutomator(selector);
		wait.until(ExpectedConditions.visibilityOf(element));
//		verifyElementPosition(element, value, instance);
	}

	private void verifyElementPosition(MobileElement element, String value, int instance) {
		By frameLocator = By.xpath(
				"//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.widget.TextView[@text='"
						+ value + "']");
		List<AndroidElement> elements = driver.findElements(frameLocator);

		for (int i = 0; i < elements.size(); i++) {
			if (elements.get(i).getText().equals(value)) {
				if (i == instance) {
					element.click();
					break;
				}
			}
		}
	}

	private void saveSchedule() {

		clickbyXpath(savebtn, "saveschedule");
		String text = yourScheduleheader.getText();
		System.out.println(text);
		if (text.contentEquals("Schedule")) {
			System.out.println("Schedule heading displayed ");
		} else {
			System.out.println("Schedule page not displayed ");
		}

	}

//			public void removedevice() {
//				driver.findElement(By.xpath(BaseClass_Z.schedulepagebackbtn)).click();
//				driver.findElement(By.xpath(BaseClass_Z.menubar)).click();
//				element = driver.findElement(By.xpath(BaseClass_Z.devicesettings));
//
//				wait.until(ExpectedConditions.visibilityOf(element));
//				element.click();
//
//				//	 	       element.findElement(By.xpath(".//android.widget.TextView[@text=='Device settings']")).click();
//				//	 	       element.findElement(By.xpath(BaseClass_Z.devicesettingsafterpairing)).click();
//
//				driver.findElement(By.xpath(BaseClass_Z.resetdevice)).click();
//				driver.findElement(By.xpath(BaseClass_Z.factoryresetyes)).click();
//
//				element = driver.findElement(By.xpath(BaseClass_Z.adddevicebtn));
//				text = element.getText();
//
//				if (text.contentEquals("Add Device")) { 
//					System.out.println("Add device page displayed");
//				}
//				else {
//					System.out.println("Add device page not displayed");
//				}     
//			}

	public void disableschedule(int min) throws Exception, IOException, InterruptedException {

		clickbyXpath(disableschedule, "disable schedule");

		driver.navigate().back();
//				verifyTextContainsByXpath(Acturnondesc, "sZephyr and AC turned ON", "AC truned ON description");

		driver.manage().timeouts().implicitlyWait(min, TimeUnit.MINUTES);
		verifyTextContainsByXpath(acturnoffdesc,
				"Please ensure sZephyr is switched ON prior to operating your AC remote", "AC truned OFF description");

	}

	// checking on/off state of relay after schedule completion.
	public void checkon_off(int min) {
		driver.navigate().back();
		verifyTextContainsByXpath(Acturnondesc, "sZephyr and AC turned ON", "AC truned ON description");

		driver.manage().timeouts().implicitlyWait(min, TimeUnit.MINUTES);
		verifyTextContainsByXpath(Acturnondesc,
				"Please ensure sZephyr is switched ON prior to operating your AC remote", "AC truned OFF description");

	}

}
