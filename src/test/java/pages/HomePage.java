package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.appmanagement.ApplicationState;
import wrappers.GenericWrappers;

public class HomePage extends GenericWrappers{
	private AndroidDriver driver;

	@FindBy(xpath="//*[@resource-id='home_main_on_off_swch']")
			private WebElement deviceONOFFButton;
	@FindBy(xpath = "//android.widget.TextView[@text=\"sanity07_1\"]")
	private WebElement devicename;
	
//	@FindBy(xpath = "//*[@resource-id='Options_Icon']")
//	private WebElement menuBarButton;
//	@FindBy(xpath = "//android.widget.TextView[@content-desc=\"com.szephyr:id/undefined\" and @text=\"\"]")
//	private WebElement menuBarButtonafterpairing;
//	@FindBy(xpath = "//android.widget.TextView[@content-desc=\"com.szephyr:id/undefined\"]")
//	private WebElement menuBarButtonafterpairing_withoutconnectivity;
	@FindBy(xpath = "//*[@resource-id='menu_bar']")
	private WebElement menuBarButton;
	
	@FindBy(xpath = "//*[@resource-id='menu_bar']")
	private WebElement menuBarButtonafterpairing;
	@FindBy(xpath = "//*[@resource-id='menu_bar']")
	private WebElement menuBarButtonafterpairing_withoutconnectivity;
	
	@FindBy(xpath = "//*[@resource-id='menu_icon_accounts']")
	private WebElement Accountinfobutton;
	
	
	@FindBy(xpath = "//*[@resource-id='menu_icon_sharelog']")
	private WebElement sharelog ;
	
	@FindBy(xpath = "//*[@resource-id='Home_StandByIndication']")
	private WebElement Acturnondesc;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Please ensure sZephyr is switched ON prior to operating your AC remote\"]")
	private WebElement ActurnOFFdesc;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Searching for sZephyr to establish connection\"]")
	private WebElement Acofflinedesc;
	
	@FindBy(xpath = "//*[@resource-id='Home_StandByIndication']")
	private WebElement Acturnonwithloaddesc;
	
	@FindBy(xpath = "//android.widget.TextView[contains(@text, 'V')]")
	private WebElement voltValue;
	@FindBy(xpath = "//android.widget.TextView[contains(@text, 'W')]")
	private WebElement wattValue;
	@FindBy(xpath = "//android.widget.TextView[contains(@text, 'A')]")
	private WebElement currentValue;
	
	@FindBy(xpath = "//*[@resource-id='PairedGeyser_Img_svg_ble_0_blue']")
	private WebElement bleSymbol;
	
	@FindBy(xpath = "//*[@resource-id='Device_on_off_btn_temp_degree']")
	private WebElement tempDegree;
	
	private WebElement devicenameDeviceSettingsPage(String username) {
		return driver.findElement(By.xpath("//android.widget.TextView[@text='"+username+"']"));
		
	}
	
	public String userName = loadProp("USERNAME");
	
	public HomePage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickONOFFButton() {
		expWaitforPairing(deviceONOFFButton);
		clickbyXpath(deviceONOFFButton, " Device ON OFF Button ");
	}
	
	public void clickMenuBarButton() throws InterruptedException {
		if (isiconDisplayed(menuBarButtonafterpairing, "menu bar After Pairing displayed")) {
			clickbyXpath(menuBarButtonafterpairing, " Menu Bar ");
			}
		else if (isiconDisplayed(menuBarButton, "menu bar element displayed")) {
			clickbyXpath(menuBarButton, " Menu Bar ");
			}else if (isiconDisplayed(menuBarButtonafterpairing_withoutconnectivity, "without connectivity menu bar icon")) {
				clickbyXpath(menuBarButtonafterpairing_withoutconnectivity, " Menu Bar ");
				
			}
	
	}
	
	public void clickAccountinfobutton() {
		clickbyXpath(Accountinfobutton, " Account info");
	}
	

	 public void clicksharcelog() {
		expWaitforPairing(sharelog);
		clickbyXpath(sharelog, " sharelog button ");
	 }
	 
	 public void VerifyONdesc()
	 {
	  verifyTextContainsByXpath(Acturnondesc, "Your AC unit is either in standby or powered OFF at the moment","Device on description ");
	 }
	 public void VerifyOFFdesc()
	 {
		 verifyTextContainsByXpath(ActurnOFFdesc, "Please ensure sZephyr is switched ON prior to operating your AC remote","Device off description");
	 }
	   public void killandopen() 
	   {
		   killAndReopenApp(devicenameDeviceSettingsPage(loadProp("USERNAMEINAPP")), loadProp("USERNAME"));
	   }
	
	   public void disableBLE() throws Exception 
	   {
		   turnOffBT();
	   }
	   public void enableBLE() 
	   {
		   turnOnBT();
	   }
	   public void enableWIFI() 
	   {
		   enableWiFi();
	   }
	   public void disableWIFI() 
	   {
		   disableWiFi();
	   }
	   
	   public void WifiSwitch(String Wifiname,String Wifipassword) throws Exception 
	   {
		   
		   connectToWiFi(Wifiname, Wifipassword);
			Runtime.getRuntime().exec("adb shell am force-stop com.android.settings");
		   if (driver.queryAppState(packages) != ApplicationState.RUNNING_IN_FOREGROUND) {
				driver.activateApp(packages); 
				// Bring it back
//				Thread.sleep(3000);
			}
	   }

	   
	   public void getCurrentvalue() throws InterruptedException {
		   
		   verifyTextContainsByXpath(currentValue, "A","Home page current  value" );
	}
	   public void getVoltvalue() throws InterruptedException {
		   verifyTextContainsByXpath(voltValue, "V","Home page Volt value" );
		   
		   
	   }
	   public void getPowervalue() throws InterruptedException {
		   verifyTextContainsByXpath(wattValue, "W","Home page WATT value" );
		   
	   }
	   public void getbleSymbol() throws InterruptedException {
		   String attribute = bleSymbol.getText();
		   System.out.println(attribute);
	   }
	   
	   public void clickMenuBarButtonafterpairing() throws Exception {
			
			if (isiconDisplayed(menuBarButtonafterpairing, "menu bar after pairing element displayed")) {
				Thread.sleep(5000);
				clickbyXpath(menuBarButtonafterpairing, " Menu Bar ");
				}else if (isiconDisplayed(menuBarButtonafterpairing_withoutconnectivity, "without connectivity menu bar icon")) {
					Thread.sleep(5000);
					clickbyXpath(menuBarButtonafterpairing_withoutconnectivity, " Menu Bar ");
					
				}
		}
	   
	   public void checkBLEConnectivity() {
		   try {
			  expWait(bleSymbol);
			  if(bleSymbol.isDisplayed()) {
				   utils.Reporter.reportStep("BLE Connectivity is etsablished Successfully.", "PASS");
			   }
		   } catch (Exception e) {
			   utils.Reporter.reportStep("BLE Connectivity is not etsablished Successfully.", "FAIL");
		}
	   }
	   
	   public void checkTempSensorWorking() {
		   try {
			  expWait(tempDegree);
			  if(tempDegree.isDisplayed()) {
				   utils.Reporter.reportStep("Temperature Sensor working fine and shows current temp: "+tempDegree.getText(), "PASS");
			   }
		   } catch (Exception e) {
			   utils.Reporter.reportStep("Temperature Sensor not working. Check Manually once ", "FAIL");
		}
	   }
