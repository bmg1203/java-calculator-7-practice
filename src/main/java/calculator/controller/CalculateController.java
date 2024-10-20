package calculator.controller;

import calculator.model.PositiveNumbers;
import calculator.service.CalculateService;

//사용자의 Input 과 Output 을 담당하며, calculate service 를 이용할 수 있는 클래스
public class CalculateController {

    private final CalculateService calculateService = new CalculateService(new PositiveNumbers());

    // userInput 을 받아 caculateService 에 넘김.
    public long insertUserInput(final String userInput) {

        return calculateService.calculate(userInput);

    }
}
