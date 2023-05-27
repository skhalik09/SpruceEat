package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RealLifeExamplePractice {
    //  Test Case - Open Godaddy.com and validate it's Page title and the url.
//    Steps to Automate:
//            1. Launch browser of your choice say., Firefox, chrome etc.
//            2. Open this URL - https://www.godaddy.com/

//           4. Get Title of page and validate it.(if conditions) expected title from website
//           4. Get URL of current page and validate it.          expected url from website
//            5. Close browser.(driver.close)
public static void main(String[] args) {
    ChromeOptions options1 = new ChromeOptions();
    WebDriver driver2 = new ChromeDriver(options1);
    options1.addArguments("--remote-allow-origins=*");

    driver2.get("https://www.godaddy.com/");
    System.out.println(driver2.getTitle());

    String actualTitle = driver2.getTitle();
    String expectedTitle = "Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy";

    if (actualTitle.equals(expectedTitle)){
        System.out.println("Test PASSED");
    }else {
        System.out.println("failed");
    }

    String actualUrl = driver2.getCurrentUrl();
    String expectedUrl = "https://www.godaddy.com/";

    System.out.println(actualUrl.equals(expectedUrl)? "Url PASSED" : "URL FAILED");
    driver2.close();

}
}