//	   String description[]={"Searching for sZephyr to establish connection","Please ensure sZephyr is switched ON prior to operating your AC remote","Your AC unit is either in standby or powered OFF at the moment","sZephyr and AC turned ON"};
	   
//	   public void checkforDeviceOffstateDescription() {
//		   
//		   String Offstatedescription="Please ensure sZephyr is switched ON prior to operating your AC remote";
//		   String text = ActurnOFFdesc.getText();
//	
//	if (text.contains(Offstatedescription)) {
//		System.out.println("Device is still present ");
//		
//	}
//	else {
//		System.out.println("Device not found");
//	
//}
//	}
//	   public void checkforDeviceOnstateDescriptionwithoutload() {
//		   
//		   String Offstatedescription="Your AC unit is either in standby or powered OFF at the moment";
//		   String text = Acturnondesc.getText();
//		   
//		   if (text.contains(Offstatedescription)) {
//			   System.out.println("Device is still present ");
//			   
//		   }
//		   else {
//			   System.out.println("Device not found");
//			   
//		   }
//	   }
//	   public void checkforDeviceOnstateDescriptionwithload() {
//		   
//		   String Offstatedescription="sZephyr and AC turned ON";
//		   String text = ActurnOFFdesc.getText();
//		   
//		   if (text.contains(Offstatedescription)) {
//			   System.out.println("Device is still present ");
//			   
//		   }
//		   else {
//			   System.out.println("Device not found");
//			   
//		   }
//	   }
//	   public void checkforDeviceofflineDecription() {
//		   
//		   String Offstatedescription="Searching for sZephyr to establish connection";
//		   String text = ActurnOFFdesc.getText();
//		   
//		   if (text.contains(Offstatedescription)) {
//			   System.out.println("Device is still present ");
//			   
//		   }
//		   else {
//			   System.out.println("Device not found");
//			   
//		   }
//	   }
}
