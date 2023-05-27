package SelectClass;

import Utils.BrowserUtils;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DreamCar {
    @Test
    public void HeadersOfTheCars() throws InterruptedException {
          /*
NOTE: Please use browser utils for the select classes if it is needed or getText.
1-Navigate to the website
2-Choose the "New" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption
6-Choose the distance 40 mil
7-Put your Zip code-->Before that Clear it.60056 element.clear()
8-Click Search Button
9-Validate the header "New Lexus RX 350 for sale"
10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX 350
     */

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver =new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//wait times
        driver.navigate().to("https://www.cars.com/");

        WebElement newUsed = driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        BrowserUtils.selectBy(newUsed,"New","text");

        WebElement make = driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(make,"Lexus","text");

        WebElement model = driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(model,"RX 350","text");

        WebElement price = driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        Select priceValidate = new Select(price);

        String actualPrice = priceValidate.getFirstSelectedOption().getText().trim();
        String expectedPrice = "No max price";
        Assert.assertEquals(actualPrice,expectedPrice);
        Thread.sleep(2000);

        WebElement miles = driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(miles,"40 miles","text");
        Thread.sleep(2000);

        WebElement zipCode = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipCode.clear();
        zipCode.sendKeys("60056");

        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"by-make-tab\"]/div/div[7]/button"));
        searchButton.click();
        Thread.sleep(2000);

        WebElement header = driver.findElement(By.xpath("//h1[@class='sds-heading--1 sds-page-section__title']"));
        String actualHeader = BrowserUtils.getText(header); //getting text and trim()
        String expectedHeader = "New Lexus RX 350 for sale";
        Assert.assertEquals(actualHeader,expectedHeader);
        Thread.sleep(2000);

        WebElement sort = driver.findElement(By.cssSelector("#sort-dropdown"));
        BrowserUtils.selectBy(sort,"Lowest price","text");

        List<WebElement> allTitle = driver.findElements(By.xpath("//h2[@class='title']"));

        for (WebElement title : allTitle){
            Assert.assertTrue(BrowserUtils.getText(title).contains("Lexus RX 350"));
            System.out.println(BrowserUtils.getText(title));
        }

        List<WebElement> allPrice = driver.findElements(By.cssSelector(".primary-price"));

        List<String> actualPrices = new ArrayList<>();
        List<String> expectedPrices = new ArrayList<>();

        for (int i=0; i<allPrice.size(); i++){
            actualPrices.add(BrowserUtils.getText(allPrice.get(i)).replace("$","").replace(",",""));
            expectedPrices.add(BrowserUtils.getText(allPrice.get(i)).replace("$","").replace(",",""));
        }
        Collections.sort(expectedPrices);
        Assert.assertEquals(actualPrice,expectedPrice);
        System.out.println(actualPrices);
        System.out.println(expectedPrices);








    }
}
