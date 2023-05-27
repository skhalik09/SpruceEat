package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class GetAttribute {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        options.addArguments("--remote-allow-origins=*");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        WebElement makeAppoitnment = driver.findElement(By.cssSelector("#btn-make-appointment"));
        makeAppoitnment.click();

        WebElement name = driver.findElement(By.xpath("//input[@value='John Doe']"));
        System.out.println(name.getText());
        System.out.println(name.getAttribute("value")); //John Doe
        System.out.println(name.getAttribute("type")); //text


    }
}
