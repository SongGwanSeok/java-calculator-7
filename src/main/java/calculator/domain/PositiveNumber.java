package calculator.domain;

public class PositiveNumber {

    private static final String POSITIVE_INTEGER_REGEX = "^[1-9]\\d*$";

    private final int number;

    public PositiveNumber(String numberString) {
        validatePositiveNumber(numberString);
        this.number = Integer.parseInt(numberString);
    }

    private void validatePositiveNumber(String splitString) {
        if (!splitString.matches(POSITIVE_INTEGER_REGEX)) {
            throw new IllegalArgumentException("양수만 입력해야 합니다.");
        }
    }

    public int getNumber() {
        return number;
    }

}
