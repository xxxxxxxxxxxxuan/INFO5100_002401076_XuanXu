import java.util.ArrayList;
import java.util.List;

public class GiftOrder {
    private List<OrderObserver> observers = new ArrayList<>();
    private String status;
    private Gift gift;
    private String orderNumber;

    public GiftOrder(Gift gift) {
        this.gift = gift;
        this.orderNumber = generateOrderNumber();
    }

    private String generateOrderNumber() {
        return "ORD-" + System.currentTimeMillis() % 10000;
    }

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }

    private void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update("Order " + orderNumber + ": " + status);
        }
    }

    public Gift getGift() {
        return gift;
    }

    public String getOrderNumber() {
        return orderNumber;
    }
}