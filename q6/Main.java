//Write a JavaFX application with components, buttons, text fields, and labels, arranged in
//a VBox or HBox layout

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SimpleJavaFXApp extends Application {
  @Override
  public void start(Stage primaryStage) {
    // Create components
    Label label = new Label("Enter your name:");
    TextField textField = new TextField();
    Button button = new Button("Submit");
    Label resultLabel = new Label();

    // Set button action
    button.setOnAction(e -> {
      String name = textField.getText();
      resultLabel.setText("Hello, " + name + "!");
    });

    // Arrange components in a VBox
    VBox vbox = new VBox(10); // 10px spacing
    vbox.getChildren().addAll(label, textField, button, resultLabel);

    // Create scene and set stage
    Scene scene = new Scene(vbox, 300, 200);
    primaryStage.setTitle("Simple JavaFX Application");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    // Upon invoking launch(args), JavaFX creates a new application thread where the
    // start(Stage primaryStage) method of your application is called
    launch(args);
  }
}
