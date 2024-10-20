package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        // TODO: 프로그램 구현
        StringBuilder separator = new StringBuilder();    //입력받은 문자열에 커스텀 구분자가 있는지
        String[] result;    //문자열 배열 선언
        int total = 0;    //후에 총 합 값 출력을 위한 저장 변수 선언

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = Console.readLine();    //주어진 Console API를 통해 문자열 입력받음

        //커스텀 구분자에 대한 처리
        if(userInput.startsWith("//")) {
            int idx = userInput.indexOf("\\n");   //커스텀 구분자 확인을 위해

            if (idx == -1) {
                //커스텀 구분자 형식이 잘못 된 경우
                throw new IllegalArgumentException();
            }else{
                //커스텀 구분자, 기본 구분자에 대한 처리
                separator.append(userInput.substring(2, idx));  //커스텀 구분자 추출하는 코드

                //그 후 원본 문자열에서 앞선 커스텀 구분자 관련 글 처리
                userInput = userInput.substring(idx + 2);
                result = userInput.split(",|;|" + separator);
                for (String num : result) {
                    total += parseStringToInt(num);
                }
            }
        }else if(userInput.length() == 0){
            //공백인 경우
            total = 0;

        }else if(userInput.startsWith("0")){
            //양수에 대해서만 처리하므로 0은 잘못된 형식의 값
            throw new IllegalArgumentException();
        }
        else if(!Character.isDigit(userInput.charAt(0))){
            //문자열이 숫자로 시작하지 않는 경우(잘못된 입력)
            throw new IllegalArgumentException();

        } else{
            //기본 구분자 사용
            result = userInput.split(",|:");
            for (String num : result) {
                total += parseStringToInt(num);
            }
        }
        System.out.println("결과 : " + total);

        Console.close();
        return;
    }

    //문자열 형태의 수를 int로 반환하는 함수
    private static int parseStringToInt(String val){
        if(val.isEmpty()){
            //::와 같은 경우 "" 공백이 나눠지게 되는데 이는 조건에 따라 0의 값을 갖음
            return 0;
        }
        try {
            int resultNum = Integer.parseInt(val);
            //입력값이 양수인 경우 정상 반환
            if(resultNum > 0){
                return resultNum;
            }else{
                //입력값이 양수가 아닌 경우 잘못된 형식으로 예외 처리
                throw new IllegalArgumentException();
            }
        }catch (NumberFormatException e){
            //parseInt함수의 경우 형식이 안 맞으면 NumberFormatException을 발생시키는데
            throw new IllegalArgumentException(e);  //이를 IllegalArgumentException으로 반환하여 처리
        }
    }
}
