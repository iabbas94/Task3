import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutomationTask3 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ilkin\\OneDrive\\Documents\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://www.carfax.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@class='button button--green']")).click();
        Assert.assertTrue(driver.getTitle().contains("Used Cars"));
        Select make = new Select(driver.findElement(By.xpath("//select[@class='form-control search-make search-make--lp']")));
        make.selectByIndex(31);

        String[] arr = {"All Models", " Model 3 ", " Model S ", " Model X ", " Model Y ", " Roadster "};

        Select model = new Select(driver.findElement(By.xpath("//select[@name='model']")));
        List<WebElement> list1 = model.getOptions();
        System.out.println(list1.size());
        for (int i = 0; i < list1.size(); i++) {

            Assert.assertEquals(arr[i], list1.get(i).getText());
        }

        model.selectByIndex(2);
        driver.findElement(By.xpath("//input[@name='zip']")).sendKeys("22182" + Keys.ENTER);

        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//h3[@class='searchForm-wrapper-header--lp']")).getText(), "Step 2 - Show me cars with");


        List<WebElement> checkBox = driver.findElements(By.xpath("//span[@class='checkbox-list-item--fancyCbx']"));
        Thread.sleep(2000);
        System.out.println(checkBox.size());
        for (WebElement box : checkBox) {
            if (!box.isSelected())


                box.click();
        }
//String resultNum=driver.findElement(By.xpath("//span[@class='totalRecordsText']")).getAttribute("value");
        //System.out.println(resultNum);
        System.out.println(Integer.parseInt(driver.findElement(By.xpath("//span[@class='totalRecordsText']")).getText()));
        driver.findElement(By.xpath("//button[@class='button large primary-green show-me-search-submit']")).click();

        //Assert.assertEquals(Integer.parseInt(driver.findElement(By.xpath("//span[@class='totalRecordsText']")).getText()),.getSize());
        //System.out.println( driver.findElement(By.xpath("//*[@id='ucl-microapp-srp-content']/div/div[2]")).getSize());

        int resultOnPage = Integer.parseInt(driver.findElement(By.xpath("//span[@id='totalResultCount']")).getText().substring(0, 2));
        int webNum = driver.findElements(By.xpath("//article[@class='srp-list-item']")).size();
//Assert.assertEquals(resultOnPage,webNum);


        List<WebElement> results = driver.findElements(By.xpath("//h4[@class='srp-list-item-basic-info-model']"));
        Thread.sleep(2000);
        for (WebElement result : results) {

            //Assert.assertTrue(result.getText().contains("Tesla Model S"));

        }

        List<String> priceList = new ArrayList<>();
        List<WebElement> webPrices = driver.findElements(By.xpath("//span[@class='srp-list-item-price']"));

        for (WebElement webPrice : webPrices) {

            if (webPrice.getText().contains("$"))
                priceList.add(webPrice.getText().substring(7));


        }
        System.out.println(priceList);
        Thread.sleep(2000);
        Select selectOption = new Select(driver.findElement(By.xpath("//select[@class='srp-header-sort-select srp-header-sort-select-desktop--srp']")));
        selectOption.selectByIndex(1);


        Thread.sleep(2000);

        List<WebElement> checkPrices = driver.findElements(By.xpath("//span[@class='srp-list-item-price']"));
        for (int i = 0; i <= checkPrices.size() - 1; i++) {

            if (Integer.parseInt(webPrices.get(i).getText().substring(1).replace(",", "")) > Integer.parseInt(webPrices.get(i + 1).getText().substring(1).replace(",", ""))) {

            }

            System.out.println("Test passed");
        }

        Select selectMileage = new Select(driver.findElement(By.xpath("//select[@class='srp-header-sort-select srp-header-sort-select-desktop--srp']")));
        selectOption.selectByIndex(4);

        List<WebElement> mileage = driver.findElements(By.className("srp-list-item-basic-info-value"));
        for (int i = 0; i <= mileage.size(); i++) {
            if (Integer.parseInt(mileage.get(i).getText().substring(9)) < Integer.parseInt(mileage.get(i + 1).getText().substring(9))) {
                System.out.println("passed");
                // }


            }


            Thread.sleep(2000);
            Select selectYear = new Select(driver.findElement(By.xpath("//select[@class='srp-header-sort-select srp-header-sort-select-desktop--srp']")));
            selectOption.selectByIndex(5);
            Thread.sleep(2000);
            List<WebElement> year = driver.findElements(By.xpath("//h4[@class='srp-list-item-basic-info-model']"));
            int newerYear = Integer.parseInt(year.get(1).getText().substring(0, 4));
            int olderYear = Integer.parseInt(year.get(2).getText().substring(0, 4));
            if (newerYear > olderYear) {
                System.out.println("Passed");

            }
       driver.close();
        }

    }
