import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseConstractTest {
    protected WebDriver driver;
    private String browserItem;

    public BaseConstractTest() {
        this.browserItem = System.getProperty("browser");
    }

    // Запуск тестов с Chrome: mvn clean test -Dbrowser=chrome
    // Запуск тестов с Yandex: mvn clean test -Dbrowser=yandex
    public WebDriver getWebDriver() {
        if (browserItem == null) {
            browserItem = "chrome";
        }
        WebDriver driver;
        switch (browserItem) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "/path/to/yandexdriver");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            default:
                throw new RuntimeException("Некорректный браузер");
        }
        return driver;
    }
}