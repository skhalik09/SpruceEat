package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class OpenChartTestNGPractice {
    @Test
    public void successfulLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver =new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//wait times
        driver.get("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");

        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
        submit.click();
        Thread.sleep(3000);

        String actualTitle = driver.getTitle();
        String expectedTitle = "Dashboard";

        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @Test
    public void negativeTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver =new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//wait times
        driver.get("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("Demo");

        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
        submit.click();
        Thread.sleep(3000);

        WebElement Error = driver.findElement(By.cssSelector("#alert"));
        String actualError = Error.getText().trim();
        String expectedError = "No match for Username and/or Password.";
        Assert.assertEquals(actualError,expectedError);
    }
    @Test
    public void validateProductButton() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver =new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//wait times
        driver.get("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");

        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
        submit.click();
        Thread.sleep(3000);

        WebElement closeClick = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeClick.click();
        Thread.sleep(3000);

        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalog.click();
        Thread.sleep(3000);

        WebElement product = driver.findElement(By.xpath("//a[.='Products']"));

        Assert.assertTrue(product.isDisplayed());
        Assert.assertTrue(product.isEnabled());


    }
    @Test
    public void boxes() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver =new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//wait times
        driver.get("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");

        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
        submit.click();
        Thread.sleep(3000);

        WebElement closeClick = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeClick.click();
        Thread.sleep(3000);

        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalog.click();
        Thread.sleep(3000);

        WebElement product = driver.findElement(By.xpath("//a[.='Products']"));
        product.click();
        Thread.sleep(3000);

        java.util.
                List<WebElement> allboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        for (int i =1; i<allboxes.size(); i++){
            Thread.sleep(100);
            Assert.assertTrue(allboxes.get(i).isDisplayed());
            Assert.assertTrue(allboxes.get(i).isEnabled());
            Assert.assertFalse(allboxes.get(i).isSelected());
            allboxes.get(i).click();
            Thread.sleep(3000);
            allboxes.get(i).isSelected();
            allboxes.get(i).sendKeys(Keys.ARROW_DOWN);
        }

    }
    @Test
    public void productNameButton() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver =new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//wait times
        driver.get("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        Thread.sleep(3000);

        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
        submit.click();


        WebElement closeClick = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeClick.click();


        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalog.click();
        Thread.sleep(3000);

        WebElement product = driver.findElement(By.xpath("//a[.='Products']"));
        product.click();

        WebElement productName = driver.findElement(By.xpath("//a[.='Product Name']"));
        productName.click();

        List<WebElement> allProducts = driver.findElements(By.xpath("//td[@class='text-start']"));

        List<String> actualProductsOrder = new ArrayList<>();
        List<String> expectedProductsOrder = new ArrayList<>();

        for (int i=1; i< allProducts.size(); i++){
            actualProductsOrder.add(allProducts.get(i).getText().toLowerCase().trim());
            expectedProductsOrder.add(allProducts.get(i).getText().toLowerCase().trim());
        }
        Collections.sort(expectedProductsOrder);
        Assert.assertEquals(actualProductsOrder,expectedProductsOrder);




    }
    @Test
    public void validateDescendingOrder() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver =new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//wait times
        driver.get("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        Thread.sleep(3000);

        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
        submit.click();


        WebElement closeClick = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeClick.click();


        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalog.click();
        Thread.sleep(3000);

        WebElement product = driver.findElement(By.xpath("//a[.='Products']"));
        product.click();

        WebElement productName = driver.findElement(By.xpath("//a[.='Product Name']"));
        productName.click();
        Thread.sleep(3000);


        List<WebElement> allProducts = driver.findElements(By.xpath("//td[@class='text-start']"));

        List<String> actualProductsOrder = new ArrayList<>();
        List<String> expectedProductsOrder = new ArrayList<>();

        for (int i=1; i< allProducts.size(); i++){
            actualProductsOrder.add(allProducts.get(i).getText().toLowerCase().trim());
            expectedProductsOrder.add(allProducts.get(i).getText().toLowerCase().trim());
        }
        Collections.sort(expectedProductsOrder);
        Collections.reverse(expectedProductsOrder);
        Assert.assertEquals(actualProductsOrder,expectedProductsOrder);

    }

}

