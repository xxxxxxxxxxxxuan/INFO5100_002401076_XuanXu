abstract class Shape {
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
}