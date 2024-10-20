package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        try {
            String targetString = Input.read();
            int result = calculator.process(targetString);
            Output.handleResult(result);
        } finally {
            Console.close();
        }
    }
}


class Calculator {
    public int process(String input) {
        if (input.trim().isEmpty()) return 0;

        Parser parser = new ProxyParser(chooseParser(input));  // 파서 선택
        String[] parsedNumbers = parser.parse(input);
        int[] numbers = convertToNumbers(parsedNumbers);
        return calculate(numbers);
    }

    private int calculate(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private Parser chooseParser(String input) {
        if (input.startsWith("//")) {
            return new CustomParser();
        } else {
            return new DefaultParser();
        }
    }

    private int[] convertToNumbers(String[] parsedNumbers) {
        int[] numbers = new int[parsedNumbers.length];
        for (int i = 0; i < parsedNumbers.length; i++) {
            numbers[i] = Integer.parseInt(parsedNumbers[i]);
        }
        return numbers;
    }
}


interface Parser {
    String[] parse(String input) throws IllegalArgumentException;
}

class ProxyParser implements Parser {
    private final Parser realParser;
    private static final String startLetter = "//";
    private static final String endLetter = "\\n";

    public ProxyParser(Parser realParser) {
        this.realParser = realParser;
    }

    @Override
    public String[] parse(String input) throws IllegalArgumentException {
        // 파싱 전 검증
        validatePreParsingInput(input);

        // 실제 파싱 수행
        String[] parsedNumbers = realParser.parse(input);

        // 파싱 후 검증
        validatePostParsingNumbers(parsedNumbers);

        return parsedNumbers;
    }

    // 파싱 전 검증
    private void validatePreParsingInput(String input) {
        if (input == null || input.isEmpty() || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty.");
        }

        if (input.startsWith(startLetter) && !(input.contains(endLetter))) {
            throw new IllegalArgumentException("Invalid custom format.");
        }

        if (input.startsWith(startLetter)) {
            String customDelimiterPart = input.substring(2, input.indexOf(endLetter));

            if (customDelimiterPart.isEmpty() || customDelimiterPart.trim().isEmpty()) {
                throw new IllegalArgumentException("Custom delimiter cannot be empty or whitespace.");
            }

            if (customDelimiterPart.length() > 1) {
                throw new IllegalArgumentException("Custom delimiter must be a single character.");
            }
        }

        if (input.contains(endLetter) && !input.startsWith(startLetter)) {
            throw new IllegalArgumentException("Invalid format: Custom delimiter must be defined at the start of the string.");
        }
    }

    // 파싱 후 검증
    private void validatePostParsingNumbers(String[] numbers) {
        for (String number : numbers) {
            if (!number.isEmpty()) {
                try {
                    int parsedNumber = Integer.parseInt(number);
                    if (parsedNumber < 0) {
                        throw new IllegalArgumentException("Negative number is not allowed: " + parsedNumber);
                    }
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid number format: " + number);
                }
            }
        }
    }
}

class DefaultParser implements Parser {

    @Override
    public String[] parse(String input) {
        return input.split(",|:");
    }
}

class CustomParser implements Parser {
    private static final String endLetter = "\\n";

    @Override
    public String[] parse(String input) {
        String delimiter = input.substring(2, input.indexOf(endLetter));
        String numbersPart = input.substring(input.indexOf(endLetter) + (endLetter.length()));
        return numbersPart.split(delimiter);
    }

}


class Input {
    private static final String INPUT_INSTRUCTION = "덧셈할 문자열을 입력해 주세요.";

    public static String read() {
        System.out.println(INPUT_INSTRUCTION);
        return Console.readLine();
    }
}

class Output {
    private static final String OUTPUT_FORMAT = "결과 : ";

    public static void handleResult(int result) {
        if (result < 0) return;
        System.out.println(OUTPUT_FORMAT + result);
    }
}
