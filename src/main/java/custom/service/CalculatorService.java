package custom.service;

public class CalculatorService {
    public int calculate(String input) {
        int empty = validateInput(input);
        if (empty == 1) {
            return 0;
        }
        int[] numbers = extractNumbers(input);
        return addNumbers(numbers);
    }

    private int validateInput(String input) {
        // 유효성 case 1: ""을 입력받은 경우
        if (input.isEmpty()) {
            return 1; // 결과 값은 0으로 출력
        }
        // 유효성 case 2: "//"로 시작하는 경우
        if (input.startsWith("//")) {
            // 최소 길이 체크
            if (input.length() < 5) {
                throw new IllegalArgumentException();
            }
            // 3번 인덱스가 '\'인지, 4번 인덱스가 'n' 인지 확인
            if (input.charAt(3) != '\\' || input.charAt(4) != 'n') {
                throw new IllegalArgumentException();
            }
            // 2번 인덱스 위치에 숫자 또는 '-'가 있는 경우 예외 처리
            if (Character.isDigit(input.charAt(2)) || input.charAt(2) == '-') {
                throw new IllegalArgumentException();
            }
            // 커스텀 구분자 설정만 있는 경우
            if (input.length() == 5) {
                return 1; // 결과 값은 0으로 출력
            }
        } else { // 유효성 case 3: "//"로 시작하지 않는 경우
            for (char c : input.toCharArray()) {
                if (!Character.isDigit(c) && c != ',' && c != ':') { // 유효한 값은 숫자와 기본 구분자
                    throw new IllegalArgumentException();
                }
            }
        }
        return 0;
    }

    private int[] extractNumbers(String input) {
        String[] numberStrings;

        // "//"로 시작하는 경우
        if (input.startsWith("//")) {
            // 커스텀 구분자 추출
            String customDelimiter = String.valueOf(input.charAt(2)); // 인덱스 2의 문자만 추출
            String numbersPart = input.substring(5); // 숫자 부분을 인덱스 5부터 문자열 끝까지 추출

            numberStrings = numbersPart.split("[,:" + customDelimiter + "]+");
        } else { // "//"로 시작하지 않는 경우
            numberStrings = input.split("[,:" + "]+");
        }
        return convertStringToInt(numberStrings);
    }

    private int[] convertStringToInt(String[] numberStrings) {
        int[] tempArray = new int[numberStrings.length]; // 임시 배열
        int count = 0; // 저장한 숫자의 개수

        for (String s : numberStrings) {
            tempArray[count++] = Integer.parseInt(s); // 정수 변환 후 저장
        }

        // 숫자의 개수에 맞는 새로운 배열 생성
        int[] resultArray = new int[count];

        // tempArray 에서 숫자가 저장된 부분만 복사
        for (int i = 0; i < count; i++) {
            if (tempArray[i] == 0) { // 0은 양수가 아니므로
                throw new IllegalArgumentException();
            }
            resultArray[i] = tempArray[i];
        }
        return resultArray;
    }

    private int addNumbers(int[] numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }
}