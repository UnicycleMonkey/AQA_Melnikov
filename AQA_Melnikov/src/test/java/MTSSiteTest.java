
import AQA08.pages.MTSMainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class MTSSiteTest {
    private final String URL = "https://mts.by";
    WebDriver driver;
    MTSMainPage mainPage;

    public MTSSiteTest(){
        mainPage = new MTSMainPage();
    }

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.get(URL);
        explicitWait(1000);
        WebElement acceptCookieButton = driver.findElement(By.xpath(mainPage.getAcceptCookieButtonXPath()));
        acceptCookieButton.click();
        explicitWait(1000);
    }

    @AfterEach
    void closeBrowserWindow() {
        driver.quit();
        driver=null;
    }

    @Test
    void test() {
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("МТС – мобильный оператор в Беларуси"));
    }

    @Test
    void testPayTitle(){
        Assert.assertTrue(tryToFind("//h2[contains(text(),'Онлайн пополнение']"));
    }

    private boolean tryToFind(String xPath) {
        boolean result = true;
        try {
            WebElement we = driver.findElement(By.xpath(xPath));
        } catch (NoSuchElementException e) {
            result =false;
        }
        return result;
    }

    @Test
    void testPaymentLogos(){


    }

    private static void explicitWait(int ms) {
        try{
            Thread.sleep(ms);
        }
        catch (InterruptedException e){
        }
    }
}
