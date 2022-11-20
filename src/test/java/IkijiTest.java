import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class IkijiTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver= new ChromeDriver();
    }

    @Test
    public void increaseAmountOfItemByPlusButton(){
        driver.get("https://store.ikiji.jp/products/tps-sweat-shirttps%E7%B8%AB%E8%A3%BD%E8%A3%8F%E8%B5%B7%E6%AF%9B%E3%82%B9%E3%82%A6%E3%82%A7%E3%83%83%E3%83%88%E3%82%B7%E3%83%A3%E3%83%84-br-22aw%E6%96%B0%E8%89%B2?variant=42814778572957");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class=\"ProductForm__AddToCart Button Button--secondary Button--full\"]")));
        WebElement addToCartButton = driver.findElement(By.xpath("//button[@class=\"ProductForm__AddToCart Button Button--secondary Button--full\"]"));
        addToCartButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"shopify-section-cart-template\"]/section/div/div/form/div/div[2]/div[3]/div/div/a[2]")));
        WebElement plusButton = driver.findElement(By.xpath("//*[@id=\"shopify-section-cart-template\"]/section/div/div/form/div/div[2]/div[3]/div/div/a[2]"));
        plusButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"updates_42814778572957:2fe52fcb631dd3ae648b16da3b2b023d\"]")));
        WebElement productAmount = driver.findElement(By.xpath("//*[@id=\"updates_42814778572957:2fe52fcb631dd3ae648b16da3b2b023d\"]"));
        Assert.assertEquals(productAmount.getAttribute("value"),"2","amount is not 2, its "+ productAmount.getAttribute("value"));

    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
