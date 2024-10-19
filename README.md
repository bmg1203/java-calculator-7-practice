# First_Week Problem : 문자열 덧셈 계산기
***
## 클래스
- Calculator 덧셈 관련 모든 기능이 있는 Class

## 변수
- private No_Space_Input : 공백 제거된 Input 문자열 저장
- private List<String> Delimiter : 구분자 관리 리스트, 커스텀 구분자 추가 시 해당 리스트에 추가됨
- private String del_deli_input : Input 문자열에서 커스텀 구분자 추가 구문 제외한 문자열 저장 
- private List<String> parts : del_deli_input 문자열을 구분자로 구분한 문자열 리스트

## 기능 구현
- Calculator() 생성자 : Input된 문자열 공백 제거, 음수값 포함된 경우 예외처리, 숫자가 없는경우 "결과 : 0" 출력 처리
- Custom_Deli() : 기본 구문자 및 Custom 구분자 추가 후 Custom 구분자 추가 구문 삭제 
- print() : 진행된 상황 출력
- split_input() : del_deli_input 문자열 구분자로 구분하기
  - escapeDelimiters() : Delimiter 구분자 리스트에 특수 기호(+,*)등의 기호가 있는 경우 일반 문자로 변환 처리
- double_check() : .의 위치와 개수로 실수인지 아닌지 확인

## 고려 사항
- Input에 공백이 있는 경우 구분하기 애매하다고 판단(=공백 제거)
- 문자열 입력이 없는 경우와 숫자가 없는 경우 출력 구현(결과 : 0)
- 문자열에서 커스텀 구분자 추가한 경우 해당 구문은 Input 문장열에서 삭제
  - ex) //#\n382인 경우 : 커스텀 구분자 # 추가 후 382로 input 문자열 변경
- 구분자로 구분 할 때 숫자가 아닌경우 예외처리
  - ex) 문자 또는 구분자가 아닌 특수문자가 포함된 경우 예외 처리 
- 구분자에 특수 기호들어간 경우
  - ex) + , *, /의 특수 기호는 프로그래밍에서 의미가 있는 기호 일반 문자로 취급되게 해줘야 함
- 구분했을 때 숫자가 실수인 경우도 고려
- 음수값이 들어온 경우 예외 처리

## 진행 사항
- ~~Calculator의 생성자의 private 변수까지 전달 잘 되는지 확인~~
- ~~커스텀 구분자 구분 문자열이 있을 때 구분 문자 리스트에 추가 되는지 확인~~
- ~~커스텀 구분자 구분 문자열이 기존에 입력된 문자열에서 삭제가 되고 del_deli_input에 저장되는지~~
- ~~구분자 리스트에 있는 구분자로 구분이 잘 되는지 확인~~
- ~~중간에 커스텀 구분자가 있을 때도 구분자 리스트에 추가해서 구분이 되는지 확인~~ 
- ~~커스텀 구분자가 특수 기호인 경우 구분자로 적용이 되는지 확인~~
- ~~구분자로 구분했을 때 문자인 경우 예외처리가 되는지 확인~~
- ~~구분된 숫자중에 실수가 있는경우 .의 위치 및 개수로 실수인지 판단되는지 확인~~
- 입력문자열에 음수가 있는지 확인