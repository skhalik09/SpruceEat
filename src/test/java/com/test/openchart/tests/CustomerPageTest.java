package com.test.openchart.tests;

import com.test.openchart.pages.CustomerPage;
import com.test.openchart.pages.LoginPage;
import org.testng.annotations.Test;

public class CustomerPageTest extends OpenChartTestBase{

    @Test
    public void validateCustomerPageFunctionality() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openChartLoginFunctionality("demo","demo");
        loginPage.errorMessage();
        Thread.sleep(1000);

        CustomerPage customerPage = new CustomerPage(driver);
        customerPage.customerPageFunctionality(driver,"Sayed","Khalik","skhalik007@yahoo.com","0000k","0000k");




    }
}
