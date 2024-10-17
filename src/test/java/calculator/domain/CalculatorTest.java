package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"//;\\n1,2:3;4", "1,2:3:4", "//[\\n1,2[3:4"})
    @DisplayName("calculator 계산 결과 테스트 - success")
    void testCalculateSuccess(String input) {
        Calculator calculator = new Calculator();

        Assertions.assertThat(calculator.calculate(input)).isEqualTo(10);
    }

}