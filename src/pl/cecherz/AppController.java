package pl.cecherz;

import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AppController {
    private final Stage stage;
    private final TextArea textArea = new TextArea();
    private final FileChooser fileChooser = new FileChooser();

    public AppController(Stage stage) {
        this.stage = stage;
    }

    public TextArea getTextArea()  {
        return textArea;
    }
    public void openFile() throws IOException {
        File file = fileChooser.showOpenDialog(stage);

        if (file != null) {
            StringBuilder readFile = new StringBuilder();
            String filepath = file.getAbsolutePath();
            List<String> fileContent = Files.readAllLines(Path.of(filepath), StandardCharsets.UTF_8);
            for (String line : fileContent) {
                readFile.append(line).append("\n");
            }
            textArea.setText(readFile.toString());
        }
    }

    public void newFile() {
        textArea.setText("");
    }
}


