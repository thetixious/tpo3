import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TextTranslation {
    private WebDriver driver;
    private String sourceLanguage;
    private String targetLanguage;
    private String operation;
    private String text;
    private JavascriptExecutor js;
    private String targetLink;

    @BeforeEach
    public void start(){
        targetLanguage = "ru";
        sourceLanguage = "en";
        operation = "translate";
        text = "hello world";
        System.setProperty("webdriver.chrome.driver", "/Users/tix/tpo/lab3/src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        js = (JavascriptExecutor) driver;

    }
    @Test
    public void testTranslation(){
        driver.get(String.format("https://translate.google.com/?sl=%s&tl=%s&text=%s&op=%s",sourceLanguage,targetLanguage,text,operation));
        WebElement ans = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[2]/div[2]/c-wiz[2]/div/div[6]/div/div[1]/span[1]/span/span"));
        Assertions.assertEquals("Привет, мир",ans.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
