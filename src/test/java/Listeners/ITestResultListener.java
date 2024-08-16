package Listeners;

import Utilities.LogsUtils;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestResultListener implements ITestListener {

public void onTestStart(ITestResult result){
    LogsUtils.info("Test Case" + result.getName() + "Started");
}
public void onTestSucess(ITestResult result){
    LogsUtils.info("Test Case " + result.getName() + " Success");
}
public void onTestSkipped(ITestResult result){
    LogsUtils.info("Test Case " + result.getName() + " Skipped");
}
}
