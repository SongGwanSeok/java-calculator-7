package calculator.domain;

import java.util.List;

public class Calculator {

    private final Splitter splitter;

    public Calculator() {
        this.splitter = new Splitter(new DelimiterExtractor());
    }

    public int calculate(String input) {
        validateInput(input);
        List<String> splitInput = splitter.split(input);

        PositiveNumbers numbers = new PositiveNumbers(splitInput);
        return numbers.calculateSum();
    }

    private void validateInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("문자열 입력해주세요.");
        }
    }

}
