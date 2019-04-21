package steps;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageDriver {
    static {
        System.setProperty("webdriver.chrome.driver", "C:\\Server\\chromedriver.exe");
    }
    private static WebDriver driver;


    public static WebDriver getDriver() {
        try {
            driver.getTitle();
            return driver;
        } catch (NullPointerException| NoSuchSessionException e) {
            driver = new ChromeDriver();
            return driver;
        }
    }
}
