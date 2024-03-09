import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private Bun bun;
    String nameBun = "White Bun";
    float priceBun = 3.00f;

    @Before
    public void creatNewBun() {
        bun = new Bun(nameBun, priceBun);
    }

    @Test
    public void testGetName() {
        String expected = "White Bun";
        assertEquals("Incorrect bun name", expected, bun.getName());
    }

    @Test
    public void testGetPrice() {
        float expected = 3.00f;
        assertEquals("Incorrect bun price", expected, bun.getPrice(), 0.001f);
    }
}
