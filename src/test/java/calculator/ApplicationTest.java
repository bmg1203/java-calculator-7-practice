package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Override
    public void runMain() {
        Application.main(new String[]{}); // Application의 main 메서드 호출
    }

    @Test
    void 빈_문자열_입력() {
        assertSimpleTest(() -> {
            long result = Application.calculate(null);
            assertThat(result).isEqualTo(0); // null 입력 시 0 반환
        });

        assertSimpleTest(() -> {
            long result = Application.calculate("");
            assertThat(result).isEqualTo(0); // 빈 문자열 입력 시 0 반환
        });
    }

    @Test
    void 숫자_하나만_입력() {
        assertSimpleTest(() -> {
            long result = Application.calculate("1");
            assertThat(result).isEqualTo(1); // 숫자 하나 입력 시 해당 숫자 반환
        });
    }

    @Test
    void 쉼표_구분자로_숫자_덧셈() {
        assertSimpleTest(() -> {
            long result = Application.calculate("1,2,3");
            assertThat(result).isEqualTo(6); // 1 + 2 + 3 = 6
        });
    }

    @Test
    void 쉼표와_콜론_구분자로_숫자_덧셈() {
        assertSimpleTest(() -> {
            long result = Application.calculate("1,2:3");
            assertThat(result).isEqualTo(6); // 1 + 2 + 3 = 6
        });
    }

    @Test
    void 음수_입력시_예외처리() {
        assertThatThrownBy(() -> Application.calculate("1,-2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수는 허용되지 않습니다"); // 음수 입력 시 예외 발생
    }

    @Test
    void 음수가_두개일때_예외처리() {
        assertThatThrownBy(() -> Application.calculate("-1,-2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수는 허용되지 않습니다"); // 음수가 두 개일 때 예외 발생
    }

    @Test
    void 콜론_구분자로_숫자_덧셈() {
        assertSimpleTest(() -> {
            long result = Application.calculate("1:2:3");
            assertThat(result).isEqualTo(6); // 1 + 2 + 3 = 6
        });
    }

    @Test
    void 커스텀_구분자로_숫자_덧셈() {
        assertSimpleTest(() -> {
            long result = Application.calculate("//;\n1;2;3");
            assertThat(result).isEqualTo(6); // 1 + 2 + 3 = 6
        });

        assertSimpleTest(() -> {
            long result = Application.calculate("//|\n4|5|6");
            assertThat(result).isEqualTo(15); // 4 + 5 + 6 = 15
        });
    }

    @Test
    void 커스텀_구분자가_기본_구분자와_혼합된_경우() {
        assertSimpleTest(() -> {
            long result = Application.calculate("//;\n1;2,3:4");
            assertThat(result).isEqualTo(10); // 1 + 2 + 3 + 4 = 10
        });
    }

    @Test
    void 커스텀_구분자_정의가_없는경우() {
        assertThatThrownBy(() -> Application.calculate("//\n1,2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효한 숫자를 입력해야 합니다!"); // 커스텀 구분자가 비어있을 때 예외 발생
    }
}
