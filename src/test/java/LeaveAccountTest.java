import Diplom.LoginUserObject;
import Diplom.MainPageObject;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class LeaveAccountTest extends BaseConstractTest{
    private LoginUserObject loginUserObject;
    private final boolean expected = true;

    @Test
    public void loginOnButtonUserRoom(){
        new MainPageObject(driver);
        loginUserObject.clickButtonToUserRoom();
        loginUserObject.loginUser("ultima@yandex.ru", "ultima1234");
        loginUserObject.leaveAccount();
        boolean actual = driver.findElement(By.xpath(".//div[@class = 'Auth_login__3hAey']")).isDisplayed();
        assertEquals(expected, actual);
    }
}
