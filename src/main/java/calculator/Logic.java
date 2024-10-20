package calculator;

import java.util.ArrayList;
import java.util.Arrays;

public class Logic {
    // 구분자 리스트 선언
    private final ArrayList<Character> delimiter = new ArrayList<>(Arrays.asList(',', ':'));

    // 문자열에 커스텀 구분자를 갖고 있는지 확인
    public int hasCustomDelimiter(String str) {
        if (str.startsWith("//")) { // 커스텀 구분자일 경우
            int idx = 1;
            while (++idx < str.length()) { // '\'로 끝나지 않으면 커스텀 구분자로 취긊하고 구분자 리스트에 추가
                if (str.charAt(idx) == '\\') {
                    idx++;
                    break;
                }
                delimiter.add(str.charAt(idx)); // 구분자 리스트에 커스텀 구분자 추가
            }
            if (idx >= str.length() || str.charAt(idx) != 'n') { // 커스텀 구분자 형식에 안맞을 경우 exception
                throw new IllegalArgumentException();
            }
            return idx;
        }
        return -1;
    }

    // 해당 인덱스부터 숫자를 추출
    public int getNum(String str, int idx) {
        int num = 0;

        while (idx < str.length() && Character.isDigit(str.charAt(idx))) {
            num *= 10;
            num += str.charAt(idx) - '0';
            idx++;
        }

        return num;
    }

    // 주어진 문자열 요구사항에 맞게 계산
    public int calculate(String str) {
        int result = 0, i = hasCustomDelimiter(str);

        while (++i < str.length()) {
            char c = str.charAt(i);

            if (Character.isDigit(c)) { // 숫자일 경우 추출해서 result에 더함
                result += getNum(str, i);
            } else if (delimiter.contains(c)) { // 구분자일 경우 continue
                continue;
            } else { // 다른 문자일 경우 exception
                throw new IllegalArgumentException();
            }
        }

        return result;
    }
}
