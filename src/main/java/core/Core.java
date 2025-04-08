package core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;

import java.time.Duration;

public class Core {
    public static WebDriver driver;
    public WebDriverWait wait;

    public Core() {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getInt("explicitWait")));
    }

    protected void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void enterText(WebElement element, String text) {
        waitForElementToBeVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    protected void enterTextLikeHuman(WebElement element, String text) {
        try {
            waitForElementToBeVisible(element);
            element.clear();
            for (char letter : text.toCharArray()) {
                element.sendKeys(String.valueOf(letter));
                Thread.sleep(200);
            }
            Thread.sleep(2000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    protected void clickElement(WebElement element) {
        waitForElementToBeClickable(element);
        element.click();
    }

    protected void clickElementUsingActions(WebElement element){
        new Actions(driver).click(element).build().perform();
    }

    protected void clickElementUsingJs(WebElement element){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    protected boolean isElementDisplayed(WebElement element) {
        waitForElementToBeVisible(element);
        return element.isDisplayed();
    }
}
