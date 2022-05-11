package repository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * This class is for defining the creation od the driver.
 */
public class DriverSingleton {
    public static WebDriver driver = null;

    public static WebDriver getDriverInstance() {
        if(driver == null){
            String type  = null;
            try {
                type = XMLUtils.getData("browserType");
                if (type.equals("Chrome")){
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\edenmm\\Downloads\\chromedriver_win32 (6)\\chromedriver.exe");
                    driver = new ChromeDriver();
                }else if (type.equals("FF")){
                    System.setProperty("webdriver.firefox.driver", "C:\\Users\\edenmm\\Downloads\\geckodriver-v0.29.1-win64.zip\\geckodriver.exe");
                    driver = new FirefoxDriver();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return driver;
    }
}
