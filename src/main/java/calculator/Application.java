package calculator;
import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
        // 문자열 입력
        System.out.print("덧셈할 문자열을 입력해 주세요.");
        String FullLine = Console.readLine();
        // 커스텀 구분자 및 기본 구분자로 문자열 분리
        String[] SplitWord = MakeSplitWordList(FullLine);
    }
    public static String[] MakeSplitWordList(String FullLine) {
        if (FullLine.startsWith("//")) {
            int EndIndex = FullLine.indexOf("\n");
            String CustomSplitWord = FullLine.substring(2, EndIndex);
            String RemainLine = FullLine.substring(EndIndex+1);
            return RemainLine.split("[,|:]" + CustomSplitWord);
        } else {
            return FullLine.split("[,|:]");
        }
    }
}