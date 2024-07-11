package diplom;

import diplom.api.CreateUserAPI;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginUserObject extends BaseConstract{

    public LoginUserObject(WebDriver driver) {
        super(driver);
    }
    //логотип
    private final By logoObject = By.xpath(".//div[@class = 'AppHeader_header__logo__2D0X2']");
    //конструктор
    private final By constructorObject = By.xpath(".//p[text() = 'Конструктор']");

    //для входа через Личный кабинет
    private final By ownerCabineOnMainPage = By.xpath(".//p[text() = 'Личный Кабинет']");

    //кнопка Войти в аккаунт
    private final By buttonGoToAccountOnMainPage = By.xpath(".//button[text() = 'Войти в аккаунт']");

    //кнопка войти на форме регистрации
    private final By buttonEntranceInFormRegistration = By.xpath(".//a[text() = 'Войти']");

    //кнопка входа на форме восстановления пароля
    private final By buttonEntranceInFormRecoveryPassword = By.xpath(".//a[@class = 'Auth_link__1fOlj' and text() = 'Войти']");
    //переход на форму регистрации
    private final By buttonForRegistrNewUser = By.xpath(".//a[@href = '/register']");
    //переход на форму восстановления пароля
    private final By linkForFormRecoveryPassword = By.xpath(".//a[text() = 'Восстановить пароль']");
    //кнопка Оформить заказ
    private final By buttonCreateOrder = By.xpath(".//button[text() = 'Оформить заказ']");
    //Объекты авторизации
    private final By inputEmailUser = By.xpath(".//label[text() = 'Email']/../input[@class='text input__textfield text_type_main-default']");
    private final By inputPasswordUser = By.xpath(".//label[text()='Пароль']/../input[@class='text input__textfield text_type_main-default']");
    private static final By buttonForLogin = By.xpath(".//button[text() = 'Войти']");

    //разлогирование из личного кабинета
    private final By buttonExit = By.xpath(".//button[text() = 'Выход']");

    //форма информации в личном кабинете
    private final By dataUserFormOnUserRoom = By.xpath(".//ul[@class = 'Profile_profileList__3vTor']");
    @Step("Клик по кнопке Личный кабинет")
    public void clickButtonPersonalArea(){
        driver.findElement(ownerCabineOnMainPage).click();
    }
    @Step("Клик по кнопке Войти в аккаунт")
    public void clickButtonToGoToAccount(){
        driver.findElement(buttonGoToAccountOnMainPage).click();
    }
    @Step("Клик по ссылке перехода c формы регистрации")
    public void clickButtonOnRegistrForm(){
        driver.findElement(buttonEntranceInFormRegistration).click();
    }
    @Step("Клик по ссылке Восстановление пароля")
    public void clickButtonOnFormRecoveryPassword(){
        driver.findElement(buttonEntranceInFormRecoveryPassword).click();
    }
    @Step("Метод перехода на форму регистрации")
    public void goToRegistrFormLink(){
        clickButtonPersonalArea();
        driver.findElement(buttonForRegistrNewUser).click();
    }
    @Step("Метод перехода на форму восстановления пароля")
    public void goToFormReconPassword(){
        driver.findElement(linkForFormRecoveryPassword).click();
        clickButtonOnFormRecoveryPassword();
    }

    @Step("Заполнить поле Email в форме авторизации")
    public void inputEmailUser(String email) {
        driver.findElement(inputEmailUser).sendKeys(email);
    }

    @Step("Заполнить поле Пароль в форме авторизации")
    public void inputPasswordUser(String password) {
        driver.findElement(inputPasswordUser).sendKeys(password);
    }

    @Step("Кликнуть на кнопку <<Войти>>")
    public void clickEnterButton() {
        driver.findElement(buttonForLogin).click();
    }
    @Step("Проверка отображения на главной странице кнопки Создания заказа под залогиненым юзером")
    public boolean displayadButtonCreateUserOrder(){
        return driver.findElement(buttonCreateOrder).isDisplayed();
    }
    @Step("Метод проверки отображения данных залогиненного юзера")
    public boolean isDisplayedUserData(){
        return driver.findElement(dataUserFormOnUserRoom).isDisplayed();
    }
    @Step("Метод выхода из аккаунта")
    public void leaveAccount(){
        clickButtonPersonalArea();
        driver.findElement(buttonExit).click();
    }
    @Step("Метод проверки перехода на главную страницу при клике на логотип")
    public boolean isDisplayedClickLogo(){
        driver.findElement(logoObject).click();
        return driver.findElement(buttonCreateOrder).isDisplayed();
    }
    @Step("Метод проверки перехода к конструктору при клике на Конструктор")
    public boolean clickConstructor(){
        driver.findElement(constructorObject).click();
        return driver.findElement(buttonCreateOrder).isDisplayed();
    }
}
