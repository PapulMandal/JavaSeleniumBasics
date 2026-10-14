package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementActions {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();
            driver.get("https://the-internet.herokuapp.com/login");

            WebElement username = driver.findElement(By.id("username"));
            WebElement password = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

            username.clear();
            username.sendKeys("tomsmith");
            password.sendKeys("SuperSecretPassword!");
            System.out.println("Username displayed: " + username.isDisplayed());
            System.out.println("Button enabled: " + loginButton.isEnabled());
            loginButton.click();

            WebElement message = driver.findElement(By.id("flash"));
            System.out.println("Message: " + message.getText());

            driver.quit();
        }
    }
