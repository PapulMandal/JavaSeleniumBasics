package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();
            driver.get("https://the-internet.herokuapp.com/login");

            WebElement usernameById = driver.findElement(By.id("username"));
            WebElement usernameByName = driver.findElement(By.name("username"));
            WebElement loginFormByClass = driver.findElement(By.className("login"));
            WebElement usernameByXPath = driver.findElement(By.xpath("//input[@id='username']"));
            WebElement usernameByCss = driver.findElement(By.cssSelector("input#username"));
            WebElement loginLinkByText = driver.findElement(By.linkText("Elemental Selenium"));
            WebElement partialLink = driver.findElement(By.partialLinkText("Elemental"));

            System.out.println(usernameById.getAttribute("placeholder"));
            System.out.println(usernameByName.isDisplayed());
            System.out.println(loginFormByClass.isDisplayed());
            System.out.println(usernameByXPath.isEnabled());
            System.out.println(usernameByCss.getTagName());
            System.out.println(loginLinkByText.getText());
            System.out.println(partialLink.getText());

            driver.quit();
    }
}
