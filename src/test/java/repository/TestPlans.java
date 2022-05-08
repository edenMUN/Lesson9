package repository;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestPlans {
    private static WebDriver driver;
    private static ExtentReports extent= new ExtentReports();
    private static ExtentTest test = extent.createTest("Coview Project", "Sanity Test");

    @BeforeClass
    public void beforeClass() throws Exception {
//        DriverSingleton.getDriverInstance();
//        String url = XMLUtils.getData("URL");
//        driver.get(url);
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter( "./report.html");
        extent.attachReporter(htmlReporter);

        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\edenmm\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("http://coview.dev.idgmc.org:8000/cases-view");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            test.log(Status.PASS, "Driver established successfully");
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Driver connection failed! " + e.getMessage());
            throw new Exception("Driver failed");
        }
    }

    @AfterClass
    public void afterClass(){
        extent.flush();
    }

    @Test (priority = 1)
    public void searchWard(){
        try {
            WebElement searchWard = driver.findElement(By.cssSelector("button[aria-label=פתח]"));
            searchWard.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            searchWard.sendKeys("מחלקה פנימית א");
            test.log(Status.PASS, "Searching for ward was successful");
        } catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL, "Ward searched-'מחלקה פנימית א' was not found " + e.getMessage());
        }
    }


    @Test (priority = 2)
    public void selectWard() throws AWTException {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_ENTER);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            String actualTitle = driver.findElement(By.className("jss12")).getText();
            String expectedTitle = "כרטיסיות מטופלים - פנימית א";
            System.out.println(actualTitle);
            Assert.assertEquals(expectedTitle, actualTitle);
            test.log(Status.PASS, "Select ward: מחלקה פנימית א was successful");
        }catch (Exception e){
//            e.printStackTrace();
            test.log(Status.FAIL, "The selected ward was not clickable " + e.getMessage());
        }
    }

    @Test (priority = 3)
    public void selectUnit(){
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            WebElement clickUnit = driver.findElement(By.xpath("//*[text()='מחלקות']"));
            clickUnit.click();
            String actualFontSize = String.valueOf(clickUnit.getCssValue("font-size"));
            System.out.println(actualFontSize);
            String expectedFontSize = "16px";
            Assert.assertEquals(actualFontSize, expectedFontSize);
            test.log(Status.PASS, "Select unit was successful");
        }catch (Exception e){
            test.log(Status.FAIL, "The unit fond size is not 14px " + e.getMessage());
        }
    }

}
