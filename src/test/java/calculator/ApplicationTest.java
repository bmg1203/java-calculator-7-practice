package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.controller.Parser;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1:2,6");
            assertThat(output()).contains("결과 : 9");
        });
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 여러개_커스텀_구분자_파싱_테스트() {
        // given
        String inputString = "//;\\n2///!/n//*\\n";
        Parser parser = new Parser();

        // when
        parser.parsingCustomSeparators(inputString);

        // then
        assertThat(parser.getSeparators())
                .containsExactly(';', '*');  // ;와 *가 제대로 파싱되었는지 확인
    }

    @Test
    void 피연산자_파싱_테스트() {
        // given
        String inputString = "//;\\n2;32,15";
        Parser parser = new Parser();

        // when
        parser.addBasicSeparators(); // 기본 구분자 추가
        parser.parsingCustomSeparators(inputString); // 커스텀 구분자 파싱
        parser.parsingOperands(); // 피연산자 파싱

        // then
        assertThat(parser.getOperands())
                .containsExactly(2, 32, 15);
    }

    @Test
    void 구분자_없는_문자열_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("\"23/43-23"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 피연산자_없는_문자열_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("///**!"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력문자열_음수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
