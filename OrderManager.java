import java.util.PriorityQueue;

public class OrderManager {
    private PriorityQueue<Order> orderQueue;

    public OrderManager() {
        this.orderQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.isVIP() && !o2.isVIP()) return -1;
            else if (!o1.isVIP() && o2.isVIP()) return 1;
            return 0;
        });
    }

    public void addOrder(Order order) {
        orderQueue.add(order);
        System.out.println("Order added: " + order);
    }

    public void viewPendingOrders() {
        System.out.println("Pending Orders:");
        for (Order order : orderQueue) {
            if (!order.getStatus().equals("Completed")) {
                System.out.println(order);
            }
        }
    }

    public void updateOrderStatus(String orderId, String newStatus) {
        for (Order order : orderQueue) {
            if (order.getOrderId().equals(orderId)) {
                order.setStatus(newStatus);
                System.out.println("Order status updated: " + order);
                return;
            }
        }
        System.out.println("Order not found with ID: " + orderId);
    }

    public void processRefund(String orderId) {
        for (Order order : orderQueue) {
            if (order.getOrderId().equals(orderId)) {
                System.out.println("Processing refund for order: " + order);
                orderQueue.remove(order);
                return;
            }
        }
        System.out.println("Order not found with ID: " + orderId);
    }

    public void viewSpecialRequests() {
        System.out.println("Special Requests:");
        for (Order order : orderQueue) {
            if (order.getSpecialRequest() != null && !order.getSpecialRequest().isEmpty()) {
                System.out.println("Order ID: " + order.getOrderId() + " - Request: " + order.getSpecialRequest());
            }
        }
    }

    public void generateDailySalesReport() {
        double totalSales = 0;
        int totalCompletedOrders = 0;

        for (Order order : orderQueue) {
            if (order.getStatus().equalsIgnoreCase("Completed")) {
                totalSales += order.getTotalAmount();
                totalCompletedOrders++;
            }
        }

        System.out.println("Daily Sales Report:");
        System.out.println("Total Sales: Rs" + totalSales);
        System.out.println("Total Completed Orders: " + totalCompletedOrders);
    }

    public PriorityQueue<Order> getOrderQueue() {
        return orderQueue;
    }

    public void setOrderQueue(PriorityQueue<Order> orderQueue) {
        this.orderQueue = orderQueue;
    }
}
