import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class websiteTitle {
    public static WebDriver driver;

    @BeforeClass
    public static void BeforeClassonce() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\edenmm\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }


    @Test
    public void Websitetitle() {
        String webtitle = "GOOGLE";
        String ActualTitle = driver.getTitle();
        Assert.assertEquals(ActualTitle, webtitle);
    }
}