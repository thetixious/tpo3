import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.datatransfer.Clipboard;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SiteTranslation {
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
        url = "https://stackoverflow.com/questions/58872451/how-can-i-bypass-the-google-captcha-with-selenium-and-python";
        url2 = "https://stackoverflow-com.translate.goog/questions/58872451/how-can-i-bypass-the-google-captcha-with-selenium-and-python?_x_tr_sl=auto&_x_tr_tl=ru&_x_tr_hl=ru&_x_tr_pto=wapp";
    }
    @Test
    public  void siteTest() throws InterruptedException {
        driver.get("https://translate.google.ru/");
//        WebElement buf = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/div/div[2]/div[1]/div[3]/div[1]/div[1]/form[2]/div/div/button/span"));
//        buf.click();
        WebElement imageButton = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[1]/nav/div[4]/div/button/span"));
        imageButton.click();
        WebElement input = driver.findElement(By.xpath("//*[@id=\"i48\"]"));
        input.sendKeys(url);
        String firstWindowHandle = driver.getWindowHandle();
        WebElement inputButton = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[4]/c-wiz/div[2]/div/span/button/span"));
        inputButton.click();
        Thread.sleep(100000);
        Set<String> windowHandles = driver.getWindowHandles();
        String secondWindowHandle = null;
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(firstWindowHandle)) {
                secondWindowHandle = windowHandle;
                break;
            }
        }
        driver.switchTo().window(secondWindowHandle);
        String newPageUrl = driver.getCurrentUrl();
        System.out.println("URL новой страницы: " + newPageUrl);
        WebElement title = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"question-header\"]/h1/a/font/font")));
        Assertions.assertEquals(url2,newPageUrl);
        Assertions.assertEquals("Как я могу обойти Google CAPTCHA с помощью Selenium и Python?",title.getText());



    }

}
