package wrappers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import io.appium.java_client.appmanagement.ApplicationState;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import utils.Reporter;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.NoSuchElementException;



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
	
	
	public boolean verifyTextContainsByXpath(WebElement xpath, String text, String field){
		boolean bReturn = false;
		try {
			expWait(xpath);
		    String sText = xpath.getText();
		    if (sText.trim().contains(text)){
			Reporter.reportStep("The text: "+sText+" contains the value :"+text, "PASS");
			bReturn = true;
			System.out.println(sText.replaceAll("[^0-9]", ""));
		}
		} catch (Exception e) {
				Reporter.reportStep("The text: did not contain the value :"+text, "FAIL");
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
	
	public static void expWaitforFirmware(WebElement xpath) {
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(300));
		wait.until(ExpectedConditions.visibilityOf(xpath));
		}
		catch(Exception e) {
			System.out.println(e); 
		}
	
	}
	public static void expWaitstatusbar(WebElement xpath) {
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(300));
		wait.until(ExpectedConditions.visibilityOf(xpath));
		}
		catch(Exception e) {
			System.out.println(e); 
		}
	}
	
				  
		 public void pullLogFileFromDevice() {
		            // Path to the log file on the mobile device
		            String deviceFilePath = "/storage/emulated/0/Download/logfile.txt";
		            
		            // Pull the file from the mobile device
		            byte[] logFile = driver.pullFile(deviceFilePath);
		            
		            // Save the file locally
		            try (FileOutputStream fos = new FileOutputStream(new File("local_logfile.txt"))) {
		                fos.write(logFile);
		                System.out.println("Log file pulled from device and saved locally.");
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }
      
		
	
		  public static void uploadLogToFTP() {
		        FTPClient ftpClient = new FTPClient();
		        String ftpServer = "192.168.10.34";
		        String ftpUser = "qa_usr";
		        String ftpPass = "nw9f2hgo@123"; // Enter your FTP password

		        try {
		            // Connect to FTP server
		            ftpClient.connect(ftpServer);
		            ftpClient.login(ftpUser, ftpPass);

		            // Switch to binary mode for file transfer
		            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

		            // Specify the destination path on the FTP server
		            String ftpFilePath = "/Internal_Project/FULL_VALIDATION_PACKAGES_LOGS/LOGS/2024/szephyr/Android/12674/logfile.txt";

		            // Upload the file
		            FileInputStream inputStream = new FileInputStream("local_logfile.txt");
		            boolean uploaded = ftpClient.storeFile(ftpFilePath, inputStream);
		            inputStream.close();

		            if (uploaded) {
		                System.out.println("Log file uploaded successfully to FTP.");
		            } else {
		                System.out.println("Failed to upload log file.");
		            }

		            // Logout and disconnect from the FTP server
		            ftpClient.logout();
		            ftpClient.disconnect();

		        } catch (IOException e) {
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

		  @SuppressWarnings("deprecation")
		public void turnOffBT() {

				try {
					//Runtime.getRuntime().exec("adb shell svc bluetooth disable");
					Runtime.getRuntime().exec("adb shell svc bluetooth disable");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		  public void turnOnBT() {

				try {
					//Runtime.getRuntime().exec("adb shell svc bluetooth disable");
					Runtime.getRuntime().exec("adb shell svc bluetooth enable");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		  public void enableWiFi() {

				try {
					//Runtime.getRuntime().exec("adb shell svc bluetooth disable");
					Runtime.getRuntime().exec("adb shell svc wifi enable");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		  public void disableWiFi() {

				try {
					//Runtime.getRuntime().exec("adb shell svc bluetooth disable");
					Runtime.getRuntime().exec("adb shell svc wifi disable");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		  
		  public void switchToSpecificWifiUsingCommand() {
		      try {
		          String command = "nmcli dev wifi connect 'realme6' password '12345222'";
		          Process process = Runtime.getRuntime().exec(command);
		          process.waitFor();
		          System.out.println("Switched to Wi-Fi network: YourWiFiSSID");
		      } catch (Exception e) {
		          e.printStackTrace();
		      }
		  }
			/*public boolean isElementDisplayed(WebElement element) {

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

			String wifi ="realme 6";
			@SuppressWarnings("deprecation")
			public void remote() {

				Runtime.getRuntime()
				.exec("adb shell am start -n com.android.settings/.Settings\\$WifiSettingsActivity");
		Thread.sleep(5000);
		WebElement element = driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\""
						+ wifi + "\"))"));
		clickbyXpath(element, "cliked on  " + wifi + " on Wi-Fi page");
		WebElement adddeenterpasswordwifipge;
		if (isElementDisplayed(adddeenterpasswordwifipge)) {
			entervaluebyXpath(enterpasswordwifipge, "wifipage password", "12345222");
			clickbyXpath(connectbuttonWifipage, "connect button");
		} else {
			System.out.println("Already password saved ");
		}
			}*/
		  
		 

		  @SuppressWarnings("deprecation")
		public void connectToWiFi(String wifiName, String wifiPassword) {
		      try {
		          // Open WiFi settings on the Android device
		          Runtime.getRuntime().exec("adb shell am start -a android.settings.WIFI_SETTINGS");
                  //adb shell am start -n com.android.settings/.Settings\\$WifiSettingsActivity
		          // Wait for the WiFi settings to open
		          Thread.sleep(5000);

		          // Scroll to the WiFi network by name
		          WebElement wifiElement = driver.findElement(MobileBy.AndroidUIAutomator(
		                  "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\""
		                          + wifiName + "\"))"));

		          
		          // Click on the WiFi network
		          clickByXpath(wifiElement, "Clicked on " + wifiName + " on Wi-Fi page");

		          // Check if the password entry field is displayed
		          WebElement enterPasswordField = driver.findElement(MobileBy.xpath("//android.widget.EditText[@resource-id=\"com.android.settings:id/password\"]")); // Replace with the actual XPath
		          if (isElementDisplayed(enterPasswordField)) {
		              // Enter the WiFi password
		              enterValueByXpath(enterPasswordField, "Wi-Fi password", wifiPassword);

		              // Click on the connect button
		              WebElement connectButton = driver.findElement(MobileBy.xpath("//android.widget.Button[@resource-id='android:id/button1']")); // Replace with the actual XPath
		              clickByXpath(connectButton, "Connect button");
		              
		               Thread.sleep(5000);
		               
		               
		           	if (driver.queryAppState("com.iinvsys.szephyr") != ApplicationState.RUNNING_IN_FOREGROUND) {
						driver.activateApp("com.iinvsys.szephyr"); // Bring it back
						Thread.sleep(7000);
					}
		               
		          } else {
		              System.out.println("Already connected or password is saved.");
		          }
		      } catch (Exception e) {
		          e.printStackTrace();
		      }
		  }

		  // Helper method to check if the element is displayed
		  public boolean isElementDisplayed(WebElement element) {
		      try {
		          Thread.sleep(3000);  // Introduce a small delay before checking visibility
		          return element.isDisplayed();
		      } catch (NoSuchElementException | InterruptedException e) {
		          return false;
		      }
		  }

		  // Example methods for clicking and entering values (to be replaced with your actual implementations)
		  public void clickByXpath(WebElement element, String description) {
		      element.click();
		      System.out.println(description);
		  }

		  public void enterValueByXpath(WebElement element, String fieldName, String value) {
		      element.sendKeys(value);
		      System.out.println("Entered value in " + fieldName + ": " + value);
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
}