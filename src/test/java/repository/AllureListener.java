package repository;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener implements ITestListener {

    private static String getTestMethod(ITestResult iTestResult){
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment
    public byte[] saveFailureScreenShot(WebDriver driver){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String massage){
        return massage;
    }

    @Override
    public void onStart(ITestContext iTestResult) {
        System.out.println("I am on start method " + iTestResult.getName());
        iTestResult.setAttribute("WebDriver", DriverSingleton.getDriverInstance());
//        ITestListener.super.onStart(iTestResult);
    }

    @Override
    public void onFinish(ITestContext iTestResult) {
        System.out.println("I am on finish method " + iTestResult.getName());
//        ITestListener.super.onFinish(iTestResult);
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Iam on TestStart method " + getTestMethod(iTestResult) + " start");
//        ITestListener.super.onTestStart(iTestResult);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("I am on TestSuccess method " + getTestMethod(iTestResult) + "succeed");
//        ITestListener.super.onTestSuccess(iTestResult);
        Object testClass = iTestResult.getInstance();
        WebDriver driver = DriverSingleton.getDriverInstance();
        if (driver instanceof WebDriver){
            System.out.println("This test was successful :" + getTestMethod(iTestResult));
        }
        saveTextLog(getTestMethod(iTestResult) + " This test was successful");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("I am on TestFailure method " + getTestMethod(iTestResult) + "failed");
        Object testClass = iTestResult.getInstance();
        WebDriver driver = DriverSingleton.getDriverInstance();
        if (driver instanceof WebDriver){
            System.out.println("Screen shot captured for test case :" + getTestMethod(iTestResult));
            saveFailureScreenShot(driver);
        }
        saveTextLog(getTestMethod(iTestResult) + " failed and screenshot taken");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("I am on TestSkipped method " + getTestMethod(iTestResult) + "skipped");
//        ITestListener.super.onTestSkipped(iTestResult);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test failed but it is defined success ratio " + getTestMethod(iTestResult));
//        ITestListener.super.onTestFailedButWithinSuccessPercentage(iTestResult);
    }
}
