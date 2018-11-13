package BaseFunk.AutomationPractice;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BaseFunk {
    WebDriver browser;

    public BaseFunk() {
        System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
    }

    public void goToPage(String url) {
        browser.get(url);
    }
    public List<WebElement> getElements(By locator){
        return browser.findElements(locator);
    }
    public WebElement getElement (By locator) {
        Assertions.assertFalse(getElements(locator).isEmpty(), "No elements!");
        return browser.findElement(locator);
    }
}
