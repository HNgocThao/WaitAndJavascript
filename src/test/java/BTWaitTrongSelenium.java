import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BTWaitTrongSelenium {
    static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://rise.fairsketch.com/events");

        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']"))).sendKeys(Keys.CONTROL, "a", "admin@demo.com");
            driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']"))).sendKeys(Keys.CONTROL, "a", "riseDemo");
            driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button"))).click();

//        WebDriverWait driverWait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Events']")));
            driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Events']"))).click();
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));

    }
}
