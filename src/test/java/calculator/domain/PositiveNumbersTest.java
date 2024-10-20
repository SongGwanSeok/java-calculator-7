package calculator.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositiveNumbersTest {

    @Test
    @DisplayName("calculateSum() 테스트 - success")
    void testPositiveNumbersSuccess() {
        // given
        List<String> numbers = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        PositiveNumbers positiveNumbers = new PositiveNumbers(numbers);
        int expected = 55;

        // when
        int actual = positiveNumbers.calculateSum();

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("calculateSum() 테스트 - fail")
    void testPositiveNumbersFail() {
        // given
        List<String> numbers = List.of("2147483647", "2147483647");
        PositiveNumbers positiveNumbers = new PositiveNumbers(numbers);

        // when then
        Assertions.assertThatThrownBy(positiveNumbers::calculateSum)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
