package com.test.openchart.tests;

import com.test.openchart.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenchartTest extends OpenChartTestBase{

    @Test
    public void loginvalidation() throws InterruptedException {
        LoginPage loginPage= new LoginPage(driver);
        loginPage.openChartLoginFunctionality("demo","demo");
        Assert.assertEquals(driver.getTitle().trim(),"Dashboard");
        loginPage.errorMessage();
    }
}
