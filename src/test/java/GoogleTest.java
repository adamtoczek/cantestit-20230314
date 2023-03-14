import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class GoogleTest {
    WebDriver driver;

    @BeforeClass
    public void setupSelenium() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("uruchamiam się przed kazda metoda testowa");
    }


    @Test
    public void searchForCantestIt() throws InterruptedException {
        driver.get("http://google.com");

        List<WebElement> gdprButtons = driver.findElements(By.cssSelector("button[data-ved]>div[role]"));
        gdprButtons.get(2).click();

        WebElement searchFiled = driver.findElement(By.name("q"));
        searchFiled.sendKeys("cantestit"+ Keys.ENTER);

        String firstTitle =  driver.findElement(By.cssSelector("#rso>div:first-of-type div.g div.g h3")).getText();

        assertTrue(firstTitle.contains("CanTest IT"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
