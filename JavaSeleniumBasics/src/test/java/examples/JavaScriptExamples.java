package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExamples {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.selenium.dev/");

            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Scroll to the bottom and back to the top.
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            Thread.sleep(500);
            js.executeScript("window.scrollTo(0, 0);");

            // Read a JavaScript property.
            String title = (String) js.executeScript("return document.title;");
            System.out.println("Document title: " + title);

            // Scroll an element into view and demonstrate JS click.
            WebElement link = driver.findElement(By.cssSelector("a[href*='documentation']"));
            js.executeScript("arguments[0].scrollIntoView({block:'center'});", link);
            // Prefer WebElement.click() when it works; use JS click for special cases only.
            // js.executeScript("arguments[0].click();", link);

            // Change the page background for demonstration.
            js.executeScript("document.body.style.backgroundColor = 'lightyellow';");

            driver.quit();
        }
    }
