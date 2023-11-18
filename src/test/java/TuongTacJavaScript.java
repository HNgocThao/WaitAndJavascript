import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class TuongTacJavaScript {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        // Init Java Script
        JavascriptExecutor javaScripts = (JavascriptExecutor) driver;


        String DYNAMIC_INPUT_PLACEHOLDER_FORM = "//input[@placeholder='%s']";
// Send Key Full Name
        String fullNameXPath = String.format(DYNAMIC_INPUT_PLACEHOLDER_FORM, "Full Name");
        WebElement fullNameEle = driver.findElement(By.xpath(fullNameXPath));
        javaScripts.executeScript("arguments[0].value = 'Vincent';", fullNameEle);
        String text = (String) javaScripts.executeScript("return arguments[0].value;", fullNameEle);
        System.out.println("Full Name: " + text);


// Send Key Full Name
        String emailXPath = String.format(DYNAMIC_INPUT_PLACEHOLDER_FORM, "name@example.com");
        WebElement emailEle = driver.findElement(By.xpath(emailXPath));
        javaScripts.executeScript("arguments[0].value = 'vincent@gmail.com';", emailEle);
        String email = (String) javaScripts.executeScript("return arguments[0].value;", emailEle);
        System.out.println("Email : " + email);


        String DYNAMIC_TEXTAREA_ID_FORM = "//textarea[@id='%s']";
// Input current address
        String currentXPath = String.format(DYNAMIC_TEXTAREA_ID_FORM, "currentAddress");
        WebElement currentEle = driver.findElement(By.xpath(currentXPath));
        javaScripts.executeScript("arguments[0].value = 'KĐT Nam Trung Yên, P. Yên Hòa, Q. Cầu Giấy, TP Hà Nội';", currentEle);
        String currentAdd = (String) javaScripts.executeScript("return arguments[0].value;", currentEle);
        System.out.println("Current Address : " + currentAdd);

// Input Permanent address
        String permanentXPath = String.format(DYNAMIC_TEXTAREA_ID_FORM, "permanentAddress");
        WebElement permanentEle = driver.findElement(By.xpath(permanentXPath));
        javaScripts.executeScript("arguments[0].value = 'Q. Cầu Giấy, TP Hà Nội';", permanentEle);
        String permanent = (String) javaScripts.executeScript("return arguments[0].value;", permanentEle);
        System.out.println("Permanent Address : " + permanent);

// Click to Submit
        String buttonXPath = "//button[@id='submit']";
        WebElement submitEle = driver.findElement(By.xpath(buttonXPath));
        javaScripts.executeScript("arguments[0].click()", submitEle);
//        Actions actions = new Actions(driver);
//        Thread.sleep(2000);
//        actions.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("r").keyUp(Keys.CONTROL).keyUp(Keys.SHIFT).release().build().perform();
    }
}
