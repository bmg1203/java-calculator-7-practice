# java-calculator-precourse

# Refactor 세부 사항
1. Integer 형으로 반환
2. 양수 덧셈 인지 후 0 보다 크게 설정
3. Integer -> Long 타입으로 변환
4. 부동소수점 로직 추가


# 기능 목록
- 예외사항
- [x] //\n 사이에 아무 값도 없으면 에러
- [x] //1\n 사이에 정수가 있으면 에러
- [x] 커스텀 지정자를 선언하고 정수를 넣지 않을 경우 에러
- [x] -1,2,3 숫자앞에 기호가 있을시 에러 (하지만 이게 구분자면 pass)
- [x] 커스텀 구분자 설정해서 다른 구분자가 있으면 에러
- [x] 문자열 뒷부분에 //와 \n가 있으면 에러
- [x] Long.MAX_VALUE 를 입력 하거나 합이 넘을 경우 에러



# Requirements
1. Default Separator = 쉼표(,), 콜론(:)
2. "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
3. "문자열 앞부분"의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.

``` 
예시
    input = "//;\\n1;2;3" 
    Separator = 세미콜론(;) 
    output = 6
```

4. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 을 발생시킨 후 애플리케이션은 종료되어야 한다

# TEST 작성
1. InputTest
   - [x] 커스텀 구분자 안에 공백이 있을 경우 예외
   - [x] 커스텀 구분자 안에 정수가 있을 경우 예외
   - [x] 커스텀 구분자가 앞에 없을 경우
   - [x] 커스텀 구분자외에 다른 구분자가 있을 경우
   - [x] 커스텀 구분자 양식에 맞지 않을 경우
   - [x] 기본 구분자 외에 다른 구분자가 있을 경우
   - [x] 문자만 있을 경우
   - [x] 정수사이에 구분자가 연속으로 나올경우
   - [x] 문자열끝에서 구분자로 끝났을 경우
   - [x] 숫자가 Long.MAX_VALUE 보다 클경우
   - [x] 0이 있을 경우 part1
   - [x] 0이 있을 경우 part2
   - [x] 공백일 경우
   - [x] 기본 구분자 
   - [x] 커스텀 구분자 문자열 예외 발생
   - [x] 커스텀 구분자 문자
2. SumTest
   - [x] 최댓값 초과및 합 테스트
3. RegexPatternTest
   - [x] 숫자 생성 테스트
4. SeparatorConvertorTest
   - [x] 구분자 추출 로직 테스트
   - [x] 숫자 생성 로직 테스트
5. RegexPatternTest
   - [x] DefaultSeparator
   - [x] DefaultSeparatorDouble
   - [x] CustomSeparator
   - [x] CustomSeparatorDouble
   - [x] Blank


