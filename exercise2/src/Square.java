class Square extends Rectangle {
    public Square(double side, String color) {
        super(side, side, color);
    }

    @Override
    public double calculatePerimeter() {
        return 4 * length;
    }
}