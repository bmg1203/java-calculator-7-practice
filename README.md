# java-calculator-precourse

## 계산기 기능 요구사항 정리

> 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다. 

**[1] main 에서 문자열 입력 받기**
  - camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다. 

**[2] 구분자 parsing** : private void parseSeparator(String input)
  - 구분자를 파싱한 결과를 ArrayList의 seprators에 저장한다.
  - defalut 구분자는 쉼표(,)와 콜론(:)이다. 
  - //, \n 사이에 존재하는 문자(size 1)을 구분자로 인정한다. 
  - 추가 구분자는 존재 할 수 있고 존재 하지 않을 수 있다.

**[3] 숫자 parsing** : public void parseNums(String input)
  - 숫자를 파싱한 결과를 ArrayList의 nums에 저장
  - 구분자가 연속되는 경우 0으로 취급한다.

**[4] 계산 값 반환**  : public static int calculateSum(ArrayList<Integer> nums)

  - 파싱된 숫자를 모두 합하여 반환한다. 

**[5] 예외 처리** 

  - 정의되지 않은 구분자가 문자열에 포함된 경우
  - String이 메모리 할당에 실패하는 경우 



 



