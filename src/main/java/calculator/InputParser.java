package calculator;

import java.math.BigInteger;

public class InputParser {
    private final String inputText;
    private String separator;
    private String[] numbers;

    public InputParser(String inputText) {
        this.inputText = inputText.trim();  // 공백 제거
        parseInput();
    }

    private void parseInput() {
        if (inputText.isEmpty()) {
            this.numbers = new String[]{"0"};
            return;
        }
        if (isCustomSeparator(inputText)) {
            this.separator = inputText.substring(2, 3);
            if (this.separator.equals("\\")) {
                this.separator = "\\\\";
            }
            this.separator = "[,|:|" + this.separator + "]";  // 커스텀 구분자 외에 기본 구분자도 허용
            this.numbers = inputText.substring(5).trim().split(separator);
        } else if (isDefaultSeparator(inputText)) {
            this.separator = "[,:]";
            this.numbers = inputText.split(separator);
        } else {
            if (isNumeric(inputText)) {
                this.numbers = new String[]{inputText};
            } else {
                System.out.println("입력 오류: 올바른 구분자를 입력해주세요");
                throw new IllegalArgumentException();
            }
        }
    }

    private static boolean isCustomSeparator(String inputText) {
        if (inputText.startsWith("//")) {
            try {
                // "//문자\n" 형태라면 올바른 입력
                if (inputText.startsWith("\\n", 3)) {
                    return true;
                }
                // 에러 식별
                if (inputText.contains("\\n")) {
                    System.out.println("입력 오류: 커스텀 구분자가 없거나 두 글자 이상입니다.");
                } else {
                    System.out.println("입력 오류: 올바른 커스텀 구분자 양식이 아닙니다.");
                }
                throw new IllegalArgumentException();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("입력 오류: 커스텀 구분자 양식을 확인해주세요");
                throw new IllegalArgumentException();
            }
        }
        return false;
    }

    private static boolean isDefaultSeparator(String inputText) {
        return inputText.contains(",") || inputText.contains(":");
    }

    private static boolean isNumeric(String inputText) {
        try {
            new BigInteger(inputText);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String getSeparator() {
        return separator;
    }

    public String[] getNumbers() {
        return numbers;
    }
}
