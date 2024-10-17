package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

    @Test
    @DisplayName("calculator 빈 문자열 계산 실패 테스트 - fail")
    void testCalculateFail() {
        String input = "";
        Calculator calculator = new Calculator();

        Assertions.assertThatThrownBy(() -> calculator.calculate(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\\n1,2:3;4", "1,2:3:4", "//[\\n1,2[3:4"})
    @DisplayName("calculator 계산 결과 테스트 - success")
    void testCalculateSuccess(String input) {
        Calculator calculator = new Calculator();

        Assertions.assertThat(calculator.calculate(input)).isEqualTo(10);
    }

}