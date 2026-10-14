
package examples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserNavigation {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        // WebDriver firefox = new FirefoxDriver();
        // WebDriver edge = new EdgeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.selenium.dev/");
        System.out.println("Title: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());

        driver.navigate().to("https://the-internet.herokuapp.com/");
        System.out.println("New title: " + driver.getTitle());

        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        driver.quit();
    }
}
