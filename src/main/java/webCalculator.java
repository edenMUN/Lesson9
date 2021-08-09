import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class webCalculator {
    public static WebDriver driver;
    public int number = 4;

    @BeforeClass
    public static void BeforeClassonce(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\edenmm\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://dgotlieb.github.io/WebCalculator/");
    }

    @Test
    public void buttondimensions(){
        WebElement button2 = driver.findElement(By.id("seven"));
        System.out.println(button2.getRect().getHeight());
        System.out.println(button2.getRect().getWidth());
    }

    @Test
    public void buttondisplayed(){
        WebElement buttondis = driver.findElement(By.id("six"));
        System.out.println(buttondis.isDisplayed());
    }

    @Test
    public void Calculate(){

    }

    @AfterClass
    public static void AfterClass(){
        driver.quit();
    }

}
