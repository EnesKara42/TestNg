package tests;


import base.TestBase;
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

public class practice extends TestBase {


    @Test
    public void selenium_test1() throws InterruptedException {
        selectorsPage selectorsPage = new selectorsPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        Thread.sleep(6000);
        driver.navigate().to("https://selectorshub.com/xpath-practice-page/");

        /**
         * Disabled bir elementi enabled yapma ve içine bir şeyler yazdırma
         */
        js.executeScript("arguments[0].disabled=false", selectorsPage.EnterFirstName);
        js.executeScript("arguments[0].disabled=false", selectorsPage.EnterLastName);
        Thread.sleep(3000);
        selectorsPage.EnterFirstName.sendKeys("sarıların");
        selectorsPage.EnterLastName.sendKeys("sülo");
        Thread.sleep(3000);
    }


}
