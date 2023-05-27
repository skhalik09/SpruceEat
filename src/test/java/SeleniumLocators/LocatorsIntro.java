package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class LocatorsIntro {

    public static void main(String[] args) throws InterruptedException {

        //LOCATORS --> is a way to locate(find) element and manipulate on it


        //ID LOCATOR
        ChromeOptions options = new ChromeOptions();
        WebDriver driver2 = new ChromeDriver(options);
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("file:///Users/sayedkhalik/Downloads/Techtorial.html");
        driver.manage().window().maximize();
        WebElement header = driver.findElement(By.id("techtorial1"));

        String actualHeader = header.getText();//it gets the text from element
        String expectedHeader = "Techtorial Academy";
        System.out.println(header.getText());
        System.out.println(actualHeader.equals(expectedHeader)? "CORRECT" : "WRONG");

        WebElement paragraph = driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());

        //NAME LOCATOR
        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("Zack");

        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.sendKeys("Khalik");

        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("123-345-7996");

        WebElement email = driver.findElement(By.name("userName"));
        email.sendKeys("zack69@gmail.com");

        WebElement address = driver.findElement(By.name("address1"));
        address.sendKeys("123 Main St, Evanston IL");

        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("Chicago");

        WebElement state = driver.findElement(By.name("state"));
        state.sendKeys("IL");


        WebElement postal = driver.findElement(By.name("postalCode"));
        postal.sendKeys("60202");

        //CLASS LOCATOR
        WebElement autos = driver.findElement(By.className("group_checkbox"));
        System.out.println(autos.getText());

        WebElement javaBox = driver.findElement(By.id("cond1"));
        if (javaBox.isDisplayed() && !javaBox.isSelected()){
            javaBox.click();
        }
        System.out.println(javaBox.isSelected()? "SELECTED": "NOT SELECTED");

        WebElement testNg = driver.findElement(By.id("cond3"));
        if (testNg.isDisplayed() && !testNg.isSelected()){
            testNg.click();
        }
        System.out.println(testNg.isSelected()? "SELECTED" : "NOT SELECTED" );

        WebElement cucumber = driver.findElement(By.id("cond4"));
        if (cucumber.isDisplayed() && !cucumber.isSelected()){
            cucumber.click();
        }
        System.out.println(cucumber.isSelected()? "SELECTED" :"NOT SELECTED" );

        //TAG NAME LOCATOR
        WebElement header2 = driver.findElement(By.tagName("h1"));
        System.out.println(header2.getText());

        WebElement javaVersion = driver.findElement(By.tagName("u"));
        System.out.println(javaVersion.getText()); //Use Java Version
        Thread.sleep(3000);

        driver.quit();



    }
}
