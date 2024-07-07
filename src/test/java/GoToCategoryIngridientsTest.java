import Diplom.CategoriesObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GoToCategoryIngridientsTest extends BaseConstractTest{
    private CategoriesObject categoriesObject;
    private final boolean expected = true;

    @Test
    public void isDisplayedBreadTest(){
        new CategoriesObject(driver);
        categoriesObject.goToBread();
        boolean actual = categoriesObject.isDisplayedBread();
        assertEquals(expected, actual);
    }
    @Test
    public void isDisplayedSouceTest(){
        new CategoriesObject(driver);
        categoriesObject.goToSouce();
        boolean actual = categoriesObject.isDisplayedSouce();
        assertEquals(expected, actual);
    }
    @Test
    public void isDisplayedFillingsTest(){
        new CategoriesObject(driver);
        categoriesObject.goToFilling();
        boolean actual = categoriesObject.isDisplayedFilling();
        assertEquals(expected, actual);
    }
}
