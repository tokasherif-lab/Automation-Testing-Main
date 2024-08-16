package Listeners;

import Utilities.LogsUtils;
import Utilities.Utility;
import io.qameta.allure.Allure;
import org.testng.IInvokedMethod;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import static DirverFactory.driverFactory.getDriver;


public class IInvokedMethodListener implements org.testng.IInvokedMethodListener {
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {

    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        File logfile = Utility.getLatestFile(LogsUtils.LOGS_PATH);
        try {
            assert logfile != null;
            Allure.addAttachment("Logs.log", Files.readString(Path.of(logfile.getPath())));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        /*if (testResult.getStatus() == ITestResult.FAILURE) {
            LogsUtils.info("Test Case " + testResult.getName() + " Failed");
            Utility.takeScreenShot(getDriver(), testResult.getName());
            Utility.takeFullScreenshot(getDriver(), new P02_LandingPage(getDriver()).getNumberOfSelectedProductsOnCart());
        }*/
    }
}
