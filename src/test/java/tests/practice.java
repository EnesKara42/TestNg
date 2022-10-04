package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.selectorsPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class practice {



    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");

        //Maximize the page
        driver.manage().window().maximize();

        //Implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }



    @Test
    public void selenium_test1() throws InterruptedException {
       selectorsPage selectorsPage=new selectorsPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;




         driver.get("https://selectorshub.com/xpath-practice-page/");







        WebElement EnterFirstName= driver.findElement(By.xpath("//input[contains(@placeholder,'First Enter')]"));
        WebElement EnterLastName= driver.findElement(By.xpath("//input[contains(@placeholder,'Last')]"));




        /**
         * Disabled bir elementi enabled yapma ve içine bir şeyler yazdırma
         */
        js.executeScript("arguments[0].disabled=false", selectorsPage.EnterFirstName);
        js.executeScript("arguments[0].disabled=false", selectorsPage.EnterLastName);
        Thread.sleep(3000);
    EnterFirstName.sendKeys("sarıların");
        EnterLastName.sendKeys("sülo");
        Thread.sleep(3000);
    }


    @AfterMethod
    public void tearDown(){
        driver.close();
    }


}
