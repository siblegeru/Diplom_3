package Diplom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPageObject extends BaseConstract {


    //pageObject для формы регистрации
    private final By ownerCabineOnMainPage = By.xpath(".//p[text() = 'Личный Кабинет']");
    private final By battonForRegistrNewUser = By.xpath(".//a[@href = '/register']");
    private final By filedInputNameNewUser = By.xpath(".//label[text() = 'Имя']");
    private final By filedInputPasswordNewUser = By.xpath(".//label[text() = 'Пароль']");
    private final By filedInputEmailNewUser = By.xpath(".//label[text() = 'Email']");
    private final By buttonRegistrNewUser = By.xpath(".//button[text() = 'Зарегистрироваться']");
    private final By failInputPassword = By.xpath(".//p[text() = 'Некорректный пароль']");

    public MainPageObject(WebDriver driver) {
        super(driver);
    }
    public void buttonForFormLoginOnMainPage() {
        driver.findElement(ownerCabineOnMainPage).click();
    }
    public void buttonFormRegistratedNewUser() {
        driver.findElement(battonForRegistrNewUser).click();
    }
    public void inputEmailFiled(String email) {
        driver.findElement(filedInputEmailNewUser).sendKeys(email);
    }
    public void inputNameFiled(String name) {
        driver.findElement(filedInputNameNewUser).sendKeys(name);
    }
    public void inputPasswordFiled(String password) {
        driver.findElement(filedInputPasswordNewUser).sendKeys(password);
    }
    public void clickOnButtonRegistration() {
        driver.findElement(buttonRegistrNewUser).click();
    }

    public void registrNewUser(String email, String name, String password){
        inputEmailFiled(email);
        inputPasswordFiled(password);
        inputNameFiled(name);
        clickOnButtonRegistration();
    }
    public boolean isDisplaidFormLogin(){
        return driver.findElement(By.xpath(".//h2[text() = 'Вход']")).isDisplayed();
    }

    public boolean isDisplaidFailInputPassword(){
        return driver.findElement(failInputPassword).isDisplayed();
    }


}
