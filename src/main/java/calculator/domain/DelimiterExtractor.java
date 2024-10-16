package calculator.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DelimiterExtractor {

    private static final List<String> DEFAULT_DELIMITERS = List.of(",", ":");
    private static final String START_POINT = "//";
    private static final String END_POINT = "\\n";

    public Set<String> extractDelimiters(String input) {
        Set<String> delimiters = new HashSet<>(DEFAULT_DELIMITERS);

        int startIndex = input.indexOf(START_POINT);
        int endIndex = input.indexOf(END_POINT, startIndex);

        if (startIndex != -1 && endIndex != -1) {
            delimiters.add(input.substring(startIndex + START_POINT.length(), endIndex));
        }

        return delimiters;
    }

}
