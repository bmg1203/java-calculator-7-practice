package calculator;

import camp.nextstep.edu.missionutils.*;

public class Application {
    public static String userInput;
    public static String[] numbers;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application app = new Application();
        app.run();
    }

    public void run() {
        System.out.println(Message.START.getMessage());
        getUserInput();
        extractNumber();
    }

    /**
     * 사용자가 콘솔에 입력한 값을 저장하는 함수
     */
    public void getUserInput() {
        String input = Console.readLine();
        userInput = input.replace("\\n", "\n");
    }

    /**
     * 구분자를 기준으로 숫자 추출하여 배열에 저장하는 함수
     */
    public void extractNumber(){
        // 커스텀 구분자를 지정한 경우
        if(userInput.matches("//[\\D]+(\r?\n)[\\s\\S]+")){
            String separator ="";
            int idx = 2;
            while(true){
                separator += userInput.charAt(idx++);
                if(userInput.charAt(idx) == '\n') break;
            }
            numbers = userInput.substring(idx+1).split(separator);
        }
        // 커스텀 구분자를 지정하지 않은 경우 - 기본 구분자: 쉼표(,), 콜론(:)
        else{
            numbers = userInput.split(",|:");
        }
    }
}