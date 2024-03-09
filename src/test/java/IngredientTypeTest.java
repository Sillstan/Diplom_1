import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private IngredientType ingredientType;
    public IngredientTypeTest(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Collection<IngredientType> data() {
        return Arrays.asList(IngredientType.values());
    }

    @Test
    public void testIngredientType() {
        String expected = ingredientType.name();
        String actual = ingredientType.toString();
        assertEquals("Incorrect type", expected, actual);
    }
}
