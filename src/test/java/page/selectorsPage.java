package page;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import io.github.sukgu.Shadow;
import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class selectorsPage {
    WebDriver driver;


    public selectorsPage(WebDriver driver) {

        this.driver = driver;
    }


    By dropdown = By.xpath("//select[@name='cars']");

    By date = By.xpath("//input[@type='date']");


    By jordanMathews = By.xpath("//input[@id='ohrmList_chkSelectRecord_14']");


    By CurrentCrashName = By.xpath("//input[@id='jex']");


    By iFrame = By.xpath("//*[@id='pact2']");


    By root1 = By.xpath("//input[@id='tea']");


    By EnterEmail = By.xpath("//input[@id='userId']");

    By dropdown1 = By.xpath("//select[@name='tablepress-1_length']");


    By EnterFirstName = By.xpath("//input[contains(@placeholder,'First Enter')]");

    By EnterLastName = By.xpath("//input[contains(@placeholder,'Last')]");


    public void clickDisabled() throws InterruptedException {
        /**
         * Turn disabled button to enabled
         */
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));


        driver.navigate().to("https://selectorshub.com/xpath-practice-page/");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder,'First Enter')]")));
        js.executeScript("arguments[0].disabled=false", driver.findElement(EnterFirstName));
        js.executeScript("arguments[0].disabled=false", driver.findElement(EnterLastName));

        driver.findElement(EnterFirstName).sendKeys("enes");
        driver.findElement(EnterLastName).sendKeys("kara");

    }

    public void dropdown2(String car_name) throws InterruptedException, IOException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Shadow shadow = new Shadow(driver);

        /**
         * Select dropdown handle etme , ve seçilen dropdownu yazdırma
         */
        Select dropdown3 = new Select(driver.findElement(dropdown1));
        dropdown3.selectByValue("50");
        WebElement memet = dropdown3.getFirstSelectedOption();

        System.out.println(memet.getText());

        /**
         * select dropdown handle etme
         */
        driver.get(ConfigurationReader.getProperty("url"));

        Select dropdown1 = new Select(driver.findElement(dropdown));
        dropdown1.selectByValue(car_name);
        Thread.sleep(5000);
        WebElement selected = dropdown1.getFirstSelectedOption();
        String actualResult = selected.getAttribute("value");
        System.out.println("actualResult = " + actualResult);
        String expedtedResult = car_name;
        driver.findElement(date).sendKeys("09091995");

        /**
         * Shadow elementleri handle etme yöntemi
         * ilk önce benim shadow element iframe in içinde olduğu için iframe e geçiş yaptım
         * #shadow-root yazısının üstündeki elementi locate ettim
         * searchContext kodunu yapıştır
         * işlem yapmak istediğin elementi locate et css ile ama
         * yapmak istediğin işlemi yap
         * en son frameden çık
         */

        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"pact\"]")));

        WebElement root1 = driver.findElement(By.xpath("//*[@id=\"snacktime\"]"));
        SearchContext shadowRoot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root1);
        WebElement shadowElement = shadowRoot.findElement(By.cssSelector("input[id=tea]"));
        shadowElement.sendKeys("enes");
        driver.switchTo().parentFrame();

        /**
         * iframe içinde iframe olunca aiağıdaki gibi yapman gerek
         */
        driver.switchTo().frame("pact1");
        driver.switchTo().frame("pact2");

        driver.findElement(CurrentCrashName).sendKeys("enes");
        driver.switchTo().defaultContent();

        Thread.sleep(3000);

        /**
         * intercepted click exception çözümü
         */
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", driver.findElement(jordanMathews));

        /**
         * screenshot of web element
         */
        File srcFile = driver.findElement(date).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(srcFile, new File("./target/test-classes/enes.png"));

        Assert.assertEquals(expedtedResult, actualResult);

    }


}
