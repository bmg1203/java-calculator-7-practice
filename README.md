# java-calculator-precourse

<h2>구현 기능</h2>

- [x] **1. 구분자 처리**
- **구분자 배열 초기화**
    - 기본 구분자로 쉼표(,)와 콜론(:) 설정
- **커스텀 구분자 확인**
    - //와 \n 사이에 구분자가 있으면 해당 구분자를 구분자 배열에 추가
    - 쉼표(,)와 콜론(:)으로 커스텀 구분자가 여러 개 구분된다면, 각 커스텀 구분자를 구분자 배열에 추가

</br>

- [ ] **2. 숫자 처리**
- **문자열에서 숫자 분리**
    - 구분자를 이용하여 숫자 추출 후 숫자 배열에 추가

</br>

- [ ] **3. 덧셈 및 출력**
- 유효한 숫자들의 합을 구한 뒤, `결과 : [숫자 합]`의 형태로 출력

</br>

- [ ] **4. 잘못된 값을 입력할 경우 예외 처리**
- 구분자가 아닌 값을 구분자로 사용할 경우
- 잘못된 구분자 형식일 경우 (//[구분자]\n가 아닐 경우)
- 숫자 + 구분자 + 숫자 형식이 아닐 경우
- 커스텀 구분자의 위치가 가장 앞이 아닐 경우
- 숫자가 없을 경우