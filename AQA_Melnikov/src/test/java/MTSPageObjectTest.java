import AQA11.pages.MTSPageObject;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.util.Arrays;

public class MTSPageObjectTest {
    WebDriver driver;
    MTSPageObject mainPage;

    public MTSPageObjectTest(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        System.out.println("Перед каждым тестом");
        driver = DriverHandler.getConfiguratedDriver();
        mainPage = new MTSPageObject(driver);
        mainPage.handleCookie();
    }

    @AfterEach
    void closeBrowserWindow() {
        System.out.println("Закрываю окно");
        driver = DriverHandler.terminateDriver(driver);
        mainPage = null;
    }

    @Disabled
    @Test
    @DisplayName("Плейсхолдеры интернет")
    void payInternetFormTest(){
        int option = 1;
        String [] expected = {"Номер абонента","Сумма","E-mail для отправки чека"};
        String[] result = getPlaceholdersArray(option);
        Assertions.assertEquals(expected, result);
    }

    @Disabled
    @Test
    @DisplayName("Плейсхолдеры рассрочка")
    void payInstalmentFormTest(){
        int option = 2;
        String [] expected = {"Номер счета на 44","Сумма","E-mail для отправки чека"};
        String[] result = getPlaceholdersArray(option);
        Assertions.assertEquals(expected, result);
    }

    @Disabled
    @Test
    @DisplayName("Плейсхолдеры мобильная связь")
    void payConnectionFormTest(){
        int option = 0;
        String [] expected = {"Номер телефона","Сумма","E-mail для отправки чека"};
        String[] result = getPlaceholdersArray(option);
        Assertions.assertEquals(expected, result);
    }

    @Disabled
    @Test
    @DisplayName("Плейсхолдеры задолженность")
    void payArrearsFormTest(){
        int option = 3;
        String [] expected = {"Номер счета на 2073","Сумма","E-mail для отправки чека"};
        String[] result = getPlaceholdersArray(option);
        Assertions.assertEquals(expected, result);
    }

    private String[] getPlaceholdersArray(int option) {
        mainPage.pickPaymentType(option);
        String [] result = mainPage.getPaymentPlaceholders(option).toArray(new String[0]);
        System.out.println(Arrays.toString(result));
        return result;
    }

    @Disabled
    @Test
    @DisplayName("Проверка заголовка оплаты")
    void testPayTitle(){
        System.out.println("Проверка заголовка оплаты");
        Assertions.assertTrue("Онлайн пополнение\nбез комиссии".equals(mainPage.getPayTitleText())
                && mainPage.lastPickedElementDisplayed());
    }

    @Disabled
    @Test
    @DisplayName("Проверка лого платежных систем")
    void testPaymentLogos(){
        System.out.println("Тест логотипов платежных систем");
        boolean result = mainPage.checkLogoVisibility(MTSPageObject.LogoContainers.PAYMENT_SECTION,5);
        Assertions.assertTrue(result);
    }

    //@Disabled
    @Test
    @DisplayName("Ссылка \"Подробнее о сервисе\"")
    void testAboutLink(){
        System.out.println("Проверка ссылки \"Подробнее о сервисе\"");
        mainPage.followLink (MTSPageObject.Links.ABOUT_SERVICE);
        Assertions.assertEquals(driver.getTitle(), "Порядок оплаты и безопасность интернет платежей");
    }

    //@Disabled
    @Test
    @DisplayName("Проверка оплаты")
    void testPayment(){
        System.out.println("Проверка работоспособности оплаты");
        final String MOCK_PHONE = "297777777";
        final String PAYMENT = "1";

        mainPage.replenishAccount(MOCK_PHONE,PAYMENT);
        Assertions.assertTrue(mainPage.lastPickedElementDisplayed());
        Assertions.assertEquals(mainPage.getLastPickedElementTag(), "iframe");
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
        Assertions.assertTrue(result);
        makeScreenshot();
    }

    @Attachment(value = "Attachment Screenshot", type = "image/png")
    public byte[] makeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
