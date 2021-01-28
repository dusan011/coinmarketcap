package pages;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

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

    public void coinMarketCap()
    {
        navigateToCoinMarketCap("https://coinmarketcap.com/");
    }
}
