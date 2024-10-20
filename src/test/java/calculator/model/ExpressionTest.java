package calculator.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExpressionTest{

    /*
        validation 에서 검증이 끝난 올바른 계산식들만 input 으로 들어옴
     */
    @Test
    void 계산식_생성() {
        String input = "1,2,3";
        String input2 = "//a\n1,2a3:4";
        Expression newExpression = new Expression(input);
        Expression newExpression2 = new Expression(input2);

        // 생성자 동작하는 지 테스트
        Assertions.assertThat(newExpression).isNotNull();

        // 입력받은 문자열을 정제된 계산식으로 변경하는 지 테스트
        Assertions.assertThat(newExpression.getExpression()).isEqualTo("1+2+3");

        Assertions.assertThat(newExpression2.getExpression()).isEqualTo("1+2+3+4");

    }
}
