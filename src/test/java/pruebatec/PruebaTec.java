package pruebatec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class PruebaTec {
    private WebDriver driver;

    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mercadolibre.com/");
        driver.manage().window().maximize();

        WebElement inputBO = driver.findElement(By.id("BO"));
        inputBO.click();

        WebElement Buttoncookies = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/button[1]"));
        Buttoncookies.click();

        WebElement ButtonSms = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/button"));
        ButtonSms.click();


        WebElement search = driver.findElement(By.id("cb1-edit"));
        search.sendKeys("reloj");
        search.submit();

        WebElement nuevo = driver.findElement(By.className("ui-search-filter-name"));
        nuevo.click();


        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        boolean product1;
        boolean product2;
        boolean product3;

        try {

            product1 = driver.findElements(By.xpath("//*[@id=\"root-app\"]/div/div/section/ol/li[1]/div/div/div[2]/div[1]/a/h2")).size() != 0;
            product2 = driver.findElements(By.xpath("//*[@id=\"root-app\"]/div/div/section/ol/li[2]/div/div/div[2]/div[1]/a/h2")).size() != 0;
            product3 = driver.findElements(By.xpath("//*[@id=\"root-app\"]/div/div/section/ol/li[3]/div/div/div[2]/div[1]/a/h2")).size() != 0;
        } catch (NoSuchElementException e){

            System.out.println("Error");
        }

        driver.quit();
    }

    public static void main(String arg[]){
        PruebaTec pruebaTec = new PruebaTec();
        pruebaTec.setUp();
    }
}
