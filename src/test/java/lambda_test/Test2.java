package lambda_test;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class Test2 {
    /*
    print out names and emials as a key - value pair
    use map interface , try to use cssSelector
     */
    @Test
    public void test2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground/table-pagination-demo");

        driver.findElement(By.xpath("//a[contains(.,'Table Pagination')]")).click();
        Thread.sleep(2000);
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='maxRows']"));
        BrowserUtils.selectBy(dropDown,"0","index");

        List<WebElement> allNames = driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> allEmails = driver.findElements(By.xpath("//tr//td[3]"));

        TreeMap<String,String> map = new TreeMap<>();

        for (int i =0; i< allNames.size(); i++){
            map.put(BrowserUtils.getText(allNames.get(i)), BrowserUtils.getText(allEmails.get(i)));
        }
        System.out.println(map);
    }
}
