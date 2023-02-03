여기서는 Functional Interface를 설명해요!

함수형 interface
-> interface인데 abstract method가 하나만 존재하는 경우!

이게 왜 중요하냐면, 함수형 인터페이스 가지고 있으면, 이거 사용하는 코드는 람다 expression으로 대체할 수 있어서 좋다
람다 expression의 타입이 함수형 인터페이스!

Function 인터페이스 -> apply(T t)라는 메소드 있음.
*다른 타입 input -> 다른 타입 output
* 이것을 Mapper라고 한다. 따라서 위는 Mapper에 해당하는 fucntion

(+) 같은 타입 input -> 같은 타입 input
= identity function
= 이 타입을 받아서 기냥 !!!! 바로 return하면 identity function임.




