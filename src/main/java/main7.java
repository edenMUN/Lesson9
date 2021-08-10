import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class main7 {
    public static WebDriver driver;

    @BeforeClass
    public static void BeforeClassonce() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\edenmm\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://dgotlieb.github.io/WebCalculator/");
    }

    @Test
    public void buttonHeight(){
        WebElement mybutton = driver.findElement(By.id("two"));
        System.out.println("button Height: " + mybutton.getRect().getHeight());
    }

    @Test
    public void buttonWidth(){
        WebElement mybutton = driver.findElement(By.id("six"));
        System.out.println("button Width: " + mybutton.getRect().getWidth());
    }

    @AfterClass
    public void quitAll(){
        driver.quit();
    }
}
