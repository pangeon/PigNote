package pl.cecherz;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Start extends Application {
    public final String applicationName = "PigNote";
    public final String iconPath = "pl/cecherz/Pig_icon.png";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle(applicationName);
        Image image = new Image(iconPath);

        primaryStage.getIcons().add(image);

        StackPane root = new StackPane();

        Scene scene = new Scene(root, 600.0, 700.0);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
