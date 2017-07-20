package orangebeans.models;

import java.util.HashMap;

public class Order {
    private int id;
    private HashMap<Product, Integer> products;
    private String paymentReference;
    private OrderStatus status;
    private String trackingID;
    private Address address;

    public Order() {
        products = new HashMap<Product, Integer>();
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setPaymentReference(String paymentReference) {
        this.paymentReference = paymentReference;
    }

    public String getPaymentReference() {
        return paymentReference;
    }

    public String getTrackingID() {
        return trackingID;
    }

    public void setTrackingID(String trackingID) {
        this.trackingID = trackingID;
    }

    public int getId() {
        return id;
    }

    public HashMap<Product, Integer> getProducts() {
        return products;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}