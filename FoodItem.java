import java.util.ArrayList;
import java.util.Iterator;

public class FoodItem {
    private int price;
    private String category;
    private String available;
    private String name;
    private ArrayList<String> review=new ArrayList<String>();

    public void showReviews(){
        if(review.isEmpty()){
            System.out.println("no reviews yet");
        }
        else{
            for(String s : review) {
                System.out.println(s);
            }
        }

    }
    public void giveReview(String rev){
        review.add(rev);
        System.out.println("review added");

    }

    public FoodItem(String name, int price, String category, String available) {
        this.price = price;
        this.category = category;
        this.available = available;
        this.name=name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getAvailable() {
        return available;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public void displayItem(){
        System.out.println("Item name: "+this.getName()+"\n"+"Item Price: "+this.getPrice()+"\n"
                +"Item Category: "+this.getCategory()+"\n"+"Item Availability: "+this.getAvailable());
    }
}
