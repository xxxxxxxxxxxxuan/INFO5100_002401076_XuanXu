import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Creating and displaying original objects:");
            Shape triangle = new Triangle(6, 4, 5, 4, 3, "red");
            Shape rectangle = new Rectangle(5, 3, "blue");
            Shape square = new Square(4, "green");
            Shape circle = new Circle(3, "yellow");

            displayShape("Triangle", triangle);
            displayShape("Rectangle", rectangle);
            displayShape("Square", square);
            displayShape("Circle", circle);

            System.out.println("\nSerializing objects to file...");
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("shapes.ser"));
            out.writeObject(triangle);
            out.writeObject(rectangle);
            out.writeObject(square);
            out.writeObject(circle);
            out.close();
            System.out.println("Serialization completed successfully.");

            System.out.println("\nDeserializing objects from file...");
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream("shapes.ser"));
            Shape deserializedTriangle = (Shape)in.readObject();
            Shape deserializedRectangle = (Shape)in.readObject();
            Shape deserializedSquare = (Shape)in.readObject();
            Shape deserializedCircle = (Shape)in.readObject();
            in.close();
            System.out.println("Deserialization completed successfully.");

            System.out.println("\nDisplaying deserialized objects:");
            displayShape("Deserialized Triangle", deserializedTriangle);
            displayShape("Deserialized Rectangle", deserializedRectangle);
            displayShape("Deserialized Square", deserializedSquare);
            displayShape("Deserialized Circle", deserializedCircle);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during serialization/deserialization: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void displayShape(String label, Shape shape) {
        System.out.println("\n" + label + ":");
        System.out.println("Type: " + shape.getClass().getSimpleName());
        System.out.println("Color: " + shape.getColor());
        System.out.printf("Area: %.2f%n", shape.calculateArea());
        System.out.printf("Perimeter: %.2f%n", shape.calculatePerimeter());
    }
}