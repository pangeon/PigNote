package pl.cecherz;

import java.io.*;
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
        reader.close();
        return fileContent.toString();
    }

    public static void saveFileContent(String fileName, String fileContent) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        writer.write(fileContent);
        writer.close();
    }
}
