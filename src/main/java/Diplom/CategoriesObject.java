package Diplom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoriesObject extends BaseConstract{

    public CategoriesObject(WebDriver driver) {
        super(driver);
    }

    //категория Булки
    private final By catedoryBread = By.xpath(".//span[text() = 'Булки']");
    //категория Соусы
    private final By catedorySouce = By.xpath(".//span[text() = 'Соусы']");
    //категория Начинки
    private final By catedoryFilling = By.xpath(".//span[text() = 'Начинки']");

    private final By displayedBread = By.xpath(".//p[text() = 'Флюоресцентная булка R2-D3']");
    private final By displayedSouce = By.xpath(".//p[text() = 'Соус Spicy-X']");
    private final By displayedFilling = By.xpath(".//p[text() = 'Мясо бессмертных моллюсков Protostomia']");

    public void goToBread(){
        driver.findElement(catedoryBread).click();
    }
    public void goToSouce(){
        driver.findElement(catedorySouce).click();
    }
    public void goToFilling(){
        driver.findElement(catedoryFilling).click();
    }
    public boolean isDisplayedBread(){
        return driver.findElement(displayedBread).isDisplayed();
    }
    public boolean isDisplayedSouce(){
        return driver.findElement(displayedSouce).isDisplayed();
    }
    public boolean isDisplayedFilling(){
        return driver.findElement(displayedFilling).isDisplayed();
    }
}
