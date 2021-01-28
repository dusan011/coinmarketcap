package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.CoinMarketCap;

public class CoinMarketCapTest extends BaseTest
{
    @Test
    public void coinMarketCapTest() throws InterruptedException {
        CoinMarketCap coinMarketCap = new CoinMarketCap(driver);
        coinMarketCap.coinMarketCap();
        Assert.assertTrue("There are no 50 cryptocurrencies in the list after filtering by row", coinMarketCap.numberOfCryptoCurrencies == 50);
        Thread.sleep(5000);
    }
}
