import java.util.Map;
import java.util.TreeMap;

public class Cart {

    private TreeMap<FoodItem,Integer> cart;
    private String Instructions;
    private boolean Checkout=false;

    public TreeMap<FoodItem, Integer> getCart() {
        return cart;
    }

    public void setCart(TreeMap<FoodItem, Integer> cart) {
        this.cart = cart;
    }

    public Cart() {

        this.cart = new TreeMap<>((item1, item2) -> item1.getName().compareTo(item2.getName()));
    }

    public void addToCart(FoodItem foodItem,int Quantity){
        cart.put(foodItem,Quantity);
        System.out.println("Item added successfully");
    }
    public void modifyQuantity(FoodItem foodItem,int NewQuantity){
        for(FoodItem key: cart.keySet()){
            if(key==foodItem){
                cart.put(foodItem,NewQuantity);
            }
        }

    }
    public void removeItem(FoodItem foodItem){
        for(FoodItem key: cart.keySet()){
            if(key==foodItem){
                cart.remove(foodItem);
            }
        }
    }
    public void checkout(){
        Checkout=true;
        cart.clear();

    }

    public boolean isCheckout() {
        return Checkout;
    }

    public String getInstructions() {
        return Instructions;
    }

    public void setInstructions(String instructions) {
        Instructions = instructions;
    }

    public void setCheckout(boolean checkout) {
        Checkout = checkout;
    }
    public void showCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Items in your cart:");
            for (Map.Entry<FoodItem, Integer> entry : cart.entrySet()) {
                FoodItem item = entry.getKey();
                Integer quantity = entry.getValue();
                System.out.println("Item Name: " + item.getName() + ", Quantity: " + quantity);
            }
        }
    }
    public int getTotal() {
        int total = 0;
        for (Map.Entry<FoodItem, Integer> entry : cart.entrySet()) {
            FoodItem item = entry.getKey();
            Integer quantity = entry.getValue();
            total += item.getPrice() * quantity;
        }
        return total;
    }

}
