package com.test.SpruceEat.test;

import com.test.SpruceEat.page.SpruceEatHomePage;
import org.testng.annotations.Test;

public class SpruceEatTest extends SpruceTestBase{

    @Test
    public void spruceEatFunctionalityTest() throws InterruptedException {
        SpruceEatHomePage spruceEatHomePage = new SpruceEatHomePage(driver);
        spruceEatHomePage.hoverIngredient(driver,"FISH & SEAFOOD");
        spruceEatHomePage.findRecipe("Fish for dinner");
        spruceEatHomePage.ratingAndPopular();
        spruceEatHomePage.productNameValidation("6-Ingredient Roasted Salmon Fillets");
    }

}
