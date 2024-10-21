# java-calculator-precourse

## 기능 목록

### 1. 입력값의 정상 여부 판단하기
    - // 와 \n 가 존재하는 경우
        - 커스텀 구분자를 추출하고 \n 뒤에 나오는 문자열이  (숫자 + 커스텀구분자) 로만 구성되었는지 확인
    - 그 외
        - 기본 구분자(',', ':') 를 이용하므로 입력값이 (숫자 + ',' + ':') 로만 구성되었는지 판단

### 2. 정상 입력값에 대해 구분자와 계산할 숫자 분리하기
    - 커스텀 구분자인 경우
        - 입력값에서 \n 이후 문자열에 대해 커스텀 구분자를 이용해 split
    - 그렇지 않은 경우
        - 기본 구분자(',', ':') 를 통해 입력값 자체를 split

### 3. 숫자 합산하기
    - 2번 과정의 결과물인 숫자 배열의 각 요소를 합산