import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class LoginTest {

    @Test
    public void test() throws InterruptedException {
        //forget and forgive
        System.setProperty("webdriver.chrome.driver", "/Users/tix/tpo/lab3/src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://translate.google.ru/");
        Thread.sleep(3000);
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"gb\"]/div[2]/div[3]/div[1]/a"));
        loginButton.click();
        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"identifierId\"]"));
        WebElement nextLogin = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span"));
        nextLogin.click();
        Thread.sleep(1000);
        WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
        WebElement passwordNext = driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span"));
        passwordNext.click();

        // Ожидание некоторого времени для обработки текста


        Thread.sleep(3000);
        // Закрытие браузера
        driver.close();
        driver.quit();
    }

}



