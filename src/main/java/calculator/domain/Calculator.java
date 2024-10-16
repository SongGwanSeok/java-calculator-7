package calculator.domain;

import java.util.List;
import java.util.Set;

public class Calculator {

    private final DelimiterExtractor delimiterExtractor;
    private final Splitter splitter;

    public Calculator(DelimiterExtractor delimiterExtractor, Splitter splitter) {
        this.delimiterExtractor = delimiterExtractor;
        this.splitter = splitter;
    }

    public int calculate(String input) {
        Set<String> delimiters = delimiterExtractor.extractDelimiters(input);
        List<String> splitInput = splitter.split(delimiters, input);

        PositiveNumbers numbers = new PositiveNumbers(splitInput);
        return numbers.calculateSum();
    }

}
