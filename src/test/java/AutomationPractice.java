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
    private final By ARTICLES = By.xpath(".//ul[contains(@class, 'menu-content')]/li/a");
    private final By DRESSES = By.xpath(".//ul[@class = 'clearfix']/li/h5/a");
    private final By COLORS = By.xpath(".//label[contains(@class, 'layered_color')]/a");
    private static final Logger LOGGER = LogManager.getLogger(AutomationPractice.class);
    WebDriver browser;

    @Test
    public void PageClicking() {
        LOGGER.info("Opening browser");
        System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get(HOME_PAGE);

        LOGGER.info("Opening list of Elements and clicking button");
        tabWomenByName("WOMEN").click();


        LOGGER.info("Dresses button click ");
        subCategoryByName("DRESSES").click();


        LOGGER.info("Choosing color 'Orange and clicking'");
        WebDriverWait wait = new WebDriverWait(browser, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(COLORS));

       List <WebElement> orange = browser.findElements(COLORS);
        orange.get(3).click();
   //     borderOfColoursByName("Orange").click();

    }

    private WebElement tabWomenByName(String name) {
        List<WebElement> tabWomanCategory = browser.findElements(ARTICLES);
        for (int i = 0; i < tabWomanCategory.size(); i++) {
            WebElement element = tabWomanCategory.get(i);
            if (element.getText().equals(name)) {
                return element;
            }
        }
        return null;
    }

    private WebElement subCategoryByName(String name) {
        List<WebElement> subCategoryDresses = browser.findElements(DRESSES);
        for (int i = 0; i < subCategoryDresses.size(); i++) {
            WebElement dresses = subCategoryDresses.get(i);
            if (dresses.getText().equals(name)) {
                return dresses;
            }
        }
        return null;
    }

//    private WebElement borderOfColoursByName(String name) {
//        List<WebElement> borderOfColours = browser.findElements(COLORS);
//        for (int i = 0; i < borderOfColours.size(); i++) {
//            WebElement color = borderOfColours.get(i);
//            if (color.getText().equals(name)) {
//                return color;
            }
     //   }
      //  return null;
  //  }

//    @AfterEach
//    public void browserClose() {
//        browser.close();
//    }
//}
