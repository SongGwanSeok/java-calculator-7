package calculator.domain;

import java.util.List;

public class PositiveNumbers {

    private final List<PositiveNumber> numbers;

    public PositiveNumbers(List<String> numberStrings) {
        this.numbers = numberStrings
            .stream()
            .map(PositiveNumber::new)
            .toList();
    }

    public int calculateSum() {
        long result = numbers.stream()
            .mapToLong(PositiveNumber::getNumber)
            .sum();
        validateIntegerRange(result);

        return (int) result;
    }

    private void validateIntegerRange(long result) {
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("합계가 int 범위를 초과했습니다.");
        }
    }

}
