import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Demo {


    public static void main(String[] args) {

System.setProperty("webdriver.chrome.driver","C:\\Users\\ilkin\\OneDrive\\Documents\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    //driver.get("https://www.google.com/");
    driver.navigate().to("https://www.amazon.com/");
    driver.getCurrentUrl();
    String title =driver.getTitle();
        System.out.println(title);
        String name = driver.findElement(By.id("nav-xshop-container")).getText();
        System.out.println(name);
    //WebElement inputBox=driver.findElement(By.name("q"));
    //inputBox.sendKeys("Audi r8"+ Keys.ENTER);
    //driver.findElement(By.name("btnK")).click();
   //Assert.assertTrue(driver.getTitle().contains("Audi r8"));
//driver.quit();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Jersey"+Keys.ENTER);

       // System.out.println(driver.getPageSource());

      Assert.assertEquals("Amazon.com. Spend less. Smile more.",title);
      Assert.assertTrue("Amazon.com. Spend less. Smile more.".contains(title));

    }




}
