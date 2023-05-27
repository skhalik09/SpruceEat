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
import java.util.List;

public class SelectMidLevelPractice {
    @Test
            public void validateOrderMessage() throws InterruptedException {
        /*
        1-Navigate to the website
2-Select one way trip button
3-Choose 4 passangers(1 wife-1 husband-2 kids)
4-Validate the depart from is default "Acapulco"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue
14-Validate the message at the top.There is a bug here/
 "After flight finder - No Seats Avaialble"

 NOTE:Your test should fail and say available is not matching with Available.
 NOTE2:You can use any select method value,visibleText
         */

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver =new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//wait times

        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement oneWayBox = driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayBox.click();
        Thread.sleep(3000);

        WebElement passengerBox = driver.findElement(By.xpath("//select[@name='passCount']"));
        Select option = new Select(passengerBox);
        option.selectByIndex(3);
        Thread.sleep(2000);

        WebElement departing = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departingValidate = new Select(departing);
        String actualPort = departingValidate.getFirstSelectedOption().getText().trim();
        String expectPort = "Acapulco";
        Assert.assertEquals(actualPort,expectPort);

        departingValidate.getFirstSelectedOption();
        departingValidate.selectByValue("Paris");
        Thread.sleep(2000);

        WebElement month = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select monthOption = new Select(month);
        monthOption.selectByIndex(7);
        Thread.sleep(2000);

        WebElement day = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select dayOption = new Select(day);
        dayOption.selectByValue("15");
        Thread.sleep(2000);

        WebElement arrive = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select arriveIn = new Select(arrive);
        arriveIn.selectByValue("San Francisco");
        Thread.sleep(2000);

        WebElement returnDate = driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select returnDateDec = new Select(returnDate);
        returnDateDec.selectByValue("12");
        Thread.sleep(2000);

        WebElement returnDay = driver.findElement(By.xpath("//select[@name='toDay']"));
        Select toDay = new Select(returnDay);
        toDay.selectByValue("15");
        Thread.sleep(2000);

        WebElement firstClass = driver.findElement(By.xpath("//input[@value='First']"));
        firstClass.click();
        Thread.sleep(2000);

        WebElement airline = driver.findElement(By.xpath("//select[@name='airline']"));
        String expected[]={"No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines"};
        Select airlineValidate = new Select(airline);
        List<WebElement>opt= airlineValidate.getOptions();
        for (int i= 0;i<opt.size();i++){
            Assert.assertEquals(expected[i],opt.get(i).getText());
        }
        airlineValidate.selectByIndex(2);

        WebElement continueButton = driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueButton.click();
        Thread.sleep(3000);

        WebElement message = driver.findElement(By.xpath("//font[@size='4']"));
        String actual= message.getText().trim();
        String expect="After flight finder - No Seats avaialble";
        Assert.assertEquals(actual,expect);

    }
    @Test
    public void validateOrderMessage2() throws InterruptedException {
        /*
        1-Navigate to the website
2-Select one way trip button
3-Choose 4 passangers(1 wife-1 husband-2 kids)
4-Validate the depart from is default "Acapulco"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue
14-Validate the message at the top.There is a bug here/
 "After flight finder - No Seats Avaialble"

 NOTE:Your test should fail and say available is not matching with Available.
 NOTE2:You can use any select method value,visibleText
         */

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver =new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//wait times

        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement oneWayBox = driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayBox.click();
        Thread.sleep(3000);

        WebElement passengerBox = driver.findElement(By.xpath("//select[@name='passCount']"));
//        Select option = new Select(passengerBox);
//        option.selectByIndex(3);
        BrowserUtils.selectBy(passengerBox,"3","index");
        Thread.sleep(2000);

        WebElement departing = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departingValidate = new Select(departing);
        String actualPort = departingValidate.getFirstSelectedOption().getText().trim();
        String expectPort = "Acapulco";
        Assert.assertEquals(actualPort,expectPort);

        departingValidate.getFirstSelectedOption();
        //departingValidate.selectByValue("Paris");
        BrowserUtils.selectBy(departing,"Paris","text");
        Thread.sleep(2000);

        WebElement month = driver.findElement(By.xpath("//select[@name='fromMonth']"));
//        Select monthOption = new Select(month);
//        monthOption.selectByIndex(7);
        BrowserUtils.selectBy(month,"December","text");
        Thread.sleep(2000);

        WebElement day = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select dayOption = new Select(day);
        dayOption.selectByValue("15");
        Thread.sleep(2000);

        WebElement arrive = driver.findElement(By.xpath("//select[@name='toPort']"));
       // Select arriveIn = new Select(arrive);
//        arriveIn.selectByValue("San Francisco");
        BrowserUtils.selectBy(arrive,"San Francisco","text");
        Thread.sleep(2000);

        WebElement returnDate = driver.findElement(By.xpath("//select[@name='toMonth']"));
//        Select returnDateDec = new Select(returnDate);
//        returnDateDec.selectByValue("12");
        BrowserUtils.selectBy(returnDate,"December","text");
        Thread.sleep(2000);

        WebElement returnDay = driver.findElement(By.xpath("//select[@name='toDay']"));
//        Select toDay = new Select(returnDay);
//        toDay.selectByValue("15");
        BrowserUtils.selectBy(returnDay,"15","index");
        Thread.sleep(2000);

        WebElement firstClass = driver.findElement(By.xpath("//input[@value='First']"));
        firstClass.click();
        Thread.sleep(2000);

        WebElement airline = driver.findElement(By.xpath("//select[@name='airline']"));
        String expected[]={"No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines"};
        Select airlineValidate = new Select(airline);
        List<WebElement>opt= airlineValidate.getOptions();
        for (int i= 0;i<opt.size();i++){
            Assert.assertEquals(expected[i],opt.get(i).getText());
        }
        airlineValidate.selectByIndex(2);

        WebElement continueButton = driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueButton.click();
        Thread.sleep(3000);

        WebElement message = driver.findElement(By.xpath("//font[@size='4']"));
        String actual= message.getText().trim();
        String expect="After flight finder - No Seats avaialble";
        Assert.assertEquals(actual,expect);

    }



}




