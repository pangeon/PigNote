package pl.cecherz;

import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class GUIController {
    private static Stage stage;
    private TextArea textArea = new TextArea();
    private FileChooser fileChooser = new FileChooser();

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

    public void changeFontSize(boolean changeToBigger, int fontSize, int change) {
        String defaultStyle = textArea.getStyle();

        if (defaultStyle.contains("-fx-font-size:")) {
            String fontSizeFromStyle = defaultStyle.replaceAll("[^0-9]", "");
            fontSize = Integer.parseInt(fontSizeFromStyle);
        }

        if (changeToBigger) {
            fontSize += change;
        } else {
            fontSize -= change;
        }
        textArea.setStyle("-fx-font-size: " + fontSize + "px;");
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


