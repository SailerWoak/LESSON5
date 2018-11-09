import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class Practice {
    private final By ARTICLE = By.xpath(".//div[@class = 'row']/article/div/span");
    private final By ARTICLE_TITLE = By.xpath(".//a[@class = 'text-mine-shaft']");
    private final By COMMENT_COUNT = By.xpath(".//a[contains(@class, 'text-red-ribbon')]");
    private final By ARTICLE_PAGE = By.xpath(".//span[@itemprop = 'headline name']");
    private final By COMMENT_PAGE = By.xpath(".//a[@class = 'comment-main-title-link']");
    private final By REG_COMMENTS = By.xpath(".//a[contains(@class,'comment-thread-switcher-list-a-reg')]/span");
    private final By ANON_COMMENTS = By.xpath(".//a[contains(@class,'comment-thread-switcher-list-a-anon')]/span");
    WebDriver driver;

    @Test
    public void delfiPractice() {

        System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://rus.delfi.lv/");

        String articleTitle = articles(1).findElement(ARTICLE_TITLE).getText();
        String commentString = articles(1).findElement(COMMENT_COUNT).getText();
        removeBrackets(commentString);

        String articlePageTitle = driver.findElement(ARTICLE_PAGE).getText();
        Assertions.assertEquals(articleTitle, articlePageTitle, "Articles not equal");

        String articlePageComment = driver.findElement(COMMENT_COUNT).getText();
        removeBrackets(articlePageComment);
        Assertions.assertEquals(commentString, articlePageComment, "Comments in article page not Equal");
        driver.findElement(COMMENT_COUNT).click();

        String commentPageTitle = driver.findElement(COMMENT_PAGE).getText();
        Assertions.assertTrue(commentPageTitle.contains(articleTitle));

        String regComment = driver.findElement(REG_COMMENTS).getText();
        removeBrackets(regComment);

        String anonComment = driver.findElement(ANON_COMMENTS).getText();
        removeBrackets(anonComment);
        String sum = regComment + anonComment;

        Assertions.assertEquals(commentString, sum, "Comments not equal");
    }
    private static Integer removeBrackets(String c) {
        return Integer.valueOf(c, c.length() - 1);
    }
    private WebElement articles(int count) {
        List<WebElement> articles = driver.findElements(ARTICLE);
        for (int i = 0; i < articles.size(); i++) {
            WebElement article = articles.get(i);
            if (article.getText().equals(count)) {
                return article;
            }
        }
        return null;
    }
}
