import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class WarmUpTask {

    public static void main(String[] args) {



        System.setProperty("webdriver.chrome.driver","C:\\Users\\ilkin\\OneDrive\\Documents\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/Products.aspx");
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']")).sendKeys("Tester");
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']")).sendKeys("test"+ Keys.ENTER);
        driver.findElement(By.xpath("//a[.='View all products']")).click();
       int rowNum= driver.findElements(By.xpath("//table[@class='ProductsTable']//tr")).size();
       int colNum=driver.findElements(By.xpath("//table[@class='ProductsTable']//tr[1]//th")).size();
        //System.out.println( driver.findElement(By.xpath("//table[@class='ProductsTable']//tr[1]//td[1]")).getText());
        for(int i= 2; i<=rowNum; i++) {
            for (int j = 1; j <= colNum; j++) {

                String xPath = "//table[@class='ProductsTable']//tr[" + i + "]//td[" + j + "]";
                System.out.println(driver.findElement(By.xpath(xPath)).getText()+"\t");
            }
            System.out.println();
        }

        //System.out.println();
    }

        }











        //System.out.println(driver.findElement(By.xpath("//input[@id='unifiedLocation1ClickAddress']")).getSize());


//       List<WebElement> links = driver.findElements(By.tagName("a"));
//        System.out.println(links);
//
//        for(WebElement element:links){
//
//            System.out.println(element.getAttribute("href"));
//        }

   //driver.findElement(By.partialLinkText("Cont")).click();

//String attribute=driver.findElement(By.className("button subscribe-button w-button")).getAttribute("value");
//        System.out.println(attribute);









