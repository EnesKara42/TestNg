package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class selectorsPage {
    WebDriver driver;



    public selectorsPage(WebDriver driver){

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//select[@name='cars']")
    public WebElement dropdown;

    @FindBy(xpath="//input[@type='date']")
    public WebElement date;

    @FindBy(xpath="//input[@id='ohrmList_chkSelectRecord_14']")
    public WebElement jordanMathews;

    @FindBy(xpath="//input[@id='jex']")
    public WebElement CurrentCrashName;

    @FindBy(xpath="//*[@id='pact2']")
    public WebElement iFrame;

    @FindBy(xpath="//input[@id='tea']")
    public WebElement root1;

    @FindBy(xpath="//input[@id='userId']")
    public WebElement EnterEmail;


    @FindBy(xpath="//input[contains(@placeholder,'First Enter')]")
    public WebElement EnterFirstName;
    @FindBy(xpath="//input[contains(@placeholder,'Last')]")
    public WebElement EnterLastName;


}
