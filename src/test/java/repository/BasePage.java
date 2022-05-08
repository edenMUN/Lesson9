package repository;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public void clickElement(By locator) throws MalformedURLException {
        getWebElement(locator).click();
    }

    /**
     * The method to find an element and send a key to the element.
     * @param locator of the element.
     * @param text you want to write in the element.
     */
    public void sendKeysToElement(By locator, String text) throws MalformedURLException {
        getWebElement(locator).sendKeys(text);
    }

    /**
     * The method creates the driver.
     * @param locator of the element.
     * @return the picture of the screenshot page.
     */
    private WebElement getWebElement(By locator) throws MalformedURLException {
        return DriverSingleton.getDriverInstance().findElement(locator);
    }

}
