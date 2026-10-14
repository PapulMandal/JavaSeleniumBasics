package examples;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertExamples {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");

            // Accept a JavaScript alert.
            driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Alert text: " + alert.getText());
            alert.accept();

            // Dismiss a confirmation dialog.
            driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
            wait.until(ExpectedConditions.alertIsPresent()).dismiss();

            // Enter text into a prompt.
            driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
            Alert prompt = wait.until(ExpectedConditions.alertIsPresent());
            prompt.sendKeys("Hello Selenium");
            prompt.accept();

            System.out.println(driver.findElement(By.id("result")).getText());

            driver.quit();

    }
}
