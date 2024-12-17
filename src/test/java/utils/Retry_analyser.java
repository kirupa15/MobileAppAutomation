package utils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry_analyser implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int maxRetryCount = 1; // Retry 3 times

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true; // Retry
        }
        return false; // No more retries
    }
}


