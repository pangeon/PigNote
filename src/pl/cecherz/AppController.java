package pl.cecherz;

import javafx.scene.control.TextArea;

public class AppController {
    private static final TextArea textArea = new TextArea();

    public TextArea getTextArea()  {
        return textArea;
    }
    public void newFile() {
        textArea.setText("");
    }
}


