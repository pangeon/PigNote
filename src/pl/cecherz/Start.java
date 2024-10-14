package pl.cecherz;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Start extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("PigNote");
        StackPane root = new StackPane();

        Scene scene = new Scene(root, 600.0, 700.0);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
