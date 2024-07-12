import diplom.LoginUserObject;

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

public class LogoOrConstructorPerehodTest extends BaseConstractTest{
    private LoginUserObject loginUserObject;
    private MainPageObject mainPageObject;
    private CreateUserAPI createUserAPI;
    private String email;
    private String name;
    private String password;
    private final boolean expected = true;
    private UserData userData;

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
        userData = new UserData(name, email, password);
        createUserAPI = new CreateUserAPI();
        createUserAPI.createUser(userData);
    }

    @Test
    @DisplayName("Проверка перехода из ЛК кликом по лого")
    public void clickLogoLinkTest(){
        loginUserObject = new LoginUserObject(driver);
        loginUserObject.clickButtonToGoToAccount();
        loginUserObject.inputEmailUser(email);
        loginUserObject.inputPasswordUser(password);
        loginUserObject.clickEnterButton();
        loginUserObject.clickButtonPersonalArea();
        boolean actual = loginUserObject.isDisplayedClickLogo();
        assertEquals(expected, actual);
        loginUserObject.leaveAccount();
    }
    @Test
    @DisplayName("Проверка перехода из ЛК кликом по Конструктору")
    public void clickConstructorButtonTest(){
        loginUserObject = new LoginUserObject(driver);
        loginUserObject.clickButtonToGoToAccount();
        loginUserObject.inputEmailUser(email);
        loginUserObject.inputPasswordUser(password);
        loginUserObject.clickEnterButton();
        loginUserObject.clickButtonPersonalArea();
        boolean actual = loginUserObject.clickConstructor();
        assertEquals(expected, actual);
        loginUserObject.leaveAccount();
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
