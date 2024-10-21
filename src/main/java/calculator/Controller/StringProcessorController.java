package calculator.Controller;

import calculator.DTO.StringCalculatorDTO;
import calculator.Service.CustomDelimiterExtractor;
import calculator.Service.DelimiterExtractor;
import calculator.Service.InputReader;
import calculator.Service.SumCalculator;
import calculator.View.StringCalculatorView;
import java.util.List;

public class StringProcessorController {
    // 의존성 주입 이후, 불변성 보장
    private final InputReader inputReader;
    private final DelimiterExtractor delimiterExtractor;
    private final CustomDelimiterExtractor customDelimiterExtractor;
    private final SumCalculator sumCalculator;
    private final StringCalculatorView stringCalculatorView;

    // 생성자에서 외부로부터의 의존성 주입
    public StringProcessorController(InputReader inputReader, DelimiterExtractor delimiterExtractor,
                                     CustomDelimiterExtractor customDelimiterExtractor, SumCalculator sumCalculator,
                                     StringCalculatorView stringCalculatorView) {

        this.inputReader = inputReader;
        this.delimiterExtractor = delimiterExtractor;
        this.customDelimiterExtractor = customDelimiterExtractor;
        this.sumCalculator = sumCalculator;
        this.stringCalculatorView = stringCalculatorView;
    }

    // 전체 프로세스 조율
    public void process() {
        try {
            // 입력을 받아서 DTO 생성
            StringCalculatorDTO inputDTO = inputReader.read();

            // 문자열을 기본 구분자를 기준으로 분리하는 로직 호출
            List<String> afterDefaultExtractor = delimiterExtractor.extractDelimiter(inputDTO);
            inputDTO.setDetachedInput(afterDefaultExtractor);

            // 기본 구분자로 분리된 문자열을 커스텀 구분자를 기준으로 또 다시 분리하는 로직 호출
            List<String> afterCustomExtractor = customDelimiterExtractor.extractDelimiter(inputDTO);
            inputDTO.setDetachedInput(afterCustomExtractor);

            // 구분자들로 분리된 문자열들을 계산해주는 로직 호출
            sumCalculator.sum(inputDTO);

            // View를 호출해 결과 출력
            stringCalculatorView.displayResult(inputDTO);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }
}
