package tests;

import helpers.BaseHelper;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest extends BaseHelper
{

    @Before
    public void testInit() {
        driver.manage().window().maximize();
    }

    @After
    public void testTearDown() throws InterruptedException {
        driver.close();
        driver.quit();
    }


}