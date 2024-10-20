package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Application {


    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        try{
            String inputStr= Console.readLine();

            Method method= new Method();

            String[] splitStr;

            if(inputStr.startsWith("//")){
                inputStr=method.changeString(inputStr);
            }

            splitStr=method.changeToArray(inputStr);

            int answer =0;
            try{
                answer= Arrays.stream(splitStr)
                        .mapToInt(Integer::parseInt)
                        .sum();
            } catch (NumberFormatException e) {
                System.out.println("잘못된 숫자 형식이 포함되어 있습니다.");
            }

            System.out.println("결과 : "+answer);
        }catch(NoSuchElementException e){
            System.out.println("결과 : 0");
            return;
        }
    }

}
