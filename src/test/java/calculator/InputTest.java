package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputTest {

    @DisplayName("입력값을 잘 가져오는지 테스트")
    @Test
    void getInput(){
        InputView inputView = new InputView();
        String inputValue = inputView.scanString("1,2:3");
        assertThat(inputValue).isEqualTo("1,2:3");
    }

    @DisplayName("올바른 입력 값일 때 유효한 값이라 판단하는지 테스트")
    @Test
    void getInput(){
        InputView inputView = new InputView();
        boolean inputValue = inputView.isValidString("//;\\n1");
        assertThat(inputValue).isTrue();
    }

    @DisplayName("음수 입력 시 유효하지 않은 값이라 판단하는지 테스트")
    @Test
    void getInput(){
        InputView inputView = new InputView();
        boolean inputValue = inputView.isValidString("-1,2,3");
        assertThat(inputValue).isFalse();
    }
}
