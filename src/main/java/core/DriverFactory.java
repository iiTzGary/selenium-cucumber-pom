package core;

import com.fasterxml.jackson.databind.JsonNode;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.ConfigReader;

import java.time.Duration;

public class DriverFactory {
   public static WebDriver createDriver() {
        String browser = ConfigReader.getString("browser");
        JsonNode browserConfig = ConfigReader.getBrowserConfig(browser);

       WebDriver driver;
       switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().arch64().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-blink-features=AutomationControlled");

                if (browserConfig.get("headless").asBoolean()) {
                    chromeOptions.addArguments("--headless");
                }
                if (browserConfig.get("incognito").asBoolean()) {
                    chromeOptions.addArguments("--incognito");
                }
                if (browserConfig.has("windowSize")) {
                    chromeOptions.addArguments("--window-size=" + browserConfig.get("windowSize").asText());
                }
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();

                if (browserConfig.get("headless").asBoolean()) {
                    firefoxOptions.addArguments("--headless");
                }
                if (browserConfig.get("privateBrowsing").asBoolean()) {
                    firefoxOptions.addArguments("--private");
                }
                driver = new FirefoxDriver(firefoxOptions);
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigReader.getInt("implicitWait")));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ConfigReader.getInt("pageLoadTime")));
        driver.manage().window().maximize();
       return driver;
   }
}