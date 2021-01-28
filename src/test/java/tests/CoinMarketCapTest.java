package tests;

import org.junit.Test;
import pages.CoinMarketCap;

public class CoinMarketCapTest extends BaseTest
{
    @Test
    public void coinMarketCapTest() throws InterruptedException {
        CoinMarketCap coinMarketCap = new CoinMarketCap(driver);
        coinMarketCap.coinMarketCap();
        Thread.sleep(5000);
    }
}
