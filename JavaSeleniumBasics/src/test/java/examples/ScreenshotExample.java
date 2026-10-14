
package examples;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotExample {

    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");

        File screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        Files.copy(screenshot.toPath(), Path.of("screenshot.png"));

        driver.quit();
    }
}
