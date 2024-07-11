
import diplom.LoginUserObject;
import diplom.MainPageObject;
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

public class EnteranceOnUserRoomTest extends BaseConstractTest {
    private LoginUserObject loginUserObject;
    private MainPageObject mainPageObject;
    private CreateUserAPI createUserAPI;
    private String email;
    private String name;
    private String password;
    private final boolean expected = true;

    @Before
    @DisplayName("Подготовка данных и открытие формы")
    public void setUp() {
        getWebDriver();
        email = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
        password = RandomStringUtils.randomAlphabetic(10);
        name = RandomStringUtils.randomAlphabetic(10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPageObject = new MainPageObject(driver);
        mainPageObject.openMainPage();
        createUserAPI = new CreateUserAPI();
        createUserAPI.createUser(email, password, name);
    }


    @Test
    @DisplayName("Проверка отображения информации о залогиненом юзере в личном кабинете")
    public void loginOnButtonUserRoom(){
        loginUserObject = new LoginUserObject(driver);
        loginUserObject.clickButtonPersonalArea();
        loginUserObject.inputEmailUser(email);
        loginUserObject.inputPasswordUser(password);
        loginUserObject.clickEnterButton();
        loginUserObject.clickButtonPersonalArea();
        boolean actual = loginUserObject.isDisplayedUserData();
        assertEquals(expected, actual);
        loginUserObject.leaveAccount();
    }

    @After
    @DisplayName("Закрытие браузера и удаление юзера")
    public void deleteUserAndCloseBrowser() {
        String response = new CreateUserAPI()
                .loginUser(email, password)
                .extract().body()
                .path("accessToken");
        if (response != null){
            new CreateUserAPI().deleteUser(response);
        }
        driver.quit();
    }
}
