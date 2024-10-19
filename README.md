프리코스 1주차 미션 - 문자열계산기
---

````
작업전 주의 사항
1.java -version 21
2. Java Style Guide를 원칙작성
3.System.exit() 호출 금지
4.제공된 라이브러리 외 외부 라이브러리 사용 금지
````

---

# 기능 구현 완료 목록

- 문자열이 없거나 ""인 경우 숫자 반환 구현 (구현 완료)
- 문자열 ""안에 ( , )로 나뉜 경우
- ( , or : )가 혼용 되어 있는 경우

---

## 완성 예시

````
예: ""= 0 , "1,2" = 3 , "1,2:3" = 6
    //와 \n 사이에 위치하는 문자 = 커스텀문자
커스텀 문자 예시 : "//;\n;1;2;3" = 6
````

---

## 목표 기능 목록

- ~~문자열 ""안에 ( : )로 나뉜 경우~~
- 커스텀 구분자 //(문자)\\n(문자)...)인 경우
- 사용자 입력 값 출력 값
- 잘못된 값을 넣었을때 프로그래밍 종료
