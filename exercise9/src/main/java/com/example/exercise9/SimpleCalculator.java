package com.example.exercise9;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SimpleCalculator extends Application {
    private TextField num1Field;
    private TextField num2Field;
    private Label resultLabel;

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(15));
        root.setAlignment(Pos.CENTER);

        // Create operator buttons row
        HBox operatorRow1 = new HBox(10);
        operatorRow1.setAlignment(Pos.CENTER);
        Button divideBtn = new Button("/");
        Button multiplyBtn = new Button("*");
        operatorRow1.getChildren().addAll(divideBtn, multiplyBtn);

        // Create second operator buttons row
        HBox operatorRow2 = new HBox(10);
        operatorRow2.setAlignment(Pos.CENTER);
        Button addBtn = new Button("+");
        Button subtractBtn = new Button("-");
        operatorRow2.getChildren().addAll(addBtn, subtractBtn);

        // Create input fields row
        HBox inputRow = new HBox(10);
        inputRow.setAlignment(Pos.CENTER);
        num1Field = new TextField();
        num2Field = new TextField();
        num1Field.setPrefWidth(100);
        num2Field.setPrefWidth(100);
        inputRow.getChildren().addAll(num1Field, num2Field);

        // Create result label
        resultLabel = new Label("");

        // Create clear button
        Button clearBtn = new Button("clear");

        // Style the components
        root.setStyle("-fx-background-color: white;");

        // Style all buttons to match the image
        String buttonStyle = "-fx-background-color: #f0f0f0; -fx-border-color: #d0d0d0; " +
                "-fx-border-radius: 3; -fx-background-radius: 3;";
        divideBtn.setStyle(buttonStyle);
        multiplyBtn.setStyle(buttonStyle);
        addBtn.setStyle(buttonStyle);
        subtractBtn.setStyle(buttonStyle);
        clearBtn.setStyle(buttonStyle);

        // Add event handlers
        divideBtn.setOnAction(e -> calculate("/"));
        multiplyBtn.setOnAction(e -> calculate("*"));
        addBtn.setOnAction(e -> calculate("+"));
        subtractBtn.setOnAction(e -> calculate("-"));
        clearBtn.setOnAction(e -> {
            num1Field.clear();
            num2Field.clear();
            resultLabel.setText("");
        });

        // Add all components to root
        root.getChildren().addAll(
                operatorRow1,
                operatorRow2,
                inputRow,
                resultLabel,
                clearBtn
        );

        // Create scene and show stage
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculate(String operator) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = 0;

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    resultLabel.setText(num1 + " plus " + num2 + " equals " + result);
                    break;
                case "-":
                    result = num1 - num2;
                    resultLabel.setText(num1 + " minus " + num2 + " equals " + result);
                    break;
                case "*":
                    result = num1 * num2;
                    resultLabel.setText(num1 + " times " + num2 + " equals " + result);
                    break;
                case "/":
                    if (num2 == 0) {
                        resultLabel.setText("Cannot divide by zero");
                        return;
                    }
                    result = num1 / num2;
                    resultLabel.setText(num1 + " divided by " + num2 + " equals " + result);
                    break;
            }
        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter valid numbers");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}