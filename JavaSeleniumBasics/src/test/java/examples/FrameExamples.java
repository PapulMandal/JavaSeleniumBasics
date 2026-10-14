
package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameExamples {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/iframe");

        // 1. Switch by ID
        driver.switchTo().frame("mce_0_ifr");

        var editor = driver.findElement(By.id("tinymce"));
        editor.clear();
        editor.sendKeys("Student Name: Rahul");
        System.out.println("By ID: " + editor.getText());

        driver.switchTo().defaultContent();

        // 2. Switch by WebElement
        driver.switchTo().frame(
                driver.findElement(By.id("mce_0_ifr"))
        );

        editor = driver.findElement(By.id("tinymce"));
        editor.clear();
        editor.sendKeys("Student Course: Java Selenium");
        System.out.println("By WebElement: " + editor.getText());

        driver.switchTo().defaultContent();

        // 3. Switch by Index (first iframe = 0)
        driver.switchTo().frame(0);

        editor = driver.findElement(By.id("tinymce"));
        editor.clear();
        editor.sendKeys("Student Batch: Automation Testing");
        System.out.println("By Index: " + editor.getText());

        driver.switchTo().defaultContent();

        driver.quit();
    }
}
