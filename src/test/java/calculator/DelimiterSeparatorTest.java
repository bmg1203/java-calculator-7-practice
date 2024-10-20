package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DelimiterSeparatorTest {

    @Test
    void 기본_구분자를_기준으로_문자열을_분리한다() {
        // given
        String input = "1,2:3";
        Delimiter defaultDelimiter = Delimiter.create(input);

        // when
        String[] split = DelimiterSeparator.split(input, defaultDelimiter);

        // then
        assertThat(split).isEqualTo(new String[]{"1", "2", "3"});
    }

    @Test
    void 커스텀_구분자를_기준으로_문자열을_분리한다() {
        // given
        String input = "1;2;3";
        Delimiter customDelimiter = Delimiter.create("//;\\n");

        // when
        String[] split = DelimiterSeparator.split(input, customDelimiter);

        // then
        assertThat(split).isEqualTo(new String[]{"1", "2", "3"});
    }
}
