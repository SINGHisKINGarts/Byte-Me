import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FoodOrderingSystemTest {
    private Menu menu;
    private Cart cart;
    private FoodItem availableItem;
    private FoodItem unavailableItem;

    @Before
    public void setUp() {

        menu = new Menu();
        menu.intialise();
        cart = new Cart();


        availableItem = new FoodItem("Test Available Item", 10, "Test Category", "Yes");
        menu.addItem(availableItem);

        unavailableItem = new FoodItem("Test Unavailable Item", 20, "Test Category", "No");
        menu.addItem(unavailableItem);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddUnavailableItemToCart() {
        // This should throw an IllegalArgumentException
        cart.addToCart(unavailableItem, 1);
    }

    @Test
    public void testModifyCartItemQuantity() {

        cart.addToCart(availableItem, 2);


        assertEquals(2, cart.getCart().get(availableItem).intValue());


        cart.modifyQuantity(availableItem, 5);


        assertEquals(5, cart.getCart().get(availableItem).intValue());
    }

    @Test
    public void testCartTotal() {

        cart.addToCart(availableItem, 3);

        int expectedTotal = availableItem.getPrice() * 3;
        assertEquals(expectedTotal, cart.getTotal());
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("FoodOrderingSystemTest");
    }
}