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
    public static final Set<String> JAVASCRIPT_KEYWORDS = new HashSet<>(Arrays.asList(
            "abstract", "await", "boolean", "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "debugger", "default", "delete", "do", "double", "else", "enum", "export", "extends",
            "false", "final", "finally", "float", "for", "function", "goto", "if", "implements", "import",
            "in", "instanceof", "int", "interface", "let", "long", "native", "new", "null", "package",
            "private", "protected", "public", "return", "short", "static", "super", "switch", "synchronized",
            "this", "throw", "throws", "transient", "true", "try", "typeof", "var", "void", "volatile", "while",
            "with", "yield"
    ));
    public static final Set<String> PHP_KEYWORDS = new HashSet<>(Arrays.asList(
            "__halt_compiler", "abstract", "and", "array", "as", "break", "callable", "case", "catch", "class",
            "clone", "const", "continue", "declare", "default", "die", "do", "echo", "else", "elseif", "empty",
            "enddeclare", "endfor", "endforeach", "endif", "endswitch", "endwhile", "eval", "exit", "extends",
            "final", "finally", "for", "foreach", "function", "global", "goto", "if", "implements", "include",
            "include_once", "instanceof", "insteadof", "interface", "isset", "list", "namespace", "new", "or",
            "print", "private", "protected", "public", "require", "require_once", "return", "static", "switch",
            "throw", "trait", "try", "unset", "use", "var", "while", "xor", "yield", "true", "false", "null"
    ));
}


