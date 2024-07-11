package diplom;

import io.qameta.allure.Step;
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

    private final By breadIsActive = By.xpath(".//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text() = 'Булки']");
    private final By souceIsActive = By.xpath(".//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text() = 'Соусы']");
    private final By fillingsIsActive = By.xpath(".//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text() = 'Начинки']");


    @Step("Переход к категории Булки")
    public void goToBread(){
        driver.findElement(catedoryBread).click();
    }
    @Step("Переход к категории Соусы")
    public void goToSouce(){
        driver.findElement(catedorySouce).click();

    }
    @Step("Переход к категории Начинки")
    public void goToFilling(){
        driver.findElement(catedoryFilling).click();
    }
    @Step("Отображение активности раздела Булки")
    public boolean isDisplayedBread(){
        return driver.findElement(breadIsActive).isDisplayed();
    }
    @Step("Отображение активности раздела Соусы")
    public boolean isDisplayedSouce(){
        return driver.findElement(souceIsActive).isDisplayed();
    }
    @Step("Отображение активности раздела Начинки")
    public boolean isDisplayedFilling(){
        return driver.findElement(fillingsIsActive).isDisplayed();
    }
}
