package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumDriverMethod {

    //driver.get()
    //driver.manage.windows.maximize()
    //driver.getTitle()
    //driver.getUrl()
    //driver.navigate.to()
    //driver.navigate.fresh()
    //driver.navigate.back()
    //driver.navigate.forward()
    //driver.getPageSource()

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize(); //it maximize the screen

        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        Thread.sleep(3000);

        driver.navigate().to("https://www.youtube.com/");
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);

        driver.navigate().back();// will go back to google again
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
        driver.navigate().forward(); //will go to youtube again
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
        driver.navigate().refresh(); //it refreshes the page
        Thread.sleep(3000);

        driver.getPageSource(); // it gets the html structure of page on console
        System.out.println(driver.getPageSource());

        driver.quit(); // it closes the all pages opened close from one automation





    }

}
