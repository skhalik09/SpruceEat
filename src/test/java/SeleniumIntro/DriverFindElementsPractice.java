package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class DriverFindElementsPractice {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup(); //setUp
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        options.addArguments("--remote-allow-origins=*");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//wait times
        driver.get("https://the-internet.herokuapp.com/");

        List<WebElement> allLinks = driver.findElements(By.xpath("//li"));

        int counter =0;
        for (WebElement link : allLinks){
            System.out.println(link.getText());
            counter++;
        }
        System.out.println(counter);

        //print if length is equal and more than 12 and count how many
        int counter2=0;
        for (WebElement link : allLinks){
            if (link.getText().length()>=12){
                System.out.println(link.getText());
                counter2++;
            }
        }
        System.out.println(counter2);







    }
}
