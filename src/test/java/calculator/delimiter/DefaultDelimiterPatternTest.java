package calculator.delimiter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DefaultDelimiterPatternTest {
    private static DefaultDelimiterPattern pattern;

    @BeforeAll
    static void beforeAll() {
        pattern = new DefaultDelimiterPattern();
    }

    @ParameterizedTest
    @CsvSource({
            "'1'",
            "'10'",
            "'100'",
            "'1,2'",
            "'1:2'",
            "'1,2,3'",
            "'1,2:3'",
            "'1:2,3'",
            "'1:25:3'",
            "'1:25:1000'"
    })
    public void 정상적인_상황_성공(String input) {
        assertThat(pattern.validate(input)).isTrue();
    }

    @Test
    public void 빈_문자열_성공() {
        assertThat(pattern.validate("")).isTrue();
    }

    @ParameterizedTest
    @CsvSource({
            "'0'",
            "'-1,2'",
            "'0:2'",
            "'-1,-2,-3'",
            "'-1,0:-1'",
            "'-1:-1,-1'",
            "'1:-25:3'"
    })
    public void 구분자는_정상인데_숫자가_양수가_아닌경우(String input) {
        assertThat(pattern.validate(input)).isFalse();
    }

    @ParameterizedTest
    @CsvSource({
            "'1ㅁ2'",
            "'1''5'",
            "'1\\3'",
            "'1/3'",
            "'1\\n3'"
    })
    public void 숫자는_정상인데_허용되지않는_구분자일떄(String input) {
        assertThat(pattern.validate(input)).isFalse();
    }

    @ParameterizedTest
    @CsvSource({
            "'asd'",
            "'aswe🤪'",
            "'12:안녕하세요'",
            "'1:안,녕:3'"
    })
    public void 아예_패턴에_맞지_않는_경우(String input) {
        assertThat(pattern.validate(input)).isFalse();
    }

    @ParameterizedTest
    @CsvSource({
            "'01:2,3'",
            "'1:05:3'",
    })
    public void 숫자앞에_0이_포함될때(String input) {
        assertThat(pattern.validate(input)).isFalse();
    }

    @Test
    public void 최대_숫자_범위_1000을_넘을때() {
        assertThat(pattern.validate("1,2,1001")).isFalse();
    }

    @Test
    void 숫자_갯수가_50개일때() {
        StringBuilder input = new StringBuilder("1");
        for (int i = 2; i <= 50; i++) {
            input.append(",").append(i);
        }
        assertThat(pattern.validate(input.toString())).isTrue();
    }

    @Test
    void 숫자_갯수_50개를_넘을때() {
        StringBuilder input = new StringBuilder("1");
        for (int i = 2; i <= 51; i++) {
            input.append(",").append(i);
        }
        assertThat(pattern.validate(input.toString())).isFalse();
    }
}
