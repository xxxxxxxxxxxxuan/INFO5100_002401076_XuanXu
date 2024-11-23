public class Main {
    public static void main(String[] args) {
        System.out.println("=== Testing Design Patterns in Gift Shop System ===\n");

        // Testing Singleton Pattern
        System.out.println("1. Testing Singleton Pattern:");
        System.out.println("   Creating first instance of GiftShopSystem...");
        GiftShopSystem shop1 = GiftShopSystem.getInstance();
        System.out.println("   Creating second instance of GiftShopSystem...");
        GiftShopSystem shop2 = GiftShopSystem.getInstance();
        System.out.println("   Checking if both instances are the same object: " +
                (shop1 == shop2 ? "Yes (Singleton working)" : "No (Singleton failed)"));
        System.out.println();

        // Testing Factory Pattern
        System.out.println("2. Testing Factory Pattern:");
        GiftFactory factory = new GiftFactory();
        System.out.println("   Creating different types of gifts using factory...");
        Gift teddy = factory.createGift("bear");
        Gift card = factory.createGift("card");
        Gift frame = factory.createGift("frame");
        System.out.println("   Created gifts:");
        System.out.println("   - " + teddy.getName() + " ($" + teddy.getPrice() + ") - Category: " + teddy.getCategory());
        System.out.println("   - " + card.getName() + " ($" + card.getPrice() + ") - Category: " + card.getCategory());
        System.out.println("   - " + frame.getName() + " ($" + frame.getPrice() + ") - Category: " + frame.getCategory());
        System.out.println();

        // Testing Observer Pattern
        System.out.println("3. Testing Observer Pattern:");
        System.out.println("   Setting up customer observer and order...");
        Customer customer = new Customer("Alice", "alice@email.com");
        Gift wrappedTeddy = new GiftWrapDecorator(teddy, "premium");
        GiftOrder order = new GiftOrder(wrappedTeddy);
        order.addObserver(customer);
        System.out.println("   Order created with ID: " + order.getOrderNumber());
        System.out.println("   Testing status updates (observer notifications):");
        order.setStatus("ORDER_RECEIVED");
        order.setStatus("GIFT_WRAPPING");
        order.setStatus("READY_FOR_PICKUP");
        System.out.println();

        // Final Summary
        System.out.println("=== Final System State ===");
        System.out.println("Order Details:");
        System.out.println("- Item: " + wrappedTeddy.getName());
        System.out.println("- Category: " + wrappedTeddy.getCategory());
        System.out.println("- Base Price: $" + String.format("%.2f", teddy.getPrice()));
        System.out.println("- Price with Gift Wrap: $" + String.format("%.2f", wrappedTeddy.getPrice()));
        shop1.addSale(wrappedTeddy.getPrice());
        System.out.println("- Total Shop Sales: $" + String.format("%.2f", shop1.getTotalSales()));
    }
}