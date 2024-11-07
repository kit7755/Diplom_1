import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static constants.Constants.*;


public class BunTest {

    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun(BUN_NAME, BUN_PRICE);
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals(BUN_NAME, bun.getName());
    }

    @Test
    public void getPriceTest() {
        Assert.assertEquals(BUN_PRICE, bun.getPrice(), 0);
    }
}