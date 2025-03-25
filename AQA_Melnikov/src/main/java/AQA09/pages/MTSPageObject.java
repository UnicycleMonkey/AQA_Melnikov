package AQA09.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MTSPageObject {
    private String url = "https://mts.by";
    private String payTitleLabelXPath = "//div[@class='pay__wrapper']/h2";
    private String acceptCookieButtonXPath = "//*[@id='cookie-agree']";
    private String paymentSystemsLogoUlXPath = "//*[@class='pay__partners']/ul/";
    private String aboutServiceLinkXPath = "//*[@id='pay-section']//a[text()='Подробнее о сервисе']";
    private String inputPhoneXPath = "//*[@id='connection-phone']";
    private String inputPaymentXPath = "//*[@id='connection-sum']";
    private String proceedPaymentButtonXPath = "//*[@id='pay-connection']/button[@class='button button__default ']";
    private String iframePaymentConfirmationXPath = "//div[@class='bepaid-app']/div/iframe";

    private final WebDriver driver;
    private WebElement lastPickedElement;

    public MTSPageObject(WebDriver driver){
        this.driver=driver;
        driver.get(url);
    }

    public boolean lastPickedElementEnabled(){
        if (lastPickedElement == null){
            return false;
        }
        return lastPickedElement.isEnabled();
    }

    public boolean lastPickedElementDisplayed(){
        if (lastPickedElement == null){
            return false;
        }
        return lastPickedElement.isDisplayed();
    }

    public void replenishAccount(String phoneNumber, String amount){

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

    public String getTitle(){
        return driver.getTitle();
    }
}


