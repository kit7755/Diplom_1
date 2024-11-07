import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientParameterizedTypeTest {
    private final IngredientType type;
    private final String expectedName;

    public IngredientParameterizedTypeTest(IngredientType type, String expectedName) {
        this.type = type;
        this.expectedName = expectedName;
    }

    @Parameterized.Parameters(name = "{index}: {0} should return \"{1}\"")
    public static Object[][] testData() {
        return new Object[][]{
                {SAUCE, "SAUCE"},
                {FILLING, "FILLING"}
        };
    }

    @Test
    public void testIngredientTypeToString() {
        assertEquals("Метод toString() должен возвращать ожидаемое имя типа ингредиента", expectedName, type.toString());
    }
}

