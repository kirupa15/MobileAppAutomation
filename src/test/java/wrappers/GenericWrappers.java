package wrappers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import utils.Reporter;
public class GenericWrappers {

	public static AndroidDriver driver;
	public static WebDriver webDriver;
	public static WebDriverWait wait;
	static ExtentTest test;
	static ExtentReports report;
	public String sUrl,primaryWindowHandle,sHubUrl,sHubPort;
	
	public Properties loadProp() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./config.properties")));
			sHubUrl = prop.getProperty("HUB");
			sHubPort = prop.getProperty("PORT");
			sUrl = prop.getProperty("URL");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	public static boolean initAndriodDriver() throws FileNotFoundException, IOException {
		
		boolean bReturn = false;
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./config.properties")));
			DesiredCapabilities caps = new DesiredCapabilities();
			//caps.setCapability("app", "C:/Users/Invcuser_106/Desktop/apk/Android_SZephyr_12431_stg.apk");	
			caps.setCapability("platformName", prop.getProperty("PLATFORM_NAME"));
			caps.setCapability("appium:platformVersion", prop.getProperty("PLATFORM_VERSION"));
			caps.setCapability("appium:udid", prop.getProperty("UDID"));
			caps.setCapability("appium:deviceName", prop.getProperty("DEVICE_NAME"));
			caps.setCapability("appium:appPackage", prop.getProperty("APP_PACKAGE"));
			caps.setCapability("appium:appActivity", prop.getProperty("APP_ACTIVITY"));
			caps.setCapability("appium:automationName", "UiAutomator2");
			caps.setCapability("newCommandTimeout", 999999);

			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), caps);
			bReturn = true;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("URL is malformed: " + e.getMessage());
			e.printStackTrace();
		}
		return bReturn;
	}

	public boolean invokeApp(String browser,String url) {
		boolean bReturn = false;
		try {

			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setBrowserName(browser);
			dc.setPlatform(Platform.WINDOWS);
			if(browser.equalsIgnoreCase("chrome")){
				WebDriverManager.chromedriver().setup();
				webDriver = new ChromeDriver();
				
			} else if(browser.equalsIgnoreCase("Edge")){
				WebDriverManager.edgedriver();
				webDriver = new EdgeDriver();
				
			} else if(browser.equalsIgnoreCase("Firefox")) {
				WebDriverManager.firefoxdriver();
				webDriver = new FirefoxDriver();
			}

			webDriver.manage().window().maximize();
			webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			webDriver.get(url);

			primaryWindowHandle = driver.getWindowHandle();
			
			Reporter.reportStep("The URL : "+ url + " launched successfully in"+ browser + " browser " , "PASS");
			bReturn = true;

		} catch (Exception e) {
			e.printStackTrace();
			Reporter.reportStep("The browser:" + browser + " could not be launched", "FAIL");
		}
		return bReturn;
	}

	
	public static boolean launchApplication(String url) {
		boolean bReturn = false;
		try {
			driver.get(url);
			Reporter.reportStep("The browser:" + url + " launched successfully", "PASS");
			bReturn = true;
			}
			catch (Exception e) {
				e.printStackTrace();
				Reporter.reportStep("The browser:" + url + " could not be launched", "FAIL");

		}
		return bReturn;
	}
	

	
	public static boolean clickbyXpath(WebElement xpath, String button) {
		boolean bReturn = false;
		try{
			expWait(xpath);
			xpath.click();
			Reporter.reportStep(button+" is clicked Successfully.", "PASS");
			bReturn = true;

	} catch (Exception e) {
			Reporter.reportStep("The Field "+button+" could not be clicked.", "FAIL");
	}
	return bReturn;

	}
	
	public static boolean clickbyXpathwithoutReport(WebElement xpath, String button) {
		boolean bReturn = false;
		try{
			expWait(xpath);
			xpath.click();
			Reporter.reportStep(button+" is clicked Successfully.", "PASS");
			bReturn = true;

	} catch (Exception e) {
			//Reporter.reportStep("The Field "+button+" could not be clicked.", "FAIL");
	}
	return bReturn;

	}


	public boolean verifyTitle(String title){
		boolean bReturn = false;
		try{
			if (driver.getTitle().equalsIgnoreCase(title)){
				Reporter.reportStep("The title of the page matches with the value :"+title, "PASS");
				bReturn = true;
			} else {
				Reporter.reportStep("The title of the page:"+driver.getTitle()+" did not match with the value :"+title, "SUCCESS");
			}

		}catch (Exception e) {
			Reporter.reportStep("The title did not match", "FAIL");
		}

		return bReturn;
	}

	public boolean selectById(WebElement id, int value, String fieldName) {
		boolean bReturn = false;
		try{
			expWait(id);
			new Select(id).selectByIndex(value);
			Reporter.reportStep("The element with id: "+fieldName+" is selected with value :"+value, "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The value: "+value+" could not be selected.", "FAIL");
		}
		return bReturn;
	}


	public boolean entervaluebyXpath(WebElement xpath, String fieldname, String value) {
		boolean bReturn = false;
		try {
			expWait(xpath);
			xpath.sendKeys(value);
			Reporter.reportStep(fieldname+" field is entered with value : " +value, "PASS");

		} catch (Exception e) {
			Reporter.reportStep("The value: "+value+" could not be entered.", "FAIL");
		}
		return bReturn;
	}

	
	public boolean entertoiFrame(WebElement xpath, String fName) {
			boolean bReturn = false;
			try {
				expWait(xpath);
				WebElement frame=xpath;
			    driver.switchTo().frame(frame);
				Reporter.reportStep("iframe "+fName+" entered successfully", "PASS");
				bReturn = true;

			} catch (Exception e) {
				Reporter.reportStep("iframe could not be entered :", "FAIL");
			}
			return bReturn;
	}

	
	public boolean selectByVisibleText(WebElement xpath, String fieldName) {
		boolean bReturn = false;
		try {
			expWait(xpath);
			List<WebElement> size=new Select(xpath).getOptions();
			for ( WebElement s: size) {
			if(s.isEnabled())
			{
	        	new Select(xpath).selectByVisibleText(s.getText());
	        	break;
	        }
			Reporter.reportStep("The dropdown: "+ fieldName +" is selected", "PASS");
			bReturn = true;
			}
		} catch (Exception e) {
				Reporter.reportStep("The dropdown: "+ fieldName +" is not selected", "FAIL");
		}
		return bReturn;
	}
	
	
	public boolean verifyTextContainsByXpath(WebElement xpath, String text, String field) {
		boolean bReturn = false;
		try {
			expWait(xpath);
			String sText = xpath.getText();
			System.out.println(sText);
			if (sText.trim().contains(text)) {
				Reporter.reportStep(field +"contains "+ text , "PASS");
				bReturn = true;
				}
			else {
				Reporter.reportStep(field+" did not contain :" + text, "FAIL");				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bReturn;
	}

	
	public void quitBrowser() {
		try {
			if(driver!= null) {
			driver.quit();
			}
		} catch (Exception e) {
			Reporter.reportStep("The browser could not be closed.", "FAIL");
		}

	}

	
	public static void expWait(WebElement xpath) {
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(xpath));
		}
		catch(Exception e) {
			System.out.println(e); 
		}
	
	}
	
	public static void expWaitforPairing(WebElement xpath) {
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOf(xpath));
		}
		catch(Exception e) {
			System.out.println(e); 
		}
	
	}
	
	public static void runPythonScript() {
        try {
            // Update the path to the Python interpreter and the Python script
            ProcessBuilder processBuilder = new ProcessBuilder("C:/Python312/python.exe", "C:/Users/Invcuser_106/Desktop/Python code/serialport.py");
            // Start the process
            Process process = processBuilder.start();

            // Capture the script output (stdout)
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            System.out.println("Output of the Python script:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Wait for the process to complete
            int exitCode = process.waitFor();
            System.out.println("Python script exited with code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        
        
    }
	public void turnOffBluetooth() {

		try {
			Runtime.getRuntime().exec("adb shell svc bluetooth disable");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	 public void killAndReopenApp() {
		    try {
		        if (driver != null) {
		            // Kill the app (terminate it)
		            driver.terminateApp("com.iinvsys.szephyr");
		            Reporter.reportStep("The app was killed successfully.", "PASS");

		            // Wait for a few seconds before reopening the app
		            Thread.sleep(3000);

		            // Reopen the app, it should maintain its previous state (same page)
		            driver.activateApp("com.iinvsys.szephyr");
		            Reporter.reportStep("The app was reopened successfully.", "PASS");
		        }
		    } catch (Exception e) {
		        Reporter.reportStep("The app could not be killed and reopened.", "FAIL");
		    }
		}
		public boolean isElementDisplayed(WebElement element) {

			try {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return element.isDisplayed();
			} catch (NoSuchElementException e) {
				return false;
			}
		}
		public boolean turnOnBT() {
			boolean bReturn = false;

			try {
				Runtime.getRuntime().exec("adb shell svc bluetooth enable");
				Reporter.reportStep("Bluetooth turned on successfully", "PASS");
				bReturn = true;
			} catch (IOException e) {
				e.printStackTrace();
				Reporter.reportStep("iframe could not be entered :", "FAIL");
			}
			return bReturn;

			
		}

		public boolean turnOffBT() throws Exception {

			boolean bReturn = false;
			try {
				Runtime.getRuntime().exec("adb shell svc bluetooth disable");
				Reporter.reportStep("Bluetooth turned OFF successfully", "PASS");
				bReturn = true;
			} catch (IOException e) {
				e.printStackTrace();
				Reporter.reportStep("iframe could not be entered :", "FAIL");
			}

			return bReturn;
		}
}