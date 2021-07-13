import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.text.Utilities;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WarmUpTask3 {


    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver","C:\\Users\\ilkin\\OneDrive\\Documents\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.bloomberg.com/markets/stocks");
        List<String> expectedValues= Arrays.asList("Name" , "Value", 	"Net Change", "% Change", 	"1 Month", 	"1 Year", 	"Time (EDT");
        List<WebElement> elements=  driver.findElements(By.xpath("//div[@data-view-uid='1|0_3_3']//tr[@class='data-table-headers']//th"));

    }

}
