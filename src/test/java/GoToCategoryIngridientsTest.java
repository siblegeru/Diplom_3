import diplom.CategoriesObject;
import diplom.MainPageObject;
import diplom.api.CreateUserAPI;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class GoToCategoryIngridientsTest extends BaseConstractTest{
    private CategoriesObject categoriesObject;
    private final boolean expected = true;
    MainPageObject mainPageObject;
    private final static String GOOGLE_DR = "google";
    @Before
    @DisplayName("Открытие формы")
    public void setUp() {
        getWebDriver();
        mainPageObject = new MainPageObject(driver);
        mainPageObject.openMainPage();
    }

    @Test
    @DisplayName("Проверка раздела Булки на активность при выборе первого")
    public void isDisplayedBreadTest(){
       categoriesObject = new CategoriesObject(driver);
        categoriesObject.goToSouce();
        categoriesObject.goToBread();
        boolean actual = categoriesObject.isDisplayedBread();
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Проверка раздела Соусы на активность при выборе первого")
    public void isDisplayedSouceTest(){
        categoriesObject = new CategoriesObject(driver);
        categoriesObject.goToSouce();
        boolean actual = categoriesObject.isDisplayedSouce();
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Проверка раздела Начинки на активность при выборе первого")
    public void isDisplayedFillingsTest(){
        categoriesObject = new CategoriesObject(driver);
        categoriesObject.goToFilling();
        boolean actual = categoriesObject.isDisplayedFilling();
        assertEquals(expected, actual);
    }
    @After
    @DisplayName("Закрытие браузера")
    public void deleteUserAndCloseBrowser() {
        driver.quit();
    }
}
