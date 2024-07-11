package diplom;


import org.openqa.selenium.WebDriver;

public class BaseConstract {
    protected WebDriver driver;
    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";

    public BaseConstract(WebDriver driver) {
        this.driver = driver;
    }

}
