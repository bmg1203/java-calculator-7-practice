package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
    // TODO: 프로그램 구현

    // 문자열 입력 받기
    System.out.println("덧셈할 문자열을 입력해 주세요.");
    String inputStr = Console.readLine();

    // 입력한 문자열에서 기본 구분자, 커스텀 구분자 찾아내기
    String customPolymerPattern = "//[^\\w\\s]";
    String basicPolymerList = "[,:]";
    String customPolymer = "";

    Pattern pattern = Pattern.compile(customPolymerPattern);
    Matcher matcher = pattern.matcher(inputStr);

    if(matcher.find() && inputStr.substring(3,5).equals("\\n")){
        customPolymer = inputStr.substring(2,3);
    }

    }
}
