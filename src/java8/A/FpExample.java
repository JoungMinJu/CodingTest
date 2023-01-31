package java8.A;

public class FpExample {
    public static void main(String[] args) {
        // FP는 왕 짧아졌구만
        final FpCalculatorService calculatorService = new FpCalculatorService();
        int add = calculatorService.calculate(new Addition(), 11,1);
        System.out.println(add);
        int sub = calculatorService.calculate(new Subtraction(), 11, 1);
        System.out.println(sub);

        // 람다 표현식도 가능
        System.out.println(calculatorService.calculate((i1, i2) -> i1 + i2, 11, 4));
        System.out.println(calculatorService.calculate((i1, i2) -> 2*i1 + i2,11,4));

        // 자주쓰는 계산법이면
        final Calculation addition = (i1, i2) -> i1 + i2; // 처럼 계산식 저장해놓고
        System.out.println(calculatorService.calculate(addition, 11,4));
        // 해도됨.
    }
}

class FpCalculatorService {
    // 메소드에서 Calculation 받음
    public int calculate(Calculation calculation, int num1, int num2){
         if (num1 > 10 && num2 < num1)
             return calculation.calculate(num1, num2);
         else
             throw new IllegalArgumentException("Invalid input num1 : " + num1 + " num2 : " + num2);
    }
}

/*
[ First Class Citizen 조건 ]
Element elm은 아래의 조건을 달성하면 First Class Citizen이다.
1. 메소드의 파라미터로 넘길 수 있다.
2. 메소드의 결과값으로 return될 수 있다.
3. List와 같은 데이터 구조체에 원소로서 포함될 수 있다.

자바의 First Class Citizen = Java의 Object
-> 자바의 function에 해당하는 메소드는?
-> 1번도 안됨. 2번도 안되지. 3번도 안된다.

First Class Function이 지원되는 언어가 아닌 Java였는데
Java8 이후부터 First class Function이 지원된다.
 */