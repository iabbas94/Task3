package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class LoginTest {

    private static Object Users;
    private static Object OneDrive;
    private static Object Documents;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ilkin\\OneDrive\\Documents\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
Thread.sleep(2000);
        String s = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPGTSTIVWXYZ";
        String random = "";
        for (int i = 0; i < 8; i++) {
            random += s.charAt((int) (Math.random() * s.length()));
        }

        //System.out.println(random);
        driver.navigate().to("http://duotifyapp.us-east-2.elasticbeanstalk.com/register.php");
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Welcome to Duotify!"));
        driver.findElement(By.id("hideLogin")).click();
        driver.findElement(By.id("username")).sendKeys(random);
        driver.findElement(By.id("firstName")).sendKeys("Ilkin");
        driver.findElement(By.id("lastName")).sendKeys("Abbas");
        driver.findElement(By.id("email")).sendKeys(random+"@gmail.com");
        driver.findElement(By.id("email2")).sendKeys(random+"@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Duo2021");
        driver.findElement(By.id("password2")).sendKeys("Duo2021");
        driver.findElement(By.name("registerButton")).click();
Thread.sleep(2000);
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("http://duotifyapp.us-east-2.elasticbeanstalk.com/browse.php?"));

        Assert.assertTrue(driver.getPageSource().contains("Ilkin Abbas"));
        driver.findElement(By.id("nameFirstAndLast")).click();

Thread.sleep(2000);
        driver.findElement(By.id("rafael")).click();
Thread.sleep(2000);
        String actualUrl2=driver.getCurrentUrl();
    Assert.assertTrue(actualUrl2.contains("http://duotifyapp.us-east-2.elasticbeanstalk.com/register.php"));

    driver.findElement(By.id("loginUsername")).sendKeys(random);
    driver.findElement(By.id("loginPassword")).sendKeys("Duo2021"+ Keys.ENTER);
Thread.sleep(2000);

        Thread.sleep(2000);
        System.out.println(driver.getPageSource().contains("You Might Also Like"));


        driver.findElement(By.id("nameFirstAndLast")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("rafael")).click();
        driver.quit();
    }




}
