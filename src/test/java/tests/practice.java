package tests;


import base.TestBase;

import org.testng.annotations.Test;
import page.selectorsPage;


public class practice extends TestBase {


    @Test
    public void selenium_test1() throws InterruptedException {
        selectorsPage selectorsPage = new selectorsPage(driver);
        selectorsPage.clickDisabled();

    }



}
