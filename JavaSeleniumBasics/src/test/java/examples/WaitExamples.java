package examples;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;

public class WaitExamples {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            // Implicit wait: applies to element searches throughout this driver session.
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
            driver.findElement(By.cssSelector("#start button")).click();

            // Explicit wait: wait for a specific condition.
            WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement result = explicitWait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish h4"))
            );
            System.out.println("Explicit wait result: " + result.getText());

            // Fluent wait: configure polling interval and ignored exception.
            driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
            driver.findElement(By.cssSelector("#start button")).click();

            FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);

            WebElement fluentResult = fluentWait.until(
                d -> d.findElement(By.cssSelector("#finish h4"))
            );
            System.out.println("Fluent wait result: " + fluentResult.getText());

            driver.quit();
    }
}
