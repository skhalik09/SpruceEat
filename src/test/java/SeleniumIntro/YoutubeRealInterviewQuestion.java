package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class YoutubeRealInterviewQuestion {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup(); //setUp
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        options.addArguments("--remote-allow-origins=*");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//wait times
        driver.get("https://www.youtube.com/");

        //song.sendKeys(Keys.ARROW_DOWN)--> put inside the loop
        WebElement searchBar = driver.findElement(By.xpath("//input[@id='search']"));
        searchBar.sendKeys("Justin Bieber");

        WebElement enter = driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
        enter.click();

        List<WebElement> songTitles = driver.findElements(By.xpath("//a[@id='video-title']"));

        Thread.sleep(3000);
        for (WebElement title : songTitles){
            if (title.getAttribute("title").equals("Justin Bieber - Baby ft. Ludacris")){
                title.click();
            }
        }




    }
}
