package com.test.openchart.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class CustomerPage {
    public CustomerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//li[@id='menu-customer']")
    WebElement customerButton;

//    @FindBy(xpath = "//ul[@id='collapse-5']//li//a")
//    WebElement subCustomer;

    @FindBy(xpath = "//div[@class='float-end']//a")
    WebElement plusButton;

    @FindBy(css = "#input-firstname")
    WebElement fisrtName;

    @FindBy(css = "#input-lastname")
    WebElement lastName;

    @FindBy(css = "#input-email")
    WebElement email;

    @FindBy(css = "#input-telephone")
    WebElement phoneNum;

    @FindBy(css = "#input-password")
    WebElement password;

    @FindBy(css = "#input-confirm")
    WebElement confirmPassword;

    @FindBy(css = "#input-newsletter")
    WebElement newLetter;

    @FindBy(css = "#input-safe")
    WebElement safeButton;

    @FindBy(xpath = "//div[@class='float-end']//button[@type='submit']")
    WebElement saveButton;

    @FindBy(css = "//div[@id='alert']")
    WebElement errorMessage;

    @FindBy(xpath = "//a[.='Customers']")
    WebElement getSubCustomer;


    public void customerPageFunctionality(WebDriver driver,String firstName,String lastName,String email,String password,String confirmPassword) throws InterruptedException {

        customerButton.click();
        getSubCustomer.click();
        Thread.sleep(1000);
        plusButton.click();
        this.fisrtName.sendKeys(firstName);
        Thread.sleep(1000);
        this.lastName.sendKeys(lastName);
        Thread.sleep(1000);
        this.email.sendKeys(email);
        Thread.sleep(1000);
        //this.phoneNum.sendKeys(phoneNum);
        this.password.sendKeys(password);
        Thread.sleep(1000);
        this.confirmPassword.sendKeys(confirmPassword);
        Thread.sleep(1000);
        BrowserUtils.scrollWithJs(driver,newLetter);
        BrowserUtils.scrollWithJs(driver,safeButton);
//        newLetter.click();
//        safeButton.click();
        Thread.sleep(500);
//        saveButton.click();

        Assert.assertEquals(BrowserUtils.getText(errorMessage), "Warning: You do not have permission to modify customers!");

    }

}

