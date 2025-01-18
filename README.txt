# Food Ordering System
The Food Ordering System is a Java-based application that allows users to order food items from a restaurant menu and administrators to manage the menu and orders.
## How to Run the Code

Run the Main.java class:
When you run the Main.java file, the application's main entry point is executed.
The main() method is the starting point of the program.
Choose a Role:
The application prompts the user to choose a role: "User" or "Admin".
Depending on the choice, the program will either enter the user interface or the admin interface.

User Interface:
If the user chooses the "User" role, they will be prompted to enter their name, phone number, and address.
The user can then perform the following operations:

Menu Operations:
View the menu
Search for specific items
Filter items by category
Sort the menu by price

Cart Operations:
Add items to the cart
Modify quantities in the cart
Remove items from the cart
Buy a VIP subscription for faster delivery
Add special instructions for the order
View the total amount to pay
View reviews and add new reviews for items
Checkout the cart and place the order

Order Tracking Operations:
View the status of their orders
Cancel and request a refund for an order

Admin Interface:
If the user chooses the "Admin" role, they will enter the admin interface.
The admin can perform the following operations:

Menu Management:
Add new food items
Update existing food items
Remove food items
View the current menu


Order Management:
View pending orders
Update the status of orders (e.g., from "Pending" to "Preparing")
Process refunds for orders
View special requests


Daily Sales Report:
Generate a daily sales report, including total sales and total completed orders

Exit the Application:
The user or admin can exit the application by selecting the "Exit" option.

## Java Concepts Used
The Food Ordering System utilizes the following Java concepts:

1. **Object-Oriented Programming (OOP)**: The application is designed using the principles of OOP, with classes such as `Admin`, `User`, `FoodItem`, `Cart`, `Order`, and `OrderManager` representing the different entities and their interactions.

2. **Inheritance**: The `User` class inherits from the `FoodItem` class, allowing users to access the properties and methods of `FoodItem`.

3. **Encapsulation**: The classes in the application follow the principle of encapsulation, where data and methods are hidden from direct access, ensuring data integrity.

5. **Collections**: The application uses various Java collections, such as `ArrayList`, `TreeMap`, and `PriorityQueue`, to store and manage the food items, orders, and other data.

By understanding these Java concepts and how they are applied in the Food Ordering System, you can continue to enhance the application's functionality, maintainability, and scalability.