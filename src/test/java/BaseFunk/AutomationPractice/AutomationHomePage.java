package BaseFunk.AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AutomationHomePage {
    BaseFunk baseFunk;
    private final By ARTICLES = By.xpath(".//ul[contains(@class, 'menu-content')]/li/a");
    private final By DRESSES = By.xpath(".//ul[@class = 'clearfix']/li/h5/a");
    private final By COLORS = By.xpath("//*[@id='ul_layered_id_attribute_group_3']/li/input");
    private final By CHOOSING_DRESSES = By.xpath(".//ul[contains(@class, 'product_list')]/li");

    public AutomationHomePage(BaseFunk baseFunk) {
        this.baseFunk = baseFunk;
    }

    public WebElement tabWomenByName(String name) {
        List<WebElement> tabWomanCategory = baseFunk.getElements(ARTICLES);
        for (int i = 0; i < tabWomanCategory.size(); i++) {
            WebElement element = tabWomanCategory.get(i);
            if (element.getText().equals(name)) {
                return element;
            }
        }
        return null;
    }

    public WebElement subCategoryByName(String name) {
        List<WebElement> subCategoryDresses = baseFunk.getElements(DRESSES);
        for (int i = 0; i < subCategoryDresses.size(); i++) {
            WebElement dresses = subCategoryDresses.get(i);
            if (dresses.getText().equals(name)) {
                return dresses;
            }
        }
        return null;
    }

    public WebElement borderOfColoursByName(Integer num) {
        baseFunk.waiter(COLORS);
        List<WebElement> borderOfColours = baseFunk.getElements(COLORS);
        for (int i = 0; i < borderOfColours.size(); i++) {
            WebElement color = borderOfColours.get(i);
            if (i == num) {
                return color;
            }
        }
        return null;
    }

    public WebElement choosingDressesById(Integer id) {
        List<WebElement> choosingDresses = baseFunk.getElements(CHOOSING_DRESSES);
        for (int i = 0; i < choosingDresses.size(); i++) {
            WebElement dress = choosingDresses.get(id);
            if (i == id) {
                return dress;
            }
        }
        return null;
    }
}
