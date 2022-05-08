package repository;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import system_screens.DisplayWars;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Listeners({AllureListener.class})
public class TestExample{
    private static WebDriver driver;

    @BeforeClass
    public void beforeClass() throws Exception {
            driver = DriverSingleton.getDriverInstance();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            String url = XMLUtils.getData("URL");
            driver.get(url);
            driver.manage().window().maximize();
    }

    @AfterClass
    public void afterClass(){
//        driver.quit();
    }

    @Test(priority = 1)
    @Description("Field Search: Select a ward and write a ward")
    @Feature("Feature7221: Patients tab screen")
    @Story("Story: 111")
    @Severity(SeverityLevel.BLOCKER)
    public void searchWard() throws MalformedURLException, AWTException {
//        DisplayWars displayWars = new DisplayWars(driver);
//        displayWars.displayWars();


            WebElement searchWard = driver.findElement(By.cssSelector("button[aria-label=פתח]"));
            searchWard.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            searchWard.sendKeys("מחלקה פנימית א");
    }


    @Test (priority = 2, description = "Selecting the ward and confirming the name of the ward")
    public void selectWard() throws AWTException {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_ENTER);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            String actualTitle = driver.findElement(By.className("jss12")).getText();
            String expectedTitle = "כרטיסיות מטופלים - פנימית א";
            System.out.println(actualTitle);
            Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Test (priority = 3, description = "Search for display buttons, go to 'ward', and verify font size")
    public void selectUnit() throws InterruptedException {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            WebElement clickUnit = driver.findElement(By.xpath("//*[@id='app']/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/button[2]"));
            clickUnit.click();
            String actualFontSize = String.valueOf(clickUnit.getCssValue("font-size"));
            System.out.println(actualFontSize);
            String expectedFontSize = "16px";
            Assert.assertEquals(actualFontSize, expectedFontSize);
            WebDriverWait wait = new WebDriverWait(driver, 20);
    }

    @Test (priority = 4)
    @Description("pressing the feedback icon")
    @Feature("Feature7823: Screen wrote to us")
    @Story("Story: 11652")
    @Severity(SeverityLevel.BLOCKER)
    public void feedbackIcon() throws InterruptedException {
        Thread.sleep(4000);
        WebElement feedbackIcon = driver.findElement(By.className("cases_feedBackButtonOutline__2JKNS"));
        feedbackIcon.click();
        String actualFeedbackTitle = String.valueOf(driver.findElement(By.className("feedbackDialog_headerText__6jlv_")).getText());
        String expectedFeedbackTitle = "כתבו לנו";
        Assert.assertEquals(actualFeedbackTitle, expectedFeedbackTitle);
    }

    @Test (priority = 5)
    @Description("Choosing feedback's subject")
    @Feature("Feature7823: Screen wrote to us")
    @Story("Story: 11652")
    @Severity(SeverityLevel.BLOCKER)
    public void openSubject(){
        WebElement openSubjectField = driver.findElement(By.id("feedbackSubjectId"));
        openSubjectField.click();
    }

    @Test (priority = 6)
    @Description("Choosing feedback's subject")
    @Feature("Feature7823: Screen wrote to us")
    @Story("Story: 11652")
    @Severity(SeverityLevel.BLOCKER)
    public void  selectSpecificSubject() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
    }

    @Test (priority = 7)
    @Description("Choosing feedback's subject")
    @Feature("Feature7823: Screen wrote to us")
    @Story("Story: 11652")
    @Severity(SeverityLevel.BLOCKER)
    public void feedbackContent(){
        WebElement feedbackContent = driver.findElement(By.id("content"));
        feedbackContent.click();
        feedbackContent.sendKeys("היי");
        String actualContentLabel = driver.findElement(By.id("content-label")).getText();
        String expectedContentLabel = "נותרו עוד 247 תווים";
        Assert.assertEquals(actualContentLabel, expectedContentLabel);
    }

    @Test (priority = 8)
    @Description("Choosing feedback's subject")
    @Feature("Feature7823: Screen wrote to us")
    @Story("Story: 11652")
    @Severity(SeverityLevel.BLOCKER)
    public void emailField(){
        driver.findElement(By.name("email")).sendKeys("eden@gmail.com");
    }

    @Test (priority = 9)
    @Description("Choosing feedback's subject")
    @Feature("Feature7823: Screen wrote to us")
    @Story("Story: 11652")
    @Severity(SeverityLevel.BLOCKER)
    public void phoneField(){
        driver.findElement(By.name("phone")).sendKeys("0508766543");
    }

    @Test (priority = 10)
    @Description("Choosing feedback's subject")
    @Feature("Feature7823: Screen wrote to us")
    @Story("Story: 11652")
    @Severity(SeverityLevel.BLOCKER)
    public void toggleScreenshot(){
        WebElement toggleScreenshot = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[2]/div/div/form/div/div[10]/span/span[1]/span"));
        toggleScreenshot.click();
    }

    @Test (priority = 11)
    @Description("Choosing feedback's subject")
    @Feature("Feature7823: Screen wrote to us")
    @Story("Story: 11652")
    @Severity(SeverityLevel.BLOCKER)
    public void pressSendButton() throws InterruptedException {
        Thread.sleep(6000);
        WebElement sendButton = driver.findElement(By.cssSelector("button[type=submit]"));
        sendButton.click();
    }

}
