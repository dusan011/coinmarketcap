package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CoinMarketCap extends BaseHelper
{

    public CoinMarketCap(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void navigateToCoinMarketCap(String url)
    {
        driver.get(url);
    }

    private void closePopUps()
    {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("cmc-button-plain")));
        WebElement questionPopUp = driver.findElement(By.className("cmc-button-plain"));
        questionPopUp.click();
        WebElement cookiePopUp = driver.findElement(By.className("cmc-cookie-policy-banner__close"));
        cookiePopUp.click();
    }

    public void coinMarketCap()
    {
        navigateToCoinMarketCap("https://coinmarketcap.com/");
        closePopUps();
    }
}
