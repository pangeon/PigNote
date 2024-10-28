package pl.cecherz;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Start extends Application {
    private GUIController controller;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        controller = new GUIController(primaryStage);
        primaryStage.setTitle(GlobalConstants.APPLICATION_NAME);

        final Image image = new Image(GlobalConstants.ICON_PATH);
        primaryStage.getIcons().add(image);

        final BorderPane borderPane = new BorderPane();
        borderPane.setTop(createMenu());
        borderPane.setCenter(controller.getTextArea());

        final Scene mainScene = new Scene(borderPane, 600.0, 700.0);
        mainScene.getStylesheets().add(GlobalConstants.TEXTAREA_STYLE[0]);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    private MenuBar createMenu() {
        final Menu dropDowMenuFile = initMenuFile();
        final Menu dropDowMenuFont = initMenuFont();
        final Menu dropDowMenuStyle = initMenuStyle();
        final Menu dropDowMenuHelp = initMenuHelp();

        final MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(
                dropDowMenuFile,
                dropDowMenuFont,
                dropDowMenuStyle,
                dropDowMenuHelp
        );

        return menuBar;
    }

    private Menu initMenuFile() {
        final Menu menuFile = new Menu("File");
        MenuItem[] menuItems = {
                new MenuItem("Clear"),
                new MenuItem("Open"),
                new MenuItem("Save as")
        };
        menuItems[0].setOnAction(actionEvent -> {
            controller.resetFile();
        });
        menuItems[1].setOnAction(actionEvent -> {
            try {
                controller.displayTextInWindow();
            } catch (FileNotFoundException e) {
                System.out.println("FileNotFoundException");
                throw new RuntimeException(e);
            } catch (SecurityException e) {
                System.out.println("SecurityException");
                throw new RuntimeException(e);
            } catch (IOException e) {
                System.out.println("IOException");
                throw new RuntimeException(e);
            }
        });
        menuItems[2].setOnAction(actionEvent -> {
            try {
                controller.saveTextAreaToFile();
            } catch (FileNotFoundException e) {
                System.out.println("FileNotFoundException");
                throw new RuntimeException(e);
            } catch (SecurityException e) {
                System.out.println("SecurityException");
                throw new RuntimeException(e);
            } catch (IOException e) {
                System.out.println("IOException");
                throw new RuntimeException(e);
            }
        });
        menuFile.getItems().addAll(menuItems);
        return menuFile;
    }

    public Menu initMenuStyle() {
        final Menu menuStyle = new Menu("Style");
        MenuItem[] menuItems = {
                new MenuItem("default"),
                new MenuItem("Neo"),
                new MenuItem("Puppy"),
                new MenuItem("Choco"),
                new MenuItem("Metal Gear")
        };
        menuStyle.getItems().addAll(menuItems);

        menuItems[0].setOnAction(_ -> controller.changeTextAreaStyle(GlobalConstants.TEXTAREA_STYLE[0]));
        menuItems[1].setOnAction(_ -> controller.changeTextAreaStyle(GlobalConstants.TEXTAREA_STYLE[1]));
        menuItems[2].setOnAction(_ -> controller.changeTextAreaStyle(GlobalConstants.TEXTAREA_STYLE[2]));
        menuItems[3].setOnAction(_ -> controller.changeTextAreaStyle(GlobalConstants.TEXTAREA_STYLE[3]));
        menuItems[4].setOnAction(_ -> controller.changeTextAreaStyle(GlobalConstants.TEXTAREA_STYLE[4]));
        return menuStyle;
    }

    public Menu initMenuFont() {

        final Menu menuFont = new Menu("Font");
        MenuItem[] menuItems = {
                new MenuItem("Bigger [+]"),
                new MenuItem("Smaller [-]"),
        };
        menuItems[0].setOnAction(_ -> {
            controller.changeFontSize(
                    true,
                    GlobalConstants.DEFAULT_FONT_SIZE,
                    GlobalConstants.DEFAULT_CHANGES_FONT_JUMP);
        });
        menuItems[1].setOnAction(_ -> {
            controller.changeFontSize(false,
                    GlobalConstants.DEFAULT_FONT_SIZE,
                    GlobalConstants.DEFAULT_CHANGES_FONT_JUMP);
        });
        menuFont.getItems().addAll(menuItems);

        return menuFont;
    }

    public Menu initMenuHelp() {
        final Menu menuHelp = new Menu("Help");

        // TODO: ADD IMPLEMENTATION

        return menuHelp;
    }



}
