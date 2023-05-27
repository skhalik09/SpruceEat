package ActionClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class PracticeActions {
    @Test
    public void practiceDragAndDrop(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");

        WebElement dropHere = driver.findElement(By.xpath("//div[@id='droppableExample-tabpane-simple']//div[@id='droppable']"));

        WebElement dragMe = driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMe,dropHere).perform();

        String actualMessage = dropHere.getText().trim();
        String expectedMessage = "Dropped!";
        Assert.assertEquals(actualMessage,expectedMessage);

        String actualColor = dropHere.getCssValue("background-color").trim();
        String expectedColor = "rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualColor,expectedColor);

    }
    @Test
    public void practiceClickAndHold() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");

        WebElement acceptClick = driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']"));
        acceptClick.click();

        WebElement dropHerebox = driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@id='droppable']"));

        Thread.sleep(2000);
        WebElement notAcceptBox = driver.findElement(By.xpath("//div[@id='notAcceptable']"));
        String actualtext = BrowserUtils.getText(notAcceptBox);
        String expectedText = "Not Acceptable";
        Assert.assertEquals(actualtext,expectedText);

        Actions actions = new Actions(driver);
        actions.clickAndHold(notAcceptBox).moveToElement(dropHerebox).release().perform();

        String actualMessageAfterAction = BrowserUtils.getText(dropHerebox).trim();
        String expectedMessageAfterAction = "Drop here";
        Assert.assertEquals(actualMessageAfterAction,expectedMessageAfterAction);



    }

}
