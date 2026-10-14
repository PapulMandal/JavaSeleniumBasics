package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsExamples {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);

        // Mouse hover.
        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement image = driver.findElement(By.cssSelector(".figure"));
        actions.moveToElement(image).perform();
        System.out.println(driver.findElement(By.cssSelector(".figure .figcaption h5")).getText());

        // Right-click.
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement hotSpot = driver.findElement(By.id("hot-spot"));
        actions.contextClick(hotSpot).perform();
        driver.switchTo().alert().accept();

        // Keyboard actions.
        driver.get("https://the-internet.herokuapp.com/key_presses");
        WebElement input = driver.findElement(By.id("target"));
        input.sendKeys("Selenium");
        actions.click(input).keyDown(Keys.CONTROL).sendKeys("a")
                .keyUp(Keys.CONTROL).sendKeys("Hello").perform();
        System.out.println(driver.findElement(By.id("result")).getText());

        // Drag and drop example page:
        // driver.get("https://demoqa.com/droppable");
        // WebElement source = driver.findElement(By.id("draggable"));
        // WebElement target = driver.findElement(By.id("droppable"));
        // actions.dragAndDrop(source, target).perform();

        driver.quit();
    }
}

