import Diplom.MainPageObject;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;


import static org.junit.Assert.assertEquals;


public class CreateNewUserTest extends BaseConstractTest {
    private MainPageObject mainPageObject;
    private String email;
    private String name;
    private String password;
    private final boolean expected = true;



    @Test
    public void checkCreateUserTest() {
        new MainPageObject(driver);
        email = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
        password = RandomStringUtils.randomAlphabetic(10);
        name = RandomStringUtils.randomAlphabetic(10);
        mainPageObject.buttonForFormLoginOnMainPage();
        mainPageObject.buttonFormRegistratedNewUser();
        mainPageObject.registrNewUser(email, name, password);
        assertEquals(expected, mainPageObject.isDisplaidFormLogin());
    }

    @Test
    public void checkCreateUserWhithSmallPasswordTest() {
        new MainPageObject(driver);
        email = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
        name = RandomStringUtils.randomAlphabetic(10);
        mainPageObject.buttonForFormLoginOnMainPage();
        mainPageObject.buttonFormRegistratedNewUser();
        mainPageObject.registrNewUser(email, name, "wtcb");
        assertEquals(expected, mainPageObject.isDisplaidFailInputPassword());
    }
}
