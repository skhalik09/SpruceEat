package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SelectPractice {
    @Test
    public void practice() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver =new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//wait times

        driver.navigate().to("file:///Users/sayedkhalik/Downloads/Techtorial.html");

        WebElement countryBox = driver.findElement(By.xpath("//select[@name='country']"));
        Select country = new Select(countryBox);

        String actualDefaultOption = country.getFirstSelectedOption().getText().trim();
        String expectedDefaultOPtion = "UNITED STATES";

        Assert.assertEquals(actualDefaultOption,expectedDefaultOPtion);

        //print out all the options and count how many countries

        List<WebElement> allcountries = country.getOptions();//will give me all the countries
        int count=0;
        for (WebElement cntry : allcountries){
            System.out.println(cntry.getText().trim());
            count++;
        }
        System.out.println(count);

        country.selectByVisibleText("BANGLADESH");
        Thread.sleep(2000);

        country.selectByValue("26");
        Thread.sleep(2000);

        country.selectByIndex(8);

    }

}
