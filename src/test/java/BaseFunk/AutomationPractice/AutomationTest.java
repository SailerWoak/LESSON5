package BaseFunk.AutomationPractice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class AutomationTest {
    private BaseFunk baseFunk = new BaseFunk();
    private final String HOME_PAGE = "http://automationpractice.com/index.php";
    private final By CORRECT_COLOR = By.xpath(".//div[@id = 'enabled_filters']/ul/li");
    private final By DRESS = By.xpath(".//div[@id='center_column']/ul/li");
    private static final Logger LOGGER = LogManager.getLogger(AutomationTest.class);


    @Test
    public void testChecking() {
        LOGGER.info("Opening browser");
        baseFunk.goToPage(HOME_PAGE);
        AutomationHomePage homePage = new AutomationHomePage(baseFunk);

        LOGGER.info("Opening list of Elements and clicking button");
        homePage.tabWomenByName("WOMEN").click();
        LOGGER.info("Dresses button click ");
        homePage.subCategoryByName("DRESSES");
        LOGGER.info("Choosing color 'Orange and clicking'");
        homePage.borderOfColoursByName(3).click();
        baseFunk.waiter(CORRECT_COLOR);
        String matchingOrangeColor = baseFunk.getElement(CORRECT_COLOR).getText();
        Assertions.assertTrue("Color: Orange".contains(matchingOrangeColor), "Color match");
        LOGGER.info("Choosing first dress");
        baseFunk.waiter(DRESS);
        homePage.choosingDressesById(1).click();

    }
}
