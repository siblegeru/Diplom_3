import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseConstractTest {
    protected WebDriver driver;

    private final String LOGIN_USER = "ultima@yandex.ru";
    private final String PASSWORD_USER = "ultima1234";
    private final String NAME_USER = "ultima";

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
    }
    //для ЯндексБраузера
//    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
//        ChromeOptions options = new ChromeOptions();
//        options.setBinary("path/to/yandex-browser.exe");
//        driver = new ChromeDriver(options);
//        driver.get("https://yandex.ru/");
//    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

}
