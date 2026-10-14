# JavaSeleniumBasics

Examples for Java + Selenium WebDriver 4 using Maven. No TestNG, ExtentReports, or logging framework is included.

## Requirements
- JDK 17+
- Maven 3.8+
- Chrome browser
- Internet access for dependencies and practice sites

Selenium Manager normally handles the ChromeDriver setup automatically.

## Open and run
1. Extract the ZIP.
2. Open the `JavaSeleniumBasics` folder in IntelliJ IDEA or Eclipse as a Maven project.
3. Let Maven download dependencies.
4. Run any class from `src/test/java/examples` using its `main` method.

Or from the project folder, compile:
```bash
mvn clean test-compile
```

To run a particular example with Maven, add an execution plugin or run its `main` method directly from your IDE. These are standalone demonstration classes, not test-framework test cases.

## Examples
- `BrowserNavigation` — browser startup and navigation
- `Locators` — ID, Name, Class, XPath, CSS, Link Text, Partial Link Text
- `WebElementActions` — click, sendKeys, getText, isDisplayed, isEnabled
- `WaitExamples` — implicit, explicit, fluent waits
- `DropdownExamples` — native Select and custom dropdown
- `AlertExamples` — accept, dismiss, get text, prompt input
- `FrameExamples` — switch into iframe and back
- `WindowExamples` — window handles and switching
- `ActionsExamples` — hover, right-click, keyboard, drag/drop sample
- `JavaScriptExamples` — scroll, read title, modify page style
- `ScreenshotExample` — save screenshot when a wait condition fails

## Practice websites
- https://the-internet.herokuapp.com/
- https://demoqa.com/
- https://www.selenium.dev/

Practice pages can change or occasionally be unavailable; update locators if their HTML changes.
