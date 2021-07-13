import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class iframes {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ilkin\\OneDrive\\Documents\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/iframe");


    driver.switchTo().frame("mce_0_ifr");
    driver.switchTo().defaultContent();

    }


}
