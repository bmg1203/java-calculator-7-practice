package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Calculator {
    static String separator = ",|:";

    // 시작 함수
    public void start(){
        // 문자열 입력
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();

        String[] separateArray = str.split(separator);
    }
}
