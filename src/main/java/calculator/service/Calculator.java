package calculator.service;

import java.util.List;

import calculator.controller.InputController;
import calculator.controller.NumberController;
import calculator.controller.OutputController;
import calculator.controller.DelimiterController;

public class Calculator {
    private final InputController inputController = new InputController();
    private final OutputController outputController = new OutputController();
    private final DelimiterController delimiterController = new DelimiterController();
    private final NumberController numberController = new NumberController();

    // calculator의 전체 동작이 순차적으로 실행되는 메서드
    public void run() {
        // 사용자의 입력값을 받아옴
        String inputString = inputController.getInputString();

        // 사용자의 입력값으로부터 커스텀 구분자를 추출
        delimiterController.extractDelimiter(inputString);

        // 커스텀 구분자를 포함한 모든 구분자들을 정규표현식 형태로 변환
        String regex = delimiterController.getRegex();

        // 숫자와 구분자만 남아있는 문자열에서 숫자만 추출
        numberController.extractNumber(inputString, regex);

        // List에 담긴 숫자들을 모두 덧셈
        int result = sumNumbers(numberController.getNumbersToList());

        // 결과물 출력
        outputController.writeResult(result);
    }

    // List에 담긴 숫자들을 순차적으로 덧셈
    private int sumNumbers(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}