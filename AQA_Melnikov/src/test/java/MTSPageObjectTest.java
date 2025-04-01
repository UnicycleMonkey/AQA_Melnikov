import AQA11.pages.MTSPageObject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import java.time.Duration;
import java.util.Arrays;
import io.qameta.allure.Description;

public class MTSPageObjectTest {
    WebDriver driver;
    MTSPageObject mainPage;

    public MTSPageObjectTest(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        System.out.println("Перед каждым тестом");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        mainPage = new MTSPageObject(driver);
        mainPage.handleCookie();
    }

    @AfterEach
    void closeBrowserWindow() {
        System.out.println("Закрываю окно");
        driver.quit();
        driver = null;
        mainPage = null;
    }

  //  @Disabled
    @Test
    @DisplayName("Плейсхолдеры интернет")
    void payInternetFormTest(){
        int option = 1;
        String [] expected = {"Номер абонента","Сумма","E-mail для отправки чека"};
        String[] result = getPlaceholdersArray(option);
        Assert.assertEquals(expected,result);
    }

   // @Disabled
    @Test
    @DisplayName("Плейсхолдеры рассрочка")
    void payInstalmentFormTest(){
        int option = 2;
        String [] expected = {"Номер счета на 44","Сумма","E-mail для отправки чека"};
        String[] result = getPlaceholdersArray(option);
        Assert.assertEquals(expected,result);
    }

   // @Disabled
    @Test
    @DisplayName("Плейсхолдеры мобильная связь")
    void payConnectionFormTest(){
        int option = 0;
        String [] expected = {"Номер телефона","Сумма","E-mail для отправки чека"};
        String[] result = getPlaceholdersArray(option);
        Assert.assertEquals(expected,result);
    }

   // @Disabled
    @Test
    @DisplayName("Плейсхолдеры задолженность")
    void payArrearsFormTest(){
        int option = 3;
        String [] expected = {"Номер счета на 2073","Сумма","E-mail для отправки чека"};
        String[] result = getPlaceholdersArray(option);
        Assert.assertEquals(expected,result);
    }

    private String[] getPlaceholdersArray(int option) {
        mainPage.pickPaymentType(option);
        String [] result = mainPage.getPaymentPlaceholders(option).toArray(new String[0]);
        System.out.println(Arrays.toString(result));
        return result;
    }

    @Test
    @DisplayName("Проверка заголовка оплаты")
    void testPayTitle(){
        System.out.println("Проверка заголовка оплаты");
        Assert.assertTrue("Онлайн пополнение\nбез комиссии".equals(mainPage.getPayTitleText())
                && mainPage.lastPickedElementDisplayed());
    }

   // @Disabled
    @Test
    @DisplayName("Проверка лого платежных систем")
    void testPaymentLogos(){
        System.out.println("Тест логотипов платежных систем");
        boolean result = mainPage.checkLogoVisibility(MTSPageObject.LogoContainers.PAYMENT_SECTION,5);
        Assert.assertTrue(result);
    }

   // @Disabled
    @Test
    @DisplayName("Ссылка \"Подробнее о сервисе\"")
    void testAboutLink(){
        System.out.println("Проверка ссылки \"Подробнее о сервисе\"");
        mainPage.followLink (MTSPageObject.Links.ABOUT_SERVICE);
        Assert.assertEquals (driver.getTitle(), "Порядок оплаты и безопасность интернет платежей");
    }

    //@Disabled
    @Test
    @DisplayName("Проверка оплаты")
    void testPayment(){
        System.out.println("Проверка работоспособности оплаты");
        final String MOCK_PHONE = "297777777";
        final String PAYMENT = "1";

        mainPage.replenishAccount(MOCK_PHONE,PAYMENT);
        Assert.assertTrue(mainPage.lastPickedElementDisplayed());
        Assert.assertEquals(mainPage.getLastPickedElementTag(),"iframe");
    }

    @Disabled
    @Test
    @DisplayName("Проверка окна подтверждения платежа")
    void testPaymentConfirmationFrame(){
        System.out.println("Проверка иконок платежных систем в окне подтверждения");
        final String MOCK_PHONE = "297777777";
        final String PAYMENT = "1";
        mainPage.replenishAccount(MOCK_PHONE,PAYMENT);
        driver.switchTo().frame(0);
        boolean result = mainPage.checkLogoVisibility(MTSPageObject.LogoContainers.PROCEED_FRAME,4);
        System.out.println(result);
        Assert.assertTrue(true);
    }
}
