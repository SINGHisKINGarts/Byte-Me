import javax.swing.*;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static Admin admin=new Admin("admin","123");
    public static void main(String[] args) {
        Menu menu = new Menu();
        OrderManager orderManager = new OrderManager();
        menu.intialise();
        // Launch GUI immediately
        SwingUtilities.invokeLater(() -> {
            MenuGUI gui = new MenuGUI(menu, orderManager);
            gui.setVisible(true);
        });

        // Run CLI in separate thread
        Thread cliThread = new Thread(() -> runCLI(menu, orderManager));
        cliThread.start();
    }

    private static void runCLI(Menu menu, OrderManager orderManager) {

        Cart cart=new Cart();
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("Enter your role");
            System.out.println("1.User");
            System.out.println("2.Admin");
            System.out.println("3.Exit");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("enter your details");
                System.out.println("Enter your name: ");
                String name=sc.nextLine();
                sc.nextLine();
                System.out.println("Enter your Phone number: ");
                String phn=sc.nextLine();
                System.out.println("Enter address to deliver: ");
                String address=sc.nextLine();
                User user=new User(name,phn,address);
                user.userinterface(orderManager,name,menu,cart);
                FileHandler.saveUserData(user);

            } else if (choice == 2) {
                admin.adminInterface(orderManager,menu);

            }
            else if(choice==3){
                break;
            }
            else{
                System.out.println("Invalid! choice enter again");
            }
        }


    }


}
