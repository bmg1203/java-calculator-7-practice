package calculator;

import calculator.domain.Calculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void 빈_문자열_또는_null_입력_0_반환() {
        assertThat(calculator.splitAndSum("")).isZero();
        assertThat(calculator.splitAndSum(null)).isZero();
    }

    @Test
    void 기본_구분자_사용() {
        assertThat(calculator.splitAndSum("1,2,3")).isEqualTo(6);
        assertThat(calculator.splitAndSum("1:2:3")).isEqualTo(6);
        assertThat(calculator.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자_사용() {
        assertThat(calculator.splitAndSum("//;\\n1;2;3")).isEqualTo(6);
        assertThat(calculator.splitAndSum("//.\\n1.2.3")).isEqualTo(6);
        assertThat(calculator.splitAndSum("//;\\n1;2,3:4")).isEqualTo(10);
    }

    @Test
    void 공백이_포함된_문자열_입력_테스트() {
        assertThat(calculator.splitAndSum("1 , 2 , 3")).isEqualTo(6);
        assertThat(calculator.splitAndSum("1 , 2: 3")).isEqualTo(6);
        assertThat(calculator.splitAndSum("//;\\n1: 2 , 3 ; 4; 5")).isEqualTo(15);
    }

    @Test
    void 구분자가_잘못된_위치에_있는_경우_예외_테스트() {
        assertThatThrownBy(() -> calculator.splitAndSum(",1,2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구분자가 잘못된 위치에 있습니다. 입력값: [,1,2]");

        assertThatThrownBy(() -> calculator.splitAndSum("1,2,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구분자가 잘못된 위치에 있습니다. 입력값: [1,2,]");
    }

    @Test
    void 연속된_구분자_입력_예외_테스트() {
        assertThatThrownBy(() -> calculator.splitAndSum("1,,2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("연속된 구분자가 포함된 잘못된 입력입니다. 입력값: [1,,2]");

        assertThatThrownBy(() -> calculator.splitAndSum("1,,,,2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("연속된 구분자가 포함된 잘못된 입력입니다. 입력값: [1,,,,2]");

        assertThatThrownBy(() -> calculator.splitAndSum("1,:2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("연속된 구분자가 포함된 잘못된 입력입니다. 입력값: [1,:2]");
        assertThatThrownBy(() -> calculator.splitAndSum("1,::,2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("연속된 구분자가 포함된 잘못된 입력입니다. 입력값: [1,::,2]");
    }

    @Test
    void 구분자_사이에_공백이_포함된_경우_예외_테스트() {
        assertThatThrownBy(() -> calculator.splitAndSum("1,  ,2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구분자 사이에 공백이 포함된 잘못된 입력입니다. 입력값: [1,  ,2]");

        assertThatThrownBy(() -> calculator.splitAndSum("//;\\n1;  ;2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구분자 사이에 공백이 포함된 잘못된 입력입니다. 입력값: [1;  ;2]");
    }

    @Test
    void 빈_커스텀_구분자_입력_예외_테스트() {
        assertThatThrownBy(() -> calculator.splitAndSum("//\\n"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 커스텀 구분자입니다. 문제가 되는 입력값: [null]");
    }

    @Test
    void 커스텀_구분자로_숫자가_입력된_경우_예외_테스트() {
        assertThatThrownBy(() -> calculator.splitAndSum("//2\\n123,4"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 커스텀 구분자입니다. 숫자는 구분자로 사용할 수 없습니다. 문제가 되는 입력값: [2]");
    }

    @Test
    void 여러_개의_커스텀_구분자_예외_테스트() {
        assertThatThrownBy(() -> calculator.splitAndSum("//;[]\\n1;[]2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 커스텀 구분자입니다. 구분자는 단일 문자여야 합니다. 문제가 되는 입력값: [;[]]");
    }

    @Test
    void 여러_개의_커스텀_구분자_추출_문자열이_포함된_경우_예외_테스트() {
        assertThatThrownBy(() -> calculator.splitAndSum("//;\\n//'\\n1;2'3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("여러 개의 커스텀 구분자 추출 문자열이 포함된 잘못된 입력값입니다.");

        assertThatThrownBy(() -> calculator.splitAndSum("//;\\n//|\\n1;2|3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("여러 개의 커스텀 구분자 추출 문자열이 포함된 잘못된 입력값입니다.");
    }

    @Test
    void 숫자가_아닌_값이_포함된_경우_예외_테스트() {
        assertThatThrownBy(() -> calculator.splitAndSum("1,a,2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 값이 유효한 정수가 아닙니다.");
    }

    @Test
    void 음수_입력_예외_테스트() {
        assertThatThrownBy(() -> calculator.splitAndSum("1,-2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구분자와 양수만 입력 가능합니다. 문제가 되는 입력값: [-2]");
    }

    @Test
    void zero_입력_예외_테스트() {
        assertThatThrownBy(() -> calculator.splitAndSum("1,0,2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구분자와 양수만 입력 가능합니다. 문제가 되는 입력값: [0]");
    }

    @Test
    void 숫자_입력값_오버플로우_예외_테스트() {
        assertThatThrownBy(() -> calculator.splitAndSum("2147483648,1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력한 숫자가 정수 범위를 초과했습니다. 문제가 되는 입력값: [2147483648]");

        assertThatThrownBy(() -> calculator.splitAndSum("//;\\n2147483648;1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력한 숫자가 정수 범위를 초과했습니다. 문제가 되는 입력값: [2147483648]");
    }

    @Test
    void 계산_결과_오버플로우_예외_테스트() {
        assertThatThrownBy(() -> calculator.splitAndSum("2147483647,1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력한 값의 계산 결과가 정수 범위를 초과했습니다.");
    }
}
