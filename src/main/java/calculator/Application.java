package calculator;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();  // Input 객체 생성
        String userInput = input.getUserInput();  // 사용자 입력 받기
        input.closeScanner();  // 스캐너 닫기

        //Select select = new Select(userInput);
    }
}
