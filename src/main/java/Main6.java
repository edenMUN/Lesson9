import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

public class Main6 {
    public static WebDriver driver;

    @BeforeClass
    public static void BeforeClassonce() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\edenmm\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://dgotlieb.github.io/Controllers/");
    }

    @Test
    public void CheeseOption(){
        driver.findElement(By.cssSelector("input[value=Cheese]")).click();
    }

    @Test
    public void  SelectDropDown(){
        Select myselection = new Select(driver.findElement(By.name("dropdownmenu")));
        myselection.selectByVisibleText("Milk");
    }

    @Test
    public void printAllElements(){
            Select dropDown = new Select(driver.findElement(By.name("dropdownmenu")));
            List<WebElement> e = dropDown.getOptions();
            int itemCount = e.size();

            for(int l = 0; l < itemCount; l++)
            {
                System.out.println(e.get(l).getText());
            }
        }
}
