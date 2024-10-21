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

    public void newFile() {
        textArea.setText("");
    }

    public void displayTextInWindow() throws IOException {
        File file = fileChooser.showOpenDialog(stage);
        String filepath = file.getAbsolutePath();

        String fileContent = TextStreamController.loadFileContent(filepath);
        textArea.setText(fileContent);
    }
}


