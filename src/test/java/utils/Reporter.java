package utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import wrappers.MobileAppWrappers;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;


	public class Reporter extends MobileAppWrappers {

	    private static ExtentTest test;
	    private static ExtentReports extent;
	    private static ExtentSparkReporter htmlReporter;
	    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm");
	    private static LocalDateTime now = LocalDateTime.now();
	    private static String time = now.format(formatter);
	    private static String reportPath = "./reports/Spark_" + time + ".html";
	    private static String imagePath = "./reports/images/";

	    public static void reportStep(String desc, String tcstatus) {

	        // Ensure the screenshot folder exists
	        File screenshotDir = new File(imagePath);
	        if (!screenshotDir.exists()) {
	            screenshotDir.mkdirs(); // Create the directory if it doesn't exist
	        }

	        long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
	        String screenshotFile = imagePath + number + ".jpg";

	        try {
	            TakesScreenshot ts = (TakesScreenshot) driver;
	            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(screenshotFile));
	        } catch (WebDriverException | IOException e) {
	            e.printStackTrace();
	        }

	        // Write if it is successful or failure or information
	        if (tcstatus.toUpperCase().equals("PASS")) {
	            test.pass(desc, MediaEntityBuilder.createScreenCaptureFromPath(screenshotFile).build());
	        } else if (tcstatus.toUpperCase().equals("FAIL")) {
	            test.fail(desc, MediaEntityBuilder.createScreenCaptureFromPath(screenshotFile).build());
	            throw new RuntimeException("FAILED");
	        } else if (tcstatus.toUpperCase().equals("INFO")) {
	            test.log(Status.INFO, desc);
	        } else if (tcstatus.toUpperCase().equals("SKIP")) {
	            test.skip(desc, MediaEntityBuilder.createScreenCaptureFromPath(screenshotFile).build());
	        } else if (tcstatus.toUpperCase().equals("FAIL&RUN")) {
	            test.fail(desc, MediaEntityBuilder.createScreenCaptureFromPath(screenshotFile).build());
	        } else if (tcstatus.toUpperCase().equals("WARNING")) {
	            test.log(Status.WARNING, desc);
	        }
	    }

	    // Start the report and delete old reports and images
	    public static void startResult() {
	        // Delete old reports and images
	        File reportDir = new File("./reports");
	        if (reportDir.exists()) {
	            try {
	                FileUtils.cleanDirectory(reportDir); // Delete all old files in the reports folder
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }

	        // Create the new report
	        htmlReporter = new ExtentSparkReporter(reportPath);
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	    }

	    public static void startTestCase() {
	        test = extent.createTest(testCaseName, testDescription);
	    }

	    public static void endResult() {
	        extent.flush();
	    }
	}


