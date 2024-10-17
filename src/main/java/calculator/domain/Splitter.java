package calculator.domain;

import java.util.List;
import java.util.Set;

public class Splitter {

    private static final int NOT_CONTAIN_END_PATTERN = -1;

    private final DelimiterExtractor delimiterExtractor;

    public Splitter(DelimiterExtractor delimiterExtractor) {
        this.delimiterExtractor = delimiterExtractor;
    }

    public List<String> split(String input) {
        Set<Character> delimiters = delimiterExtractor.extractDelimiters(input);
        String delimiterRegex = delimiterExtractor.makeDelimiterRegex(delimiters);

        String numberPart = splitNumberPartFrom(input);

        return List.of(numberPart.split(delimiterRegex));
    }

    private String splitNumberPartFrom(String input) {
        String endPattern = delimiterExtractor.getEndPattern();
        int endIndex = input.indexOf(endPattern);

        if (endIndex == NOT_CONTAIN_END_PATTERN) {
            return input;
        }
        return input.substring(endIndex + endPattern.length());
    }

}
