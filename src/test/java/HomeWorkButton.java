import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HomeWorkButton {
    private final By ARTICLES = By.xpath(".//a[@class = 'sf-with-ul']");
    private final By DRESSES = By.xpath(".//a[@class = 'img']");
    private final By COLORS = By.xpath(".//ul[@class = 'col-lg-12 layered_filter_ul color-group']/li");

    @Test
    public void newTest() {

        System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http://automationpractice.com/index.php");

        List<WebElement> topics = browser.findElements(ARTICLES);
        WebElement topic = topics.get(0);
        topic.click();

        List<WebElement> newPage = browser.findElements(DRESSES);
        WebElement dress = newPage.get(1);
        dress.click();

        List<WebElement> border = browser.findElements(COLORS);
        WebElement orange = border.get(3);
        orange.click();
    }
}
