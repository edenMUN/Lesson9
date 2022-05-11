package system_screens;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;

/**
 * This class is for defining all find element in the login page.
 */
public class LoginPage {

    private WebDriver driver;

    /**
     * The method initializes a driver variable.
     * @param driver the driver.
     */
    public LoginPage(WebDriver driver) {
        this.driver =driver;
    }

    /**
     * The method calls all the other methods is this class.
     */
    public void loginPage() {
        countryCode();
        phoneNumber();
        termsConsent();
        nextButton();
    }

    /**
     * The method find an element- press country code, click on it and select one.
     */
    public void countryCode(){
        WebElement countryCode = driver.findElement(By.className("country-code-block"));
        countryCode.click();
        List<WebElement> clickOnCountry = driver.findElements(By.tagName("li"));
        clickOnCountry.get(105).click();
        String expectedCode = "+972";
        Assert.assertEquals(countryCode.getText(), expectedCode);
    }

    /**
     * The method find an element- press phone number field, click on it and type a phone number.
     */
    public void phoneNumber(){
        WebElement phoneField = driver.findElement(By.id("number"));
        System.out.println(phoneField.getText());
        phoneField.sendKeys("0508166425");
    }

    /**
     * The method find an element- checkbox terms of consent, select the field.
     */
    public void termsConsent(){
        WebElement termsConsent = driver.findElement(By.className("checkbox-component-oioPT"));
        boolean isSelected = termsConsent.isSelected();
        if (isSelected == false){
            termsConsent.click();
        }
    }

    /**
     * The method find an element- press next button and continue to home page.
     */
    public void nextButton(){
        WebElement nextButton = driver.findElement(By.className("button-component-uUV_B"));
        if (nextButton.isEnabled()) {
            nextButton.click();
        }
    }
}
