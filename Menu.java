import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

public class Menu {
    private ArrayList<FoodItem> List10;
    private ArrayList<FoodItem> List20;
    private ArrayList<FoodItem> List50;
    private TreeMap<Integer,ArrayList<FoodItem>> menuByprice;
    private int numberOfItem;
    private boolean isInitialized = false;

    public void intialise(){
        this.List10=new ArrayList<>();
        this.List20=new ArrayList<>();
        this.List50=new ArrayList<>();
        this.menuByprice=new TreeMap<>();
        InitialiseMenu();
    }

    public ArrayList<FoodItem> getList10() {
        return List10;
    }

    public void setList10(ArrayList<FoodItem> list10) {
        List10 = list10;
    }

    public ArrayList<FoodItem> getList20() {
        return List20;
    }

    public void setList20(ArrayList<FoodItem> list20) {
        List20 = list20;
    }

    public ArrayList<FoodItem> getList50() {
        return List50;
    }

    public void setList50(ArrayList<FoodItem> list50) {
        List50 = list50;
    }

    public TreeMap<Integer, ArrayList<FoodItem>> getMenuByprice() {
        return menuByprice;
    }

    public void setMenuByprice(TreeMap<Integer, ArrayList<FoodItem>> menuByprice) {
        this.menuByprice = menuByprice;
    }

    public int getNumberOfItem() {
        return numberOfItem;
    }

    public void setNumberOfItem(int numberOfItem) {
        this.numberOfItem = numberOfItem;
    }

    public void InitialiseMenu(){

        if(isInitialized) return;

        List10.add(new FoodItem("sandwich",10 ,"MainCourse","Yes"));
        List10.add(new FoodItem("poha",10,"MainCourse","Yes"));
        List10.add(new FoodItem("rice",10,"MainCourse","Yes"));

        List50.add(new FoodItem("puri chole",50,"MainCourse","Yes"));
        List50.add(new FoodItem("pulao",50,"MainCourse","Yes"));
        List50.add(new FoodItem("thali (1sabji,1salad,4roti) ",50,"MainCourse","Yes"));
        List50.add(new FoodItem("pakode",50,"Snacks","Yes"));

        List20.add(new FoodItem("Coke",20,"Beverage","Yes"));
        List20.add(new FoodItem("NimbuPani",20,"Beverage","Yes"));
        numberOfItem=9;
        menuByprice.put(10,List10);
        menuByprice.put(20,List20);
        menuByprice.put(50,List50);
        isInitialized = true;

    }
    public void addItem(FoodItem foodItem){
        if(foodItem.getPrice()==10){
            List10.add(foodItem);
            numberOfItem++;
        }
        else if(foodItem.getPrice()==20){
            List20.add(foodItem);
            numberOfItem++;
        }
        else if(foodItem.getPrice()==50){
            List50.add(foodItem);numberOfItem++;
        }
        else{
            ArrayList<FoodItem> temp=new ArrayList<FoodItem>();
            temp.add(foodItem);
            menuByprice.put(foodItem.getPrice(),temp);numberOfItem++;
        }
    }
    public void showMenu() {
        System.out.println("Menu:");
        for (var entry : menuByprice.entrySet()) {
            System.out.println("Price Category: " + entry.getKey());
            for (FoodItem item : entry.getValue()) {
                item.displayItem();
                System.out.println("---------------");
            }
        }
    }
    public FoodItem findItemByName(String name){
        for(ArrayList<FoodItem> list: menuByprice.values()){
            for (FoodItem item:list){
                if(item.getName().equals(name)){
                    return item;
                }
            }
        }
        return null;
    }
    public void showByCategory(String category){
        for (var entry : menuByprice.entrySet()) {
            for (FoodItem item : entry.getValue()) {
                if(item.getCategory()==category){
                    item.displayItem();
                }
            }
        }
    }

    public void removeItem(String name) {
        for (ArrayList<FoodItem> list : menuByprice.values()) {
            Iterator<FoodItem> iterator = list.iterator();
            while (iterator.hasNext()) {
                FoodItem item = iterator.next();
                if (item.getName().equals(name)) {
                    iterator.remove();
                    numberOfItem--;
                    System.out.println("Item removed successfully.");
                    return;
                }
            }
        }
        System.out.println("Item not found in the menu.");
    }




}
