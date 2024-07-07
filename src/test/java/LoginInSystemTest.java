import Diplom.LoginUserObject;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginInSystemTest extends BaseConstractTest{
    private LoginUserObject loginUserObject;
    private final boolean expected = true;

    @Test
    public void loginOnButtonUserRoom(){
        new LoginUserObject(driver);
        loginUserObject.clickButtonToUserRoom();
        loginUserObject.loginUser("ultima@yandex.ru", "ultima1234");
        boolean actual = loginUserObject.displayadButtonCreateUserOrder();
        assertEquals(expected, actual);
        loginUserObject.leaveAccount();
    }
    @Test
    public void loginOnButtonGoToAccount(){
        new LoginUserObject(driver);
        loginUserObject.clickButtonToGoToAccount();
        loginUserObject.loginUser("ultima@yandex.ru", "ultima1234");
        boolean actual = loginUserObject.displayadButtonCreateUserOrder();
        assertEquals(expected, actual);
        loginUserObject.leaveAccount();
    }
    @Test
    public void loginOnRegistrFormLink(){
        new LoginUserObject(driver);
        loginUserObject.goToRegistrFormLink();
        loginUserObject.loginUser("ultima@yandex.ru", "ultima1234");
        boolean actual = loginUserObject.displayadButtonCreateUserOrder();
        assertEquals(expected, actual);
        loginUserObject.leaveAccount();
    }
    @Test
    public void loginOnFormReconPassword(){
        new LoginUserObject(driver);
        loginUserObject.goToFormReconPassword();
        loginUserObject.loginUser("ultima@yandex.ru", "ultima1234");
        boolean actual = loginUserObject.displayadButtonCreateUserOrder();
        assertEquals(expected, actual);
        loginUserObject.leaveAccount();
    }
}
