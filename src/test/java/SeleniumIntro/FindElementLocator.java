package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class FindElementLocator {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup(); //setUp
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        options.addArguments("--remote-allow-origins=*");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//wait times
        driver.get("file:///Users/sayedkhalik/Downloads/Techtorial.html");//URL

        //List for store multiple elements
        //4 elements
        List<WebElement> allBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        for (WebElement box : allBoxes){
            if (box.isDisplayed() && box.isEnabled() && !box.isSelected()){
                Thread.sleep(3000);
                box.click();
                break;


            }
        }

    }
}
