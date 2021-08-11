import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AssertWebsiteURL {
    public static WebDriver driver;

    @BeforeClass
    public static void BeforeClassonce(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\edenmm\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }

    @Test
    public void WebsiteURL(){
        String ActualTitle = driver.getCurrentUrl();
        String ExpectedTitle = "https://www.google.com/";
        Assert.assertEquals(ExpectedTitle, ActualTitle);
    }

    @AfterClass
    public static void AfterClass(){
        driver.quit();
    }
}

