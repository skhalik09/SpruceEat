package com.test.openchart.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#input-username")
    WebElement userName;

    @FindBy(css = "#input-password")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//title")
    WebElement actualTitle;

    @FindBy(css = "#alert")
    WebElement errorMessage;

    @FindBy(xpath = "//button[@class='btn-close']")
    WebElement xbutton;



    public void openChartLoginFunctionality(String userName,String password) throws InterruptedException {
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
          loginButton.click();
          Thread.sleep(2000);
          xbutton.click();

    }
    public String errorMessage(){
        return BrowserUtils.getText(errorMessage);

    }


}
