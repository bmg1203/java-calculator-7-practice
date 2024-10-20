### precourse week 1

# java-calculator

## 구현 기능 목록

### 계산기 실행

- [x] 계산기 시작 문구 출력
- [x] 사용자 입력 받기
- [ ] 입력 구분자 및 숫자 추출하여 덧셈 수행
    - [x] 커스텀 구분자 존재 유무 및 존재한다면 종류 확인
    - [x] 구분자 기준으로 숫자 추출
        - [x] 구분자 사이에 문자가 존재하지 않는다면 0이 존재하는 것으로 간주
    - [x] 추출된 숫자들의 덧셈 수행

### 계산기 종료

- [x] 덧셈 결과 출력

## 예외 처리 목록

### 사용자 입력

- [x] 0이 포함된 경우 (음수인 경우 아래 조건에서 처리)
- [x] 구분자(`,`, `:`, 커스텀 구분자) 및 숫자를 제외한 문자가 포함된 경우
- [ ] 커스텀 구분자 설정 양식(`//\n`) 입력이 올바르지 않은 경우
- [ ] 커스텀 구분자 설정 양식 내에 입력 문자가 없는 경우