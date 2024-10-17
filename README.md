# ✨ 문자열 덧셈 계산기

- 입력된 문자열에서 숫자를 추출하여 덧셈을 수행하는 계산기를 구현한다.
- 쉼표( `,` ) 또는 콜론( `:` )을 구분자로 사용하여 숫자를 분리한다.
- 커스텀 구분자를 지원한다. 커스텀 구분자는 `"//"` 와 `"\n"` 사이에 위치하는 문자를 사용한다.
- 잘못된 입력이 주어질 경우, `IllegalArgumentException`을 발생시키고 프로그램을 종료한다.

# ✅ 구현할 기능 목록

### 사용자 입력 처리

- [x] 사용자 입력을 받는다.
- [x] 빈 문자열 또는 `null`이 입력되었을 때 `0`을 반환한다.

### 기본 구분자를 통한 숫자 분리 및 덧셈 기능

- [ ] 문자열을 쉼표( `,` ) 또는 콜론( `:` )을 기준으로 분리한다.
- [ ] 분리된 문자열을 숫자로 변환하고 그 합을 계산한다.

### 커스텀 구분자 지원

- [ ] 문자열의 앞부분에 `"//"`와 `"\n"` 사이에 위치한 커스텀 구분자를 인식한다.
- [ ] 커스텀 구분자로 숫자를 분리하고 합을 계산한다.

### 입력 값 예외 처리

- [ ] 숫자가 아닌 값이 포함된 경우 `IllegalArgumentException`을 발생시킨다.
- [ ] 음수가 포함된 경우 `IllegalArgumentException`을 발생시킨다.
- [ ] 예외 발생 시 프로그램을 종료한다.

### 덧셈 결과 출력 기능

- [ ] 분리된 숫자의 합을 출력한다.
