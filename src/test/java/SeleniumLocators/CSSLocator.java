package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CSSLocator {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        options.addArguments("--remote-allow-origins=*");
        driver.manage().window().maximize();

        driver.get("https://www.etsy.com/");
        WebElement searchBar = driver.findElement(By.cssSelector("#global-enhancements-search-query"));
        searchBar.sendKeys("watch");

        WebElement enterSearch = driver.findElement(By.cssSelector(".wt-nudge-r-1"));
        enterSearch.click();

        System.out.println(driver.getCurrentUrl());
    }
}
