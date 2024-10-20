# java-calculator-precourse

---

## 문자열 덧셈 계산기

입력한 문자열에서 숫자를 추출해 더하는 계산기 구현

### 기능 요구 사항

1. `camp.nextstep.edu.missionutils`의 `readLine()`을 통해 사용자의 입력 받기
2. `쉼표(,)` 또는 `콜론(:)` 구분자 존재 시, 구분자 기준으로 분리한 각 숫자의 합 반환
3. 앞의 기본 구분자 외 `커스텀 구분자` 지정 가능, 커스텀 구분자는 문자열 앞부분의 `"//"`와 `"/n"` 사이에 위치하는 문자 사용
4. 사용자가 잘못된 값(`양수`, `구분자` 이외) 입력 시, `IllegalArgumentException` 발생시킨 후 애플리케이션 종료

### To-Do

- [X] 사용자의 입력 받기
- [ ] (사용자가 잘못된 값 입력 시,) `IllegalArgumentException` 발생
- [X] 기본 구분자 로직 구현
- [X] 커스텀 구분자 로직 구현
- [ ] 구분자 및 커스텀 구분자 기준 분리 후 더하기
- [X] `null`이나 `공백`을 입력 받았을 시, 0 반환
- [X] `음수` 입력 받았을 시, `IllegalArgumentException` 발생
- [X] 숫자의 합 계산 및 결과 반환
- [ ] 애플리케이션 종료