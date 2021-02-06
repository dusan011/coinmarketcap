package pages;

import helpers.BaseHelper;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class CoinMarketCapAddToWatch extends BaseHelper
{

    private List<WebElement> cryptos()
    {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("cmc-table")));
        WebElement table = driver.findElement(By.className("cmc-table"));
        WebElement tbody = table.findElement(By.tagName("tbody"));
        List<WebElement> results = tbody.findElements(By.tagName("tr"));
        results.removeIf(result->result.getAttribute("class").contains("fENxkl"));
        System.out.println("Result is "+results.size());
        return results;
    }

    private void closePopUp()
    {
        List<WebElement> popup = driver.findElements(By.xpath("/html/body/div[2]/div/div[1]/div/svg"));
        if(popup.size()>0)
        {
            popup.get(0).click();
        }
    }


    private void addToWatch() throws InterruptedException {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[1]/div[1]/div[2]/a[2]")));
        driver.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/div[2]/a[2]")).click();

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/main/form/div[2]/input")));
        WebElement email = driver.findElement(By.xpath("/html/body/div/main/form/div[2]/input"));
        email.sendKeys("dusanp93@icloud.com");
        WebElement password = driver.findElement(By.xpath("/html/body/div/main/form/div[5]/input"));
        password.sendKeys("Codekurs93!");
        WebElement logIn = driver.findElement(By.className("ekKQHW"));
        logIn.click();

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("tbody")));
        List<Crypto> clickedCryptos = new ArrayList<Crypto>();
        List<WebElement> results = cryptos();

        results.get(1).findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/table/tbody/tr[2]/td[1]/span/span")).click();
        closePopUp();

        Crypto c1 = new Crypto();
        c1.symbol = results.get(1).findElement(By.className("coin-item-symbol")).getText();
        clickedCryptos.add(c1);

        js.executeScript("arguments[0].click();",driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[1]/div[1]/a[1]/button")));
        wdWait.until(ExpectedConditions.urlToBe("https://coinmarketcap.com/watchlist/"));


        List<WebElement> watchLists = cryptos();

        for (int i =0; i<watchLists.size(); i++)
        {
            System.out.println(watchLists.size());
            System.out.println("Symbol from watchlist:"+watchLists.get(i).findElement(By.className("coin-item-symbol")).getText());
            System.out.println("Symbol I added:"+clickedCryptos.get(i).symbol);
            Assert.assertEquals(watchLists.get(i).findElement(By.className("coin-item-symbol")).getText(),clickedCryptos.get(i).symbol);
        }
        Thread.sleep(5000);
    }



    public void coinMarketCapAddToWatch() throws InterruptedException {
        navigateToCoinMarketCap("https://coinmarketcap.com/");
        addToWatch();
    }
}
