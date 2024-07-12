import diplom.MainPageObject;

import diplom.UserData;
import diplom.api.CreateUserAPI;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.chrome.ChromeDriver;



import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


public class CreateNewUserTest extends BaseConstractTest {
    MainPageObject mainPageObject;
    private String email;
    private String name;
    private String password;
    private final boolean expected = true;
    UserData userData;

    @Before
    @DisplayName("Подготовка данных и открытие формы")
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");

        //driver = getWebDriver();
        email = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
        password = RandomStringUtils.randomAlphabetic(10);
        name = RandomStringUtils.randomAlphabetic(10);
        userData = new UserData(name, email, password);
        mainPageObject = new MainPageObject(driver);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        mainPageObject.openMainPage();
        mainPageObject.buttonForFormLoginOnMainPage();

    }



    @Test
    @DisplayName("Создание пользователя через UI")
    public void checkCreateUserTest() {
        mainPageObject.isDisplaidFormLogin();
        mainPageObject.buttonFormRegistratedNewUser();
        mainPageObject.registrNewUser(email, password, name);

    }

    @Test
    @DisplayName("Проверка отображения ошибки при некорректном пароле")
    public void checkCreateUserWhithSmallPasswordTest() {
        mainPageObject.buttonFormRegistratedNewUser();
        mainPageObject.registrNewUser(email, name, "wtcb");
        assertEquals(expected, mainPageObject.isDisplaidFailInputPassword());
    }

    @After
    @DisplayName("Закрытие браузера и удаление юзера")
    public void deleteUserAndCloseBrowser() {
        String response = new CreateUserAPI()
                .loginUser(userData)
                .extract().body()
                .path("accessToken");
        if (response != null){
            new CreateUserAPI().deleteUser(response);
        }
        driver.quit();
    }
}
