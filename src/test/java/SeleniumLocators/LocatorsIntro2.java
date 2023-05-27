package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsIntro2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        options.addArguments("--remote-allow-origins=*");
        driver.manage().window().maximize();

        driver.navigate().to("file:///Users/sayedkhalik/Downloads/Techtorial.html");

        //LinkedText LOCATOR
        WebElement javaLink = driver.findElement(By.linkText("Java"));
        javaLink.click();
        WebElement javaHeader = driver.findElement(By.tagName("h1"));
        String actualHeader = javaHeader.getText().trim();
        String expectedHeader = "Java";
        System.out.println(actualHeader.equals(expectedHeader)? "CORRECT" :"FALSE" );
        driver.navigate().back();


        WebElement seleniumLink = driver.findElement(By.linkText("Selenium"));//it has a tagName and Text
        seleniumLink.click();
        WebElement seleniumHeader = driver.findElement(By.tagName("h1"));

        String actualHeader2 = seleniumHeader.getText().trim();
        String expectedHeader2 = "Selenium automates browsers. That's it!";
        System.out.println(actualHeader2.equals(expectedHeader2)? "SELENIUM PASSED" :"SELENIUM FAILED");
        driver.navigate().back();


        WebElement cucumberLink = driver.findElement(By.linkText("Cucumber"));
        cucumberLink.click();
        WebElement cucumberHeader = driver.findElement(By.tagName("h1"));

        String actualHeader3 = cucumberHeader.getText().trim();
        String expectedHeader3 = "Tools & techniques that elevate teams to greatness";
        System.out.println(actualHeader3.equals(expectedHeader3)? "Passed" :"Failed" );

        //LOCATOR PARTIALLINKTEXT:
        WebElement restApi = driver.findElement(By.partialLinkText("Rest"));
        restApi.click();
        System.out.println(driver.getTitle());








 }
}
