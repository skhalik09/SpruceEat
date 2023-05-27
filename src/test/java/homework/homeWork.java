package homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class homeWork {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        options.addArguments("--remote-allow-origins=*");

        //1st Website
        driver.get("https://www.starbucks.com/");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Starbucks Coffee Company";
        System.out.println(actualTitle.equals(expectedTitle) ?"Starbucks Title--> Passed" :"Failed" );

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.starbucks.com/";
        System.out.println(actualUrl.equals(expectedUrl)? "Starbucks URL--> Passed" : "Failed");
        System.out.println("===========================");
        driver.close();

        //2nd website
        driver = new ChromeDriver(options);
        driver.get("https://www.gucci.com/us/en/?gclid=CjwKCAjw6vyiBhB_EiwAQJRopg0ZKC0DMrKLqyBib06fIC-qGi_Qm5CjBgjtLSHxegdQdqzCxplXdBoC8-8QAvD_BwE&gclsrc=aw.ds");
        String actualTitle2 = driver.getTitle();
        String expectedlTitle2 = "GUCCI® US Official Site | Redefining Luxury Fashion";
        System.out.println(actualTitle2.equals(expectedlTitle2)? "Gucci Title--> Passed" : "Failed" );
        String actualUrl2 = driver.getCurrentUrl();
        String expectedUrl2 = "https://www.gucci.com/us/en/?gclid=CjwKCAjw6vyiBhB_EiwAQJRopg0ZKC0DMrKLqyBib06fIC-qGi_Qm5CjBgjtLSHxegdQdqzCxplXdBoC8-8QAvD_BwE&gclsrc=aw.ds";
        System.out.println(actualUrl2.equals(expectedUrl2)? "Gucci URL-> Passed" : "Failed" );
        driver.close();
        System.out.println("=========================");


        //3rd Website
        driver = new ChromeDriver(options);
        driver.get("https://www.versace.com/us/en-us/home/?wt_mc=US.SEM.Google.Text.01_Top_Brand_Exact_US.Exact&utm_campaignname=01_Top_Brand_Exact_US&utm_adgroup=Exact&utm_term=versace&s_kwcid=AL!6089!3!Keyword!EXACT!!g!!versace&gclid=CjwKCAjw6vyiBhB_EiwAQJRopqAwJxK-UPR-GCM8N4DxeawJkdW46YCc-1I8oEY309IJywo77ZpJ4hoCTpQQAvD_BwE&gclsrc=aw.ds");
        String actualTitle3 = driver.getTitle();
        String expectedTitle3 = "VERSACE USA | High Fashion Clothing & Accessories";
        System.out.println(actualTitle3.equals(expectedTitle3)? "Versace title--> Passed" : "Failed" );
        String actualUrl3 = driver.getCurrentUrl();
        String expectedUrl3 = "https://www.versace.com/us/en-us/home/?wt_mc=US.SEM.Google.Text.01_Top_Brand_Exact_US.Exact&utm_campaignname=01_Top_Brand_Exact_US&utm_adgroup=Exact&utm_term=versace&s_kwcid=AL!6089!3!Keyword!EXACT!!g!!versace&gclid=CjwKCAjw6vyiBhB_EiwAQJRopqAwJxK-UPR-GCM8N4DxeawJkdW46YCc-1I8oEY309IJywo77ZpJ4hoCTpQQAvD_BwE&gclsrc=aw.ds";
        System.out.println(actualTitle3.equals(expectedTitle3)? "Versace Url--> Passed" : "Failed");
        driver.close();
    }
}
