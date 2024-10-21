# java-calculator-precourse

## 기능 목록
- [x] 문자 입력
- [x] 커스텀 구분자 지정
- [x] 문자열 분리하여 덧셈 할 수로 인식
- [x] 덧셈 결과 출력
- [x] 잘못된 입력 시 `IllegalArgumentException` 예외 발생

## 정리
##### 새로 배운 것
여러 문자들 중 아무거나 하나를 구분자로 하여 문자를 split할 때는 regex기능을 사용하면 간편하게 해결할 수 있었습니다.<br>`String.join("|", sep)`와 같이 문자열을 나열하는데, 맨 앞에 |를 넣어주면 regex 문법으로 나눌 수 있었습니다.
##### 많은 시간을 투자한 부분
`\n`을 기준으로 커스텀 구분자의 입력받기를 완료할 때, \n의 인덱스를 구해서 해결하려고 하니 계속 -1번째 즉 문자열에 없는 문자라고 오류가 발생했습니다.<br>온전히 \n 문자의 인덱스를 구하기 위해선 \n가 아닌 `\\n`의 위치를 구해야 했었는데 이를 알기까지 많은 시간을 소요했습니다.