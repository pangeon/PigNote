package pl.cecherz;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LanguageSyntax {
    private String langName;
    private Set<String> keywords;

    public LanguageSyntax(String langName, Set<String> keywords) {
        this.langName = langName;
        this.keywords = keywords;
    }

    public String getLangName() {
        return langName;
    }

    public Set<String> getKeywords() {
        return keywords;
    }
}
