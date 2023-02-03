package java8.C;

import java.util.function.Consumer;

public class FunctionalInterfaceExamples {
    public static void main(String[] args) {

        // z----컨슈머 예제 여기서 사용!!
        // -> 1. 익명 클래스 사용하기
        final Consumer<String> print = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        // -> 사용하기
        print.accept("hello");

        // 2. 람다 표현식
        final Consumer<String> print2 = value -> System.out.println(value);
        print2.accept("hi");

        // 이것을 Function으로 해도되지 않니?? 근데 Function은 return값을 가지고 있어야하므로 <String, Void>로 할 수 없음

        // 약간 이럴 때 쓴다.
        final Consumer<String> greeting = name -> System.out.println("Hello! " + name);
        greeting.accept("minju");
    }
}
