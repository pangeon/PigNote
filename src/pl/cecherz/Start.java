package pl.cecherz;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Start extends Application {
    public final String applicationName = "PigNote";
    public final String iconPath = "pl/cecherz/Pig_icon.png";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) {
        primaryStage.setTitle(applicationName);

        final Image image = new Image(iconPath);
        primaryStage.getIcons().add(image);

        final BorderPane borderPane = new BorderPane();
        borderPane.setTop(createMenu());
        borderPane.setCenter(createTextArea());

        final Scene mainScene = new Scene(borderPane, 600.0, 700.0);

        primaryStage.setScene(mainScene);
        primaryStage.show();

    }
    private MenuBar createMenu() {
        final Menu menuFile = new Menu("File");
        MenuItem[] menuItems = {
                new MenuItem("Open"),
                new MenuItem("Save")
        };
        menuFile.getItems().addAll(menuItems);

        final Menu menuOptions = new Menu("Options");
        final Menu menuHelp = new Menu("Help");

        final MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menuFile, menuOptions, menuHelp);

        return menuBar;
    }
    private TextArea createTextArea() {
        return new TextArea();
    }
}
