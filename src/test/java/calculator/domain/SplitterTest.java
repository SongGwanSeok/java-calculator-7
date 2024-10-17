package calculator.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SplitterTest {

    @Test
    @DisplayName("구분자가 있을 때 split() 테스트 - success")
    void testSplitWithCustomDelimiterSuccess() {
        String input = "//[\\n123,21:3[4111";
        Splitter splitter = new Splitter(new DelimiterExtractor());
        List<String> expected = List.of("123", "21", "3", "4111");

        Assertions.assertThat(splitter.split(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("구분자가 없을 때 split() 테스트 - success")
    void testSplitWithoutCustomDelimiterSuccess() {
        String input = "123,21,3:4111";
        Splitter splitter = new Splitter(new DelimiterExtractor());
        List<String> expected = List.of("123", "21", "3", "4111");

        Assertions.assertThat(splitter.split(input)).isEqualTo(expected);
    }

}
