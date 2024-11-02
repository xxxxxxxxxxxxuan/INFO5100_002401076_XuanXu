import java.io.Serializable;

abstract class Shape implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int shapeCount = 0;
    protected String color;

    public Shape(String color) {
        this.color = color;
        shapeCount++;
    }

    public abstract double calculateArea();
    public abstract double calculatePerimeter();
    public static int getShapeCount() {
        return shapeCount;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " (Color: " + color +
                ", Area: " + String.format("%.2f", calculateArea()) +
                ", Perimeter: " + String.format("%.2f", calculatePerimeter()) + ")";
    }
}