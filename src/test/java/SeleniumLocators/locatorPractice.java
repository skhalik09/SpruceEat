package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class locatorPractice {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.manage().window().maximize();

        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Zack");

        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Khalik");

        Thread.sleep(3000);

        WebElement gender = driver.findElement(By.id("sex-0"));
        if (gender.isDisplayed() && !gender.isSelected()){
            gender.click();
        }

        WebElement experience = driver.findElement(By.id("exp-4"));
        if (experience.isDisplayed() && !experience.isSelected()){
            experience.click();
        }

        WebElement date = driver.findElement(By.id("datepicker"));
        date.sendKeys("05/16/2023");

        WebElement mTester = driver.findElement(By.id("profession-0"));
        mTester.click();

        WebElement aTester = driver.findElement(By.id("profession-1"));
        aTester.click();

        WebElement seleniumWeb = driver.findElement(By.id("tool-2"));
        seleniumWeb.click();

        WebElement continent = driver.findElement(By.id("continents"));
        continent.sendKeys("Europe");





    }
}
