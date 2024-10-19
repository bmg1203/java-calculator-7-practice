package calculator.operation;

import calculator.util.CalculatorUtils;

import java.util.*;

public class CalculatorRunner {

    Set<Character> separators = new HashSet<>(Set.of(',', ':'));

    public void run() {
        // 문자열 입력받기
        String userInput = CalculatorUtils.getInput();
        // 입력값에서 커스텀 구분자를 추출하기
        CalculatorUtils.extractSeparators(separators, userInput);
        // 사용자 입력이 올바른지 검사하기
        CalculatorUtils.checkInputFormat(userInput, separators);
    }
}
