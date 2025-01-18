import java.util.UUID;

public class Order {
    private String orderId;
    private String customerName;
    private String status; // "pending", "preparing", "out for Delivery", "Completed"
    private boolean isVIP;
    private String specialRequest; // Any special requests/instructions as written in user
    private double totalAmount;
    private boolean orderRefundRequest = false;


    public Order(String customerName, boolean isVIP, String specialRequest, double totalAmount) {
        this.orderId = UUID.randomUUID().toString();
        this.customerName = customerName;
        this.status = "Pending"; // Default status
        this.isVIP = isVIP;
        this.specialRequest = specialRequest;
        this.totalAmount = totalAmount;
    }


    public String getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public boolean isVIP() { return isVIP; }
    public String getSpecialRequest() { return specialRequest; }
    public double getTotalAmount() { return totalAmount; }
    public boolean isOrderRefundRequest() { return orderRefundRequest; }
    public void setOrderRefundRequest(boolean orderRefundRequest) { this.orderRefundRequest = orderRefundRequest; }

    @Override
    public String toString() {
        return "Order ID: " + orderId +
                ", Customer: " + customerName +
                ", Status: " + status +
                ", VIP: " + (isVIP ? "Yes" : "No") +
                ", Special Request: " + specialRequest +
                ", Total Amount: Rs" + totalAmount +
                ", Refund Requested: " + (orderRefundRequest ? "Yes" : "No");
    }
}
