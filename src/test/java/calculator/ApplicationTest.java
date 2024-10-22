package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

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
    /*
     * isEmpty 메서드 테스트
     * 입력값이 빈 문자열인지 확인
     */
    @Test
    void 빈_문자열일_경우_true_반환(){
        String input = "";
        Boolean result = Application.isEmpty(input);
        assertThat(result).isEqualTo(true);
    }
    @Test
    void 빈_문자열이_아닐_경우_1_반환(){
        String input = "1,2";
        Boolean result = Application.isEmpty(input);
        assertThat(result).isEqualTo(false);
    }

    /*
     * validateInput 메서드 테스트
     input = "1,2:3", "//;\n1;2;3", "//2\n123", "a,b;c", "//a\na123", "//;\na1;23",
     "//;*\n1;2;3", 커스텀구분자가 /,\n," 중에 있을 경우를 테스트
     */
    @Test
    void 기본_구분자와_숫자만_있는경우_예외_없음(){
        String input = "1,2:3";
        Application.validateInput(input);
        assertThat(true).isTrue();
    }
    @Test
    void 커스텀_구분자_예외_없음(){
        String input = "//;\n1;2;3";
        Application.validateInput(input);
        assertThat(true).isTrue();
    }
    @Test
    void 커스텀_구분자에_숫자가_포함될_경우_예외_발생(){
        String input = "//2\n123";
        assertThatThrownBy(() -> Application.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_대신_알파벳일_경우_예외_발생(){
        String input = "a,b;c";
        assertThatThrownBy(() -> Application.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀_구분자에_알파벳이_포함된_경우_예외_발생(){
        String input = "//a\n123";
        assertThatThrownBy(() -> Application.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_대신_알파벳이_있을_경우_예외_발생(){
        String input = "//;\\na1;23";
        assertThatThrownBy(() -> Application.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 커스텀_구분자의_일부만_있을_경우_예외_발생(){
        String input = "//;*\\n1;2;3";
        assertThatThrownBy(() -> Application.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 커스텀_구분자에_이스케이프_문자가_포함될_경우_예외_없음(){
        String input = "//\\\n1\\2";
        Application.validateInput(input);
        assertThat(true).isTrue();
    }

    /*
     * splitByDelimiter 메서드 테스트
     * - 기본 구분자와 커스텀 구분자를 사용하여 문자열을 올바르게 분리하는지 검증
     */
    @Test
    void 기본_구분자로_문자열_분리() {
        String input = "1,2:3";
        String Delimiter = "[,|:]";
        String[] result = Application.splitByDelimiter(input, Delimiter);
        String[] answer = {"1", "2", "3"};
        assertThat(result).isEqualTo(answer);
    }
    @Test
    void 커스텀_구분자로_문자열_분리() {
        String input = "1;2;3";
        String Delimiter = ";";
        String[] result = Application.splitByDelimiter(input, Delimiter);
        String[] answer = {"1", "2", "3"};
        assertThat(result).isEqualTo(answer);
    }

    /*
     * sumNumbers 메서드 테스트
     */
    @Test
    void 숫자_계산() {
        String[] numbers = {"1", "2", "3"};
        int result = Application.sumNumbers(numbers);
        int answer = 6;
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void 큰_숫자_계산() {
        String[] numbers = {"1000000", "2000000", "3000000"};
        int result = Application.sumNumbers(numbers);
        int answer = 6000000;
        assertThat(result).isEqualTo(answer);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
