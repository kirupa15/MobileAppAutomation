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

import jssc.SerialPortException;
import utils.DataInputProvider;
import utils.GetAppLog;
import utils.Reporter;
import utils.logReadandWrite;

public class MobileAppWrappers extends GenericWrappers {
	protected String browserName;
	protected String dataSheetName;
	protected static String testCaseName;
	protected static String testDescription;

	
	@BeforeSuite
	public void beforeSuite() throws FileNotFoundException, IOException, InterruptedException{
		Reporter.startResult();
		GetAppLog applog= new GetAppLog();
		applog.startLogProcess();
		logReadandWrite readwrite = new logReadandWrite(loadProp("COM"));
		readwrite.openPort();

	}

	@BeforeTest
	public void beforeTest() throws FileNotFoundException, IOException, Exception{
	}

	@BeforeMethod 
	public void beforeMethod(){ 
		Reporter.startTestCase();

	}

	@AfterSuite
	public void afterSuite(){
		Reporter.endResult();
	}


	@AfterTest
	public void afterTest() throws IOException{

		
	}

	@AfterMethod
	public void afterMethod(){
//		quitBrowser();
		try {
			// FTP server credentials

			String server = "192.168.10.34";//192.168.10.34
			int port = 21;
			String user = "qa_usr";
			String pass = "nw9f2hgo@123";

			// Local log files
			String appLogPath = "./app_log.txt";
			String deviceLogPath = "./serial_log.txt";

			// FTP paths
			String existingDirectory = "/Internal_Project/FULL_VALIDATION_PACKAGES_LOGS/LOGS/2024/Automation_Logs/";
			String newSubDir = "logs_" + randomnumbers(6); // Subdirectory name
			// Initialize FTP connection
			FTPUploader(server, port, user, pass);

			// Create new subdirectory inside the existing directory
			createAndNavigateToSubdirectory(existingDirectory, newSubDir);

			// Upload files to the new subdirectory
			uploadFile(appLogPath,  testCaseName+"App.txt");
			uploadFile(deviceLogPath, testCaseName+".txt");
			

			String remotefilepath =existingDirectory+newSubDir;
			String Filename="/"+ testCaseName+".txt";
			Reporter.reportStep(" FTP Path : "+ remotefilepath +
					"<br>"
					+"Device Log File name:"+Filename, "INFO");
			
			// Disconnect from FTP server
			disconnect();

		} catch (IOException e) {
			e.printStackTrace();

		}
		driver.terminateApp("com.iinvsys.szephyr");
//		driver.closeApp();
		driver.quit();
//		logReadandWrite readwrite=new logReadandWrite("COM4");
//		readwrite.closePort();
	}

	@DataProvider(name="fetchData")
	public Object[][] getData(){
		return DataInputProvider.getSheet(dataSheetName);
	}

}
