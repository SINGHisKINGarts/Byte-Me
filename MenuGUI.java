import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class MenuGUI extends JFrame {
    private JTable menuTable;
    private JTable ordersTable;
    private DefaultTableModel menuModel;
    private DefaultTableModel ordersModel;
    private JPanel cards;
    private CardLayout cardLayout;
    private Menu menu;
    private OrderManager orderManager;

    public MenuGUI(Menu menu, OrderManager orderManager) {
        this.menu = menu;
        this.orderManager = orderManager;

        setTitle("Food Ordering System GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Initialize card layout
        cards = new JPanel(new CardLayout());
        cardLayout = (CardLayout) cards.getLayout();

        // Create menu panel
        JPanel menuPanel = createMenuPanel();
        cards.add(menuPanel, "MENU");

        // Create orders panel

        JPanel ordersPanel = createOrdersPanel();
        cards.add(ordersPanel, "ORDERS");

        // Navigation panel
        JPanel navPanel = new JPanel();
        JButton menuButton = new JButton("View Menu");
        JButton ordersButton = new JButton("View Orders");

        menuButton.addActionListener(e -> cardLayout.show(cards, "MENU"));
        ordersButton.addActionListener(e -> cardLayout.show(cards, "ORDERS"));

        navPanel.add(menuButton);
        navPanel.add(ordersButton);

        // Add components to frame
        add(navPanel, BorderLayout.NORTH);
        add(cards, BorderLayout.CENTER);

        // Refresh button
        JButton refreshButton = new JButton("Refresh Data");
        refreshButton.addActionListener(e -> refreshData());
        navPanel.add(refreshButton);
    }

    private JPanel createMenuPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // Create table model with columns
        menuModel = new DefaultTableModel(
                new Object[]{"Name", "Price", "Category", "Availability"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table read-only
            }
        };

        menuTable = new JTable(menuModel);
        JScrollPane scrollPane = new JScrollPane(menuTable);

        panel.add(new JLabel("Menu Items", SwingConstants.CENTER), BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        loadMenuData();

        return panel;
    }

    private JPanel createOrdersPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // Create table model with columns
        ordersModel = new DefaultTableModel(
                new Object[]{"Order ID", "Customer", "Status", "Total Amount", "Special Request"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table read-only
            }
        };

        ordersTable = new JTable(ordersModel);
        JScrollPane scrollPane = new JScrollPane(ordersTable);

        panel.add(new JLabel("Pending Orders", SwingConstants.CENTER), BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        loadOrdersData();

        return panel;
    }

    private void loadMenuData() {
        menuModel.setRowCount(0); // Clear existing data

        for (var entry : menu.getMenuByprice().entrySet()) {
            for (FoodItem item : entry.getValue()) {
                menuModel.addRow(new Object[]{
                        item.getName(),
                        item.getPrice(),
                        item.getCategory(),
                        item.getAvailable()
                });
            }
        }
    }

    private void loadOrdersData() {
        ordersModel.setRowCount(0); // Clear existing data

        for (Order order : orderManager.getOrderQueue()) {
            if (!order.getStatus().equals("Completed")) {
                ordersModel.addRow(new Object[]{
                        order.getOrderId(),
                        order.getCustomerName(),
                        order.getStatus(),
                        order.getTotalAmount(),
                        order.getSpecialRequest()
                });
            }
        }
    }

    public void refreshData() {
        loadMenuData();
        loadOrdersData();
    }
}