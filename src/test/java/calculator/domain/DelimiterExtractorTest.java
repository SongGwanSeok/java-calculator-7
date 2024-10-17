package calculator.domain;

import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DelimiterExtractorTest {

    @Test
    @DisplayName("구분자가 없는 경우 테스트 - success")
    void testExtractEmptyDelimitersSuccess() {
        String input = "1,2:3";
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();
        Set<Character> delimiters = delimiterExtractor.extractDelimiters(input);

        Assertions.assertThat(delimiters).hasSize(2);
        Assertions.assertThat(delimiters).isEqualTo(Set.of(',', ':'));
    }

    @ParameterizedTest
    @ValueSource(chars = {'[', ']', '-', '+', 'a', '0', '?', '/', '\\', '"', '\'', ';', '.', '<', '>', '!', '@', '#',
        '$', '%', '^', '&', '*', '(', ')', '='})
    @DisplayName("구분자가 있는 경우 테스트 - success")
    void testExtractDelimitersSuccess(char delimiter) {
        String input = "//" + delimiter + "\\n1,2:3,4,5";
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();
        Set<Character> delimiters = delimiterExtractor.extractDelimiters(input);

        Assertions.assertThat(delimiters).hasSize(3);
        Assertions.assertThat(delimiters).isEqualTo(Set.of(',', ':', delimiter));
    }

    @ParameterizedTest
    @ValueSource(strings = {"//,\\n", "//:\\n"})
    @DisplayName("구분자가 있는 경우 테스트 (기본 구분자) - success")
    void testExtractDefaultDelimitersSuccess(String input) {
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();
        Set<Character> delimiters = delimiterExtractor.extractDelimiters(input);

        Assertions.assertThat(delimiters).hasSize(2);
        Assertions.assertThat(delimiters).isEqualTo(Set.of(',', ':'));
    }

    @ParameterizedTest
    @ValueSource(strings = {";\\n1,2;;3", "/;\\n1,2;;3"})
    @DisplayName("왼쪽 패턴('//')이 없는 경우 테스트 - success")
    void testExtractDelimitersWrongLeftPatternFail(String input) {
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();

        Set<Character> delimiters = delimiterExtractor.extractDelimiters(input);

        Assertions.assertThat(delimiters).hasSize(2);
        Assertions.assertThat(delimiters).isEqualTo(Set.of(',', ':'));
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\1,2;3", "//;n1,2;3", "//;1,2;3", "//;\n1,2;3"})
    @DisplayName("오른쪽 패턴('\n')이 없는 경우 테스트 - success")
    void testExtractDelimitersWrongRightPatternFail(String input) {
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();

        Set<Character> delimiters = delimiterExtractor.extractDelimiters(input);

        Assertions.assertThat(delimiters).hasSize(2);
        Assertions.assertThat(delimiters).isEqualTo(Set.of(',', ':'));
    }

}