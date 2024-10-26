public class Main {
    public static void main(String[] args) {
        Shape triangle = new Triangle(6, 4, 5, 4, 3, "red");
        Shape rectangle = new Rectangle(5, 3, "blue");
        Shape square = new Square(4, "green");
        Shape circle = new Circle(3, "yellow");

        Shape[] shapes = {triangle, rectangle, square, circle};

        for (Shape shape : shapes) {
            System.out.println("\n" + shape.getClass().getSimpleName() +
                    " (" + shape.getColor() + "):");
            System.out.printf("Area: %.2f%n", shape.calculateArea());
            System.out.printf("Perimeter: %.2f%n", shape.calculatePerimeter());
        }
        System.out.println("\nTotal shapes created: " + Shape.getShapeCount());
    }
}