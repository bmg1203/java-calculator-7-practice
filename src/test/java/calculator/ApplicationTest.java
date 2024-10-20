package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용_메인() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_구분자_공백() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//  \\n1  2  3"))
                        .isInstanceOf(IllegalArgumentException.class));
    }


    @Test
    void 오직_숫자() {
        assertSimpleTest(() -> {
            run("1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 일반_구분자_소수() {
        assertSimpleTest(() -> {
            run("//;\\n1.1;2.1;3.1");
            assertThat(output()).contains("결과 : 6.3");
        });
    }

    @Test
    void 커스텀_구분자_소수() {
        assertSimpleTest(() -> {
            run("1.1, 2.1, 3.1");
            assertThat(output()).contains("결과 : 6.3");
        });
    }

    @Test
    void 오직_문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }



//    @Test
//    void 숫자_컴마() {
//        assertSimpleTest(() -> {
//            run("1,");
//            assertThat(output()).contains("결과 : 1");
//        });
//    }
//
//    @Test
//    void 컴마_숫자() {
//        assertSimpleTest(() -> {
//            run(",1");
//            assertThat(output()).contains("결과 : 1");
//        });
//    }

    @Test
    void 입력_공백() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 일반_구분자() {
        assertSimpleTest(()->{
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자() {
        assertSimpleTest(()->{
            run("//^\\n1^3^3");
            assertThat(output()).contains("결과 : 7");
        });
    }

    @Test
    void 커스텀_구분자_입력_문자열() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//;;\\n1;;4;;2"))
                    .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_예약어_커스텀_구분자_일반_구분자_공존() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1;4,2:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_예약어_아닌_다른_문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1!4!2!3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 일반_예약어_커스텀_구분자_일반_구분자_공존() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1;4,2:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_숫자_아닌_문자_일반_구분자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_숫자_아닌_문자_커스텀_구분자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\na;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_메인() {
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
