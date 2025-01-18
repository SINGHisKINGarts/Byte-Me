import java.io.*;
import java.util.Map;

public class FileHandler {
    private static final String ORDER_HISTORY_FILE = "order_history.txt";
    private static final String USER_DATA_FILE = "user_data.txt";
    private static final String CART_DATA_FILE = "cart_data.txt";
    private static final String CURRENT_USER_FILE = "current_user.txt";

    // Save order history (existing method)
    public static void saveOrderHistory(String username, Order order) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(ORDER_HISTORY_FILE, true)))) {
            out.println(username + "," +
                    order.getOrderId() + "," +
                    order.getTotalAmount() + "," +
                    order.getStatus());
        } catch (IOException e) {
            System.out.println("Error saving order history: " + e.getMessage());
        }
    }

    // Save user data (existing method)
    public static void saveUserData(User user) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(USER_DATA_FILE, true)))) {
            out.println(user.getName() + "," +
                    user.getPhnNumber() + "," +
                    user.getAddress() + "," +
                    user.isVip());
        } catch (IOException e) {
            System.out.println("Error saving user data: " + e.getMessage());
        }

        // Also save current user
        try (PrintWriter out = new PrintWriter(new FileWriter(CURRENT_USER_FILE))) {
            out.println(user.getName());
        } catch (IOException e) {
            System.out.println("Error saving current user: " + e.getMessage());
        }
    }

    // Save cart data (existing method with slight modification)
    public static void saveCartData(String username, Cart cart) {
        try (PrintWriter out = new PrintWriter(new FileWriter(CART_DATA_FILE))) {
            out.println(username);
            for (Map.Entry<FoodItem, Integer> entry : cart.getCart().entrySet()) {
                FoodItem item = entry.getKey();
                Integer quantity = entry.getValue();
                out.println(item.getName() + "," + quantity + "," +
                        item.getPrice() + "," +
                        item.getCategory() + "," +
                        item.getAvailable());
            }
        } catch (IOException e) {
            System.out.println("Error saving cart data: " + e.getMessage());
        }
    }

    // Load current user
    public static String loadCurrentUser() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CURRENT_USER_FILE))) {
            return reader.readLine();
        } catch (IOException e) {
            System.out.println("Error loading current user: " + e.getMessage());
            return null;
        }
    }

    // Load cart data for current user
    public static Cart loadCartData(Menu menu) {
        Cart cart = new Cart();
        try (BufferedReader reader = new BufferedReader(new FileReader(CART_DATA_FILE))) {
            // Skip username line
            String username = reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String name = parts[0];
                    int quantity = Integer.parseInt(parts[1]);
                    int price = Integer.parseInt(parts[2]);
                    String category = parts[3];
                    String available = parts[4];

                    // Find or create the food item
                    FoodItem foodItem = menu.findItemByName(name);
                    if (foodItem == null) {
                        foodItem = new FoodItem(name, price, category, available);
                    }

                    cart.addToCart(foodItem, quantity);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading cart data: " + e.getMessage());
        }
        return cart;
    }
}