package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import wrappers.GenericWrappers;

public class Internal_longrun_task extends GenericWrappers{

	private AndroidDriver driver;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"com.szephyr:id/Home_VOLT_Box\"]")
	private WebElement voltBoxValue;
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"com.szephyr:id/Home_VOLT_Box\"]")
	private WebElement voltValue;
	@FindBy(xpath = "")
	private WebElement  onOffButton;

	public Internal_longrun_task(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait=new WebDriverWait(driver, 30);
	}


	public boolean checkVoltValue() {

		//		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"com.szephyr:id/Home_VOLT_Box\"]\""));
		WebElement element = voltBoxValue.findElement(By.className("android.widget.TextView"));
		

		boolean bReturn = false;
		try {
			int value =1000;
//			int value =2222;
			String val="100.0V";
			String valueOf = String.valueOf(value);

			while (value>0) {
				expWait(element);
				String text = element.getText();
				int elevalue = extractintvalue(text);
				
				
				
				
				if (elevalue<=value) {
					verifyTextContainsByXpath(element,val, "lowvolt");
					System.out.println("nope");
					bReturn = true;
					break;
				}
				System.out.println("volt value displayed :  "+text);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			System.out.println("Low volt not detected");
		}
		return bReturn;
	} 

}
