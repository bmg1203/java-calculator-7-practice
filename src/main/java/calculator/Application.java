package calculator;
import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class Application {
    public static double add(String str) {
        // 문자열이 비어있거나 null이면 0을 출력
        if (str == null || str.isEmpty()) {
            return 0;
        } else {
            // 기본 구분자를 ",:"d으로 정함
            String separator = ",|:";
            // 커스텀 구분자를 사용하는지 확인
            if (str.startsWith("//")) {
                // 커스텀 구분자가 "//"로 시작하면 구분자 찾기
                separator = CustomSeparator(str)+"|"+separator;
                str = extractNumber(str); // 구분자 이후 숫자 추출
            }
            // 설정된 구분자로 문자열 분리
            String[] numbers = str.split(separator);
            // 숫자 합계 계산
            double result = 0;
            for (String number : numbers) {
                result += validateInput(number);
            }
            return result;
        }
    }
    // 커스텀 구분자 변경 메소드
    private static String CustomSeparator(String str) {
        // "\n" 문자열이 있는지 확인
        int separatorIndex = str.indexOf("\\n");
        if (separatorIndex != -1) {
            // "//"과 "\n" 사이의 커스텀 구분자로 구분자 변경
            return str.substring(2,separatorIndex);
        } else {
            throw new IllegalArgumentException("잘못된 구분자입니다.");
        }
    }

    // 문자열에서 커스텀 구분자 제외한 숫자 추출 메소드
    private static String extractNumber(String str) {
        int separatorIndex = str.indexOf("\\n");
        return str.substring(separatorIndex + 2);
    }

    // 유효한 문자열 입력 검사 메소드
    private static double validateInput(String number) {
        try {
            double num = Double.parseDouble(number);  // 소수까지 처리할 수 있도록 Double 사용
            if (num < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            } else {
                return num;
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private static String formatResult(double result) {
        if (result == (int)result) {
            return String.valueOf((int) result);  // 정수로 캐스팅 후 문자열로 변환
        } else {
            return String.valueOf(result);  // 그대로 소수로 출력
        }
    }

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요. ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double answer = add(input);
        System.out.println("결과 : " + formatResult(answer));
    }
}