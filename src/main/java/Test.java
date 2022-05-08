import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class Test {
    private static WebDriver driver;

    @BeforeClass
    static public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\edenmm\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.Amazon.com");
    }

    @org.testng.annotations.Test
    public void search(){
        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("laptop");
        search.sendKeys(Keys.ENTER);
    }
}
