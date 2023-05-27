package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XpathrealhealthProject {
              /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/ -->DONE
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your comment for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Validate the header is "Appointment confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.

           */

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        options.addArguments("--remote-allow-origins=*");
        driver.manage().window().maximize();

        driver.get("https://katalon-demo-cura.herokuapp.com/");

        //CSS WITH ID
        //WebElement makeAppoitnment2 = driver.findElement(By.cssSelector("#btn-make-appointment"));

        WebElement makeAppointment = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        makeAppointment.click();

        WebElement username = driver.findElement(By.xpath("//input[@id='txt-username']"));
        username.sendKeys("John Doe");

        WebElement password = driver.findElement(By.xpath("//input[@id='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");
        Thread.sleep(3000);

        WebElement loginbutton = driver.findElement(By.xpath("//button[@id='btn-login']"));
        loginbutton.click();

        WebElement facility = driver.findElement(By.xpath("//select[@id='combo_facility']"));
        facility.sendKeys("HongKong CURA Healthcare Center");

        WebElement admissionBox = driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']"));
        if (admissionBox.isDisplayed() && !admissionBox.isSelected()){
            admissionBox.click();
        }

        WebElement healthCareBox = driver.findElement(By.xpath("//input[@id='radio_program_medicaid']"));
        healthCareBox.click();

        WebElement visitDate = driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        visitDate.sendKeys("03/17/2023");

        WebElement comment = driver.findElement(By.xpath("//textarea[@id='txt_comment']"));
        comment.sendKeys("Hello, I would like to make an appointment." +
                "Very Sick!!!");
        Thread.sleep(3000);

        //CSS WITH CLASS
        WebElement button= driver.findElement(By.cssSelector(".btn-default"));
        button.click();

        //WebElement bookAppointment = driver.findElement(By.xpath("//button[@id='btn-book-appointment']"));
        //bookAppointment.click();

        WebElement header = driver.findElement(By.xpath("//h2[.='Appointment Confirmation']"));

        String actualHeader = header.getText();
        String expectedHeader = "Appointment Confirmation";
        System.out.println(actualHeader.equals(expectedHeader)? "Appointment Confirm":"Appointment Not Confirm" );

        WebElement hongKongCura = driver.findElement(By.xpath("//p[contains(text(),'Hongkong')]"));
        System.out.println("Hospital Readmission: "+hongKongCura.getText());

        WebElement yes = driver.findElement(By.xpath("//p[@id='hospital_readmission']"));
        System.out.println("Health Care Program: "+yes.getText());

        WebElement date = driver.findElement(By.xpath("//p[@id='visit_date']"));
        System.out.println("Visit Date: "+date.getText());

        WebElement comment2 = driver.findElement(By.xpath("//p[@id='comment']"));
        System.out.println("Comment: "+comment2.getText());

        WebElement goToHomePage = driver.findElement(By.xpath("//a[@class='btn btn-default']"));
        goToHomePage.click();

        System.out.println(driver.getCurrentUrl());
        //driver.quit();



    }
}
