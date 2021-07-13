import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class warmUpTask2 {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver","C:\\Users\\ilkin\\OneDrive\\Documents\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
driver.get("https://www.cars.com/");
driver.manage().window().maximize();
//driver.findElement(By.id("make-model-search-stocktype")).click();
Select pick = new Select(driver.findElement(By.id("make-model-search-stocktype")));
pick.selectByVisibleText("Used cars");
Select model = new Select(driver.findElement(By.id("makes")));
//model.selectByIndex(2);
       // System.out.println( model.getOptions());
        List<WebElement> list=model.getOptions();

        int numbers= list.size();
        for(WebElement models: list){
            models.getText();
            System.out.println("Model "+ models.getText());

        }
    }






}
