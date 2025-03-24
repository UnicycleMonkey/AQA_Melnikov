package AQA08.pages;

import org.openqa.selenium.By;

public class MTSMainPage {
    private String acceptCookieButtonXPath = "//*[@id='cookie-agree']";
    private String paymentSystemsLogoUlXPath = "//*[@class='pay__partners']/ul/";
    private String aboutServiceLinkXPath = "//*[@id='pay-section']//a[text()='Подробнее о сервисе']";
    private String inputPhoneXPath = "//*[@id='connection-phone']";
    private String inputPaymentXPath = "//*[@id='connection-sum']";
    private String proceedPaymentButtonXPath = "//*[@id='pay-connection']/button[@class='button button__default ']";
    private String iframePaymentConfirmationXPath = "//div[@class='bepaid-app']/div/iframe";

    public By getAcceptCookieButton(){
        return By.xpath(acceptCookieButtonXPath);
    }

    public By getPaymentSystemsLogoUl(){
        return By.xpath(paymentSystemsLogoUlXPath);
    }

    public By getPaymentSystemLogo(int i){
        return By.xpath(paymentSystemsLogoUlXPath+"li["+i+"]");
    }

    public By getAboutServiceLink() {
        return By.xpath(aboutServiceLinkXPath);
    }

    public By getInputPhone() {
        return By.xpath(inputPhoneXPath);
    }

    public By getInputPayment(){
        return By.xpath(inputPaymentXPath);
    }

    public By getProceedPaymentButton(){
        return By.xpath(proceedPaymentButtonXPath);
    }

    public By getIframePaymentConfirmation(){
        return By.xpath(iframePaymentConfirmationXPath);
    }
}
