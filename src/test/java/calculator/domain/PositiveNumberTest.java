package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositiveNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "22", "333", "4444", "55555", "666666", "7777777", "88888888", "999999999"})
    @DisplayName("PositiveNumber 생성 테스트 - success")
    void testPositiveNumberSuccess(String numberString) {
        PositiveNumber positiveNumber = new PositiveNumber(numberString);

        Assertions.assertThat(positiveNumber.getNumber()).isEqualTo(Integer.parseInt(numberString));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "3.14", "9999999999"})
    @DisplayName("PositiveNumber 생성 테스트 - fail")
    void testPositiveNumberFail(String numberString) {
        Assertions.assertThatThrownBy(() -> new PositiveNumber(numberString))
            .isInstanceOf(IllegalArgumentException.class);
    }

}