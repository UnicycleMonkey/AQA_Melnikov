package AQA11.pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MTSPageObject {
    private final static String url = "https://mts.by";
    private final static String payTitleLabelXPath = "//div[@class='pay__wrapper']/h2";
    private final static String acceptCookieButtonXPath = "//*[@id='cookie-agree']";
    private final static String aboutServiceLinkXPath = "//*[@id='pay-section']//a[text()='Подробнее о сервисе']";
    private final static String inputPhoneXPath = "//*[@id='connection-phone']";
    private final static String inputPaymentXPath = "//*[@id='connection-sum']";
    private final static String proceedPaymentButtonXPath = "//*[@id='pay-connection']/button[@class='button button__default ']";
    private final static String iframePaymentConfirmationXPath = "//div[@class='bepaid-app']/div/iframe";
    private final static String paymentSystemsLogoUlXPath = "//*[@class='pay__partners']/ul/";
    private final static String paymentSystemsLogoContainerXPath = "//*[@class='cards-brands cards-brands__container " +
            "ng-tns-c891095944-0 ng-trigger ng-trigger-brandsState ng-star-inserted']";
    private final static String paymentTypeDropdownXPath="//*[@class='select__list']";
    private final static String getPaymentTypeButtonXPath = "//*[@class='select__header']";
    private final static int PAYMENT_TYPES_QUANTITY = 4;

    private final WebDriver driver;
    private WebElement lastPickedElement;

    public enum Links {
        ABOUT_SERVICE(aboutServiceLinkXPath);
        private final String xPath;

        Links(String xPath) {
            this.xPath = xPath;
        }
    }

    public enum LogoContainers {
        PAYMENT_SECTION(paymentSystemsLogoUlXPath),
        PROCEED_FRAME(paymentSystemsLogoContainerXPath);
        private final String xPath;

        LogoContainers(String xPath) {
            this.xPath = xPath;
        }
    }

    public enum PaymentTypeForms{
        PAY_CONNECTION("//*[@id='pay-connection']"),
        PAY_INTERNET("//*[@id='pay-internet']"),
        PAY_INSTALMENT("//*[@id='pay-instalment']"),
        PAY_ARREARS("//*[@id='pay-arrears']");
        private final String xPath;

        PaymentTypeForms(String xPath) {
            this.xPath = xPath;
        }

        public String getXPath(int num){
            if(num<0 || num>=PaymentTypeForms.values().length){
                throw new IllegalArgumentException();
            }
            String result = "";
            switch (num){
                case 0:
                    result =  PAY_CONNECTION.xPath;
                    break;
                case 1:
                    result =  PAY_INTERNET.xPath;
                    break;
                case 2:
                    result =  PAY_INSTALMENT.xPath;
                    break;
                case 3:
                    result =  PAY_ARREARS.xPath;
            }
            return result;
        }
    }

    public MTSPageObject(WebDriver driver){
        this.driver=driver;
        driver.get(url);
    }

    public void followLink(Links link){
        driver.findElement(By.xpath(link.xPath)).click();
    }

    public void pickPaymentType(int option){
        if (option < 0 || option >= PAYMENT_TYPES_QUANTITY){
            throw  new IllegalArgumentException();
        }
        driver.findElement(By.xpath(getPaymentTypeButtonXPath)).click();
        explicitWait(500);
        driver.findElement(By.xpath(paymentTypeDropdownXPath+"/*["+(option+1)+"]")).click();
    }

    public ArrayList <String> getPaymentPlaceholders(int option){
        List <WebElement> inputs =  driver.findElements(
                By.xpath(PaymentTypeForms.PAY_CONNECTION.getXPath(option)+"//input"));
        ArrayList<String> result = new ArrayList<>();
        for(WebElement we: inputs){
            result.add(we.getDomProperty("placeholder"));
        }
        return result;
    }

    public boolean checkLogoVisibility(LogoContainers container, int quantity){
        boolean result = true;
        try {
            for (int i = 1; i <= quantity; i++) {
                result= result && driver.findElement(By.xpath(container.xPath+"/*["+i+"]")).isDisplayed();
            }
        }catch (NoSuchElementException e){
            System.out.println("Элемент не найден! "+e.getMessage());
            return false;
        }
        return result;
    }

    public boolean lastPickedElementDisplayed(){
        if (lastPickedElement == null){
            return false;
        }
        return lastPickedElement.isDisplayed();
    }

    public String getLastPickedElementTag(){
        if (lastPickedElement == null){
            return "";
        }
        return lastPickedElement.getTagName();
    }

    public void replenishAccount(String phoneNumber, String amount) {
        WebElement inputPhone = driver.findElement (By.xpath(inputPhoneXPath));
        WebElement inputPayment = driver.findElement (By.xpath(inputPaymentXPath));
        WebElement proceedButton = driver.findElement (By.xpath(proceedPaymentButtonXPath));

        inputPhone.sendKeys(phoneNumber);
        inputPayment.sendKeys(amount);
        proceedButton.click();
        lastPickedElement = waitForElementDisplayed(iframePaymentConfirmationXPath, 6000);
        explicitWait(2000); //так и не осилил, чтобы успевало появиться без этого костыля
        System.out.println(lastPickedElement.getTagName());
    }

    public String getPayTitleText(){
        lastPickedElement = driver.findElement(By.xpath(payTitleLabelXPath));
        return lastPickedElement.getText();
    }

    public void handleCookie() {
        try {
            System.out.println("жду окошко с куками");
            WebElement acceptCookieButton = driver.findElement(By.xpath(acceptCookieButtonXPath));
            if(acceptCookieButton.isEnabled()) {
                acceptCookieButton.click();
                System.out.println("Тыкнул в 'принять'");
            }
        }catch (ElementNotInteractableException e){
            System.out.println("Окошка не было");
        }
    }

    private WebElement waitForElementDisplayed (String xPath, long timeout){
        WebElement we = null;
        try {
             we = (new WebDriverWait(driver, Duration.ofMillis(timeout)))
                     .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
        }
        catch (TimeoutException te){
            System.out.println("Не дождался =( "+te.getMessage());
        }
        return we;
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
}


