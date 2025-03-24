
import AQA08.pages.MTSMainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
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
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        System.out.println("Перед каждым тестом");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        explicitWait(1000);
        handleCookie();
    }

    @AfterEach
    void closeBrowserWindow() {
        System.out.println("Закрываю окно");
        driver.quit();
        driver=null;
    }


    @Test
    @Description("Проверка заголовка оплаты")
    void testPayTitle(){
        WebElement we = driver.findElement(By.xpath("//div[@class='pay__wrapper']/h2"));
        String str = we.getText();
        Assert.assertTrue(we.isDisplayed());
        Assert.assertEquals(str, "Онлайн пополнение\nбез комиссии");
    }


    @Test
    @Description("Проверка лого платежных систем")
    void testPaymentLogos(){
        System.out.println("тест логотипов");
        boolean result = true;
        for (int i = 1; i <= 5; i++) {
            result= result && tryToFind(mainPage.getPaymentSystemLogo(i));
        }
        Assert.assertTrue(result);
    }


    @Test
    @Description("Ссылка \"Подробнее о сервисе\"")
    void testAboutLink(){
        System.out.println("Проверка ссылки \"Подробнее о сервисе\"");
        WebElement linkAbout = driver.findElement(mainPage.getAboutServiceLink());
        linkAbout.click();
        Assert.assertEquals(driver.getTitle(), "Порядок оплаты и безопасность интернет платежей");
    }

    @Test
    @Description("Проверка оплаты")
    void testPayment(){
        System.out.println("Проверка работоспособности оплаты");
        final String MOCK_PHONE = "297777777";
        final String PAYMENT = "1";

        WebElement inputPhone = driver.findElement (mainPage.getInputPhone());
        WebElement inputPayment = driver.findElement (mainPage.getInputPayment());
        WebElement proceedButton = driver.findElement (mainPage.getProceedPaymentButton());

        inputPhone.sendKeys(MOCK_PHONE+Keys.ENTER);
        inputPayment.sendKeys(PAYMENT);
        proceedButton.click();
        explicitWait(5000);

        Assert.assertTrue(driver.findElement (mainPage.getIframePaymentConfirmation()).isEnabled());

    }

    private static void explicitWait(int ms) {
        try{
            Thread.sleep(ms);
            System.out.println("Жду "+ms+" мс");
        }
        catch (InterruptedException e){
            System.out.println("Что-то сломалось во время ожидания: "+e.getMessage());
        }
    }

    private boolean tryToFind(By byXPass) {
        boolean result = true;
        System.out.println("Ищу "+byXPass);
        try {
            driver.findElement(byXPass);
        } catch (NoSuchElementException e) {
            result =false;
            System.out.println("Не нашел "+byXPass);
        }
        return result;
    }

    private void handleCookie() {
        try {
            System.out.println("жду окошко с куками");
            WebElement acceptCookieButton = driver.findElement(mainPage.getAcceptCookieButton());
            if(acceptCookieButton.isEnabled()) {
                acceptCookieButton.click();
                System.out.println("Тыкнул в 'принять'");
            }
        }catch (ElementNotInteractableException e){
            System.out.println("Окошка не было");
        }
        explicitWait(500);
    }
}
