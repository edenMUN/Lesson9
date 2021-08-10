import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.TestOnly;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class main5 {
    public static WebDriver driver;
//    public WebElement element;

    @BeforeClass
    public static void BeforeClassonce() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\edenmm\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://dgotlieb.github.io/Actions");
    }

//    @Test
//    public void screenshot() {
//        WebElement elemnt = driver.findElement(By.id("div1"));
//        File screenShotFile = element.getScreenshotAs(OutputType.FILE); // take the screenshot
//        try {
//            FileUtils.copyFile(screenShotFile, new File("element1-screenshot.png")); // save screenshot to disk
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    public void elementScreenshotTest() {
        takeElementScreenshot(driver.findElement(By.id("div1")));
    }

    private static void takeElementScreenshot(WebElement element){
        File screenShotFile = element.getScreenshotAs(OutputType.FILE); // take the screenshot
        try {
            FileUtils.copyFile(screenShotFile, new File("element-screenshot.png")); // save screenshot to disk
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Drag(){
        WebElement firstElement = driver.findElement(By.id("div1"));
        WebElement secondElement = driver.findElement(By.id("drag1"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(secondElement, firstElement);
    }

    @Test
    public void DoubleClick(){
        WebElement X = driver.findElement(By.xpath("/html/body/p[2]"));
        Actions myAction = new Actions(driver);
        myAction.doubleClick(X);
        myAction.perform();
        WebElement actual = driver.findElement(By.id("demo"));
        String actualstring = actual.getText();
        String expected = "You double clicked";
        Assert.assertEquals(actualstring, expected);
    }

    @Test
    public void mouseHover(){
        Actions hoverAction = new Actions(driver);
        WebElement myElement = driver.findElement(By.id("close"));
        hoverAction.moveToElement(myElement).perform();
    }

    @Test
    private void SelectTwo(){
        Select mySelection = new Select(driver.findElement(By.name("food")));
        mySelection.selectByValue("pizza");
        mySelection.selectByValue("burger");
    }

    @Test
    public void UploaFile(){
        WebElement uploadElement = driver.findElement(By.name("pic"));
        uploadElement.click();
    }

    @Test
    public void scrollToElement(){
        WebElement uploadElement = driver.findElement(By.id("clickMe"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", uploadElement);
    }

    @Test
    public void ScrollToLocation(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");
    }
}

