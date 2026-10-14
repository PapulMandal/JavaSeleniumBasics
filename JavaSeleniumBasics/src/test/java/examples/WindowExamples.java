
package examples;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WindowType;

public class WindowExamples {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");

        String parentWindow = driver.getWindowHandle();

        driver.findElement(By.linkText("Click Here")).click();

        Set<String> allWindows = driver.getWindowHandles();

        String childWindow = allWindows.stream()
                .filter(window -> !window.equals(parentWindow))
                .findFirst()
                .orElseThrow();

        driver.switchTo().window(childWindow);

        System.out.println("Child title: " + driver.getTitle());
        System.out.println("Child text: "
                + driver.findElement(By.tagName("h3")).getText());

        driver.close();

        driver.switchTo().window(parentWindow);
        System.out.println("Parent title: " + driver.getTitle());

        // driver.switchTo().newWindow(WindowType.TAB);
        // driver.get("https://www.selenium.dev/");

        driver.quit();
    }
}
