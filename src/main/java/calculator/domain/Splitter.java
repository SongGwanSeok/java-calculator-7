package calculator.domain;

import java.util.List;
import java.util.Set;

public class Splitter {

    private static final String PART_SEPARATOR = "\\n";
    private final DelimiterExtractor delimiterExtractor;

    public Splitter(DelimiterExtractor delimiterExtractor) {
        this.delimiterExtractor = delimiterExtractor;
    }

    public List<String> split(String input) {
        Set<Character> delimiters = delimiterExtractor.extractDelimiters(input);
        String delimiterRegex = delimiterExtractor.makeDelimiterRegex(delimiters);
        String numberPart = getNumberPart(input);

        return List.of(numberPart.split(delimiterRegex));
    }

    private String getNumberPart(String input) {
        if (!delimiterExtractor.isContainDelimiter(input)) {
            return input;
        }
        return input.substring(input.indexOf(PART_SEPARATOR) + PART_SEPARATOR.length());
    }

}
