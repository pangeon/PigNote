package pl.cecherz;

public class Utils {
    public static String extractName(String cssStyleName) {
        String result = cssStyleName.replaceAll("-style\\.css$", "");
        result = result.substring(0, 1).toUpperCase() + result.substring(1).toLowerCase();

        return result;
    }
}
