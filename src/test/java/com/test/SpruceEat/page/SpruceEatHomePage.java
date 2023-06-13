package com.test.SpruceEat.page;

import Utils.BrowserUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class SpruceEatHomePage {
    public SpruceEatHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);}

    @FindBy(xpath = "//span[.='Ingredients']")
    WebElement ingredientsList;

    @FindBy(css = "#search-form-input")
    WebElement recipeBox;

    @FindBy(css = "#button_1-0")
    WebElement searchBox;

    @FindBy(xpath = "//div[@id='facet_starRating_score']//li[1]")
    WebElement ratingBox;

    @FindBy(xpath = "//label[@for='pop_search_editor']")
    WebElement popularBox;

    @FindBy(xpath = "//span[@class='card__underline']")
    WebElement productName;



    public void hoverIngredient(WebDriver driver,String fishSeafoodButton) throws InterruptedException {

        Actions actions = new Actions(driver);
         actions.moveToElement(ingredientsList).perform();
         Thread.sleep(1000);
         if (BrowserUtils.getText(ingredientsList).contains(fishSeafoodButton)){
             ingredientsList.click();
         }
         Thread.sleep(1000);
        }
    public void findRecipe(String menuName) throws InterruptedException {
        recipeBox.sendKeys(menuName);
        Thread.sleep(1000);
        searchBox.click();
        Thread.sleep(1000);
    }
    public void ratingAndPopular() throws InterruptedException {
        ratingBox.click();
        Thread.sleep(1000);
        popularBox.click();
        Thread.sleep(1000);

    }
    public void productNameValidation(String expectedProductName){
        Assert.assertEquals(BrowserUtils.getText(productName),expectedProductName);
    }

}


