package pl.cecherz;

import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.List;

public class GUIController {
    private static Stage stage;
    private TextArea textArea = new TextArea();
    private FileChooser fileChooser = new FileChooser();
    private TextFlow textFlow = new TextFlow();

    public GUIController(Stage stage) {
        GUIController.stage = stage;
    }

    public TextArea getTextArea()  {
        return textArea;
    }

    public void resetFile() {
        textArea.setText("");
    }

    public void displayTextInWindow() throws IOException {
        File file = fileChooser.showOpenDialog(stage);
        String filepath = file.getAbsolutePath();

        String fileContent = TextStreamController.loadFileContent(filepath);
        textArea.setText(fileContent);
    }

    public void saveTextAreaToFile() throws IOException {
        File file = getFileExtChooser().showSaveDialog(stage);
        String textContent = textArea.getText();
        String fileName = String.valueOf(file);
        TextStreamController.saveFileContent(fileName, textContent);
    }

    public void changeTextAreaStyle(String cssStyle) {
        textArea.getStylesheets().clear();
        textArea.getStylesheets().add(cssStyle);
    }

    public void changeFontSize(boolean changeToBigger, int change) {
        Font currentFont = textArea.getFont();
        int currentFontSize = (int) currentFont.getSize();

        if (changeToBigger) {
            currentFontSize += change;
        } else {
            currentFontSize -= change;
        }
        textArea.setFont(Font.font(currentFont.getFamily(), currentFontSize));
    }

    public void changeFontFamily(String fontName) {
        Font currentFont = textArea.getFont();
        List<String> fontsCollections = Font.getFamilies();

        if (fontsCollections.contains(fontName)) {
            textArea.setFont(Font.font(fontName, currentFont.getSize()));
        } else {
            textArea.setFont(currentFont);
            System.out.println("Font is not installed in your system.");
            Font.getFamilies().forEach(System.out::println);
        }
    }

    public void showHelp() {
        textArea.setText(
        """
        PigNote
        Author: Kamil Cecherz
        2024.10
        """
        );
    }

    public TextFlow enableSyntaxView() {
        TextFlow textFlow = new TextFlow();
        String textAreaContent = textArea.getText();

        String[] tokens = textAreaContent.split(" ");
        for (String token: tokens) {
            Text text;
            if (token.matches("public|class|void")) {
                text = new Text(token + " ");
                text.setFill(Color.BLUE);
            } else {
                text = new Text(token + " ");
                text.setFill(Color.BLACK);
            }
            textFlow.getChildren().add(text);
        }
        return textFlow;
    }

    private FileChooser getFileExtChooser() {
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extensionTxtFilter = new FileChooser.ExtensionFilter(
                "TXT files (*.txt)", "*.txt");
        FileChooser.ExtensionFilter allFilesFilter = new FileChooser.ExtensionFilter(
                "All files (*.*)", "*.*");

        fileChooser.getExtensionFilters().addAll(extensionTxtFilter, allFilesFilter);
        return fileChooser;
    }
}


