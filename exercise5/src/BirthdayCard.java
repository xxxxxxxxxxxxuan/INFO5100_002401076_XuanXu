public class BirthdayCard implements Gift {
    @Override
    public String getName() { return "Birthday Greeting Card"; }

    @Override
    public double getPrice() { return 5.99; }

    @Override
    public String getCategory() { return "Cards"; }
}