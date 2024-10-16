package calculator.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DelimiterExtractor {

    private static final List<String> DEFAULT_DELIMITERS = List.of(",", ":");
    private static final String START_PATTERN = "//";
    private static final String END_PATTERN = "\\n";

    public Set<String> extractDelimiters(String input) {
        Set<String> delimiters = new HashSet<>(DEFAULT_DELIMITERS);

        int startIndex = input.indexOf(START_PATTERN);
        int endIndex = input.indexOf(END_PATTERN, startIndex);

        if (startIndex != -1 && endIndex != -1) {
            delimiters.add(input.substring(startIndex + START_PATTERN.length(), endIndex));
        }

        return delimiters;
    }

    public String getEndPattern() {
        return END_PATTERN;
    }

}
