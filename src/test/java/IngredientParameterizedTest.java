import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientParameterizedTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "{index}: {1} ({0}) - Price: {2}")
    public static Object[][] testData() {
        return new Object[][]{
                {IngredientType.SAUCE, "Сырный соус", 59},
                {IngredientType.FILLING, "Пармезан", 49}
        };
    }

    @Test
    public void testIngredientProperties() {
        Ingredient ingredient = new Ingredient(type, name, price);

        assertEquals("Тип ингредиента должен совпадать с ожидаемым", type, ingredient.getType());
        assertEquals("Название ингредиента должно совпадать с ожидаемым", name, ingredient.getName());
        assertEquals("Цена ингредиента должна совпадать с ожидаемой", price, ingredient.getPrice(), 0.001);
    }
}

