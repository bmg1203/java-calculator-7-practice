package calculator.numberExtractor;

import java.util.List;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberExtractorTest {

    @Test
    void 문자열에서_숫자를_추출한다() {
        //given
        NumberExtractorImpl sut = new NumberExtractorImpl();

        //when
        List<Integer> result = sut.extract("1:2:3", Set.of(':', ','));

        //then
        Assertions.assertThat(result).containsExactly(1, 2, 3);
    }

    @Test
    void 문자열에서_두자리_이상의_숫자를_추출한다() {
        //given
        NumberExtractorImpl sut = new NumberExtractorImpl();

        //when
        List<Integer> result = sut.extract("1:12:123:1234", Set.of(':', ','));

        //then
        Assertions.assertThat(result).containsExactly(1, 12, 123, 1234);
    }

    @Test
    void 구분자로_지정되지_않은_기호가_있으면_예외가_발생한다() {
        //given
        NumberExtractorImpl sut = new NumberExtractorImpl();

        //expected
        Assertions.assertThatThrownBy(() ->
                        sut.extract("1:2^3", Set.of(':', ',')))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력된 문자열에 구분자와 숫자가 아닌 문자가 포함되어 있습니다.");
    }

    @Test
    void 숫자도_구분자로_활용될_수_있다() {
        //given
        NumberExtractorImpl sut = new NumberExtractorImpl();

        //when
        List<Integer> result = sut.extract("10203", Set.of('0'));

        //then
        Assertions.assertThat(result).containsExactly(1, 2, 3);
    }

    @Test
    void 입력_범위를_넘는_숫자가_입력되면_예외가_발생한다() {
        //given
        NumberExtractorImpl sut = new NumberExtractorImpl();

        //expected
        Assertions.assertThatThrownBy(() ->
                        sut.extract("21474836478:10", Set.of(':')))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력된 문자열에 입력 최대값을 넘는 숫자가 포함되어 있습니다.");
    }
}