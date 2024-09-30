package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import wrappers.GenericWrappers;

public class LandingPage extends GenericWrappers{
	    
	    private AndroidDriver<AndroidElement> driver;
	    
	 // Locate all elements on the page
	    
	    @FindBy(xpath = "//android.widget.TextView[@text='Sign In']")
	    private WebElement signInButton;
	    
	    @FindBy(xpath = "//android.widget.TextView[@text='Sign Up']")
	    private WebElement signUpButton;
	    
	    @FindBy(id = "loginButton")
	    private WebElement loginButton;
	    
	    //div[text()='Home']//following-sibling::div[1]
	    
	    // Constructor
	    
	    public LandingPage(AndroidDriver<AndroidElement> driver) {
	        this.driver=driver;
	        PageFactory.initElements(driver, this);
	    }
	    
	    // Methods to interact with elements
	    public void clickSignInButton() {
	    	clickbyXpath(signInButton, " Sign In Button " );
	    }
	    
	    public void clickSignUpButton() {
	    	clickbyXpath(signUpButton, " Sign Up Button " );
	    }
	    
}
