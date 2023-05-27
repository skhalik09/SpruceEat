package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestCase1 {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        options.addArguments("--remote-allow-origins=*");
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/text-box");

        WebElement fullName = driver.findElement(By.xpath("//input[@id='userName']"));
        fullName.sendKeys("Sayed Khalik");

        WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys("skhalik69@gmail.com");

        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddress.sendKeys("123 Main St");

        WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("321 Greenwood Ave");
        Thread.sleep(3000);

        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
        submitButton.click();

        String displayedName = driver.findElement(By.id("name")).getText();
        String displayedEmail = driver.findElement(By.id("email")).getText();
        String dispCurrentAddress = driver.findElement(By.id("currentAddress")).getText();
        String dispPrmntAddress = driver.findElement(By.id("permanentAddress")).getText();
        Thread.sleep(3000);

        String expectedName = "Name:Sayed Khalik";
        String expectedEmail = "Email:skhalik69@gmail.com";
        String expectedCurrentAddress = "Current Address :123 Main St";
        String expectedPrmntAddress = "Permananet Address :321 Greenwood Ave";

        if (displayedName.equals(expectedName) && displayedEmail.equals(expectedEmail )&& dispCurrentAddress.equals(expectedCurrentAddress)&&
                dispPrmntAddress.equals(expectedPrmntAddress)){
            System.out.println("Test Case 1: PASSED");
        }else {
            System.out.println("Test Case 1: FAILED");
        }












    }
}
