package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        String stringValue = InputString.input(); // 문자열 받기
        StringValueDivide.divide(stringValue); // 커스텀 구분자 선언 부분과 계산식 부분으로 나눔
        String customDelimiterAssign = StringValueDivide.getCustomDelimiterAssign(); // 커스텀 구분자 선언 부분
        String expression = StringValueDivide.getExpression(); // 계산식 부분
        List<String> customDelimiterList = CustomDelimiter.getCustomDelimiterList(customDelimiterAssign); // 커스텀 구분자 리스트 받아오기
        List<Integer> numberList = Expression.getNumberList(expression, customDelimiterList); // 숫자 추출하기 (일단, 구분자 상관없이)
        System.out.println("결과 : " + Calculate.getTotalPlus(numberList)); // 계산 결과 출력
    }
}
