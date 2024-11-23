public class GiftFactory {
    public Gift createGift(String type) {
        switch (type.toLowerCase()) {
            case "card":
                return new BirthdayCard();
            case "bear":
                return new TeddyBear();
            case "frame":
                return new PhotoFrame();
            default:
                throw new IllegalArgumentException("Unknown gift type");
        }
    }
}