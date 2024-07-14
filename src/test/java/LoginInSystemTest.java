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

public class LoginInSystemTest extends BaseConstractTest{
    private LoginUserObject loginUserObject;
    private String email;
    private String name;
    private String password;
    private final boolean expected = true;
    MainPageObject mainPageObject;
    CreateUserAPI createUserAPI;
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

    @DisplayName("Вход по кнопке Личный кабинет")
    @Test
    public void loginOnButtonUserRoom(){
        loginUserObject = new LoginUserObject(driver);
        loginUserObject.clickButtonPersonalArea();
        loginUserObject.inputEmailUser(email);
        loginUserObject.inputPasswordUser(password);
        loginUserObject.clickEnterButton();
        boolean actual = loginUserObject.displayadButtonCreateUserOrder();
        assertEquals(expected, actual);
        loginUserObject.leaveAccount();
    }
    @Test
    @DisplayName("Вход по кнопке Войти в Аккаунт")
    public void loginOnButtonGoToAccount(){
        loginUserObject = new LoginUserObject(driver);
        loginUserObject.clickButtonToGoToAccount();
        loginUserObject.inputEmailUser(email);
        loginUserObject.inputPasswordUser(password);
        loginUserObject.clickEnterButton();
        boolean actual = loginUserObject.displayadButtonCreateUserOrder();
        assertEquals(expected, actual);
        loginUserObject.leaveAccount();
        mainPageObject.isDisplaidFormLogin();
    }
    @Test
    @DisplayName("Вход через ссылку на форме регистрации")
    public void loginOnRegistrFormLink(){
        loginUserObject = new LoginUserObject(driver);
        loginUserObject.goToRegistrFormLink();
        loginUserObject.clickButtonOnRegistrForm();
        loginUserObject.inputEmailUser(email);
        loginUserObject.inputPasswordUser(password);
        loginUserObject.clickEnterButton();
        boolean actual = loginUserObject.displayadButtonCreateUserOrder();
        assertEquals(expected, actual);
        loginUserObject.leaveAccount();
    }
    @Test
    @DisplayName("Вход через ссылку на форме Восстановление пароля")
    public void loginOnFormReconPassword(){
        loginUserObject = new LoginUserObject(driver);
        loginUserObject.clickButtonPersonalArea();
        loginUserObject.goToFormReconPassword();
        loginUserObject.inputEmailUser(email);
        loginUserObject.inputPasswordUser(password);
        loginUserObject.clickEnterButton();
        boolean actual = loginUserObject.displayadButtonCreateUserOrder();
        assertEquals(expected, actual);
        loginUserObject.leaveAccount();
    }

    @Test
    @DisplayName("Проверка выхода из аккаунта")
    public void reloginAccount(){
        loginUserObject = new LoginUserObject(driver);
        loginUserObject.clickButtonToGoToAccount();
        loginUserObject.inputEmailUser(email);
        loginUserObject.inputPasswordUser(password);
        loginUserObject.clickEnterButton();
        loginUserObject.leaveAccount();
        mainPageObject.isDisplaidFormLogin();
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
