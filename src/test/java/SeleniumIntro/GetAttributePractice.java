package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class GetAttributePractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup(); //setUp
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        options.addArguments("--remote-allow-origins=*");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//wait times
        driver.get("https://www.w3.org/TR/2019/NOTE-wai-aria-practices-1.1-20190814/examples/checkbox/checkbox-1/checkbox-1.html");

        WebElement collapseButton = driver.findElement(By.xpath("//button"));
        collapseButton.click();


        List<WebElement> checkBoxes = driver.findElements(By.xpath("//div[@role='checkbox']"));

        for ( WebElement box : checkBoxes){
            if (box.getAttribute("aria-checked").equals("false")){ //by attribute name
                box.click();
            }




        }

    }
}
