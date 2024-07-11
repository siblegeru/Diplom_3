package diplom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class MainPageObject extends BaseConstract {


    //pageObject для формы регистрации
    private final By isDisplayLoginForm = By.xpath(".//div[@class = 'Auth_login__3hAey']");
    private final By ownerCabineOnMainPage = By.xpath(".//p[text()='Личный Кабинет']");
    private final By buttonForRegistrNewUser = By.xpath(".//a[@href = '/register']");
    private final By filedInputNameNewUser = By.xpath(".//label[text()='Имя']/../input[@class='text input__textfield text_type_main-default']");
    private final By filedInputPasswordNewUser = By.xpath(".//label[text()='Пароль']/../input[@class='text input__textfield text_type_main-default']");
    private final By filedInputEmailNewUser = By.xpath(".//label[text()='Email']/../input[@class='text input__textfield text_type_main-default']");
    private final By buttonRegistrNewUser = By.xpath(".//button[text() = 'Зарегистрироваться']");
    private final By failInputPassword = By.xpath(".//p[text() = 'Некорректный пароль']");
    private static final String BASE_URI = "https://stellarburgers.nomoreparties.site/";

    public MainPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    @Step("Открыть главную страницу сервиса")
    public MainPageObject openMainPage() {
         driver.get(BASE_URI);
        return this;
    }

    @Step("Клик по кнопке Личный кабинет")
    public void buttonForFormLoginOnMainPage() {
        driver.findElement(ownerCabineOnMainPage).click();
    }
    @Step("Клик по ссылке Регистрация")
    public void buttonFormRegistratedNewUser() {
        driver.findElement(buttonForRegistrNewUser).click();
    }
    @Step("Ввод поля Email")
    public void inputEmailFiled(String email) {
        driver.findElement(filedInputEmailNewUser).sendKeys(email);
    }
    @Step("Ввод поля Имя")
    public void inputNameFiled(String name) {
        driver.findElement(filedInputNameNewUser).sendKeys(name);
    }
    @Step("Ввод поля Password")
    public void inputPasswordFiled(String password) {
        driver.findElement(filedInputPasswordNewUser).sendKeys(password);
    }
    @Step("Клик по кнопке Регистрация на форме регистрации пользователя")
    public void clickOnButtonRegistration() {
        driver.findElement(buttonRegistrNewUser).click();
    }
    @Step("Выполнение регистрации пользователя")
    public void registrNewUser(String email, String name, String password){
        inputEmailFiled(email);
        inputPasswordFiled(password);
        inputNameFiled(name);
        clickOnButtonRegistration();
    }
    @Step("Метод проверки открытия формы логирования")
    public boolean isDisplaidFormLogin(){
        return driver.findElement(By.xpath(".//h2[text() = 'Вход']")).isDisplayed();
    }
    @Step("Отображение ошибки при некорректном пароле(меньше 6 символов) при регистрации")
    public boolean isDisplaidFailInputPassword(){
        return driver.findElement(failInputPassword).isDisplayed();
    }
    @Step("Отображение формы логирования после выхода из аккаунта")
    public boolean isDisplaidLoginForm(){
        return driver.findElement(isDisplayLoginForm).isDisplayed();
    }


}
