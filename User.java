import java.util.Objects;
import java.util.Scanner;

public class User {
    private String name;
    private String phnNumber;
    private String address;
    private boolean isVip = false;

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }

    public User(String name, String phnNumber, String address) {
        this.name = name;
        this.phnNumber = phnNumber;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhnNumber() {
        return phnNumber;
    }

    public void setPhnNumber(String phnNumber) {
        this.phnNumber = phnNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void orderTrackOperations(OrderManager orderManager,String Username,Menu menu,Cart cart){

        while(true){
            System.out.println("1.View Order Status");
            System.out.println("2.cancel Order"); //orderRefundRequest in ordermanager find your order using your name
            System.out.println("3.Exit");
            Scanner w=new Scanner(System.in);
            int choicep=w.nextInt();
            switch (choicep){
                case 1:
                    for (Order order : orderManager.getOrderQueue()) {
                        if (order.getCustomerName().equals(Username)) {
                            System.out.println("your order status is: "+order.getStatus());

                        }
                    }
                    break;
                case 2:
                    for (Order order : orderManager.getOrderQueue()) {
                        if (order.getCustomerName().equals(Username)) {
                            System.out.println("your order is sent for refund review ");
                            order.setOrderRefundRequest(true);
                        }
                    }
            }
            if(choicep==3){
                break;
            }
        }




    }
    public void userinterface(OrderManager orderManager,String Username,Menu menu,Cart cart){
        Scanner sc =new Scanner(System.in);
        while(true){
            System.out.println("1.Menu operations");
            System.out.println("2.Cart operations");
            System.out.println("3.Order Tracking operations");
            System.out.println("4.Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    MenuOperations(Username,menu);
                    break;
                case 2:
                    CartOperations(orderManager,Username,cart, menu);
                    break;
                case 3:
                    orderTrackOperations(orderManager,Username,menu,cart);
                    break;
            }
            if (choice==4){
                break;
            }
        }
    }
    public void MenuOperations(String Username,Menu menu){
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("1.Show Menu");
            System.out.println("2.search item");
            System.out.println("3.Filter items");
            System.out.println("4.Sort by price");
            System.out.println("5.Exit");
            System.out.println("Enter your choice:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    menu.showMenu();
                    break;
                case 2:
                    System.out.println("enter item name to search: ");
                    Scanner input=new Scanner(System.in);
                    String name = input.next();
                    menu.findItemByName(name).displayItem();
                    break;
                case 3:
                    System.out.println("Enter category to filter- 1. MainCourse\n 2.Snacks\n 3.Beverages\n 4.Others");
                    Scanner l=new Scanner(System.in);
                    String categoryToSearch=l.nextLine();
                    for (var entry : menu.getMenuByprice().entrySet()) {
                        for (FoodItem item : entry.getValue()) {
                            if(item.getCategory()==categoryToSearch){
                                item.displayItem();
                            }
                        }
                    }
                    break;
                case 4:
                    System.out.println("Menu Sorted by price:- ");
                    menu.showMenu();
                    break;


            }
            if(choice==5){
                break;
            }
        }

    }
    public void CartOperations(OrderManager orderManager,String Username,Cart cart,Menu menu){
        Scanner input=new Scanner(System.in);
        while(true){
            System.out.println("Cart operations");
            System.out.println("1.Show Cart");
            System.out.println("2.Add item to cart");
            System.out.println("3.Modify quantity in cart");
            System.out.println("4.Remove item from cart");
            System.out.println("5.--- BUY VIP (for fast delivery)  ---");
            System.out.println("6.Give food instructions");
            System.out.println("7.Get Total amount to pay");
            System.out.println("8.Get reviews of item");
            System.out.println("9.Give review to item");
            System.out.println("10.Checkout cart");
            System.out.println("11.Exit");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    cart.showCart();
                    break;
                case 2:
                    Scanner lop=new Scanner(System.in);
                    System.out.println("Enter quantity item and item name");
                    System.out.println("Enter item name: ");
                    String itemname = lop.nextLine();
                    System.out.println("Enter Quantity: ");
                    Scanner pop=new Scanner(System.in);
                    int itemQuantity = pop.nextInt();

                    cart.addToCart(menu.findItemByName(itemname), itemQuantity);
                    break;
                case 3:
                    Scanner gg=new Scanner(System.in);
                    System.out.println("enter item name to modify quantity: ");
                    System.out.println("Enter item name: ");
                    String name = gg.nextLine();
                    gg.nextLine();

                    System.out.println("Enter new Quantity: ");
                    int modifiedQuantity = gg.nextInt();

                    cart.modifyQuantity(menu.findItemByName(name), modifiedQuantity);


                    break;
                case 4:
                    Scanner tt=new Scanner(System.in);
                    System.out.println("Enter item to remove: ");
                    String itemRemove = tt.nextLine();
                    cart.removeItem(menu.findItemByName(itemRemove));
                    break;
                case 5:
                    Scanner oo=new Scanner(System.in);
                    System.out.println("Enter yes to buy and no to reject");
                    String choicee=oo.nextLine();

                    if(Objects.equals(choicee, "yes") || Objects.equals(choicee, "Yes")){
                        isVip=true;
                        System.out.println("you have subscribed to vip");
                    }
                    break;

                case 6:
                    Scanner yy=new Scanner(System.in);
                    System.out.println("Enter food instructions: ");
                    String instrucn = yy.nextLine();
                    cart.setInstructions(instrucn);
                    break;
                case 7:
                    System.out.println("Total amount to pay: " + cart.getTotal());

                    break;
                case 8:
                    Scanner kk=new Scanner(System.in);
                    System.out.println("Enter item name to get reviews: ");
                    String nameForReview=kk.nextLine();
                    menu.findItemByName(nameForReview).showReviews();
                    break;
                case 9:
                    Scanner jj=new Scanner(System.in);
                    System.out.println("Enter item name to give review: ");
                    String ItemtoReview=jj.nextLine();
                    jj.nextLine();
                    System.out.println("Enter review for the above item: ");
                    Scanner dd=new Scanner(System.in);
                    String ReviewForItem=dd.nextLine();


                    menu.findItemByName(ItemtoReview).giveReview(ReviewForItem);
                    break;
                case 10:
                    System.out.println("Checking out the cart!");
                    Order order=new Order(Username,isVip, cart.getInstructions(), cart.getTotal());
                    cart.checkout();
                    orderManager.addOrder(order);

                    break;

            }
            if (choice==11){
                break;
            }
        }
    }
}
