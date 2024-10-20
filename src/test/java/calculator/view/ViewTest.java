package calculator.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ViewTest {
    @Test
    @DisplayName("입력 값을 반환한다.")
    void 입력_값_반환() {
        // Given
        InputView inputView = new InputView();
        String input = "입력값";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // When
        String result = inputView.getInput();

        // Then
        assertThat(result).isEqualTo(input);

        System.setIn(System.in); // Cleanup
    }

    @Test
    @DisplayName("입력 메시지를 출력한다.")
    void 입력_메시지_출력() {
        // Given
        OutputView outputView = new OutputView();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // When
        outputView.displayInputMessage();

        // Then
        assertThat(outputStream.toString()).isEqualTo("덧셈할 문자열을 입력해 주세요.\n");

        // Cleanup
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("결과를 출력한다.")
    void 결과_출력() {
        // Given
        OutputView outputView = new OutputView();
        int result = 6;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // When
        outputView.printResult(result);

        // Then
        assertThat(outputStream.toString()).isEqualTo("결과 : 6\n");

        // Cleanup
        System.setOut(originalOut);
    }
}
