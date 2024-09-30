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
		boolean driverInitialized = initAndriodDriver();
		if (driverInitialized) {
		 System.out.println("Mobile App lanched Succesfully"); } else {
		 System.out.println("Issue in Launching Mobile App"); }
		 
	}

	@BeforeTest
	public void beforeTest(){

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
         String appLogPath = "C://Users//Invcuser_45//Desktop//React-Log-20240924_182921.txt";
         String deviceLogPath = "C://Users//Invcuser_45//Desktop//LiveLog//OLD//teraterm.log";

         // FTP paths
         String existingDirectory = "/users/Ashif/";
         String newSubDir = "Applogs_" + randomnumbers(4); // Subdirectory name

         // Initialize FTP connection
         FTPUploader ftpUploader = new FTPUploader(server, port, user, pass);

         // Create new subdirectory inside the existing directory
         ftpUploader.createAndNavigateToSubdirectory(existingDirectory, newSubDir);

         // Upload files to the new subdirectory
         ftpUploader.uploadFile(appLogPath, "React-Log-20240924_182921.txt");
         ftpUploader.uploadFile(deviceLogPath, "teraterm.log");

         // Disconnect from FTP server
         ftpUploader.disconnect();

        	} catch (IOException e) {
         e.printStackTrace();
     
        	}
	}

	@AfterMethod
	public void afterMethod(){
		quitBrowser();
		driver.quit();
	}

	@DataProvider(name="fetchData")
	public Object[][] getData(){
		return DataInputProvider.getSheet(dataSheetName);
	}

}
