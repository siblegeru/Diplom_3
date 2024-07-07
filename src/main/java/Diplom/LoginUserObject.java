package Diplom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    private final By buttonEntranceInFormReconPassword = By.xpath(".//a[@class = 'Auth_link__1fOlj' and text() = 'Войти']");
    //переход на форму регистрации
    private final By buttonForRegistrNewUser = By.xpath(".//a[@href = '/register']");
    //переход на форму восстановления пароля
    private final By linkForFormReconPassword = By.xpath(".//a[text() = 'Восстановить пароль']");
    //кнопка Оформить заказ
    private final By buttonCreateOrder = By.xpath(".//button[text() = 'Оформить заказ']");

    //атрибуты формы логирования
    private final By filedWritenEmailForAutorized = By.className("text input__textfield text_type_main-default");
    private final By filedWritenPasswordForAutorized = By.xpath(".//input[@class = 'text input__textfield text_type_main-default' and @name = 'Пароль']");
    private final By buttonLoginAutorizedUser = By.xpath(".//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");

    //разлогирование из личного кабинета
    private final By buttonExit = By.xpath(".//button[text() = 'Выход']");

    //форма информации в личном кабинете
    private final By dataUserFormOnUserRoom = By.xpath(".//ul[@class = 'Profile_profileList__3vTor']");

    public void clickButtonToUserRoom(){
        driver.findElement(ownerCabineOnMainPage).click();
    }
    public void clickButtonToGoToAccount(){
        driver.findElement(buttonGoToAccountOnMainPage).click();
    }
    public void clickButtonOnRegistrForm(){
        driver.findElement(buttonEntranceInFormRegistration).click();
    }
    public void clickButtonOnFormReconPassword(){
        driver.findElement(buttonEntranceInFormReconPassword).click();
    }
    public void goToRegistrFormLink(){
        driver.findElement(buttonForRegistrNewUser).click();
        clickButtonOnRegistrForm();
    }
    public void goToFormReconPassword(){
        driver.findElement(linkForFormReconPassword).click();
        clickButtonOnFormReconPassword();
    }

    //логирование пользователя
    public void loginUser(String email, String password){
        driver.findElement(filedWritenEmailForAutorized).sendKeys(email);
        driver.findElement(filedWritenPasswordForAutorized).sendKeys(password);
        driver.findElement(buttonLoginAutorizedUser).click();
    }

    public boolean displayadButtonCreateUserOrder(){
        return driver.findElement(buttonCreateOrder).isDisplayed();
    }

    public boolean isDisplayedUserData(){
        return driver.findElement(dataUserFormOnUserRoom).isDisplayed();
    }

    public void leaveAccount(){
        clickButtonToUserRoom();
        driver.findElement(buttonExit).click();
    }

    public boolean isDisplayedClickLogo(){
        driver.findElement(logoObject).click();
        return driver.findElement(buttonCreateOrder).isDisplayed();
    }
    public boolean clickConstructor(){
        driver.findElement(constructorObject).click();
        return driver.findElement(buttonCreateOrder).isDisplayed();
    }
}
