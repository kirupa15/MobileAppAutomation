package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import wrappers.GenericWrappers;

public class HomePage extends GenericWrappers{
	private AndroidDriver driver;

	@FindBy(xpath="//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[7]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.CircleView[1]")
			private WebElement deviceONOFFButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"\"]")
	private WebElement menuBarButton;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"com.szephyr:id/menu_icon_accounts, com.szephyr:id/menu_text_accounts\"]")
	private WebElement Accountinfobutton;
	
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"com.szephyr:id/menu_icon_sharelog, com.szephyr:id/menu_text_sharelog\"]")
	private WebElement sharelog ;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"sZephyr and AC turned ON\"]")
	private WebElement Acturnondesc;
	
	public HomePage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickONOFFButton() {
		expWaitforPairing(deviceONOFFButton);
		clickbyXpath(deviceONOFFButton, " Device ON OFF Button ");
	}
	
	public void clickMenuBarButton() {
		clickbyXpath(menuBarButton, " Menu Bar ");
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
	  verifyTextContainsByXpath(Acturnondesc, "sZephyr and AC turned ON","Home Page");
	 }
	   public void killandopen() 
	   {
		   killAndReopenApp();
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
	   
	   public void WifiSwitch() 
	   {
		   
		   connectToWiFi("realme", "12345222");
	   }

}
