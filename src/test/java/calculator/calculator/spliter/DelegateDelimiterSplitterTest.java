package calculator.calculator.spliter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import calculator.calculator.SplitterFixture;
import calculator.splitter.AbstractDelimiterSplitter;
import calculator.splitter.DelegateDelimiterSplitter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class DelegateDelimiterSplitterTest {

    @ParameterizedTest
    @MethodSource("patternAndResultList")
    public void 문자분리(String value, List<String> result) {
        List<AbstractDelimiterSplitter> splitters = SplitterFixture.defaultSplitter();
        DelegateDelimiterSplitter splitter = new DelegateDelimiterSplitter(splitters);

        assertThat(splitter.split(value)).containsExactlyInAnyOrderElementsOf(result);
    }

    static Stream<Arguments> patternAndResultList() {
        return Stream.of(arguments("//.\\n1.2.3", Arrays.asList("1", "2", "3")),
                arguments("1,1,2", Arrays.asList("1", "1", "2")), arguments("1:1:3", Arrays.asList("3", "1", "1")),
                arguments("1:3,2", Arrays.asList("1", "2", "3")));
    }

    @Test
    public void 빈_문자열_분리() {
        DelegateDelimiterSplitter splitter = new DelegateDelimiterSplitter(SplitterFixture.defaultSplitter());

        assertThat(splitter.split("")).isEqualTo(List.of(""));
    }

    @Test
    public void null_입력() {
        DelegateDelimiterSplitter splitter = new DelegateDelimiterSplitter(SplitterFixture.defaultSplitter());
        assertThatIllegalArgumentException().isThrownBy(() -> splitter.split(null));
    }

}
