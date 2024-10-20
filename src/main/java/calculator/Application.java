package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.\n");
        String numInput = Console.readLine();

        // 커스텀 구분자 처리
        String[] numbers;

        if (numInput.startsWith("//")) {
            // 문자열에 "\n"이 있는지 체크
            try {
                if (!numInput.contains("\\n")) {
                    throw new IllegalArgumentException("커스텀 구분자 지정을 위해 \\n를 입력해주세요.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }

            // 커스텀 구분자와 문자열 분리
            String[] parts = numInput.replace("\\n","\n").split("\n", 2); // 첫 번째 줄에서 분리
            String customDelimiter = parts[0].substring(2); // 커스텀 구분자 추출

           try {
                // parts[1]가 \n을 포함하고 있는지 체크
                if (parts[1].contains("\n")) {
                    throw new IllegalArgumentException("\\n는 커스텀 구분자로 지정할 수 없습니다.");
                }
                // 커스텀 구분자를 입력하지 않음
                if(customDelimiter.isEmpty()){
                    throw new IllegalArgumentException("커스텀 구분자를 입력하세요.");
                }
                // 숫자와 공백은 커스텀 구분자로 사용할 수 없음
                if (customDelimiter.equals(" ") || Character.isDigit(customDelimiter.charAt(0))) {
                    throw new IllegalArgumentException("숫자와 공백은 커스텀 구분자로 사용할 수 없습니다.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
            // 기본 구분자와 커스텀 구분자 결합 (특수문자는 Pattern.quote()로 처리)
            String delimiterPattern = "[,:]|" + Pattern.quote(customDelimiter); // "|"로 구분자 패턴 추가
            numbers = parts[1].split(delimiterPattern, -1);
        } else {
            // 기본 구분자 ',' ':'로 문자열 분리
            numbers = numInput.split("[,:]", -1);
        }

        int sum = 0; // 덧셈 결과 저장할 변수
        // 숫자가 유효한지 확인하기 위한 정규 표현식
        String numberPattern = "-?\\d+"; // 음수 포함 숫자 패턴

        for (String number : numbers) {
            number = number.trim(); // 숫자 앞 뒤 공백 제거

            if (number.isEmpty()) { // 빈 문자열 체크
                continue;
            }
            try {
                if(!number.matches(numberPattern)){
                    throw new IllegalArgumentException("기본 구분자(',' ':')와 숫자를 제외한 문자를 입력하였습니다.");
                }

                int num = Integer.parseInt(number); // 문자열을 정수로 변환
                if (num < 0) {
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
                }

                sum += num; // 덧셈
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                throw e;
            }
        }
        System.out.println("결과 : " + sum);
    }
}
