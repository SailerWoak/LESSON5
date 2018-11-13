package BaseFunk.AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AutomationHomePage {
    BaseFunk baseFunk;
    private final By ARTICLES = By.xpath(".//ul[contains(@class, 'menu-content')]/li/a");

    public AutomationHomePage(BaseFunk baseFunk){
        this.baseFunk = baseFunk;
    }
    public WebElement tabWomenByName(String name) {
        List<WebElement> tabWomanCategory = baseFunk.browser.findElements(ARTICLES);
        for (int i = 0; i < tabWomanCategory.size(); i++) {
            WebElement element = tabWomanCategory.get(i);
            if (element.getText().equals(name)) {
                return element;
            }
        }
        return null;
    }
}
