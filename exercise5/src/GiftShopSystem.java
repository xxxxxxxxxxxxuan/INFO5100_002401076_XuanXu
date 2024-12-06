public class GiftShopSystem {
    private static GiftShopSystem instance;
    private double totalSales = 0;

    private GiftShopSystem() {}

    public static GiftShopSystem getInstance() {
        if (instance == null) {
            instance = new GiftShopSystem();
        }
        return instance;
    }

    public void addSale(double amount) {
        totalSales += amount;
    }

    public double getTotalSales() {
        return totalSales;
    }
}