package AQA08.pages;

public class MTSMainPage {
    private final String acceptCookieButtonXPath = "//*[@id='cookie-agree']";
    private final String payContinueButtonXPath = "//*[@id=\"pay-connection\"]/button";
    private final String payPhoneInputXPath = "//*[@id=\"connection-phone\"]";

    public String getAcceptCookieButtonXPath(){
        return acceptCookieButtonXPath;
    }

    public String getPayContinueButtonXPath() {
        return payContinueButtonXPath;
    }

    public String getPayPhoneInputXPath() {
        return payPhoneInputXPath;
    }
}
