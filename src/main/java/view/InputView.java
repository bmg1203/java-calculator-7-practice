package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private String buff;

    public String readbuffer(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        buff = Console.readLine();
        return buff;
    }
}
