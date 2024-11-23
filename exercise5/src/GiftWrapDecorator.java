public class GiftWrapDecorator implements Gift {
    private Gift gift;
    private String wrapStyle;
    private double wrapCost;

    public GiftWrapDecorator(Gift gift, String wrapStyle) {
        this.gift = gift;
        this.wrapStyle = wrapStyle;
        this.wrapCost = calculateWrapCost(wrapStyle);
    }

    private double calculateWrapCost(String style) {
        switch (style.toLowerCase()) {
            case "basic":
                return 2.99;
            case "premium":
                return 4.99;
            case "luxury":
                return 7.99;
            default:
                return 2.99;
        }
    }

    @Override
    public String getName() {
        return gift.getName() + " (Gift Wrapped - " + wrapStyle + ")";
    }

    @Override
    public double getPrice() {
        return gift.getPrice() + wrapCost;
    }

    @Override
    public String getCategory() {
        return gift.getCategory();
    }
}