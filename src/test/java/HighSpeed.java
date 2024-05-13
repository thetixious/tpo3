import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.datatransfer.Clipboard;

public class HighSpeed {
    private WebDriver driver;
    private String url;
    private String url2;
    private WebDriverWait wait;

    @BeforeEach
    public void start() {
        System.setProperty("webdriver.chrome.driver", "/Users/tix/tpo/lab3/src/test/resources/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 200);
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws InterruptedException {

        driver.get("https://translate.google.ru/");
        Thread.sleep(15000);
        WebElement settingButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"ow7\"]/div/span/button/div[3]"))));
        settingButton.click();
        WebElement pick = driver.findElement(By.xpath("//*[@id=\"i3\"]"));
        pick.click();
        WebElement soundPick = driver.findElement(By.xpath("//*[@id=\"ucj-1\"]/div[3]/div/div/div[1]/div[2]/button/span[2]"));
        soundPick.click();
        Thread.sleep(10000);

    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
