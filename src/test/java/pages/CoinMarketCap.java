package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CoinMarketCap extends BaseHelper
{

    @FindBy(className = "cmc-button-plain")
    WebElement questionPopUp;

    @FindBy(className = "cmc-cookie-policy-banner__close")
    WebElement cookiePopUp;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div/div[1]/div[2]/div/div")
    WebElement showRows;

    @FindBy(xpath = "//*[@id=\"tippy-6\"]/div/div[1]/div/div/button[2]")
    WebElement row50;

    @FindBy(className = "cmc-table")
    WebElement table;

    @FindBy(className = "tbody")
    WebElement tbody;

    public static int numberOfCryptoCurrencies = 0;

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
        questionPopUp.click();
        cookiePopUp.click();
    }

    private void clickOnShowRows()
    {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("sc-16r8icm-0")));
        showRows.click();
    }

    private void clickOnRow50()
    {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"tippy-6\"]/div/div[1]/div/div/button[2]")));
        row50.click();
    }

    private void first50Currencies()
    {
        wdWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div/div[2]/table/tbody/tr[58]")));
        tbody = table.findElement(By.tagName("tbody"));
        List<WebElement> first50CryptoCurrencies = tbody.findElements(By.tagName("tr"));
        first50CryptoCurrencies.removeIf(result->result.getAttribute("class").contains("sc-15ks4ej-1"));
        numberOfCryptoCurrencies = first50CryptoCurrencies.size();
        System.out.printf("Number of cryptocurrencies "+first50CryptoCurrencies.size());
    }

    public void coinMarketCap()
    {
        navigateToCoinMarketCap("https://coinmarketcap.com/");
        closePopUps();
        clickOnShowRows();
        clickOnRow50();
        first50Currencies();
    }
}
