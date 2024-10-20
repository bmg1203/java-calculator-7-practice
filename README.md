# java-calculator-precourse

#How to solve?

##1.입력받기
문자열을 입력받아 저장하자

##2. 추가 구분자가 있는지 확인하기
글자수가 4글자 아래면 숫자만 있는것이므로 추가 구분자가 없으니 패스하고
그 문자열의 첫번째 글자와 두번째 글자가 /인지 확인하고 4번째글자가\n인지 확인하자

##3.문자열을 순회하면서 문자열의 숫자를 BigInteger 배열에 파싱한다.(2000자가 넘으면 에러가 뜨게하자 (처리시간이 너무 길어질 수 있음))
문자열을 순회하면서 구분자가 오기전까지 문자열을 순회하며 문자열인 숫자를 저장하다가 구분자가 오거나 배열의 끝에 도달하게 되면 숫자를 빅인티져 형태로 배열에 저장한다.
그외에 다른것이 나오면 에러 처리를 해준다.

##4.BigInteger배열에 있는 BigInter들을 모두 더하는 연산을 진행한다

##5.출력한다.





