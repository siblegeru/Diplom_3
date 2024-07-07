
import Diplom.LoginUserObject;
import Diplom.MainPageObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EnteranceOnUserRoomTest extends BaseConstractTest {
    private LoginUserObject loginUserObject;
    private final boolean expected = true;

    @Test
    public void loginOnButtonUserRoom(){
        new MainPageObject(driver);
        loginUserObject.clickButtonToUserRoom();
        loginUserObject.loginUser("ultima@yandex.ru", "ultima1234");
        loginUserObject.clickButtonToUserRoom();
        boolean actual = loginUserObject.isDisplayedUserData();
        assertEquals(expected, actual);
        loginUserObject.leaveAccount();
    }
}
