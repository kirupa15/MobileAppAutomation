package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import wrappers.GenericWrappers;

public class HomePage extends GenericWrappers{
	private AndroidDriver driver;

	@FindBy(xpath="//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[7]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.CircleView[1]")
			private WebElement deviceONOFFButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"\"]")
	private WebElement menuBarButton;
	
	public HomePage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickONOFFButton() {
		clickbyXpath(deviceONOFFButton, " Device ON OFF Button ");
	}
	
	public void clickMenuBarButton() {
		clickbyXpath(menuBarButton, " Menu Bar ");
	}
	
	
	

}
