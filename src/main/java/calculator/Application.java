package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    // 커스텀 구분자 관련해서 여러 번 사용하기 때문에 필드값을 지정
    private static final String CUSTOM_SEPARATOR = "//(.)\\\\n(.*)";

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        // 덧셈할 문자열 입력
        String input = Console.readLine();

        // 기본 구분자로 초기화
        String separator = ",|:";

        // 아무것도 입력하지 않으면 결과는 0으로 출력
        if (input.isEmpty()) {
            System.out.println("결과: 0");
            return;
        }

        try {
            if (existCustomSeparator(input)) {
                // 커스텀 구분자가 존재한다면 구분자를 추출해서 separator 변수에 저장
                separator = findCustomSeparator(input);

                // 커스텀 구분자 생성하는 부분 자르고 문자열 가져오기
                String cutString = input.substring(input.lastIndexOf("n") + 1);

                // 구분자를 이용해 문자열 분리
                String[] cutStringArr = cutString.split(separator);

                // 문자열배열에 있는 문자열을 검증하는 함수 호출
                validateInput(cutStringArr);

                // 계산
                addCalc(cutStringArr);

            } else {
                // 숫자만 입력했을 때 사용자 입력 검증(테스트 중)
                if (false) {
                    validateInput(input);

                    // 커스텀 구분자가 존재하지 않으면 결과를 출력
                    System.out.println("결과 : " + Integer.parseInt(input));
                } else {
                    // 커스텀 구분자가 아닌 기본 구분자를 사용했을 때

                    // 구분자를 이용해 문자열 분리
                    String[] cutStringArr = input.split(separator);

                    // 문자열 배열에 있는 문자열을 검증하는 함수 호출
                    validateInput(cutStringArr);
                    
                    // 계산
                    addCalc(cutStringArr);
                }
            }
        } catch (IllegalArgumentException e) {

            // 검증 실패하면 에러 메시지 출력
            System.err.println(e.getMessage());
        }

    }

    // 숫자만 입력했을 때 사용자 입력을 검증하는 함수
    private static void validateInput(String input) {
        // 0보다 큰지 확인. 그리고 숫자 형식인지 확인
        if (!input.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }

    // 구분자가 사용할 때 사용자 입력을 검증하는 함수
    private static void validateInput(String[] inputArr) {
        for (String str : inputArr) {
            // 0보다 큰지 확인. 그리고 숫자 형식인지 확인
            if (!str.matches("^[1-9]\\d*$")) {
                throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
            }
        }
    }

    // 커스텀 구분자가 존재하는지 검증하는 함수
    private static boolean existCustomSeparator(String input) {
        return input.matches(CUSTOM_SEPARATOR);
    }

    // 커스텀 구분자를 찾는 함수
    private static String findCustomSeparator(String input) {

        // 정규 표현식을 컴파일하고, 입력 문자열에 대해 매처를 생성
        Matcher m = Pattern.compile(CUSTOM_SEPARATOR).matcher(input);

        // 입력 문자열에서 패턴과 일치하는 부분이 있는지 확인
        if (m.find()) {
            // 일치하는 부분이 있으면 일치하는 그룹 중 첫 번째 그룹의 값을 반환
            return m.group(1);
        } else {
            return null;
        }
    }

    // 문자열을 덧셈하는 함수
    private static void addCalc(String[] cutStringArr) {
        int result = 0;

        for (String str : cutStringArr) {
            result += Integer.parseInt(str);
        }

        System.out.println("결과 : " + result);
    }
}
