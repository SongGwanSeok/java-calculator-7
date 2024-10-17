package calculator.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DelimiterExtractor {

    private static final List<Character> DEFAULT_DELIMITERS = List.of(',', ':');
    private static final String START_PATTERN = "//";
    private static final String END_PATTERN = "\\n";
    private static final Integer DELIMITER_IDX = 2;
    private static final Integer END_PATTERN_IDX = 3;

    public Set<Character> extractDelimiters(String input) {
        Set<Character> delimiters = new HashSet<>(DEFAULT_DELIMITERS);

        if (isContainDelimiter(input)) {
            delimiters.add(input.charAt(DELIMITER_IDX));
        }

        return delimiters;
    }

    private boolean isContainDelimiter(String input) {
        if (!input.startsWith(START_PATTERN)) {
            return false;
        }
        return input.contains(END_PATTERN) && input.indexOf(END_PATTERN) == END_PATTERN_IDX;
    }

    public String makeDelimiterRegex(Set<Character> delimiters) {
        return "[" + delimiters.stream()
            .map(this::escapeSpecialCharacter)
            .collect(Collectors.joining()) + "]";
    }

    private String escapeSpecialCharacter(char c) {
        return switch (c) {
            case '.', '+', '[', ']' -> "\\" + c;
            default -> String.valueOf(c);
        };
    }

    public String getEndPattern() {
        return END_PATTERN;
    }

}
