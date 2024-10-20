package calculator;


public class InputValidation { // 입력의 유효성을 확인하는 클래스이다.

    //커스텀 구분자의 유효성에 대해 확인하는 메서드이다.
    public static String[] CheckCustomDelimiter(String input) {
        String[] checkResult = new String[2];

        //커스텀 구분자가 존재한다면 유효성 검사와 함께 추출을 시도한다.
        if (input.contains("//") && input.contains("\\n")) {
            int start = input.indexOf("//");
            int end = input.indexOf("\\n");
            if (start != 0 || start > end || end - start > 3) {
                throw new IllegalArgumentException();
            }
            String customDelimiter = input.substring(start + 2, end);
            if (customDelimiter.isEmpty()) {
                throw new IllegalArgumentException(); // 빈 구분자 예외 처리
            }
            checkResult[0] = customDelimiter; // 커스텀 구분자
            checkResult[1] = input.substring(end + 2); // 커스텀구분자와 지정문자 이후의 input으로 업데이트한다.
            return checkResult;
        }
        return null;
    }

    //Input 자체의 유효성을 확인하는 메서드이다.
    public static String CheckInput(String input, String customDelimiter) {
        if (input.isEmpty()) {
            return null;
        }

        String delimiter = "[,:";  // 기본 구분자 처리
        if (customDelimiter != null && !customDelimiter.isBlank()) {
            delimiter += customDelimiter; // 커스텀 구분자가 존재했으면 이를 포함하여 검사한다.
        }
        delimiter += "]";

        String[] tokens = input.split(delimiter); // 구분자를 바탕으로 문자열을 분류한다.
        for (String token : tokens) {

            CheckNumber(token);
        }

        return delimiter;
    }

    //입력된 값이 숫자인지 그 유효성을 확인하는 메서드이다.
    public static void CheckNumber(String token) {
        try {
            int number = Integer.parseInt(token); // 입력이 숫자가 아니라면 예외를 터뜨린다.
            if (number < 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
