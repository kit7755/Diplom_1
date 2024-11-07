import org.junit.Assert;
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


import static constants.Constants.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun bunMock;
    @Mock
    private Ingredient ingredientMock;
    @Mock
    private Ingredient ingredientMock2;

    @Before
    public void setUp() {
        burger = new Burger();
        // Устанавливаем стандартное поведение для булочки и ингредиентов
        Mockito.when(bunMock.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(bunMock.getName()).thenReturn(BUN_NAME);
        Mockito.when(ingredientMock.getPrice()).thenReturn(INGR_PRICE);
        Mockito.when(ingredientMock.getName()).thenReturn(INGR_NAME);
        Mockito.when(ingredientMock.getType()).thenReturn(IngredientType.SAUCE);
        burger.setBuns(bunMock);
    }

    @Test
    public void testSetBuns() {
        Assert.assertEquals("Булочка должна быть установлена", bunMock, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredientMock);
        Assert.assertEquals("Ингредиент должен быть добавлен", ingredientMock, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredientMock);
        burger.addIngredient(ingredientMock2);
        burger.removeIngredient(0);
        Assert.assertEquals("Остался один ингредиент после удаления", 1, burger.ingredients.size());
        Assert.assertEquals("Оставшийся ингредиент - второй добавленный", ingredientMock2, burger.ingredients.get(0));
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredientMock);
        burger.addIngredient(ingredientMock2);
        burger.moveIngredient(1, 0);
        Assert.assertEquals("Ингредиенты поменяли местами", ingredientMock2, burger.ingredients.get(0));
        Assert.assertEquals("Первый ингредиент переместился", ingredientMock, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        burger.addIngredient(ingredientMock);
        burger.addIngredient(ingredientMock);
        float expectedPrice = (BUN_PRICE * 2) + (INGR_PRICE * 2);
        Assert.assertEquals("Стоимость бургера рассчитана корректно", expectedPrice, burger.getPrice(), DELTA);
    }

    @Test
    public void testGetReceipt() {
        burger.addIngredient(ingredientMock);
        String actualReceipt = burger.getReceipt();
        String expectedReceipt = String.format("(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n",
                BUN_NAME, IngredientType.SAUCE.toString().toLowerCase(), INGR_NAME, BUN_NAME,
                (BUN_PRICE * 2) + INGR_PRICE);

        Assert.assertEquals("Чек должен быть корректным", expectedReceipt, actualReceipt);
    }
}

