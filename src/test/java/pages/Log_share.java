//import io.appium.java_client.AppiumDriver;
//
//import org.apache.commons.net.ftp.FTPClient;
////import org.apache.commons.net.ftp.FTP;
////import org.apache.commons.net.ftp.FTPClient;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//public class LogShare {
//
//    private static AppiumDriver driver;
//
//    public static void clickLogShareButton() {
//        WebElement shareButton = driver.findElement(By.xpath("//your-xpath-here"));
//        shareButton.click();
//    }
//
//    public static void pullLogFileFromDevice() {
//        // Path to the log file on the mobile device
//        String deviceFilePath = "/storage/emulated/0/Download/logfile.txt";
//        
//        // Pull the file from the mobile device
//        byte[] logFile = driver.pullFile(deviceFilePath);
//        
//        // Save the file locally
//        try (FileOutputStream fos = new FileOutputStream(new File("local_logfile.txt"))) {
//            fos.write(logFile);
//            System.out.println("Log file pulled from device and saved locally.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void uploadLogToFTP() {
//        FTPClient ftpClient = new FTPClient();
//        String ftpServer = "192.168.10.34";
//        String ftpUser = "qa_usr";
//        String ftpPass = "nw9f2hgo@123"; // Enter your FTP password
//
//        try {
//            // Connect to FTP server
//            ftpClient.connect(ftpServer);
//            ftpClient.login(ftpUser, ftpPass);
//
//            // Switch to binary mode for file transfer
//            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
//
//            // Specify the destination path on the FTP server
//            String ftpFilePath = "/Internal_Project/FULL_VALIDATION_PACKAGES_LOGS/LOGS/2024/szephyr/Android/12674/logfile.txt";
//
//            // Upload the file
//            FileInputStream inputStream = new FileInputStream("local_logfile.txt");
//            boolean uploaded = ftpClient.storeFile(ftpFilePath, inputStream);
//            inputStream.close();
//
//            if (uploaded) {
//                System.out.println("Log file uploaded successfully to FTP.");
//            } else {
//                System.out.println("Failed to upload log file.");
//            }
//
//            // Logout and disconnect from the FTP server
//            ftpClient.logout();
//            ftpClient.disconnect();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        // Trigger the log share button
//        clickLogShareButton();
//
//        // Pull the log file from the mobile device
//        pullLogFileFromDevice();
//
//        // Upload the log file to FTP
//        uploadLogToFTP();
//    }
//}
