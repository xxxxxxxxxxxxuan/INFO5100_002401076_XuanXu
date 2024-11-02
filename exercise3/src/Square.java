class Square extends Rectangle {
    private static final long serialVersionUID = 1L;

    public Square(double side, String color) {
        super(side, side, color);
    }

    @Override
    public double calculatePerimeter() {
        return 4 * length;
    }
}