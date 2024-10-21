package pl.cecherz;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class TextStreamController {
    public static String loadFileContent(String filepath) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(filepath), StandardCharsets.UTF_8));

        String line;
        StringBuilder fileContent = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            fileContent.append(line).append("\n");
        }
        return fileContent.toString();
    }
}
