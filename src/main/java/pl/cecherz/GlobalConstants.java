package pl.cecherz;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public record GlobalConstants() {
    public static final String APPLICATION_NAME = "PigNote";
    public static final String ICON_PATH = "Pig_icon.png";
    public static final String[] TEXTAREA_STYLE = {
            "default-style.css",
            "neo-style.css",
            "puppy-style.css",
            "choco-style.css",
            "metal-gear-style.css"
    };
    public static final int DEFAULT_CHANGE_FONT_JUMP = 1;
    public static final String[] FONT_FAMILIES = {
            "Consolas",
            "Constantia",
            "Courier New",
            "DejaVu Sans Light",
            "Lucida Console",
            "Segoe UI",
            "Source Sans Pro",
            "System",
    };
    public static final String[] PROGRAMMING_LANGUAGES = {
            "Java",
            "JavaScript",
            "PHP"
    };
    public static final Set<String> JAVA_KEYWORDS = new HashSet<>(Arrays.asList(
            "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally",
            "float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface",
            "long", "native", "new", "null", "package", "private", "protected", "public", "return",
            "short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws",
            "transient", "try", "void", "volatile", "while", "true", "false"
    ));
}


