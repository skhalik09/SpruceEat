package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPATHPractice {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        options.addArguments("--remote-allow-origins=*");
        driver.manage().window().maximize();

        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
        Thread.sleep(3000);

        WebElement firstName = driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstName.sendKeys("Sayed");

        WebElement lastName = driver.findElement(By.xpath("//input[@id='input-lastname']"));
        lastName.sendKeys("Khalik");

        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        email.sendKeys("Sayed69@gmail.com");

        WebElement phoneNum = driver.findElement(By.xpath("//input[@id='input-telephone']"));
        phoneNum.sendKeys("123-456-7890");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("Hello_***");

        WebElement confrimPassword = driver.findElement(By.xpath("//input[@id='input-confirm']"));
        confrimPassword.sendKeys("Hello_***");

        WebElement subscribe = driver.findElement(By.xpath("//input[@name='newsletter']"));
        subscribe.click();
        Thread.sleep(3000);

        WebElement agree = driver.findElement(By.xpath("//input[@name='agree']"));
        agree.click();

        WebElement continueBox = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueBox.click();

        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://tutorialsninja.com/demo/index.php?route=account/account";
        System.out.println(actualUrl.equals(expectedUrl)?"URL Passed.":"URL Failed.");

    }
}
