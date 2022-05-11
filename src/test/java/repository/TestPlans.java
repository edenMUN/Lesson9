package repository;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import system_screens.LoginPage;
import java.net.MalformedURLException;
import java.time.Duration;


/**
 * This class is for running tests.
 */
public class TestPlans {
    private static WebDriver driver;

    @BeforeClass
    public void beforeClass() throws Exception {
            driver = DriverSingleton.getDriverInstance();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            String url = XMLUtils.getData("URL");
            driver.get(url);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    @Test
    public void homePage02() throws MalformedURLException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginPage();
    }
}
