import AQA09.pages.MTSPageObject;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

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

    @Disabled
    @Test
    @Description("мусорный тест для обкатки")
    void dummyTest(){
        System.out.println(mainPage.getTitle());
        System.out.println(driver.manage().timeouts().getPageLoadTimeout());
        System.out.println(driver.manage().timeouts().getImplicitWaitTimeout());
    }


    @Disabled
    @Test
    @Description("Проверка заголовка оплаты")
    void testPayTitle(){
        System.out.println("Проверка заголовка оплаты");
        Assert.assertTrue("Онлайн пополнение\nбез комиссии".equals(mainPage.getPayTitleText())
                && mainPage.lastPickedElementDisplayed());
    }

//    @Disabled
//    @Test
//    @Description("Проверка лого платежных систем")
//    void testPaymentLogos(){
//        System.out.println("Тест логотипов платежных систем");
//        boolean result = true;
//        for (int i = 1; i <= 5; i++) {
//            result= result && tryToFind(mainPage.getPaymentSystemLogo(i));
//        }
//        Assert.assertTrue(result);
//    }
//
//    @Disabled
//    @Test
//    @Description("Ссылка \"Подробнее о сервисе\"")
//    void testAboutLink(){
//        System.out.println("Проверка ссылки \"Подробнее о сервисе\"");
//        WebElement linkAbout = driver.findElement(mainPage.getAboutServiceLink());
//        linkAbout.click();
//        Assert.assertEquals(driver.getTitle(), "Порядок оплаты и безопасность интернет платежей");
//    }
//
//    @Disabled
//    @Test
//    @Description("Проверка оплаты")
//    void testPayment(){
//        System.out.println("Проверка работоспособности оплаты");
//        final String MOCK_PHONE = "297777777";
//        final String PAYMENT = "1";
//
//        WebElement inputPhone = driver.findElement (mainPage.getInputPhone());
//        WebElement inputPayment = driver.findElement (mainPage.getInputPayment());
//        WebElement proceedButton = driver.findElement (mainPage.getProceedPaymentButton());
//
//        inputPhone.sendKeys(MOCK_PHONE+ Keys.ENTER);
//        inputPayment.sendKeys(PAYMENT);
//        proceedButton.click();
//        explicitWait(5000);
//
//        Assert.assertTrue(driver.findElement (mainPage.getIframePaymentConfirmation()).isEnabled());
//
//    }
}
