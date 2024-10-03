package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import wrappers.GenericWrappers;

public class AccountsInfoPage extends GenericWrappers{

	private AndroidDriver driver;

	// Locate all elements on the page

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"com.szephyr:id/menu_icon_accounts, com.szephyr:id/menu_text_accounts\"]")
	private WebElement AccountsinfoButton;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\", English\"]/android.widget.TextView[2]")
	private WebElement SelectLanguageButton;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Tamil\"]")
	private WebElement SelectLanguageTamilButtom;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\", Tamil\"]/android.widget.TextView[2]")
	private WebElement SelectLanguageDropDownButton;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"English\"]")
	private WebElement SelectLanguageEnglishButton;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"com.szephyr:id/Accounts_FirmwareAutoUpdate\"]/android.view.ViewGroup/android.view.ViewGroup")
	private WebElement FirmwareUpdateSettingButton;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"com.szephyr:id/Accounts_DeleteAccount_SubTitle, com.szephyr:id/Accounts_DeleteAccount_SubTitle1\"]")
	private WebElement DeleteAccountButton;
	
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button")
	private WebElement AccountDeleteButton;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"com.szephyr:id/Device_BackIcon\"]")
	private WebElement AccountInfoBackButton;

	@FindBy(xpath = "//android.widget.TextView[@content-desc=\"com.szephyr:id/menu_text_removeDevice\"] ")
	private WebElement Clickremovedevicebutton;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"YES\"]")
	private WebElement RemoveDeviceYesButton;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"com.szephyr:id/Options_Icon\"]")
	private WebElement Clickmenubaricon;
	
	@FindBy(xpath = "//android.widget.TextView[@content-desc=\"com.szephyr:id/accountsText\"]")
	private WebElement Clickaccountinfo;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"com.szephyr:id/Accounts_DeleteAccount_SubTitle, com.szephyr:id/Accounts_DeleteAccount_SubTitle1\"]")
	private WebElement Clickaccountdelete;
	
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]")
	private WebElement Clickaccountdeleteyes;
	
	



	
	
	// Constructor to initialize the driver and instantiate elements using
	
	public AccountsInfoPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Methods to be used as part of AccountInfo.
	
	public void clickAccountsInfoButton() {
		clickbyXpath(AccountsinfoButton, " Accounts Info Button  ");
	}
	
	public void clickSelectLanguageButton() {
		clickbyXpath(SelectLanguageButton, " Select Language Drop Box Button  ");
	}
	
	public void clickSelectLanguageTamilButton() {
		clickbyXpath(SelectLanguageTamilButtom, " Selct Tamil Button ");
	}
	
	public void clickSelectLanguageDropDownButton() {
		clickbyXpath(SelectLanguageDropDownButton, " Select Language Drop Box Button  ");
	}
	
	public void clickSelectLanguageEnglishButton() {
		clickbyXpath(SelectLanguageEnglishButton, " Selct English Button ");

	}
	
	public void clickFirmwareUpdateSettingButton() {	
		clickbyXpath(FirmwareUpdateSettingButton, " Firmware auto update click Button ");
	}
	
	@SuppressWarnings("deprecation")
	public void clickDeleteAccountButton() {
		driver.findElement(MobileBy.AndroidUIAutomator(
			    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Delete Account\"));"))
			    .click();
		clickbyXpath(DeleteAccountButton, " Delete Account click Button ");
	}
	
	public void clickAccountDeleteButton() {	 
		clickbyXpath(AccountDeleteButton, " Account Delete Ok click Button ");
	}
	
	public void clickAccountInfoBackButton() {	 
		clickbyXpath(AccountInfoBackButton, " Account Info Back click Button ");
	}
	
	public void Clickremovedevicebutton() {	 
		clickbyXpath(Clickremovedevicebutton, " Click Remove device Button ");
	}
	
	public void clickRemoveDeviceYESButton() {	 
		clickbyXpath(RemoveDeviceYesButton, " Remove Device Yes Button ");
	}

	public void Clickmenubaricon() {	 
		clickbyXpath(Clickmenubaricon, " Click menubaricon ");
	}
	
	public void Clickaccountinfo() {	 
		clickbyXpath(Clickaccountinfo, " Click accountinfo ");
	}
	
	public void Clickaccountdelete() {	 
		clickbyXpath(Clickaccountdelete, " Click account delete ");
	}
	
	public void Clickaccountdeleteyes() {	 
		clickbyXpath(Clickaccountdeleteyes, " Click account delete yes ");
	}
}

	


