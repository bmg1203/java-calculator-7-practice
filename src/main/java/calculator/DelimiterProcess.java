package calculator;

import java.util.ArrayList;
import java.util.List;

public class DelimiterProcess {
    private List<String> delimitersInit = new ArrayList<>();
    private String userInput;
    private boolean delimStarting;

    //Generator: 기본 구분자 추가
    public DelimiterProcess(String userInput) {
        this.userInput = userInput;
        delimitersInit.add(",");
        delimitersInit.add(":");
    }

    //getDelimiter(): 커스텀 구별자가 없을 때까지 반복 -> 커스텀 구별자를 ArrayList에 넣기
    public List<String> getDelimiters() {
        isNumberStarting();

        while(delimStarting) {
            addDelimiter();
            isNumberStarting();
        }

        replacePattern();

        return delimitersInit;
    }

    //isNumberString(): true일 때 커스텀 구별자가 모두 끝난 것
    private void isNumberStarting(){
        if(userInput.startsWith("//")){
            delimStarting = true;
        } else {
            delimStarting = false;
        }
    }

    //addDelimiter(): 문자열에서 커스텀 구분자를 분리 -> 구분자 리스트에 추가, userInput 잘라서 초기화
    private void addDelimiter(){
        int endDelimIndex = userInput.indexOf("\\n");

        //"\\n"을 찾지 못했을 때 예외 처리
         if (endDelimIndex == -1) {
             throw new IllegalArgumentException("잘못된 구분자 형식입니다. \\n이 누락되었습니다.");
         }

         String customDelimiter = userInput.substring(2, endDelimIndex);
         delimitersInit.add(customDelimiter);
         userInput = userInput.substring(endDelimIndex + 2);
    }


    //getUserInput(): 구분자를 모두 처리한 문자열만을 반환
    public String getUserInput() {
        userInput = userInput.trim();
        if(userInput.isEmpty()) {
            return "0";
        }
        return userInput;
    }

    //replacePatterQ(): 정규식 패턴 문자가 구분자로 입력될 때 backslash 더함
    private void replacePattern() {
        delimitersInit.replaceAll(delim -> {
            String patterns = "\\ ( [ { ^ $ . * + ? | ₩ x X";

            if (patterns.contains(delim)) {
                return "\\" + delim;
            }
            return delim;
        });
    }


}
