import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient1;
    @Mock
    private Ingredient ingredient2;
    @Mock
    private Ingredient ingredient3;
    private Burger burger;

    @Before
    public void createNewBurger() {
        burger = new Burger();
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        Bun actualBun = burger.bun;
        assertEquals("Incorrect bun", bun, actualBun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient1);
        List<Ingredient> expected = List.of(ingredient1);
        List<Ingredient> actual = burger.ingredients;
        assertEquals("Incorrect ingredient list", expected, actual);
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        List<Ingredient> actual = burger.ingredients;
        assertEquals("Incorrect ingredient list", List.of(), actual);
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        Ingredient actual = burger.ingredients.get(1);
        assertEquals("Incorrect ingredient on position in list", ingredient1, actual);
    }

    @Test
    public void testGetReceipt() {
        Mockito.when(bun.getName()).thenReturn("White Bun");
        Mockito.when(bun.getPrice()).thenReturn(3.00f);
        burger.setBuns(bun);
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient1.getName()).thenReturn("Cheese");
        Mockito.when(ingredient1.getPrice()).thenReturn(1.00f);
        burger.addIngredient(ingredient1);
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        List<Ingredient> ingredients = burger.ingredients;
        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().name().toLowerCase(), ingredient.getName()));
        }
        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));
        String expected = receipt.toString();
        String actual = burger.getReceipt();
        assertEquals("Incorrect receipt", expected, actual);
    }
}
