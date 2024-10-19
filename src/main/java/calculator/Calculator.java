package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    private final Delimiter delimiter = new Delimiter();
    private final Converter converter = new Converter();

    public void startCalculate() {
        System.out.println("덧셈할 문자열을 입력해주세요.");

        String inputString = Console.readLine();
        
        String numberString = delimiter.extractNumberString(inputString);

        StringBuilder delimiterExpression = new StringBuilder();
        for (char delimiter : delimiter.getDelimiters()) {
            this.delimiter.appendDelimiter(delimiterExpression, delimiter);
        }

        String delimiterStr = delimiterExpression.toString();

        String[] numList = numberString.split(delimiterStr);

        int sum = 0;

        for (String token : numList) {

            String trimToken = token.trim();

            sum += converter.convertToValidInteger(trimToken);

        }

        System.out.println("결과 : " + sum);
    }
}
