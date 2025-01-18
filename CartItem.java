public class CartItem {
    private int Quantity;
    private FoodItem foodItem;

    public CartItem(int quantity, FoodItem foodItem) {
        Quantity = quantity;
        this.foodItem = foodItem;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }
}
