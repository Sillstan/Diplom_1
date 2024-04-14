import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerSecondTest {
    private Burger burger;
    private Bun bun;
    private Ingredient ingredient1;
    private Ingredient ingredient2;
    private String name;
    private float price;
    public BurgerSecondTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Before
    public void creatNewEntities() {
        ingredient1 = new Ingredient(IngredientType.SAUCE, "Cheese", 1.00f);
        ingredient2 = new Ingredient(IngredientType.FILLING, "Beef cutlet", 2.00f);
        burger = new Burger();
    }

    @Parameterized.Parameters
    public static Object[][] getBun() {
        return new Object[][] {
                {"White Bun", 3.00f},
                {"Gray Bun", 2.00f}
        };
    }

    @Test
    public void testGetPrice() {
        bun = new Bun(name, price);
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        float expected = bun.price * 2 + ingredient1.price + ingredient2.price;
        float actual = burger.getPrice();
        assertEquals("Incorrect price", expected, actual, 0.001);
    }
}
