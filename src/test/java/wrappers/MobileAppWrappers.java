package wrappers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.StoreLogPage;
import utils.ADBconnections;
import utils.CheckoutAndBuildApk;
import utils.DataInputProvider;
import utils.GetAppLog;
import utils.Reporter;

public class MobileAppWrappers extends GenericWrappers {
	protected String browserName;
	protected String dataSheetName;
	protected static String testCaseName;
	protected static String testDescription;
	private PrintStream originalOut;
    private PrintStream fileOut;
    
    
    
    
    
    String baseRemotePath = loadProp("BASEREMOTEPATH");  // Base FTP directory path
    String localDirectory =loadProp("LOCALAPPPATH") ;  // Local directory to save file
    String newFileName = loadProp("NEWFILENAME");  // New file name
    
    
    String server = "192.168.10.34";//192.168.10.34
	int port = 21;
	String user = "qa_usr";
	String pass = "nw9f2hgo@123";
	
	@BeforeSuite
	public void beforeSuite() throws FileNotFoundException, IOException, InterruptedException{
		
//		ADBconnections AdbUtils = new ADBconnections();
		
		// Enable below two lines of code to Get app from FTP
//		FTPUploader(server, port, user, pass);
//		getLatestApk(baseRemotePath, localDirectory, newFileName);
//		
//		disconnect();
		
		// Enable below 2 lines of code to check out latest app from Sharepath
		
//		CheckoutAndBuildApk build= new CheckoutAndBuildApk();
//		build.buildAPK();
		
		Reporter.startResult();//START TESTNG RESULT
		
	        // Redirect console output to a file
//		originalOut = System.out;
//	        fileOut = new PrintStream(new FileOutputStream("test-output/console-output.txt"));
//	        System.setOut(fileOut);
//	        System.out.println("Test suite started. Output is redirected to file.");
	        
	        //START GETTING APP LOG
	//	GetAppLog applog= new GetAppLog();
//		applog.startLogProcess();
		
//		ABDconnection();
		
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
		System.out.println("Test suite finished. Closing output redirection.");
//        fileOut.close();
//        System.setOut(originalOut);
	}


	@AfterTest
	public void afterTest() throws IOException{

		
	}

	@AfterMethod
	public void afterMethod() throws Exception{
//		quitBrowser();
		
		driver.terminateApp(packages);
		driver.quit();
		
	}

//	@DataProvider(name="fetchData")
//	public Object[][] getData(){
//		return DataInputProvider.getSheet(dataSheetName);
//	}

}
