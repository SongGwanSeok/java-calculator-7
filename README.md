# java-calculator-precourse

# 구현할 기능 목록

- [X] 입력을 담당하는 객체
    - 단순히 입력에 필요한 문자열 출력
    - 문자열을 입력을 받는다.

- [X] 출력을 담당하는 객체
    - 결과를 형식에 맞게 출력한다.

- [X] 입출력과 모델 사이의 흐름을 담당하는 객체
    - 입력받은 값을 모델에게 위임한다.
    - 모델에게 받은 결과를 출력에게 위임한다.
    - 전체적인 프로그램의 흐름을 담당한다.

- [X] 계산기 객체
    - 전체적인 계산 과정을 수행하는 역할

- [X] 커스텀 구분자를 추출하는 객체
    - 입력 받은 문자열에서 "//"과 "\n" 사이의 문자를 가져온다.
    - "//"과 "\n"이 없거나 하나만 있는 경우 -> 예외
    - "//"과 "\n" 사이에 빈 문자열이 들어오는 경우 -> 예외
    - 커스텀 구분자로 숫자를 사용할 수 있나? -> (특수 문자, 알파벳, 숫자?)
    - 커스텀 구분자에 빈 문자가 들어오는 경우 -> 기본 구분자만 사용

- [X] 구분자를 가지고 문자열을 분할하는 객체
    - 문자열을 구분자로 분할해 문자열 리스트로 만들어준다.
    - 아무 숫자도 입력되지 않은 경우 -> 예외 or 0 or 재시도

- [X] 분할 된 숫자들을 가지는 객체
    - 분할된 문자열을 분할된 숫자로 모두 변환해 가진다.
    - 숫자의 덧셈 결과를 반환한다.
    - 더한 숫자의 범위가 int를 넘어가는 경우 -> 예외? long으로 구현해야하나?

- [X] 숫자를 가지는 객체
    - 문자열을 숫자로 변환해 가진다.
    - 문자열이 숫자가 아닌 경우 -> 예외
    - 0이 들어오는 경우 -> 예외
    - int 범위를 넘어가는 경우 -> 예외
        - Integer.parse()에서 IllegalArgumentException을 상속 받은 NumberFormatException을 반환
    - 변환된 숫자를 반환한다.
