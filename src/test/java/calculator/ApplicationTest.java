package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 공백_입력(){
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 구분자만_입력(){
        assertSimpleTest(() -> {
            run("//;\\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 커스텀_구분자와_음수가_입력되었을_때_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n-1;2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_입력_형식이_잘못되었을_때_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//21,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 형식에_맞지_않는_단순_문자열이_입력되었을_때_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("asd123"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자가_커스텀_구분자일_때_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//2\n12121"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_문자열에_구분자가_중복일_때_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1;;2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자_중복_입력되었을때_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//,;\\n1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_형식이_중복_입력되었을_때_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n//s\\n1;2s3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자가_잘못_입력되었을_때_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1;2a3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 영문자_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//x\\n1x2x3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void Int_자료형_범위를_넘어가는_덧셈(){
        assertSimpleTest(() -> {
            run("2147483647,1");
            assertThat(output()).contains("결과 : 2147483648");
        });
    }

    @Test
    void Long_자료형_범위를_넘어가는_덧셈(){
        assertSimpleTest(() -> {
            run("922337236854775807,1");
            assertThat(output()).contains("결과 : 922337236854775808");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
