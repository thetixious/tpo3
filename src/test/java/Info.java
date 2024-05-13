import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Info {


    private WebDriver driver;
    private String url;
    private String url2;
    private WebDriverWait wait;

    @BeforeEach
    public void start() {
        System.setProperty("webdriver.chrome.driver", "/Users/tix/tpo/lab3/src/test/resources/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 200);
    }

    @Test
    public void testRule() throws InterruptedException {
        driver.get("https://translate.google.ru/");
        Thread.sleep(20000);
        WebElement set = driver.findElement(By.xpath("//*[@id=\"gb\"]/div[2]/div[1]/div[1]"));
        set.click();
        WebElement rule = driver.findElement(By.xpath("//*[@id=\"gb\"]/div[1]/div/div[2]/div/c-wiz/div/div[2]/a[1]"));
        rule.click();
        String url = driver.getCurrentUrl();
        Assertions.assertEquals("https://policies.google.com/?hl=ru", url);
    }

    @Test
    public void testRef() throws InterruptedException {

        driver.get("https://translate.google.ru/");
        Thread.sleep(20000);
        WebElement set = driver.findElement(By.xpath("//*[@id=\"gb\"]/div[2]/div[1]/div[1]"));
        set.click();
        WebElement rule = driver.findElement(By.xpath("//*[@id=\"gb\"]/div[1]/div/div[2]/div/c-wiz/div/div[2]/a[2]"));
        rule.click();
        String url = driver.getCurrentUrl();
        Assertions.assertEquals("https://support.google.com/translate/?hl=ru#topic=7011755", url);
    }
    @Test
    public void testSendRev() throws InterruptedException {
        driver.get("https://translate.google.ru/");
        Thread.sleep(20000);
        WebElement set = driver.findElement(By.xpath("//*[@id=\"gb\"]/div[2]/div[1]/div[1]"));
        set.click();
        WebElement rule = driver.findElement(By.xpath("//*[@id=\"gb\"]/div[1]/div/div[2]/div/c-wiz/div/div[2]/a[4]"));
        rule.click();
        String url = driver.getCurrentUrl();
        Assertions.assertEquals("https://about.google/?hl=ru", url);
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
