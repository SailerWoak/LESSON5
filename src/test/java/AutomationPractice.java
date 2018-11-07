import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AutomationPractice {
    private final String HOME_PAGE = "http://automationpractice.com/index.php";
    private final By ARTICLES = By.xpath(".//a[@class = 'sf-with-ul']");
    private final By DRESSES = By.xpath(".//a[@class = 'img']");
    private final By COLORS = By.xpath(".//ul[@class = 'col-lg-12 layered_filter_ul color-group']/li");
    private static final Logger LOGGER = LogManager.getLogger(AutomationPractice.class);
    WebDriver browser;

    @Test
    public void PageClicking() {
        LOGGER.info("Opening browser");
        System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get(HOME_PAGE);

        LOGGER.info("Opening list of Elements and clicking button");
        tabWomenByName("Women").click();


        LOGGER.info("Dresses button click ");
        subCategoryByName("Dresses").click();


        LOGGER.info("Choosing color 'Orange and clicking'");
        borderOfColoursByName("Orange").click();

        WebDriverWait wait = new WebDriverWait(browser, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(COLORS));
    }

    private WebElement tabWomenByName(String tab) {
        List<WebElement> tabWomanCategory = browser.findElements(ARTICLES);
        for (int i = 0; i < tabWomanCategory.size(); i++) {
            WebElement element = tabWomanCategory.get(i);
            if (element.getText().equals(tab)) {
                return element;
            }
        }
        return null;
    }
    private WebElement subCategoryByName (String colour){
        List<WebElement> subCategoryDresses = browser.findElements(DRESSES);
        for(int i = 0; i < subCategoryDresses.size(); i++){
            WebElement dresses = subCategoryDresses.get(i);
            if (dresses.getText().equals(colour)) {
                return dresses;
            }
        }
        return null;
    }
    private WebElement borderOfColoursByName (String name) {
        List<WebElement> borderOfColours = browser.findElements(COLORS);
        for(int i = 0; i < borderOfColours.size(); i++){
            WebElement colours = borderOfColours.get(i);
            if (colours.getText().equals(name)){
                return colours;
            }
        }
        return null;
    }
    @AfterEach
    public void browserClose() {
        browser.close();
    }
}
