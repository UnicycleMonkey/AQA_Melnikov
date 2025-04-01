import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverHandler {
    public static WebDriver getConfiguratedDriver() {
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        return driver;
    }

    public static WebDriver terminateDriver(WebDriver driver) {
        if(driver!=null){
            driver.quit();
        }
        return null;
    }
}
