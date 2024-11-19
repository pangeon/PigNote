package pl.cecherz;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.IntStream;

import static pl.cecherz.GlobalConstants.*;

public class Start extends Application {
    private GUIController controller;
    private final BorderPane borderPane = new BorderPane();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        controller = new GUIController(primaryStage);
        primaryStage.setTitle(APPLICATION_NAME);

        final Image image = new Image(ICON_PATH);
        primaryStage.getIcons().add(image);

        borderPane.setTop(createMenu());
        borderPane.setCenter(controller.getTextArea());

        final Scene mainScene = new Scene(borderPane, 600.0, 700.0);
        mainScene.getStylesheets().add(TEXTAREA_STYLE[0]);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    private MenuBar createMenu() {
        final Menu dropDowMenuFile = initMenuFile();
        final Menu dropDowMenuFont = initMenuFont();
        final Menu dropDowMenuStyle = initMenuStyle();
        final Menu dropDowMenuTools = initMenuTools();
        final Menu dropDowMenuHelp = initMenuHelp();

        final MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(
                dropDowMenuFile,
                dropDowMenuFont,
                dropDowMenuStyle,
                dropDowMenuTools,
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
        menuItems[0].setOnAction((ActionEvent _) -> controller.resetFile());
        menuItems[1].setOnAction((ActionEvent _) -> {
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
        menuItems[2].setOnAction((ActionEvent _) -> {
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

        Arrays.stream(TEXTAREA_STYLE).map(s -> {
            MenuItem menuItem = new MenuItem(Utils.extractName(s));
            menuItem.setOnAction(_ -> controller.changeTextAreaStyle(s));
            return menuItem;

        }).forEach(menuStyle.getItems()::add);

        return menuStyle;
    }

    public Menu initMenuFont() {
        final Menu menuFont = new Menu("Font");
        final Menu dropDownFamilyMenu = new Menu("Family");

        Arrays.stream(FONT_FAMILIES)
                .map(MenuItem::new)
                .forEach(dropDownFamilyMenu.getItems()::add);

        MenuItem[] menuItems = {
                new MenuItem("Bigger [+]"),
                new MenuItem("Smaller [-]"),
                dropDownFamilyMenu
        };
        menuItems[0].setOnAction(_ -> {
            controller.changeFontSize(
                    true,
                    DEFAULT_CHANGE_FONT_JUMP);
        });
        menuItems[1].setOnAction(_ -> {
            controller.changeFontSize(false,
                    DEFAULT_CHANGE_FONT_JUMP);
        });

        IntStream.range(0, FONT_FAMILIES.length).forEach(i -> dropDownFamilyMenu.getItems().get(i)
                        .setOnAction(_ -> controller.changeFontFamily(FONT_FAMILIES[i])));
        menuFont.getItems().addAll(menuItems);

        return menuFont;
    }

    public Menu initMenuTools() {
        final Menu menuHelp = new Menu("Syntax");
        MenuItem[] menuItems = {
                new MenuItem("On"),
                new MenuItem("Off"),
        };
        menuHelp.getItems().addAll(menuItems);
        menuItems[0].setOnAction(_ -> borderPane.setCenter(controller.enableSyntaxView()));
        menuItems[1].setOnAction(_ -> borderPane.setCenter(controller.getTextArea()));
        return menuHelp;
    }

    public Menu initMenuHelp() {
        final Menu menuHelp = new Menu("Help");
        MenuItem[] menuItems = {
                new MenuItem("About")
        };
        menuHelp.getItems().addAll(menuItems);
        menuItems[0].setOnAction(_ -> controller.showHelp());
        return menuHelp;
    }



}
