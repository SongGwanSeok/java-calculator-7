package calculator.domain;

import java.util.List;
import java.util.Set;

public class Splitter {

    private static final String END_POINT = "\\n";

    private final DelimiterExtractor delimiterExtractor;

    public Splitter(DelimiterExtractor delimiterExtractor) {
        this.delimiterExtractor = delimiterExtractor;
    }

    public List<String> split(String input) {
        Set<String> delimiters = delimiterExtractor.extractDelimiters(input);
        String regex = String.join("|", delimiters);

        return List.of(getNumberPart(input).split(regex));
    }

    private String getNumberPart(String input) {
        int endIndex = input.indexOf(END_POINT);

        if (endIndex == -1) {
            return input;
        }
        return input.substring(endIndex + 2);
    }

}
