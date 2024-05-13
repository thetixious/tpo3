import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ImageTranslation {

    private WebDriver driver;
    private Clipboard clipboard;
    private String ans;
    private String translatedText;
    private WebDriverWait waitF;

    @BeforeEach
    public void start(){
        System.setProperty("webdriver.chrome.driver", "/Users/tix/tpo/lab3/src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        waitF = new WebDriverWait(driver, 100);
        ans = "В маленьком городке зеленщик открыл магазин, "+
              "  расположенный над глубоким подвалом. Каждую ночь из этого"+
      "  подвала в магазин толпами приходили мыши. Они ели"+
     "   яблоки и груши, виноград и орехи и не жалели";




    }

    @Test
    public void test() throws InterruptedException, IOException, UnsupportedFlavorException {
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        driver.get("https://translate.google.ru/");
        WebElement buf = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/div/div[2]/div[1]/div[3]/div[1]/div[1]/form[2]/div/div/button/span"));
        buf.click();
        WebElement imageButton = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[1]/nav/div[2]/div/button/span"));
        imageButton.click();
        Thread.sleep(5000);
        WebElement bufferButton = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[5]/c-wiz/div[2]/c-wiz/div/div/div/div[1]/div[2]/div[2]/div[2]/div/button/span"));
        bufferButton.click();
        Thread.sleep(5000);
        WebElement copyButton = waitF.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[5]/c-wiz/div[2]/c-wiz/div/div[1]/div[2]/div[1]/button/span[2]")));
        copyButton.click();
        translatedText = (String) clipboard.getData(DataFlavor.stringFlavor);
        Assertions.assertEquals(ans,translatedText);



    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
