package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class DropdownExamples {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();

            // Native HTML <select> dropdown.
            driver.get("https://the-internet.herokuapp.com/dropdown");
            WebElement dropdownElement = driver.findElement(By.id("dropdown"));
            Select dropdown = new Select(dropdownElement);
            dropdown.selectByVisibleText("Option 2");
            System.out.println("Selected: " + dropdown.getFirstSelectedOption().getText());

            // Custom dropdown: click the menu, then click an option.
            driver.get("https://demoqa.com/select-menu");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement customDropdown = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("withOptGroup"))
            );
            customDropdown.click();

            WebElement option = wait.until(
                ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@id,'react-select-2-option-1-1')]")
                )
            );
            option.click();
            System.out.println("Custom dropdown selected.");

            driver.quit();
    }
}
