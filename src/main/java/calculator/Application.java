package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 입력
        // 문자열 str 입력받음
        System.out.println("덧셈할 문자열을 입력해 주세요.\n");
        String str = Console.readLine();

        // 커스텀 구분자 찾기
        findCustomSpliter splitterFinder = new findCustomSpliter();
        String custom = splitterFinder.customSpliter(str);

        // 잘못된 문자열인지 오류 탐색 or 합 출력
    }
}
