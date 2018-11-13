package BaseFunk.AutomationPractice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AutomationTest {
    private BaseFunk baseFunk = new BaseFunk();
    private final String HOME_PAGE  = "http://automationpractice.com/index.php";
    private static final Logger LOGGER = LogManager.getLogger(AutomationTest.class);
    @Test
    public AutomationHomePage testChecking(){
        LOGGER.info("Opening browser");
        baseFunk.goToPage(HOME_PAGE);
        AutomationHomePage homePage = new AutomationHomePage(baseFunk);

        LOGGER.info("Opening list of Elements and clicking button");
       homePage.tabWomenByName("WOMEN").click();
       return new AutomationHomePage(baseFunk);
    }
}
