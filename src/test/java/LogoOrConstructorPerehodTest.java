import Diplom.LoginUserObject;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LogoOrConstructorPerehodTest extends BaseConstractTest{
    private LoginUserObject loginUserObject;
    private final boolean expected = true;

    @Test
    public void clickLogoLinkTest(){
        new LoginUserObject(driver);
        loginUserObject.clickButtonToGoToAccount();
        loginUserObject.loginUser("ultima@yandex.ru", "ultima1234");
        loginUserObject.clickButtonToUserRoom();
        boolean actual = loginUserObject.isDisplayedClickLogo();
        assertEquals(expected, actual);
        loginUserObject.leaveAccount();
    }
    @Test
    public void clickConstructorButtonTest(){
        new LoginUserObject(driver);
        loginUserObject.clickButtonToGoToAccount();
        loginUserObject.loginUser("ultima@yandex.ru", "ultima1234");
        loginUserObject.clickButtonToUserRoom();
        boolean actual = loginUserObject.clickConstructor();
        assertEquals(expected, actual);
        loginUserObject.leaveAccount();
    }
}
