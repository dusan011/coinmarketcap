package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.CoinMarketCap;
import pages.CoinMarketCapAddToWatch;

public class CoinMarketCapTest extends BaseTest
{
    @Test
    public void coinMarketCapTest() throws InterruptedException {
       // CoinMarketCap coinMarketCap = new CoinMarketCap(driver);
        //coinMarketCap.coinMarketCap();
        //Assert.assertTrue("There are no 50 cryptocurrencies in the list after filtering by row", coinMarketCap.numberOfCryptoCurrencies == 50);
        CoinMarketCapAddToWatch c2 = new CoinMarketCapAddToWatch();
        c2.coinMarketCapAddToWatch();
        Thread.sleep(5000);
    }
}
