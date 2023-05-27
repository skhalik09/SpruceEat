package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestCase2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup(); //setUp
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        options.addArguments("--remote-allow-origins=*");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//wait times
        driver.get("https://www.saucedemo.com/");


        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("Java");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Selenium");
        Thread.sleep(3000);

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='error-message-container error']"));

        String actualMessage = errorMessage.getText();
        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";

        if (actualMessage.equals(expectedMessage)){
            System.out.println("PASSED");
        }


    }
}
