package wrappers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.net.ftp.FTPClient;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import utils.DataInputProvider;
import utils.Reporter;

public class MobileAppWrappers extends GenericWrappers {
	protected String browserName;
	protected String dataSheetName;
	protected static String testCaseName;
	protected static String testDescription;
	GenericWrappers genericwrappers;

	@BeforeSuite
	public void beforeSuite() throws FileNotFoundException, IOException{
		Reporter.startResult();


	}

	@BeforeTest
	public void beforeTest() throws FileNotFoundException, IOException{

	}

	@BeforeMethod 
	public void beforeMethod(){ 
		Reporter.startTestCase();
		//initDriver(); 

	}

	@AfterSuite
	public void afterSuite(){
		Reporter.endResult();
	}


	@AfterTest
	public void afterTest() throws IOException{

		try {
			// FTP server credentials

			String server = "192.168.10.34";//192.168.10.34
			int port = 21;
			String user = "qa_usr";
			String pass = "nw9f2hgo@123";

			// Local log files
			String appLogPath = "./serial_log.txt";
			String deviceLogPath = "./serial_log.txt";

			// FTP paths
			String existingDirectory = "//Internal_Project//FULL_VALIDATION_PACKAGES_LOGS//LOGS//2024//Automation_Logs//";
			String newSubDir = "Applogs_" + randomnumbers(6); // Subdirectory name

			// Initialize FTP connection
			FTPUploader(server, port, user, pass);

			// Create new subdirectory inside the existing directory
			createAndNavigateToSubdirectory(existingDirectory, newSubDir);

			// Upload files to the new subdirectory
			uploadFile(appLogPath, "React-Log-20240924_182921.txt");
			uploadFile(deviceLogPath, "Deivelog.txt");

			// Disconnect from FTP server
			disconnect();

		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	@AfterMethod
	public void afterMethod(){
		quitBrowser();
		//driver.quit();
	}

	@DataProvider(name="fetchData")
	public Object[][] getData(){
		return DataInputProvider.getSheet(dataSheetName);
	}

}
