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


