package calculator.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DelimiterExtractor {

    private static final List<Character> DEFAULT_DELIMITERS = List.of(',', ':');
    private static final List<Character> REGEX_DELIMITERS = List.of('[', ']', '\\', '^', '-');
    private static final String DELIMITER_PART_REGEX = "^//.?\\\\n.*";
    private static final String ESCAPE_CHARACTER = "\\";
    private static final String END_PATTERN = "\\n";
    private static final Integer DELIMITER_IDX = 2;

    public Set<Character> extractDelimiters(String input) {
        Set<Character> delimiters = new HashSet<>(DEFAULT_DELIMITERS);
        if (isContainDelimiter(input) && isNotEmptyDelimiter(input)) {
            delimiters.add(input.charAt(DELIMITER_IDX));
        }

        return delimiters;
    }

    public boolean isContainDelimiter(String input) {
        return input.matches(DELIMITER_PART_REGEX);
    }

    private boolean isNotEmptyDelimiter(String input) {
        return input.indexOf(END_PATTERN) != DELIMITER_IDX;
    }

    public String makeDelimiterRegex(Set<Character> delimiters) {
        return "[" + delimiters.stream()
            .map(this::escapeSpecialCharacter)
            .collect(Collectors.joining()) + "]";
    }

    private String escapeSpecialCharacter(char delimiter) {
        if (REGEX_DELIMITERS.contains(delimiter)) {
            return ESCAPE_CHARACTER + delimiter;
        }
        return String.valueOf(delimiter);
    }

}
