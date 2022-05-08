package system_screens;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import repository.BasePage;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.time.Duration;

public class DisplayWars extends BasePage {
    private WebDriver driver;

    public DisplayWars(WebDriver driver) {
        this.driver = driver;
    }

    public void displayWars() throws MalformedURLException, AWTException {
        searchWard();
        selectWard();
        selectUnit();
    }

    @Test(priority = 2, description = "Field Search: Select a ward and write a ward")
    @Description("Field Search: Select a ward and write a ward")
    @Feature("Feature7221: Patients tab screen")
    @Story("Story: 111")
    @Severity(SeverityLevel.BLOCKER)
    public void searchWard() throws MalformedURLException {
        WebElement searchWard = driver.findElement(By.cssSelector("button[aria-label=פתח]"));
        searchWard.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        searchWard.sendKeys("מחלקה פנימית א");
    }

    @Test (priority = 3, description = "Selecting the ward and confirming the name of the ward")
    public void selectWard() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String actualTitle = driver.findElement(By.className("jss12")).getText();
        String expectedTitle = "כרטיסיות מטופלים - פנימית א";
        System.out.println(actualTitle);
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Test (priority = 4, description = "Search for display buttons, go to 'ward', and verify font size")
    public void selectUnit(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement clickUnit = driver.findElement(By.xpath("//*[@id='app']/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/button[2]"));
        clickUnit.click();
        String actualFontSize = String.valueOf(clickUnit.getCssValue("font-size"));
        System.out.println(actualFontSize);
        String expectedFontSize = "16px";
        Assert.assertEquals(actualFontSize, expectedFontSize);
    }
}
