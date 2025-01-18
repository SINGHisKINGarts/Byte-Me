import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.SortedMap;

public class Admin {
    private String username;
    private String Password;



    public Admin(String username, String password) {
        this.username = username;
        this.Password = password;


    }

    public void adminInterface(OrderManager orderManager,Menu menu){
        Scanner sc=new Scanner(System.in);

        while(true){
            System.out.println("Enter your choice");
            System.out.println("1.Menu Management");
            System.out.println("2.Order Management");
            System.out.println("3.Generate Daily Sales Report");
            System.out.println("4.Exit");
            int choice = sc.nextInt();
            if (choice == 1) {
                // menu management
                while(true){
                    System.out.println("1.Add new Food item");
                    System.out.println("2.Update Existing item");
                    System.out.println("3.Remove Existing item");
                    System.out.println("4.Show menu for reference");
                    System.out.println("5.Exit");
                    int o_choice = sc.nextInt();
                    if (o_choice == 1) {
                        menu.showMenu();

                        System.out.println("Enter your Item Details");
                        sc.nextLine();
                        System.out.print("Enter your Item name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter its Price: ");
                        int price = sc.nextInt();
                        sc.nextLine(); // Consume leftover newline after integer input

                        System.out.print("Enter its Category: ");
                        String category = sc.nextLine();

                        System.out.print("Enter Availability (Yes/No): ");
                        String available = sc.nextLine();

                        FoodItem foodItem = new FoodItem(name, price, category, available);
                        menu.addItem(foodItem);

                        System.out.println("Item Added Successfully");

                    }
                    else if (o_choice == 2) {
                        menu.showMenu();
                        sc.nextLine();
                        System.out.println("Enter your Item name: ");
                        String name = sc.nextLine();
                        if (menu.findItemByName(name).getName() != null) {
                            if (Objects.equals(menu.findItemByName(name).getName(), name)) {
                                System.out.println("Enter choice to update");
                                System.out.println("1.Update name");
                                System.out.println("2.Update price");
                                System.out.println("3.Update category");
                                System.out.println("4.Update availability");
                                int u_choice = sc.nextInt();
                                sc.nextLine();
                                switch (u_choice) {
                                    case 1:
                                        System.out.println("Enter new name: ");
                                        String updatedName = sc.nextLine();
                                        menu.findItemByName(name).setName(updatedName);
                                        break;

                                    case 2:
                                        System.out.println("Enter new price; ");
                                        int updatedPrice = sc.nextInt();
                                        menu.findItemByName(name).setPrice(updatedPrice);

                                        break;

                                    case 3:
                                        System.out.println("Enter new category: ");
                                        String updatedCategory = sc.nextLine();
                                        menu.findItemByName(name).setCategory(updatedCategory);

                                        break;
                                    case 4:
                                        System.out.println("Enter Availability(Yes/No) : ");
                                        String updatedAvailable = sc.nextLine();
                                        menu.findItemByName(name).setAvailable(updatedAvailable);

                                        break;

                                }

                            }
                        } else {
                            System.out.println("Wrong item name entered!");
                            break;
                        }


                    }
                    else if (o_choice == 3) {
                        sc.nextLine();
                        System.out.println("Enter item name to remove: ");
                        String name = sc.nextLine();
                        menu.removeItem(name);
                        System.out.println("Item removed successfully");

                    }
                    else if (o_choice == 4) {
                        menu.showMenu();
                    }
                    else{
                        break;
                    }
                }
            }
            else if (choice == 2) {
                // order management
                Scanner kk=new Scanner(System.in);
                System.out.println("Enter your choice");
                System.out.println("1.View Pending orders");
                System.out.println("2.update Order status");
                System.out.println("3.Process Refund");
                System.out.println("4.Handle Special Request");
                System.out.println("5.Exit");
                int newchoice = kk.nextInt();
                switch (newchoice){
                    case 1:
                        orderManager.viewPendingOrders();
                        break;
                    case 2:
                        System.out.println("Enter order id: ");
                        Scanner ff=new Scanner(System.in);
                        String orderid=ff.nextLine();
                        System.out.println("Set status from pending to-(\"Pending\", \"Preparing\", \"Out for Delivery\", \"Completed\") ");
                        Scanner ll=new Scanner(System.in);
                        String orderstatus=ll.nextLine();
                        orderManager.updateOrderStatus(orderid,orderstatus);
                        break;
                    case 3:
                        System.out.println("Enter order id: ");
                        Scanner hh=new Scanner(System.in);
                        String ordertoRefund=hh.nextLine();
                        orderManager.processRefund(ordertoRefund);
                        break;
                    case 4:
                        orderManager.viewSpecialRequests();
                        break;

                }
                if(newchoice==5){
                    break;
                }


            }
            else if(choice==3){
                orderManager.generateDailySalesReport();
            }
            else if(choice==4){
                break;
            }

        }
    }

}
