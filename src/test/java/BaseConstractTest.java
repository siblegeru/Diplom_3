

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class BaseConstractTest {
    protected WebDriver driver;
    private String browserItem;
    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";

    public WebDriver getWebDriver() {
        if (browserItem == null) {
            browserItem = "chrome";
        }
        WebDriver driver;
        switch (browserItem) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "/Users/siblegeru/Downloads/chromedriver-mac-arm64/chromedriver");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "/Applications/Yandex.app/Contents/MacOS/Yandex");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            default:
                throw new RuntimeException("Некорректный браузер");
        }
        return driver;
    }

}
